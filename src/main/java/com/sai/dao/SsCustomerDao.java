
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;
import com.sai.model.SsCustomer;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Test
 */
    
    public interface SsCustomerDao extends CrudRepository<SsCustomer, Long>{
   
@Query("select max(custAcctNo) from SsCustomer")
    public Integer getMaxCustAccountNo();

    @Query("select max(custId) from SsCustomer")
    public Integer getMaxCustId();
    
//  @Query("select * from SsCustomer")
    // public List<Object> getCustNames();
        
 //        SsCustomer findByVehicleNo(String vehicle_no);
          
//   @Query(value="SELECT distinct ss.cust_id,ss.cust_name,ss.cust_type,ss.address1, ss.address2,  ss.address3"
//           + ",ss.location,ss.pincode,ss.city, ss.state_name,ss.contact_no1,ss.contact_no2,ss.email_id,\n" +
//    "ss.vehicle_no,ss.chassis_no,ss.engine_no,ss.model,ss.dealer_code,ss.dt_of_purchase\n" +
//    ",td.last_servc_dt,td.last_servc_type ,td.last_servc_loc,td.last_servc_km,td.amc ,td.call_du_dt,td.delv_dt \n" +
//    "FROM test.ss_task_details td,test.ss_customer ss WHERE td.cust_id=ss.cust_id and td.vehicle_no=ss.vehicle_no and\n" +
//    "ss.vehicle_no=?1 and td.call_du_dt=(SELECT MAX(call_du_dt) from test.ss_task_details where vehicle_no=?1 )", nativeQuery = true)
//   Map getVehNoExCustomer(String vehicle_no); //Working Fine
// //    public  Map getVehNoExCustomer(String vehicle_no); //Working Fine
//  
//   /////////////get Customer ModelWiseSearch//////////////////////
//       @Query(value="SELECT ss.cust_id as custId ,ss.cust_name as custName,ss.cust_type as custType,ss.address1, ss.address2 ,ss.address3,ss.location,ss.pincode,\n" +
//        " ss.city, ss.STATE_NAME stateName,ss.country country, ss.contact_no1 as contactNo1,ss.contact_no2 as contactNo2,ss.email_id emailId,ss.created_by createdBy,ss.creation_date creationDt,\n" +
//        " ss.last_updated_by as lastUpdatedBy,ss.last_updation_date as lstUpDate,ss.vehicle_no as vehicleNo,ss.chassis_no as chassisNo,ss.engine_no as engineNo,ss.model,ss.dealer_code,ss.dt_of_purchase as dealerCd FROM test.ss_customer ss "
//      + "where ss.model=?1", nativeQuery = true)
//    // Map getVehicleNo(String vehicle_no); //Working Fine
//      public List<Map> getCustModelWiseSearch(String Model); 
    
//           @Query("select custId,custName,custType,address1,address2,address3,location,pincode,city,stateName,country,contactNo1,contactNo2,"
//             + "emailId,createdBy,creationDt,lastUpdatedBy,lstUpDate,attribute1,attribute2,attribute3,attribute4,attribute5,vehicleNo,chassisNo,engineNo,model,"
//             + "dealerCd,dtOfPurchase,contactPerson,contactPerNo from SsCustomer where model=?1")
//      public List<SsCustomer> findByModel1(String model); 

     /* @Query("select * from SsCustomer where model=?1")
      public List<Map> getCustModelWiseSearch1(String model); 
      */
 public SsCustomer findTopByInputTypeOrderByIdDesc(String inputType);
 
 public Optional<SsCustomer> findByCustId(int custId);
 //public SsCustomer findByVehicleNo(String vehicleNo);
      
    public void deleteByCustId(Integer id);

    public Optional<SsCustomer> findByCustAcctNo(String cust_no);
}
