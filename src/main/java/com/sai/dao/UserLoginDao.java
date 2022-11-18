package com.sai.dao;

import com.sai.dto.cmnStString;
import com.sai.model.UserLogin;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginDao extends CrudRepository<UserLogin, Long> {

     UserLogin findByUsername(String username);
     
    // UserLogin findByLocation(long locId);   
     
           @Query(value=" select concat(ticketno,\"-\",emp_name) exename, agent_Id  from test.ss_executive_details where ticketno=?1 ",nativeQuery=true)
    // MassAssignData getMassAssCount(long locId); 
    public  Map getexeName(String ticketno);
    
          @Query(value="select user_id as userId,ticket_no as ticketNo,login_name as username,role,dept,reporting_to as reportTo,type,loc_id as locId,org_id as orgId,ip_address as ipAddress\n" +
                "from test.user_login where loc_id=?1", nativeQuery = true)
       public List<Map> findByLocation(long loc_id);
       
                     @Query("SELECT NEW com.sai.model.UserLogin(ticketNo ,locId) FROM UserLogin where role='USER'  AND type = 'INSURANCE' AND reportTo =?1 ")
    public List<UserLogin> findByReportedTo(String loginName);
    
    @Query("SELECT NEW com.sai.dto.cmnStString(ticketNo,username)  FROM UserLogin where role='USER'  AND type = 'INSURANCE' AND reportTo =?1 and locId=?2 ")
    public List<cmnStString> totalLogins(String loginName,Integer locId);//Integer locId, String ticketNo, String username, String dept
}

   
