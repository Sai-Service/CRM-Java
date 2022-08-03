/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.SsAdministratorData;
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
 
 //public interface SSAdministratorDataDao extends CrudRepository<SsTaskDetails, Long>
 //{
 public interface SSAdministratorDataDao extends CrudRepository<SsAdministratorData, Long>
 {
   // public void save(SsAdministratorData adminData);
//
//   @Modifying
//   @Transactional
// //  @Query(value="update test.ss_administrator_data set Status=?1 WHERE TASK_ID=?2",nativeQuery=true)
//     @Query(value="update test.ss_administrator_data set Status='CLOSED' WHERE TASK_ID=?1",nativeQuery=true)
// // public List<Map> UpdateAssignee(String assignee ,String ASSIGNEE_ID,Long FROMTASK_ID,Long TOTASK_ID );  
//    public void AdmintatusUpdate(Long TASK_ID );  
//  
//    
//      //////TO DISPLAY TASK ID//////////////////////         
////    @Query("select distinct std.admnId as admnId  from SsAdministratorData std where std.taskId=?1 ")
//    List<Map> getAdminId(long taskId);
//
//    
//    SsAdministratorData findByTaskId(long task_id);
//  
//    SsAdministratorData findAdminIdByTaskId(long task_id);
//   // public void save(SsAdministratorData adminData);
            
    
 }
