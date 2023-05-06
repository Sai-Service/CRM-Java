/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.SaiResponse;
import com.sai.dao.SsCustomerDao;
import com.sai.dao.SsInsTaskDetailsDao;
import com.sai.dao.SsInsuranceDetailsDao;
import com.sai.dao.SsVehicleMasterDao;
import com.sai.dto.SsInsCustomer;
import com.sai.model.SsCustomer;
import com.sai.model.SsVehicleMaster;
import com.sai.model.insurance.SsInsTaskDetails;
import com.sai.model.insurance.SsInsuranceDetails;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Swaroopcomp
 */
@RestController
@RequestMapping("/ins")
public class SsInsuranceDetailsController implements Serializable {

    @Autowired
    SsInsuranceDetailsDao insuranceDetailsDao;
    @Autowired
    private SsCustomerDao customerDao;

    @Autowired
    private SsInsTaskDetailsDao insTaskDetailsDao;

    @Autowired
    private SsVehicleMasterDao vehicleDao;

    @GetMapping("/policy")
    public List<SsInsuranceDetails> getInsPlicyDetails() {
        return (List<SsInsuranceDetails>) insuranceDetailsDao.findAll();
    }

    @PostMapping("/policy")
    SaiResponse addPolicyDetails(@RequestBody SsInsuranceDetails details) {
        SaiResponse apiResponse;
        try {
            insuranceDetailsDao.save(details);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Error while Inserting Insurance Policy details", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    @PutMapping("/policy/{id}")
    SaiResponse updatePolicy(@RequestBody SsInsuranceDetails updatedPolicy, @PathVariable Integer id) {
        SaiResponse apiResponse;
        Optional<SsInsuranceDetails> opsInsDetail = insuranceDetailsDao.findById(id);
        SsInsuranceDetails insDetail = opsInsDetail.isPresent() ? opsInsDetail.get() : null;

        if (insDetail != null) {
            BeanUtils.copyProperties(updatedPolicy, insDetail);
            insDetail.setVehicleNo(updatedPolicy.getVehicleNo());
            insuranceDetailsDao.save(insDetail);
        } else {
            apiResponse = new SaiResponse(400, " Insurance Policy details not found", null);
        }
        apiResponse = new SaiResponse(200, "OK", insDetail);
        return apiResponse;
    }

    @DeleteMapping("/policy/{id}")
    SaiResponse deletePolicy(@PathVariable Integer id) {
        SaiResponse apiResponse;
        try {
            Optional<SsInsuranceDetails> opsInsDetail = insuranceDetailsDao.findById(id);
            SsInsuranceDetails insDetail = opsInsDetail.isPresent() ? opsInsDetail.get() : null;

            if (insDetail != null) {
                insuranceDetailsDao.delete(insDetail);
            }
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Not Deleted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    @GetMapping("/policy/{id}")
    public SsInsuranceDetails getSsInsuranceDetailsById(@PathVariable String id) {
        SsInsuranceDetails policyDetails = insuranceDetailsDao.findByPolicyNo(id);
        return policyDetails;

    }

    @RequestMapping(value = "/policy/byVehicle/{vehicleNo}", method = RequestMethod.GET, produces = {"application/JSON"})
    SsInsCustomer getSsInsuranceDetailsByVehicleNo(@PathVariable String vehicleNo) {
        
        SsInsuranceDetails details = insuranceDetailsDao.findByVehicleNoAndStatus(vehicleNo, "Active");
        SsVehicleMaster vehicle = vehicleDao.findByVehicleNo(vehicleNo);
    
        Optional<SsCustomer> optionalCustomer = customerDao.findByCustId(vehicle.getCustId());
        SsCustomer customer = optionalCustomer.isPresent() ? optionalCustomer.get() : null;
        
//        Optional<SsCustomer> optionalCustomer = customerDao.findById(new Long(vehicle.getCustId()));
//        SsCustomer customer = optionalCustomer.isPresent() ? optionalCustomer.get() : null;
//       
      //  SsInsTaskDetails insTaskDetails = insTaskDetailsDao.findByVehicleNoAndEventStatus(vehicleNo, "NEW");
         SsInsTaskDetails insTaskDetails = insTaskDetailsDao.getByVehStatus(vehicleNo);
        SsInsCustomer insCustomer = new SsInsCustomer();

        BeanUtils.copyProperties(customer, insCustomer);

        BeanUtils.copyProperties(insTaskDetails, insCustomer);
        BeanUtils.copyProperties(details, insCustomer);
        BeanUtils.copyProperties(vehicle, insCustomer);
        insCustomer.setChassisNo(vehicle.getChassis());
        insCustomer.setEngineNo(vehicle.getEngine());
        insCustomer.setContactNo1(customer.getContactNo1());
       insCustomer.setContactNo2(customer.getContactNo2());
       
       
        return insCustomer;
    }

}
