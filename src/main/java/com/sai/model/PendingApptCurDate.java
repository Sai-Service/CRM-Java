/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

import java.util.Date;
import javax.persistence.Column;

/**
 *
 * @author Test
 */
public class PendingApptCurDate {
    
    
    private long appmntId;
    private String vehicleNo;
    private String contactPerson;
    private String servType;
    private String servLoc;
    private String servGroup;
    private Date apptDate;
    private String apptTimeSlot;
    private String apptStatus;
    private String pickupMms;
    private String pickUp;
    private Date pickupTime;
    private int amount;
    private String pickAdd;  
    private String remark;
    private String lastDesposition;    
    private String apptAttended;
    private String advName;
    private String contactNo1;
    private String contactNo2;

    public PendingApptCurDate(long appmntId, String vehNo, String contactPerson, String servType, String servLoc, String servGroup, Date apptDate, String apptTimeSlot, String apptStatus, String pickupMms, String pickUp, Date pickupTime, int amount, String pickAdd, String remark, String lastDesposition, String apptAttended, String advName, String contactNo1, String contactNo2) {
        this.appmntId = appmntId;
        this.vehicleNo = vehNo;
        this.contactPerson = contactPerson;
        this.servType = servType;
        this.servLoc = servLoc;
        this.servGroup = servGroup;
        this.apptDate = apptDate;
        this.apptTimeSlot = apptTimeSlot;
        this.apptStatus = apptStatus;
        this.pickupMms = pickupMms;
        this.pickUp = pickUp;
        this.pickupTime = pickupTime;
        this.amount = amount;
        this.pickAdd = pickAdd;
        this.remark = remark;
        this.lastDesposition = lastDesposition;
        this.apptAttended = apptAttended;
        this.advName = advName;
        this.contactNo1 = contactNo1;
        this.contactNo2 = contactNo2;
    }

    public long getAppmntId() {
        return appmntId;
    }

    public void setAppmntId(long appmntId) {
        this.appmntId = appmntId;
    }


    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }
    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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

    public String getapptTimeSlot() {
        return apptTimeSlot;
    }

    public void setapptTimeSlot(String apptTimeSlot) {
        this.apptTimeSlot = apptTimeSlot;
    }

    public String getApptStatus() {
        return apptStatus;
    }

    public void setApptStatus(String apptStatus) {
        this.apptStatus = apptStatus;
    }

    public String getPickupMms() {
        return pickupMms;
    }

    public void setPickupMms(String pickupMms) {
        this.pickupMms = pickupMms;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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

    public String getAdvName() {
        return advName;
    }

    public void setAdvName(String advName) {
        this.advName = advName;
    }

    public String getContactNo1() {
        return contactNo1;
    }

    public void setContactNo1(String contactNo1) {
        this.contactNo1 = contactNo1;
    }

    public String getContactNo2() {
        return contactNo2;
    }

    public void setContactNo2(String contactNo2) {
        this.contactNo2 = contactNo2;
    }
    
    
    
}
