/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 *
 * @author Swaroopcomp
 */
public class SsServiceHistoryJobDetails {
     private String srNo;
    private String serviceType;
    private String locCity;
    private String jobNo;
    private String saName;
    private String techName;
    private String surveyorName;
    private String alternateMobile;
    private String dealerName;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date jobDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date delvDate;
    private String group;
    private String mileage;
    private String billNo;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date billDate;
    private String partAmt;
    private String laborAmt;
    private String totamt;
    private String material;
    private String matDesc;
    private String type;
    private String quantity;
    private String totalAmt;
    private String type1;
    private String recomondation;

    public SsServiceHistoryJobDetails(String srNo, String serviceType, String locCity, String jobNo, String saName, String techName, String surveyorName, String alternateMobile, String dealerName, Date jobDate, Date delvDate, String group, String mileage, String billNo, Date billDate, String partAmt, String laborAmt, String totamt, String material, String matDesc, String type, String quantity, String totalAmt, String type1, String recomondation) {
        this.srNo = srNo;
        this.serviceType = serviceType;
        this.locCity = locCity;
        this.jobNo = jobNo;
        this.saName = saName;
        this.techName = techName;
        this.surveyorName = surveyorName;
        this.alternateMobile = alternateMobile;
        this.dealerName = dealerName;
        this.jobDate = jobDate;
        this.delvDate = delvDate;
        this.group = group;
        this.mileage = mileage;
        this.billNo = billNo;
        this.billDate = billDate;
        this.partAmt = partAmt;
        this.laborAmt = laborAmt;
        this.totamt = totamt;
        this.material = material;
        this.matDesc = matDesc;
        this.type = type;
        this.quantity = quantity;
        this.totalAmt = totalAmt;
        this.type1 = type1;
        this.recomondation = recomondation;
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

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getRecomondation() {
        return recomondation;
    }

    public void setRecomondation(String recomondation) {
        this.recomondation = recomondation;
    }
    
    
    
    
}
