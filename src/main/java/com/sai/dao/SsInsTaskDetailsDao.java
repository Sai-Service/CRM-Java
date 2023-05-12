/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.SSUserDispSummary;
import com.sai.model.SsCustomer;
import com.sai.model.UserLogin;
import com.sai.model.insurance.SsInsTaskDetails;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Swaroopcomp
 */
public interface SsInsTaskDetailsDao extends CrudRepository<SsInsTaskDetails, Integer> {

    public SsInsTaskDetails findByTaskId(Integer id);

    public SsInsTaskDetails findByTaskIdAndLocId(Integer id, Integer locId);

    public List<SsInsTaskDetails> findByLocIdAndAssignIdAndCallDueDt(Integer locId, String User, Date curdate);

    public List<SsInsTaskDetails> findByLocIdAndCallDueDt(Integer locId, Date curdate);

    //   public List<Object> findByLocIdAndCallDueDt(Integer locId, Date curdate);
    @Query(value = "select distinct std.taskId,sc.cust_Name,sc.custAcctNo ,std.vehicleNo,std.eventName,std.callDueDt,\n"
            + "std.insEndDate,std.eventStatus,std.custStatus,std.custid,std.printRenewal, std.apptYN,\n"
            + "std.remark,std.disposition,std.apptAddress,std.assignId,std.createdBy,std.lstUpdBy,std.insType,\n"
            + "std.contactYN,std.apptDate ,vm.dtOfPurchase,vm.model,vm.variant \n"
            + "from test.Ss_Ins_Task_Details std,ss_cust_new sc , ss_vehicle_master vm where std.eventStatus!='CLOSED' and std.vehicleNo=vm.vehicleNo and sc.custacctno=std.custId and std.locId=?1 \n"
            + "and std.assignId=?2 and std.callDueDt=?3", nativeQuery = true)
    public List<Map> getTaskData(Integer locId, String User, Date curdate);

    @Query(value = "select distinct std.taskId,sc.cust_Name,sc.custAcctNo ,std.vehicleNo,std.eventName,std.callDueDt,\n"
            + "std.insEndDate,std.eventStatus,std.custStatus,std.custid,std.printRenewal, std.apptYN,\n"
            + "std.remark,std.disposition,std.apptAddress,std.assignId,std.createdBy,std.lstUpdBy,std.insType,\n"
            + "std.contactYN,std.apptDate \n"
            + "from test.Ss_Ins_Task_Details std,ss_cust_new sc where std.eventStatus='CLOSED' and sc.custacctno=std.custId and std.locId=?1 \n"
            + "and  std.callDueDt=?2", nativeQuery = true)
    public List<Map> getTaskDataLocWise(Integer locId, Date curdate);

    public SsInsTaskDetails findByVehicleNo(String vehicleNo);

    //SELECT TICKET_NO FROM test.user_login where ROLE='USER' AND TYPE = 'INSURANCE' AND REPORTING_TO =?1 and LOC_ID=?2;
    @Query(value = "SELECT TICKET_NO ,LOC_ID FROM test.user_login where ROLE='USER' AND TYPE = 'INSURANCE' AND REPORTING_TO =?1 ", nativeQuery = true)
    public List<Map> getUserList(String loginName);

    @Query(value = "select count(ul1.login_name)  as usercount from test.user_login ul,test.user_login ul1, test.ss_loc_access sla \n"
            + "where ul.login_name=sla.user_name AND sla.loc_access=UL1.loc_id and ul1.role='USER' AND sla.valid='Y'\n"
            + "and ul.login_name=?1", nativeQuery = true)
    public Object getUsercount(String login_name);

//        @Query("select distinct std.taskId as taskId  from SsTaskDetails std where std.callDuDt=CURRENT_DATE and std.locId=?1 order by std.taskId")
//    List<Object> getTaskId(long locId);
    //public int countByLoginName(String loginName);
    // @Query("UPDATE SsInsTaskDetails instask SET instask.assignId = ?1 WHERE insTask.taskId BETWEEN ?2 AND ?3")
    List<SsInsTaskDetails> findByTaskIdBetween(int start, int end);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE SsInsTaskDetails instask SET instask.assignId = ?1 WHERE instask.taskId BETWEEN ?2 AND ?3 AND  instask.locId=?4 and  instask.assignId is null")
    int updateAssignIdwithLoc(String assigneeId, int start, int end, int locId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE SsInsTaskDetails instask SET instask.assignId = ?1 WHERE instask.taskId BETWEEN ?2 AND ?3 ")
    int updateAssignId(String assigneeId, int start, int end);

    @Modifying
    @Transactional
    @Query(value = "update ss_ins_task_details set assignId=?1 WHERE taskId=?2 and eventStatus!='CLOSED'", nativeQuery = true)
    public void UpdateAssigneeTaskIdwise(String assignee, long taskId);

   // public SsInsTaskDetails findByVehicleNoAndStatus(String vehicleNo, String active);

    public SsInsTaskDetails findByVehicleNoAndEventStatus(String vehicleNo, String aNEW);

       @Query("select std from SsInsTaskDetails std where vehicleNo=?1 and eventStatus !='CLOSED'")
    public SsInsTaskDetails getByVehStatus(String vehicleNo);
    
     @Query("select max(taskId) from SsInsTaskDetails")
    public Integer getMaxTaskId();
     
}
