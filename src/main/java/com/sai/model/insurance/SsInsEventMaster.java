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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Test
 */
@Entity
@Table(name = "ss_ins_event_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SsInsEventMaster.findAll", query = "SELECT s FROM SsInsEventMaster s")})
public class SsInsEventMaster implements Serializable {

    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 50)
    @Column(name = "eventName")
    private String eventName;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 45)
    @Column(name = "insType")
    private String insType;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "locId")
    private int locId;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 45)
    @Column(name = "callType")
    private String callType;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "whnToAction")
    private int whnToAction;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dataType")
    private String dataType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dataBasedOn")
    private String dataBasedOn;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "orgId")
    private int orgId;
    @Size(max = 500)
    @Column(name = "attribute1")
    private String attribute1;
    @Size(max = 500)
    @Column(name = "attribute2")
    private String attribute2;
    @Size(max = 500)
    @Column(name = "attribute3")
    private String attribute3;
    @Size(max = 500)
    @Column(name = "attribute4")
    private String attribute4;
    @Size(max = 500)
    @Column(name = "attribute5")
    private String attribute5;
    @Size(max = 500)
    @Column(name = "attribute6")
    private String attribute6;
    @Size(max = 500)
    @Column(name = "attribute7")
    private String attribute7;
    @Size(max = 500)
    @Column(name = "attribute8")
    private String attribute8;
    @Size(max = 500)
    @Column(name = "attribute9")
    private String attribute9;
    @Size(max = 500)
    @Column(name = "attribute10")
    private String attribute10;
    @Size(max = 45)
    @Column(name = "activeStatus")
    private String activeStatus;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "flwupLoc")
    private int flwupLoc;
    @Column(name = "statusEndDt")
    @Temporal(TemporalType.DATE)
    private Date statusEndDt;
    @Column(name = "createdBy")
    private Integer createdBy;
    @Column(name = "updatedBy")
    private Integer updatedBy;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eventId")
    private Integer eventId;
    @Column(name = "createdDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "updatedDate")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;

    public SsInsEventMaster() {
    }

    public SsInsEventMaster(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }



    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsInsEventMaster)) {
            return false;
        }
        SsInsEventMaster other = (SsInsEventMaster) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "com.sai.model.SsInsEventMaster[ eventId=" + eventId + " ]";
    }


    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }


    public int getFlwupLoc() {
        return flwupLoc;
    }

    public void setFlwupLoc(int flwupLoc) {
        this.flwupLoc = flwupLoc;
    }
    public Date getStatusEndDt() {
        return statusEndDt;
    }
    public void setStatusEndDt(Date statusEndDt) {
        this.statusEndDt = statusEndDt;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getInsType() {
        return insType;
    }

    public void setInsType(String insType) {
        this.insType = insType;
    }

    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public int getWhnToAction() {
        return whnToAction;
    }

    public void setWhnToAction(int whnToAction) {
        this.whnToAction = whnToAction;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataBasedOn() {
        return dataBasedOn;
    }

    public void setDataBasedOn(String dataBasedOn) {
        this.dataBasedOn = dataBasedOn;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
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

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }
    
}
