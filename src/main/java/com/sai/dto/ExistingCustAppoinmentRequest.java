/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 *
 * @author Swaroopcomp
 */
public class ExistingCustAppoinmentRequest {

    @JsonProperty("cust_type")
    private String custType;
    @JsonProperty("address1")
    private String address1;
    @JsonProperty("contact_no2")
    private String contactNo2;
    @JsonProperty("last_servc_loc")
    private String lastServcLoc;
    @JsonProperty("cust_name")
    private String custName;
    @JsonProperty("address2")
    private String address2;
    @JsonProperty("chassis_no")
    private String chassisNo;
    @JsonProperty("address3")
    private String address3;
    @JsonProperty("cust_id")
    private long custId;
    @JsonProperty("pincode")
    private long pincode;
    @JsonProperty("last_servc_type")
    private String lastServcType;
    @JsonProperty("contact_no1")
    private String contactNo1;
    @JsonProperty("last_servc_km")
    private long lastServcKm;
    @JsonProperty("city")
    private String city;
    @JsonProperty("model")
    private String model;
    @JsonProperty("location")
    private String location;
    @JsonProperty("dealer_code")
    private String dealerCode;
    @JsonProperty("state_name")
    private String stateName;
    @JsonProperty("vehicle_no")
    private String vehicleNo;
    @JsonProperty("call_du_dt")
    private String callDuDt;
    @JsonProperty("engine_no")
    private String engineNo;
    @JsonProperty("last_servc_dt")
    private Date lastServcDt;
    @JsonProperty("amc")
    private String amc;
    @JsonProperty("email_id")
    private String emailId;
    @JsonProperty("dt_of_purchase")
    private Date dtOfPurchase;
    @JsonProperty("servcGrp")
    private String servcGrp;
    @JsonProperty("contacted")
    private String contacted;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("remarks")
    private String remarks;
    @JsonProperty("taskReason")
    private String taskReason;
    @JsonProperty("servDuDt")
    private Date servDuDt;
    @JsonProperty("delvDt")
    private Date delvDt;
    @JsonProperty("servcType")
    private String servcType;
    @JsonProperty("assignee")
    private Assignee assignee;

    @JsonProperty("apptDate")
    private Date apptDate;
    @JsonProperty("apptTimeSlt")
    private String apptTimeSlt;
    @JsonProperty("pickUp")
    private String pickUp;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("pickAdd")
    private String pickAdd;
    @JsonProperty("lastDesposition")
    private String lastDesposition;

    private String exename;
    @JsonProperty("servcLoc")
    private LstServLoc servcLoc;
    private String pickupMms;
    private Date pickupTime;

    public String getExename() {
        return exename;
    }

    public void setExename(String exename) {
        this.exename = exename;
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

    public String getContactNo2() {
        return contactNo2;
    }

    public void setContactNo2(String contactNo2) {
        this.contactNo2 = contactNo2;
    }

    public String getLastServcLoc() {
        return lastServcLoc;
    }

    public void setLastServcLoc(String lastServcLoc) {
        this.lastServcLoc = lastServcLoc;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public String getLastServcType() {
        return lastServcType;
    }

    public void setLastServcType(String lastServcType) {
        this.lastServcType = lastServcType;
    }

    public String getContactNo1() {
        return contactNo1;
    }

    public void setContactNo1(String contactNo1) {
        this.contactNo1 = contactNo1;
    }

    public long getLastServcKm() {
        return lastServcKm;
    }

    public void setLastServcKm(long lastServcKm) {
        this.lastServcKm = lastServcKm;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getCallDuDt() {
        return callDuDt;
    }

    public void setCallDuDt(String callDuDt) {
        this.callDuDt = callDuDt;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public Date getLastServcDt() {
        return lastServcDt;
    }

    public void setLastServcDt(Date lastServcDt) {
        this.lastServcDt = lastServcDt;
    }

    public String getAmc() {
        return amc;
    }

    public void setAmc(String amc) {
        this.amc = amc;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Date getDtOfPurchase() {
        return dtOfPurchase;
    }

    public void setDtOfPurchase(Date dtOfPurchase) {
        this.dtOfPurchase = dtOfPurchase;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTaskReason() {
        return taskReason;
    }

    public void setTaskReason(String taskReason) {
        this.taskReason = taskReason;
    }

    public Date getServDuDt() {
        return servDuDt;
    }

    public void setServDuDt(Date servDuDt) {
        this.servDuDt = servDuDt;
    }

    public Date getDelvDt() {
        return delvDt;
    }

    public void setDelvDt(Date delvDt) {
        this.delvDt = delvDt;
    }

    public String getServcType() {
        return servcType;
    }

    public void setServcType(String servcType) {
        this.servcType = servcType;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    public LstServLoc getServcLoc() {
        return servcLoc;
    }

    public void setServcLoc(LstServLoc servcLoc) {
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

}
