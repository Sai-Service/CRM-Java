/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model.insurance;

import com.sai.model.SsCustomer;
import com.sai.model.SsVehicleMaster;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Swaroopcomp
 */
@Entity
@Table(name = "ss_ins_task_details")

public class SsInsTaskDetails implements Serializable {

    @Basic(optional = false)
    @NotNull
    private int custId;
    @Size(max = 45)
    private String eventName;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date callDueDt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String eventStatus;
    @Size(max = 45)
    private String printRenewal;
    @Size(max = 45)
    private String apptYN;
    @Size(max = 1045)
    private String remark;
    @Size(max = 200)
    private String disposition;
    @Size(max = 1045)
    private String apptAddress;
    @Size(max = 50)
    private String assignId;
    @Size(max = 10)
    private String custStatus;
   
    private Integer createdBy;
    
    private Integer lstUpdBy;
    @Size(max = 1045)
    private String attribute1;
    @Size(max = 1045)
    private String attribute2;
    @Size(max = 1045)
    private String attribute3;
     @Size(max = 1045)
    private String attribute4;
    @Size(max = 1045)
    private String attribute5;
  
    @Size(max = 1045)
    private String attribute6;
    @Size(max = 1045)
    private String attribute7;
    @Size(max = 1045)
    private String attribute8;
    @Size(max = 1045)
    private String attribute9;
    @Size(max = 1045)
    private String attribute10;
    @Size(max = 25)
    private String insType;
     @Size(max = 25)
    private String contactYN;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taskId")
//    private Collection<SsInsTaskHistory> ssInsTaskHistoryCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue
    @Column(name = "taskId")
    private Integer taskId;
    
    @Column(name = "insEndDate")
    @Temporal(TemporalType.DATE)
    private Date insEndDate;
    @Column(name = "apptDate")
    @Temporal(TemporalType.DATE)
    private Date apptDate;
    @Column(name = "creationDt")
    @Temporal(TemporalType.DATE)
    private Date creationDt;
    @Column(name = "lstUpdDt")
    @Temporal(TemporalType.DATE)
    private Date lstUpdDt;
    @Column(name = "locId")
    private Integer locId;
    @Column(name = "orgId")
    private Integer orgId;
    
//    @JoinColumn(name = "vehicleNo_frk")
//    @ManyToOne(fetch = FetchType.LAZY ,cascade=CascadeType.ALL)
    private String vehicleNo;
    
    

    public SsInsTaskDetails() {
    }

    public SsInsTaskDetails(Integer taskId) {
        this.taskId = taskId;
    }

    public SsInsTaskDetails(Integer taskId, int custId, Date callDueDt, String eventStatus) {
        this.taskId = taskId;
        this.custId = custId;
        this.callDueDt = callDueDt;
        this.eventStatus = eventStatus;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }


    public Date getInsEndDate() {
        return insEndDate;
    }

    public void setInsEndDate(Date insEndDate) {
        this.insEndDate = insEndDate;
    }


    public Date getApptDate() {
        return apptDate;
    }

    public void setApptDate(Date apptDate) {
        this.apptDate = apptDate;
    }


    public Date getCreationDt() {
        return creationDt;
    }

    public void setCreationDt(Date creationDt) {
        this.creationDt = creationDt;
    }


    public Date getLstUpdDt() {
        return lstUpdDt;
    }

    public void setLstUpdDt(Date lstUpdDt) {
        this.lstUpdDt = lstUpdDt;
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

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }
   
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskId != null ? taskId.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsInsTaskDetails)) {
            return false;
        }
        SsInsTaskDetails other = (SsInsTaskDetails) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "com.sai.model.insurance.SsInsTaskDetails[ taskId=" + taskId + " ]";
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getCallDueDt() {
        return callDueDt;
    }

    public void setCallDueDt(Date callDueDt) {
        this.callDueDt = callDueDt;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getPrintRenewal() {
        return printRenewal;
    }

    public void setPrintRenewal(String printRenewal) {
        this.printRenewal = printRenewal;
    }

    public String getApptYN() {
        return apptYN;
    }

    public void setApptYN(String apptYN) {
        this.apptYN = apptYN;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getApptAddress() {
        return apptAddress;
    }

    public void setApptAddress(String apptAddress) {
        this.apptAddress = apptAddress;
    }

    public String getAssignId() {
        return assignId;
    }

    public void setAssignId(String assignId) {
        this.assignId = assignId;
    }

    public String getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(String custStatus) {
        this.custStatus = custStatus;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getLstUpdBy() {
        return lstUpdBy;
    }

    public void setLstUpdBy(Integer lstUpdBy) {
        this.lstUpdBy = lstUpdBy;
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

    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    public String getAttribute9() {
        return attribute9;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9;
    }

    public String getAttribute10() {
        return attribute10;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10;
    }

    public String getInsType() {
        return insType;
    }

    public void setInsType(String insType) {
        this.insType = insType;
    }

//    @XmlTransient
//    public Collection<SsInsTaskHistory> getSsInsTaskHistoryCollection() {
//        return ssInsTaskHistoryCollection;
//    }
//
//    public void setSsInsTaskHistoryCollection(Collection<SsInsTaskHistory> ssInsTaskHistoryCollection) {
//        this.ssInsTaskHistoryCollection = ssInsTaskHistoryCollection;
//    }

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

    public String getContactYN() {
        return contactYN;
    }

    public void setContactYN(String contactYN) {
        this.contactYN = contactYN;
    }
    
    
}
