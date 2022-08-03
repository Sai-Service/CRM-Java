/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.dto.SsServiceHistoryJobDetails;
import com.sai.dto.SsServiceHistoryResponse;
import com.sai.model.SsServiceHistory;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface SsServiceHistoryDao extends CrudRepository<SsServiceHistory, Long> {

    @Query("select NEW com.sai.dto.SsServiceHistoryResponse(sh.vehicleNo, sh.custName, sh.address, sh.contactNo, sh.emailId, sh.amc, sh.engineWax, sh.teflon, sh.underChassis, sh.dinitrol, sh.model, sh.description, sh.chassisNo, sh.engineNo, sh.dos, sh.addContact, sh.ewStartDt, sh.ewPeriod, sh.ewInsurer, sh.fuelType ) from SsServiceHistory sh where sh.vehicleNo=?1 order by sh.jobDate ")
    public List<SsServiceHistoryResponse> findOneServiceHistoryReportHeader(String vehicleNumber);

    @Query("select NEW com.sai.dto.SsServiceHistoryJobDetails(sh.srNo, sh.serviceType, sh.locCity, sh.jobNo, sh.saName, sh.techName, sh.surveyorName, sh.alternateMobile, sh.dealerName, sh.jobDate, sh.delvDate, sh.group, sh.mileage, sh.billNo, sh.billDate, sh.partAmt, sh.laborAmt, sh.totamt, sh.material, sh.matDesc, sh.type, sh.quantity, sh.totalAmt, sh.chargesType, sh.recomondation) from SsServiceHistory sh where sh.vehicleNo=?1 order by  sh.jobDate ")
    public List<SsServiceHistoryJobDetails> findServiceHistoryJobDetails(String vehicleNumber);
}
