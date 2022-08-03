/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;
/**
 *
 * @author Test
 */
@Entity
@Table(name = "ss_company")
public class SsCompany implements Serializable {
  
//    @Id
 //   @javax.persistence.Id
 //   @Column(name = "COMPANY_CODE")
 //   private long companyCode;
    
    
    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "COMPANY_CODE")
    private long companyCode=1L;   
     
    @Column(name = "COMPANY_NAME")
    private  String companyName;
    
    @Column(name = "CREATION_DATE")
    private Date creationDt;
    
    @Column(name = "CREATED_BY")
    private  long createdBy;
        
    @Column(name = "LAST_UPDATION_DATE")
    private  Date lstUpDate;
    
    @Column(name = "LAST_UPDATED_BY")
    private  long lstUpBy;

    @Column(name = "STATUS")
    private  String status;       
    
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "INACTIVE_DATE")
    private  Date inactiveDate;       
    
    
    public SsCompany()
    {
        
    }

    public SsCompany(long companyCode, String companyName, Date creationDt, long createdBy, Date lstUpDate, long lstUpBy, String status, Date inactiveDate) {
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.creationDt = creationDt;
        this.createdBy = createdBy;
        this.lstUpDate = lstUpDate;
        this.lstUpBy = lstUpBy;
        this.status = status;
        this.inactiveDate = inactiveDate;
    }

    public long getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(long companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getCreationDt() {
        return creationDt;
    }

    public void setCreationDt(Date creationDt) {
        this.creationDt = creationDt;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLstUpDate() {
        return lstUpDate;
    }

    public void setLstUpDate(Date lstUpDate) {
        this.lstUpDate = lstUpDate;
    }

    public long getLstUpBy() {
        return lstUpBy;
    }

    public void setLstUpBy(long lstUpBy) {
        this.lstUpBy = lstUpBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(Date inactiveDate) {
        this.inactiveDate = inactiveDate;
    }
    
    
}
