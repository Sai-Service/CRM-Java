/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.LocAccessLoginwise;
import com.sai.model.UserLogin;
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
public interface LocAccessLoginwiseDao extends CrudRepository<UserLogin, Long> {
    
    /////working query for getting user login details.//////
 //    @Query(value="select ul.login_name,sla.loc_access,SLA.LOCNAME,ul1.login_name as username from test.user_login ul,test.user_login ul1, test.ss_loc_access sla \n" +
   //     "where ul.login_name=sla.user_name AND sla.loc_access=UL1.loc_id and ul1.role='USER' AND sla.valid='Y' and ul.login_name=?1" , nativeQuery = true)
   @Query(value="select distinct ul.login_name,sla.loc_access,SLA.LOCNAME,ul1.login_name as username ,sed.emp_name\n" +
            "from test.user_login ul,test.user_login ul1, test.ss_loc_access sla, test.ss_executive_details sed\n" +
            "where ul.login_name=sla.user_name AND sla.loc_access=UL1.loc_id and ul1.role='USER' and ul.type='PSF' and ul1.type='PSF' AND sla.valid='ACTIVE' and ul.login_name=?1\n" +
    "and ul1.ticket_no=sed.ticketno  and sla.loc_access=?2", nativeQuery = true)
    public List<Map> getUserList(String login_name,Integer locId);
    
   @Query(value="select distinct ul.reporting_to login_name,sla.loc_access,SLA.LOCNAME,ul1.login_name as username ,sed.emp_name\n" +
            "from test.user_login ul,test.user_login ul1, test.ss_loc_access sla, test.ss_executive_details sed\n" +
            "where ul.login_name=sla.user_name AND sla.loc_access=UL1.loc_id and ul1.role='USER' and ul.type='PRPSF' and ul1.type='PRPSF' AND sla.valid='ACTIVE' and ul.reporting_to=?1\n" +
    "and ul1.ticket_no=sed.ticketno and sla.loc_access=?2", nativeQuery = true)
    public List<Map> getUserListProforma(String login_name,Integer locId);
   
    
    
    
    @Query(value="select distinct ul.login_name,sla.loc_access,SLA.LOCNAME,ul1.login_name as username ,sed.emp_name\n" +
    "from test.user_login ul,test.user_login ul1, test.ss_loc_access sla, test.ss_executive_details sed\n" +
    "where ul.login_name=sla.user_name AND sla.loc_access=UL1.loc_id and ul1.role='USER' and ul.type='PSF' and ul1.type='PSF' AND sla.valid='ACTIVE' and ul.login_name=?1\n" +
    "and ul1.ticket_no=sed.ticketno", nativeQuery = true)
    public List<Map> getUserList11(String login_name);
       
    
   @Query(value="select count(ul1.login_name)  as usercount from test.user_login ul,test.user_login ul1, test.ss_loc_access sla \n" +
    "where ul.login_name=sla.user_name AND sla.loc_access=UL1.loc_id and ul1.role='USER' and ul.type='PSF' and ul1.type='PSF' AND sla.valid='ACTIVE'\n" +
    "and ul.login_name=?1",nativeQuery=true)
    public List<Map> getUsercountList(String login_name);  
    
     @Query(value="select distinct count(ul1.login_name)  as usercount from test.user_login ul,test.user_login ul1, test.ss_loc_access sla \n" +
    "where ul.login_name=sla.user_name AND sla.loc_access=UL1.loc_id and ul1.role='USER' and  ul.type='PSF' and sla.type='PSF' and ul1.type='PSF' AND sla.valid='ACTIVE'\n" +
    "and ul.login_name=?1",nativeQuery=true)
    public Object getUsercount(String login_name);  
    
        @Query(value="select distinct count(ul1.login_name)  as usercount from test.user_login ul,test.user_login ul1, test.ss_loc_access sla \n" +
    "where ul.login_name=sla.user_name AND sla.loc_access=UL1.loc_id and ul1.role='USER' and  ul.type='PRPSF' and sla.type='PRPSF' and ul1.type='PRPSF' AND sla.valid='ACTIVE'\n" +
    "and ul.login_name=?1",nativeQuery=true)
    public Object getUsercountProforma(String login_name);  
    
   @Modifying
   @Transactional
   @Query(value="update test.ss_task_details set ASSIGNEE=?1,ASSIGNEE_ID=?2 WHERE TASK_ID BETWEEN ?3 AND ?4 and task_status!='CLOSED'",nativeQuery=true)
 // public List<Map> UpdateAssignee(String assignee ,String ASSIGNEE_ID,Long FROMTASK_ID,Long TOTASK_ID );  
    public void UpdateAssignee(String assignee ,String ASSIGNEE_ID,long FROMTASK_ID,long TOTASK_ID );  
    
    @Modifying
   @Transactional
   @Query(value="update test.ss_task_details set ASSIGNEE=?1,ASSIGNEE_ID=?2 WHERE task_Id=?3 and task_status!='CLOSED'",nativeQuery=true)
 // public List<Map> UpdateAssignee(String assignee ,String ASSIGNEE_ID,Long FROMTASK_ID,Long TOTASK_ID );  
    public void UpdateAssigneeTaskIdwise(String assignee ,String ASSIGNEE_ID,long taskId );  
   
    
        @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value=" update test.ss_task_details sad set sad.assignee=?1 , sad.assignee_id=?2 "
            + " where  sad.task_status!='CLOSED' and sad.task_id between ?3 and ?4 and sad.loc_id=?5",nativeQuery=true)
    int updateAssignIdwithLoc(String assignee,String assignee_id, long FROMTASK_ID,long TOTASK_ID , long loc_id );
   
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value="Update test.ss_task_details std JOIN  test.ss_vehicle_master svm ON std.VEHICLE_NO=svm.vehicleNo "
            + "SET std.ASSIGNEE = ?1, std.ASSIGNEE_ID=?2 WHERE std.TASK_STATUS='NEW' AND svm.model=?3",nativeQuery=true)
    int updateAssigneeByModel(String assignee,String assignee_id, String model , long loc_id );
    
   
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value="Update test.ss_task_details std JOIN  test.ss_vehicle_master svm ON std.VEHICLE_NO=svm.vehicleNo "
            + "SET std.ASSIGNEE = ?1, std.ASSIGNEE_ID=?2 WHERE std.TASK_STATUS='NEW' AND svm.vehicleType=?3",nativeQuery=true)
    int updateAssigneeByVehicleType(String assignee,String assignee_id, String model , long loc_id );

    
}
