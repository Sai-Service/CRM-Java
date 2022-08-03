/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
 * @author Swaroopcomp
 */
@Entity
@Table(name = "ss_service_advisor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SsServiceAdvisor.findAll", query = "SELECT s FROM SsServiceAdvisor s")})
public class SsServiceAdvisor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String ticketNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String advisorName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    private String group;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private Integer location;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String contactNo1;
    @Size(max = 45)
    private String contactNo2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String desgination;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    private Integer createdBy;
    @Temporal(TemporalType.DATE)
    private Date updationDate;
    private Integer updatedBy;
    private String status;
    private Date inactiveDate;
    private String dept; 
    
    public SsServiceAdvisor() {
    }

    public SsServiceAdvisor(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public SsServiceAdvisor(String ticketNo, String advisorName, String group, Integer location, String contactNo1, String desgination,String status,Date inactiveDate,String dept) {
        this.ticketNo = ticketNo;
        this.advisorName = advisorName;
        this.group = group;
        this.location = location;
        this.contactNo1 = contactNo1;
        this.desgination = desgination;
        this.status=status;
        this.inactiveDate=inactiveDate;
        this.dept=dept;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    
    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
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

    public String getDesgination() {
        return desgination;
    }

    public void setDesgination(String desgination) {
        this.desgination = desgination;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdationDate() {
        return updationDate;
    }

    public void setUpdationDate(Date updationDate) {
        this.updationDate = updationDate;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
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

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketNo != null ? ticketNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsServiceAdvisor)) {
            return false;
        }
        SsServiceAdvisor other = (SsServiceAdvisor) object;
        if ((this.ticketNo == null && other.ticketNo != null) || (this.ticketNo != null && !this.ticketNo.equals(other.ticketNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sai.model.SsServiceAdvisor[ ticketNo=" + ticketNo + " ]";
    }
    
}
