/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

import java.io.Serializable;
import java.math.BigInteger;
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

@Entity
@Table(name = "ss_customer")

public class SsCustomer implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "INPUT_TYPE")
    private String inputType;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "CUST_ID")
    private int custId;
    private int custAcctNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 145)
    @Column(name = "CUST_NAME")
    private String custName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CUST_TYPE")
    private String custType;
    @Size(max = 245)
    private String address1;
    @Size(max = 245)
    private String address2;
    @Size(max = 245)
    private String address3;
    @Size(max = 45)
    private String location;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 45)
    private String city;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 45)
    @Column(name = "STATE_NAME")
    private String stateName;
    @Size(max = 45)
    private String country;
    @Size(max = 45)
    @Column(name = "CONTACT_NO2")
    private String contactNo2;
    @Size(max = 415)
    @Column(name = "EMAIL_ID")
    private String emailId;
    @Size(max = 45)
    private String status;
    @Size(max = 545)
    private String attribute1;
    @Size(max = 545)
    private String attribute2;
    @Size(max = 545)
    private String attribute3;
    @Size(max = 545)
    private String attribute4;
    @Size(max = 545)
    private String attribute5;
    @Size(max = 545)
    private String attribute6;
    @Size(max = 545)
    private String attribute7;
    @Size(max = 545)
    private String attribute8;
    @Size(max = 545)
    private String attribute9;
    @Size(max = 545)
    private String attribute10;
    @Size(max = 1005)
    @Column(name = "SSCOR_ADDRESS")
    private String sscorAddress;
    @Size(max = 45)
    @Column(name = "CONTACT_NO3")
    private String contactNo3;
    @Temporal(TemporalType.DATE)
    private Date dob;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PINCODE")
    private Integer pincode;
    @Column(name = "CONTACT_NO1")
    private BigInteger contactNo1;
    @Column(name = "CREATED_BY")
    private Integer createdBy;
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Column(name = "LAST_UPDATED_BY")
    private Integer lastUpdatedBy;
    @Column(name = "LAST_UPDATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastUpdationDate;
    @Size(max = 1005)
    @Column(name = "ssCorrespondAddress")
    private String ssCorrespondAddress;

    public SsCustomer() {
    }

    public SsCustomer(Integer id) {
        this.id = id;
    }

    public SsCustomer(Integer id, String inputType, int custId, String custName, String custType) {
        this.id = id;
        this.inputType = inputType;
        this.custId = custId;
        this.custName = custName;
        this.custType = custType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getCustAcctNo() {
        return custAcctNo;
    }

    public void setCustAcctNo(int custAcctNo) {
        this.custAcctNo = custAcctNo;
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


    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }


    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }


    public BigInteger getContactNo1() {
        return contactNo1;
    }

    public void setContactNo1(BigInteger contactNo1) {
        this.contactNo1 = contactNo1;
    }

    public String getContactNo2() {
        return contactNo2;
    }

    public void setContactNo2(String contactNo2) {
        this.contactNo2 = contactNo2;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdationDate() {
        return lastUpdationDate;
    }

    public void setLastUpdationDate(Date lastUpdationDate) {
        this.lastUpdationDate = lastUpdationDate;
    }
    public String getSsCorrespondAddress() {
        return ssCorrespondAddress;
    }
    public void setSsCorrespondAddress(String ssCorrespondAddress) {
        this.ssCorrespondAddress = ssCorrespondAddress;
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
        if (!(object instanceof SsCustomer)) {
            return false;
        }
        SsCustomer other = (SsCustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "com.sai.model.SsCustomer[ id=" + id + " ]";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getSscorAddress() {
        return sscorAddress;
    }

    public void setSscorAddress(String sscorAddress) {
        this.sscorAddress = sscorAddress;
    }

    public String getContactNo3() {
        return contactNo3;
    }

    public void setContactNo3(String contactNo3) {
        this.contactNo3 = contactNo3;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    
}
