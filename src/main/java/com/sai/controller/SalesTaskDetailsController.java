/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.dao.SalesTaskDetailsDao;
import com.sai.model.SalesTaskDetails;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        List<SalesTaskDetails> locDet = ssTaskDetRepo.findByLocIdAndTaskStatus(locId,"NEW");
      //  SalesTaskDetails locDet1 = locDet.isPresent() ? locDet.get() : null;
        return locDet;
    }
    
  @GetMapping("/SalesTaskDetails/taskId/{taskId}")
    public SalesTaskDetails getBytaskId(@PathVariable Integer taskId) {
        Optional<SalesTaskDetails> taskDet = ssTaskDetRepo.findByTaskId(taskId);
       SalesTaskDetails taskDet1= taskDet.isPresent() ? taskDet.get() : null;
        return taskDet1;
    }
    
   
         @GetMapping("/SalesTaskDetails/UserSumm/{taskAssigneeId}")
    public List<SalesTaskDetails> getByAssigneeId(@PathVariable String taskAssigneeId) {
        List<SalesTaskDetails> userData = ssTaskDetRepo.findByTaskAssigneeIdAndTaskStatus(taskAssigneeId,"NEW");
      //  SalesTaskDetails locDet1 = locDet.isPresent() ? locDet.get() : null;
        return userData;
    }
    
    
}
