/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class WorkCheck {
    private int aid;
    private Worker wid;
    private Session sesid;
    private boolean present;
    private String description;
    private Date record_time;


    public WorkCheck() {
    }

    public WorkCheck(int aid, Worker wid, Session sesid, boolean present, String description, Date record_time) {
        this.aid = aid;
        this.wid = wid;
        this.sesid = sesid;
        this.present = present;
        this.description = description;
        this.record_time = record_time;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public Worker getWid() {
        return wid;
    }

    public void setWid(Worker wid) {
        this.wid = wid;
    }

    public Session getSesid() {
        return sesid;
    }

    public void setSesid(Session sesid) {
        this.sesid = sesid;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRecord_time() {
        return record_time;
    }

    public void setRecord_time(Date record_time) {
        this.record_time = record_time;
    }

   
    
 
    
}
