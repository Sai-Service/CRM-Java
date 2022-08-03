/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Test
 */
@Entity
@Table(name = "ss_sql_job_creation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SsSqlJobCreation.findAll", query = "SELECT s FROM SsSqlJobCreation s")})
public class SsSqlJobCreation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "srNumber")
    private String srNumber;
    @Size(max = 20)
    @Column(name = "repairNumber")
    private String repairNumber;
    @Size(max = 45)
    @Column(name = "vehicleNo")
    private String vehicleNo;
    @Column(name = "creationDate")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Size(max = 60)
    @Column(name = "serAdvisor")
    private String serAdvisor;

    public SsSqlJobCreation() {
    }

    public SsSqlJobCreation(String srNumber) {
        this.srNumber = srNumber;
    }

    public String getSrNumber() {
        return srNumber;
    }

    public void setSrNumber(String srNumber) {
        this.srNumber = srNumber;
    }

    public String getRepairNumber() {
        return repairNumber;
    }

    public void setRepairNumber(String repairNumber) {
        this.repairNumber = repairNumber;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getSerAdvisor() {
        return serAdvisor;
    }

    public void setSerAdvisor(String serAdvisor) {
        this.serAdvisor = serAdvisor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (srNumber != null ? srNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsSqlJobCreation)) {
            return false;
        }
        SsSqlJobCreation other = (SsSqlJobCreation) object;
        if ((this.srNumber == null && other.srNumber != null) || (this.srNumber != null && !this.srNumber.equals(other.srNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sai.model.SsSqlJobCreation[ srNumber=" + srNumber + " ]";
    }
    
}
