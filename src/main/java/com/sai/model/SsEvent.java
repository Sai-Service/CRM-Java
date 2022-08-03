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
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
/**
 *
 * @author Test
 */
@Entity
@NamedNativeQuery(name = "SsEvent.findForSearch", query = "select * from ss_event where service_type = ?1 AND active_status='ACTIVE'", resultClass = SsEvent.class)

@Table(name = "ss_event")
public class SsEvent implements Serializable{
 //    @Id
 //   @javax.persistence.Id
 //   @Column(name = "EVENT_ID")
 //   private long eventId;
     
     @Id
    @GeneratedValue
    @Column(name = "EVENT_ID")
    private long eventId=1L;
     
    
    @Column(name = "EVENT_NAME")
    private  String eventName;
    
    @Column(name = "SERVICE_TYPE")
    private  String serType;

    @Column(name = "SUB_CATEGORY")
    private String subCategory;
    
    @Column(name = "TYPE")
    private  String type;
    
    @Column(name = "WHEN_TO_ACTION")
    private  long whenToAct;
    
    @Column(name = "DAYS_AFTER_DELIVERY")
    private  long dayAftDelv;
        
    @Column(name = "KMS_DUE")
    private  long kmsDue;
            
    @Column(name = "SERVICE_LOCATION")
    private  String servLocation;
    
    @Column(name = "SS_CALL_DT_BASED_ON")
    private  String ssCallDtBsOn;
    
     @Column(name = "SS_SERVICE_DT_BASED_ON")
    private  String ssServDtBsOn;
    
    @Column(name = "DEPT")
    private  String dept;
        
    @Column(name = "MODEL")
    private  String model;
            
    @Column(name = "COLOR")
    private  String color;
    
    @Column(name = "ACTIVE_STATUS")
    private  String activeStatus;
        
        
    @Column(name = "LOC_ID")
    private  long locId;
        
    @Column(name = "ORG_ID")
    private  long orgId;
            
    @Column(name = "CREATED_BY")
    private  long createdBy;
    
    @Column(name = "CREATION_DATE")
    private  Date creationDt;
    
    @Column(name = "LAST_UPDATED_BY")
    private  long lstUpBy;
    
    @Column(name = "LAST_UPDATION_DATE")
    private Date lstUpDt;
    
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
        
    @Column(name = "INACTIVE_DATE")
    private  Date inactiveDate; 
    
     @Column(name = "FUEL_TYPE")
    private  String fuelType; 
     
    public SsEvent()
    {
        
    }

    public SsEvent(String eventName, String serType, String subCategory, String type, long whenToAct, long dayAftDelv, long kmsDue, String servLocation, String ssCallDtBsOn, String ssServDtBsOn, String dept, String model, String color, String activeStatus, long locId, long orgId, long createdBy, Date creationDt, long lstUpBy, Date lstUpDt, String attribute1, String attribute2, String attribute3, String attribute4, String attribute5, Date inactiveDate, String fuelType) {
        this.eventName = eventName;
        this.serType = serType;
        this.subCategory = subCategory;
        this.type = type;
        this.whenToAct = whenToAct;
        this.dayAftDelv = dayAftDelv;
        this.kmsDue = kmsDue;
        this.servLocation = servLocation;
        this.ssCallDtBsOn = ssCallDtBsOn;
        this.ssServDtBsOn = ssServDtBsOn;
        this.dept = dept;
        this.model = model;
        this.color = color;
        this.activeStatus = activeStatus;
        this.locId = locId;
        this.orgId = orgId;
        this.createdBy = createdBy;
        this.creationDt = creationDt;
        this.lstUpBy = lstUpBy;
        this.lstUpDt = lstUpDt;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
        this.inactiveDate = inactiveDate;
        this.fuelType = fuelType;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getSerType() {
        return serType;
    }

    public void setSerType(String serType) {
        this.serType = serType;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getWhenToAct() {
        return whenToAct;
    }

    public void setWhenToAct(long whenToAct) {
        this.whenToAct = whenToAct;
    }

    public long getDayAftDelv() {
        return dayAftDelv;
    }

    public void setDayAftDelv(long dayAftDelv) {
        this.dayAftDelv = dayAftDelv;
    }

    public long getKmsDue() {
        return kmsDue;
    }

    public void setKmsDue(long kmsDue) {
        this.kmsDue = kmsDue;
    }

    public String getServLocation() {
        return servLocation;
    }

    public void setServLocation(String servLocation) {
        this.servLocation = servLocation;
    }

    public String getSsCallDtBsOn() {
        return ssCallDtBsOn;
    }

    public void setSsCallDtBsOn(String ssCallDtBsOn) {
        this.ssCallDtBsOn = ssCallDtBsOn;
    }

    public String getSsServDtBsOn() {
        return ssServDtBsOn;
    }

    public void setSsServDtBsOn(String ssServDtBsOn) {
        this.ssServDtBsOn = ssServDtBsOn;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public long getLocId() {
        return locId;
    }

    public void setLocId(long locId) {
        this.locId = locId;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
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

    public Date getLstUpDt() {
        return lstUpDt;
    }

    public void setLstUpDt(Date lstUpDt) {
        this.lstUpDt = lstUpDt;
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

    public Date getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(Date inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

   
    
   
}
