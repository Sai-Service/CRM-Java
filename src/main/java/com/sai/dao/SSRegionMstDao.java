/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.SSRegionMst;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Test
 */
    
    public interface SSRegionMstDao extends CrudRepository<SSRegionMst, Long>{
    // @Query("select orgId,orgName from SSRegionMst")
     //public List<Object> getRegionNames();
          public List<SSRegionMst> findAllRegion();
    
 List<SSRegionMst> findByValid(String valid);
}
