/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;
import com.sai.model.SSGatepassAll;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Test
 */

    public interface SSGatepassAllDao extends CrudRepository<SSGatepassAll, Long>{
   //  @Query("select custId,custName from SSGatepassAll")
    // public List<Object> getGatepassNames();
        
        SSGatepassAll findByGatepassId(Long gatepassId);
     
   @Query("select NEW com.sai.model.SSGatepassAll(id,gatepassId,deliveryDate,custName,custId,contactNo,VehNo,orgId,locId,servLoc,refNo,servType,lastKM,model,chassisNo,engineNo,deptCode)"
                + " from SSGatepassAll Where deliveryDate=curdate() and taskId is null ")
    public List<SSGatepassAll> findGatepassExceptionReport();

    
    @Query(value = "select  sgp.org_id,sgp.loc_id,\n" +
            "( select  count(gatepass_id) TaskGen from test.ss_gatepass_all \n" +
            "where delivery_date=curdate() and task_id is null and loc_id=sgp.loc_id) TaskNotGen,\n" +
            "(select count(gatepass_id) TaskGen from test.ss_gatepass_all \n" +
            "where delivery_date=curdate() and task_id is not null and loc_id=sgp.loc_id) TaskGen\n" +
            "from test.ss_gatepass_all sgp\n" +
            "where sgp.delivery_date=curdate() group by sgp.org_id,sgp.loc_id order by sgp.org_id,sgp.loc_id", nativeQuery = true)
            List<Map> getSummGPExceptionReport();

  
}
