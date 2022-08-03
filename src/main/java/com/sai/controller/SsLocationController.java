/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.SaiResponse;
import com.sai.model.SsLocation;
import java.util.List;
import com.sai.dao.SsLocationDao;
import com.sai.dao.UserLoginDao;
import com.sai.model.LocationNames;
import com.sai.model.UserLogin;
import java.util.Calendar;
import org.springframework.web.bind.annotation.GetMapping;
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
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SsLocationController {

    @Autowired
    private SsLocationDao locationRepository;

    @Autowired
    private UserLoginDao userRepository;

    @GetMapping("/ssLocations")
    public List<SsLocation> getLocation() {
        return (List<SsLocation>) locationRepository.findAll();
    }

    @PostMapping("/ssLocations")
    SaiResponse addUser(@RequestBody SsLocation locations) {
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
            locations.setCreatedBy(user.getUserId());
            locations.setCreationDt(currentDate);
            locations.setLstUpBy(user.getUserId());
            locations.setLstUpDate(currentDate);
            //  SsCompany newCompany = companyRepository.save(company);
            locationRepository.save(locations);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Not inserted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    @PutMapping("/ssLocations/{id}")
    SaiResponse updateSsLoc(@RequestBody SsLocation updatedSsLoc, @PathVariable Long id) {
        SaiResponse apiResponse;
        Optional<SsLocation> optionalOpUnit = locationRepository.findById(updatedSsLoc.getLocId());
        SsLocation SsLoc = optionalOpUnit.isPresent() ? optionalOpUnit.get() : null;
        if (SsLoc != null) {
            String username = null;
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                username = principal.toString();
            }
            UserLogin user = userRepository.findByUsername(username);

//            BeanUtils.copyProperties(updatedSsLoc, SsLoc);
updatedSsLoc.setCreatedBy(SsLoc.getCreatedBy());
updatedSsLoc.setCreationDt(SsLoc.getCreationDt());
updatedSsLoc.setLstUpBy(user.getUserId());
updatedSsLoc.setLstUpDate(Calendar.getInstance().getTime());
            locationRepository.save(updatedSsLoc);
        } else {
            apiResponse = new SaiResponse(400, "Location Master found", null);
        }
        apiResponse = new SaiResponse(200, "OK", SsLoc);
        return apiResponse;

    }

    @DeleteMapping("/ssLocations/{id}")
    SaiResponse deleteSsLoc(@PathVariable Long id) {
        SaiResponse apiResponse;
        try {
            locationRepository.deleteById(id);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Not Deleted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    @RequestMapping(value = "/ssLocations/names", method = RequestMethod.GET)
    public List<LocationNames> getLocationNames() {
        List<LocationNames> objLists = locationRepository.getLocationNames();
        return objLists;
    }

    @GetMapping("/ssLocations/{id}")
    public SsLocation getSsLocById(@PathVariable Long id) {
        Optional<SsLocation> optionalUser = locationRepository.findById(id);
        SsLocation user = optionalUser.isPresent() ? optionalUser.get() : null;
        return user;
    }

    @GetMapping("/ssLocations/LocIdByOrgId/{org_id}")//////////////
    public List<SsLocation> findByOrgId(@PathVariable long org_id) {
        List<SsLocation> locIdOrgId = locationRepository.findByOrgId(org_id);
        return locIdOrgId;
    }
}
