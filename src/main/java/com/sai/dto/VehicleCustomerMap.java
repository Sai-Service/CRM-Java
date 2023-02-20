/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dto;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Swaroopcomp
 */
public class VehicleCustomerMap {
    
    private Integer custId;
    private  String custName;
    private  String custType;
    private  String address1;
    private  String address2;
    private  String address3;
    private  String location;
    private  Integer pincode;
    private  String city;
    private  String stateName;
    private  String country;
    private  String contactNo1;    
    private  String contactNo2;
    private  String emailId;
    private  String vehicleNo; 
    private  String chassisNo; 
    private  String engineNo; 
    private  String model; 
    private  String dealerCd; 
    private  Date dtOfPurchase; 
    private BigInteger contactPerNo;
      private String contactPerson;

    public VehicleCustomerMap(Integer custId, String custName, String custType, String address1, String address2, String address3, String location, Integer pincode, String city, String stateName, String country, String contactNo1, String contactNo2, String emailId, String vehicleNo, String chassisNo, String engineNo, String model, String dealerCd, Date dtOfPurchase, String contactPerson , BigInteger contactPerNo) {
        this.custId = custId;
        this.custName = custName;
        this.custType = custType;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.location = location;
        this.pincode = pincode;
        this.city = city;
        this.stateName = stateName;
        this.country = country;
        this.contactNo1 = contactNo1;
        this.contactNo2 = contactNo2;
        this.emailId = emailId;
        this.vehicleNo = vehicleNo;
        this.chassisNo = chassisNo;
        this.engineNo = engineNo;
        this.model = model;
        this.dealerCd = dealerCd;
        this.dtOfPurchase = dtOfPurchase;
        this.contactPerNo = contactPerNo;
        this.contactPerson = contactPerson;
    }

     public VehicleCustomerMap(){}
    public VehicleCustomerMap(Integer custId, String custName, String custType, String address1, String address2, String address3, String location, Integer pincode, String city, String stateName, String country, String contactNo1, String contactNo2, String emailId, String vehicleNo, String chassisNo, String engineNo, String model, String dealerCd, Date dtOfPurchase) {
        this.custId = custId;
        this.custName = custName;
        this.custType = custType;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.location = location;
        this.pincode = pincode;
        this.city = city;
        this.stateName = stateName;
        this.country = country;
        this.contactNo1 = contactNo1;
        this.contactNo2 = contactNo2;
        this.emailId = emailId;
        this.vehicleNo = vehicleNo;
        this.chassisNo = chassisNo;
        this.engineNo = engineNo;
        this.model = model;
        this.dealerCd = dealerCd;
        this.dtOfPurchase = dtOfPurchase;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
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

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
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

    public String getContactNo1() {
        return contactNo1;
    }

    public void setContactNo1(String contactNo1) {
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

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDealerCd() {
        return dealerCd;
    }

    public void setDealerCd(String dealerCd) {
        this.dealerCd = dealerCd;
    }

    public Date getDtOfPurchase() {
        return dtOfPurchase;
    }

    public void setDtOfPurchase(Date dtOfPurchase) {
        this.dtOfPurchase = dtOfPurchase;
    }

    public BigInteger getContactPerNo() {
        return contactPerNo;
    }

    public void setContactPerNo(BigInteger contactPerNo) {
        this.contactPerNo = contactPerNo;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
    
    
    
}
