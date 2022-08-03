/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;
import com.sai.model.SsSlotAvailable;
import java.util.Date;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Test
 */
    
    public interface SsSlotAvailableDao extends CrudRepository<SsSlotAvailable, Long>{
   // @Query("select * from SsSlotAvailable")
    //public List<Object> getSlotsNames();
          SsSlotAvailable findByLocId(long serv_loc_id,String timing);     
          
           SsSlotAvailable findBySerLocIdAndServiceDateAndTiming(long serv_loc_id,Date serviceDate,String timing); 
}
