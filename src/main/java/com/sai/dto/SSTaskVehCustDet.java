/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dto;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Test
 */
public class SSTaskVehCustDet {
    
   private long taskId;
    private String taskType;
    private String taskStatus;
    private long apptmtId;
    private Date callDuDt;
    private Integer custId;
    private String custAdd;
    private String contactPerson;
    private String contactNo1;
    private String contactNo2;
    private String emailAdd;
    private String vehicleNo;
    private String salesExecName;
    private int locId;
    private int orgId;
    private String referenceNo;
    private String servcGrp;
    private Integer inventoryItemId;
    private String contacted;
    private String reason;
    private String remarks;
    private String taskReason;
    private Date lastServcDt;
    private String lastServcType;
    private String lastServcLoc;
    private Integer lastServcKm;
    private Date nextServcDt;
    private String nextServcType;
    private Date creationDate;
    private long createdBy;
    private Date lastUpdateDate;
    private long lastUpdatedBy;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String assignee;
    private String assigneeId;
     private  String custName;
    private  String custType;
    private  String chassisNo; 
    private  String engineNo; 
    private  String model; 
    private  String dealerCd; 
    private  Date dtOfPurchase; 
    private BigInteger contactPerNo;
    private String mcpStKm;
    private String mcpEnKm;
    private Date cngDueDate;
    private Date pucDueDate;
    private Date ewStDate;
    private Date ewEnDate;
    private Date mcpStDate;
    private Date mcpEnDate;

    public SSTaskVehCustDet(long taskId, String taskType, String taskStatus, long apptmtId, Date callDuDt, Integer custId, String custAdd, String contactPerson, String contactNo1, String contactNo2, String emailAdd, String vehicleNo, String salesExecName, int locId, int orgId, String referenceNo, String servcGrp, Integer inventoryItemId, String contacted, String reason, String remarks, String taskReason, Date lastServcDt, String lastServcType, String lastServcLoc, Integer lastServcKm, Date nextServcDt, String nextServcType, Date creationDate, long createdBy, Date lastUpdateDate, long lastUpdatedBy, String attribute1, String attribute2, String attribute3, String attribute4, String attribute5, String assignee, String assigneeId, String custName, String custType, String chassisNo, String engineNo, String model, String dealerCd, Date dtOfPurchase, BigInteger contactPerNo, String mcpStKm, String mcpEnKm, Date cngDueDate, Date pucDueDate, Date ewStDate, Date ewEnDate, Date mcpStDate, Date mcpEnDate) {
        this.taskId = taskId;
        this.taskType = taskType;
        this.taskStatus = taskStatus;
        this.apptmtId = apptmtId;
        this.callDuDt = callDuDt;
        this.custId = custId;
        this.custAdd = custAdd;
        this.contactPerson = contactPerson;
        this.contactNo1 = contactNo1;
        this.contactNo2 = contactNo2;
        this.emailAdd = emailAdd;
        this.vehicleNo = vehicleNo;
        this.salesExecName = salesExecName;
        this.locId = locId;
        this.orgId = orgId;
        this.referenceNo = referenceNo;
        this.servcGrp = servcGrp;
        this.inventoryItemId = inventoryItemId;
        this.contacted = contacted;
        this.reason = reason;
        this.remarks = remarks;
        this.taskReason = taskReason;
        this.lastServcDt = lastServcDt;
        this.lastServcType = lastServcType;
        this.lastServcLoc = lastServcLoc;
        this.lastServcKm = lastServcKm;
        this.nextServcDt = nextServcDt;
        this.nextServcType = nextServcType;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
        this.assignee = assignee;
        this.assigneeId = assigneeId;
        this.custName = custName;
        this.custType = custType;
        this.chassisNo = chassisNo;
        this.engineNo = engineNo;
        this.model = model;
        this.dealerCd = dealerCd;
        this.dtOfPurchase = dtOfPurchase;
        this.contactPerNo = contactPerNo;
        this.mcpStKm = mcpStKm;
        this.mcpEnKm = mcpEnKm;
        this.cngDueDate = cngDueDate;
        this.pucDueDate = pucDueDate;
        this.ewStDate = ewStDate;
        this.ewEnDate = ewEnDate;
        this.mcpStDate = mcpStDate;
        this.mcpEnDate = mcpEnDate;
    }

    public SSTaskVehCustDet() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public Date getCallDuDt() {
        return callDuDt;
    }

    public void setCallDuDt(Date callDuDt) {
        this.callDuDt = callDuDt;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
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

    public String getSalesExecName() {
        return salesExecName;
    }

    public void setSalesExecName(String salesExecName) {
        this.salesExecName = salesExecName;
    }

    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getServcGrp() {
        return servcGrp;
    }

    public void setServcGrp(String servcGrp) {
        this.servcGrp = servcGrp;
    }

    public Integer getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Integer inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
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

    public Date getLastServcDt() {
        return lastServcDt;
    }

    public void setLastServcDt(Date lastServcDt) {
        this.lastServcDt = lastServcDt;
    }

    public String getLastServcType() {
        return lastServcType;
    }

    public void setLastServcType(String lastServcType) {
        this.lastServcType = lastServcType;
    }

    public String getLastServcLoc() {
        return lastServcLoc;
    }

    public void setLastServcLoc(String lastServcLoc) {
        this.lastServcLoc = lastServcLoc;
    }

    public Integer getLastServcKm() {
        return lastServcKm;
    }

    public void setLastServcKm(Integer lastServcKm) {
        this.lastServcKm = lastServcKm;
    }

    public Date getNextServcDt() {
        return nextServcDt;
    }

    public void setNextServcDt(Date nextServcDt) {
        this.nextServcDt = nextServcDt;
    }

    public String getNextServcType() {
        return nextServcType;
    }

    public void setNextServcType(String nextServcType) {
        this.nextServcType = nextServcType;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
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

    public BigInteger getContactPerNo() {
        return contactPerNo;
    }

    public void setContactPerNo(BigInteger contactPerNo) {
        this.contactPerNo = contactPerNo;
    }

    public String getMcpStKm() {
        return mcpStKm;
    }

    public void setMcpStKm(String mcpStKm) {
        this.mcpStKm = mcpStKm;
    }

    public String getMcpEnKm() {
        return mcpEnKm;
    }

    public void setMcpEnKm(String mcpEnKm) {
        this.mcpEnKm = mcpEnKm;
    }

    public Date getCngDueDate() {
        return cngDueDate;
    }

    public void setCngDueDate(Date cngDueDate) {
        this.cngDueDate = cngDueDate;
    }

    public Date getPucDueDate() {
        return pucDueDate;
    }

    public void setPucDueDate(Date pucDueDate) {
        this.pucDueDate = pucDueDate;
    }

    public Date getEwStDate() {
        return ewStDate;
    }

    public void setEwStDate(Date ewStDate) {
        this.ewStDate = ewStDate;
    }

    public Date getEwEnDate() {
        return ewEnDate;
    }

    public void setEwEnDate(Date ewEnDate) {
        this.ewEnDate = ewEnDate;
    }

    public Date getMcpStDate() {
        return mcpStDate;
    }

    public void setMcpStDate(Date mcpStDate) {
        this.mcpStDate = mcpStDate;
    }

    public Date getMcpEnDate() {
        return mcpEnDate;
    }

    public void setMcpEnDate(Date mcpEnDate) {
        this.mcpEnDate = mcpEnDate;
    }
  

    
    
}
