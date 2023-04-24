/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Worker;

/**
 *
 * @author ADMIN
 */
public class WorkerDBContext extends DBContext<Worker> {

    public ArrayList<Worker> listWorkerInAGroup(int id) {
        ArrayList<Worker> listWorker = new ArrayList<>();
        try {
            String sql = "SELECT s.stdid,s.stdcode,s.stdfirstname,s.stdmidname,s.stdlastname,s.stdgmail\n"
                    + "FROM Worker s\n"
                    + "INNER JOIN Worker_Group stdg ON stdg.stdid = s.stdid\n"
                    + "INNER JOIN [Group] g ON g.gid = stdg.gid\n"
                    + "WHERE g.gid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                Worker s = new Worker();
                s.setWid(rs.getString("wid"));
               s.setName(rs.getString("name"));
                s.setContact(rs.getString("contact"));

                listWorker.add(s);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listWorker;
    }

    @Override
    public void insert(Worker model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Worker model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Worker model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    @Override
    public ArrayList<Worker> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Worker get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}