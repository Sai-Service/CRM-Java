/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sai.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_login")
@NamedNativeQuery(name = "UserLogin.findByLocation", query = "select * from user_login where loc_id = ?1", resultClass = UserLogin.class)

public class UserLogin implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ORG_ID")
    private int orgId;

    @Column(name = "LOC_ID")
    private Integer locId;
    @Column(name = "CREATED_BY")
    private Integer createdBy;
    @Column(name = "LAST_UPDATED_BY")
    private Integer lastUpdatedBy;
    
   // @Id
  //  @GeneratedValue
    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private long userId=1L;
    
    @Column(name = "TICKET_NO")
    private  String ticketNo;
        
    @Column(name = "LOGIN_NAME")
    private  String username;
    
    @Column(name = "PASSWORD")
    private  String password;

    @Column(name = "ROLE")
    private  String role;
    
    @Column(name = "DEPT")
    private  String dept;
    
    @Column(name = "REPORTING_TO")
    private  String reportTo;    
   
     @Column(name = "TYPE")
    private  String type;    
    

    @Column(name = "CREATION_DT")
    private  Date creationDt;    


    @Column(name = "LAST_UPDATION_DATE")
    private  Date lstUpDate;    

    
    @Column(name = "ATTRIBUTE1")
    private  String attribute1;   
    
    @Column(name = "ATTRIBUTE2")
    private  String attribute2;   

    @Column(name = "ATTRIBUTE3")
    private  String attribute3;   

    @Column(name = "ATTRIBUTE4")
    private  String attribute4;   

    @Column(name = "ATTRIBUTE5")
    private  String attribute5;       
    
     
    @Column(name = "IP_ADDRESS")
    private  String ipAddress;  


    public UserLogin(){
        
    }

    public UserLogin(long userId, String ticketNo, String username, String password, String role, String dept, String reportTo, String type, int locId, Date creationDt, int createdBy, Date lstUpDate, int lstUpBy, String attribute1, String attribute2, String attribute3, String attribute4, String attribute5, int orgId, String ipAddress) {
        this.userId = userId;
        this.ticketNo = ticketNo;
        this.username = username;
        this.password = password;
        this.role = role;
        this.dept = dept;
        this.reportTo = reportTo;
        this.type = type;
        this.locId = locId;
        this.creationDt = creationDt;
        this.createdBy = createdBy;
        this.lstUpDate = lstUpDate;
        this.lastUpdatedBy = lstUpBy;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
        this.orgId = orgId;
        this.ipAddress = ipAddress;
    }

    public UserLogin( String ticketNo,Integer locId) {
        this.locId = locId;
        this.ticketNo = ticketNo;
    }

    public UserLogin(Integer locId, String ticketNo, String username, String dept) {
        this.locId = locId;
        this.ticketNo = ticketNo;
        this.username = username;
        this.dept = dept;
    }
    

    
    
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getReportTo() {
        return reportTo;
    }

    public void setReportTo(String reportTo) {
        this.reportTo = reportTo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
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

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLstUpDate() {
        return lstUpDate;
    }

    public void setLstUpDate(Date lstUpDate) {
        this.lstUpDate = lstUpDate;
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

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

   
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }


   
    
}