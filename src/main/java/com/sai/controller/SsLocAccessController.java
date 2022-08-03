/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.SaiResponse;
import com.sai.model.SsLocAccess;
import java.util.List;
import com.sai.dao.SsLocAccessDao;
import com.sai.dao.SsLocationDao;
import com.sai.dao.UserLoginDao;
import com.sai.model.SsLocation;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Test
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SsLocAccessController {

    @Autowired
    private UserLoginDao userRepository;

    @Autowired
    private SsLocAccessDao locaccessRepository;
    
    @Autowired
private SsLocationDao locationRepository;

    @GetMapping("/ssLocAccesses")
    public List<SsLocAccess> getlocaccess() {
        return (List<SsLocAccess>) locaccessRepository.findByValid("ACTIVE");
    }

    @PostMapping("/ssLocAccesses")
    SaiResponse addUser(@RequestBody SsLocAccess locaccess) {
        SaiResponse apiResponse;
        try {

//Verify constrainsts
            boolean isRecordPresent = locaccessRepository.existsSsLocAccessByUsernameAndTypeAndLocName(locaccess.getUsername(), locaccess.getType(),locaccess.getLocName());
            if (isRecordPresent) {
                return apiResponse = new SaiResponse(400, "User with same Type is already exist", null);
            }
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

            locaccess.setCreatedBy(user.getUserId());
            locaccess.setCreationDt(currentDate);
            locaccess.setLstUpBy(user.getUserId());
            locaccess.setLstUpDate(currentDate);

            SsLocation location = locationRepository.findByLocName(locaccess.getLocName());
            locaccess.setLocAccess(new Long(location.getLocId()).intValue());
            locaccessRepository.save(locaccess);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Not Deleted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    @PutMapping("/ssLocAccesses/{id}")
    SaiResponse updateLocAccess(@RequestBody SsLocAccess updatedLocAccess, @PathVariable Long id) {
        SaiResponse apiResponse;
        Optional<SsLocAccess> optionalLocAccess = locaccessRepository.findById(updatedLocAccess.getLid());
        SsLocAccess locAccess = optionalLocAccess.isPresent() ? optionalLocAccess.get() : null;
        
        if (locAccess != null) {
            locAccess.setValid(updatedLocAccess.getValid());
            locAccess.setType(updatedLocAccess.getType());
            SsLocation location = locationRepository.findByLocName(updatedLocAccess.getLocName());
            locAccess.setLocAccess(new Long(location.getLocId()).intValue());
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

            locAccess.setLstUpBy(user.getUserId());
            locAccess.setLstUpDate(currentDate);
            locaccessRepository.save(locAccess);
        } else {
            apiResponse = new SaiResponse(400, "Location Master found", null);
        }
        apiResponse = new SaiResponse(200, "OK", locAccess);
        return apiResponse;
    }

    @DeleteMapping("/ssLocAccesses/{id}")
    SaiResponse deleteLocAccess(@PathVariable Long id) {
        SaiResponse apiResponse;
        try {
            locaccessRepository.deleteById(id);
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
    @GetMapping("/ssLocAccesses/{id}")
    public SsLocAccess getLocAccessById(@PathVariable Long id) {
        Optional<SsLocAccess> optionalUser = locaccessRepository.findById(id);
        SsLocAccess user = optionalUser.isPresent() ? optionalUser.get() : null;
        return user;
    }

    @RequestMapping(value = "/ssLocAccess/getLocNameTypeOrgWise", method = RequestMethod.GET, produces = {"application/JSON"})
    // Map getUsercountList(@PathVariable String vehicle_no)
    public List<Map> getLocNameTypeOrgWise() {
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
        long orgId = new Long(user.getOrgId()).intValue();
        // return taskRepository.getTotalApptExewise(loc_id);
        return locaccessRepository.getLocNameTypeOrgWise(user.getType(), orgId, user.getTicketNo());

    }

}
