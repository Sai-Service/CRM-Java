/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.impl;

import com.sai.model.HrOperatingUnit;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Test
 */
@Repository
public interface OrganizationRepository extends CrudRepository<HrOperatingUnit, Long>
{
    //@Query("select id,orgName from HROperatingUnit")
    //public List<HrOperatingUnit> getUnitsNames();
    HrOperatingUnit findByOrgId(String org_id);

    List <HrOperatingUnit> findByPanNo(String pan_number);
}
