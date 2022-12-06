/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.service;

import com.sai.dto.SsTaskReport;
import com.sai.model.SSAppoinmentDetails;
import com.sai.model.insurance.SsInsuranceDetails;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Swaroopcomp
 */
public interface SSTaskCreationService {

    public List<SsTaskReport> findTaskByConditions(Map<String, String> map);

    public List<SsTaskReport> findReasonWiseReport(String fromDate,String toDate ,Integer orgId,Integer locId,String reasonCode);

    public List<SSAppoinmentDetails> findAppointmentReport(String fromDate,String toDate,Integer orgId,Integer locId);

  //  public List<EventReport> findEventWiseReport(Map<String, String> map
    
    public List<Object> findEventWiseReport(Map<String, String> map);

     public List<SsInsuranceDetails> findByInsDetailConditions(Map<String, String> map);
    
}
