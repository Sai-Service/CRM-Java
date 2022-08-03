/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.HrOperatingUnit;
import com.sai.model.OpUnit;
import com.sai.model.SsCompany;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Test
 */
public interface HrOperatingUnitsDao extends CrudRepository<HrOperatingUnit, Long>{
    
    @Query("select distinct NEW com.sai.model.OpUnit(hru.orgId, hru.orgName)  from HrOperatingUnit hru order by hru.orgId")
    public List<OpUnit> getUnitsNames();

    HrOperatingUnit findByOrgId(long orgId);
    
    public List<HrOperatingUnit> findByPanNo(String panid);
    
     List<HrOperatingUnit> findByActiveStatus(String activeStatus);

}
