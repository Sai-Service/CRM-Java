/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.SaiResponse;
import com.sai.dao.SsInsTaskHistoryDao;
import com.sai.model.insurance.SsInsTaskDetails;
import com.sai.model.insurance.SsInsTaskHistory;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Swaroopcomp
 */
@RestController
@RequestMapping("/ins")
public class SsInsTaskHistoryController implements Serializable {

     @Autowired
     SsInsTaskHistoryDao insTaskHistoryDao ;

   @GetMapping("/task/history")
    public List<SsInsTaskHistory> getInsTaskHistory(){
        return (List<SsInsTaskHistory>) insTaskHistoryDao.findAll();
    }
    
    @PostMapping("/task/history")
    SaiResponse addInsTaskHistory(@RequestBody SsInsTaskHistory details) {
        SaiResponse apiResponse;
        try {
            insTaskHistoryDao.save(details);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Error while Inserting Insurance Task History ", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }
    
@RequestMapping(value = "/task/history/{id}", method = RequestMethod.GET, produces = {"application/JSON"})
  public SsInsTaskHistory getInsTaskHistoryByTaskId(@PathVariable Integer id) {
       Optional< SsInsTaskHistory> historyList= insTaskHistoryDao.findById(id);
         SsInsTaskHistory tskHistory = historyList.isPresent() ? historyList.get() : null;
          return tskHistory;
    }
  
     @RequestMapping(value = "/InsHistoryTaskId/{taskId}", method = RequestMethod.GET, produces = {"application/JSON"})
    // Map getUsercountList(@PathVariable String vehicle_no)
    public List<Map> getInsTaskHistory(@PathVariable Integer taskId) {
        return insTaskHistoryDao.getInsTaskHistory(taskId);

    } 
 
        ///////////////////TO DISPLAY MARQUEE VALUE FOR CONTACTED CUSTOMER ON HOME PAGE///////////
    @RequestMapping(value = "/getInsContactedCust/{locId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public Map getInsContactedCust(@PathVariable Integer locId) {

        return insTaskHistoryDao.getInsContactedCust(locId);
    }
    
       ///////////////////TO DISPLAY MARQUEE VALUE FOR UNCONTACTED CUSTOMER ON HOME PAGE///////////
    @RequestMapping(value = "/getInsUnContactedCust/{locId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public Map getInsUnContactedCust(@PathVariable Integer locId) {

        return insTaskHistoryDao.getInsUnContactedCust(locId);
    }
     
        ///////////////////TO DISPLAY MARQUEE VALUE FOR appt taken CUSTOMER ON HOME PAGE///////////
    @RequestMapping(value = "/getInsApptTakenCust/{locId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public Map getInsApptTakenCust(@PathVariable Integer locId) {

        return insTaskHistoryDao.getInsApptTakenCust(locId);
    }
    
        ///////////////////TO DISPLAY MARQUEE VALUE FOR appt not taken CUSTOMER ON HOME PAGE///////////
    @RequestMapping(value = "/getInsApptNtTakenCust/{locId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public Map getInsApptNtTakenCust(@PathVariable Integer locId) {

        return insTaskHistoryDao.getInsApptNtTakenCust(locId);
    }
}
