/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sai.dto.LstServLoc;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Test
 */
public class NewCustAppt {
    private Integer custId;
    private  String custName;
    private  String custType;
    private  String address1;
    private  String address2;
    private  String address3;
    private  String location;
    private  Integer pincode;
    private  String city;
    private  String stateName;
    private  String country;
    private  String contactNo1;    
    private  String contactNo2;
    private  String emailId;
    private  long createdBy;
    private  Date creationDt;
    private  long lstUpBy;  
    private  Date lstUpDate;
    private  String vehicleNo; 
    private  String chassisNo; 
    private  String engineNo; 
    private  String model; 
    private  String dealerCd; 
    private  Date dtOfPurchase; 
    
  
    ////ss task details
    private String CustAdd;   
    private Date callDuDt;    
    private String amc; 
    private String salesExeName;
    private Integer locId;
    private Integer orgId;
    private String servcGrp;
    private String contacted;
    private String remarks;
    private String reason;
    private String taskReason;
    private Date lstServDt;    
    private String lstServType;
  
    private Integer lstKm;
    private String attribute1;
    private Date nxtServDt;
    private String nxtServType;
    private String servcLoc;
    private Date apptDate;
    private String apptTimeSlt;
    private String pickUp;
    private Integer amount;
    private String pickAdd;
    private String lastDesposition;
    private String apptAttended;
    private Date apptAttDt;
    private String apptAttLoc;
    private String exename;
    private  String pickupMms;
    private String pickupTime;
    
@JsonProperty("lstServLoc")
private LstServLoc lstServLoc;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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

    public Date getLstUpDate() {
        return lstUpDate;
    }

    public void setLstUpDate(Date lstUpDate) {
        this.lstUpDate = lstUpDate;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDealerCd() {
        return dealerCd;
    }

    public void setDealerCd(String dealerCd) {
        this.dealerCd = dealerCd;
    }

    public Date getDtOfPurchase() {
        return dtOfPurchase;
    }

    public void setDtOfPurchase(Date dtOfPurchase) {
        this.dtOfPurchase = dtOfPurchase;
    }

    public String getCustAdd() {
        return CustAdd;
    }

    public void setCustAdd(String CustAdd) {
        this.CustAdd = CustAdd;
    }

    public Date getCallDuDt() {
        return callDuDt;
    }

    public void setCallDuDt(Date callDuDt) {
        this.callDuDt = callDuDt;
    }

    public String getAmc() {
        return amc;
    }

    public void setAmc(String amc) {
        this.amc = amc;
    }

    public String getSalesExeName() {
        return salesExeName;
    }

    public void setSalesExeName(String salesExeName) {
        this.salesExeName = salesExeName;
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

    public String getServcGrp() {
        return servcGrp;
    }

    public void setServcGrp(String servcGrp) {
        this.servcGrp = servcGrp;
    }

    public String getContacted() {
        return contacted;
    }

    public void setContacted(String contacted) {
        this.contacted = contacted;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public Integer getLstKm() {
        return lstKm;
    }

    public void setLstKm(Integer lstKm) {
        this.lstKm = lstKm;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
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

    public String getServcLoc() {
        return servcLoc;
    }

    public void setServcLoc(String servcLoc) {
        this.servcLoc = servcLoc;
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

    public String getExename() {
        return exename;
    }

    public void setExename(String exename) {
        this.exename = exename;
    }

    public LstServLoc getLstServLoc() {
        return lstServLoc;
    }

    public void setLstServLoc(LstServLoc lstServLoc) {
        this.lstServLoc = lstServLoc;
    }

    public String getPickupMms() {
        return pickupMms;
    }

    public void setPickupMms(String pickupMms) {
        this.pickupMms = pickupMms;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    
    
}

