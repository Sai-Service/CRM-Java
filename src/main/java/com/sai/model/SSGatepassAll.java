/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Id;
/**
 *
 * @author Test
 */
@Entity
@Table(name = "ss_gatepass_all")
@NamedNativeQuery(name = "SSGatepassAll.findByGatepassId", query = "select * from ss_gatepass_all where gatepass_id = ?1 ", resultClass = SSGatepassAll.class)

public class SSGatepassAll implements Serializable {
    
    @Id
    @GeneratedValue
     @Column(name = "ID")
    private long id;
    
    @Column(name = "GATEPASS_ID")
    private long gatepassId;
    
    @Column(name = "DELIVERY_DATE")
    private  String deliveryDate;
    
    @Column(name = "DEL_TIME")
    private  String delvTime;

    @Column(name = "CUST_NAME")
    private String custName;
    
    @Column(name = "CUST_ID")
    private  long custId;
    
    @Column(name = "CUST_ADDRESS1")
    private  String custAddress1;
    
    @Column(name = "CUST_TYPE")
    private String custType;
    
    @Column(name = "CONTACT_NO")
    private  String contactNo;
    
    @Column(name = "VEH_NO")
    private  String VehNo;
    
    @Column(name = "ITEM_ID")
    private long itemId;
    
    @Column(name = "ORG_ID")
    private  long orgId;
    
    @Column(name = "LOC_ID")
    private  long locId;
    
    @Column(name = "SERVICE_LOC")
    private  String servLoc;
    
    @Column(name = "REFERENCE_NO")
    private  String refNo;
    
    @Column(name = "SERVICE_TYPE")
    private  String servType;
        
    @Column(name = "LAST_KM")
    private  long lastKM;
    
    @Column(name = "MODEL")
    private  String model;
        
    @Column(name = "MODEL_DESC")
    private  String modelDesc;   
    
    @Column(name = "CHASSIS_NO")
    private  String chassisNo;   

    @Column(name = "ENGINE_NO")
    private  String engineNo;   

    @Column(name = "DEPT_CODE")
    private  String deptCode;   

    @Column(name = "TASK_ID")
    private  Integer taskId;       

    @Column(name = "INTERFACE_STATUS")
    private  String interStatus; 
        
    @Column(name = "CREATED_BY")
    private  long createdBy; 
            
    @Column(name = "CREATION_DATE")
    private  String creationDate;
 
        
    @Column(name = "LAST_UPDATED_BY")
    private  long lstUpBy; 
            
    @Column(name = "LAST_UPDATION_DATE")
    private  String lstUpDate;
    
            
    @Column(name = "ATTRIBUTE1")
    private  String attribute1; 
            
    @Column(name = "ATTRIBUTE2")
    private  String attribute2;
    
    @Column(name = "ATTRIBUTE3")
    private  String attribute3; 
            
    @Column(name = "ATTRIBUTE4")
    private  String attribute4;
    
    @Column(name = "ATTRIBUTE5")
    private  String attribute5;    
    
    public SSGatepassAll()
    {
        
    }
    
    public SSGatepassAll(long gatepassId, String delvDate, String delvTime,String custName,long custId,String custAddress1,String custType,String contactNo,String VehNo,
            long itemId,long orgId,long locId,String servLoc,String refNo,String servType,long lastKM,String model,String modelDesc,String chassisNo,String engineNo
            ,String deptCode,Integer taskId,String interStatus,long createdBy,String creationDate,long lstUpBy,String lstUpDate,String attribute1,String attribute2,String attribute3,String attribute4,String attribute5) {
        this.gatepassId= gatepassId;
        this.deliveryDate= delvDate;
        this.delvTime = delvTime;
        this.custName= custName;
        this.custId= custId;
        this.custAddress1 = custAddress1;
        this.custType= custType;
        this.contactNo= contactNo;
        this.VehNo=VehNo;
        this.itemId=itemId;
        this.orgId=orgId;
        this.locId=locId;
        this.servLoc=servLoc;        
        this.refNo = refNo;
        this.servType= servType;
        this.lastKM= lastKM;
        this.model = model;
        this.modelDesc= modelDesc;
        this.chassisNo= chassisNo;
        this.engineNo = engineNo;
        this.deptCode= deptCode;
        this.taskId = taskId;
        this.interStatus=interStatus;
        this.createdBy=createdBy;
        this.creationDate=creationDate;
        this.lstUpBy=lstUpBy;
        this.lstUpDate=lstUpDate;
        this.attribute1= attribute1;
        this.attribute2= attribute2;
        this.attribute3 = attribute3;
        this.attribute4= attribute4;
        this.attribute5 = attribute5;
    }

    public SSGatepassAll(long id, long gatepassId, String deliveryDate, String custName, long custId, String contactNo, String VehNo, long orgId, long locId, String servLoc, String refNo, String servType, long lastKM, String model, String chassisNo, String engineNo, String deptCode) {
        this.id = id;
        this.gatepassId = gatepassId;
        this.deliveryDate = deliveryDate;
        this.custName = custName;
        this.custId = custId;
        this.contactNo = contactNo;
        this.VehNo = VehNo;
        this.orgId = orgId;
        this.locId = locId;
        this.servLoc = servLoc;
        this.refNo = refNo;
        this.servType = servType;
        this.lastKM = lastKM;
        this.model = model;
        this.chassisNo = chassisNo;
        this.engineNo = engineNo;
        this.deptCode = deptCode;
    }
    
    
    

    public long getGatepassId() {
        return gatepassId;
    }

    public void setGatepassId(long gatepassId) {
        this.gatepassId = gatepassId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

  

    public String getDelvTime() {
        return delvTime;
    }

    public void setDelvTime(String delvTime) {
        this.delvTime = delvTime;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getCustAddress1() {
        return custAddress1;
    }

    public void setCustAddress1(String custAddress1) {
        this.custAddress1 = custAddress1;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getVehNo() {
        return VehNo;
    }

    public void setVehNo(String VehNo) {
        this.VehNo = VehNo;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public long getLocId() {
        return locId;
    }

    public void setLocId(long locId) {
        this.locId = locId;
    }

    public String getServLoc() {
        return servLoc;
    }

    public void setServLoc(String servLoc) {
        this.servLoc = servLoc;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getServType() {
        return servType;
    }

    public void setServType(String servType) {
        this.servType = servType;
    }

    public long getLastKM() {
        return lastKM;
    }

    public void setLastKM(long lastKM) {
        this.lastKM = lastKM;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelDesc() {
        return modelDesc;
    }

    public void setModelDesc(String modelDesc) {
        this.modelDesc = modelDesc;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getInterStatus() {
        return interStatus;
    }

    public void setInterStatus(String interStatus) {
        this.interStatus = interStatus;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public long getLstUpBy() {
        return lstUpBy;
    }

    public void setLstUpBy(long lstUpBy) {
        this.lstUpBy = lstUpBy;
    }

    public String getLstUpDate() {
        return lstUpDate;
    }

    public void setLstUpDate(String lstUpDate) {
        this.lstUpDate = lstUpDate;
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

    
}
