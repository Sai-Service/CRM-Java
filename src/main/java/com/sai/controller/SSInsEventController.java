/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.SaiResponse;
import com.sai.dao.SsInsEventDao;
import com.sai.dao.UserLoginDao;
import com.sai.model.SsEvent;
import com.sai.model.insurance.SsInsEventMaster;
import com.sai.model.UserLogin;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Test
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ins")
public class SSInsEventController {
    
     @Autowired
    private UserLoginDao userRepository;

    @Autowired
    private SsInsEventDao eventRepository;
    
    
    
     @GetMapping("/ssInsEvents")
    public List<SsInsEventMaster> getEvent() {
        return (List<SsInsEventMaster>) eventRepository.findByActiveStatus("ACTIVE");
    }
  @PostMapping("/ssEvents")
    SaiResponse addUser(@RequestBody SsInsEventMaster events) {
        SaiResponse apiResponse;
        try {

            String username = null;
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                username = principal.toString();
            }
            UserLogin user = userRepository.findByUsername(username);

            Calendar calendar = Calendar.getInstance();
            java.util.Date currentDate = calendar.getTime();
            int userId = new Long(user.getUserId()).intValue();
           
            events.setCreatedBy(userId);
            events.setCreatedDate(currentDate);
            events.setUpdatedDate(currentDate);
            events.setUpdatedBy(userId);
            events.setOrgId(user.getOrgId());
            events.setAttribute1(user.getType());
            eventRepository.save(events);
            
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Not Deleted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    
    
     @GetMapping("/ssEvents/{id}")
    public SsInsEventMaster getSsEventById(@PathVariable Long id) {
        Optional<SsInsEventMaster> optionalUser = eventRepository.findById(id);
        SsInsEventMaster user = optionalUser.isPresent() ? optionalUser.get() : null;
        return user;
    }
    
    
      @GetMapping("/ssInsEvents/search")//////////////
    public List<SsInsEventMaster> findForSearch(@RequestParam Map<String, String> map) {

        long locId = 0;
        String insType = null;
        String dataBasedOn = null;

        boolean searchByLoc = false;
        boolean searchByInsType = false;
        boolean searchBydataBasedOn = false;
        
         for (String searchKey : map.keySet()) {
            if (searchKey.equals("loc")) {
                String location = map.get("loc");
                String[] locDetails = location.split("-");
                locId = Long.parseLong(locDetails[0]);
                searchByLoc = true;
            }
            if (searchKey.equals("insType")) {
                insType = map.get(searchKey);
                searchByInsType = true;
            }
            if (searchKey.equals("dataBasedOn")) {
                dataBasedOn = map.get(searchKey);
                searchBydataBasedOn = true;
            }
        }
        
           if (searchByLoc && searchByInsType && searchBydataBasedOn) {
            return eventRepository.findByInsTypeAndLocIdAndDataBasedOnAndActiveStatus(insType, locId, dataBasedOn,"ACTIVE");
        } //insType,dataBasedOn,locId
        if (searchByLoc && searchByInsType) {
            return eventRepository.findByLocIdAndDataBasedOnAndActiveStatus(locId, insType,"ACTIVE");
        }
        if (searchByInsType && searchBydataBasedOn) {
            return eventRepository.findByInsTypeAndDataBasedOnAndActiveStatus(dataBasedOn, insType,"ACTIVE");
        }
        if (searchByLoc && searchBydataBasedOn) {
            return eventRepository.findByInsTypeAndLocIdAndActiveStatus(dataBasedOn, locId,"ACTIVE");
        }
        if (searchByLoc) {
            return eventRepository.findByLocIdAndActiveStatus(locId,"ACTIVE");
        }
        if (searchByInsType) {
            return eventRepository.findByDataBasedOnAndActiveStatus(insType,"ACTIVE");
        }
        if (searchBydataBasedOn) {
            return eventRepository.findByInsTypeAndActiveStatus(dataBasedOn,"ACTIVE");
        }

      
         return null;
        
    }
}
