/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.dao.SSAdministratorDataDao;
import com.sai.dao.SSTaskCreationDao;
import com.sai.dao.SsCustomerDao;
import com.sai.dao.SsVehicleMasterDao;
import com.sai.dto.SSTaskVehCustDet;
import com.sai.model.SSUserDispSummary;
import com.sai.model.SsAdministratorData;
import com.sai.model.SsCustomer;
import com.sai.model.SsTaskDetails;
import com.sai.model.SsVehicleMaster;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Test
 */
@RestController
public class SSAdminSummaryController {

    @Autowired
    private SSTaskCreationDao TaskRepository;

    @Autowired
    private SSAdministratorDataDao AdminRepository;

    @Autowired
    private SsCustomerDao customerRepo;

    @Autowired
    private SsVehicleMasterDao vehicleRepo;

    @GetMapping("/ssAdminSummary")
    public List<SsAdministratorData> getAdminSummary() {
        return (List<SsAdministratorData>) AdminRepository.findAll();
    }

    /////find by VEHICLE NO///
    @GetMapping("/ssAdminSummary/vehicleNo/{vehicle_no}")//////////////
    public SsTaskDetails findByVehNo(@PathVariable String vehicle_no) {
        SsTaskDetails orgIdUser = TaskRepository.findByVehicleNoAndTaskStatus(vehicle_no, "BOOKED");
        //   HrOperatingUnit user = orgIdUser.isPresent() ? orgIdUser.get() : null;
        return orgIdUser;
    }

    /////find by TASK ID NO///
    @GetMapping("/ssAdminSummary/taskid/{task_id}")//////////////
    public SSTaskVehCustDet findByTaskId(@PathVariable Long task_id) {
        SsTaskDetails orgtaskid = TaskRepository.findByTaskId(task_id);
        SsVehicleMaster vehicle = vehicleRepo.findByVehicleNo(orgtaskid.getVehicleNo());

        Optional< SsCustomer> OpCustomer = customerRepo.findByCustId(vehicle.getCustId());
        SsCustomer customer = OpCustomer.isPresent() ? OpCustomer.get() : null;;
        SSTaskVehCustDet vcm = new SSTaskVehCustDet();
        BeanUtils.copyProperties(customer, vcm);
        BeanUtils.copyProperties(vehicle, vcm);
        BeanUtils.copyProperties(orgtaskid, vcm);

        vcm.setChassisNo(vehicle.getChassis());
        vcm.setEngineNo(vehicle.getEngine());
        vcm.setSalesExecName(orgtaskid.getAssignee());
        vcm.setContacted(orgtaskid.getContacted());
        vcm.setReason(orgtaskid.getReason());
        vcm.setRemarks(orgtaskid.getRemarks());
        vcm.setServcGrp(orgtaskid.getServcGrp());
        vcm.setTaskReason(orgtaskid.getTaskReason());
        vcm.setTaskType(orgtaskid.getTaskType());
        vcm.setTaskStatus(orgtaskid.getTaskStatus());
         vcm.setLastServcDt(orgtaskid.getLastServcDt());
         vcm.setDealerCd(vehicle.getDealerCode());
        
        
        
        
        return vcm;

        // return orgtaskid;
    }

    /*
      @GetMapping("/ssAdminSummary/taskid/{task_id}")//////////////
    public SsTaskDetails findByTaskId(@PathVariable Long task_id) {
        SsTaskDetails orgtaskid = TaskRepository.findByTaskId(task_id); 
        // return orgtaskid;
    }*/
/////////////////////////GET ADMIN ID FROM TASK ID NEW/////////////////
//      @GetMapping("/ssAdminSummary/admnIdByTaskId/{task_id}")//////////////
//    public SsAdministratorData findAdminIdByTaskId(@PathVariable Long task_id) {
//        SsAdministratorData admnId = AdminRepository.findAdminIdByTaskId(task_id);
//     //   HrOperatingUnit user = orgIdUser.isPresent() ? orgIdUser.get() : null;
//        return admnId;
//    }
    //////////////FOR USER SUMMARY/////////////////
    @GetMapping("/ssUserSummary/locId/{locId}")//////////////
    public List<SSUserDispSummary> getUserSumm(@PathVariable long locId) {
        List<SSUserDispSummary> locIdUser = TaskRepository.getUserSumm(locId);
        return locIdUser;
    }

    //////////ADMIN SUMMARY DATA////////////     
    @GetMapping("/ssAdminSummaryold/locId/{locId}")//////////////
    public List<SSUserDispSummary> getAdminSumm(@PathVariable long locId) {
        List<SSUserDispSummary> locIdUser = TaskRepository.getAdminSumm(locId);
        return locIdUser;
    }

    ////////////TO DISLAY DATA ON ADMIN SUMMARY---new changed by jyoti t on 11-jul-2020
    @RequestMapping(value = "/ssAdminSummary/locId/{loc_id}", method = RequestMethod.GET, produces = {"application/JSON"})
    // Map getUsercountList(@PathVariable String vehicle_no)
    public List<Map> getMainAdminSummary(@PathVariable Integer loc_id) {
        return TaskRepository.getMainAdminSummary(loc_id);
    }

    //////////////all SUMMARY Min DATA///////
    @RequestMapping(value = "/ssAdminSummary/allfunction/{locId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public Map getallfunctions(@PathVariable Integer locId) {

        return TaskRepository.getallfunctions(locId);
    }
    ////single task id //////from sstaskcreationDao

    @RequestMapping(value = "/ssAdminSummary/ByTaskId/{locId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public List<Object> getTaskId(@PathVariable Integer locId) {
        return TaskRepository.getTaskId(locId);

    }
//     ////single admin ID id //////from sstaskcreationDao
//     @RequestMapping(value ="/ssAdminSummary/adminByTaskId/{taskId}", method = RequestMethod.GET, produces = {"application/JSON"})
//    public List<Map> getAdminId(@PathVariable Long taskId)
//    { 
//       
//        return AdminRepository.getAdminId(taskId);
//      
//    }
    /*     @GetMapping("/ssAdminSummary/ByTaskId/{locId}")//////////////
    public List<Map> getTaskId(@PathVariable long locId) {
        List<Map> locIdUser = TaskRepository.getTaskId(locId);
         return locIdUser;
  }*/
}
