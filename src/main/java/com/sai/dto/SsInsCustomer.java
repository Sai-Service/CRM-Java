/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Swaroopcomp
 */
public class SsInsCustomer {
    
@JsonProperty("custId")
private Integer custId;
@JsonProperty("miNo")
private String miNo;
@JsonProperty("insCompName")
private String insCompName;
@JsonProperty("policyNo")
private String policyNo;
@JsonProperty("year")
private Integer year;
@JsonProperty("insType")
private String insType;
@JsonProperty("idvAmt")
private String idvAmt;
@JsonProperty("prmAmt")
private String prmAmt;
@JsonProperty("claimAmt")
private String claimAmt;
@JsonProperty("remark")
private String remark;
@JsonProperty("financeCompName")
private String financeCompName;
@JsonProperty("policyType")
private String policyType;
@JsonProperty("exShowPrice")
private String exShowPrice;
@JsonProperty("endorsementTaken")
private String endorsementTaken;
@JsonProperty("policyRenewType")
private String policyRenewType;
@JsonProperty("policySubType")
private String policySubType;
@JsonProperty("dealerName")
private String dealerName;
@JsonProperty("currentNCB")
private String currentNCB;
@JsonProperty("autoMembership")
private String autoMembership;
@JsonProperty("autoMembPremium")
private String autoMembPremium;
@JsonProperty("driverCover")
private String driverCover;
@JsonProperty("legalLibNoPer")
private String legalLibNoPer;
@JsonProperty("driverCoverPremium")
private String driverCoverPremium;
@JsonProperty("typeOfCustomer")
private String typeOfCustomer;
@JsonProperty("paymentMode")
private String paymentMode;
@JsonProperty("accountNo")
private String accountNo;
@JsonProperty("bankBranch")
private String bankBranch;
@JsonProperty("bankName")
private String bankName;
@JsonProperty("status")
private String status;
@JsonProperty("orgId")
private Integer orgId;
@JsonProperty("locId")
private Integer locId;
@JsonProperty("id")
private Integer id;
@JsonProperty("vehicleNo")
private String vehicleNo;
@JsonProperty("insStDate")
private Date insStDate;
@JsonProperty("insPeriod")
private Integer insPeriod;
@JsonProperty("insEndDt")
private Date insEndDt;
@JsonProperty("claimCount")
private Integer claimCount;
@JsonProperty("remittanceDate")
private Date remittanceDate;
@JsonProperty("paymentAmt")
private Float paymentAmt;
@JsonProperty("paymentDate")
private Date paymentDate;
@JsonProperty("inactiveDate")
private Date inactiveDate;
@JsonProperty("creationDt")
private Date creationDt;
@JsonProperty("createdBy")
private Integer createdBy;
@JsonProperty("lstUpdationDt")
private Date lstUpdationDt;
@JsonProperty("lstUpdatedby")
private Integer lstUpdatedby;

//customer
@JsonProperty("pincode")
private Integer pincode;
@JsonProperty("contactNo1")
private String contactNo1;
@JsonProperty("createdBy")

private Integer lastUpdatedBy;

@JsonProperty("inputType")
private String inputType;
@JsonProperty("custName")
private String custName;
@JsonProperty("custType")
private String custType;
@JsonProperty("address1")
private String address1;
@JsonProperty("address2")
private String address2;
@JsonProperty("address3")
private String address3;
@JsonProperty("location")
private String location;
@JsonProperty("city")
private String city;
@JsonProperty("stateName")
private String stateName;
@JsonProperty("country")
private String country;
@JsonProperty("contactNo2")
private String contactNo2;
@JsonProperty("emailId")
private String emailId;

@JsonProperty("lstUpDate")
private String lstUpDate;
@JsonProperty("vehicleNo")

private String chassisNo;

@JsonProperty("engineNo")
private String engineNo;
@JsonProperty("model")
private String model;
@JsonProperty("dealerCd")
private String dealerCd;
@JsonProperty("dtOfPurchase")
private Date dtOfPurchase;
@JsonProperty("contactPerson")
private Object contactPerson;
@JsonProperty("contactPerNo")
private Object contactPerNo;

@JsonProperty("taskId")
private Integer taskId;

@JsonProperty("eventName")
private String eventName;

@JsonProperty("eventStatus")
private String eventStatus;

@JsonProperty("custStatus")
private String custStatus;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(String custStatus) {
        this.custStatus = custStatus;
    }




@JsonProperty("custId")
public Integer getCustId() {
return custId;
}

@JsonProperty("custId")
public void setCustId(Integer custId) {
this.custId = custId;
}

@JsonProperty("miNo")
public String getMiNo() {
return miNo;
}

@JsonProperty("miNo")
public void setMiNo(String miNo) {
this.miNo = miNo;
}

@JsonProperty("insCompName")
public String getInsCompName() {
return insCompName;
}

@JsonProperty("insCompName")
public void setInsCompName(String insCompName) {
this.insCompName = insCompName;
}

@JsonProperty("policyNo")
public String getPolicyNo() {
return policyNo;
}

@JsonProperty("policyNo")
public void setPolicyNo(String policyNo) {
this.policyNo = policyNo;
}

@JsonProperty("year")
public Integer getYear() {
return year;
}

@JsonProperty("year")
public void setYear(Integer year) {
this.year = year;
}

@JsonProperty("insType")
public String getInsType() {
return insType;
}

@JsonProperty("insType")
public void setInsType(String insType) {
this.insType = insType;
}

@JsonProperty("idvAmt")
public String getIdvAmt() {
return idvAmt;
}

@JsonProperty("idvAmt")
public void setIdvAmt(String idvAmt) {
this.idvAmt = idvAmt;
}

@JsonProperty("prmAmt")
public String getPrmAmt() {
return prmAmt;
}

@JsonProperty("prmAmt")
public void setPrmAmt(String prmAmt) {
this.prmAmt = prmAmt;
}

@JsonProperty("claimAmt")
public String getClaimAmt() {
return claimAmt;
}

@JsonProperty("claimAmt")
public void setClaimAmt(String claimAmt) {
this.claimAmt = claimAmt;
}

@JsonProperty("remark")
public String getRemark() {
return remark;
}

@JsonProperty("remark")
public void setRemark(String remark) {
this.remark = remark;
}

@JsonProperty("financeCompName")
public String getFinanceCompName() {
return financeCompName;
}

@JsonProperty("financeCompName")
public void setFinanceCompName(String financeCompName) {
this.financeCompName = financeCompName;
}

@JsonProperty("policyType")
public String getPolicyType() {
return policyType;
}

@JsonProperty("policyType")
public void setPolicyType(String policyType) {
this.policyType = policyType;
}

@JsonProperty("exShowPrice")
public String getExShowPrice() {
return exShowPrice;
}

@JsonProperty("exShowPrice")
public void setExShowPrice(String exShowPrice) {
this.exShowPrice = exShowPrice;
}

@JsonProperty("endorsementTaken")
public String getEndorsementTaken() {
return endorsementTaken;
}

@JsonProperty("endorsementTaken")
public void setEndorsementTaken(String endorsementTaken) {
this.endorsementTaken = endorsementTaken;
}

@JsonProperty("policyRenewType")
public String getPolicyRenewType() {
return policyRenewType;
}

@JsonProperty("policyRenewType")
public void setPolicyRenewType(String policyRenewType) {
this.policyRenewType = policyRenewType;
}

@JsonProperty("policySubType")
public String getPolicySubType() {
return policySubType;
}

@JsonProperty("policySubType")
public void setPolicySubType(String policySubType) {
this.policySubType = policySubType;
}

@JsonProperty("dealerName")
public String getDealerName() {
return dealerName;
}

@JsonProperty("dealerName")
public void setDealerName(String dealerName) {
this.dealerName = dealerName;
}

@JsonProperty("currentNCB")
public String getCurrentNCB() {
return currentNCB;
}

@JsonProperty("currentNCB")
public void setCurrentNCB(String currentNCB) {
this.currentNCB = currentNCB;
}

@JsonProperty("autoMembership")
public String getAutoMembership() {
return autoMembership;
}

@JsonProperty("autoMembership")
public void setAutoMembership(String autoMembership) {
this.autoMembership = autoMembership;
}

@JsonProperty("autoMembPremium")
public String getAutoMembPremium() {
return autoMembPremium;
}

@JsonProperty("autoMembPremium")
public void setAutoMembPremium(String autoMembPremium) {
this.autoMembPremium = autoMembPremium;
}

@JsonProperty("driverCover")
public String getDriverCover() {
return driverCover;
}

@JsonProperty("driverCover")
public void setDriverCover(String driverCover) {
this.driverCover = driverCover;
}

@JsonProperty("legalLibNoPer")
public String getLegalLibNoPer() {
return legalLibNoPer;
}

@JsonProperty("legalLibNoPer")
public void setLegalLibNoPer(String legalLibNoPer) {
this.legalLibNoPer = legalLibNoPer;
}

@JsonProperty("driverCoverPremium")
public String getDriverCoverPremium() {
return driverCoverPremium;
}

@JsonProperty("driverCoverPremium")
public void setDriverCoverPremium(String driverCoverPremium) {
this.driverCoverPremium = driverCoverPremium;
}

@JsonProperty("typeOfCustomer")
public String getTypeOfCustomer() {
return typeOfCustomer;
}

@JsonProperty("typeOfCustomer")
public void setTypeOfCustomer(String typeOfCustomer) {
this.typeOfCustomer = typeOfCustomer;
}

@JsonProperty("paymentMode")
public String getPaymentMode() {
return paymentMode;
}

@JsonProperty("paymentMode")
public void setPaymentMode(String paymentMode) {
this.paymentMode = paymentMode;
}

@JsonProperty("accountNo")
public String getAccountNo() {
return accountNo;
}

@JsonProperty("accountNo")
public void setAccountNo(String accountNo) {
this.accountNo = accountNo;
}

@JsonProperty("bankBranch")
public String getBankBranch() {
return bankBranch;
}

@JsonProperty("bankBranch")
public void setBankBranch(String bankBranch) {
this.bankBranch = bankBranch;
}

@JsonProperty("bankName")
public String getBankName() {
return bankName;
}

@JsonProperty("bankName")
public void setBankName(String bankName) {
this.bankName = bankName;
}

@JsonProperty("status")
public String getStatus() {
return status;
}

@JsonProperty("status")
public void setStatus(String status) {
this.status = status;
}

@JsonProperty("orgId")
public Integer getOrgId() {
return orgId;
}

@JsonProperty("orgId")
public void setOrgId(Integer orgId) {
this.orgId = orgId;
}

@JsonProperty("locId")
public Integer getLocId() {
return locId;
}

@JsonProperty("locId")
public void setLocId(Integer locId) {
this.locId = locId;
}

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("vehicleNo")
public String getVehicleNo() {
return vehicleNo;
}

@JsonProperty("vehicleNo")
public void setVehicleNo(String vehicleNo) {
this.vehicleNo = vehicleNo;
}

@JsonProperty("insStDate")
public Date getInsStDate() {
return insStDate;
}

@JsonProperty("insStDate")
public void setInsStDate(Date insStDate) {
this.insStDate = insStDate;
}

@JsonProperty("insPeriod")
public Integer getInsPeriod() {
return insPeriod;
}

@JsonProperty("insPeriod")
public void setInsPeriod(Integer insPeriod) {
this.insPeriod = insPeriod;
}

@JsonProperty("insEndDt")
public Date getInsEndDt() {
return insEndDt;
}

@JsonProperty("insEndDt")
public void setInsEndDt(Date insEndDt) {
this.insEndDt = insEndDt;
}

@JsonProperty("claimCount")
public Integer getClaimCount() {
return claimCount;
}

@JsonProperty("claimCount")
public void setClaimCount(Integer claimCount) {
this.claimCount = claimCount;
}

@JsonProperty("remittanceDate")
public Date getRemittanceDate() {
return remittanceDate;
}

@JsonProperty("remittanceDate")
public void setRemittanceDate(Date remittanceDate) {
this.remittanceDate = remittanceDate;
}

@JsonProperty("paymentAmt")
public Float getPaymentAmt() {
return paymentAmt;
}

@JsonProperty("paymentAmt")
public void setPaymentAmt(Float paymentAmt) {
this.paymentAmt = paymentAmt;
}

@JsonProperty("paymentDate")
public Date getPaymentDate() {
return paymentDate;
}

@JsonProperty("paymentDate")
public void setPaymentDate(Date paymentDate) {
this.paymentDate = paymentDate;
}

@JsonProperty("inactiveDate")
public Date getInactiveDate() {
return inactiveDate;
}

@JsonProperty("inactiveDate")
public void setInactiveDate(Date inactiveDate) {
this.inactiveDate = inactiveDate;
}

@JsonProperty("creationDt")
public Date getCreationDt() {
return creationDt;
}

@JsonProperty("creationDt")
public void setCreationDt(Date creationDt) {
this.creationDt = creationDt;
}

@JsonProperty("createdBy")
public Integer getCreatedBy() {
return createdBy;
}

@JsonProperty("createdBy")
public void setCreatedBy(Integer createdBy) {
this.createdBy = createdBy;
}

@JsonProperty("lstUpdationDt")
public Date getLstUpdationDt() {
return lstUpdationDt;
}

@JsonProperty("lstUpdationDt")
public void setLstUpdationDt(Date lstUpdationDt) {
this.lstUpdationDt = lstUpdationDt;
}

@JsonProperty("lstUpdatedby")
public Integer getLstUpdatedby() {
return lstUpdatedby;
}

@JsonProperty("lstUpdatedby")
public void setLstUpdatedby(Integer lstUpdatedby) {
this.lstUpdatedby = lstUpdatedby;
}

@JsonProperty("pincode")
public Integer getPincode() {
return pincode;
}

@JsonProperty("pincode")
public void setPincode(Integer pincode) {
this.pincode = pincode;
}

@JsonProperty("contactNo1")
public String getContactNo1() {
return contactNo1;
}

@JsonProperty("contactNo1")
public void setContactNo1(String contactNo1) {
this.contactNo1 = contactNo1;
}



@JsonProperty("lastUpdatedBy")
public Integer getLastUpdatedBy() {
return lastUpdatedBy;
}

@JsonProperty("lastUpdatedBy")
public void setLastUpdatedBy(Integer lastUpdatedBy) {
this.lastUpdatedBy = lastUpdatedBy;
}

@JsonProperty("inputType")
public String getInputType() {
return inputType;
}

@JsonProperty("inputType")
public void setInputType(String inputType) {
this.inputType = inputType;
}

@JsonProperty("custName")
public String getCustName() {
return custName;
}

@JsonProperty("custName")
public void setCustName(String custName) {
this.custName = custName;
}

@JsonProperty("custType")
public String getCustType() {
return custType;
}

@JsonProperty("custType")
public void setCustType(String custType) {
this.custType = custType;
}

@JsonProperty("address1")
public String getAddress1() {
return address1;
}

@JsonProperty("address1")
public void setAddress1(String address1) {
this.address1 = address1;
}

@JsonProperty("address2")
public String getAddress2() {
return address2;
}

@JsonProperty("address2")
public void setAddress2(String address2) {
this.address2 = address2;
}

@JsonProperty("address3")
public String getAddress3() {
return address3;
}

@JsonProperty("address3")
public void setAddress3(String address3) {
this.address3 = address3;
}

@JsonProperty("location")
public String getLocation() {
return location;
}

@JsonProperty("location")
public void setLocation(String location) {
this.location = location;
}

@JsonProperty("city")
public String getCity() {
return city;
}

@JsonProperty("city")
public void setCity(String city) {
this.city = city;
}

@JsonProperty("stateName")
public String getStateName() {
return stateName;
}

@JsonProperty("stateName")
public void setStateName(String stateName) {
this.stateName = stateName;
}

@JsonProperty("country")
public String getCountry() {
return country;
}

@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

@JsonProperty("contactNo2")
public String getContactNo2() {
return contactNo2;
}

@JsonProperty("contactNo2")
public void setContactNo2(String contactNo2) {
this.contactNo2 = contactNo2;
}

@JsonProperty("emailId")
public String getEmailId() {
return emailId;
}

@JsonProperty("emailId")
public void setEmailId(String emailId) {
this.emailId = emailId;
}


@JsonProperty("lstUpDate")
public String getLstUpDate() {
return lstUpDate;
}

@JsonProperty("lstUpDate")
public void setLstUpDate(String lstUpDate) {
this.lstUpDate = lstUpDate;
}

@JsonProperty("chassisNo")
public String getChassisNo() {
return chassisNo;
}

@JsonProperty("chassisNo")
public void setChassisNo(String chassisNo) {
this.chassisNo = chassisNo;
}

@JsonProperty("engineNo")
public String getEngineNo() {
return engineNo;
}

@JsonProperty("engineNo")
public void setEngineNo(String engineNo) {
this.engineNo = engineNo;
}

@JsonProperty("model")
public String getModel() {
return model;
}

@JsonProperty("model")
public void setModel(String model) {
this.model = model;
}

@JsonProperty("dealerCd")
public String getDealerCd() {
return dealerCd;
}

@JsonProperty("dealerCd")
public void setDealerCd(String dealerCd) {
this.dealerCd = dealerCd;
}

@JsonProperty("dtOfPurchase")
public Date getDtOfPurchase() {
return dtOfPurchase;
}

@JsonProperty("dtOfPurchase")
public void setDtOfPurchase(Date dtOfPurchase) {
this.dtOfPurchase = dtOfPurchase;
}

@JsonProperty("contactPerson")
public Object getContactPerson() {
return contactPerson;
}

@JsonProperty("contactPerson")
public void setContactPerson(Object contactPerson) {
this.contactPerson = contactPerson;
}

@JsonProperty("contactPerNo")
public Object getContactPerNo() {
return contactPerNo;
}

@JsonProperty("contactPerNo")
public void setContactPerNo(Object contactPerNo) {
this.contactPerNo = contactPerNo;
}
}
