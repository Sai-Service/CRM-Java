/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.CommonDetail;
import com.sai.SaiResponse;
import com.sai.dao.SSAdministratorDataDao;
import com.sai.dao.SSAppoinmentDetailsDao;
import com.sai.dao.SSTaskCreationDao;
import com.sai.dao.SsCustomerDao;
import com.sai.dao.SsSlotAvailableDao;
import com.sai.dao.SsVehicleMasterDao;
import com.sai.dao.UserLoginDao;
import com.sai.dto.LstServLoc;
import com.sai.model.NewCustAppt;
import com.sai.model.SSAppoinmentDetails;
import com.sai.model.SsCustomer;
import com.sai.model.SsSlotAvailable;
import com.sai.model.SsTaskDetails;
import com.sai.model.SsVehicleMaster;
import com.sai.model.UpdateTaskDetAppt;
import com.sai.model.UserLogin;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Test
 */
@RestController
public class SSAppoinmentDetailsController {

    @Autowired
    private SSAppoinmentDetailsDao appoinmentRepository;

    @Autowired
    private SSTaskCreationDao taskcreation;

    @Autowired
    private SSAdministratorDataDao adminRepository;

    @Autowired
    private SsCustomerDao customerRepo;

    @Autowired
    private SsSlotAvailableDao slotAvail;

    @Autowired
    private UserLoginDao userRepository;

    @Autowired
    private SsVehicleMasterDao vehicleRepo;

    @GetMapping("/sSAppoinmentDetailses")//////////////////
    public List<SSAppoinmentDetails> getAppoinments() {
        return (List<SSAppoinmentDetails>) appoinmentRepository.findAll();
    }

    /////find by VEHICLE NO///
    @GetMapping("/sSAppoinmentDetailses/vehicleNo/{vehNo}")//////////////
    public List<SSAppoinmentDetails> findByApptVehicleNo(@PathVariable String vehNo) {
        List<SSAppoinmentDetails> SSAppt = appoinmentRepository.findByVehicleNo(vehNo);
        return SSAppt;
    }

    //////// BOOK APPOINMENT--TO INSERT DATA IN THE SS_APPOINMENT_DETAILS AND TO UPDATE IN THE SS_TASK_DETAILS WITH TASK OPEN
    @PostMapping("/sSAppoinmentDetailses")
    SaiResponse addAppoinment(@RequestBody UpdateTaskDetAppt appts) {

        SaiResponse apiResponse;
        try {

            String timeSlotReq = appts.getApptTimeSlt();
            String timeSlot[] = timeSlotReq.split("-");

            String exeNameReq = appts.getExename();
            String exeName[] = exeNameReq.split("-");

            LstServLoc servLoc = appts.getServLoc();
            String[] serviceGrpDetails = appts.getServGroup().split("-");
            java.util.Date currentDate = Calendar.getInstance().getTime();
            java.sql.Date date = new java.sql.Date(currentDate.getTime());

            UserLogin user = null;
            try {
                String username = new CommonDetail().getLoggedInUser();
                user = userRepository.findByUsername(username);
            } catch (Exception ex) {
//            Logger.getLogger(TaskCreationController.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
                return new SaiResponse(400, "User not found", null);
            }

            if (user == null) {
                return new SaiResponse(400, "User not found", null);
            }
            SSAppoinmentDetails apptDetails = new SSAppoinmentDetails();
            //     apptDetails.setAppmntId(appts.getAppmntId());
            apptDetails.setTaskId(appts.getTaskId());
           // apptDetails.setAdminId(appts.getAdmnId());
            apptDetails.setTaskType(appts.getTaskType());
            apptDetails.setVehicleNo(appts.getVehicleNo());
            apptDetails.setServType(appts.getServType());
            apptDetails.setServLoc(servLoc.getLocName());

            apptDetails.setApptDate(appts.getApptDate());
            apptDetails.setApptTimeSlot(timeSlot[0]);
            apptDetails.setApptStatus("BOOKED");
            apptDetails.setPickUp(appts.getPickUp());
            apptDetails.setAmount(appts.getAmount());
            apptDetails.setPickAdd(appts.getPickAdd());
            apptDetails.setRemark(appts.getRemark());
            apptDetails.setApptAttended(exeName[1]); /// exeName--ASHWINI
            apptDetails.setApptAttLoc(servLoc.getLocName());
            apptDetails.setApptAttDt(appts.getApptDate());
              apptDetails.setLocationId(servLoc.getLocId());
            apptDetails.setPickupMms(appts.getPickupMms());
            apptDetails.setPickupTime(appts.getPickupTime()); // add apptdate+time
            apptDetails.setAdvName(serviceGrpDetails[1]);
            apptDetails.setServGroup(serviceGrpDetails[0]);

            apptDetails.setOrgId(appts.getOrgId());
            apptDetails.setLastDesposition(appts.getLastDesposition());
            // apptDetails.setCreationDt(appts.getCreationDt());

            if (appts.getCreationDt() != null) {
                apptDetails.setCreationDt(appts.getCreationDt());
            } else {
                apptDetails.setCreationDt(currentDate);
            }
            if (appts.getApptAttDt() != null) {
                apptDetails.setApptAttDt(appts.getApptAttDt());
            }
//            apptDetails.setCreatedBy(appts.getCreatedBy());

            apptDetails.setCreatedBy(user.getUserId());
            apptDetails.setLstUpDt(currentDate);
            apptDetails.setLastUpdatedBy(user.getUserId());
            apptDetails.setAttribute1(appts.getAttribute1());
            apptDetails.setAttribute2(appts.getAttribute2());
            apptDetails.setAttribute3(appts.getAttribute3());
            apptDetails.setAttribute4(appts.getAttribute4());
            apptDetails.setAttribute5(appts.getAttribute5());

            SSAppoinmentDetails saveApptDetail = appoinmentRepository.save(apptDetails);

            SsTaskDetails taskObj = taskcreation.findByTaskId(appts.getTaskId());
            taskObj.setApptmtId(saveApptDetail.getAppmntId());

            taskObj.setTaskStatus("BOOKED");//NEW ADDED BY JYOTI T ON 09-07-20
            taskObj.setContacted(appts.getContacted());
            taskObj.setReason(appts.getReason());
            taskObj.setRemarks(appts.getRemark());
            taskObj.setTaskReason(appts.getLastDesposition());
            //  taskObj.setLstServDt(appts.getLstServDt());//commented BY JYOTI T ON 09-07-20
            //  taskObj.setLstServType(appts.getServType());//commented BY JYOTI T ON 09-07-20
            //   taskObj.setLstServLoc(appts.getLstServLoc());//commented BY JYOTI T ON 09-07-20
            //  taskObj.setLstKm(appts.getLstKm());//commented BY JYOTI T ON 09-07-20
            taskObj.setNextServcDt(appts.getNxtServDt());
            taskObj.setNextServcType(appts.getNxtServType());
            taskObj.setServcGrp(serviceGrpDetails[0]);
            taskObj.setSalesExecName(serviceGrpDetails[1]);
            taskObj.setAssigneeId(exeName[0]);
            taskObj.setAssignee(exeName[1]);
            taskcreation.save(taskObj);
           
           // System.out.println("appoinment date :"+appts.getApptDate());
//            String apptDtEx=new SimpleDateFormat("yyyy-mm-dd").format(appts.getApptDate());

           
//            Date apptDate=new SimpleDateFormat("mm/dd/yyyy").parse(apptDtEx);
            
//            SsSlotAvailable sltavail = slotAvail.findBySerLocIdAndServiceDateAndTiming(servLoc.getLocId(),appts.getApptDate(), timeSlot[0]);
//            
//            if (sltavail==null)
//            {
//            throw new Exception("Slot not found for given parameters");
//            }
//            else
//            {
//            long quota = sltavail.getQuota();
//            quota = quota - 1;
//
//            sltavail.setQuota(quota);
//            slotAvail.save(sltavail);
//            }
        } catch (Exception e) {
            e.printStackTrace();
            return apiResponse = new SaiResponse(400, "Data Not Inserted", e.getMessage());
        }
        return apiResponse = new SaiResponse(200, "Ok", null);

    }

    ///////TO GENERATE APPOINMENT WITH NEW CUSTOMER which will insert new customer also......//
    @Transactional
    @PostMapping("/SSNewCustAppoinment")
    SaiResponse SSNewCustAppt(@RequestBody NewCustAppt newcustappt) {
        SaiResponse apiResponse;
        try {
            java.util.Date currentDate = Calendar.getInstance().getTime();

            String timeSlot = newcustappt.getApptTimeSlt();
            String[] slotDetails = timeSlot.split("-");
            String[] serviceGrpDetails = newcustappt.getServcGrp().split("-");
            String executiveDetails[] = ((String) newcustappt.getExename()).split("-");
            LstServLoc lstServLoc = newcustappt.getLstServLoc();

            ////Reading usernameand userId
            String username = null;
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                username = principal.toString();
            }
            UserLogin user = userRepository.findByUsername(username);

            /////To insert customer Data
            SsCustomer SSCust = new SsCustomer();

            SSCust.setCustId(newcustappt.getCustId());
            SSCust.setInputType("CRM");
            SSCust.setCustName(newcustappt.getCustName());
            SSCust.setCustType(newcustappt.getCustType());
            SSCust.setAddress1(newcustappt.getAddress1());
            SSCust.setAddress2(newcustappt.getAddress2());
            SSCust.setAddress3(newcustappt.getAddress3());
            SSCust.setLocation(newcustappt.getLocation());
            SSCust.setPincode(newcustappt.getPincode());
            SSCust.setCity(newcustappt.getCity());
            SSCust.setStateName(newcustappt.getStateName());
            SSCust.setCountry(newcustappt.getCountry());
            SSCust.setContactNo1(newcustappt.getContactNo1());
            SSCust.setContactNo2(newcustappt.getContactNo2());
            SSCust.setEmailId(newcustappt.getEmailId());
            SSCust.setCreatedBy(new Long(user.getUserId()).intValue());
            SSCust.setCreationDate(currentDate);
            SSCust.setLastUpdatedBy(new Long(user.getUserId()).intValue());
            SSCust.setLastUpdationDate(currentDate);
            SsCustomer custDet = customerRepo.save(SSCust);

            SsVehicleMaster vehicle = new SsVehicleMaster();
            vehicle.setCustId(custDet.getId());
            vehicle.setVehicleNo(newcustappt.getVehicleNo());
            vehicle.setChassis(newcustappt.getChassisNo());
            vehicle.setEngine(newcustappt.getEngineNo());
            vehicle.setModel(newcustappt.getModel());
            vehicle.setVariant(newcustappt.getModel());
              vehicle.setVehicleType("ARENA");//NEED TO CHANGE
            vehicle.setDealerCode(newcustappt.getEngineNo());
            vehicle.setDtOfPurchase(newcustappt.getDtOfPurchase());
            vehicle.setCreatedBy(new Long(user.getUserId()).intValue());
            vehicle.setCreationDt(currentDate);
            vehicle.setLstUpdatedBy(new Long(user.getUserId()).intValue());
            vehicle.setLstUpdatedDt(currentDate);
            SsVehicleMaster vehicleMaster = vehicleRepo.save(vehicle);

            ////////////TO INSERT TASK////////////////////
            SsTaskDetails details = new SsTaskDetails();

            details.setTaskType("SERVICE");
            details.setTaskStatus("BOOKED");//change done by jyoti t NEW to BOOKED on 09-07-20
            details.setCallDuDt(currentDate);//need to pass
//            details.setCustId(SSCust.getCustId());
            //  details.setCustName(SSCust.getCustName());
            details.setCustAdd(SSCust.getAddress1() + "," + SSCust.getAddress2() + "," + SSCust.getAddress3() + "," + SSCust.getLocation() + "," + SSCust.getPincode() + "," + SSCust.getCity() + "," + SSCust.getStateName());
            details.setContactPerson(SSCust.getCustName());
            //        details.setCustType(SSCust.getCustType());
            details.setContactNo1(String.valueOf(SSCust.getContactNo1().intValue()));
            details.setContactNo2(SSCust.getContactNo2());
            details.setEmailAdd(SSCust.getEmailId());
            details.setVehicleNo(vehicleMaster.getVehicleNo());
//            details.setChassisNo(vehicleMaster.getChassis());
//            details.setEngineNo(vehicleMaster.getEngine());
//            details.setModel(vehicleMaster.getModel());
//            details.setDtOfPurchase(vehicleMaster.getDtOfPurchase());
//            details.setDealerCode(vehicleMaster.getDealerCode());
//            details.setAmc(newcustappt.getAmc());//
            details.setSalesExecName(newcustappt.getSalesExeName());
            //   details.setLocId(lstServLoc.getLocId());
            details.setOrgId(user.getOrgId());
            details.setServcGrp(serviceGrpDetails[0]);
            details.setSalesExecName(serviceGrpDetails[1]);

            //   details.setContacted(newcustappt.getContacted());
            details.setRemarks(newcustappt.getRemarks());
            //     details.setTaskReason(newcustappt.getLastDesposition());
            details.setReason("New Customer Appointment Booked");
            if (newcustappt.getApptDate() != null) {
                details.setNextServcDt(newcustappt.getApptDate());
            }
//            details.setNxtServDt(newcustappt.getApptDate());
            details.setNextServcType(newcustappt.getLstServType());
            details.setLastServcLoc(lstServLoc.getLocName());
            details.setAttribute1(newcustappt.getLstServType());//added by Jyoti T 09-07-20
            details.setCreationDate(currentDate);
            details.setCreatedBy(user.getUserId());
            details.setLastUpdateDate(currentDate);
            details.setLastUpdatedBy(user.getUserId());
            //           details.setServDuDt(currentDate);
            details.setAssigneeId(executiveDetails[0]);
            details.setAssignee(executiveDetails[1]);

            SsTaskDetails sd1 = taskcreation.save(details);///This will save data in the Task Creation Table

            ////////////////////ENTER DATA IN THE ADMINISTRATOR TABLE//////////////////////////   
//            SsAdministratorData adminData = new SsAdministratorData();
//
//            adminData.setTaskType(sd1.getTaskType());
//         //   adminData.setCustName(sd1.getCustName());
//       //     adminData.setCustType(sd1.getCustType());
//            adminData.setContactNo(sd1.getContactNo1());
//            adminData.setVehicleNo(sd1.getVehicleNo());
//            adminData.setStatus("BOOKED");//added by Jyoti t on 09-07-20
//            adminData.setCheckFlag("N");
//            adminData.setServcType(newcustappt.getLstServType());
//            adminData.setCallDueDt(currentDate);
//          //  adminData.setServDueTo(sd1.getServDuDt());
//
//            adminData.setStatus(sd1.getTaskStatus());
//            adminData.setCreationDt(currentDate);
//            adminData.setCreatedBy(user.getUserId());
//            adminData.setLstUpdDt(currentDate);
//            adminData.setLstUpdLogin(user.getUserId());
//            adminData.setAssigneeId(executiveDetails[0]);
//            adminData.setAssignee(executiveDetails[1]);
//            adminData.setTaskId(sd1.getTaskId());
//            adminData.setOrgid(user.getOrgId());
//            adminData.setServcLoc(lstServLoc.getLocName());
//
//            adminRepository.save(adminData); ///Save Admin Data
            ////////****To Add New Appoinment/////
            SSAppoinmentDetails apptDetails = new SSAppoinmentDetails();

            //   apptDetails.setAppmntId(appts.getAppmntId());
            apptDetails.setTaskId(sd1.getTaskId());
            //    apptDetails.setAdminId(adminData.getAdmnId());
            apptDetails.setTaskType(sd1.getTaskType());
            apptDetails.setVehicleNo(sd1.getVehicleNo());
            apptDetails.setServType(newcustappt.getLstServType());
            apptDetails.setServLoc(sd1.getLastServcLoc());
            apptDetails.setApptDate(newcustappt.getApptDate());
            apptDetails.setApptTimeSlot(slotDetails[0]);
            apptDetails.setApptStatus("BOOKED");
            apptDetails.setPickUp(newcustappt.getPickUp());
            apptDetails.setAmount(newcustappt.getAmount());
            apptDetails.setPickAdd(newcustappt.getPickAdd());
            apptDetails.setRemark(sd1.getRemarks());
            apptDetails.setLastDesposition(newcustappt.getLastDesposition());
            apptDetails.setApptAttended(executiveDetails[0]);
            apptDetails.setApptAttDt(newcustappt.getApptDate());
            apptDetails.setApptAttLoc(sd1.getLastServcLoc());
            apptDetails.setPickupMms(newcustappt.getPickupMms());
            apptDetails.setPickupTime(newcustappt.getPickupTime()); // add apptdate+time
            apptDetails.setServGroup(serviceGrpDetails[0]);
            apptDetails.setAdvName(serviceGrpDetails[1]);
            apptDetails.setLocationId(lstServLoc.getLocId());/////NEED TO PASS SD1.GET LOCID
            apptDetails.setOrgId(user.getOrgId());///FROM SD1.ORG
            apptDetails.setCreationDt(currentDate);
            apptDetails.setCreatedBy(user.getUserId());
            apptDetails.setLstUpDt(currentDate);
            apptDetails.setLastUpdatedBy(user.getUserId());

//            SsSlotAvailable sltavail = slotAvail.findByLocId(lstServLoc.getLocId(), slotDetails[0]);
//            long quota = sltavail.getQuota();
//            quota = quota - 1;
//
//            sltavail.setQuota(quota);
//            slotAvail.save(sltavail);

            SSAppoinmentDetails saveApptDetail = appoinmentRepository.save(apptDetails);
            System.out.println("Appoinment Id is--" + saveApptDetail.getAppmntId());

            SsTaskDetails taskObj = taskcreation.findByTaskId(saveApptDetail.getTaskId());
            taskObj.setApptmtId(saveApptDetail.getAppmntId());
            taskcreation.save(taskObj);
        } catch (Exception e) {
             e.printStackTrace();
            return new SaiResponse(400, "New Customer appoinment Not Inserted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);

    }

    ///////////////////TO DISPLAY MARQUEE VALUE FOR appoinemtn taken admin ON HOME PAGE///////////
    @RequestMapping(value = "/ssAppoinment/getAppoinmentCount/{locId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public Map getAppoinmentCount(@PathVariable Integer locId) {

        return appoinmentRepository.getAppoinmentCount(locId);
    }
    
    
       ///////////////////TO DISPLAY MARQUEE VALUE FOR appoinemtn taken executive ON HOME PAGE///////////
    @RequestMapping(value = "/ssAppoinment/getAppoinmentCountExewise/{apptAttended}", method = RequestMethod.GET, produces = {"application/JSON"})
    public Map getAppoinmentCountExewise(@PathVariable String apptAttended) {

        return appoinmentRepository.getAppoinmentCountExewise(apptAttended);
    }

    ///////////////////TO DISPLAY MARQUEE VALUE FOR appoinemtn taken admin ON HOME PAGE///////////
    @RequestMapping(value = "/ssAppoinment/getAppoinmentPickup/{locId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public Map getAppoinmentPickup(@PathVariable Integer locId) {

        return appoinmentRepository.getAppoinmentPickup(locId);
    }
    
     ///////////////////TO DISPLAY MARQUEE VALUE FOR appoinemtn taken executive ON HOME PAGE///////////
    @RequestMapping(value = "/ssAppoinment/getAppoinmentPickupExecwise/{locId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public Map getAppoinmentPickupExecwise(@PathVariable String apptAttended) {

        return appoinmentRepository.getAppoinmentPickupExecwise(apptAttended);
    }
}
