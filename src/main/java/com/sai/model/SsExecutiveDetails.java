/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;


import com.fasterxml.jackson.annotation.JsonFormat;
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
@NamedNativeQuery(name = "SsExecutiveDetails.findExeByLocId", query = "select * from ss_executive_details where loc_id = ?1 and status='ACTIVE' ", resultClass = SsExecutiveDetails.class)

@Table(name = "ss_executive_details")
public class SsExecutiveDetails implements Serializable {
    
    
    //@Id
    //@javax.persistence.Id
    //@Column(name = "EXEC_ID")
    //private long execId;
    
    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "EXEC_ID")
    private long execId=1L;
    
    @Column(name = "TICKETNO")
    private  String ticketNo;
    
    @Column(name = "EMP_NAME")
    private String empName ;
    
    @Column(name = "DIV_CODE")
    private  String divCode;
    
    @Column(name = "DEPT_CODE")
    private String deptCode ;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "DOB")
    private  Date dob;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "DOJ")
    private Date doj ;

    @Column(name = "LOC_ID")
    private  long locId;

   @Column(name = "CREATED_BY")
    private  long createdBy;
    
    @Column(name = "CREATION_DATE")
    private  Date creationDt;

    @Column(name = "LAST_UPDATED_BY")
    private  long lstUpBy;  
    
    @Column(name = "LAST_UPDATION_DATE")
    private  Date lstUpDate;
    
    @Column(name = "ATTRIBUTE1")
    private  String attribute1;   
    
    @Column(name = "ATTRIBUTE2")
    private  String attribute2;   

    @Column(name = "ATTRIBUTE3")
    private  String attribute3;   

    @Column(name = "ATTRIBUTE4")
    private  String attribute4;   

    @Column(name = "ATTRIBUTE5")
    private  String attribute5;    
   
   @Column(name = "STATUS")
    private  String status;       
    
   @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "INACTIVE_DATE")
    private  Date inactiveDate;          
    
  @Column(name = "AGENT_ID")
    private  String agentId; 

    @Column(name = "Desg_Code")
    private  String desgCode; 
  
    public SsExecutiveDetails()
    {
        
    }

    public SsExecutiveDetails(String ticketNo, String empName, String divCode, String deptCode, Date dob, Date doj, long locId, long createdBy, Date creationDt, long lstUpBy, Date lstUpDate, String attribute1, String attribute2, String attribute3, String attribute4, String attribute5, String status, Date inactiveDate, String agentId, String desgCode) {
        this.ticketNo = ticketNo;
        this.empName = empName;
        this.divCode = divCode;
        this.deptCode = deptCode;
        this.dob = dob;
        this.doj = doj;
        this.locId = locId;
        this.createdBy = createdBy;
        this.creationDt = creationDt;
        this.lstUpBy = lstUpBy;
        this.lstUpDate = lstUpDate;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
        this.status = status;
        this.inactiveDate = inactiveDate;
        this.agentId = agentId;
        this.desgCode = desgCode;
    }

    public long getExecId() {
        return execId;
    }

    public void setExecId(long execId) {
        this.execId = execId;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDivCode() {
        return divCode;
    }

    public void setDivCode(String divCode) {
        this.divCode = divCode;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public long getLocId() {
        return locId;
    }

    public void setLocId(long locId) {
        this.locId = locId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(Date inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getDesgCode() {
        return desgCode;
    }

    public void setDesgCode(String desgCode) {
        this.desgCode = desgCode;
    }

    
    
    
}
