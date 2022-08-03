/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.SaiResponse;
import com.sai.model.SsCompany;
import java.util.List;
import com.sai.dao.SsCompanyDao;
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
public class SSCompanyController {

    @Autowired
    private SsCompanyDao companyRepository;

        @Autowired
    private UserLoginDao userRepository; 

    
     java.util.Date currentDate = Calendar.getInstance().getTime();

    @GetMapping("/ssCompanies")
    public List<SsCompany> getCompany() {
   //         public List<SsCompany> getCompany(@RequestBody String Status) {
      //  return (List< SsCompany>) companyRepository.findAll();
         return (List< SsCompany>) companyRepository.findByStatus("ACTIVE");
    }

   @PostMapping("/ssCompanies")
    SaiResponse addUser(@RequestBody SsCompany company) {
        SaiResponse apiResponse;
        try {
             System.out.println("========Company===" );
           String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        UserLogin user = userRepository.findByUsername(username);  
             System.out.println("========Company===" + user.getUserId());
            company.setCreatedBy(user.getUserId());
            company.setCreationDt(currentDate);
            company.setLstUpBy(user.getUserId());
            company.setLstUpDate(currentDate);
            SsCompany newCompany = companyRepository.save(company);
            System.out.println("========Company===" + newCompany.getCreatedBy());
             return new SaiResponse(200, "Ok", newCompany);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Company not found", null);
        }
        return apiResponse;
    }

    @PutMapping("/ssCompanies/{id}")
    SaiResponse updateSsCompany(@RequestBody SsCompany updatedSsCompany, @PathVariable Long id) {
        SaiResponse apiResponse;
        
        Optional<SsCompany> optionalSsCompany = companyRepository.findById(updatedSsCompany.getCompanyCode());
        SsCompany SsCompany = optionalSsCompany.isPresent() ? optionalSsCompany.get() : null;
        try{
        if (SsCompany != null) {
            String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        UserLogin user = userRepository.findByUsername(username);  
            updatedSsCompany.setLstUpBy(user.getUserId());
            updatedSsCompany.setLstUpDate(currentDate);
            updatedSsCompany.setCreatedBy(SsCompany.getCreatedBy());
            updatedSsCompany.setCreationDt(SsCompany.getCreationDt());
            
           SsCompany comp  = companyRepository.save(updatedSsCompany);
             apiResponse = new SaiResponse(200, "OK", comp);
        } else {
            apiResponse = new SaiResponse(400, "Operating unit not found", null);
        }
         } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Company not found", null);
        }
        return apiResponse;
    }

    @DeleteMapping("/ssCompanies/{id}")
    SaiResponse deleteSsCompany(@PathVariable Long id) {
        SaiResponse apiResponse;
        try {
            companyRepository.deleteById(id);

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
    @GetMapping("/ssCompanies/{id}")
    public SsCompany getSsCompanyById(@PathVariable Long id) {
        Optional<SsCompany> optionalUser = companyRepository.findById(id);
        SsCompany user = optionalUser.isPresent() ? optionalUser.get() : null;

        return user;

    }


    /*   @RequestMapping(value ="/company/names", method = RequestMethod.GET)
    public List<Object> getCompanyNames() {
       List<Object> oCompanyLists = companyRepository.getCompanyNames();
       return oCompanyLists;
    }*/
    

    
}
