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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "sales_task_details", catalog = "test", schema = "")
public class SalesTaskDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer taskId;
    private Integer custAcctNo;
    @Size(max = 200)
    private String custDetails;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private String custName;
    private String contactNo;
        private String contactNo1;
    private String tlName;
    private Double baseamount;
    private Double discamount;
    private Double taxableamt;
    private Double totaltax;
    private Double totalamt;
    @Size(max = 25)
    private String colorCode;
    @Size(max = 65)
    private String colorDesc;
    @Size(max = 4)
    private String financeyn;
    @Size(max = 4)
    private String exchangeyn;
    @Size(max = 45)
    private String salesExe;
    @Size(max = 45)
    private String model;
    @Size(max = 45)
    private String variant;
    @Size(max = 100)
    private String varDesc;
    private BigInteger prfOrderNo;
    @Temporal(TemporalType.DATE)
    private Date prfOrdereddate;
    private Integer locId;
    private Integer orgId;
    @Temporal(TemporalType.DATE)
    private Date callDuDt;
    @Size(max = 45)
    private String taskStatus;
    @Size(max = 45)
    private String contacted;
    @Size(max = 45)
    private String reason;
    @Size(max = 200)
    private String remark;
    @Temporal(TemporalType.DATE)
    private Date nextflwupDt;
    @Size(max = 4)
    private String convertSOYN;
    private BigInteger convertSONo;
    @Size(max = 45)
    private String taskAssigneeId;
    private String assignee;
    private Integer createdBy;
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    public SalesTaskDetails() {
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getTlName() {
        return tlName;
    }

    public void setTlName(String tlName) {
        this.tlName = tlName;
    }

    public SalesTaskDetails(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getCustAcctNo() {
        return custAcctNo;
    }

    public void setCustAcctNo(Integer custAcctNo) {
        this.custAcctNo = custAcctNo;
    }

    public String getCustDetails() {
        return custDetails;
    }

    public void setCustDetails(String custDetails) {
        this.custDetails = custDetails;
    }

    public Double getBaseamount() {
        return baseamount;
    }

    public void setBaseamount(Double baseamount) {
        this.baseamount = baseamount;
    }

    public Double getDiscamount() {
        return discamount;
    }

    public void setDiscamount(Double discamount) {
        this.discamount = discamount;
    }

    public String getContactNo1() {
        return contactNo1;
    }

    public void setContactNo1(String contactNo1) {
        this.contactNo1 = contactNo1;
    }
    

    public Double getTaxableamt() {
        return taxableamt;
    }

    public void setTaxableamt(Double taxableamt) {
        this.taxableamt = taxableamt;
    }

    public Double getTotaltax() {
        return totaltax;
    }

    public void setTotaltax(Double totaltax) {
        this.totaltax = totaltax;
    }

    public Double getTotalamt() {
        return totalamt;
    }

    public void setTotalamt(Double totalamt) {
        this.totalamt = totalamt;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorDesc() {
        return colorDesc;
    }

    public void setColorDesc(String colorDesc) {
        this.colorDesc = colorDesc;
    }

    public String getFinanceyn() {
        return financeyn;
    }

    public void setFinanceyn(String financeyn) {
        this.financeyn = financeyn;
    }

    public String getExchangeyn() {
        return exchangeyn;
    }

    public void setExchangeyn(String exchangeyn) {
        this.exchangeyn = exchangeyn;
    }

    public String getSalesExe() {
        return salesExe;
    }

    public void setSalesExe(String salesExe) {
        this.salesExe = salesExe;
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

    public String getVarDesc() {
        return varDesc;
    }

    public void setVarDesc(String varDesc) {
        this.varDesc = varDesc;
    }

    public BigInteger getPrfOrderNo() {
        return prfOrderNo;
    }

    public void setPrfOrderNo(BigInteger prfOrderNo) {
        this.prfOrderNo = prfOrderNo;
    }

    public Date getPrfOrdereddate() {
        return prfOrdereddate;
    }

    public void setPrfOrdereddate(Date prfOrdereddate) {
        this.prfOrdereddate = prfOrdereddate;
    }

    public Integer getLocId() {
        return locId;
    }

    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Date getCallDuDt() {
        return callDuDt;
    }

    public void setCallDuDt(Date callDuDt) {
        this.callDuDt = callDuDt;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getContacted() {
        return contacted;
    }

    public void setContacted(String contacted) {
        this.contacted = contacted;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getNextflwupDt() {
        return nextflwupDt;
    }

    public void setNextflwupDt(Date nextflwupDt) {
        this.nextflwupDt = nextflwupDt;
    }

    public String getConvertSOYN() {
        return convertSOYN;
    }

    public void setConvertSOYN(String convertSOYN) {
        this.convertSOYN = convertSOYN;
    }

    public BigInteger getConvertSONo() {
        return convertSONo;
    }

    public void setConvertSONo(BigInteger convertSONo) {
        this.convertSONo = convertSONo;
    }

    public String getTaskAssigneeId() {
        return taskAssigneeId;
    }

    public void setTaskAssigneeId(String taskAssigneeId) {
        this.taskAssigneeId = taskAssigneeId;
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

}
