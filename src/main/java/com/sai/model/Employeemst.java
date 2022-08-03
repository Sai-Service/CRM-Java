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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Test
 */
@Entity
@Table(name = "employeemst")

public class Employeemst implements Serializable {

    @Size(max = 100)
    @Column(name = "empName")
    private String empName;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ticketNo")
    private Integer ticketNo;
    
    
    @Column(name = "empDept")
    private Integer empDept;
    
    @Column(name = "contactNo")
    private BigInteger contactNo;
    
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;

    public Employeemst() {
    }

    public Employeemst(Integer ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Integer getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(Integer ticketNo) {
        this.ticketNo = ticketNo;
    }


    public Integer getEmpDept() {
        return empDept;
    }

    public void setEmpDept(Integer empDept) {
        this.empDept = empDept;
    }

    public BigInteger getContactNo() {
        return contactNo;
    }

    public void setContactNo(BigInteger contactNo) {
        this.contactNo = contactNo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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
        if (!(object instanceof Employeemst)) {
            return false;
        }
        Employeemst other = (Employeemst) object;
        if ((this.ticketNo == null && other.ticketNo != null) || (this.ticketNo != null && !this.ticketNo.equals(other.ticketNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sai.model.Employeemst[ ticketNo=" + ticketNo + " ]";
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
    
}
