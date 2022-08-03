/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

import com.sai.model.insurance.SsInsuranceDetails;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Swaroopcomp
 */
@Entity
@Table(name = "ss_vehicle_master")

public class SsVehicleMaster implements Serializable {

    @Basic(optional = false)
    @NotNull
    private int custId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String chassis;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 45)
    private String engine;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 45)
    private String model;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 45)
    private String variant;
    @Size(max = 100)
    private String modelDesc;
    @Size(max = 45)
    private String segment1;
    @Size(max = 45)
    private String color;
    @Size(max = 10)
    private String fuelType;
    @Size(max = 45)
    private String typeOfVeh;
    @Size(max = 45)
    private String vinNo;
    @Size(max = 45)
    private String ewStatus;
    @Size(max = 45)
    private String mcpStKm;
    @Size(max = 45)
    private String mcpEnKm;
    @Size(max = 145)
    private String ewInsuName;
    @Size(max = 45)
    private String dealerCode;
    @Size(max = 145)
    private String contactPerson;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String vehicleType;
    @Size(max = 1)
    private String miYN;
    @Temporal(TemporalType.DATE)
    private Date cngDueDate;
    @Temporal(TemporalType.DATE)
    private Date pucDueDate;
    
   // @OneToMany(mappedBy = "vehicleno")
    //private Collection<SsInsuranceDetails> ssInsuranceDetailsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "vehicleNo")
    private String vehicleNo;
    
    @Column(name = "dtOfPurchase")
    @Temporal(TemporalType.DATE)
    private Date dtOfPurchase;
    @Column(name = "ewStDate")
    @Temporal(TemporalType.DATE)
    private Date ewStDate;
    @Column(name = "ewEnDate")
    @Temporal(TemporalType.DATE)
    private Date ewEnDate;
    @Column(name = "mcpStDate")
    @Temporal(TemporalType.DATE)
    private Date mcpStDate;
    @Column(name = "mcpEnDate")
    @Temporal(TemporalType.DATE)
    private Date mcpEnDate;
    @Column(name = "contactPerNo")
    private BigInteger contactPerNo;
    @Column(name = "creationDt")
    @Temporal(TemporalType.DATE)
    private Date creationDt;
    @Column(name = "createdBy")
    private Integer createdBy;
    @Column(name = "lstUpdatedDt")
    @Temporal(TemporalType.DATE)
    private Date lstUpdatedDt;
    @Column(name = "lstUpdatedBy")
    private Integer lstUpdatedBy;

    public SsVehicleMaster() {
    }

    public SsVehicleMaster(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public SsVehicleMaster(String vehicleNo, String chassis, String engine) {
        this.vehicleNo = vehicleNo;
        this.chassis = chassis;
        this.engine = engine;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }



    public Date getDtOfPurchase() {
        return dtOfPurchase;
    }

    public void setDtOfPurchase(Date dtOfPurchase) {
        this.dtOfPurchase = dtOfPurchase;
    }


    public Date getEwStDate() {
        return ewStDate;
    }

    public void setEwStDate(Date ewStDate) {
        this.ewStDate = ewStDate;
    }

    public Date getEwEnDate() {
        return ewEnDate;
    }

    public void setEwEnDate(Date ewEnDate) {
        this.ewEnDate = ewEnDate;
    }


    public Date getMcpStDate() {
        return mcpStDate;
    }

    public void setMcpStDate(Date mcpStDate) {
        this.mcpStDate = mcpStDate;
    }

    public Date getMcpEnDate() {
        return mcpEnDate;
    }

    public void setMcpEnDate(Date mcpEnDate) {
        this.mcpEnDate = mcpEnDate;
    }


    public BigInteger getContactPerNo() {
        return contactPerNo;
    }

    public void setContactPerNo(BigInteger contactPerNo) {
        this.contactPerNo = contactPerNo;
    }


    public Date getCreationDt() {
        return creationDt;
    }

    public void setCreationDt(Date creationDt) {
        this.creationDt = creationDt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLstUpdatedDt() {
        return lstUpdatedDt;
    }

    public void setLstUpdatedDt(Date lstUpdatedDt) {
        this.lstUpdatedDt = lstUpdatedDt;
    }

    public Integer getLstUpdatedBy() {
        return lstUpdatedBy;
    }

    public void setLstUpdatedBy(Integer lstUpdatedBy) {
        this.lstUpdatedBy = lstUpdatedBy;
    }
//    @XmlTransient
//    public Collection<SsInsuranceDetails> getSsInsuranceDetailsCollection() {
//        return ssInsuranceDetailsCollection;
//    }
//    public void setSsInsuranceDetailsCollection(Collection<SsInsuranceDetails> ssInsuranceDetailsCollection) {
//        this.ssInsuranceDetailsCollection = ssInsuranceDetailsCollection;
//    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getModelDesc() {
        return modelDesc;
    }

    public void setModelDesc(String modelDesc) {
        this.modelDesc = modelDesc;
    }

    public String getSegment1() {
        return segment1;
    }

    public void setSegment1(String segment1) {
        this.segment1 = segment1;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTypeOfVeh() {
        return typeOfVeh;
    }

    public void setTypeOfVeh(String typeOfVeh) {
        this.typeOfVeh = typeOfVeh;
    }

    public String getVinNo() {
        return vinNo;
    }

    public void setVinNo(String vinNo) {
        this.vinNo = vinNo;
    }

    public String getEwStatus() {
        return ewStatus;
    }

    public void setEwStatus(String ewStatus) {
        this.ewStatus = ewStatus;
    }

    public String getMcpStKm() {
        return mcpStKm;
    }

    public void setMcpStKm(String mcpStKm) {
        this.mcpStKm = mcpStKm;
    }

    public String getMcpEnKm() {
        return mcpEnKm;
    }

    public void setMcpEnKm(String mcpEnKm) {
        this.mcpEnKm = mcpEnKm;
    }

    public String getEwInsuName() {
        return ewInsuName;
    }

    public void setEwInsuName(String ewInsuName) {
        this.ewInsuName = ewInsuName;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getMiYN() {
        return miYN;
    }

    public void setMiYN(String miYN) {
        this.miYN = miYN;
    }

    public Date getCngDueDate() {
        return cngDueDate;
    }

    public void setCngDueDate(Date cngDueDate) {
        this.cngDueDate = cngDueDate;
    }

    public Date getPucDueDate() {
        return pucDueDate;
    }

    public void setPucDueDate(Date pucDueDate) {
        this.pucDueDate = pucDueDate;
    }

}
