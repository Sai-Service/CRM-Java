/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Test
 */
@Entity
@Table(name = "ss_task_details")
@NamedNativeQuery(name = "SsTaskDetails.findByVehNo", query = "select * from ss_task_details where vehicle_no = ?1 ", resultClass = SsTaskDetails.class)

@NamedNativeQuery(name = "SsTaskDetails.findByTaskId", query = "select * from ss_task_details where task_id = ?1", resultClass = SsTaskDetails.class)

//@NamedNativeQuery(name = "SsTaskDetails.findCountByLoc", query = "select * from ss_task_details where loc_id = ?1 and CALL_DU_DT=curdate() ", resultClass = SsTaskDetails.class)


//@NamedNativeQueries(value = {
//@NamedNativeQuery(name = "SsTaskDetails.findByTaskId", query = "select * from ss_task_details where task_id = ?1 and CALL_DU_DT=curdate() ", resultClass = SsTaskDetails.class) })


 public class SsTaskDetails  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TASK_ID")
    private long taskId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TASK_TYPE")
    private String taskType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TASK_STATUS")
    private String taskStatus;
    @Column(name = "APPTMT_ID")
    private long apptmtId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALL_DU_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date callDuDt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUST_ID")
    private long custId;
    @Size(max = 1000)
    @Column(name = "CUST_ADD")
    private String custAdd;
    @Size(max = 145)
    @Column(name = "CONTACT_PERSON")
    private String contactPerson;
    @Size(max = 45)
    @Column(name = "CONTACT_NO1")
    private String contactNo1;
    @Size(max = 45)
    @Column(name = "CONTACT_NO2")
    private String contactNo2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 145)
    @Column(name = "EMAIL_ADD")
    private String emailAdd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "VEHICLE_NO")
    private String vehicleNo;
    @Size(max = 45)
    @Column(name = "SALES_EXEC_NAME")
    private String salesExecName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOC_ID")
    private int locId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORG_ID")
    private int orgId;
    @Size(max = 45)
    @Column(name = "REFERENCE_NO")
    private String referenceNo;
    @Size(max = 45)
    @Column(name = "SERVC_GRP")
    private String servcGrp;
    @Column(name = "INVENTORY_ITEM_ID")
    private Integer inventoryItemId;
    @Size(max = 45)
    @Column(name = "CONTACTED")
    private String contacted;
    @Size(max = 245)
    @Column(name = "REASON")
    private String reason;
    @Size(max = 425)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 245)
    @Column(name = "TASK_REASON")
    private String taskReason;
    @Column(name = "LAST_SERVC_DT")
    @Temporal(TemporalType.DATE)
    private Date lastServcDt;
    @Size(max = 45)
    @Column(name = "LAST_SERVC_TYPE")
    private String lastServcType;
    @Size(max = 45)
    @Column(name = "LAST_SERVC_LOC")
    private String lastServcLoc;
    @Column(name = "LAST_SERVC_KM")
    private Integer lastServcKm;
    @Column(name = "NEXT_SERVC_DT")
    @Temporal(TemporalType.DATE)
    private Date nextServcDt;
    @Size(max = 45)
    @Column(name = "NEXT_SERVC_TYPE")
    private String nextServcType;
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Column(name = "CREATED_BY")
    private long createdBy;
    @Column(name = "LAST_UPDATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastUpdateDate;
    @Column(name = "LAST_UPDATED_BY")
    private long lastUpdatedBy;
    @Size(max = 245)
    @Column(name = "ATTRIBUTE1")
    private String attribute1;
    @Size(max = 245)
    @Column(name = "ATTRIBUTE2")
    private String attribute2;
    @Size(max = 245)
    @Column(name = "ATTRIBUTE3")
    private String attribute3;
    @Size(max = 245)
    @Column(name = "ATTRIBUTE4")
    private String attribute4;
    @Size(max = 245)
    @Column(name = "ATTRIBUTE5")
    private String attribute5;
    @Size(max = 45)
    @Column(name = "ASSIGNEE")
    private String assignee;
    @Size(max = 45)
    @Column(name = "ASSIGNEE_ID")
    private String assigneeId;
@Column(name = "CUST_NAME")
    private String custName;
@Column(name = "CUST_TYPE")
    private String custType;

    
    
    
    
    public SsTaskDetails() {
    }

    public SsTaskDetails(long taskId) {
        this.taskId = taskId;
    }

    public SsTaskDetails(long taskId, String taskType, String taskStatus, Date callDuDt, long custId, String emailAdd, String vehicleNo, int locId, int orgId) {
        this.taskId = taskId;
        this.taskType = taskType;
        this.taskStatus = taskStatus;
        this.callDuDt = callDuDt;
        this.custId = custId;
        this.emailAdd = emailAdd;
        this.vehicleNo = vehicleNo;
        this.locId = locId;
        this.orgId = orgId;
    }
//             SsTaskDetails(std.taskType,  std.taskStatus,  std.callDuDt,  std.custId,   std.custAdd,  std.contactPerson, std.contactNo1,  std.contactNo2,  std.emailAdd,  std.vehicleNo,  std.reason,  std.remarks,  std.taskReason,  std.lastServcDt,  std.lastServcType,  std.lastServcLoc,  std.lastServcKm, std.nextServcDt,  std.nextServcType\n" +

    public SsTaskDetails(String taskType, String taskStatus, Date callDuDt, long custId, String custAdd, String contactPerson, String contactNo1, String contactNo2, String emailAdd, String vehicleNo, String reason, String remarks, String taskReason, Date lastServcDt, String lastServcType, String lastServcLoc, Integer lastServcKm, Date nextServcDt, String nextServcType) {
        this.taskType = taskType;
        this.taskStatus = taskStatus;
        this.callDuDt = callDuDt;
        this.custId = custId;
        this.custAdd = custAdd;
        this.contactPerson = contactPerson;
        this.contactNo1 = contactNo1;
        this.contactNo2 = contactNo2;
        this.emailAdd = emailAdd;
        this.vehicleNo = vehicleNo;
        this.reason = reason;
        this.remarks = remarks;
        this.taskReason = taskReason;
        this.lastServcDt = lastServcDt;
        this.lastServcType = lastServcType;
        this.lastServcLoc = lastServcLoc;
        this.lastServcKm = lastServcKm;
        this.nextServcDt = nextServcDt;
        this.nextServcType = nextServcType;
    }

    //taskId,taskType,taskStatus,apptmtId,callDuDt,custId,contactPerson,custAdd,contactNo1,contactNo2,emailAdd,vehicleNo,salesExecName,locId,orgId,referenceNo,servcGrp,inventoryItemId,contacted,reason,remarks,taskReason,lastServcDt,lastServcType,lastServcLoc,lastServcKm,nextServcDt,nextServcType,creationDate,createdBy,lastUpdateDate,lastUpdateBy,attribute1,attribute2,attribute3,attribute4,attribute5

    public SsTaskDetails(long taskId, String taskType, String taskStatus, long apptmtId, Date callDuDt, long custId, String custAdd, String contactPerson, String contactNo1, String contactNo2, String emailAdd, String vehicleNo, String salesExecName, int locId, int orgId, String referenceNo, String servcGrp, Integer inventoryItemId, String contacted, String reason, String remarks, String taskReason, Date lastServcDt, String lastServcType, String lastServcLoc, Integer lastServcKm, Date nextServcDt, String nextServcType, Date creationDate, long createdBy, Date lastUpdateDate, long lastUpdatedBy, String attribute1, String attribute2, String attribute3, String attribute4, String attribute5) {
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
    }

    public SsTaskDetails(long taskId, String taskType, String taskStatus, long apptmtId, Date callDuDt, long custId, String custAdd, String contactPerson, String contactNo1, String contactNo2, String emailAdd, String vehicleNo, String salesExecName, int locId, int orgId, String referenceNo, String servcGrp, Integer inventoryItemId, String contacted, String reason, String remarks, String taskReason, Date lastServcDt, String lastServcType, String lastServcLoc, Integer lastServcKm, Date nextServcDt, String nextServcType, Date creationDate, long createdBy, Date lastUpdateDate, long lastUpdatedBy, String attribute1, String attribute2, String attribute3, String attribute4, String attribute5, String assignee, String assigneeId) {
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

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getCustAdd() {
        return custAdd;
    }

    public void setCustAdd(String custAdd) {
        this.custAdd = custAdd;
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

    


   
    @Override
    public String toString() {
        return "com.sai.model.SsTaskDetails[ taskId=" + taskId + " ]";
    }


    
    
}
