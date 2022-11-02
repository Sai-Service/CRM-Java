/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.SaiResponse;
import com.sai.dao.SSAdministratorDataDao;
import com.sai.dao.SSAppoinmentDetailsDao;
import com.sai.dao.SSTaskCreationDao;
import com.sai.model.SsCustomer;
import java.util.List;
import java.lang.String;
import com.sai.dao.SsCustomerDao;
import com.sai.dao.SsSlotAvailableDao;
import com.sai.dao.SsTaskGenDao;
import com.sai.dao.SsVehicleMasterDao;
import com.sai.dao.UserLoginDao;
import com.sai.dto.Assignee;
import com.sai.dto.ExistingCustAppoinmentRequest;
import com.sai.dto.LstServLoc;
import com.sai.dto.VehicleCustomerMap;
import com.sai.model.SSAppoinmentDetails;
import com.sai.model.SsSlotAvailable;
import com.sai.model.SsTaskDetails;
import com.sai.model.SsVehicleMaster;
import com.sai.model.UserLogin;
import java.util.Calendar;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Test
 */
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SsCustomerController {

    @Autowired
    private SsCustomerDao customerRepo;

    @Autowired
    private SsVehicleMasterDao vehicleRepo;

    @Autowired
    private SSTaskCreationDao taskRepository;

    @Autowired
    private SSAdministratorDataDao adminRepository;

    @Autowired
    private SSAppoinmentDetailsDao appoinmentRepository;

    @Autowired
    private SsSlotAvailableDao slotAvail;

    @Autowired
    private UserLoginDao userRepository;

    @Autowired
    private SsTaskGenDao ssTaskGenDao;

    @GetMapping("/ssCustomers")
    public List<SsCustomer> getCust() {
        return (List<SsCustomer>) customerRepo.findAll();
    }

    @PostMapping("/ssCustomers")
    SaiResponse addCustomer(@RequestBody VehicleCustomerMap vcm) {
        SaiResponse apiResponse;
        try {
            SsCustomer customer = new SsCustomer();
            BeanUtils.copyProperties(vcm, customer);
            customer.setInputType("CRM");
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
            int userId = new Long(user.getUserId()).intValue();
            customer.setCreatedBy(userId);
            customer.setCreationDate(currentDate);
            customer.setLastUpdatedBy(userId);
            customer.setLastUpdationDate(currentDate);

            SsCustomer newCust = customerRepo.save(customer);

            SsVehicleMaster vehicleMaster = new SsVehicleMaster();
            BeanUtils.copyProperties(vcm, vehicleMaster);
            vehicleMaster.setCustId(newCust.getId());
            vehicleRepo.save(vehicleMaster);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Not Deleted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    @PutMapping("/ssCustomers/{id}")
    SaiResponse updateCustomer(@RequestBody SsCustomer updatedCustomer, @PathVariable Integer id) {
        SaiResponse apiResponse;
        Optional<SsCustomer> optionalCustomer = customerRepo.findByCustId(updatedCustomer.getCustId());
        SsCustomer Customer = optionalCustomer.isPresent() ? optionalCustomer.get() : null;
        if (Customer != null) {
            BeanUtils.copyProperties(updatedCustomer, Customer);
            customerRepo.save(Customer);
        } else {
            apiResponse = new SaiResponse(400, "Customer Master found", null);
        }
        apiResponse = new SaiResponse(200, "OK", Customer);
        return apiResponse;
    }
    
        @RequestMapping(value = "/search/vehicle", method = RequestMethod.GET, produces = {"application/JSON"})
    // Map getUsercountList(@PathVariable String vehicle_no)
    VehicleCustomerMap searchVehicle(@RequestParam Map<String, String> map) {
        String chassiNo = null;
        String engineNo = null;
        for (String searchKey : map.keySet()) {
            if (searchKey.equals("chassi")) {
                chassiNo = map.get("chassi");
            }
            if (searchKey.equals("engine")) {
                engineNo = map.get("engine");
            }
        }
        VehicleCustomerMap vehicle = vehicleRepo.findVehicleByChassiNoAndEngineNo(chassiNo, engineNo);
       
        return vehicle;
    }

    @DeleteMapping("/ssCustomers/{id}")
    SaiResponse deleteCustomer(@PathVariable Integer id) {
        SaiResponse apiResponse;
        try {
            customerRepo.deleteByCustId(id);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Not Deleted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    @GetMapping("/ssCustomers/{id}")
    public SsCustomer getSsCustomerById(@PathVariable Long id) {
        Optional<SsCustomer> optionalUser = customerRepo.findById(id);
        SsCustomer user = optionalUser.isPresent() ? optionalUser.get() : null;
        return user;
    }

    /////only to find Customer Details from customer master by VEHICLE NO///
    @GetMapping("/ssCustomers/vehicleNo/{vehicleNo}")//////////////
    public VehicleCustomerMap findByVehicleNo(@PathVariable String vehicleNo) {
        SsVehicleMaster vehicle = vehicleRepo.findByVehicleNo(vehicleNo);
        Optional< SsCustomer> OpCustomer = customerRepo.findByCustId(vehicle.getCustId());
        SsCustomer customer = OpCustomer.isPresent() ? OpCustomer.get() : null;;
        VehicleCustomerMap vcm = new VehicleCustomerMap();
        BeanUtils.copyProperties(customer, vcm);
        BeanUtils.copyProperties(vehicle, vcm);
        return vcm;
    }

    //To Find the Existing Customer Vehicle No///////////used in Existing Customer appoinment booking--working fine
    @RequestMapping(value = "/ssCustomers/ExistCustvehNo/{vehicle_no}", method = RequestMethod.GET, produces = {"application/JSON"})
    Map getUsercountList(@PathVariable String vehicle_no)
    {
    //SsTaskDetails getVehNoExCustomer(@PathVariable String vehicle_no) {
         return vehicleRepo.getVehNoExCustomer(vehicle_no);
       // return ssTaskGenDao.findTopByVehicleNoOrderByCallDuDtDesc(vehicle_no);
    }

    //To Find the Modelwise Customer Search///////////
    @RequestMapping(value = "/ssCustomers/CustModelWiseSearch/{model}", method = RequestMethod.GET, produces = {"application/JSON"})
    // Map getUsercountList(@PathVariable String vehicle_no)
    public List<VehicleCustomerMap> getCustModelWiseSearch(@PathVariable String model) {
        return vehicleRepo.findByModel(model);
    }

    @GetMapping("/ssCustomers/CustSearch/{model}")//////////////
    public List<VehicleCustomerMap> getCustModelWiseSearch1(@PathVariable String model) {
        List<VehicleCustomerMap> custVehicleList = vehicleRepo.findByModel(model);
        return custVehicleList;
    }

    ////EXISTING CUSTOMER APPOINMENT BOOKING--working
    @Transactional
    @PostMapping("/SSExistingCustAppoinment")
    SaiResponse SSExsCustAppt(@RequestBody ExistingCustAppoinmentRequest req) {
        try {
            Calendar calendar = Calendar.getInstance();
            java.util.Date currentDate = calendar.getTime();

            String timeSlot = req.getApptTimeSlt();
            String[] slotDetails = timeSlot.split("-");

            Assignee assignee = req.getAssignee();

            String[] serviceGrpDetails = req.getServcGrp().split("-");
            
            String executiveDetails[] = ((String) req.getExename()).split("-");

            LstServLoc servcLoc = req.getServcLoc();

            ////Reading usernameand userId
            String username = null;
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                username = principal.toString();
            }
            UserLogin user = userRepository.findByUsername(username);
            System.out.println("====Existin Cust Appt ====" + user.toString());

            /////////////TO INSERT TASK////////////////////
            SsTaskDetails details = new SsTaskDetails();

            details.setTaskType("SERVICE");
            details.setTaskStatus("BOOKED");
            details.setCallDuDt(currentDate);//need to pass 
            details.setCustId(req.getCustId());
            //   details.setCustName(req.getCustName());
            details.setCustAdd(req.getAddress1() + "," + req.getAddress2() + "," + req.getAddress3() + "," + req.getLocation() + "," + req.getPincode() + "," + req.getCity() + "," + req.getStateName());
            details.setContactPerson(req.getCustName());
            //    details.setCustType(req.getCustType());
            details.setContactNo1(req.getContactNo1());
            details.setContactNo2(req.getContactNo2());
            details.setEmailAdd(req.getEmailId());
            details.setVehicleNo(req.getVehicleNo());
//            details.setChassisNo(req.getChassisNo());
//            details.setEngineNo(req.getEngineNo());
//            details.setModel(req.getModel());
//            details.setDtOfPurchase(req.getDtOfPurchase());
//            details.setDealerCode(req.getDealerCode());
//            details.setAmc(req.getAmc());//

            details.setSalesExecName(serviceGrpDetails[1]);
            details.setLocId(servcLoc.getLocId());

            details.setServcGrp(serviceGrpDetails[0]);
        //    details.setContacted(req.getContacted());
        //    details.setReason(req.getReason());
            details.setRemarks(req.getRemarks());
      //      details.setTaskReason(req.getLastDesposition());//changes done by jyoti t on 09-07-20
            if (assignee.getLstServDt() != null) {
                details.setLastServcDt(assignee.getLstServDt());
            }
            details.setLastServcType(assignee.getLstServType());
            details.setLastServcLoc(servcLoc.getLocName());
            details.setLastServcKm(assignee.getLstKm());
            if (req.getApptDate() != null) {
                details.setNextServcDt(req.getApptDate());
            }
            details.setNextServcType(req.getServcType());
            details.setAttribute1(req.getServcType());

//            details.setServDuDt(assignee.getServDuDt());
//            details.setDelvDt(assignee.getDelvDt());
            //  details.setAttribute1(req.getAttribute1());
            
            details.setAssigneeId(executiveDetails[0]);
             details.setAssignee(executiveDetails[1]);
            details.setOrgId(user.getOrgId()); // get logged in user org Id and location Id
            details.setCreatedBy(user.getUserId());
            details.setCreationDate(currentDate);
            details.setLastUpdatedBy(user.getUserId());
            details.setLastUpdateDate(currentDate);

            SsTaskDetails sd1 = taskRepository.save(details);///This will save data in the Task Creation Table

            System.out.println("TASK ID Id is--" + sd1.getTaskId());

            ////////////////////ENTER DATA IN THE ADMINISTRATOR TABLE//////////////////////////   
//            SsAdministratorData adminData = new SsAdministratorData();
//
//            adminData.setTaskType(sd1.getTaskType());
////            adminData.setCustName(sd1.getCustName());
////            adminData.setCustType(sd1.getCustType());
//            adminData.setContactNo(sd1.getContactNo1());
//            adminData.setVehicleNo(sd1.getVehicleNo());
//            adminData.setCheckFlag("N");
//            adminData.setServcType(req.getServcType());
//            adminData.setCallDueDt(sd1.getCallDuDt());
//            adminData.setServDueTo(assignee.getServDuDt());
//
//            adminData.setAssignee(executiveDetails[0]);
//            adminData.setStatus("BOOKED");
//            adminData.setCreationDt(currentDate);
//            adminData.setCreatedBy(user.getUserId());
//            adminData.setLstUpdDt(currentDate);
//            adminData.setLstUpdLogin(user.getUserId());
//          //  adminData.setAssigneeId(executiveDetails[1]);
//            adminData.setTaskId(sd1.getTaskId());
//            adminData.setOrgid(user.getOrgId());
//            adminData.setServcLoc(servcLoc.getLocName());
//
//            adminRepository.save(adminData); ///Save Admin Data

            ////////****To Add New Appoinment/////
            SSAppoinmentDetails apptDetails = new SSAppoinmentDetails();

            //   apptDetails.setAppmntId(appts.getAppmntId());
            apptDetails.setTaskId(sd1.getTaskId());
          // apptDetails.setAdminId(adminData.getAdmnId());
            apptDetails.setTaskType(sd1.getTaskType());
            apptDetails.setVehicleNo(sd1.getVehicleNo());
            apptDetails.setServType(req.getServcType());
            apptDetails.setServLoc(servcLoc.getLocName());
           
            apptDetails.setApptDate(req.getApptDate());
            apptDetails.setApptTimeSlot(slotDetails[0]);
            apptDetails.setApptStatus("BOOKED");
            apptDetails.setPickUp(req.getPickUp());
            apptDetails.setAmount(req.getAmount());
            apptDetails.setPickAdd(req.getPickAdd());
            apptDetails.setRemark(req.getRemarks());
            apptDetails.setLastDesposition(req.getLastDesposition());
            apptDetails.setApptAttended(executiveDetails[0]);
            apptDetails.setApptAttDt(apptDetails.getApptDate());
            apptDetails.setApptAttLoc(servcLoc.getLocName());
            apptDetails.setPickupMms(req.getPickupMms());
            apptDetails.setPickupTime(req.getPickupTime()); // add apptdate+time
             apptDetails.setServGroup(serviceGrpDetails[0]);
            apptDetails.setAdvName(serviceGrpDetails[1]);
            apptDetails.setLocationId(servcLoc.getLocId());/////NEED TO PASS SD1.GET LOCID
            apptDetails.setOrgId(user.getOrgId());///FROM SD1.ORG
            apptDetails.setCreationDt(currentDate);
            apptDetails.setCreatedBy(user.getUserId());
            apptDetails.setLstUpDt(currentDate);
            apptDetails.setLastUpdatedBy(user.getUserId());

    
            SsSlotAvailable sltavail = slotAvail.findBySerLocIdAndServiceDateAndTiming(servcLoc.getLocId(),req.getApptDate(), slotDetails[0]);
            
            if (sltavail==null)
            {
            throw new Exception("Slot not found for given parameters");
            }
            else
            {
            long quota = sltavail.getQuota();
           quota = quota - 1;
//
            sltavail.setQuota(quota);
            slotAvail.save(sltavail);
            }


            SSAppoinmentDetails saveApptDetail = appoinmentRepository.save(apptDetails);
            System.out.println("Appoinment Id is--" + saveApptDetail.getAppmntId());

            SsTaskDetails taskObj = taskRepository.findByTaskId(saveApptDetail.getTaskId());
            taskObj.setApptmtId(saveApptDetail.getAppmntId());
            taskRepository.save(taskObj);

        } catch (Exception e) {
            e.printStackTrace();
            return new SaiResponse(400, "Error while processing customer appointment.", null);
        }
        return new SaiResponse(200, "OK", null);
    }

}
