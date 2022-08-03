/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model.insurance;

import com.sai.model.SsVehicleMaster;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Swaroopcomp
 */
@Entity
@Table(name = "ss_insurance_details")

public class SsInsuranceDetails implements Serializable {

    @Column(name = "custId")
    private Integer custId;
    @Size(max = 245)
    @Column(name = "miNo")
    private String miNo;
    @Size(max = 100)
    @Column(name = "insCompName")
    private String insCompName;

    @Size(max = 45)

    @Column(name = "idvAmt")
    private String idvAmt;

    @Size(max = 50)
    @Column(name = "prmAmt")
    private String prmAmt;
    @Size(max = 50)
    @Column(name = "claimAmt")
    private String claimAmt;
    @Size(max = 545)
//    @Column(name = "payDetails")
//    private String payDetails;
//    @Size(max = 545)
//    @Column(name = "apptDetails")
//    private String apptDetails;
    @Size(max = 1000)
    @Column(name = "remark")
    private String remark;
    //  @Size(max = 55)
//    @Column(name = "financeCompName")
//    private String financeComp;
    @Size(max = 50)
    @Column(name = "policyType")
    private String policyType;
    @Size(max = 45)
    @Column(name = "exShowPrice")
    private String exShowPrice;
    @Size(max = 545)
    @Column(name = "endorsementTaken")
    private String endorsementTaken;

    @Size(max = 55)
    @Column(name = "policySubType")
    private String policySubType;
    @Size(max = 45)
    @Column(name = "dealerName")
    private String dealerName;
    @Size(max = 545)
    @Column(name = "currentNCB")
    private String currentNCB;
    @Size(max = 45)
    @Column(name = "autoMembership")
    private String autoMembership;
    @Size(max = 45)
    @Column(name = "autoMembPremium")
    private String autoMembPremium;
    @Size(max = 45)
    @Column(name = "driverCover")
    private String driverCover;
    @Size(max = 45)
    @Column(name = "legalLibNoPer")
    private String legalLibNoPer;
    @Size(max = 45)
    @Column(name = "driverCoverPremium")
    private String driverCoverPremium;
    @Size(max = 45)
    @Column(name = "typeOfCustomer")
    private String typeOfCustomer;
    @Size(max = 545)
    @Column(name = "attribute1")
    private String attribute1;
    @Size(max = 545)
    @Column(name = "attribute2")
    private String attribute2;
    @Size(max = 545)
    @Column(name = "attribute3")
    private String attribute3;
    @Size(max = 545)
    @Column(name = "attribute4")
    private String attribute4;
    @Size(max = 545)
    @Column(name = "attribute5")
    private String attribute5;
    @Size(max = 545)
    @Column(name = "attribute6")
    private String attribute6;
    @Size(max = 545)
    @Column(name = "attribute7")
    private String attribute7;
    @Size(max = 545)
    @Column(name = "attribute8")
    private String attribute8;
    @Size(max = 545)
    @Column(name = "attribute9")
    private String attribute9;
    @Size(max = 545)
    @Column(name = "attribute10")
    private String attribute10;
//    @EmbeddedId()
//    protected com.sai.model.insurance.SsInsuranceDetailsPK ssInsuranceDetailsPK;
    @Column(name = "year")
    private Integer year;

//    @JoinColumn(name = "vehicleno", referencedColumnName = "vehicleNo")
//    @ManyToOne
//    private SsVehicleMaster vehicleno;
//    @Basic(optional = false)

    @Size(min = 1, max = 25)
    @Column(name = "policyNo")
    private String policyNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "insType")
    private String insType;
    @Size(max = 55)
    @Column(name = "financeCompName")
    private String financeCompName;
    @Size(max = 50)
    @Column(name = "policyRenewType")
    private String policyRenewType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "paymentMode")
    private String paymentMode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "accountNo")
    private String accountNo;
    @Size(max = 45)
    @Column(name = "bankBranch")
    private String bankBranch;
    @Size(max = 45)
    @Column(name = "bankName")
    private String bankName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orgId")
    private int orgId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "locId")
    private int locId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "vehicleNo")
    private String vehicleNo;

    @Column(name = "insStDate")
    @Temporal(TemporalType.DATE)
    private Date insStDate;
    @Column(name = "insPeriod")
    private Integer insPeriod;
    @Column(name = "insEndDt")
    @Temporal(TemporalType.DATE)
    private Date insEndDt;
    @Column(name = "claimCount")
    private Integer claimCount;
    @Column(name = "remittanceDate")
    @Temporal(TemporalType.DATE)
    private Date remittanceDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "paymentAmt")
    private Float paymentAmt;
    @Column(name = "paymentDate")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @Column(name = "inactiveDate")
    @Temporal(TemporalType.DATE)
    private Date inactiveDate;
    @Column(name = "creationDt")
    @Temporal(TemporalType.DATE)
    private Date creationDt;
    @Column(name = "createdBy")
    private Integer createdBy;
    @Column(name = "lstUpdationDt")
    @Temporal(TemporalType.DATE)
    private Date lstUpdationDt;
    @Column(name = "lstUpdatedby")
    private Integer lstUpdatedby;

    public SsInsuranceDetails() {
    }

    public SsInsuranceDetails(Integer id) {
        this.id = id;
    }

    public SsInsuranceDetails(Integer id, String vehicleNo, int custId, String miNo, String insCompName, String policyNo, int year, String insType, String paymentMode, String accountNo, String status) {
        this.id = id;
        this.vehicleNo = vehicleNo;
        this.custId = custId;
        this.miNo = miNo;
        this.insCompName = insCompName;
        this.policyNo = policyNo;
        this.year = year;
        this.insType = insType;
        this.paymentMode = paymentMode;
        this.accountNo = accountNo;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public Date getInsStDate() {
        return insStDate;
    }

    public void setInsStDate(Date insStDate) {
        this.insStDate = insStDate;
    }

    public Integer getInsPeriod() {
        return insPeriod;
    }

    public void setInsPeriod(Integer insPeriod) {
        this.insPeriod = insPeriod;
    }

    public Date getInsEndDt() {
        return insEndDt;
    }

    public void setInsEndDt(Date insEndDt) {
        this.insEndDt = insEndDt;
    }

    public Integer getClaimCount() {
        return claimCount;
    }

    public void setClaimCount(Integer claimCount) {
        this.claimCount = claimCount;
    }

    public Date getRemittanceDate() {
        return remittanceDate;
    }

    public void setRemittanceDate(Date remittanceDate) {
        this.remittanceDate = remittanceDate;
    }

    public Float getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(Float paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(Date inactiveDate) {
        this.inactiveDate = inactiveDate;
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

    public Date getLstUpdationDt() {
        return lstUpdationDt;
    }

    public void setLstUpdationDt(Date lstUpdationDt) {
        this.lstUpdationDt = lstUpdationDt;
    }

    public Integer getLstUpdatedby() {
        return lstUpdatedby;
    }

    public void setLstUpdatedby(Integer lstUpdatedby) {
        this.lstUpdatedby = lstUpdatedby;
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
        if (!(object instanceof SsInsuranceDetails)) {
            return false;
        }
        SsInsuranceDetails other = (SsInsuranceDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sai.model.insurance.SsInsuranceDetails[ id=" + id + " ]";
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getInsType() {
        return insType;
    }

    public void setInsType(String insType) {
        this.insType = insType;
    }

    public String getFinanceCompName() {
        return financeCompName;
    }

    public void setFinanceCompName(String financeCompName) {
        this.financeCompName = financeCompName;
    }

    public String getPolicyRenewType() {
        return policyRenewType;
    }

    public void setPolicyRenewType(String policyRenewType) {
        this.policyRenewType = policyRenewType;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public SsInsuranceDetails(int custId, String miNo, String insCompName, String policyNo, int year, String insType, String idvAmt, String prmAmt, String claimAmt, String remark, String financeCompName, String policyType, String exShowPrice, String endorsementTaken, String policyRenewType, String policySubType, String dealerName, String currentNCB, String driverCover, String legalLibNoPer, String driverCoverPremium, String typeOfCustomer, String paymentMode, String accountNo, String bankBranch, String bankName, String status, int orgId, int locId, Integer id, String vehicleNo, Date insStDate, Integer insPeriod, Date insEndDt, Integer claimCount, Date remittanceDate, Float paymentAmt, Date paymentDate, Date inactiveDate, Date creationDt, Integer createdBy, Date lstUpdationDt, Integer lstUpdatedby) {
        this.custId = custId;
        this.miNo = miNo;
        this.insCompName = insCompName;
        this.policyNo = policyNo;
        this.year = year;
        this.insType = insType;
        this.idvAmt = idvAmt;
        this.prmAmt = prmAmt;
        this.claimAmt = claimAmt;
        this.remark = remark;
        this.financeCompName = financeCompName;
        this.policyType = policyType;
        this.exShowPrice = exShowPrice;
        this.endorsementTaken = endorsementTaken;
        this.policyRenewType = policyRenewType;
        this.policySubType = policySubType;
        this.dealerName = dealerName;
        this.currentNCB = currentNCB;
        this.driverCover = driverCover;
        this.legalLibNoPer = legalLibNoPer;
        this.driverCoverPremium = driverCoverPremium;
        this.typeOfCustomer = typeOfCustomer;
        this.paymentMode = paymentMode;
        this.accountNo = accountNo;
        this.bankBranch = bankBranch;
        this.bankName = bankName;
        this.status = status;
        this.orgId = orgId;
        this.locId = locId;
        this.id = id;
        this.vehicleNo = vehicleNo;
        this.insStDate = insStDate;
        this.insPeriod = insPeriod;
        this.insEndDt = insEndDt;
        this.claimCount = claimCount;
        this.remittanceDate = remittanceDate;
        this.paymentAmt = paymentAmt;
        this.paymentDate = paymentDate;
        this.inactiveDate = inactiveDate;
        this.creationDt = creationDt;
        this.createdBy = createdBy;
        this.lstUpdationDt = lstUpdationDt;
        this.lstUpdatedby = lstUpdatedby;
    }

//    public com.sai.model.insurance.SsInsuranceDetailsPK getSsInsuranceDetailsPK() {
//        return ssInsuranceDetailsPK;
//    }
//    public void setSsInsuranceDetailsPK(com.sai.model.insurance.SsInsuranceDetailsPK ssInsuranceDetailsPK) {
//        this.ssInsuranceDetailsPK = ssInsuranceDetailsPK;
//    }
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

//    public SsVehicleMaster getVehicleno() {
//        return vehicleno;
//    }
//
//    public void setVehicleno(SsVehicleMaster vehicleno) {
//        this.vehicleno = vehicleno;
//    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getMiNo() {
        return miNo;
    }

    public void setMiNo(String miNo) {
        this.miNo = miNo;
    }

    public String getInsCompName() {
        return insCompName;
    }

    public void setInsCompName(String insCompName) {
        this.insCompName = insCompName;
    }

    public String getIdvAmt() {
        return idvAmt;
    }

    public void setIdvAmt(String idvAmt) {
        this.idvAmt = idvAmt;
    }

    public String getPrmAmt() {
        return prmAmt;
    }

    public void setPrmAmt(String prmAmt) {
        this.prmAmt = prmAmt;
    }

    public String getClaimAmt() {
        return claimAmt;
    }

    public void setClaimAmt(String claimAmt) {
        this.claimAmt = claimAmt;
    }

//    public String getPayDetails() {
//        return payDetails;
//    }
//
//    public void setPayDetails(String payDetails) {
//        this.payDetails = payDetails;
//    }
//    public String getApptDetails() {
//        return apptDetails;
//    }
//
//    public void setApptDetails(String apptDetails) {
//        this.apptDetails = apptDetails;
//    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

//    public String getFinanceComp() {
//        return financeComp;
//    }
//
//    public void setFinanceComp(String financeComp) {
//        this.financeComp = financeComp;
//    }
    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getExShowPrice() {
        return exShowPrice;
    }

    public void setExShowPrice(String exShowPrice) {
        this.exShowPrice = exShowPrice;
    }

    public String getEndorsementTaken() {
        return endorsementTaken;
    }

    public void setEndorsementTaken(String endorsementTaken) {
        this.endorsementTaken = endorsementTaken;
    }

    public String getPolicySubType() {
        return policySubType;
    }

    public void setPolicySubType(String policySubType) {
        this.policySubType = policySubType;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getCurrentNCB() {
        return currentNCB;
    }

    public void setCurrentNCB(String currentNCB) {
        this.currentNCB = currentNCB;
    }

    public String getAutoMembership() {
        return autoMembership;
    }

    public void setAutoMembership(String autoMembership) {
        this.autoMembership = autoMembership;
    }

    public String getAutoMembPremium() {
        return autoMembPremium;
    }

    public void setAutoMembPremium(String autoMembPremium) {
        this.autoMembPremium = autoMembPremium;
    }

    public String getDriverCover() {
        return driverCover;
    }

    public void setDriverCover(String driverCover) {
        this.driverCover = driverCover;
    }

    public String getLegalLibNoPer() {
        return legalLibNoPer;
    }

    public void setLegalLibNoPer(String legalLibNoPer) {
        this.legalLibNoPer = legalLibNoPer;
    }

    public String getDriverCoverPremium() {
        return driverCoverPremium;
    }

    public void setDriverCoverPremium(String driverCoverPremium) {
        this.driverCoverPremium = driverCoverPremium;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
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
}
