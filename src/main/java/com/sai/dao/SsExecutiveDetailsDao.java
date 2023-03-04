/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.ExecutiveName;
import com.sai.model.SsExecutiveDetails;
import com.sai.model.SsLocation;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
/**
 *
 * @author Test
 */
    public interface SsExecutiveDetailsDao extends CrudRepository<SsExecutiveDetails, Long>{
    @Query("select distinct NEW com.sai.model.ExecutiveName(sed.execId, sed.ticketNo,sed.empName,sed.locId)  from SsExecutiveDetails sed where sed.locId=?1 and deptCode ='SR' order by sed.execId")
    public List<ExecutiveName> getExeNames(long locId);
    
       @Query("select distinct NEW com.sai.model.ExecutiveName(sed.execId, sed.ticketNo,sed.empName,sed.locId)  from SsExecutiveDetails sed where sed.locId=?1 and deptCode ='SA' order by sed.execId")
    public List<ExecutiveName> getExeNamesSA(long locId);
    
    public List<SsExecutiveDetails> findExeByLocId(long loc_id, String deptCode);
    
    public List<SsExecutiveDetails> findByLocIdAndDeptCode(long locId, String deptCode);

    public Optional<SsExecutiveDetails> findByTicketNo(String assignee_id);

    public List<SsExecutiveDetails> findByLocIdAndDeptCodeAndStatus(long locid, String dept, String active);
   
}
