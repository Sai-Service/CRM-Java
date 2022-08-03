/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.SaiResponse;
import com.sai.model.SSRegionMst;
import java.util.List;
import com.sai.dao.SSRegionMstDao;
import com.sai.dao.UserLoginDao;
import com.sai.model.UserLogin;
import java.util.Calendar;
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

/**
 *
 * @author Test
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SSRegionMstController {

    @Autowired
    private SSRegionMstDao regionRepository;

    @Autowired
    private UserLoginDao userRepository;

    @GetMapping("/sSRegionMsts")
    public List<SSRegionMst> getregion() {
        return (List<SSRegionMst>) regionRepository.findByValid("ACTIVE");
    }

    @PostMapping("/sSRegionMsts")
    SaiResponse addUser(@RequestBody SSRegionMst regions) {
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

            regions.setCreatedBy(user.getUserId());
            regions.setCreationDt(currentDate);
            regions.setLstUpBy(user.getUserId());
            regions.setLstUpDate(currentDate);

            regionRepository.save(regions);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Not inserted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    /*  @RequestMapping(value ="/regions/names", method = RequestMethod.GET)
    public List<Object> getRegionNames() {
       List<Object> oRegionLists = regionRepository.getRegionNames();
       return oRegionLists;
    }*/
    @PutMapping("/sSRegionMsts/{id}")
    SaiResponse updateRegions(@RequestBody SSRegionMst updatedRegions, @PathVariable Long id) {
        SaiResponse apiResponse;
        Optional<SSRegionMst> optionalRegions = regionRepository.findById(updatedRegions.getRegionId());
        SSRegionMst Regions = optionalRegions.isPresent() ? optionalRegions.get() : null;
        if (Regions != null) {
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

            updatedRegions.setCreatedBy(Regions.getCreatedBy());
            updatedRegions.setCreationDt(Regions.getCreationDt());
            updatedRegions.setLstUpBy(user.getUserId());
            updatedRegions.setLstUpDate(currentDate);
//            BeanUtils.copyProperties(updatedRegions, Regions);
            regionRepository.save(updatedRegions);
        } else {
            apiResponse = new SaiResponse(400, "Region Master found", null);
        }
        apiResponse = new SaiResponse(200, "OK", updatedRegions);
        return apiResponse;
    }

    @DeleteMapping("/sSRegionMsts/{id}")
    SaiResponse deleteRegions(@PathVariable Long id) {
        SaiResponse apiResponse;
        try {
            regionRepository.deleteById(id);
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
 /*  @GetMapping("/opunits/{id}")
    public SSRegionMst getRegionsById(@PathVariable Long id){
       Optional<SSRegionMst> optionalUser = regionRepository.findById(id);
        SSRegionMst user = optionalUser.isPresent() ? optionalUser.get() : null;
        return user;
    }*/
    @GetMapping("/sSRegionMsts/{id}")
    public SSRegionMst getOpUnitById(@PathVariable Long id) {
        Optional<SSRegionMst> optionalUser = regionRepository.findById(id);
        SSRegionMst user = optionalUser.isPresent() ? optionalUser.get() : null;
        return user;
    }

    @GetMapping("/sSRegionMsts/findAllRegion")//////////////
    public List<SSRegionMst> findAllRegion() {
        List<SSRegionMst> locIdOrgId = regionRepository.findAllRegion();
        return locIdOrgId;
    }
}
