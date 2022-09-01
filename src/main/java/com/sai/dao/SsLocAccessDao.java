/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;
import com.sai.model.SsLocAccess;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Test
 */

    public interface SsLocAccessDao extends CrudRepository<SsLocAccess, Long>{
   //  @Query("select * from SsLocAccess")
     //public List<Object> getLocAccNames();
        
    @Query(value="SELECT DISTINCT sla.loc_access as locId, sla.locName as locName FROM ss_loc_access sla,ss_location sl\n" +
"where sla.loc_access= sl.loc_id and sla.type=?1 and sl.org_id=?2 and sla.user_name=?3", nativeQuery = true)
    public List<Map> getLocNameTypeOrgWise(String type,long orgId,String username);
    
    public boolean existsSsLocAccessByUsernameAndTypeAndLocName(String username, String type, String locName);
    
     public List<SsLocAccess> findByValid(String valid);
}
