/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.SalesTaskDetails;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Lenovo
 */
public interface SalesTaskDetailsDao extends CrudRepository<SalesTaskDetails, Long>{

    public List<SalesTaskDetails> findByLocId(Integer locId);
 ///SalesTaskDetails

    public Optional<SalesTaskDetails> findByTaskId(long taskId);

    public List<SalesTaskDetails> findByOrgIdAndTaskStatus(Integer orgId, String aNEW);

    public List<SalesTaskDetails> findByLocIdAndTaskStatus(Integer locId, String aNEW);
    
     @Query("select distinct std from SalesTaskDetails std where std.locId=?1 and std.taskStatus=?2 and std.convertSOYN in ('ENTERED','BOOKED','N') order by std.taskId")
    List<SalesTaskDetails> getByLocIDandTask(Integer locId,String aNEW);
    
    
    
     @Query("select distinct std.taskId as taskId  from SalesTaskDetails std where std.locId=?1 and taskAssigneeId is null  order by std.taskId")
    List<Object> getTaskProforma(Integer locId);
    
    
    @Modifying
   @Transactional
   @Query(value="update sales_task_details set assignee=?1,taskAssigneeId=?2 WHERE taskId=?3 and taskStatus!='CLOSED'",nativeQuery=true)
    public void UpdateAssigneeTaskIdwise(String assignee ,String ASSIGNEE_ID,long taskId );  
   

       @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value=" update sales_task_details sad set sad.assignee=?1 , sad.taskAssigneeId=?2 "
            + " where  sad.taskStatus!='CLOSED' and sad.taskId between ?3 and ?4 and sad.locId=?5",nativeQuery=true)
    int updateAssignIdwithLocPR(String assignee,String taskAssigneeId, long FROMTASK_ID,long TOTASK_ID , long loc_id );

    public List<SalesTaskDetails> findByTaskAssigneeId(String taskAssigneeId);

    public List<SalesTaskDetails> findByTaskAssigneeIdAndTaskStatus(String taskAssigneeId, String aNEW);
    
         @Query("select distinct std from SalesTaskDetails std where std.locId=?1 and std.taskStatus=?2 and std.convertSOYN in ('ENTERED','BOOKED','N') order by std.taskId")
    List<SalesTaskDetails> getByAssigneeStatus(Integer locId,String aNEW);
    
    
   
  //    public List<SalesTaskDetails> findByTaskAssigneeIdAndTaskStatus(String taskAssigneeId, String aNEW);
      
   @Query("select distinct std from SalesTaskDetails std where std.taskAssigneeId=?1 and std.callDuDt between ?2 and ?3 and std.taskStatus='NEW'  order by std.taskId")
    List<SalesTaskDetails> getTaskProformaByDate(String taskAssigneeId,Date fromDate,Date toDate1);
    
}
