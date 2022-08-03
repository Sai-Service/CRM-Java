/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

/**
 *
 * @author Test
 */
@Entity
@NamedNativeQuery(name = "SsSlotAvailable.findByLocId", query = "select * from ss_slot_available where serv_loc_id = ?1 and timing=?2 and service_date=curdate() and valid='Y'", resultClass = SsSlotAvailable.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "ss_slot_available")
public class SsSlotAvailable implements Serializable {

    @Id
    @javax.persistence.Id
    @Column(name = "SLOT_ID")
    private long slotId;

    @Column(name = "ORG_ID")
    private long orgId;

    @Column(name = "SERV_LOC_ID")
    private long serLocId;

    @Column(name = "SERV_LOC_NAME")
    private String servLocName;

    @Column(name = "TIMING")
    private String timing;

    @Column(name = "QUOTA")
    private long quota;

    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(name = "SERVICE_DATE")
    private Date serviceDate;

    @Column(name = "VALID")
    private String valid;

    @Column(name = "CREATED_BY")
    private long createdBy;

    @Column(name = "CREATION_DATE")
    private Date creationDt;

    @Column(name = "LAST_UPDATED_BY")
    private long lstUpBy;

    @Column(name = "LAST_UPDATION_DATE")
    private Date lstUpDate;

    @Column(name = "ATTRIBUTE1")
    private String attribute1;

    @Column(name = "ATTRIBUTE2")
    private String attribute2;

    public SsSlotAvailable() {

    }

    public SsSlotAvailable(long slotId, long orgId, long serLocId, String servLocName, String timing, long quota, Date serviceDate, String valid, long createdBy, Date creationDt, long lstUpBy, Date lstUpDate, String attribute1, String attribute2) {

        this.slotId = slotId;
        this.orgId = orgId;
        this.serLocId = serLocId;
        this.servLocName = servLocName;
        this.timing = timing;
        this.quota = quota;
        this.serviceDate = serviceDate;
        this.valid = valid;
        this.createdBy = createdBy;
        this.creationDt = creationDt;
        this.lstUpBy = lstUpBy;
        this.lstUpDate = lstUpDate;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;

    }

    public long getSlotId() {
        return slotId;
    }

    public void setSlotId(long slotId) {
        this.slotId = slotId;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public long getSerLocId() {
        return serLocId;
    }

    public void setSerLocId(long serLocId) {
        this.serLocId = serLocId;
    }

    public String getServLocName() {
        return servLocName;
    }

    public void setServLocName(String servLocName) {
        this.servLocName = servLocName;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public long getQuota() {
        return quota;
    }

    public void setQuota(long quota) {
        this.quota = quota;
    }

    public Date getserviceDate() {
        return serviceDate;
    }

    public void setserviceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
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

}
