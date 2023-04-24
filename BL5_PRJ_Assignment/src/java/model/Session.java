/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Session {
    private int id;
    private Manager manager;
    private Time time;
    private Date date;
    private boolean present; 
    private Group group;

    private ArrayList<CheckWork> atts = new ArrayList<>();



    public Session() {
    }

    public Session(int id, Manager manager, Time time, Date date, boolean present, Group group) {
        this.id = id;
        this.manager = manager;
        this.time = time;
        this.date = date;
        this.present = present;
        this.group = group;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public ArrayList<CheckWork> getAtts() {
        return atts;
    }

    public void setAtts(ArrayList<CheckWork> atts) {
        this.atts = atts;
    }
    

    

}