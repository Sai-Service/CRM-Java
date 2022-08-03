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
import javax.persistence.GeneratedValue;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Test
 */
@Entity
@NamedNativeQuery(name = "SSRegionMst.findAllRegion", query = "select * from ss_region_mst where valid ='ACTIVE' ", resultClass = SSRegionMst.class)

@Table(name = "ss_region_mst")

public class SSRegionMst implements Serializable {
  
 //   @Id
 //  @javax.persistence.Id
 //  @Column(name = "REGION_ID")
 // private long regionId;
    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "REGION_ID")
    private long regionId=1L;
    
    
    @Column(name = "REGION_NAME")
    private  String regionName;
    
    @Column(name = "VALID")
    private  String valid;

    @Column(name = "CREATION_DATE")
    private  Date creationDt;
    
    @Column(name = "CREATED_BY")
    private  long createdBy;
        
    @Column(name = "UPDATION_DATE")
    private  Date lstUpDate;
    
    @Column(name = "UPDATED_BY")
    private  long lstUpBy;
    
      public SSRegionMst()
    {
        
    }
    
    public SSRegionMst(long regionId, String regionName, String valid,Date creationDt,long createdBy,Date lstUpDate,long lstUpBy) {
        
        this.regionId= regionId;
        this.regionName= regionName;
        this.valid = valid;
        this.creationDt= creationDt;
        this.createdBy= createdBy;
        this.lstUpDate = lstUpDate;
        this.lstUpBy = lstUpBy;
    }

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
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
    
}
