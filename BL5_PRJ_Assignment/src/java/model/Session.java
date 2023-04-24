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

    private int sesid;
    private Manager mid;
    private Time time;
    private boolean present; 
    private Group gid;
    private Time tid;
    private Date date;
  
    private ArrayList<WorkCheck> atts = new ArrayList<>();



    public Session() {
    }

    public Session(int sesid, Manager mid, Time time, boolean present, Group gid, Time tid, Date date) {
        this.sesid = sesid;
        this.mid = mid;
        this.time = time;
        this.present = present;
        this.gid = gid;
        this.tid = tid;
        this.date = date;
    }

    public int getSesid() {
        return sesid;
    }

    public void setSesid(int sesid) {
        this.sesid = sesid;
    }

    public Manager getMid() {
        return mid;
    }

    public void setMid(Manager mid) {
        this.mid = mid;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public Group getGid() {
        return gid;
    }

    public void setGid(Group gid) {
        this.gid = gid;
    }

    public Time getTid() {
        return tid;
    }

    public void setTid(Time tid) {
        this.tid = tid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<WorkCheck> getAtts() {
        return atts;
    }

    public void setAtts(ArrayList<WorkCheck> atts) {
        this.atts = atts;
    }
    


    

}