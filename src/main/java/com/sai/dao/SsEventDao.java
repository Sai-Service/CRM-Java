/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.SsEvent;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Test
 */
public interface SsEventDao extends CrudRepository<SsEvent, Long> {

    //  @Query("select * from SsEvent")
    // public List<Object> getEventNames();
    public List<SsEvent> findForSearch(String serType);

    public List<SsEvent> findBySerTypeAndActiveStatus(String serType,String status);

    public List<SsEvent> findByLocIdAndActiveStatus(long locId,String status);

    public List<SsEvent> findByDeptAndActiveStatus(String dept,String status);

    public List<SsEvent> findBySerTypeAndLocIdAndActiveStatus(String serType, long locId,String status);

    public List<SsEvent> findBySerTypeAndDeptAndActiveStatus(String serType, String dept,String status);

    public List<SsEvent> findByLocIdAndDeptAndActiveStatus(long locId, String dept,String status);

    public List<SsEvent> findBySerTypeAndLocIdAndDeptAndActiveStatus(String serType, long locId, String dept,String status);

    public List<SsEvent> findByActiveStatus(String activeStatus);

}
