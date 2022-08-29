/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.SaiResponse;
import com.sai.dao.SalesTaskDetailsDao;
import com.sai.dto.prfTaskRegenrate;
import com.sai.model.SalesTaskDetails;
import com.sai.model.SsTaskDetails;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */
@RestController
public class SalesTaskDetailsController {

    @Autowired
    private SalesTaskDetailsDao ssTaskDetRepo;

    @GetMapping("/SalesTaskDetails/{locId}")
    public List<SalesTaskDetails> getByLocId(@PathVariable Integer locId) {
        List<SalesTaskDetails> locDet = ssTaskDetRepo.findByLocIdAndTaskStatus(locId, "NEW");
        //  SalesTaskDetails locDet1 = locDet.isPresent() ? locDet.get() : null;
        return locDet;
    }

    @GetMapping("/SalesTaskDetails/taskId/{taskId}")
    public SalesTaskDetails getBytaskId(@PathVariable Integer taskId) {
        Optional<SalesTaskDetails> taskDet = ssTaskDetRepo.findByTaskId(taskId);
        SalesTaskDetails taskDet1 = taskDet.isPresent() ? taskDet.get() : null;
        return taskDet1;
    }

    @GetMapping("/SalesTaskDetails/UserSumm/{taskAssigneeId}")
    public List<SalesTaskDetails> getByAssigneeId(@PathVariable String taskAssigneeId) {
        List<SalesTaskDetails> userData = ssTaskDetRepo.findByTaskAssigneeIdAndTaskStatus(taskAssigneeId, "NEW");
        //  SalesTaskDetails locDet1 = locDet.isPresent() ? locDet.get() : null;
        return userData;
    }

    //////TO RESCHEDULE TASK......//
    @Transactional
    @PostMapping("/SalesTaskDetails/SSReGenerate/{taskId}")
    SaiResponse ReSchedule(@RequestBody prfTaskRegenrate input, @PathVariable Integer taskId) throws Exception {
          SaiResponse apiResponse = null;
   try {
       
        java.util.Date currentDate = Calendar.getInstance().getTime();
        //////////////Existing Task
        Optional<SalesTaskDetails> originalTask = ssTaskDetRepo.findByTaskId(taskId);
        SalesTaskDetails originalTask1 = originalTask.isPresent() ? originalTask.get() : null;

        if(input.getTaskStatus().equalsIgnoreCase("CLOSED") && input.getReason().equalsIgnoreCase("BOOKED"))
        {
           //To close old Task      
        originalTask1.setTaskStatus("CLOSED");
        originalTask1.setCallDuDt(currentDate);
        originalTask1.setReason(input.getReason());
        originalTask1.setRemark(input.getRemark());
        originalTask1.setContacted(input.getContacted());
        originalTask1.setConvertSOYN("Y");
        
        
        ssTaskDetRepo.save(originalTask1);
        
        }
        else
        {
        SalesTaskDetails newTask = new SalesTaskDetails();

        SalesTaskDetails sd1 = null;
        BeanUtils.copyProperties(originalTask, newTask, "taskId");

        newTask.setCustAcctNo(originalTask1.getCustAcctNo());
        newTask.setCustDetails(originalTask1.getCustDetails());
        newTask.setCustName(originalTask1.getCustName());
        newTask.setContactNo(originalTask1.getContactNo());
        newTask.setContactNo1(originalTask1.getContactNo1());
        newTask.setTlName(originalTask1.getTlName());
        newTask.setBaseamount(originalTask1.getBaseamount());
        newTask.setDiscamount(originalTask1.getDiscamount());
        newTask.setTaxableamt(originalTask1.getTaxableamt());
        newTask.setTotalamt(originalTask1.getTotalamt());
        newTask.setTotaltax(originalTask1.getTotaltax());
        newTask.setColorCode(originalTask1.getColorCode());
        newTask.setColorDesc(originalTask1.getColorDesc());
        newTask.setFinanceyn(originalTask1.getFinanceyn());
        newTask.setExchangeyn(originalTask1.getExchangeyn());
        newTask.setSalesExe(originalTask1.getSalesExe());
        newTask.setModel(originalTask1.getModel());
        newTask.setVarDesc(originalTask1.getVarDesc());
        newTask.setVariant(originalTask1.getVariant());

        newTask.setPrfOrderNo(originalTask1.getPrfOrderNo());
        newTask.setPrfOrdereddate(originalTask1.getPrfOrdereddate());
        newTask.setLocId(originalTask1.getLocId());
        newTask.setOrgId(originalTask1.getOrgId());
        newTask.setTaskStatus("NEW");
        newTask.setTaskAssigneeId(originalTask1.getTaskAssigneeId());
        newTask.setAssignee(originalTask1.getAssignee());
        newTask.setCallDuDt(input.getNextflwupDt());
        
    
        newTask.setCreatedBy(1);
        newTask.setCreationDate(currentDate);
        sd1 = ssTaskDetRepo.save(newTask);
        
           //To close old Task      
        originalTask1.setTaskStatus("CLOSED");
        originalTask1.setCallDuDt(input.getNextflwupDt());
        originalTask1.setReason(input.getReason());
        originalTask1.setRemark(input.getRemark());
        originalTask1.setContacted(input.getContacted());
        originalTask1.setNextflwupDt(input.getNextflwupDt());
        ssTaskDetRepo.save(originalTask1);
        }
        ////////////////////////////////Close Appoinment/////////////////////////
     apiResponse = new SaiResponse(200, "Task Updated Successfully", originalTask1.getTaskId());

         } catch (Exception e) {
            e.printStackTrace();
            apiResponse = new SaiResponse(400, "Error while task updation", e.getMessage());
        }
        return apiResponse;
    }

}
