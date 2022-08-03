/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

import java.util.Date;

/**
 *
 * @author Test
 */
public class LocAccessLoginwise {
     private String login_name;
     private String loc_access;
     private String locname;
     private String username;

    public LocAccessLoginwise(String login_name, String loc_access, String locname, String username) {
        this.login_name = login_name;
        this.loc_access = loc_access;
        this.locname = locname;
        this.username = username;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getLoc_access() {
        return loc_access;
    }

    public void setLoc_access(String loc_access) {
        this.loc_access = loc_access;
    }

    public String getLocname() {
        return locname;
    }

    public void setLocname(String locname) {
        this.locname = locname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
   
     
}
