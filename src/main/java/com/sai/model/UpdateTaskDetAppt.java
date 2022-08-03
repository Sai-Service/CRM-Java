/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sai.dto.LstServLoc;
import java.util.Date;

/**
 *
 * @author Test
 */
public class UpdateTaskDetAppt {

    private Integer appmntId;
    private Integer taskId;
    private Integer admnId;
    private String taskType;
    private String vehicleNo;
    private String servType;
    @JsonProperty("servLoc")
    private LstServLoc servLoc;
    private String servGroup;
    private Date apptDate;
    private String apptTimeSlt;
    private String apptStatus;
    private String pickUp;
    private Integer amount;
    private String pickAdd;
    private String remark;
    @JsonProperty("Desposition")
    private String lastDesposition;
    private String apptAttended;
    private Date apptAttDt;
    private String apptAttLoc;
    private Integer locId;
    private Integer orgId;
    private Date creationDt;
    private Integer createdBy;
    private Date lstUpDt;
    private Integer lstUpBy;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
///////TO UPDATE THE COLUMNS OF SS TASK DETAILS TABLE///////
    private String contacted;
    @JsonProperty("reasonCode")
    private String reason;
    private String taskReason;
    private Date lstServDt;
    private String lstServType;
    private String lstServLoc;
    private Integer lstKm;
    private Date nxtServDt;
    private String nxtServType;
    private String exename;

    private String pickupMms;
    private Date pickupTime;

    public String getPickupMms() {
        return pickupMms;
    }

    public void setPickupMms(String pickupMms) {
        this.pickupMms = pickupMms;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getExename() {
        return exename;
    }

    public void setExename(String exename) {
        this.exename = exename;
    }

    public UpdateTaskDetAppt() {
    }

    public Integer getAppmntId() {
        return appmntId;
    }

    public void setAppmntId(Integer appmntId) {
        this.appmntId = appmntId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getAdmnId() {
        return admnId;
    }

    public void setAdmnId(Integer admnId) {
        this.admnId = admnId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getServType() {
        return servType;
    }

    public void setServType(String servType) {
        this.servType = servType;
    }

    public LstServLoc getServLoc() {
        return servLoc;
    }

    public void setServLoc(LstServLoc servLoc) {
        this.servLoc = servLoc;
    }

    public String getServGroup() {
        return servGroup;
    }

    public void setServGroup(String servGroup) {
        this.servGroup = servGroup;
    }

    public Date getApptDate() {
        return apptDate;
    }

    public void setApptDate(Date apptDate) {
        this.apptDate = apptDate;
    }

    public String getApptTimeSlt() {
        return apptTimeSlt;
    }

    public void setApptTimeSlt(String apptTimeSlt) {
        this.apptTimeSlt = apptTimeSlt;
    }

    public String getApptStatus() {
        return apptStatus;
    }

    public void setApptStatus(String apptStatus) {
        this.apptStatus = apptStatus;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPickAdd() {
        return pickAdd;
    }

    public void setPickAdd(String pickAdd) {
        this.pickAdd = pickAdd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLastDesposition() {
        return lastDesposition;
    }

    public void setLastDesposition(String lastDesposition) {
        this.lastDesposition = lastDesposition;
    }

    public String getApptAttended() {
        return apptAttended;
    }

    public void setApptAttended(String apptAttended) {
        this.apptAttended = apptAttended;
    }

    public Date getApptAttDt() {
        return apptAttDt;
    }

    public void setApptAttDt(Date apptAttDt) {
        this.apptAttDt = apptAttDt;
    }

    public String getApptAttLoc() {
        return apptAttLoc;
    }

    public void setApptAttLoc(String apptAttLoc) {
        this.apptAttLoc = apptAttLoc;
    }

    public Integer getLocId() {
        return locId;
    }

    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Date getCreationDt() {
        return creationDt;
    }

    public void setCreationDt(Date creationDt) {
        this.creationDt = creationDt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLstUpDt() {
        return lstUpDt;
    }

    public void setLstUpDt(Date lstUpDt) {
        this.lstUpDt = lstUpDt;
    }

    public Integer getLstUpBy() {
        return lstUpBy;
    }

    public void setLstUpBy(Integer lstUpBy) {
        this.lstUpBy = lstUpBy;
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

    public String getContacted() {
        return contacted;
    }

    public void setContacted(String contacted) {
        this.contacted = contacted;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTaskReason() {
        return taskReason;
    }

    public void setTaskReason(String taskReason) {
        this.taskReason = taskReason;
    }

    public Date getLstServDt() {
        return lstServDt;
    }

    public void setLstServDt(Date lstServDt) {
        this.lstServDt = lstServDt;
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

    public Integer getLstKm() {
        return lstKm;
    }

    public void setLstKm(Integer lstKm) {
        this.lstKm = lstKm;
    }

    public Date getNxtServDt() {
        return nxtServDt;
    }

    public void setNxtServDt(Date nxtServDt) {
        this.nxtServDt = nxtServDt;
    }

    public String getNxtServType() {
        return nxtServType;
    }

    public void setNxtServType(String nxtServType) {
        this.nxtServType = nxtServType;
    }

}
