package com.sai.dto;

import java.util.Date;

public class SsTaskReport {

//    task_id,call_du_dt,cust_id,cust_name,cust_add,contact_person,cust_type,contact_no1,contact_no2,email_add,vehicle_no,
//chasis_no,engine_no,model,
    //contacted,reason,remarks,task_reason,last_servc_dt,last_servc_type,last_servc_loc,last_servc_km,
//next_servc_Dt,next_servc_type,call_for_service,assignee,assignee_id
    private long taskId;
    private Date callDuDt;
    private long custId;
    private String custName;
    private String custAdd;
    private String contactPerson;
    private String custType;
    private String contactNo1;
    private String contactNo2;
    private String emailAdd;
    private String vehicleNo;
    private String chassisNo;
    private String engineNo;
    private String model;
    private String contacted;
  private String reason;
    private String remarks;
    private String taskReason;
    private Date lstServDt;
    private String lstServType;
    private String lstServLoc;
    private long lstKm;
    private Date nxtServDt;
    private String nxtServType;
    private String callForService;
    private String assignee;
    private String assigneeId;

//    SsTaskReport (std.taskId,std.callDuDt, std.custId, std.CustName,std.CustAdd,std.contactPerson,std.custType,std.contactNo1,std.contactNo2,"
//              + "std.emailAdd,std.vehicleNo,std.chassisNo,std.engineNo,std.Model,std.contacted, std.reason,std.remarks,std.taskReason,std.lstServDt,std.lstServType,std.lstServLoc,std.lstKm,std.nxtServDt,std.nxtServType,"
//              + "std.attribute1 as callForService,sad.assignee, sad.assigneeId) 

    public SsTaskReport(long taskId, Date callDuDt, long custId, String custName, String custAdd, String contactPerson, String custType, String contactNo1, String contactNo2, String emailAdd, String vehicleNo, String chassisNo, String engineNo, String model, String contacted, String reason, String remarks, String taskReason, Date lstServDt, String lstServType, String lstServLoc, long lstKm, Date nxtServDt, String nxtServType, String callForService, String assignee, String assigneeId) {
        this.taskId = taskId;
        this.callDuDt = callDuDt;
        this.custId = custId;
        this.custName = custName;
        this.custAdd = custAdd;
        this.contactPerson = contactPerson;
        this.custType = custType;
        this.contactNo1 = contactNo1;
        this.contactNo2 = contactNo2;
        this.emailAdd = emailAdd;
        this.vehicleNo = vehicleNo;
        this.chassisNo = chassisNo;
        this.engineNo = engineNo;
        this.model = model;
        this.contacted = contacted;
        this.reason = reason;
        this.remarks = remarks;
        this.taskReason = taskReason;
        this.lstServDt = lstServDt;
        this.lstServType = lstServType;
        this.lstServLoc = lstServLoc;
        this.lstKm = lstKm;
        this.nxtServDt = nxtServDt;
        this.nxtServType = nxtServType;
        this.callForService = callForService;
        this.assignee = assignee;
        this.assigneeId = assigneeId;
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
    
    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public Date getCallDuDt() {
        return callDuDt;
    }

    public void setCallDuDt(Date callDuDt) {
        this.callDuDt = callDuDt;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAdd() {
        return custAdd;
    }

    public void setCustAdd(String custAdd) {
        this.custAdd = custAdd;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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

    public String getContactNo2() {
        return contactNo2;
    }

    public void setContactNo2(String contactNo2) {
        this.contactNo2 = contactNo2;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
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

    public String getContacted() {
        return contacted;
    }

    public void setContacted(String contacted) {
        this.contacted = contacted;
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

    public String getCallForService() {
        return callForService;
    }

    public void setCallForService(String callForService) {
        this.callForService = callForService;
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
    
    

}
