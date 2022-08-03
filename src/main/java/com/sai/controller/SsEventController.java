/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.SaiResponse;
import com.sai.model.SsEvent;
import java.util.List;
import com.sai.dao.SsEventDao;
import com.sai.dao.UserLoginDao;
import com.sai.model.UserLogin;
import java.util.Calendar;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Test
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SsEventController {

    @Autowired
    private UserLoginDao userRepository;

    @Autowired
    private SsEventDao eventRepository;

    @GetMapping("/ssEvents")
    public List<SsEvent> getEvent() {
        return (List<SsEvent>) eventRepository.findByActiveStatus("ACTIVE");
    }

    @PostMapping("/ssEvents")
    SaiResponse addUser(@RequestBody SsEvent events) {
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

            events.setCreatedBy(user.getUserId());
            events.setCreationDt(currentDate);
            events.setLstUpBy(user.getUserId());
            events.setLstUpDt(currentDate);
            events.setOrgId(user.getOrgId());
            events.setAttribute1(user.getType());
            eventRepository.save(events);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Not Deleted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    @PutMapping("/ssEvents/{id}")
    SaiResponse updateSsEvent(@RequestBody SsEvent updatedSsEvent, @PathVariable Long id) {
        SaiResponse apiResponse;
        Optional<SsEvent> optionalSsEvent = eventRepository.findById(updatedSsEvent.getEventId());
        SsEvent SsEvent = optionalSsEvent.isPresent() ? optionalSsEvent.get() : null;
        if (SsEvent != null) {
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

            updatedSsEvent.setCreatedBy(SsEvent.getCreatedBy());
            updatedSsEvent.setCreationDt(SsEvent.getCreationDt());
            updatedSsEvent.setLstUpBy(user.getUserId());
            updatedSsEvent.setLstUpDt(currentDate);
            updatedSsEvent.setOrgId(SsEvent.getOrgId());
//            BeanUtils.copyProperties(updatedSsEvent, SsEvent);
            eventRepository.save(updatedSsEvent);
        } else {
            apiResponse = new SaiResponse(400, "Event Master found", null);
        }
        apiResponse = new SaiResponse(200, "OK", updatedSsEvent);
        return apiResponse;
    }

    @DeleteMapping("/ssEvents/{id}")
    SaiResponse deleteOpUnit(@PathVariable Long id) {
        SaiResponse apiResponse;
        try {
            eventRepository.deleteById(id);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Not Deleted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    /*  @RequestMapping(value ="/opunits/names", method = RequestMethod.GET)
    public List<OpUnit> getOpUnitsNames() {
       List<OpUnit> objLists = UnitRepository.getUnitsNames();
       return objLists;
    }*/
    @GetMapping("/ssEvents/{id}")
    public SsEvent getSsEventById(@PathVariable Long id) {
        Optional<SsEvent> optionalUser = eventRepository.findById(id);
        SsEvent user = optionalUser.isPresent() ? optionalUser.get() : null;
        return user;
    }

    @GetMapping("/ssEvents/search")//////////////
    public List<SsEvent> findForSearch(@RequestParam Map<String, String> map) {

        long locId = 0;
        String dept = null;
        String serType = null;

        boolean searchByLoc = false;
        boolean searchByDept = false;
        boolean searchBySerType = false;

        for (String searchKey : map.keySet()) {
            if (searchKey.equals("loc")) {
                String location = map.get("loc");
                String[] locDetails = location.split("-");
                locId = Long.parseLong(locDetails[0]);
                searchByLoc = true;
            }
            if (searchKey.equals("dept")) {
                dept = map.get(searchKey);
                searchByDept = true;
            }
            if (searchKey.equals("serType")) {
                serType = map.get(searchKey);
                searchBySerType = true;
            }
        }
        System.out.println(locId + "-" + searchByLoc + ", " + serType + searchBySerType + ", -" + dept + "-" + searchByDept);

        if (searchByLoc && searchByDept && searchBySerType) {
            return eventRepository.findBySerTypeAndLocIdAndDeptAndActiveStatus(serType, locId, dept,"ACTIVE");
        }
        if (searchByLoc && searchByDept) {
            return eventRepository.findByLocIdAndDeptAndActiveStatus(locId, dept,"ACTIVE");
        }
        if (searchByDept && searchBySerType) {
            return eventRepository.findBySerTypeAndDeptAndActiveStatus(serType, dept,"ACTIVE");
        }
        if (searchByLoc && searchBySerType) {
            return eventRepository.findBySerTypeAndLocIdAndActiveStatus(serType, locId,"ACTIVE");
        }
        if (searchByLoc) {
            return eventRepository.findByLocIdAndActiveStatus(locId,"ACTIVE");
        }
        if (searchByDept) {
            return eventRepository.findByDeptAndActiveStatus(dept,"ACTIVE");
        }
        if (searchBySerType) {
            return eventRepository.findBySerTypeAndActiveStatus(serType,"ACTIVE");
        }

        return null;
    }
}
