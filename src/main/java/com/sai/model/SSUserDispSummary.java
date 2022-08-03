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
public class SSUserDispSummary {
 
    private long taskId;
    private String taskType;
    private long custId;
    private String custAdd;
    private String contactNo1;
    private String vehicleNo;
    private String lstServType;
    private String lstServLoc;
    private Date callDuDt;
    private Date nxtServDt;  //changes by jyoti t
    private String taskStatus;
    private String remarks;
    private Integer locId;
    private String nxtServType;//added by jyoti t

    public SSUserDispSummary() {
    }

    public SSUserDispSummary(long taskId, String taskType,  long custId, String custAdd, String contactNo1, String vehicleNo, String lstServType, String lstServLoc, Date callDuDt, Date nxtServDt, String taskStatus, String remarks, Integer locId, String nxtServType) {
        this.taskId = taskId;
        this.taskType = taskType;
       //this.CustName = CustName;
      //  this.custAdd = custType;
      this.custId =custId;
      this.custAdd = custAdd;
        this.contactNo1 = contactNo1;
        this.vehicleNo = vehicleNo;
        this.lstServType = lstServType;
        this.lstServLoc = lstServLoc;
        this.callDuDt = callDuDt;
        this.nxtServDt = nxtServDt;
        this.taskStatus = taskStatus;
        this.remarks = remarks;
        this.locId = locId;
        this.nxtServType = nxtServType;
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
//
//    public String getCustName() {
//        return CustName;
//    }
//
//    public void setCustName(String CustName) {
//        this.CustName = CustName;
//    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getCustAdd() {
        return custAdd;
    }

    public void setCustAdd(String custAdd) {
        this.custAdd = custAdd;
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

    public Date getNxtServDt() {
        return nxtServDt;
    }

    public void setNxtServDt(Date nxtServDt) {
        this.nxtServDt = nxtServDt;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getLocId() {
        return locId;
    }

    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    public String getNxtServType() {
        return nxtServType;
    }

    public void setNxtServType(String nxtServType) {
        this.nxtServType = nxtServType;
    }

   

   
}
