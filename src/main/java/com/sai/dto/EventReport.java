/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dto;

import java.util.Date;
public class EventReport {
    String subCategory;
    long custId;
    String custName;
    String custAddress;
    String contactPerson;
    String custType;
    String contactNo1;
    String contactNo2;
    String emailId;
    String VehNo;
    String chassisNo;
    String engineNo;
    String model;
    String dealerCd;
    Date dateOfPurchase;
    long orgId;
    long locId;
    String servLoc;
    String refNo;
    String lastServcType;
    String lastKM;
    Date lastServcDt;
    Date nextServcDt;
    String nextServcType;
    Date serviceDueDt;
    Date deliveryDate;

    public EventReport(String subCategory, long custId, String custName, String custAddress, String contactPerson, String custType, String contactNo1, String contactNo2, String emailId, String VehNo, String chassisNo, String engineNo, String model, String dealerCd, Date dateOfPurchase, long orgId, long locId, String servLoc, String refNo, String lastServcType, String lastKM, Date lastServcDt, Date nextServcDt, String nextServcType, Date serviceDueDt, Date deliveryDate) {
        this.subCategory = subCategory;
        this.custId = custId;
        this.custName = custName;
        this.custAddress = custAddress;
        this.contactPerson = contactPerson;
        this.custType = custType;
        this.contactNo1 = contactNo1;
        this.contactNo2 = contactNo2;
        this.emailId = emailId;
        this.VehNo = VehNo;
        this.chassisNo = chassisNo;
        this.engineNo = engineNo;
        this.model = model;
        this.dealerCd = dealerCd;
        this.dateOfPurchase = dateOfPurchase;
        this.orgId = orgId;
        this.locId = locId;
        this.servLoc = servLoc;
        this.refNo = refNo;
        this.lastServcType = lastServcType;
        this.lastKM = lastKM;
        this.lastServcDt = lastServcDt;
        this.nextServcDt = nextServcDt;
        this.nextServcType = nextServcType;
        this.serviceDueDt = serviceDueDt;
        this.deliveryDate = deliveryDate;
    }

   
}
