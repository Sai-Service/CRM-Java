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
/**
 *
 * @author Test
 */
@Entity


@Table(name = "ss_administrator_data")
public class SsAdministratorData implements Serializable {
    
    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "ADMN_ID")
    private long admnId;
     
   @Column(name = "TASK_TYPE")
    private String taskType;
   
    @Column(name = "CUST_NAME")
    private String custName;
   
    @Column(name = "CUST_TYPE")
    private String custType;
    
    @Column(name = "CONTACT_NO")
    private String contactNo;
     
    @Column(name = "VEHICLE_NO")
    private String vehicleNo;
      
    @Column(name = "CHECK_FLAG")
    private String checkFlag;
       
    @Column(name = "SERVC_TYPE")
    private String servcType;
        
    @Column(name = "CALL_DUE_DT")
    private Date callDueDt;
         
    @Column(name = "SERVC_DUE_DT")
    private Date servDueTo;

        
    @Column(name = "ASSIGNEE")
    private String assignee;

    @Column(name = "STATUS")
    private String status;
    
    @Column(name = "CREATION_DATE")
    private Date creationDt;
   
    @Column(name = "CREATED_BY")
    private long createdBy;
    
    @Column(name = "LAST_UPDATE_DATE")
    private Date lstUpdDt;
    
    @Column(name = "LAST_UPDATED_BY")
    private long lstUpdLogin;
        
    @Column(name = "ASSIGNEE_ID")
    private String assigneeId;
    
    @Column(name = "TASK_ID")
    private long taskId;
    
    @Column(name = "ORG_ID")
    private long orgid;

    @Column(name = "SERVC_LOCATION")
    private String servcLoc;

    public SsAdministratorData() {
    }

    public SsAdministratorData(long admnId, String taskType, String custName, String custType, String contactNo, String vehNo, String checkFlag,
            String servcType, Date callDueDt, Date servDueTo, String assignee, String status, Date creationDt, long createdBy, Date lstUpdDt, long lstUpdLogin,
            String assigneeId, long taskId, long orgid, String servcLoc) {
        this.admnId = admnId;
        this.taskType = taskType;
        this.custName = custName;
        this.custType = custType;
        this.contactNo = contactNo;
        this.vehicleNo = vehNo;
        this.checkFlag = checkFlag;
        this.servcType = servcType;
        this.callDueDt = callDueDt;
        this.servDueTo = servDueTo;
        this.assignee = assignee;
        this.status = status;
        this.creationDt = creationDt;
        this.createdBy = createdBy;
        this.lstUpdDt = lstUpdDt;
        this.lstUpdLogin = lstUpdLogin;
        this.assigneeId = assigneeId;
        this.taskId = taskId;
        this.orgid = orgid;
        this.servcLoc = servcLoc;
    }

    
    
    public long getAdmnId() {
        return admnId;
    }

    public void setAdmnId(long admnId) {
        this.admnId = admnId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }

    public String getServcType() {
        return servcType;
    }

    public void setServcType(String servcType) {
        this.servcType = servcType;
    }

    public Date getCallDueDt() {
        return callDueDt;
    }

    public void setCallDueDt(Date callDueDt) {
        this.callDueDt = callDueDt;
    }

    public Date getServDueTo() {
        return servDueTo;
    }

    public void setServDueTo(Date servDueTo) {
        this.servDueTo = servDueTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreationDt() {
        return creationDt;
    }

    public void setCreationDt(Date creationDt) {
        this.creationDt = creationDt;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLstUpdDt() {
        return lstUpdDt;
    }

    public void setLstUpdDt(Date lstUpdDt) {
        this.lstUpdDt = lstUpdDt;
    }

    public long getLstUpdLogin() {
        return lstUpdLogin;
    }

    public void setLstUpdLogin(long lstUpdLogin) {
        this.lstUpdLogin = lstUpdLogin;
    }

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public long getOrgid() {
        return orgid;
    }

    public void setOrgid(long orgid) {
        this.orgid = orgid;
    }

    public String getServcLoc() {
        return servcLoc;
    }

    public void setServcLoc(String servcLoc) {
        this.servcLoc = servcLoc;
    }

}
