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
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;
/**
 *
 * @author Test
 */
@Entity
@NamedNativeQuery(name = "SsCommonList.findByCmnType", query = "select * from ss_common_list where type = ?1 and status='ACTIVE' ", resultClass = SsCommonList.class)

@Table(name = "ss_common_list")
public class SsCommonList implements Serializable{
    
 //   @Id
  //  @javax.persistence.Id
   // @Column(name = "CM_CODE")
   // private long cmCode;
    
    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "CM_CODE")
    private long cmCode=1L;
    
    
    @Column(name = "CM_NAME")
    private  String cmName;
    
    @Column(name = "CM_DESC")
    private String cmDesc ;

    @Column(name = "TYPE")
    private  String type;
    
    @Column(name = "TYPE_DESC")
    private String typeDesc ;
    
    @Column(name = "ATTRIBUTE1")
    private  String attribute1;
    
    @Column(name = "ATTRIBUTE2")
    private String attribute2 ;
    
    @Column(name = "CREATED_BY")
    private  long createdBy;
    
    @Column(name = "CREATION_DATE")
    private Date creationDt ;
    
    @Column(name = "LAST_UPDATED_BY")
    private  long lstUpBy;
    
    @Column(name = "LAST_UPDATION_DATE")
    private Date lstUpDt ;
        
    @Column(name = "STATUS")
    private  String status;       
    
    @Column(name = "INACTIVE_DATE")
    private  Date inactiveDate;       
    
    
    public SsCommonList()
    {
        
    }

    public SsCommonList(long cmCode, String cmName, String cmDesc, String type, String typeDesc, String attribute1, String attribute2, long createdBy, Date creationDt, long lstUpBy, Date lstUpDt, String status, Date inactiveDate) {
        this.cmCode = cmCode;
        this.cmName = cmName;
        this.cmDesc = cmDesc;
        this.type = type;
        this.typeDesc = typeDesc;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.createdBy = createdBy;
        this.creationDt = creationDt;
        this.lstUpBy = lstUpBy;
        this.lstUpDt = lstUpDt;
        this.status = status;
        this.inactiveDate = inactiveDate;
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

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDt() {
        return creationDt;
    }

    public void setCreationDt(Date creationDt) {
        this.creationDt = creationDt;
    }

    public long getLstUpBy() {
        return lstUpBy;
    }

    public void setLstUpBy(long lstUpBy) {
        this.lstUpBy = lstUpBy;
    }

    public Date getLstUpDt() {
        return lstUpDt;
    }

    public void setLstUpDt(Date lstUpDt) {
        this.lstUpDt = lstUpDt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(Date inactiveDate) {
        this.inactiveDate = inactiveDate;
    }
    
   
}
