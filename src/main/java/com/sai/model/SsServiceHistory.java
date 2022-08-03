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
import javax.persistence.Table;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Test
 */
@Entity
@Table(name = "Ss_service_history")
public class SsServiceHistory {

    @Id
    @javax.persistence.Id
    @Column(name = "VEHICLE_NO")
    private String vehicleNo;

    @Column(name = "CUST_NAME")
    private String custName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CONTACT_NO")
    private String contactNo;

    @Column(name = "EMAIL_ID")
    private String emailId;

    @Column(name = "AMC")
    private String amc;

    @Column(name = "ENGINE_WAX")
    private String engineWax;

    @Column(name = "TEFLON")
    private String teflon;

    @Column(name = "UNDER_CHASSIS")
    private String underChassis;

    @Column(name = "DINITROL")
    private String dinitrol;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CHASSIS_NO")
    private long chassisNo;

    @Column(name = "ENGINE_NO")
    private long engineNo;

    @Column(name = "DOS")
    private String dos;

    @Column(name = "ADDITIONAL_CONTACT")
    private String addContact;

    @Column(name = "EW_START_DT")
    private Date ewStartDt;

    @Column(name = "EW_PERIOD")
    private String ewPeriod;

    @Column(name = "EW_INSURER")
    private String ewInsurer;

    @Column(name = "FUEL_TYPE")
    private String fuelType;

    @Column(name = "SR_NO")
    private String srNo;

    @Column(name = "SERVICE_TYPE")
    private String serviceType;

    @Column(name = "LOC_CITY")
    private String locCity;

    @Column(name = "JOB_NO")
    private String jobNo;

    @Column(name = "SA_NAME")
    private String saName;

    @Column(name = "TECH_NAME")
    private String techName;

    @Column(name = "SURVEYOR_NAME")
    private String surveyorName;

    @Column(name = "ALTERNATE_MOBILE")
    private String alternateMobile;

    @Column(name = "DEALER_NAME")
    private String dealerName;

    @Column(name = "JOB_DATE")
    private Date jobDate;

    @Column(name = "DELV_DATE")
    private Date delvDate;

    @Column(name = "GROUP")
    private String group;

    @Column(name = "MILEAGE")
    private String mileage;

    @Column(name = "BILL_NO")
    private String billNo;

    @Column(name = "BILL_DATE")
    private Date billDate;

    @Column(name = "PART_AMT")
    private String partAmt;

    @Column(name = "LABOR_AMT")
    private String laborAmt;

    @Column(name = "TOT_AMT")
    private String totamt;

    @Column(name = "MATERIAL")
    private String material;

    @Column(name = "MATERIAL_DESC")
    private String matDesc;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "QUANTITY")
    private String quantity;

    @Column(name = "TOTAL_AMT")
    private String totalAmt;

    @Column(name = "TYPE1")
    private String chargesType;
    
    @Column(name = "RECOMONDATION")
    private String recomondation;

   
    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAmc() {
        return amc;
    }

    public void setAmc(String amc) {
        this.amc = amc;
    }

    public String getEngineWax() {
        return engineWax;
    }

    public void setEngineWax(String engineWax) {
        this.engineWax = engineWax;
    }

    public String getTeflon() {
        return teflon;
    }

    public void setTeflon(String teflon) {
        this.teflon = teflon;
    }

    public String getUnderChassis() {
        return underChassis;
    }

    public void setUnderChassis(String underChassis) {
        this.underChassis = underChassis;
    }

    public String getDinitrol() {
        return dinitrol;
    }

    public void setDinitrol(String dinitrol) {
        this.dinitrol = dinitrol;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(long chassisNo) {
        this.chassisNo = chassisNo;
    }

    public long getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(long engineNo) {
        this.engineNo = engineNo;
    }

    public String getDos() {
        return dos;
    }

    public void setDos(String dos) {
        this.dos = dos;
    }

    public String getAddContact() {
        return addContact;
    }

    public void setAddContact(String addContact) {
        this.addContact = addContact;
    }

    public Date getEwStartDt() {
        return ewStartDt;
    }

    public void setEwStartDt(Date ewStartDt) {
        this.ewStartDt = ewStartDt;
    }

    public String getEwPeriod() {
        return ewPeriod;
    }

    public void setEwPeriod(String ewPeriod) {
        this.ewPeriod = ewPeriod;
    }

    public String getEwInsurer() {
        return ewInsurer;
    }

    public void setEwInsurer(String ewInsurer) {
        this.ewInsurer = ewInsurer;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getSrNo() {
        return srNo;
    }

    public void setSrNo(String srNo) {
        this.srNo = srNo;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getLocCity() {
        return locCity;
    }

    public void setLocCity(String locCity) {
        this.locCity = locCity;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public String getSaName() {
        return saName;
    }

    public void setSaName(String saName) {
        this.saName = saName;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public String getSurveyorName() {
        return surveyorName;
    }

    public void setSurveyorName(String surveyorName) {
        this.surveyorName = surveyorName;
    }

    public String getAlternateMobile() {
        return alternateMobile;
    }

    public void setAlternateMobile(String alternateMobile) {
        this.alternateMobile = alternateMobile;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public Date getJobDate() {
        return jobDate;
    }

    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
    }

    public Date getDelvDate() {
        return delvDate;
    }

    public void setDelvDate(Date delvDate) {
        this.delvDate = delvDate;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getPartAmt() {
        return partAmt;
    }

    public void setPartAmt(String partAmt) {
        this.partAmt = partAmt;
    }

    public String getLaborAmt() {
        return laborAmt;
    }

    public void setLaborAmt(String laborAmt) {
        this.laborAmt = laborAmt;
    }

    public String getTotamt() {
        return totamt;
    }

    public void setTotamt(String totamt) {
        this.totamt = totamt;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMatDesc() {
        return matDesc;
    }

    public void setMatDesc(String matDesc) {
        this.matDesc = matDesc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getChargesType() {
        return chargesType;
    }

    public void setChargesType(String chargesType) {
        this.chargesType = chargesType;
    }

    public String getRecomondation() {
        return recomondation;
    }

    public void setRecomondation(String recomondation) {
        this.recomondation = recomondation;
    }
    
 

}
