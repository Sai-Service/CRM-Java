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
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;
/**
 *
 * @author Test
 */
@Entity
@NamedNativeQuery(name = "SsLocation.findByOrgId", query = "select * from ss_location where org_id = ?1 and status='ACTIVE'", resultClass = SsLocation.class)

@Table(name = "ss_location")

public class SsLocation implements Serializable{
        
     @Id
    @javax.persistence.Id
    @Column(name = "LOC_ID")
    private long locId;
    
    @Column(name = "LOC_NAME")
    private  String locName;
    
    @Column(name = "LOC_DESC")
    private  String locDesc;

    @Column(name = "ADDRESS1")
    private String address1;
    
    @Column(name = "ADDRESS2")
    private  String address2;
    
    @Column(name = "LOCATION")
    private  String location;

    @Column(name = "PINCODE")
    private long pinCode;
    
    @Column(name = "CITY")
    private  String city;
    
    @Column(name = "STATE_NAME")
    private  String stateName;

    @Column(name = "COUNTRY")
    private String country;
    
    @Column(name = "CONTACT_NO")
    private  long contactNo;
    
    @Column(name = "EMAIL_ID")
    private  String emailId;

    @Column(name = "CREATED_BY")
    private long createdBy;
    
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
   
     @Column(name = "ORG_ID")
    private  long orgId;       
    
     @Column(name = "STATUS")
    private  String status;       
    
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "INACTIVE_DATE")
    private  Date inactiveDate;       
    
    @Column(name = "REGION")
    private  String region;    
     
    public SsLocation()
    {
        
    }

    public SsLocation(long locId, String locName, String locDesc, String address1, String address2, String location, long pinCode, String city, String stateName, String country, long contactNo, String emailId, long createdBy, Date creationDt, long lstUpBy, Date lstUpDate, String attribute1, String attribute2, String attribute3, String attribute4, String attribute5, long orgId, String status, Date inactiveDate, String region) {
        this.locId = locId;
        this.locName = locName;
        this.locDesc = locDesc;
        this.address1 = address1;
        this.address2 = address2;
        this.location = location;
        this.pinCode = pinCode;
        this.city = city;
        this.stateName = stateName;
        this.country = country;
        this.contactNo = contactNo;
        this.emailId = emailId;
        this.createdBy = createdBy;
        this.creationDt = creationDt;
        this.lstUpBy = lstUpBy;
        this.lstUpDate = lstUpDate;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
        this.orgId = orgId;
        this.status = status;
        this.inactiveDate = inactiveDate;
        this.region = region;
    }

    public long getLocId() {
        return locId;
    }

    public void setLocId(long locId) {
        this.locId = locId;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getLocDesc() {
        return locDesc;
    }

    public void setLocDesc(String locDesc) {
        this.locDesc = locDesc;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getPinCode() {
        return pinCode;
    }

    public void setPinCode(long pinCode) {
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

   
    
    
}
