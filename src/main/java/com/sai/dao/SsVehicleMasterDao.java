
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.dto.VehicleCustomerMap;
import com.sai.model.SsVehicleMaster;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Test
 */

public interface SsVehicleMasterDao extends CrudRepository<SsVehicleMaster, Long> {

    SsVehicleMaster findByVehicleNo(String vehicleNo);

    @Query(value = "SELECT distinct ss.cust_id,ss.cust_name,ss.cust_type,ss.address1, ss.address2,  ss.address3"
            + ",ss.location,ss.pincode,ss.city, ss.state_name,ss.contact_no1,ss.contact_no2,ss.email_id,\n"
            + "sv.vehicleNo,sv.chassis as chassis_no,sv.engine as engine_no,sv.model,sv.dealerCode as dealer_code,sv.dtOfPurchase as dt_of_purchase\n"
            + ",td.last_servc_dt,td.last_servc_type ,td.last_servc_loc,td.last_servc_km ,td.call_du_dt \n"
            + "FROM test.ss_task_details td,test.ss_cust_new ss, test.ss_vehicle_master sv WHERE td.cust_id=ss.cust_id and td.vehicle_no=sv.vehicleNo and\n"
            + "td.vehicle_no=?1 and td.call_du_dt=(SELECT MAX(call_du_dt) from test.ss_task_details td where td.vehicle_no=?1 )", nativeQuery = true)
    Map getVehNoExCustomer(String vehicle_no); //Working Fine

    @Query("select NEW com.sai.dto.VehicleCustomerMap( sc.custId,sc.custName,sc.custType,sc.address1,sc.address2,sc.address3,sc.location,sc.pincode,sc.city,sc.stateName,sc.country,sc.contactNo1,sc.contactNo2,"
            + "sc.emailId,sv.vehicleNo,sv.chassis,sv.engine,sv.model,"
            + "sv.dealerCode,sv.dtOfPurchase,sv.contactPerson,sv.contactPerNo) from SsCustomer sc , SsVehicleMaster sv where sv.model=?1")
    public List<VehicleCustomerMap> findByModel(String model);

    public void deleteByCustId(Integer id);

    @Query("select NEW com.sai.dto.VehicleCustomerMap( sc.custId,sc.custName,sc.custType,sc.address1,sc.address2,sc.address3,sc.location,sc.pincode,sc.city,sc.stateName,sc.country,sc.contactNo1,sc.contactNo2,"
            + "sc.emailId,sv.vehicleNo,sv.chassis,sv.engine,sv.model,"
            + "sv.dealerCode,sv.dtOfPurchase,sv.contactPerson,sv.contactPerNo) from SsCustomer sc , SsVehicleMaster sv where sc.id =sv.custId AND sv.chassis=?1 AND sv.engine=?2")
    public VehicleCustomerMap findVehicleByChassiNoAndEngineNo(String chassis, String engineNo);
    
     public VehicleCustomerMap findVehicleByVehicleNo(String vehicleNo);
}
