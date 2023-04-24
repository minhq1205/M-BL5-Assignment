/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CheckWork;
import model.Group;
import model.Manager;
import model.Session;
import model.Worker;

import model.Time;

/**
 *
 * @author sonnt
 */
public class SessionDBContext extends DBContext<Session> {
    
     public ArrayList<Session> getSessions(int lid) {
        String sql = "SELECT ses.sesid,ses.date,ses.status,g.gid,g.gname,c.courseid,c.cname,r.rid,r.rname,t.slotid,t.slotTime \n"
                + "FROM [Session] ses INNER JOIN [Group] g ON ses.gid = g.gid\n"
                + "					INNER JOIN Course c ON c.courseid = g.courseid\n"
                + "					INNER JOIN Room r ON r.rid = ses.rid\n"
                + "					INNER JOIN Time t ON t.slotid = ses.slotid\n"
                + "WHERE ses.lid = ?";
        ArrayList<Session> sessions = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, lid);
            rs = stm.executeQuery();
            while (rs.next()) {
                Session session = new Session();
                session.setDate(rs.getDate("date"));
                session.setPresent(rs.getBoolean("present"));
                session.setId(rs.getInt("seid"));
                
                Group g = new Group();
                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                session.setGroup(g);
                
//                Course c = new Course();
//                c.setId(rs.getString("courseid"));
//                c.setName(rs.getString("cname"));
//                g.setCourse(c);
//                
//                Room r = new Room();
//                r.setId(rs.getInt("rid"));
//                r.setName(rs.getString("rname"));
//                session.setRoom(r);
                
                Time t = new Time();
                t.setId(rs.getInt("slotid"));
                t.setTime(rs.getString("time"));
                session.setTime(t);
                
                sessions.add(session);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(sessions.size());
        return sessions;
    }

    public ArrayList<Session> listSessionsDates(int id) {
        ArrayList<Session> listSessionsDates = new ArrayList<>();
        try {
            String sql = "select seid, [date] from [Session]\n"
                    + "where gid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                s.setId(rs.getInt("seid"));
                s.setDate(rs.getDate("date"));
                listSessionsDates.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSessionsDates;
    }

    public ArrayList<Session> filter(String lid, Date from, Date to) {
        ArrayList<Session> sessions = new ArrayList<>();
        try {
            String sql = "select s.sesid , s.[date] , s.[status]\n"
                    + ",l.lid,l.lname\n"
                    + ",g.gid,g.gname\n"
                    + ",c.courseid,c.cname\n"
                    + ",r.rid,r.rname\n"
                    + ",t.slotid , t.slotTime\n"
                    + "From [Session] s\n"
                    + "inner join Manager l on l.lid = s.lid\n"
                    + "inner join [Group] g on g.gid = s.gid\n"
                    + "inner join [Course] c on c.courseid = g.courseid\n"
                    + "inner join Room r on r.rid = s.rid\n"
                    + "inner join Time t on t.slotid = s.slotid\n"
                    + "where l.lid = ? AND s.[date] >= ? AND s.[date] <= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, lid);
            stm.setDate(2, from);
            stm.setDate(3, to);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session session = new Session();
                Manager l = new Manager();
 
                Group g = new Group();
                Time t = new Time();


                session.setId(rs.getInt("seid"));
                session.setDate(rs.getDate("date"));
                session.setPresent(rs.getBoolean("present"));

                l.setId(rs.getInt("lid"));
                l.setName(rs.getString("lname"));
                session.setManager(l);

                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                session.setGroup(g);

//                c.setId(rs.getString("courseid"));
//                c.setName(rs.getString("cname"));
//                g.setCourse(c);
//
//                r.setId(rs.getInt("rid"));
//                r.setName(rs.getString("rname"));
//                session.setRoom(r);

                t.setId(rs.getInt("slotid"));
                t.setTime(rs.getString("time"));
                session.setTime(t);

                sessions.add(session);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessions;
    }

    @Override
    public void insert(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Session getFilter(String subid, int gid) {
        try {
            String sql = "SELECT g.gid,g.gname,c.courseid,c.cname,s.stdid,s.stdcode,s.stdname\n"
                    + "                    FROM Course c\n"
                    + "                   INNER JOIN [Group] g ON g.courseid = c.courseid \n"
                    + "                   INNER JOIN Worker_Group sg ON sg.gid = g.gid\n"
                    + "                    INNER JOIN Worker s ON s.stdid = s.stdid\n"
                    + "                    WHERE c.courseid = ? and g.gid = '1'";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, subid);
            stm.setInt(2, gid);
            ResultSet rs = stm.executeQuery();
            Session filter = null;
            while (rs.next()) {
                if (filter == null) {
                    filter = new Session();

                    Group g = new Group();
                    g.setId(rs.getInt("gid"));
                    g.setName(rs.getString("gname"));
                    filter.setGroup(g);

//                    Course c = new Course();
//                    c.setId(rs.getString("subid"));
//                    c.setName(rs.getString("subname"));
//                    g.setCourse(c);

                }
                //read Worker
                Worker s = new Worker();
                s.setId(rs.getInt("stdid"));
//                s.setCode(rs.getString("stdcode"));
                s.setName(rs.getString("stdname"));

                //read attandance
                CheckWork a = new CheckWork();
                a.setWorker(s);
                a.setSession(filter);
                filter.getAtts().add(a);
            }
            return filter;
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Session get(int id) {
        try {
            String sql = "SELECT ses.sesid,ses.date,ses.[status]\n"
                    + "                                     	,g.gid,g.gname\n"
                    + "                                 	,r.rid,r.rname\n"
                    + "                                     	,t.slotid,t.slotTime\n"
                    + "                                      	,l.lid,l.lname\n"
                    + "                                       	,c.courseid,c.cname\n"
                    + "                                      	,s.stdid,s.stdname,s.stdcode\n"
                    + "                                      	,ISNULL(a.Worker_status,0) present, ISNULL(a.[decription],'') [description]\n"
                    + "                                     		FROM [Session] ses\n"
                    + "                                 		INNER JOIN Room r ON r.rid = ses.rid\n"
                    + "										INNER JOIN Time t ON t.slotid = ses.slotid\n"
                    + "                                   		INNER JOIN Manager l ON l.lid = ses.lid\n"
                    + "                                		INNER JOIN [Group] g ON g.gid = ses.gid\n"
                    + "                               		INNER JOIN Course c ON c.courseid = g.courseid\n"
                    + "                          		INNER JOIN [Worker_Group] sg ON sg.gid = g.gid\n"
                    + "                             	    INNER JOIN [Worker] s ON s.stdid = sg.stdid\n"
                    + "                                		LEFT JOIN CheckWork a ON s.stdid = a.stdid AND ses.sesid = a.sesid\n"
                    + "                                   WHERE ses.sesid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            Session ses = null;
            while (rs.next()) {
                if (ses == null) {
                    ses = new Session();
//                    Room r = new Room();
//                    r.setId(rs.getInt("rid"));
//                    r.setName(rs.getString("rname"));
//                    ses.setRoom(r);

                    Time t = new Time();
                    t.setId(rs.getInt("slotid"));
                    t.setTime(rs.getString("slotTime"));
                    ses.setTime(t);

                    Manager l = new Manager();
                    l.setId(rs.getInt("lid"));
                    l.setName(rs.getString("lname"));
                    ses.setManager(l);

                    Group g = new Group();
                    g.setId(rs.getInt("gid"));
                    g.setName(rs.getString("gname"));
                    ses.setGroup(g);

//                    Course sub = new Course();
//                    sub.setId(rs.getString("subid"));
//                    sub.setName(rs.getString("subname"));
//                    g.setCourse(sub);

                    ses.setDate(rs.getDate("date"));
                    ses.setPresent(rs.getBoolean("present"));
                }
                //read Worker
                Worker s = new Worker();
                s.setId(rs.getInt("stdid"));
//                s.setCode(rs.getString("stdcode"));
                s.setName(rs.getString("stdname"));

                //read attandance
                CheckWork a = new CheckWork();
                a.setWorker(s);
                a.setSession(ses);
                a.setPresent(rs.getBoolean("present"));
                a.setDescription(rs.getString("description"));
                ses.getAtts().add(a);
            }
            return ses;
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Session> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Session model) {
        try {
            connection.setAutoCommit(false);
            String sql = "UPDATE [Session] SET status = 1 WHERE sesid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getId());
            stm.executeUpdate();

            //remove old attandances
            sql = "DELETE CheckWork WHERE sesid = ?";
            PreparedStatement stm_delete = connection.prepareStatement(sql);
            stm_delete.setInt(1, model.getId());
            stm_delete.executeUpdate();

            //insert new attandances
            for (CheckWork att : model.getAtts()) {
                sql = "INSERT INTO [CheckWork]\n"
                        + "                                 ([sesid]\n"
                        + "                                  ,[stdid]\n"
                        + "                                 ,[Worker_status]\n"
                        + "                                ,[description]\n"
                        + "                                  ,[record_time])\n"
                        + "                            VALUES\n"
                        + "                                (?\n"
                        + "                                 ,?\n"
                        + "                               ,?\n"
                        + "                               ,?\n"
                        + "                                   ,GETDATE())";
                PreparedStatement stm_insert = connection.prepareStatement(sql);
                stm_insert.setInt(1, model.getId());
                stm_insert.setInt(2, att.getWorker().getId());
                stm_insert.setBoolean(3, att.isPresent());
                stm_insert.setString(4, att.getDescription());
                stm_insert.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
