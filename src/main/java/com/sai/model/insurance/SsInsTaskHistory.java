/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model.insurance;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "ss_ins_task_history")
public class SsInsTaskHistory implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String contactYN;
    
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date contactedDate;
    
    @Size(max = 245)
    private String disposition;
    @Size(max = 1045)
    private String remark;
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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    
    @Column(name = "nxtFollowupDate")
    @Temporal(TemporalType.DATE)
    private Date nxtFollowupDate;
    @Column(name = "creationDate")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    
    @Column(name = "createdBy")
    private Integer createdBy;
    
    @Column(name = "lstUpdatedDate")
    @Temporal(TemporalType.DATE)
    private Date lstUpdatedDate;
    
    @Column(name = "lstUpdatedBy")
    private Integer lstUpdatedBy;
    
    
    @JoinColumn(name = "taskId", referencedColumnName = "taskId")
    @ManyToOne(optional = false)
    private SsInsTaskDetails taskId;

    public SsInsTaskHistory() {
    }

    public SsInsTaskHistory(Integer id) {
        this.id = id;
    }

    public SsInsTaskHistory(Integer id, String contactYN, Date contactedDate) {
        this.id = id;
        this.contactYN = contactYN;
        this.contactedDate = contactedDate;
    }


    public SsInsTaskHistory(String contactYN, Date currentDate, String disposition, String remark, Date callDueDt, SsInsTaskDetails insTaskDetails) {
        this.contactYN = contactYN;
        this.contactedDate = currentDate;
        this.disposition = disposition;
        this.remark = remark;
        this.nxtFollowupDate = callDueDt;
        this.taskId =insTaskDetails;
        
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getNxtFollowupDate() {
        return nxtFollowupDate;
    }

    public void setNxtFollowupDate(Date nxtFollowupDate) {
        this.nxtFollowupDate = nxtFollowupDate;
    }


    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLstUpdatedDate() {
        return lstUpdatedDate;
    }

    public void setLstUpdatedDate(Date lstUpdatedDate) {
        this.lstUpdatedDate = lstUpdatedDate;
    }

    public Integer getLstUpdatedBy() {
        return lstUpdatedBy;
    }

    public void setLstUpdatedBy(Integer lstUpdatedBy) {
        this.lstUpdatedBy = lstUpdatedBy;
    }
    public SsInsTaskDetails getTaskId() {
        return taskId;
    }
    public void setTaskId(SsInsTaskDetails taskId) {
        this.taskId = taskId;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsInsTaskHistory)) {
            return false;
        }
        SsInsTaskHistory other = (SsInsTaskHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "com.sai.model.insurance.SsInsTaskHistory[ id=" + id + " ]";
    }

    public String getContactYN() {
        return contactYN;
    }

    public void setContactYN(String contactYN) {
        this.contactYN = contactYN;
    }

    public Date getContactedDate() {
        return contactedDate;
    }

    public void setContactedDate(Date contactedDate) {
        this.contactedDate = contactedDate;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
    
}
