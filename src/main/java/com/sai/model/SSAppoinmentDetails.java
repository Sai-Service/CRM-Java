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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
/**
 *
 * @author Test
 */
@Entity
@NamedNativeQuery(name = "SSAppoinmentDetails.findByTaskId", query = "select * from ss_appoinment_details where task_id = ?1 ", resultClass = SSAppoinmentDetails.class)

@NamedNativeQuery(name = "SSAppoinmentDetails.findByApptVehicleNo", query = "select * from ss_appoinment_details where vehicle_no = ?1 ", resultClass = SSAppoinmentDetails.class)

@Table(name = "ss_appoinment_details")
public class SSAppoinmentDetails implements Serializable {

    @Column(name = "TASK_ID")
    private long taskId;
    
    @Column(name = "ADMIN_ID")
    private long adminId;
    
    private Integer amount;
    @Column(name = "LOCATION_ID")
    private Integer locationId;
    @Column(name = "ORG_ID")
    private Integer orgId;
    @Column(name = "CREATED_BY")
    private long createdBy;
    @Column(name = "LAST_UPDATED_BY")
    private long lastUpdatedBy;
    @Size(max = 10)
    @Column(name = "PICKUP_MMS")
    private String pickupMms;
    @Column(name = "PICKUP_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pickupTime;
    
    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "APPMNT_ID")
    private long appmntId;
    

    @Column(name = "TASK_TYPE")
    private String taskType;

    @Column(name = "VEHICLE_NO")
    private String vehicleNo;

    @Column(name = "SERV_TYPE")
    private String servType;

    @Column(name = "SERV_LOC")
    private String servLoc;

    @Column(name = "SERV_GROUP")
    private String servGroup;

    @Column(name = "APPT_DATE")
    private Date apptDate;

    @Column(name = "APPT_TIME_SLOT")
    private String apptTimeSlot;

    @Column(name = "APPT_STATUS")
    private String apptStatus;

    @Column(name = "PICKUP")
    private String pickUp;


    @Column(name = "PICKUP_ADDRESS")
    private String pickAdd;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "LAST_DESPOSITION")
    private String lastDesposition;

    @Column(name = "APPT_ATTENEDED")
    private String apptAttended;

    @Column(name = "APPT_ATTEN_DT")
    private Date apptAttDt;

    @Column(name = "APPT_ATTEN_LOC")
    private String apptAttLoc;


    @Column(name = "CREATION_DATE")
    private Date creationDt;


    @Column(name = "LAST_UPDATE_DATE")
    private Date lstUpDt;
    

    @Column(name = "ATTRIBUTE1")
    private String attribute1;

    @Column(name = "ATTRIBUTE2")
    private String attribute2;    
    
    @Column(name = "ATTRIBUTE3")
    private String attribute3;

    @Column(name = "ATTRIBUTE4")
    private String attribute4;    
    
    @Column(name = "ATTRIBUTE5")
    private String attribute5;
    
  @Column(name = "ADV_NAME")
    private String advName;

    public SSAppoinmentDetails() {
    }

    public SSAppoinmentDetails(long appmntId, long taskId, long admnId, String taskType, String vehNo, String servType, String servLoc, String servGroup, Date apptDate, String apptTimeSlt, String apptStatus, String pickUp, int amount, String pickAdd, String remark, String lastDesposition, String apptAttended, Date apptAttDt, String apptAttLoc, int locId, int orgId, Date creationDt, long createdBy, Date lstUpDt, long lstUpBy, String attribute1, String attribute2, String attribute3, String attribute4, String attribute5, String advName) {
        this.appmntId = appmntId;
        this.taskId = taskId;
        this.adminId = admnId;
        this.taskType = taskType;
        this.vehicleNo = vehNo;
        this.servType = servType;
        this.servLoc = servLoc;
        this.servGroup = servGroup;
        this.apptDate = apptDate;
        this.apptTimeSlot = apptTimeSlt;
        this.apptStatus = apptStatus;
        this.pickUp = pickUp;
        this.amount = amount;
        this.pickAdd = pickAdd;
        this.remark = remark;
        this.lastDesposition = lastDesposition;
        this.apptAttended = apptAttended;
        this.apptAttDt = apptAttDt;
        this.apptAttLoc = apptAttLoc;
     //   this.l = locId;
        this.orgId = orgId;
        this.creationDt = creationDt;
        this.createdBy = createdBy;
        this.lstUpDt = lstUpDt;
        this.lastUpdatedBy = lstUpBy;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
        this. advName =advName;
    }
    
     public SSAppoinmentDetails(long appmntId, String vehNo, String servType, String servLoc, String servGroup, Date apptDate, String apptTimeSlt, String apptStatus, String pickUp, Integer amount, String pickAdd, String remark, String lastDesposition, String apptAttended ){
          this.appmntId = appmntId;
         this.vehicleNo = vehNo;
        this.servType = servType;
        this.servLoc = servLoc;
        this.servGroup = servGroup;
        this.apptDate = apptDate;
        this.apptTimeSlot = apptTimeSlt;
        this.apptStatus = apptStatus;
        this.pickUp = pickUp;
        this.amount = amount;
        this.pickAdd = pickAdd;
        this.remark = remark;
        this.lastDesposition = lastDesposition;
        this.apptAttended = apptAttended;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

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

    public long getAppmntId() {
        return appmntId;
    }

    public void setAppmntId(long appmntId) {
        this.appmntId = appmntId;
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

    public String getServLoc() {
        return servLoc;
    }

    public void setServLoc(String servLoc) {
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

    public String getApptTimeSlot() {
        return apptTimeSlot;
    }

    public void setApptTimeSlot(String apptTimeSlot) {
        this.apptTimeSlot = apptTimeSlot;
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

    public Date getCreationDt() {
        return creationDt;
    }

    public void setCreationDt(Date creationDt) {
        this.creationDt = creationDt;
    }

    public Date getLstUpDt() {
        return lstUpDt;
    }

    public void setLstUpDt(Date lstUpDt) {
        this.lstUpDt = lstUpDt;
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

    public String getAdvName() {
        return advName;
    }

    public void setAdvName(String advName) {
        this.advName = advName;
    }
    

   
}
