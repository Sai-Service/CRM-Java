/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.insurance.SsInsuranceDetails;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Swaroopcomp
 */
public interface  SsInsuranceDetailsDao extends CrudRepository<SsInsuranceDetails, Long>{

    public SsInsuranceDetails findByPolicyNo(String policyNo);

    public List<SsInsuranceDetails> findByVehicleNo(String vehicleNo);

    public SsInsuranceDetails findByVehicleNoAndStatus(String vehicleNo, String active);

    public Optional<SsInsuranceDetails> findById(Integer id);
    
      @Modifying
    @Transactional
    @Query(value = "update SsInsuranceDetails set lstUpdationDt=curDate(),insStDate=?1,insEndDt=?2 where vehicleNo=?3 and custId=?4")
    public void updateInsDate(Date insStDate, Date insEndDt,String vehicleNo,Integer custId);

    
}
