/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

/**
 *
 * @author Test
 */
public class Despositions {
    private long cmCode;
    private String cmName;
    private String cmDesc;
    private String type;

    public Despositions(long cmCode, String cmName, String cmDesc, String type) {
        this.cmCode = cmCode;
        this.cmName = cmName;
        this.cmDesc = cmDesc;
        this.type = type;
    }

    public long getCmCode() {
        return cmCode;
    }

    public void setCmCode(long cmCode) {
        this.cmCode = cmCode;
    }

    public String getCmName() {
        return cmName;
    }

    public void setCmName(String cmName) {
        this.cmName = cmName;
    }

    public String getCmDesc() {
        return cmDesc;
    }

    public void setCmDesc(String cmDesc) {
        this.cmDesc = cmDesc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
}
