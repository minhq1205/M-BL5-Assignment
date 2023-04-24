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
import model.Time;

/**
 *
 * @author Ngo Tung Son
 */
public class TimeDBContext extends DBContext<Time> {

    @Override
    public void insert(Time model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Time model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Time model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Time get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Time> list() {
        ArrayList<Time> slots = new ArrayList<>();
        try {
            String sql = "select slotid , slotTime\n"
                    + "from [Time] ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Time slot = new Time();
                slot.setId(rs.getInt("slotid"));
                slot.setTime(rs.getString("slotTime"));
                slots.add(slot);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slots;
    }
    
   public ArrayList<Time> all() {
        ArrayList<Time> slots = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT [slotid]\n"
                    + "      ,[slotTime]\n"
                    + "  FROM [Time]";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Time d = new Time();
                d.setId(rs.getInt("slotid"));
                d.setTime(rs.getString("slotTime"));
                slots.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(TimeDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(TimeDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(TimeDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return slots;

    }
}
