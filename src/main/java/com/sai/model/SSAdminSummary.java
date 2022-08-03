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
public class SSAdminSummary {
    
    
    private long taskId;
    private String taskType;
    private String CustName;
    private String custType;
    private String contactNo1;
    private String vehicleNo;
    private String lstServType;
    private String lstServLoc;
    private Date callDuDt;
    private Date servDuDt;  
    private String taskStatus;
   private long locId;
 

    public SSAdminSummary(long taskId, String taskType, String CustName, String custType, String contactNo1, String vehicleNo, String lstServType, String lstServLoc, Date callDuDt, Date servDuDt, String taskStatus, long locId) {
        this.taskId = taskId;
        this.taskType = taskType;
        this.CustName = CustName;
        this.custType = custType;
        this.contactNo1 = contactNo1;
        this.vehicleNo = vehicleNo;
        this.lstServType = lstServType;
        this.lstServLoc = lstServLoc;
        this.callDuDt = callDuDt;
        this.servDuDt = servDuDt;
        this.taskStatus = taskStatus;
        this.locId = locId;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String CustName) {
        this.CustName = CustName;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getContactNo1() {
        return contactNo1;
    }

    public void setContactNo1(String contactNo1) {
        this.contactNo1 = contactNo1;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getLstServType() {
        return lstServType;
    }

    public void setLstServType(String lstServType) {
        this.lstServType = lstServType;
    }

    public String getLstServLoc() {
        return lstServLoc;
    }

    public void setLstServLoc(String lstServLoc) {
        this.lstServLoc = lstServLoc;
    }

    public Date getCallDuDt() {
        return callDuDt;
    }

    public void setCallDuDt(Date callDuDt) {
        this.callDuDt = callDuDt;
    }

    public Date getServDuDt() {
        return servDuDt;
    }

    public void setServDuDt(Date servDuDt) {
        this.servDuDt = servDuDt;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public long getLocId() {
        return locId;
    }

    public void setLocId(long locId) {
        this.locId = locId;
    }

  

   
}
