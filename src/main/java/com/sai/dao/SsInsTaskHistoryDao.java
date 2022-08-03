/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.dto.SSInsTaskContactYN;
import com.sai.model.insurance.SsInsTaskHistory;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Swaroopcomp
 */
public interface SsInsTaskHistoryDao extends CrudRepository<SsInsTaskHistory, Integer>{

    public List<SsInsTaskHistory> findByTaskId(Integer taskId);
    
    
    
    @Query(value="Select contactYN,contactedDate,nxtfollowupDate,disposition,remark from test.ss_ins_task_history where taskid=?1", nativeQuery = true)
    List<Map> getInsTaskHistory(Integer taskId);
 
//        @Query("Select NEW com.sai.model.insurance.SsInsTaskHistory(contactYN,contactedDate,nxtfollowupDate,disposition,remark) from SsInsTaskHistory where taskid=?1")
//    List<SsInsTaskHistory>findByTaskId(Integer taskId);
    
     //////TO DISPLAY MARQUEE VALUE FOR CONTACTED CUSTOMER ON ADMIN HOME PAGE//////////////////////         
    @Query(value="select count(sith.taskId) as contacted from test.ss_ins_task_history sith ,ss_ins_task_details sitd \n" +
            "where sith.taskId=sitd.taskId and sith.contactedDate=curdate() and sitd.contactYN='Y' and sitd.locId=?1" , nativeQuery = true)
             Map getInsContactedCust(Integer locId);
 
     //////TO DISPLAY MARQUEE VALUE FOR CONTACTED CUSTOMER ON ADMIN  HOME PAGE//////////////////////         
    @Query(value="select count(sith.taskId) uncontacted from test.ss_ins_task_history sith ,ss_ins_task_details sitd \n" +
            "where sith.taskId=sitd.taskId and sith.contactedDate=curdate() and sitd.contactYN='N' and sitd.locId=?1", nativeQuery = true)
             Map getInsUnContactedCust(Integer locId);
            
     //////TO DISPLAY MARQUEE VALUE FOR appoinment take  CUSTOMER ON ADMIN  HOME PAGE//////////////////////         
    @Query(value="select count(sith.taskId) apptY from test.ss_ins_task_history sith ,ss_ins_task_details sitd \n" +
"where sith.taskId=sitd.taskId and sith.contactedDate=curdate() and sitd.apptYN='Y' and sitd.locId=?1", nativeQuery = true)
             Map getInsApptTakenCust(Integer locId);
  
     //////TO DISPLAY MARQUEE VALUE FOR appoinment not taken CUSTOMER ON ADMIN HOME PAGE//////////////////////         
    @Query(value="select count(sith.taskId) apptN from test.ss_ins_task_history sith ,ss_ins_task_details sitd \n" +
            "where sith.taskId=sitd.taskId and sith.contactedDate=curdate() and sitd.contactYN='N' and sitd.locId=?1", nativeQuery = true)
             Map getInsApptNtTakenCust(Integer locId);
        
        ///////////////////////////////FOR EXECUTIVE HOME PAGE///////////////////////////////////
             
             
   
             
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////          
             
             
             
   //   ----------------------------BELOW ARE THE DETAIL REPORTS FOR ABOVE----------------            
        
  /*       //////TO DISPLAY MARQUEE VALUE FOR appoinment not taken CUSTOMER ON HOME PAGE//////////////////////         
             @Query(value="select NEW com.sai.dto.SSInsTaskContactYN(sitd.taskId,sitd.custId,sitd.vehicleNo,sitd.eventName,sitd.callDueDt,sitd.insEndDate,sitd.eventStatus,\n" +
"sitd.apptYN,sitd.remark,sitd.disposition,sitd.apptDate,sitd.assignId,sitd.custStatus,sitd.insType,sitd.contactYN) from "
            + "sInsTaskHistory sith ,SsInsTaskDetails sitd \n" +
            "where sith.taskId=sitd.taskId and sith.contactedDate=curdate() and sitd.contactYN='Y' and sitd.locId=?1", nativeQuery = true)
       public List<SSInsTaskContactYN> getInsContYCustDetails(long locId);*/
             
          @Query("select NEW  com.sai.dto.SSInsTaskContactYN (sitd.taskId,sitd.custId,sitd.vehicleNo,sitd.eventName,sitd.callDueDt,sitd.insEndDate,sitd.eventStatus,\n" +
"sitd.apptYN,sitd.remark,sitd.disposition,sitd.apptDate,sitd.assignId,sitd.custStatus,sitd.insType) from "
            + " SsInsTaskHistory sith ,SsInsTaskDetails sitd \n" +
            "where sith.taskId=sitd.taskId and sith.contactedDate=curdate() and sitd.contactYN='Y' and sitd.locId=?1 ")
       public List<SSInsTaskContactYN> getInsContYCustDetails(Integer locId);     
        

     @Query("select NEW  com.sai.dto.SSInsTaskContactYN (sitd.taskId,sitd.custId,sitd.vehicleNo,sitd.eventName,sitd.callDueDt,sitd.insEndDate,sitd.eventStatus,\n" +
"sitd.apptYN,sitd.remark,sitd.disposition,sitd.apptDate,sitd.assignId,sitd.custStatus,sitd.insType) from "
            + " SsInsTaskHistory sith ,SsInsTaskDetails sitd \n" +
            "where sith.taskId=sitd.taskId and sith.contactedDate=curdate() and sitd.contactYN='N' and sitd.locId=?1 ")
       public List<SSInsTaskContactYN> getInsContNCustDetails(Integer locId);

       

     @Query("select NEW  com.sai.dto.SSInsTaskContactYN (sitd.taskId,sitd.custId,sitd.vehicleNo,sitd.eventName,sitd.callDueDt,sitd.insEndDate,sitd.eventStatus,\n" +
"sitd.apptYN,sitd.remark,sitd.disposition,sitd.apptDate,sitd.assignId,sitd.custStatus,sitd.insType) from "
            + " SsInsTaskHistory sith ,SsInsTaskDetails sitd \n" +
            "where sith.taskId=sitd.taskId and sith.contactedDate=curdate() and sitd.apptYN='N' and sitd.locId=?1 ")
       public List<SSInsTaskContactYN> getInsApptNDetails(Integer locId);

     
     @Query("select NEW  com.sai.dto.SSInsTaskContactYN (sitd.taskId,sitd.custId,sitd.vehicleNo,sitd.eventName,sitd.callDueDt,sitd.insEndDate,sitd.eventStatus,\n" +
"sitd.apptYN,sitd.remark,sitd.disposition,sitd.apptDate,sitd.assignId,sitd.custStatus,sitd.insType) from "
            + " SsInsTaskHistory sith ,SsInsTaskDetails sitd \n" +
            "where sith.taskId=sitd.taskId and sith.contactedDate=curdate() and sitd.apptYN='Y' and sitd.locId=?1 ")
       public List<SSInsTaskContactYN> getInsApptYDetails(Integer locId);
       
       public Optional<SsInsTaskHistory> findById(Integer id);

    public List<SsInsTaskHistory> findByTaskIdAndContactedDate(Integer id, Date currentDate);
            
             
             
             
             
}
