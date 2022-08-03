/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.PendingApptCurDate;
import com.sai.model.SSAppoinmentDetails;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Test
 */
public interface SSAppoinmentDetailsDao extends CrudRepository<SSAppoinmentDetails, Long>{
    
  SSAppoinmentDetails findByTaskId(long taskId);
  
    List<SSAppoinmentDetails>findByVehicleNo(String vehicleNo);

    //////TO DISPLAY MARQUEE VALUE FOR pick up CUSTOMER ON HOME PAGE admin //////////////////////         
    @Query("select  count(std.appmntId) as pickUp from SSAppoinmentDetails std where std.creationDt=CURRENT_DATE and pickUp='Y' and std.locationId=?1 order by std.appmntId")
    Map getAppoinmentPickup(int locationId);
    
    @Query("select  NEW com.sai.model.SSAppoinmentDetails(std.appmntId,  std.vehicleNo,  std.servType,  std.servLoc,  std.servGroup,  std.apptDate,  std.apptTimeSlot,  std.apptStatus, std.pickUp,  std.amount, std.pickAdd, std.remark, std.lastDesposition, std.apptAttended)  from SSAppoinmentDetails std where std.creationDt=CURRENT_DATE and std.pickUp='Y' and std.locationId=?1 order by std.appmntId")
    List<SSAppoinmentDetails> findByLocationIdApptPickup(int locationId);
 
    /////TO DISPLAY MARQUEE VALUE FOR pick up CUSTOMER ON HOME PAGE executive//////////////////////         
    @Query("select  count(std.appmntId) as pickUp from SSAppoinmentDetails std where std.creationDt=CURRENT_DATE and pickUp='Y' and std.apptAttended=?1 order by std.appmntId")
    Map getAppoinmentPickupExecwise(String apptAttended);
  
    ////for DETAILS Report--Executivewise//////////////
    @Query("select  NEW com.sai.model.SSAppoinmentDetails(std.appmntId,  std.vehicleNo,  std.servType,  std.servLoc,  std.servGroup,  std.apptDate,  std.apptTimeSlot,  std.apptStatus, std.pickUp,  std.amount, std.pickAdd, std.remark, std.lastDesposition, std.apptAttended)  from SSAppoinmentDetails std where std.creationDt=CURRENT_DATE and std.pickUp='Y' and std.apptAttended=?1 order by std.appmntId")
    List<SSAppoinmentDetails> findByLocationIdApptPickupExecwise(String apptAttended);
    
    
      //////TO DISPLAY MARQUEE VALUE FOR UNCONTACTED admin ON HOME PAGE//////////////////////         
    @Query("select  count(std.appmntId) as appoinment from SSAppoinmentDetails std where std.creationDt=CURRENT_DATE and std.locationId=?1 order by std.appmntId")
    Map getAppoinmentCount(int locationId);
   
      //////TO DISPLAY MARQUEE details on click FOR totol appoinement taken today CUSTOMER ON HOME PAGE//////////////////////         
    @Query("select  NEW com.sai.model.SSAppoinmentDetails(std.appmntId,  std.vehicleNo,  std.servType,  std.servLoc,  std.servGroup,  std.apptDate,  std.apptTimeSlot,  std.apptStatus, std.pickUp,  std.amount, std.pickAdd, std.remark, std.lastDesposition, std.apptAttended)  from SSAppoinmentDetails std  where std.creationDt=CURRENT_DATE and std.locationId=?1 order by std.appmntId")
     List<SSAppoinmentDetails> findByLocationIdtApptCntDetails(Integer locationId);
    
       //////TO DISPLAY MARQUEE VALUE FOR UNCONTACTED executive ON HOME PAGE//////////////////////         
    @Query("select  count(std.appmntId) as appoinment from SSAppoinmentDetails std where std.creationDt=CURRENT_DATE and std.apptAttended=?1 order by std.appmntId")
    Map getAppoinmentCountExewise(String apptAttended);
    
       ////// ////for DETAILS Report--Executivewise//////////////
     @Query("select  NEW com.sai.model.SSAppoinmentDetails(std.appmntId,  std.vehicleNo,  std.servType,  std.servLoc,  std.servGroup,  std.apptDate,  std.apptTimeSlot,  std.apptStatus, std.pickUp,  std.amount, std.pickAdd, std.remark, std.lastDesposition, std.apptAttended)  from SSAppoinmentDetails std  where std.creationDt=CURRENT_DATE and std.apptAttended=?1 order by std.appmntId")
     List<SSAppoinmentDetails> findByLocationIdtApptCntDetailsExewise(String apptAttended);
    
   
     
         @Query("select NEW com.sai.model.PendingApptCurDate(spd.appmntId,spd.vehicleNo,std.contactPerson,spd.servType,spd.servLoc,spd.servGroup,spd.apptDate,spd.apptTimeSlot,spd.apptStatus,spd.pickupMms,\n" +
"spd.pickUp,spd.pickupTime,spd.amount,spd.pickAdd,spd.remark,spd.lastDesposition,spd.apptAttended,spd.advName,std.contactNo1,std.contactNo2) from "
            + " SSAppoinmentDetails spd,SsTaskDetails std \n" +
            "where spd.attribute1!='Job Created' and spd.apptDate=curdate() and spd.locationId=?1 and std.taskId=spd.taskId ")
       public List<PendingApptCurDate> getPendingApptCurDate(Integer locationId);
}

