/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.SaiResponse;
import com.sai.model.HrOperatingUnit;
import java.util.List;
import com.sai.dao.HrOperatingUnitsDao;
import com.sai.dao.SsCompanyDao;
import com.sai.dao.UserLoginDao;
import com.sai.model.OpUnit;
import com.sai.model.UserLogin;
import java.util.Calendar;
import java.util.Map;
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
//import com.sai.dao.HROperatingUnitDao;
//import com.sai.model.OpUnit;

/**
 *
 * @author Test
 */
@RestController
public class HrOperatingUnitsController {

    @Autowired
    private HrOperatingUnitsDao UnitRepository;
    
    @Autowired
     private SsCompanyDao companyRepo;
    
        @Autowired
    private UserLoginDao userRepository;

    @GetMapping("/hrOperatingUnits")//////////////////
    public List<HrOperatingUnit> getOpUnits() {
        return (List<HrOperatingUnit>) UnitRepository.findByActiveStatus("ACTIVE");
    }

    @PostMapping("/hrOperatingUnits")
    SaiResponse addOpUnit(@RequestBody HrOperatingUnit units) {
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
        units.setCreatedBy(user.getUserId());
            units.setCreationDt(currentDate);
            units.setLstUpBy(user.getUserId());
            units.setLstUpDate(currentDate);
            UnitRepository.save(units);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Operating unit not found", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    @PutMapping("/hrOperatingUnits/{id}")
    SaiResponse updateOpUnit(@RequestBody HrOperatingUnit updatedOpUnit, @PathVariable Long id) {
        SaiResponse apiResponse;
        Optional<HrOperatingUnit> optionalOpUnit = UnitRepository.findById(updatedOpUnit.getOrgId());
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
      
        HrOperatingUnit opUnit = optionalOpUnit.isPresent() ? optionalOpUnit.get() : null;
        if (opUnit != null) {
//            BeanUtils.copyProperties( opUnit, updatedOpUnit);
            
            updatedOpUnit.setLstUpBy(user.getUserId());
            updatedOpUnit.setLstUpDate(currentDate);
            updatedOpUnit.setCreatedBy(opUnit.getCreatedBy());
            updatedOpUnit.setCreationDt(opUnit.getCreationDt());
            UnitRepository.save(updatedOpUnit);
        } else {
            apiResponse = new SaiResponse(400, "Operating unit not found", null);
        }
        apiResponse = new SaiResponse(200, "OK", opUnit);
        return apiResponse;
    }
/////////////////TO GET OP NAMES/////////////////////////////////////////

    @RequestMapping(value = "/hrOperatingUnits/names", method = RequestMethod.GET)
    public List<OpUnit> getOpUnitsNames() {
        List<OpUnit> objLists = UnitRepository.getUnitsNames();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
              System.out.println("-------username :" + username);
        } else {
            String username = principal.toString();
            System.out.println("-------username2 :" + username);
        }
        return objLists;
    }

    @GetMapping("/hrOperatingUnits/{id}")//////////////
    public HrOperatingUnit getOpUnitById(@PathVariable Long id) {
        Optional<HrOperatingUnit> optionalUser = UnitRepository.findById(id);
        HrOperatingUnit user = optionalUser.isPresent() ? optionalUser.get() : null;
        return user;
    }

    ////find by Pan No////
    @GetMapping("/hrOperatingUnits/panby/{panid}")//////////////
    public List<HrOperatingUnit> findByPanNo(@PathVariable String panid) {
        List<HrOperatingUnit> opUser1 = UnitRepository.findByPanNo(panid);
        // HrOperatingUnit user = optionalUser.isPresent() ? optionalUser.get() : null;
        return opUser1;
    }

    /////find by ORG ID///
    @GetMapping("/hrOperatingUnits/orgId/{orgid}")//////////////
    public HrOperatingUnit findByOrgId(@PathVariable long orgid) {
        HrOperatingUnit orgIdUser = UnitRepository.findByOrgId(orgid);
        //   HrOperatingUnit user = orgIdUser.isPresent() ? orgIdUser.get() : null;
        return orgIdUser;
    }

    //  public void run(String...args) throws Exception {
    //     List < HrOperatingUnit > user3 = UnitRepository.findByPanNo("1111");
    //    System.out.println(user3.get(0).toString());
    // }
    
    @RequestMapping(value ="/company/names", method = RequestMethod.GET)
    public List<Map> getcompanyName() {
       List<Map> objLists = companyRepo.getcompanyName();
       return objLists;
    }
}
