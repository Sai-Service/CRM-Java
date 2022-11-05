/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;
//import com.sai.dao.SSAdminSummaryDao;

import com.sai.CommonDetail;
import com.sai.SaiResponse;
import com.sai.dao.SSAdministratorDataDao;
import com.sai.dao.SSAppoinmentDetailsDao;
import com.sai.dao.SSTaskCreationDao;
import com.sai.dao.SsInsTaskHistoryDao;
import com.sai.dao.SsSlotAvailableDao;
import com.sai.dto.SsTaskDetailsRequest;
import com.sai.dao.UserLoginDao;
import com.sai.dto.LstServLoc;
import com.sai.dto.ReScheduleTaskRequest;
import com.sai.model.SSAppoinmentDetails;
import com.sai.model.SsSlotAvailable;
import com.sai.model.SsTaskDetails;
import com.sai.model.UserLogin;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Test
 */
@RestController
public class TaskCreationController {

    @Autowired
    private SSTaskCreationDao taskRepository;

    @Autowired
    private SSAdministratorDataDao adminRepository;

    @Autowired
    private SSAppoinmentDetailsDao appoinmentRepository;

    @Autowired
    private UserLoginDao userRepository;

    @Autowired
    private SsSlotAvailableDao slotAvail;

    @Autowired
    private SsInsTaskHistoryDao insTaskHist;

    ////UPDATE THE TASK STATUS AS CLOSED AND ADMIN STATUS CLOSED////////////
    @RequestMapping(value = "/UpdateTaskStatus", method = RequestMethod.PUT, produces = {"application/JSON"})
    SaiResponse UpdateAssignee(@RequestBody SsTaskDetails updatedTaskSt) {
        try {

            taskRepository.save(updatedTaskSt);
        } catch (Exception ex) {

            return new SaiResponse(400, "Error while closing task", ex.getMessage());
        }
        return new SaiResponse(200, "OK", null);
    }

    //TO REGENERATE TASK
    @Transactional
    @PostMapping("/SSRegenrateTask/{task_id}")
    SaiResponse addNewTask(@RequestBody SsTaskDetailsRequest taskRequest, @PathVariable Long task_id) {
        java.util.Date currentDate = Calendar.getInstance().getTime();
         UserLogin user = null;
        try {
            String username = new CommonDetail().getLoggedInUser();
            user = userRepository.findByUsername(username);
            
        } catch (Exception ex) {
            Logger.getLogger(TaskCreationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (user != null) {
                
                 SsTaskDetails oldTaskid = taskRepository.findByTaskId(task_id);

                SsTaskDetails regenTask = new SsTaskDetails();
                regenTask.setTaskType(taskRequest.getTaskType());
                regenTask.setTaskStatus(taskRequest.getTaskStatus());
                regenTask.setCustId(taskRequest.getCustId());
                regenTask.setContactPerson(taskRequest.getContactPerson());
                regenTask.setCustAdd(taskRequest.getCustAdd());
                regenTask.setContactNo1(taskRequest.getContactNo1());
                regenTask.setContactNo2(taskRequest.getContactNo2());
                regenTask.setEmailAdd(taskRequest.getEmailAdd());
                regenTask.setTaskReason(taskRequest.getTaskReason());
                regenTask.setSalesExecName(oldTaskid.getSalesExecName());
                regenTask.setServcGrp(oldTaskid.getServcGrp());
                regenTask.setVehicleNo(taskRequest.getVehicleNo());
                regenTask.setTaskReason(taskRequest.getTaskReason());

                regenTask.setLastServcType(oldTaskid.getLastServcType());
                regenTask.setLastServcLoc(oldTaskid.getLastServcLoc());
                regenTask.setLastServcKm(oldTaskid.getLastServcKm());
                regenTask.setNextServcType(oldTaskid.getNextServcType());
                     regenTask.setNextServcDt(oldTaskid.getNextServcDt());
            
                regenTask.setRemarks(taskRequest.getRemark());
                regenTask.setContacted(taskRequest.getContacted());
                regenTask.setReason(taskRequest.getReasonCode());

                regenTask.setLocId(taskRequest.getLocId());
                regenTask.setAssigneeId(taskRequest.getAssingeeId());
                regenTask.setAssignee(taskRequest.getAssingeeId());
                regenTask.setOrgId(user.getOrgId());

                if (taskRequest.getRegenerateCallDuDt() != null) {
                    regenTask.setCallDuDt(taskRequest.getRegenerateCallDuDt().getCallDuDt());
                }
                if (taskRequest.getLstServDt() != null) {
                    regenTask.setLastServcDt(taskRequest.getLstServDt());
                }
                if (taskRequest.getNxtServDt() != null) {
                    regenTask.setNextServcDt(taskRequest.getNxtServDt());
                }


                regenTask.setReferenceNo(oldTaskid.getReferenceNo());
                regenTask.setInventoryItemId(oldTaskid.getInventoryItemId());
                regenTask.setAttribute1(oldTaskid.getAttribute1());
                regenTask.setCreatedBy(user.getUserId());
                regenTask.setCreationDate(currentDate);
                regenTask.setLastUpdatedBy(user.getUserId());
                regenTask.setLastUpdateDate(currentDate);
                regenTask.setTaskStatus("Task-Regenerated");
                SsTaskDetails sd1 = taskRepository.save(regenTask);

           
                oldTaskid.setTaskStatus("CLOSED");
                oldTaskid.setLastUpdateDate(currentDate);
                oldTaskid.setLastUpdatedBy(user.getUserId());
                taskRepository.save(oldTaskid);

                 }
        } catch (Exception e) {
            e.printStackTrace();
            return new SaiResponse(400, "Invalid Inputs", null);
        }
        return new SaiResponse(200, "OK", null);
    }

///////TO RESCHEDULE TASK......//
    @Transactional
    @PostMapping("/SSReScheduleTask/{task_id}")
    SaiResponse ReSchedule(@RequestBody ReScheduleTaskRequest reScheduleTaskRequest, @PathVariable Long task_id) {
        ///To regenerate and save new task////   

        String timeSlot = reScheduleTaskRequest.getApptTimeSlt();
        String[] slotDetails = timeSlot.split("-");
        String[] serviceGrpDetails = reScheduleTaskRequest.getServGroup().split("-");
        LstServLoc servLoc = reScheduleTaskRequest.getServLoc();

        ////Reading usernameand userId
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        UserLogin user = userRepository.findByUsername(username);
        System.out.println("====Reschedule Task ====" + user.toString());

        java.util.Date currentDate = Calendar.getInstance().getTime();

        String[] executiveDetails = reScheduleTaskRequest.getExename().split("-");

        SsTaskDetails originalTask = taskRepository.findByTaskId(task_id);
        SsTaskDetails newTask = new SsTaskDetails();
        SsTaskDetails sd1 = null;
        BeanUtils.copyProperties(originalTask, newTask, "taskId");
//         if (newTask != null) {
        newTask.setServcGrp(serviceGrpDetails[0]);
        newTask.setSalesExecName(serviceGrpDetails[1]);
        newTask.setNextServcType(reScheduleTaskRequest.getServType());

        newTask.setCreatedBy(user.getUserId());
        newTask.setCreationDate(currentDate);
        newTask.setLastUpdatedBy(user.getUserId());
        newTask.setLastUpdateDate(currentDate);
        newTask.setAssigneeId(executiveDetails[0]);
        newTask.setAssignee(executiveDetails[1]);
        newTask.setTaskStatus("Task-Rescheduled");
        sd1 = taskRepository.save(newTask);
//        }

        ////////////////////ENTER DATA IN THE ADMINISTRATOR TABLE//////////////////////////   
//        SsAdministratorData adminData = new SsAdministratorData();
//        adminData.setTaskType(sd1.getTaskType());
////        adminData.setCustName(sd1.getCustName());
////        adminData.setCustType(sd1.getCustType());
//        adminData.setContactNo(sd1.getContactNo1());
//        adminData.setVehicleNo(sd1.getVehicleNo());
//        adminData.setCheckFlag("N");
//        adminData.setServcType(sd1.getNextServcType());//changed by Jyoti T on 09-07-2020
//        adminData.setCallDueDt(sd1.getCallDuDt());
////        if (sd1.getServDuDt() != null) {
////            adminData.setServDueTo(sd1.getServDuDt());
////        }
//        adminData.setStatus(sd1.getTaskStatus());
//        adminData.setCreationDt(currentDate);
//        adminData.setCreatedBy(user.getUserId());
//        adminData.setLstUpdDt(currentDate);
//        adminData.setLstUpdLogin(user.getUserId());
//        adminData.setTaskId(sd1.getTaskId());
//        adminData.setOrgid(user.getOrgId());
//        adminData.setServcLoc(servLoc.getLocName());//changes done by Jyoti T on 09-07-20
//        //set assignee and assignee Id
//        adminData.setAssigneeId(executiveDetails[0]);
//        adminData.setAssignee(executiveDetails[1]);
//
//        adminRepository.save(adminData);
        ////////****To Add New Appoinment/////
        SSAppoinmentDetails apptDetails = new SSAppoinmentDetails();
        SSAppoinmentDetails apptInsert = appoinmentRepository.findByTaskId(task_id);
        if (apptInsert == null) {

            return new SaiResponse(400, "Appointment for this task id is not present", null);
        }

        //     apptDetails.setAppmntId(appts.getAppmntId());
        apptDetails.setTaskId(sd1.getTaskId());
        // apptDetails.setAdminId(adminData.getAdmnId());

        apptDetails.setServType(reScheduleTaskRequest.getServType());
        apptDetails.setServLoc(servLoc.getLocName());
        apptDetails.setServGroup(serviceGrpDetails[0]);
        apptDetails.setAdvName(serviceGrpDetails[1]);
        apptDetails.setPickupMms(reScheduleTaskRequest.getPickupMms());
        apptDetails.setPickupTime(reScheduleTaskRequest.getPickupTime());
        apptDetails.setApptDate(reScheduleTaskRequest.getApptDate());

        apptDetails.setApptTimeSlot(slotDetails[0]);
        apptDetails.setApptStatus("BOOKED");
        apptDetails.setPickUp(reScheduleTaskRequest.getPickUp());
        apptDetails.setAmount(reScheduleTaskRequest.getAmount());
        apptDetails.setPickAdd(reScheduleTaskRequest.getPickAdd());
        //existing appointment details 
        apptDetails.setTaskType(apptInsert.getTaskType());
        apptDetails.setVehicleNo(apptInsert.getVehicleNo());
        apptDetails.setRemark(apptInsert.getRemark());
        apptDetails.setLastDesposition(apptInsert.getLastDesposition());
        apptDetails.setApptAttended(executiveDetails[1]);//changes done by jyoti t on 09-07-20---[0] to [1]
        apptDetails.setApptAttLoc(servLoc.getLocName());
        apptDetails.setApptAttDt(reScheduleTaskRequest.getApptDate());
//        apptDetails.setApptAttLoc(apptInsert.getApptAttLoc());
        apptDetails.setLocationId(servLoc.getLocId());
        apptDetails.setOrgId(user.getOrgId());
        // apptDetails.setCreationDt(appts.getCreationDt());

        if (apptInsert.getCreationDt() != null) {
            apptDetails.setCreationDt(apptInsert.getCreationDt());
        }
        apptDetails.setCreatedBy(user.getUserId());
        apptDetails.setLstUpDt(currentDate);
        apptDetails.setLastUpdatedBy(user.getUserId());

        apptDetails.setAttribute1(apptInsert.getAttribute1());
        apptDetails.setAttribute2(apptInsert.getAttribute2());/////////////////
        apptDetails.setAttribute3(apptInsert.getAttribute3());
        apptDetails.setAttribute4(apptInsert.getAttribute4());
        apptDetails.setAttribute5(apptInsert.getAttribute5());

        SSAppoinmentDetails saveApptDetail = appoinmentRepository.save(apptDetails);
        //  System.out.println("Appoinment Id is--" + saveApptDetail.getAppmntId());

        sd1.setApptmtId(saveApptDetail.getAppmntId());
        //    SsTaskDetails taskObj = taskRepository.findByTaskId(sd1.getTaskId());
        //  taskObj.setApptmtId(saveApptDetail.getAppmntId());
//
     //   SsSlotAvailable sltavail = slotAvail.findByLocId(servLoc.getLocId(), slotDetails[0]);
      SsSlotAvailable sltavail = slotAvail.findBySerLocIdAndServiceDateAndTiming(servLoc.getLocId(), apptInsert.getApptDate(), slotDetails[0]);
     
     long quota = sltavail.getQuota();
        quota = quota - 1;

        sltavail.setQuota(quota);
        sltavail.setLstUpBy(user.getUserId());
//            sltavail.setLstUpDate(currentDate.toString());
        slotAvail.save(sltavail);

        ////////////////////////////////Close Appoinment/////////////////////////
        //To close old Task      
        SsTaskDetails oldTaskid = taskRepository.findByTaskId(task_id);
        // SsTaskDetails taskObj = taskRepository.findByTaskId(SsTask.getTaskId());////Not Found
        oldTaskid.setTaskStatus("CLOSED");

        taskRepository.save(oldTaskid);

        //To close old admin data against above task
//        SsAdministratorData admnData = adminRepository.findByTaskId(task_id);
//        admnData.setStatus("Task-Rescheduled");
//        admnData.setLstUpdDt(currentDate);
//        adminRepository.save(admnData);
        //To close old admin data against above task
        SSAppoinmentDetails apptData = appoinmentRepository.findByTaskId(task_id);
        apptData.setApptStatus("Task-Rescheduled");
        apptData.setLstUpDt(currentDate);
        appoinmentRepository.save(apptData);
        return new SaiResponse(200, "OK", null);
    }

    //To Find the EW Customer Reminder Date///////////
    @RequestMapping(value = "/ssTask/EWReminderMessage/{vehicleNo}", method = RequestMethod.GET, produces = {"application/JSON"})
    // Map getUsercountList(@PathVariable String vehicle_no)
    Map getEWMessage(@PathVariable String vehicleNo) {
        return taskRepository.getEWMessage(vehicleNo);
    }

    @RequestMapping(value = "/ssTask/MCPReminderMessage/{vehicleNo}", method = RequestMethod.GET, produces = {"application/JSON"})
    // Map getUsercountList(@PathVariable String vehicle_no)
    Map getMCPMessage(@PathVariable String vehicleNo) {
        return taskRepository.getMCPMessage(vehicleNo);
    }

    @RequestMapping(value = "/ssTask/totalApptExewise/{loc_id}", method = RequestMethod.GET, produces = {"application/JSON"})
    // Map getUsercountList(@PathVariable String vehicle_no)
    public List<Map> getTotalApptExewise(@PathVariable Integer loc_id) {
        return taskRepository.getTotalApptExewise(loc_id);

    }

    @RequestMapping(value = "/ssTask/SlotAvailable", method = RequestMethod.GET, produces = {"application/JSON"})
    // Map getUsercountList(@PathVariable String vehicle_no)
    public List<Map> getSlotAvailNew(@RequestParam long serv_loc_id,@RequestParam String serviceDate) {
        return taskRepository.getSlotAvailDatewise(serv_loc_id,serviceDate);

    }
    
    
    @RequestMapping(value = "/ssTask/SlotAvailable/{serv_loc_id}", method = RequestMethod.GET, produces = {"application/JSON"})
    // Map getUsercountList(@PathVariable String vehicle_no)
    public List<Map> getSlotAvail(@PathVariable long serv_loc_id) {
        return taskRepository.getSlotAvail(serv_loc_id);

    }
    
    
      @RequestMapping(value = "/ssTask/UserSummLoginwise/{assignee_id}", method = RequestMethod.GET, produces = {"application/JSON"})
    // Map getUsercountList(@PathVariable String vehicle_no)
    public List<Map> getUserSummLoginwise(@PathVariable String assignee_id) {
        return taskRepository.getUserSummLoginwise(assignee_id);

    }

    /////find by VEHICLE NO///
    /////find by VEHICLE NO///
    @GetMapping("/sSTaks/vehicleNoAppt/{vehicleNo}")//////////////
    public List<SsTaskDetails> getApptTaskVehicleNo(@PathVariable String vehicleNo) {
        List<SsTaskDetails> SSAppt = taskRepository.findByVehicleNo(vehicleNo);
        //   HrOperatingUnit user = orgIdUser.isPresent() ? orgIdUser.get() : null;
        return SSAppt;
    }
//    @GetMapping("/sSTaks/vehicleNoAppt/{vehicleNo}")//////////////
//    public List<SsTaskDetails> getApptTaskVehicleNo(@PathVariable String vehicleNo) {
//        List<SsTaskDetails> SSAppt = taskRepository.getApptTaskVehicleNo(vehicleNo);
//        //   HrOperatingUnit user = orgIdUser.isPresent() ? orgIdUser.get() : null;
//        return SSAppt;
//    }
    ///////////////////TO DISPLAY MARQUEE VALUE FOR CONTACTED CUSTOMER ON HOME PAGE admin///////////

    @RequestMapping(value = "/ssTask/getContactedCust/{locId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public Map getContactedCust(@PathVariable int locId) {

        return taskRepository.getContactedCust(locId);
    }

    ///////////////////TO DISPLAY MARQUEE VALUE FOR UNCONTACTED CUSTOMER ON HOME PAGE admin///////////
    @RequestMapping(value = "/ssTask/getUnContactedCust/{locId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public Map getUnContactedCust(@PathVariable int locId) {

        return taskRepository.getUnContactedCust(locId);
    }

    ///////////////////TO DISPLAY MARQUEE VALUE FOR UNCONTACTED CUSTOMER ON HOME PAGE admin///////////
    @RequestMapping(value = "/ssTask/getSmsSend/{locId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public Map getTotalSMSSend(@PathVariable int locId) {

        return taskRepository.getTotalSMSSend(locId);
    }

    @RequestMapping(value = "/ssTask/yesttotalApptExewise/{loc_id}", method = RequestMethod.GET, produces = {"application/JSON"})
    // Map getUsercountList(@PathVariable String vehicle_no)
    public List<Map> getTotApptExeYesterday(@PathVariable Integer loc_id) {
        return taskRepository.getTotApptExeYesterday(loc_id);

    }

    ///////////////////TO DISPLAY MARQUEE VALUE FOR CONTACTED CUSTOMER ON HOME PAGE EXECUTIVE///////////
    @RequestMapping(value = "/ssTask/getContactedCustExeWise/{assigneeId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public Map getContactedCustExeWise(@PathVariable String assigneeId) {

        return taskRepository.getContactedCustExeWise(assigneeId);
    }

    ///////////////////TO DISPLAY MARQUEE VALUE FOR UNCONTACTED CUSTOMER ON HOME PAGE admin///////////
    @RequestMapping(value = "/ssTask/getUnContactedCustExewise/{assigneeId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public Map getUnContactedCustExewise(@PathVariable String assigneeId) {

        return taskRepository.getUnContactedCustExewise(assigneeId);
    }

    ///////////////////TO DISPLAY MARQUEE VALUE FOR UNCONTACTED CUSTOMER ON HOME PAGE///////////
    @RequestMapping(value = "/ssTask/getTotalSMSSendExeWise/{apptAttended}", method = RequestMethod.GET, produces = {"application/JSON"})
    public Map getTotalSMSSendExeWise(@PathVariable String apptAttended) {

        return taskRepository.getTotalSMSSendExeWise(apptAttended);
    }

}
