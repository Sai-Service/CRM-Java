/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dto;

import com.sai.model.SsVehicleMaster;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Test
 */
public class SSInsTaskContactYN {
    
    private Integer taskId;
    private Integer custId;
    private String vehicleNo;
    private String eventName;
    private Date callDueDt;
    private Date insEndDate;
    private String eventStatus;
    private String apptYN;
    private String remark;
    private String disposition;
    private Date apptDate;
    private String assignId;
    private String custStatus;
    private String insType;
    private BigInteger contactNo;

     public SSInsTaskContactYN(Integer taskId, Integer custId, String vehicleNo, String eventName, Date callDueDt, Date insEndDate, String eventStatus, String apptYN, String remark, String disposition, Date apptDate, String assignId, String custStatus, String insType) {
        this.taskId = taskId;
        this.custId = custId;
       // this.vehicleNo = vehicleNo.getVehicleNo();
        this.vehicleNo=vehicleNo;
        this.eventName = eventName;
        this.callDueDt = callDueDt;
        this.insEndDate = insEndDate;
        this.eventStatus = eventStatus;
        this.apptYN = apptYN;
        this.remark = remark;
        this.disposition = disposition;
        this.apptDate = apptDate;
        this.assignId = assignId;
        this.custStatus = custStatus;
        this.insType = insType;
        this.contactNo=contactNo;
        
        //this.contactYN = contactYN;
    }

    public SSInsTaskContactYN() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public BigInteger getContactNo() {
        return contactNo;
    }

    public void setContactNo(BigInteger contactNo) {
        this.contactNo = contactNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }
    

    
    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getCallDueDt() {
        return callDueDt;
    }

    public void setCallDueDt(Date callDueDt) {
        this.callDueDt = callDueDt;
    }

    public Date getInsEndDate() {
        return insEndDate;
    }

    public void setInsEndDate(Date insEndDate) {
        this.insEndDate = insEndDate;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getApptYN() {
        return apptYN;
    }

    public void setApptYN(String apptYN) {
        this.apptYN = apptYN;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public Date getApptDate() {
        return apptDate;
    }

    public void setApptDate(Date apptDate) {
        this.apptDate = apptDate;
    }

    public String getAssignId() {
        return assignId;
    }

    public void setAssignId(String assignId) {
        this.assignId = assignId;
    }

    public String getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(String custStatus) {
        this.custStatus = custStatus;
    }

    public String getInsType() {
        return insType;
    }

    public void setInsType(String insType) {
        this.insType = insType;
    }
    
    
}
