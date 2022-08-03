/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.insurance.SsInsuranceDetails;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Swaroopcomp
 */
public interface  SsInsuranceDetailsDao extends CrudRepository<SsInsuranceDetails, Long>{

    public SsInsuranceDetails findByPolicyNo(String policyNo);

    public List<SsInsuranceDetails> findByVehicleNo(String vehicleNo);

    public SsInsuranceDetails findByVehicleNoAndStatus(String vehicleNo, String active);

    public Optional<SsInsuranceDetails> findById(Integer id);
    
}
