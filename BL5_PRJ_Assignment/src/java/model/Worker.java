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
public class Worker {
    private String wid;
    private String name;
    private String contact;
    private ArrayList<Group> groups = new ArrayList<>();
    private ArrayList<WorkCheck> atts = new ArrayList<>();
    
    public Worker() {
    }

    public Worker(String wid, String name, String contact) {
        this.wid = wid;
        this.name = name;
        this.contact = contact;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public ArrayList<WorkCheck> getAtts() {
        return atts;
    }

    public void setAtts(ArrayList<WorkCheck> atts) {
        this.atts = atts;
    }
    
    
}
