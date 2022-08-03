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
public class ExistingCustAppt {
    private long cust_id;
    private  String cust_name;
    private  String cust_type;
    private  String address1;
    private  String address2;
    private  String address3;
    private  String location;
    private  long pincode;
    private  String city;
    private  String state_name;
    private  String contact_no1;    
    private  String contact_no2;
    private  String email_id;
    private  String vehicle_no; 
    private  long chassis_no; 
    private  long engine_no; 
    private  String model; 
    private  String dealer_code; 
    private  Date dt_of_purchase; 
    
    private Date last_servc_dt;
    private String last_servc_type;
    private String last_servc_loc;   
    private long last_servc_km;
    private String amc;
    private Date call_du_dt;
    private long locId;
    private long orgId;
    private String servcGrp;
    private String contacted;
    private String reason;
    private String remarks;
    private String taskReason;
    private Date lstServDt;
    private String lstServType;
    private String lstServLoc;
    private long lstKm;
    private Date servDuDt;
    private Date delvDt;
    private String attribute1;
    
    
    private String servcType;
    private String assignee;
    private String assigneeId;
    private String servcLoc;
    
    private Date apptDate;
    private String apptTimeSlt;
    private String pickUp;
    private long amount;
    private String pickAdd;
  //  private String remark;
    private String lastDesposition;
    private Date apptAttDt;
    
    
    
    
    
    public ExistingCustAppt() {
    }

    public ExistingCustAppt(long cust_id, String cust_name, String cust_type, String address1, String address2, String address3, String location, long pincode, String city, String state_name, String contact_no1, String contact_no2, String email_id, String vehicle_no, long chassis_no, long engine_no, String model, String dealer_code, Date dt_of_purchase, Date last_servc_dt, String last_servc_type, String last_servc_loc, long last_servc_km, String amc, Date call_du_dt, long locId, long orgId, String servcGrp, String contacted, String reason, String remarks, String taskReason, Date lstServDt, String lstServType, String lstServLoc, long lstKm, Date servDuDt, Date delvDt, String attribute1, String servcType, String assignee, String assigneeId, String servcLoc, Date apptDate, String apptTimeSlt, String pickUp, long amount, String pickAdd, String lastDesposition, Date apptAttDt) {
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.cust_type = cust_type;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.location = location;
        this.pincode = pincode;
        this.city = city;
        this.state_name = state_name;
        this.contact_no1 = contact_no1;
        this.contact_no2 = contact_no2;
        this.email_id = email_id;
        this.vehicle_no = vehicle_no;
        this.chassis_no = chassis_no;
        this.engine_no = engine_no;
        this.model = model;
        this.dealer_code = dealer_code;
        this.dt_of_purchase = dt_of_purchase;
        this.last_servc_dt = last_servc_dt;
        this.last_servc_type = last_servc_type;
        this.last_servc_loc = last_servc_loc;
        this.last_servc_km = last_servc_km;
        this.amc = amc;
        this.call_du_dt = call_du_dt;
        this.locId = locId;
        this.orgId = orgId;
        this.servcGrp = servcGrp;
        this.contacted = contacted;
        this.reason = reason;
        this.remarks = remarks;
        this.taskReason = taskReason;
        this.lstServDt = lstServDt;
        this.lstServType = lstServType;
        this.lstServLoc = lstServLoc;
        this.lstKm = lstKm;
        this.servDuDt = servDuDt;
        this.delvDt = delvDt;
        this.attribute1 = attribute1;
        this.servcType = servcType;
        this.assignee = assignee;
        this.assigneeId = assigneeId;
        this.servcLoc = servcLoc;
        this.apptDate = apptDate;
        this.apptTimeSlt = apptTimeSlt;
        this.pickUp = pickUp;
        this.amount = amount;
        this.pickAdd = pickAdd;
        this.lastDesposition = lastDesposition;
        this.apptAttDt = apptAttDt;
    }

    public long getCust_id() {
        return cust_id;
    }

    public void setCust_id(long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_type() {
        return cust_type;
    }

    public void setCust_type(String cust_type) {
        this.cust_type = cust_type;
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

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getContact_no1() {
        return contact_no1;
    }

    public void setContact_no1(String contact_no1) {
        this.contact_no1 = contact_no1;
    }

    public String getContact_no2() {
        return contact_no2;
    }

    public void setContact_no2(String contact_no2) {
        this.contact_no2 = contact_no2;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public long getChassis_no() {
        return chassis_no;
    }

    public void setChassis_no(long chassis_no) {
        this.chassis_no = chassis_no;
    }

    public long getEngine_no() {
        return engine_no;
    }

    public void setEngine_no(long engine_no) {
        this.engine_no = engine_no;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDealer_code() {
        return dealer_code;
    }

    public void setDealer_code(String dealer_code) {
        this.dealer_code = dealer_code;
    }

    public Date getDt_of_purchase() {
        return dt_of_purchase;
    }

    public void setDt_of_purchase(Date dt_of_purchase) {
        this.dt_of_purchase = dt_of_purchase;
    }

    public Date getLast_servc_dt() {
        return last_servc_dt;
    }

    public void setLast_servc_dt(Date last_servc_dt) {
        this.last_servc_dt = last_servc_dt;
    }

    public String getLast_servc_type() {
        return last_servc_type;
    }

    public void setLast_servc_type(String last_servc_type) {
        this.last_servc_type = last_servc_type;
    }

    public String getLast_servc_loc() {
        return last_servc_loc;
    }

    public void setLast_servc_loc(String last_servc_loc) {
        this.last_servc_loc = last_servc_loc;
    }

    public long getLast_servc_km() {
        return last_servc_km;
    }

    public void setLast_servc_km(long last_servc_km) {
        this.last_servc_km = last_servc_km;
    }

    public String getAmc() {
        return amc;
    }

    public void setAmc(String amc) {
        this.amc = amc;
    }

    public Date getCall_du_dt() {
        return call_du_dt;
    }

    public void setCall_du_dt(Date call_du_dt) {
        this.call_du_dt = call_du_dt;
    }

    public long getLocId() {
        return locId;
    }

    public void setLocId(long locId) {
        this.locId = locId;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
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

    public long getLstKm() {
        return lstKm;
    }

    public void setLstKm(long lstKm) {
        this.lstKm = lstKm;
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

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getServcType() {
        return servcType;
    }

    public void setServcType(String servcType) {
        this.servcType = servcType;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
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

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
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

    public Date getApptAttDt() {
        return apptAttDt;
    }

    public void setApptAttDt(Date apptAttDt) {
        this.apptAttDt = apptAttDt;
    }

    
}
