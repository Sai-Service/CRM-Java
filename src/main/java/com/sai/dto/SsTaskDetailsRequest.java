package com.sai.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class SsTaskDetailsRequest {

    @JsonProperty("taskType")
    private String taskType;
    @JsonProperty("taskStatus")
    private String taskStatus;
    @JsonProperty("apptmtId")
    private long apptmtId;
    @JsonProperty("custId")
    private long custId;
    @JsonProperty("custName")
    private String custName;
    @JsonProperty("custType")
    private String custType;
    @JsonProperty("contactPerson")
    private String contactPerson;
    @JsonProperty("custAdd")
    private String custAdd;
    @JsonProperty("contactNo1")
    private String contactNo1;
    @JsonProperty("contactNo2")
    private String contactNo2;
    @JsonProperty("emailAdd")
    private String emailAdd;
    @JsonProperty("taskReason")
    private String taskReason;
    @JsonProperty("admnId")
    private long admnId;
    @JsonProperty("callDuDt")
    private Date callDuDt;
    @JsonProperty("salesExeName")
    private String salesExeName;
    @JsonProperty("vehicleNo")
    private String vehicleNo;
    @JsonProperty("model")
    private String model;
    @JsonProperty("dtOfPurchase")
    private Date dtOfPurchase;
    @JsonProperty("engineNo")
    private String engineNo;
    @JsonProperty("chassisNo")
    private String chassisNo;
    @JsonProperty("amc")
    private String amc;
    @JsonProperty("dealerCode")
    private String dealerCode;
    @JsonProperty("lstServDt")
    private Date lstServDt;
    @JsonProperty("lstServType")
    private String lstServType;
    @JsonProperty("lstServLoc")
    private String lstServLoc;
    @JsonProperty("lstKm")
    private Integer lstKm;
    @JsonProperty("nxtServDt")
    private Date nxtServDt;
    @JsonProperty("nxtServType")
    private String nxtServType;
    @JsonProperty("remark")
    private String remark;
    @JsonProperty("contacted")
    private String contacted;
    @JsonProperty("reasonCode")
    private String reasonCode;
    @JsonProperty("Desposition")
    private String desposition;
    @JsonProperty("exicutive")
    private String exicutive;
    @JsonProperty("date")
    private Date date;
    @JsonProperty("pickAdd")
    private String pickAdd;
    @JsonProperty("servGroup")
    private String servGroup;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("apptDate")
    private Date apptDate;
    @JsonProperty("apptTimeSlt")
    private String apptTimeSlt;
    @JsonProperty("pickUp")
    private String pickUp;
    @JsonProperty("servType")
    private String servType;
 //   @JsonProperty("servLoc")
   // private String servLoc;
    @JsonProperty("locId")
    private Integer locId;
    @JsonProperty("orgId")
    private Integer orgId;
    @JsonProperty("empName")
    private String empName;
  //  @JsonProperty("assignee")
//    private Assignee assignee;
    private Date delvDt;
    private Date servDuDt;
    private String exename;
    
    private String assingeeId;
    private String assignee;
    
     @JsonProperty("regenerateCallDuDt")
    private RegenerateCallDuDt regenerateCallDuDt;

    public RegenerateCallDuDt getRegenerateCallDuDt() {
        return regenerateCallDuDt;
    }

    public void setRegenerateCallDuDt(RegenerateCallDuDt regenerateCallDuDt) {
        this.regenerateCallDuDt = regenerateCallDuDt;
    }

    public String getAssingeeId() {
        return assingeeId;
    }

    public void setAssingeeId(String assingeeId) {
        this.assingeeId = assingeeId;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
     


    public String getExename() {
        return exename;
    }

    public void setExename(String exename) {
        this.exename = exename;
    }
    
    public Date getDelvDt() {
        return delvDt;
    }

    public void setDelvDt(Date delvDt) {
        this.delvDt = delvDt;
    }

    public Date getServDuDt() {
        return servDuDt;
    }

    public void setServDuDt(Date servDuDt) {
        this.servDuDt = servDuDt;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public long getApptmtId() {
        return apptmtId;
    }

    public void setApptmtId(long apptmtId) {
        this.apptmtId = apptmtId;
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

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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

    public String getTaskReason() {
        return taskReason;
    }

    public void setTaskReason(String taskReason) {
        this.taskReason = taskReason;
    }

    public long getAdmnId() {
        return admnId;
    }

    public void setAdmnId(long admnId) {
        this.admnId = admnId;
    }

    public Date getCallDuDt() {
        return callDuDt;
    }

    public void setCallDuDt(Date callDuDt) {
        this.callDuDt = callDuDt;
    }

    public String getSalesExeName() {
        return salesExeName;
    }

    public void setSalesExeName(String salesExeName) {
        this.salesExeName = salesExeName;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDtOfPurchase() {
        return dtOfPurchase;
    }

    public void setDtOfPurchase(Date dtOfPurchase) {
        this.dtOfPurchase = dtOfPurchase;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getAmc() {
        return amc;
    }

    public void setAmc(String amc) {
        this.amc = amc;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getContacted() {
        return contacted;
    }

    public void setContacted(String contacted) {
        this.contacted = contacted;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getDesposition() {
        return desposition;
    }

    public void setDesposition(String desposition) {
        this.desposition = desposition;
    }

    public String getExicutive() {
        return exicutive;
    }

    public void setExicutive(String exicutive) {
        this.exicutive = exicutive;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPickAdd() {
        return pickAdd;
    }

    public void setPickAdd(String pickAdd) {
        this.pickAdd = pickAdd;
    }

    public String getServGroup() {
        return servGroup;
    }

    public void setServGroup(String servGroup) {
        this.servGroup = servGroup;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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

    public String getServType() {
        return servType;
    }

    public void setServType(String servType) {
        this.servType = servType;
    }

//    public String getServLoc() {
//        return servLoc;
//    }
//
//    public void setServLoc(String servLoc) {
//        this.servLoc = servLoc;
//    }

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


    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

//    public Assignee getAssignee() {
//        return assignee;
//    }
//
//    public void setAssignee(Assignee assignee) {
//        this.assignee = assignee;
//    }

}
