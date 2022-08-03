/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.ActiveStatus;
import com.sai.model.CALLTYPE;
import com.sai.model.LoginRole;
import com.sai.model.LoginCallType;
import com.sai.model.ColorCode;
import com.sai.model.CommonAllType;
import com.sai.model.CustType;
import com.sai.model.Designation;
import com.sai.model.DeptName;
import com.sai.model.Despositions;
import com.sai.model.DivCode;
import com.sai.model.FuelType;
import com.sai.model.ModelCode;
import com.sai.model.ReasonCode;
import com.sai.model.ServiceCallBasedOn;
import com.sai.model.ServiceType;
import com.sai.model.SsCommonList;
import com.sai.model.StateName;
import com.sai.model.SubCategory;
import com.sai.model.TaskStatus;
import com.sai.model.YNCode;
import com.sai.model.insurance.CustStatus;
import com.sai.model.insurance.EventDisposition;
import com.sai.model.insurance.EventType;
import com.sai.model.insurance.PolicyRenwType;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Test
 */

   
   public interface SsCommonListDao extends CrudRepository<SsCommonList, Long>{
  @Query("select distinct NEW com.sai.model.StateName(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='STATE' order by scl.cmName")
  public List<StateName> getStateNames();
  
   @Query("select distinct NEW com.sai.model.ColorCode(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='COLOR'")
  public List<ColorCode> getColorCode();


 @Query("select distinct NEW com.sai.model.ModelCode(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='MODEL'")
  public List<ModelCode> getModelCode();

  @Query("select distinct NEW com.sai.model.DeptName(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='DEPT'")
  public List<DeptName> getDeptCode();

 @Query("select distinct NEW com.sai.model.ServiceType(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='SRTYPE'")
  public List<ServiceType> getServiceType();
  
  @Query("select distinct NEW com.sai.model.SubCategory(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='SUBCTG'")
  public List<SubCategory> getSubCategory();

  @Query("select distinct NEW com.sai.model.Despositions(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='DESPO'")
  public List<Despositions> getDespositions();

 @Query("select distinct NEW com.sai.model.ReasonCode(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='RESN'")
 public List<ReasonCode> getReasonCode();

@Query("select distinct NEW com.sai.model.YNCode(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='YN'")
 public List<YNCode> getYNCode();

@Query("select distinct NEW com.sai.model.DivCode(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='DIV'")
 public List<DivCode> getDivCode();

 @Query("select distinct NEW com.sai.model.CALLTYPE(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='CLTYPE'")
 public List<CALLTYPE> getCALLTYPE();
 
 @Query("select distinct NEW com.sai.model.ServiceCallBasedOn(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='SRBASE'")
 public List<ServiceCallBasedOn> getServiceClBsOn(); 

  @Query("select distinct NEW com.sai.model.FuelType(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='FUEL'")
 public List<FuelType> getFuelType(); 

 @Query("select distinct NEW com.sai.model.ActiveStatus(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='STATUS'")
 public List<ActiveStatus> getActiveStatus(); 

@Query("select distinct NEW com.sai.model.CommonAllType(scl.type,scl.typeDesc)  from SsCommonList scl where scl.status='ACTIVE' order by scl.type")
public List<CommonAllType>  getDisTypes(); 

@Query("select distinct NEW com.sai.model.CustType(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='CUSTTYPE'")
 public List<CustType> getCustType(); 

@Query("select distinct NEW com.sai.model.TaskStatus(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='TASKTYPE'")
 public List<TaskStatus> getTaskType(); 
 
 
 
 public List<SsCommonList> findByCmnType(String type);
  
@Query("select distinct NEW com.sai.model.LoginRole(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='ROLE'")
public List<LoginRole> getLoginRole(); 
  
 @Query("select distinct NEW com.sai.model.LoginCallType(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='LCALLTYPE'")
public List<LoginCallType> getLoginCallType(); 

 @Query("select distinct NEW com.sai.model.insurance.CustStatus(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='CUSTSTATUS'")
public List<CustStatus> getCustStatus(); 

 @Query("select distinct NEW com.sai.model.insurance.EventType(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='EVENTTYPE'")
public List<EventType> getEventType(); 

 @Query("select distinct NEW com.sai.model.insurance.EventDisposition(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='EVENTDISP'")
public List<EventDisposition> getEventDisposition(); 

 @Query("select distinct NEW com.sai.model.insurance.PolicyRenwType(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='RENWTY'")
public List<PolicyRenwType> getPolicyRenwType(); 
  //@Query("select distinct NEW com.sai.model.ModelName(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='MODEL'")
  //public List<ModelCode> getModelCode(); 


 @Query("select distinct NEW com.sai.model.Designation(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='DESG'")
  public List<Designation> getDesignation();
  
  @Query("select distinct NEW com.sai.model.Despositions(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='YEVENTDISP'")
  public List<Despositions> getYEventDespositions();
        
  @Query("select distinct NEW com.sai.model.Despositions(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='NEVENTDISP'")
  public List<Despositions> getNEventDespositions();
  
  @Query("select distinct NEW com.sai.model.Despositions(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='PAYMENTMODE'")
  public List<Despositions> getPaymentMode();
  
  @Query("select distinct NEW com.sai.model.Despositions(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='CMNLST'")
  public List<Despositions> getCmnList();

  @Query("select distinct NEW com.sai.model.Despositions(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.cmName=?1")
  public List<Despositions> findByManuallyCmCode(String cmName);  

 @Query("select distinct NEW com.sai.model.Despositions(scl.cmCode,scl.cmName,scl.cmDesc,scl.type)  from SsCommonList scl where scl.type='SMSTYPE'")
  public List<Despositions> getSmsType();
   
  
  }
