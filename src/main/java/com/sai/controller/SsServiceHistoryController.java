/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.sai.dao.SsServiceHistoryDao;
import com.sai.dto.SsServiceHistoryJobDetails;
import com.sai.dto.SsServiceHistoryResponse;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SsServiceHistoryController {
    
    @Autowired
    SsServiceHistoryDao serviceHistoryDao;
    
     @GetMapping("/ssServiceHistory/{vehicleNumber}")
    public SsServiceHistoryResponse  getSerivceHistory(@PathVariable String vehicleNumber) {
        SsServiceHistoryResponse response = serviceHistoryDao.findOneServiceHistoryReportHeader(vehicleNumber).get(0);
        List< SsServiceHistoryJobDetails> jobDetails = serviceHistoryDao.findServiceHistoryJobDetails(vehicleNumber);
        response.setJobDetails(jobDetails);
        return response;
        
    }
    
}
