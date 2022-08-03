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
public class CommonAllType {
    private String cmDesc;
    private String type;

    public CommonAllType(String cmDesc, String type) {
        this.cmDesc = cmDesc;
        this.type = type;
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
