/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.impl;

import com.sai.model.HrOperatingUnit;
import com.sai.model.SSRegionMst;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Test
 */

@Repository
public interface RegionMstRepository extends CrudRepository<SSRegionMst, Long>
{
    
}
