/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.insurance.SsInsEventMaster;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Test
 */
public interface SsInsEventDao extends CrudRepository<SsInsEventMaster, Long>  {
    
    public List<SsInsEventMaster> findByActiveStatus(String activeStatus);
    //insType,dataBasedOn,locId
 //   public List<SsInsEventMaster> findForSearch(String insType);

    public List<SsInsEventMaster> findByInsTypeAndActiveStatus(String insType,String status);

    public List<SsInsEventMaster> findByLocIdAndActiveStatus(long locId,String status);

    public List<SsInsEventMaster> findByDataBasedOnAndActiveStatus(String dataBasedOn,String status);

    public List<SsInsEventMaster> findByInsTypeAndLocIdAndActiveStatus(String insType, long locId,String status);

    public List<SsInsEventMaster> findByInsTypeAndDataBasedOnAndActiveStatus(String insType, String dataBasedOn,String status);

    public List<SsInsEventMaster> findByLocIdAndDataBasedOnAndActiveStatus(long locId, String dataBasedOn,String status);

    public List<SsInsEventMaster> findByInsTypeAndLocIdAndDataBasedOnAndActiveStatus(String insType, long locId, String dataBasedOn,String status);

}
