/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Group {
    private int gid;
    private Worker wid;

    public Group() {
    }

    public Group(int gid, Worker wid) {
        this.gid = gid;
        this.wid = wid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public Worker getWid() {
        return wid;
    }

    public void setWid(Worker wid) {
        this.wid = wid;
    }
    
    
}
