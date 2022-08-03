package com.sai.controller;

import com.sai.SaiResponse;
import com.sai.model.SsCommonList;
import java.util.List;

import com.sai.dao.SsCommonListDao;
import com.sai.dao.UserLoginDao;
import com.sai.model.ActiveStatus;
import com.sai.model.CALLTYPE;
import com.sai.model.LoginRole;
import com.sai.model.LoginCallType;
import com.sai.model.ColorCode;
import com.sai.model.CommonAllType;
import com.sai.model.CustType;
import com.sai.model.Designation;
import com.sai.model.DeptName;
import com.sai.model.Despositions;
import com.sai.model.DivCode;
import com.sai.model.FuelType;
import com.sai.model.ModelCode;
import com.sai.model.ReasonCode;
import com.sai.model.ServiceCallBasedOn;
import com.sai.model.ServiceType;
import com.sai.model.StateName;
import com.sai.model.SubCategory;
import com.sai.model.TaskStatus;
import com.sai.model.UserLogin;
import com.sai.model.YNCode;
import com.sai.model.insurance.CustStatus;
import com.sai.model.insurance.EventDisposition;
import com.sai.model.insurance.EventType;
import com.sai.model.insurance.PolicyRenwType;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Test
 */
@RestController
    public class SSCommonListController {

    @Autowired
    private SsCommonListDao commonRepository;
    //private ColorCodeDao colorRepository;
    //  
     @Autowired
    private UserLoginDao userRepository;
     
    @GetMapping("/ssCommonLists")
    public List<SsCommonList> getCommon() {
        return (List<SsCommonList>) commonRepository.findAll();
    }

    @PostMapping("/ssCommonLists")
    SaiResponse addUser(@RequestBody SsCommonList commonL) {
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
        
        commonL.setCreatedBy(user.getUserId());
           commonL.setCreationDt(currentDate);
            commonL.setLstUpBy(user.getUserId());
            commonL.setLstUpDt(currentDate);
 
            commonRepository.save(commonL);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Common List not found", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    @PutMapping("/ssCommonLists/{id}")
    SaiResponse updateCommonL(@RequestBody SsCommonList updatedCommonL, @PathVariable Long id) {
        SaiResponse apiResponse;
        Optional<SsCommonList> optionalCommonL = commonRepository.findById(updatedCommonL.getCmCode());
        SsCommonList CommonL = optionalCommonL.isPresent() ? optionalCommonL.get() : null;
        if (CommonL != null) {
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
        
        updatedCommonL.setCreatedBy(CommonL.getCreatedBy());
           updatedCommonL.setCreationDt(CommonL.getCreationDt());
            updatedCommonL.setLstUpBy(user.getUserId());
            updatedCommonL.setLstUpDt(currentDate);
//            BeanUtils.copyProperties(updatedCommonL, CommonL);
            commonRepository.save(updatedCommonL);
        } else {
            apiResponse = new SaiResponse(400, "Operating unit not found", null);
        }
        apiResponse = new SaiResponse(200, "OK", updatedCommonL);
        return apiResponse;
        // return CommonL;
    }///////

    @DeleteMapping("/ssCommonLists/{id}")
    SaiResponse deleteCommonL(@PathVariable Long id) {
        SaiResponse apiResponse;
        try {
            commonRepository.deleteById(id);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Not Deleted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    //FOR STATE CODE
    @RequestMapping(value = "/ssCommonLists/names", method = RequestMethod.GET)
    public List<StateName> getOpUnitsNames() {
        List<StateName> objLists = commonRepository.getStateNames();
        return objLists;
    }

    //FOR COLOR CODE
    @RequestMapping(value = "/ssCommonLists/ColorCode", method = RequestMethod.GET)
    public List<ColorCode> getColorCode() {
        List<ColorCode> objLists = commonRepository.getColorCode();
        return objLists;
    }

    //FOR MODEL CODE
    @RequestMapping(value = "/ssCommonLists/ModelCode", method = RequestMethod.GET)
    public List<ModelCode> getModelCode() {
        List<ModelCode> objLists = commonRepository.getModelCode();
        return objLists;
    }

    //FOR dept CODE
    @RequestMapping(value = "/ssCommonLists/DeptName", method = RequestMethod.GET)
    public List<DeptName> getDeptCode() {
        List<DeptName> objLists = commonRepository.getDeptCode();
        return objLists;
    }

    //FOR Service CODE
    @RequestMapping(value = "/ssCommonLists/ServiceType", method = RequestMethod.GET)
    public List<ServiceType> getServiceType() {
        List<ServiceType> objLists = commonRepository.getServiceType();
        return objLists;
    }

    //FOR SUB CATEGORY
    @RequestMapping(value = "/ssCommonLists/SubCategory", method = RequestMethod.GET)
    public List<SubCategory> getSubCategory() {
        List<SubCategory> objLists = commonRepository.getSubCategory();
        return objLists;
    }

    //FOR DESPOSITION
    @RequestMapping(value = "/ssCommonLists/Despositions", method = RequestMethod.GET)
    public List<Despositions> getDespositions() {
        List<Despositions> objLists = commonRepository.getDespositions();
        return objLists;
    }

    //FOR REASON CODE
    @RequestMapping(value = "/ssCommonLists/ReasonCode", method = RequestMethod.GET)
    public List<ReasonCode> getReasonCode() {
        List<ReasonCode> objLists = commonRepository.getReasonCode();
        return objLists;
    }

    //FOR YN CODE
    @RequestMapping(value = "/ssCommonLists/YNCode", method = RequestMethod.GET)
    public List<YNCode> getYNCode() {
        List<YNCode> objLists = commonRepository.getYNCode();
        return objLists;
    }

    //FOR DIVCODE CODE
    @RequestMapping(value = "/ssCommonLists/DivCode", method = RequestMethod.GET)
    public List<DivCode> getDivCode() {
        List<DivCode> objLists = commonRepository.getDivCode();
        return objLists;
    }

    //FOR CALL TYPE CODE
    @RequestMapping(value = "/ssCommonLists/CallType", method = RequestMethod.GET)
    public List<CALLTYPE> getCALLTYPE() {
        List<CALLTYPE> objLists = commonRepository.getCALLTYPE();
        return objLists;
    }

    //FOR service call based on TYPE CODE
    @RequestMapping(value = "/ssCommonLists/ServiceClBsOn", method = RequestMethod.GET)
    public List<ServiceCallBasedOn> getServiceClBsOn() {
        List<ServiceCallBasedOn> objLists = commonRepository.getServiceClBsOn();
        return objLists;
    }
    //FOR FUEL TYPE CODE

    @RequestMapping(value = "/ssCommonLists/FuelType", method = RequestMethod.GET)
    public List<FuelType> getFuelType() {
        List<FuelType> objLists = commonRepository.getFuelType();
        return objLists;
    }

    //FOR ACTIVE/INACTIVE STATUS  CODE
    @RequestMapping(value = "/ssCommonLists/StatusCode", method = RequestMethod.GET)
    public List<ActiveStatus> getActiveStatus() {
        List<ActiveStatus> objLists = commonRepository.getActiveStatus();
        return objLists;
    }

    @GetMapping("/ssCommonLists/{id}")
    public SsCommonList getCommonLById(@PathVariable Long id) {
        Optional<SsCommonList> optionalUser = commonRepository.findById(id);
        SsCommonList user = optionalUser.isPresent() ? optionalUser.get() : null;
        return user;
    }

    @GetMapping("/ssCommonLists/findByCmnType/{type}")//////////////
    public List<SsCommonList> findByCmnType(@PathVariable String type) {
        List<SsCommonList> cmnType = commonRepository.findByCmnType(type);
        return cmnType;
    }

    //Please   
    @RequestMapping(value = "/ssCommonLists/AllTypes", method = RequestMethod.GET)
    public List<CommonAllType> getDisTypes() {
        List<CommonAllType> objLists = commonRepository.getDisTypes();
        return objLists;
    }

    @RequestMapping(value = "/ssCommonLists/CustType", method = RequestMethod.GET)
    public List<CustType> getCustType() {
        List<CustType> objLists = commonRepository.getCustType();
        return objLists;
    }

    @RequestMapping(value = "/ssCommonLists/TaskType", method = RequestMethod.GET)
    public List<TaskStatus> getTaskType() {
        List<TaskStatus> objLists = commonRepository.getTaskType();
        return objLists;
    }

    @RequestMapping(value = "/ssCommonLists/LoginRole", method = RequestMethod.GET)
    public List<LoginRole> getLoginRole() {
        List<LoginRole> objLists = commonRepository.getLoginRole();
        return objLists;
    }

    @RequestMapping(value = "/ssCommonLists/LoginCallType", method = RequestMethod.GET)
    public List<LoginCallType> getLoginCallType() {
        List<LoginCallType> objLists = commonRepository.getLoginCallType();
        return objLists;
    }
    
      @RequestMapping(value = "/ssCommonLists/CustStatus", method = RequestMethod.GET)
    public List<CustStatus> getCustStatus() {
        List<CustStatus> objLists = commonRepository.getCustStatus();
        return objLists;
    }

       @RequestMapping(value = "/ssCommonLists/EventType", method = RequestMethod.GET)
    public List<EventType> getEventType() {
        List<EventType> objLists = commonRepository.getEventType();
        return objLists;
    }

       @RequestMapping(value = "/ssCommonLists/EventDisposition", method = RequestMethod.GET)
    public List<EventDisposition> getEventDisposition() {
        List<EventDisposition> objLists = commonRepository.getEventDisposition();
        return objLists;
    } 
    
        @RequestMapping(value = "/ssCommonLists/PolicyRenwType", method = RequestMethod.GET)
    public List<PolicyRenwType> getPolicyRenwType() {
        List<PolicyRenwType> objLists = commonRepository.getPolicyRenwType();
        return objLists;
    } 
    
    @RequestMapping(value = "/ssCommonLists/Designation", method = RequestMethod.GET)
    public List<Designation> getDesignation() {
        List<Designation> objLists = commonRepository.getDesignation();
        return objLists;
    } 
    
       @RequestMapping(value = "/ssCommonLists/YEventDespositions", method = RequestMethod.GET)
    public List<Despositions> getYEventDespositions() {
        List<Despositions> objLists = commonRepository.getYEventDespositions();
        return objLists;
    } 

     @RequestMapping(value = "/ssCommonLists/NEventDespositions", method = RequestMethod.GET)
    public List<Despositions> getNEventDespositions() {
        List<Despositions> objLists = commonRepository.getNEventDespositions();
        return objLists;
    }
    
    @RequestMapping(value = "/ssCommonLists/insPaymentMode", method = RequestMethod.GET)
    public List<Despositions> getPaymentMode() {
        List<Despositions> objLists = commonRepository.getPaymentMode();
        return objLists;
    }
    
    @RequestMapping(value = "/ssCommonLists/getCmnList", method = RequestMethod.GET)
    public List<Despositions> getCmnList() {
        List<Despositions> objLists = commonRepository.getCmnList();
        return objLists;
    }
    
      @GetMapping("/ssCommonLists/findByManuallyCmCode/{cmName}")//////////////
    public List<Despositions> findByManuallyCmCode(@PathVariable String cmName) {
        List<Despositions> cmnType = commonRepository.findByManuallyCmCode(cmName);
        return cmnType;
    }
    
       @RequestMapping(value = "/ssCommonLists/SmsType", method = RequestMethod.GET)
    public List<Despositions> getSmsType() {
        List<Despositions> objLists = commonRepository.getSmsType();
        return objLists;
    }
}
