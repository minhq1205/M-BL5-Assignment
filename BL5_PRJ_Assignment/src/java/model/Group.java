/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Group {
    private int gid;
    private String gname;
    private Manager mid;
    private ArrayList<Session> sessions = new ArrayList<>();
    private ArrayList<Worker> workers = new ArrayList<>();

    public Group() {
    }

    public Group(int gid, String gname, Manager mid) {
        this.gid = gid;
        this.gname = gname;
        this.mid = mid;
    }

    
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Manager getMid() {
        return mid;
    }

    public void setMid(Manager mid) {
        this.mid = mid;
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<Session> sessions) {
        this.sessions = sessions;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    
}
