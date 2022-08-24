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

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "PROFORMA_HEADERS_ALL")
@NamedQueries({
    @NamedQuery(name = "ProformaHeadersAll.findAll", query = "SELECT p FROM ProformaHeadersAll p")})
public class ProformaHeadersAll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HEADERID")
    private Integer headerid;
    @Column(name = "BILLTOLOCID")
    private Integer billtolocid;
    @Column(name = "SHIPTOLOCID")
    private Integer shiptolocid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTACCTNO")
    private Integer custacctno;
    @Size(max = 255)
    @Column(name = "CUSTDETAILS")
    private String custdetails;
    @Column(name = "CUSTPODATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date custpodate;
    @Size(max = 100)
    @Column(name = "CUSTPONUMBER")
    private String custponumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BASEAMOUNT")
    private Double baseamount;
    @Column(name = "DISCAMOUNT")
    private Double discamount;
    @Column(name = "TAXABLEAMT")
    private Double taxableamt;
    @Column(name = "DISPER")
    private Integer disper;
    @Column(name = "TOTALTAX")
    private Double totaltax;
    @Column(name = "TOTALAMT")
    private Double totalamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORGID")
    private Integer orgid;
    @Column(name = "DEPT")
    private Integer dept;
    @Column(name = "DIVISIONID")
    private Integer divisionid;
    @Size(max = 45)
    @Column(name = "CANCELLEDFLAG")
    private String cancelledflag;
    @Size(max = 45)
    @Column(name = "COLOR")
    private String color;
    @Size(max = 45)
    @Column(name = "DELIVERYAT")
    private String deliveryat;
    @Size(max = 50)
    @Column(name = "DISCTYPE")
    private String disctype;
    @Size(max = 1)
    @Column(name = "FINANCEYN")
    private String financeyn;
    @Size(max = 1)
    @Column(name = "EXCHANGEYN")
    private String exchangeyn;
    @Size(max = 255)
    @Column(name = "ISSUECODETYPE")
    private String issuecodetype;
    @Size(max = 255)
    @Column(name = "ISSUEDBY")
    private String issuedby;
    @Size(max = 45)
    @Column(name = "MODEL")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERNUMBER")
    private BigInteger ordernumber;
    @Size(max = 255)
    @Column(name = "ORDERSTATUS")
    private String orderstatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERTYPEID")
    private Integer ordertypeid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDEREDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordereddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICELISTID")
    private Integer pricelistid;
    @Size(max = 145)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 45)
    @Column(name = "TLNAME")
    private String tlname;
    @Size(max = 255)
    @Column(name = "VALIDDAYS")
    private String validdays;
    @Size(max = 45)
    @Column(name = "VARIANT")
    private String variant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDBY")
    private Integer createdby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "LASTUPDATEDBY")
    private Integer lastupdatedby;
    @Column(name = "LASTUPDATEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdateddate;
    @Size(max = 45)
    @Column(name = "ATTRIBUTE1")
    private String attribute1;
    @Size(max = 45)
    @Column(name = "ATTRIBUTE2")
    private String attribute2;
    @Size(max = 45)
    @Column(name = "ATTRIBUTE3")
    private String attribute3;
    @Size(max = 45)
    @Column(name = "ATTRIBUTE4")
    private String attribute4;
    @Size(max = 45)
    @Column(name = "ATTRIBUTE5")
    private String attribute5;
    
    @Column(name = "LOCATIONID")
    private Integer locationId;
    private long taskId;
//    @JsonIgnoreProperties("headerid")
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "headerid")   
//    private List<ProformaLinesAll> proformaLinesAllList;

    public ProformaHeadersAll() {
    }

    public ProformaHeadersAll(Integer headerid) {
        this.headerid = headerid;
    }

    public ProformaHeadersAll(Integer headerid, Integer custacctno, Integer orgid, BigInteger ordernumber, Integer ordertypeid, Date ordereddate, 
            Integer pricelistid, Integer createdby, Date creationdate) {
        this.headerid = headerid;
        this.custacctno = custacctno;
        this.orgid = orgid;
        this.ordernumber = ordernumber;
        this.ordertypeid = ordertypeid;
        this.ordereddate = ordereddate;
        this.pricelistid = pricelistid;
        this.createdby = createdby;
        this.creationdate = creationdate;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }
    
    public Integer getHeaderid() {
        return headerid;
    }

    public void setHeaderid(Integer headerid) {
        this.headerid = headerid;
    }

    public Integer getBilltolocid() {
        return billtolocid;
    }

    public void setBilltolocid(Integer billtolocid) {
        this.billtolocid = billtolocid;
    }

    public Integer getShiptolocid() {
        return shiptolocid;
    }

    public void setShiptolocid(Integer shiptolocid) {
        this.shiptolocid = shiptolocid;
    }

    public Integer getCustacctno() {
        return custacctno;
    }

    public void setCustacctno(Integer custacctno) {
        this.custacctno = custacctno;
    }

    public String getCustdetails() {
        return custdetails;
    }

    public void setCustdetails(String custdetails) {
        this.custdetails = custdetails;
    }

    public Date getCustpodate() {
        return custpodate;
    }

    public void setCustpodate(Date custpodate) {
        this.custpodate = custpodate;
    }

    public String getCustponumber() {
        return custponumber;
    }

    public void setCustponumber(String custponumber) {
        this.custponumber = custponumber;
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

    public Double getTaxableamt() {
        return taxableamt;
    }

    public void setTaxableamt(Double taxableamt) {
        this.taxableamt = taxableamt;
    }

    public Integer getDisper() {
        return disper;
    }

    public void setDisper(Integer disper) {
        this.disper = disper;
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

    public Integer getOrgid() {
        return orgid;
    }

    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    public Integer getDivisionid() {
        return divisionid;
    }

    public void setDivisionid(Integer divisionid) {
        this.divisionid = divisionid;
    }

    public String getCancelledflag() {
        return cancelledflag;
    }

    public void setCancelledflag(String cancelledflag) {
        this.cancelledflag = cancelledflag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDeliveryat() {
        return deliveryat;
    }

    public void setDeliveryat(String deliveryat) {
        this.deliveryat = deliveryat;
    }

    public String getDisctype() {
        return disctype;
    }

    public void setDisctype(String disctype) {
        this.disctype = disctype;
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

    public String getIssuecodetype() {
        return issuecodetype;
    }

    public void setIssuecodetype(String issuecodetype) {
        this.issuecodetype = issuecodetype;
    }

    public String getIssuedby() {
        return issuedby;
    }

    public void setIssuedby(String issuedby) {
        this.issuedby = issuedby;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigInteger getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(BigInteger ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Integer getOrdertypeid() {
        return ordertypeid;
    }

    public void setOrdertypeid(Integer ordertypeid) {
        this.ordertypeid = ordertypeid;
    }

    public Date getOrdereddate() {
        return ordereddate;
    }

    public void setOrdereddate(Date ordereddate) {
        this.ordereddate = ordereddate;
    }

    public Integer getPricelistid() {
        return pricelistid;
    }

    public void setPricelistid(Integer pricelistid) {
        this.pricelistid = pricelistid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTlname() {
        return tlname;
    }

    public void setTlname(String tlname) {
        this.tlname = tlname;
    }

    public String getValiddays() {
        return validdays;
    }

    public void setValiddays(String validdays) {
        this.validdays = validdays;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public Integer getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Integer createdby) {
        this.createdby = createdby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Integer getLastupdatedby() {
        return lastupdatedby;
    }

    public void setLastupdatedby(Integer lastupdatedby) {
        this.lastupdatedby = lastupdatedby;
    }

    public Date getLastupdateddate() {
        return lastupdateddate;
    }

    public void setLastupdateddate(Date lastupdateddate) {
        this.lastupdateddate = lastupdateddate;
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

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    
//    public List<ProformaLinesAll> getProformaLinesAllList() {
//        return proformaLinesAllList;
//    }
//
//    public void setProformaLinesAllList(List<ProformaLinesAll> proformaLinesAllList) {
//        this.proformaLinesAllList = proformaLinesAllList;
//    }
//


    
}
