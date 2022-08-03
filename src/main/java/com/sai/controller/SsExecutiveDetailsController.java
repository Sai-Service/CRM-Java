/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.SaiResponse;
import com.sai.model.SsExecutiveDetails;
import java.util.List;
import com.sai.dao.SsExecutiveDetailsDao;
import com.sai.dao.UserLoginDao;
import com.sai.model.ExecutiveName;
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
public class SsExecutiveDetailsController {
    
    @Autowired
    private UserLoginDao userRepository; 

    @Autowired  
    private  SsExecutiveDetailsDao ExecRepository;
 
    @GetMapping("/ssExecutiveDetailses")
    public List<SsExecutiveDetails> getExec() {
        return (List<SsExecutiveDetails>) ExecRepository.findAll();
    }
 
    @PostMapping("/ssExecutiveDetailses")
    SaiResponse addUser(@RequestBody SsExecutiveDetails Executive) 
    {
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
       
        Executive.setCreatedBy(user.getUserId());
            Executive.setCreationDt(currentDate);
            Executive.setLstUpBy(user.getUserId());
            Executive.setLstUpDate(currentDate);
 
            
        ExecRepository.save(Executive);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Not Deleted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);

    }

    @PutMapping("/ssExecutiveDetailses/{id}")
    SaiResponse updateSsExecutive(@RequestBody SsExecutiveDetails updatedSsExecutive, @PathVariable Long id) {
    SaiResponse apiResponse;
     try {
        Optional<SsExecutiveDetails> optionalSsExecutive = ExecRepository.findById(updatedSsExecutive.getExecId());
        SsExecutiveDetails ssExecutive = optionalSsExecutive.isPresent() ? optionalSsExecutive.get() : null;
        if(ssExecutive != null) {
            
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
       
        updatedSsExecutive.setCreatedBy(ssExecutive.getCreatedBy());
            updatedSsExecutive.setCreationDt(ssExecutive.getCreationDt());
            updatedSsExecutive.setLstUpBy(user.getUserId());
            updatedSsExecutive.setLstUpDate(currentDate);
//            BeanUtils.copyProperties(updatedSsExecutive, SsExecutive);
            ExecRepository.save(updatedSsExecutive);
        }
        else {
            apiResponse = new SaiResponse(400, "Executive Master found", null);
        }
        apiResponse = new SaiResponse(200, "OK", updatedSsExecutive);
     }catch(Exception e){
         apiResponse = new SaiResponse(400, "Executive Master found", null);
     }
        return apiResponse;
     
    }
 
     @DeleteMapping("/ssExecutiveDetailses/{id}")
    SaiResponse deleteSsExecutive(@PathVariable Long id) {
        SaiResponse apiResponse;
        try {
       ExecRepository.deleteById(id);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Not Deleted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }
    
 
       //////////////FOR USER SUMMARY/////////////////
       @GetMapping("/ssExecutiveDetailses/Exenames/{locId}")//////////////
    public List<ExecutiveName> getExeNames(@PathVariable long locId) {
        List<ExecutiveName> locIdUser = ExecRepository.getExeNames(locId);
         return locIdUser;
  }
        
    
     @GetMapping("/ssExecutiveDetailses/{id}")
    public SsExecutiveDetails getSsExecutiveById(@PathVariable Long id){
       Optional<SsExecutiveDetails> optionalUser = ExecRepository.findById(id);
        SsExecutiveDetails user = optionalUser.isPresent() ? optionalUser.get() : null;
        return user;
    }
    
          @GetMapping("/ssExecutiveDetailses/ExeByLocId/{loc_id}")//////////////
      public List<SsExecutiveDetails> findByOrgId(@PathVariable long loc_id) {
        List<SsExecutiveDetails> exeLocId = ExecRepository.findExeByLocId(loc_id,"SR");
         return exeLocId;
      }
      
      @GetMapping("/ssExecutiveDetailses/ExeByLocIdDept/{locId}")//////////////
      public List<SsExecutiveDetails> findByLocIdAndDeptCode(@PathVariable long locId) {
            List<SsExecutiveDetails> exeLocId = ExecRepository.findByLocIdAndDeptCode(locId,"INS");
         return exeLocId;
      }

}