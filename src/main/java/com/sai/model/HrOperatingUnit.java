/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
/**
 *
 * @author Test
 */

@Entity
@Table(name = "hr_operating_units")

@NamedNativeQuery(name = "HROperatingUnit.findByOrgId", query = "select * from hr_operating_units where org_id = ?1 and active_status='ACTIVE'", resultClass = HrOperatingUnit.class)
@NamedNativeQueries(value = {
@NamedNativeQuery(name = "HROperatingUnit.findByPanNo", query = "select * from hr_operating_units where pan_number = ?1" , resultClass = HrOperatingUnit.class) })

public class HrOperatingUnit  implements Serializable{
    
    @Id
    @javax.persistence.Id
    @Column(name = "ORG_ID")
    private long orgId;
    
    @Column(name = "ORGANIZATION_NAME")
    private  String orgName;
    
    @Column(name = "DESCRIPTION")
    private  String description;

    @Column(name = "ADDRESS1")
    private String address1;
    
    @Column(name = "ADDRESS2")
    private  String address2;
    
    @Column(name = "PINCODE")
    private  long pinCode;
    
    @Column(name = "CITY")
    private String city;
    
    @Column(name = "STATE")
    private  String state;
    
    @Column(name = "COUNTRY")
    private String country;
    
    @Column(name = "EMAIL_ADDRESS")
    private  String emailId;
    
    @Column(name = "GSTN_NUMBER")
    private  String gstnNo;
    
    @Column(name = "PAN_NUMBER")
    private  String panNo;
    
    @Column(name = "CREATION_DATE")
    private  Date creationDt;
    
    @Column(name = "CREATED_BY")
    private  long createdBy;
        
    @Column(name = "LAST_UPDATION_DATE")
    private  Date lstUpDate;
    
    @Column(name = "LAST_UPDATED_BY")
    private  long lstUpBy;
    
    @Column(name = "ACTIVE_STATUS")
    private  String activeStatus;
    
    @JsonFormat(pattern="yyyy-MM-dd")
     @Column(name = "INACTIVE_DATE")
    private  Date inactiveDate;
    
//     @JsonProperty("cmpny_code")
     @Column(name = "COMPANY_CODE")
    private  String cmpnyCode;
      
  
    public HrOperatingUnit()
    {
        
    }
  
    
   
    
  /*     @Override
    public String toString() {
        return "HrOperatingUnit [orgId=" + orgId + ", orgName=" + orgName + ", description=" + description + ", address1=" + address1 +
            ", address2=" + address2 + ", pinCode=" + pinCode + ", city=" + city + ", state=" + state + ", country=" + country + ", emailId=" + emailId + ", gstnNo=" + gstnNo + ""
                + ", panNo=" + panNo + ", creationDt=" + creationDt + ", createdBy=" + createdBy + ", lstUpDate=" + lstUpDate + ", lstUpBy=" + lstUpBy + "]";
    }*/

    public HrOperatingUnit(long orgId, String orgName, String description, String address1, String address2, long pinCode, String city, String state, String country, String emailId, String gstnNo, String panNo, Date creationDt, long createdBy, Date lstUpDate, long lstUpBy, String activeStatus, Date inactiveDt, String cmpnyCode) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.description = description;
        this.address1 = address1;
        this.address2 = address2;
        this.pinCode = pinCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.emailId = emailId;
        this.gstnNo = gstnNo;
        this.panNo = panNo;
        this.creationDt = creationDt;
        this.createdBy = createdBy;
        this.lstUpDate = lstUpDate;
        this.lstUpBy = lstUpBy;
        this.activeStatus = activeStatus;
        this.inactiveDate = inactiveDt;
        this.cmpnyCode = cmpnyCode;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getGstnNo() {
        return gstnNo;
    }

    public void setGstnNo(String gstnNo) {
        this.gstnNo = gstnNo;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
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

    public Date getLstUpDate() {
        return lstUpDate;
    }

    public void setLstUpDate(Date lstUpDate) {
        this.lstUpDate = lstUpDate;
    }

    public long getLstUpBy() {
        return lstUpBy;
    }

    public void setLstUpBy(long lstUpBy) {
        this.lstUpBy = lstUpBy;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Date getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(Date inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

   

    public String getCmpnyCode() {
        return cmpnyCode;
    }

    public void setCmpnyCode(String cmpnyCode) {
        this.cmpnyCode = cmpnyCode;
    }

    
    
}
