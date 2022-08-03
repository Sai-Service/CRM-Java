/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;
import com.sai.model.LocationNames;
import com.sai.model.SsLocation;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Test
 */

    public interface SsLocationDao extends CrudRepository<SsLocation, Long>{
    @Query("select distinct NEW com.sai.model.LocationNames(ssl.locId, ssl.locName)  from SsLocation ssl order by ssl.locId")
    public List<LocationNames> getLocationNames();
    
        
   // SsLocation findByOrgId(long org_id);
   public List<SsLocation> findByOrgId(long org_id);

    public SsLocation findByLocName(String locName);
    
}
