/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

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
public interface SsInsTaskDetailsDao extends CrudRepository<SsInsTaskDetails, Integer>{

    public SsInsTaskDetails findByTaskId(Integer id);
    
    
    public SsInsTaskDetails findByTaskIdAndLocId(Integer id,Integer locId);

    public List<SsInsTaskDetails> findByLocIdAndAssignIdAndCallDueDt(Integer locId, String User, Date curdate);
    public List<SsInsTaskDetails> findByLocIdAndCallDueDt(Integer locId, Date curdate);

    public SsInsTaskDetails findByVehicleNo(String vehicleNo);

    //SELECT TICKET_NO FROM test.user_login where ROLE='USER' AND TYPE = 'INSURANCE' AND REPORTING_TO =?1 and LOC_ID=?2;
           @Query(value="SELECT TICKET_NO ,LOC_ID FROM test.user_login where ROLE='USER' AND TYPE = 'INSURANCE' AND REPORTING_TO =?1 ", nativeQuery = true)
    public List<Map> getUserList(String loginName);
    

    @Query(value="select count(ul1.login_name)  as usercount from test.user_login ul,test.user_login ul1, test.ss_loc_access sla \n" +
    "where ul.login_name=sla.user_name AND sla.loc_access=UL1.loc_id and ul1.role='USER' AND sla.valid='Y'\n" +
    "and ul.login_name=?1",nativeQuery=true)
    public Object getUsercount(String login_name);
    
//        @Query("select distinct std.taskId as taskId  from SsTaskDetails std where std.callDuDt=CURRENT_DATE and std.locId=?1 order by std.taskId")
//    List<Object> getTaskId(long locId);
    
    //public int countByLoginName(String loginName);
    // @Query("UPDATE SsInsTaskDetails instask SET instask.assignId = ?1 WHERE insTask.taskId BETWEEN ?2 AND ?3")
    
    List<SsInsTaskDetails> findByTaskIdBetween(int start, int end);
    
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE SsInsTaskDetails instask SET instask.assignId = ?1 WHERE instask.taskId BETWEEN ?2 AND ?3 AND locId=?4")
    int updateAssignIdwithLoc(String assigneeId, int start, int  end, int locId );
    
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE SsInsTaskDetails instask SET instask.assignId = ?1 WHERE instask.taskId BETWEEN ?2 AND ?3 ")
    int updateAssignId(String assigneeId, int start, int  end );
    
  
    
}
