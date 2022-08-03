/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
/**
 *
 * @author Test
 */
@Entity
@Table(name = "ss_loc_access")
public class SsLocAccess implements Serializable
{

    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "LACC_ID")
    private long lid=1L;
    
    @Column(name = "USER_NAME")
    private  String username;
    
    @Column(name = "LOC_ACCESS")
    private Integer locAccess ;

    @Column(name = "LOCNAME")
    private String locName ;
    
    @Column(name = "VALID")
    private String valid ;
    
    @Column(name = "CREATION_DATE")
    private  Date creationDt;
    
    @Column(name = "CREATED_BY")
    private  long createdBy;
        
    @Column(name = "LAST_UPDATED_DATE")
    private  Date lstUpDate;
    
    @Column(name = "LAST_UPDATED_BY")
    private  long lstUpBy;
    
    
    @Column(name = "type")
    private String type ;

    public SsLocAccess()
    {
        
    }

    public SsLocAccess(String username, Integer locAccess, String locName, String valid, Date creationDt, long createdBy, Date lstUpDate, long lstUpBy, String type) {
        this.username = username;
        this.locAccess = locAccess;
        this.locName = locName;
        this.valid = valid;
        this.creationDt = creationDt;
        this.createdBy = createdBy;
        this.lstUpDate = lstUpDate;
        this.lstUpBy = lstUpBy;
        this.type = type;
    }

    public long getLid() {
        return lid;
    }

    public void setLid(long lid) {
        this.lid = lid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    public Integer getLocAccess() {
        return locAccess;
    }

    public void setLocAccess(Integer locAccess) {
        this.locAccess = locAccess;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public Date getCreationDt() {
        return creationDt;
    }

    public void setCreationDt(Date creationDt) {
        this.creationDt = creationDt;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLstUpDate() {
        return lstUpDate;
    }

    public void setLstUpDate(Date lstUpDate) {
        this.lstUpDate = lstUpDate;
    }

    public long getLstUpBy() {
        return lstUpBy;
    }

    public void setLstUpBy(long lstUpBy) {
        this.lstUpBy = lstUpBy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
