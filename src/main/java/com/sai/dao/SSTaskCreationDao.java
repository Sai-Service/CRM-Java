
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.SsTaskDetails;
import com.sai.model.SSAppoinmentDetails;
import com.sai.model.SSUserDispSummary;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Test
 */
public interface SSTaskCreationDao extends CrudRepository<SsTaskDetails, Long> {

    ////TO DISPLAY DATA IN THE USER FORM SUMMARY///////////////////
    @Query("select NEW com.sai.model.SSUserDispSummary(std.taskId,std.taskType,std.custId,std.custAdd,std.contactNo1,std.vehicleNo,"
            + "std.lastServcType ,std.lastServcLoc,std.callDuDt,std.nextServcDt,std.taskStatus,std.remarks,std.locId,std.nextServcType  ) from SsTaskDetails std where callDuDt=CURRENT_DATE and std.locId=?1 order by std.taskId")
    public List<SSUserDispSummary> getUserSumm(long locId);

    /////TO DISPLAY DATA IN THE ADMIN SUMMARY FORM/////////////////
    @Query("select  NEW com.sai.model.SSUserDispSummary(std.taskId,std.taskType,std.custId,std.custAdd,std.contactNo1,std.vehicleNo,"
            + "std.lastServcType ,std.lastServcLoc,std.callDuDt,std.nextServcDt,std.taskStatus,std.remarks,std.locId,std.nextServcType) from SsTaskDetails std where callDuDt=CURRENT_DATE  and std.locId=?1 and std.taskStatus!='CLOSED' order by std.taskId")
    public List<SSUserDispSummary> getAdminSumm(long locId);

    //////TO DISPLAY ALL THE FUNCTIONS Value//////////////////////         
    @Query("select  count(std.taskId) as count, min(std.taskId) as mincount,max(std.taskId) as maxcount from SsTaskDetails std where callDuDt=CURRENT_DATE and std.locId=?1 order by std.taskId")
    // MassAssignData getMassAssCount(long locId); 
    Map getallfunctions(Integer locId);

    //////TO DISPLAY MARQUEE VALUE FOR CONTACTED CUSTOMER ON HOME PAGE ADMIN//////////////////////         
    @Query("select  count(std.taskId) as contacted from SsTaskDetails std where callDuDt=CURRENT_DATE and contacted='Y' and std.locId=?1 order by std.taskId")
    // MassAssignData getMassAssCount(long locId); 
    Map getContactedCust(int locId);

    ///////////////////FOR REPORT////////////////////
    @Query("select  NEW com.sai.model.SsTaskDetails(std.taskType,  std.taskStatus,  std.callDuDt,  std.custId,   std.custAdd,  std.contactPerson,   std.contactNo1,  std.contactNo2,  std.emailAdd,  std.vehicleNo,std.reason,  std.remarks,  std.taskReason,  std.lastServcDt,  std.lastServcType,  std.lastServcLoc,  std.lastServcKm, std.nextServcDt,  std.nextServcType\n"
            + ") from SsTaskDetails std where std.callDuDt=CURRENT_DATE and std.contacted='Y' and std.locId=?1 order by std.taskId")
    // MassAssignData getMassAssCount(long locId); 
    List<SsTaskDetails> getContactedCustDetails(int locId);

    //////TO DISPLAY MARQUEE VALUE FOR CONTACTED CUSTOMER ON HOME PAGE EXECUTIVE//////////////////////         
    @Query("select  count(std.taskId) as contacted from SsTaskDetails std where callDuDt=CURRENT_DATE and contacted='Y' and std.assigneeId=?1 order by std.taskId")
    // MassAssignData getMassAssCount(long locId); 
    Map getContactedCustExeWise(String assigneeId);

    ///////////////////FOR REPORT////////////////////
    @Query("select  NEW com.sai.model.SsTaskDetails(std.taskType,  std.taskStatus,  std.callDuDt,  std.custId,   std.custAdd,  std.contactPerson,   std.contactNo1,  std.contactNo2,  std.emailAdd,  std.vehicleNo,std.reason,  std.remarks,  std.taskReason,  std.lastServcDt,  std.lastServcType,  std.lastServcLoc,  std.lastServcKm, std.nextServcDt,  std.nextServcType\n"
            + ") from SsTaskDetails std where callDuDt=CURRENT_DATE and contacted='Y' and std.assigneeId=?1 order by std.taskId")
    // MassAssignData getMassAssCount(long locId); 
    List<SsTaskDetails> getContactedCustDetailsExewise(String assigneeId);

    //////TO DISPLAY MARQUEE VALUE FOR UNCONTACTED CUSTOMER ON HOME PAGE ADMIN//////////////////////         
    @Query("select  count(std.taskId) as uncontacted from SsTaskDetails std where callDuDt=CURRENT_DATE and contacted='N' and std.locId=?1 order by std.taskId")
    // MassAssignData getMassAssCount(long locId); 
    Map getUnContactedCust(int locId);

    //////TO DISPLAY MARQUEE VALUE FOR UNCONTACTED CUSTOMER ON HOME PAGE//////////////////////         
    @Query("select  NEW com.sai.model.SsTaskDetails(std.taskType,  std.taskStatus,  std.callDuDt,  std.custId,   std.custAdd,  std.contactPerson, std.contactNo1,  std.contactNo2,  std.emailAdd,  std.vehicleNo,  std.reason,  std.remarks,  std.taskReason,  std.lastServcDt,  std.lastServcType,  std.lastServcLoc,  std.lastServcKm, std.nextServcDt,  std.nextServcType\n"
            + ") from SsTaskDetails std where std.callDuDt=CURRENT_DATE and std.contacted='N' and std.locId=?1 order by std.taskId")
    // MassAssignData getMassAssCount(long locId); 
    List<SsTaskDetails> getUnContactedCustDetails(int locId);

    //////TO DISPLAY MARQUEE VALUE FOR UNCONTACTED CUSTOMER ON HOME PAGE executive//////////////////////         
    @Query("select  count(std.taskId) as uncontacted from SsTaskDetails std where callDuDt=CURRENT_DATE and contacted='N' and std.assigneeId=?1 order by std.taskId")
    // MassAssignData getMassAssCount(long locId); 
    Map getUnContactedCustExewise(String assigneeId);

    ///////////////////////FOR REPORT//////////////////////////////
    @Query("select  NEW com.sai.model.SsTaskDetails(std.taskType,  std.taskStatus,  std.callDuDt,  std.custId,   std.custAdd,  std.contactPerson, std.contactNo1,  std.contactNo2,  std.emailAdd,  std.vehicleNo,  std.reason,  std.remarks,  std.taskReason,  std.lastServcDt,  std.lastServcType,  std.lastServcLoc,  std.lastServcKm, std.nextServcDt,  std.nextServcType\n"
            + ") from SsTaskDetails std where callDuDt=CURRENT_DATE and contacted='N' and std.assigneeId=?1 order by std.taskId")
    List<SsTaskDetails> getUnContactedCustDetailsExewise(String assigneeId);

    //////TO DISPLAY MARQUEE VALUE FOR TOTAL SMS SEND ON HOME PAGE admin//////////////////////         
    @Query("select count(appmnt_id) as smssend from SSAppoinmentDetails std where std.creationDt=CURRENT_DATE and std.locationId=?1")
    // MassAssignData getMassAssCount(long locId); 
    Map getTotalSMSSend(int locId);

    //////TO DISPLAY MARQUEE VALUE FOR TOTAL SMS SEND ON HOME PAGE//////////////////////         
    @Query("select NEW com.sai.model.SSAppoinmentDetails(std.appmntId,  std.vehicleNo,  std.servType,  std.servLoc,  std.servGroup,  std.apptDate,  std.apptTimeSlot,  std.apptStatus, std.pickUp,  std.amount, std.pickAdd, std.remark, std.lastDesposition, std.apptAttended) "
            + " from SSAppoinmentDetails std where std.creationDt=CURRENT_DATE and std.locationId=?1")
    // MassAssignData getMassAssCount(long locId); 
    List<SSAppoinmentDetails> getTotalSMSSendDetails(Integer locationId);

    //////TO DISPLAY MARQUEE VALUE FOR TOTAL SMS SEND ON HOME PAGE executive//////////////////////         
    @Query("select count(appmnt_id) as smssend from SSAppoinmentDetails std where std.creationDt=CURRENT_DATE and std.apptAttended=?1")
    // MassAssignData getMassAssCount(long locId); 
    Map getTotalSMSSendExeWise(String apptAttended);

//////TO DISPLAY MARQUEE VALUE FOR TOTAL SMS SEND ON HOME PAGE//////////////////////         
    @Query("select NEW com.sai.model.SSAppoinmentDetails(std.appmntId,  std.vehicleNo,  std.servType,  std.servLoc,  std.servGroup,  std.apptDate,  std.apptTimeSlot,  std.apptStatus, std.pickUp,  std.amount, std.pickAdd, std.remark, std.lastDesposition, std.apptAttended) "
            + " from SSAppoinmentDetails std where std.creationDt=CURRENT_DATE and std.apptAttended=?1")
    // MassAssignData getMassAssCount(long locId); 
    List<SSAppoinmentDetails> getTotalSMSSendDetailsExewise(String apptAttended);

    ////////TO DISPLAY HIGHEST APPOINMENT TAKEN///////
    @Query(value = "select a.* from (select  std.assignee_id,std.assignee,count(appt.APPMNT_ID) total\n"
            + "from test.ss_task_details std,ss_appoinment_details appt\n"
            + "where  std.task_status!='CLOSED' AND appt.creation_date =curdate() and std.loc_id=?1  \n"
            + " and appt.task_id=std.task_id\n"
            + " group by std.assignee,std.assignee_id) a order by total desc", nativeQuery = true)
    public List<Map> getTotalApptExewise(Integer loc_id);

    //////TO DISPLAY TASK ID//////////////////////         
    @Query("select distinct std.taskId as taskId  from SsTaskDetails std where std.callDuDt=CURRENT_DATE and taskStatus='NEW' and std.locId=?1 and assigneeId is null  order by std.taskId")
    List<Object> getTaskId(Integer locId);

    
    SsTaskDetails findByVehicleNoAndTaskStatus(String vehicle_no, String taskStatus);

    SsTaskDetails findByTaskId(long task_id);

    ///////////////UPDATE THE SS_TASK_DETAILS & SS_ADMINISTRATOR_DATA TASK_TYPE AS CLOSED AFTER CLOSING THE TASK.////////
    @Modifying
    @Transactional
    @Query(value = "update test.ss_task_details set task_status='CLOSED' WHERE TASK_ID=?1", nativeQuery = true)
    public void TaskStatusUpdate(Long TASK_ID);

    //////TO DISPLAY ALL THE Message for EW and MCP End//////////////////////         
    @Query(value = " select concat(\"Customer EW Ending after 15 Days...Ew End Date is : \" ,ewEnDate) Reminder from\n test.ss_vehicle_master where  vehicleNo=?1 and ewEnDate like (curdate()  + interval 15 day ) ", nativeQuery = true)
    // MassAssignData getMassAssCount(long locId); 
    Map getEWMessage(String vehicleNo);

//    @Query(value = " select concat(\"Customer MCP Ending after 15 Days...MCP Date is : \" ,MCPDate) Reminder from\n test.ss_vehicle_master where  vehicleNo=?1 and mcpEnDate like (curdate()  + interval 15 day ) ", nativeQuery = true)
//    Map getMCPMessage(String vehicleNo);

    @Query(value = " select concat(TIMING,\" - \",QUOTA) Slot from test.ss_slot_available WHERE SERVICE_DATE=curdate()\n"
            + "and serv_loc_id=?1 and valid='Y' ", nativeQuery = true)
    public List<Map> getSlotAvail(long serv_loc_id);

    /////TO DISPLAY DATA IN THE USER SUMMARY FORM login wise/////////////////
    @Query(value = "select std.task_id as taskId,std.task_type as taskType,std.cust_name,std.cust_id as custId ,std.contact_no1 as contactNo1,std.cust_name as custName"
            + ",std.vehicle_no as vehicleNo, std.last_servc_type as lastServcType,std.remarks,std.last_servc_loc as lastServcLoc,std.next_servc_type as attribute1,std.call_du_dt as callDuDt"
            + ",std.next_servc_dt as servDuDt,std.task_status as taskStatus,std.loc_id as locId,std.cust_type as custType from ss_task_details std \n"
            + "where  std.task_status!='CLOSED' and std.call_du_dt=curdate() AND std.assignee_id=?1", nativeQuery = true)
    List<Map> getUserSummLoginwise(String assignee_id);

    //To display admin summary--NEW UPDATE ON 11-JUL-2020
//    @Query(value = "SELECT std.task_id as taskid,std.cust_id as custid,std.cust_name,\n"
//            + "std.contact_no1 as contactno1,std.vehicle_no as vehicleno,std.last_servc_dt as lstservdt,std.last_servc_type as lstservtype,last_servc_loc as lstservloc,\n"
//            + "std.next_servc_Dt as nxtservdt,std.next_servc_type as nxtservtype,std.assignee,std.assignee_id as assigneeid\n"
//            + "from test.ss_task_details std\n"
//            + "where std.task_status!='CLOSED' AND std.call_du_dt =curdate() and  std.loc_id=?1  order by std.next_servc_type", nativeQuery = true)
//    List<Map> getMainAdminSummary(Integer loc_id);

    ////////TO DISPLAY yesterday HIGHEST APPOINMENT TAKEN///////
    @Query(value = "select a.* from (select  std.assignee_id as assignee_id1 ,std.assignee as assignee1,count(appt.APPMNT_ID) total1\n"
            + "from test.ss_task_details std,ss_appoinment_details appt\n"
            + "where  std.task_status!='CLOSED' AND appt.creation_date =curdate()- interval 1 day and std.loc_id=?1  \n"
            + " and appt.task_id=std.task_id\n"
            + " group by std.assignee,std.assignee_id) a order by total1 desc  limit 0,10", nativeQuery = true)
    public List<Map> getTotApptExeYesterday(Integer loc_id);

    public List<SsTaskDetails> findByVehicleNo(String vehicleNo);

   
      @Query(value = " select concat(TIMING,\" - \",QUOTA) Slot from test.ss_slot_available WHERE serv_loc_id=?1 and SERVICE_DATE=?2 and valid='Y' ", nativeQuery = true)
    public List<Map> getSlotAvailDatewise(long serv_loc_id, String serviceDate);

     public List<SsTaskDetails> findByAssigneeIdAndLocIdAndTaskStatus(String assigneeId,int locId,String status);//Need to Add Date Also
   
       public List<SsTaskDetails> findByAssigneeIdAndLocIdAndTaskStatusAndCallDuDt(String assigneeId,int locId,String status,Date inputDate);//Need to Add Date Also
   
     
     public List<SsTaskDetails> findByAssigneeIdAndLocIdAndLastServcTypeAndTaskStatusAndCallDuDt(String assigneeId,int locId,String servc_type,String status,Date inputDate);//Need to Add Date Also
     
 public List<SsTaskDetails> findByLocIdAndLastServcTypeAndTaskStatus(int locId,String servc_type,String status);//Need to Add Date Also

    public List<SsTaskDetails> findByLocIdAndLastServcTypeAndTaskStatus(Integer locId, String serType, String aNEW);
    
     public List<SsTaskDetails> findByLocIdAndNextServcTypeAndTaskStatus(Integer locId, String serType, String aNEW);
   
     public List<SsTaskDetails> findByLocIdAndNextServcTypeAndTaskStatusAndCallDuDt(Integer locId, String serType, String aNEW,Date callDuDt);

        @Query(value = " select std.task_Id as taskId from test.ss_task_details std WHERE std.loc_id=?1 and std.NEXT_SERVC_TYPE=?2 and std.task_status=?3 and std.call_du_dt=?4 ", nativeQuery = true)
    public List<Map> getTaskIdNew(Integer locId, String serType, String aNEW,Date callDuDt);

      @Query(value = " select concat(\"Customer MCP Ending after 15 Days...MCP Start Date is : \" ,ifnull(mcpStDate,'-')) Reminder from\n test.ss_vehicle_master where  vehicleNo=?1 and mcpEnDate like (curdate()  + interval 15 day ) ", nativeQuery = true)
    String getMCPMessage(String vehicleNo);
//
    
     //To display admin summary--NEW UPDATE ON 11-JUL-2020
    @Query(value = "SELECT std.task_id as taskid,std.cust_id as custid,std.cust_name,\n"
            + "std.contact_no1 as contactno1,std.vehicle_no as vehicleno,std.last_servc_dt as lstservdt,std.last_servc_type as lstservtype,last_servc_loc as lstservloc,\n"
            + "std.next_servc_Dt as nxtservdt,std.next_servc_type as nxtservtype,std.assignee,std.assignee_id as assigneeid\n"
            + "from test.ss_task_details std\n"
            + "where std.task_status!='CLOSED' and  std.loc_id=?1   AND std.call_du_dt =?2 order by std.next_servc_type", nativeQuery = true)
    List<Map> getMainAdminSummary(Integer loc_id,Date inputDate);


}
