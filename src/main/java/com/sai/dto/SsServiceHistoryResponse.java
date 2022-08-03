/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Swaroopcomp
 */
public class SsServiceHistoryResponse {

    private String vehicleNo;
    private String custName;
    private String address;
    private String contactNo;
    private String emailId;
    private String amc;
    private String engineWax;
    private String teflon;
    private String underChassis;
    private String dinitrol;
    private String model;
    private String description;
    private long chassisNo;
    private long engineNo;
    private String dos;
    private String addContact;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date ewStartDt;
    private String ewPeriod;
    private String ewInsurer;
    private String fuelType;
    private List<SsServiceHistoryJobDetails>jobDetails;

    public SsServiceHistoryResponse(String vehicleNo, String custName, String address, String contactNo, String emailId, String amc, String engineWax, String teflon, String underChassis, String dinitrol, String model, String description, long chassisNo, long engineNo, String dos, String addContact, Date ewStartDt, String ewPeriod, String ewInsurer, String fuelType) {
        this.vehicleNo = vehicleNo;
        this.custName = custName;
        this.address = address;
        this.contactNo = contactNo;
        this.emailId = emailId;
        this.amc = amc;
        this.engineWax = engineWax;
        this.teflon = teflon;
        this.underChassis = underChassis;
        this.dinitrol = dinitrol;
        this.model = model;
        this.description = description;
        this.chassisNo = chassisNo;
        this.engineNo = engineNo;
        this.dos = dos;
        this.addContact = addContact;
        this.ewStartDt = ewStartDt;
        this.ewPeriod = ewPeriod;
        this.ewInsurer = ewInsurer;
        this.fuelType = fuelType;
     //   this.jobDetails = jobDetails;
    }
    
    

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

    public List<SsServiceHistoryJobDetails> getJobDetails() {
        return jobDetails;
    }

    public void setJobDetails(List<SsServiceHistoryJobDetails> jobDetails) {
        this.jobDetails = jobDetails;
    }
    
    

  
    
}
