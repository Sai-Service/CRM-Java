/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Test
 */
@Entity
@Table(name = "deptmaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deptmaster.findAll", query = "SELECT d FROM Deptmaster d")})
public class Deptmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "deptCode")
    private Integer deptCode;
    @Size(max = 45)
    @Column(name = "deptName")
    private String deptName;
    @OneToMany(mappedBy = "empDept")
    private Collection<Employeemst> employeemstCollection;

    public Deptmaster() {
    }

    public Deptmaster(Integer deptCode) {
        this.deptCode = deptCode;
    }

    public Integer getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(Integer deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @XmlTransient
    public Collection<Employeemst> getEmployeemstCollection() {
        return employeemstCollection;
    }

    public void setEmployeemstCollection(Collection<Employeemst> employeemstCollection) {
        this.employeemstCollection = employeemstCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptCode != null ? deptCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deptmaster)) {
            return false;
        }
        Deptmaster other = (Deptmaster) object;
        if ((this.deptCode == null && other.deptCode != null) || (this.deptCode != null && !this.deptCode.equals(other.deptCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sai.model.Deptmaster[ deptCode=" + deptCode + " ]";
    }
    
}
