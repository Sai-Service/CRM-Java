/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.dao.SsServiceAdvisorDao;
import com.sai.model.HrOperatingUnit;
import com.sai.model.SsEvent;
import com.sai.model.SsServiceAdvisor;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Test
 */
@RestController
public class SsServAdvisorController {
    
     @Autowired
    private SsServiceAdvisorDao serAdvRepository;
    
    @GetMapping("/ssServiceAdvisor")//////////////////
    public List<SsServiceAdvisor> getSrAdvisor() {
        
         SsServiceAdvisor ssAdv = new SsServiceAdvisor() ;     
        return (List<SsServiceAdvisor>) serAdvRepository.findByLocationAndDesginationAndStatus(ssAdv.getLocation(),"Service Advisor","ACTIVE");
    }

        @GetMapping("/SsServiceAdvisor/{ticketNo}")
    public SsServiceAdvisor getSsEventById(@PathVariable String ticketNo) {
        Optional<SsServiceAdvisor> optionalUser = serAdvRepository.findByTicketNo(ticketNo);
        SsServiceAdvisor user = optionalUser.isPresent() ? optionalUser.get() : null;
        return user;
    }
    
    @GetMapping("/SsServiceAdvisor/ServAdvByLocId/{locId}")
    public List<SsServiceAdvisor>  getSsEventByLocId(@PathVariable Integer locId) {
        List<SsServiceAdvisor>  advList = serAdvRepository.findByLocation(locId);
        return advList;
    }
    
    
}
