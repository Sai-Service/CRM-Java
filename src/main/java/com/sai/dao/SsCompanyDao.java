/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.SsCompany;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Test
 */
  
    public interface SsCompanyDao extends CrudRepository<SsCompany, Long>{
   //  @Query("select * from SsCompany")
    // public List<Object> getCompanyNames();
        
        @Query(value=" select distinct company_name as cmpnyCode from test.ss_company where status='ACTIVE' order by company_code ",nativeQuery=true)
    // MassAssignData getMassAssCount(long locId); 
    public List<Map> getcompanyName();
    
 //  public <SsCompany>  findbyStatus("ACTIVE");
   List<SsCompany> findByStatus(String status);
}

