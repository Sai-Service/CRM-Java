/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.SaiResponse;
import com.sai.dao.LocAccessLoginwiseDao;
import com.sai.dao.SSAdministratorDataDao;
import com.sai.dao.SSTaskCreationDao;
import com.sai.dao.UpdateAssigneeDao;
import com.sai.dao.UserLoginDao;
import com.sai.dto.Assignee;
import com.sai.dto.UpdateAssigneeRequest;
import com.sai.model.UpdateAssignee;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Test
 */
@RestController
public class LocAccessLoginWiseController {

    @Autowired
    private LocAccessLoginwiseDao taskGenImpl;

    @Autowired
    private SSTaskCreationDao taskCreation;

    @Autowired
    private UpdateAssigneeDao updateTaskAssignee;

    @Autowired
    private UserLoginDao userRepository;

    @Autowired
    private SSAdministratorDataDao ssAdminData;

      //////////////TO UPDATE THE ASSIGNEE ID AUTOMATICALLY TO ALL THE TASK-///////
    @RequestMapping(value = "/LocAccessLoginwise/{login_name}", method = RequestMethod.GET, produces = {"application/JSON"})
    public List<Map> getUserList(@PathVariable String login_name) {
        List<Map> userDetail = taskGenImpl.getUserList(login_name);
        List<UpdateAssignee> toAssignee = new ArrayList<>();

        int perUsertaskcount = 0;
        Integer location = 0;
        int incrementalCnt = 0;
        Long toCount = 0L;
        Long fromCount = 0L;
        List<Object> taskcount = null;
        int leftTaskCount = 0;

        for (Map map1 : userDetail) {
            if (!(location == ((Integer) map1.get("loc_access")))) {
                taskcount = taskCreation.getTaskId((Integer) map1.get("loc_access"));
                BigInteger userCount = (BigInteger) taskGenImpl.getUsercount(login_name);
                int totalTaskCount = taskcount.size();
                int totalusercntfrLoc = userCount.intValue();

                perUsertaskcount = totalTaskCount / totalusercntfrLoc;
                leftTaskCount = totalTaskCount % totalusercntfrLoc;
                incrementalCnt = 0;
                
            }

            fromCount = (Long) taskcount.get(incrementalCnt);
            int nextCount = 0;
            if (leftTaskCount > 0) {
                nextCount = incrementalCnt + perUsertaskcount + 1;
                leftTaskCount = leftTaskCount - 1;
            } else {
                nextCount = incrementalCnt + perUsertaskcount;
            }
            toCount = (Long) taskcount.get(nextCount - 1);
            // toCount = (Long) taskcount.get(incrementalCnt + perUsertaskcount);
            UpdateAssignee assineeDetails = new UpdateAssignee((String) map1.get("username"), (String) map1.get("emp_name"), 0, fromCount, toCount);
            toAssignee.add(assineeDetails);
            //  incrementalCnt = incrementalCnt + perUsertaskcount;
            incrementalCnt = nextCount;
            location = (Integer) map1.get("loc_access");
        }
        for (UpdateAssignee detail : toAssignee) {
     //       taskGenImpl.UpdateAssignee(detail.getAssignee(), detail.getAssigneeId(), detail.getFromTaskId(), detail.getToTaskId());
       taskGenImpl.UpdateAssigneeTaskIdwise(detail.getAssignee(), detail.getAssigneeId(), detail.getFromTaskId());
      
        }
        return userDetail;
    }


    //GET USERCOUNT FROM LIS
    @RequestMapping(value = "/UserCountLoginwise/{login_name}", method = RequestMethod.GET, produces = {"application/JSON"})
    public List<Map> getUsercountList(@PathVariable String login_name) {
        return taskGenImpl.getUsercountList(login_name);
    }

    @RequestMapping(value = "/getUsercountList1/{login_name}", method = RequestMethod.GET, produces = {"application/JSON"})
    public List<Map> getUsercountList1(@PathVariable String login_name) {
        return taskGenImpl.getUserList11(login_name);
    }

    ////UPDATE THE ASSIGNEE ID AND ASSIGNEE NAME
    @RequestMapping(value = "/UpdateAssigneeId", method = RequestMethod.PUT, produces = {"application/JSON"})
    SaiResponse UpdateAssignee(@RequestBody UpdateAssigneeRequest updatedAssignee) {
        SaiResponse apiResponse;
        try {
            Assignee assignee = updatedAssignee.getAssignee();
            //  public void UpdateAssignee(String assignee ,String ASSIGNEE_ID,long FROMTASK_ID,long TOTASK_ID );  
            taskGenImpl.updateAssignIdwithLoc(assignee.getEmpName(), assignee.getTicketNo(), updatedAssignee.getMincount(), updatedAssignee.getMaxcount(), assignee.getLocId());
//         taskGenImpl.UpdateAssignee(assignee.getEmpName(), assignee.getTicketNo(), updatedAssignee.getMincount(), updatedAssignee.getMaxcount()); 
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Updation not Done", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

     @RequestMapping(value = "/taskupdateManually/assingee", method = RequestMethod.GET, produces = {"application/JSON"})
    public SaiResponse assignTaskToUsersManually(@RequestParam Map<String, Object> map) {
        try {
            Integer fromTaskId = 0;
            Integer toTaskId = 0;
            String assignee = null;
            String assigneeId = null;
            Integer locId = 0;
            String model = null;
            String vehicleType = null;

            for (String searchKey : map.keySet()) {   //mincount=167&maxcount=171&assignee=M28796&locId=124
                if (searchKey.equals("mincount")) {
                    fromTaskId = Integer.parseInt((String) map.get("mincount"));
                    toTaskId = Integer.parseInt((String) map.get("maxcount"));
                    assignee = (String) map.get("assignee");
//                      assignee_id = (String) map.get("assignee_id");
                    locId = Integer.parseInt((String) map.get("locId"));
                } else if (searchKey.equals("model")) {
                    model = (String) map.get("model");
                    assignee = (String) map.get("assignee");
                    assigneeId = (String) map.get("assignee_id");
                    locId = Integer.parseInt((String) map.get("locId"));
                } else if (searchKey.equals("vehicleType")) {
                    vehicleType = (String) map.get("vehicleType");
                    assignee = (String) map.get("assignee");
                    assigneeId = (String) map.get("assignee_id");
                    locId = Integer.parseInt((String) map.get("locId"));
                }

            }
            if (fromTaskId > 0 && toTaskId > 0) {
                taskGenImpl.updateAssignIdwithLoc(assignee, assigneeId, fromTaskId, toTaskId, locId);
            }

            if (model != null) {
                taskGenImpl.updateAssigneeByModel(assignee, assignee, model, locId);
            }

            if (vehicleType != null) {
                taskGenImpl.updateAssigneeByModel(assignee, assignee, vehicleType, locId);
            }
//insTaskDetailsDao.updateAssignIdwithLoc(ua.getAssigneeId() ,new Long(ua.getFromTaskId()).intValue(), new Long(ua.getToTaskId()).intValue(), ua.getLocId());
        } catch (Exception e) {
            e.printStackTrace();
            return new SaiResponse(400, "Error while updating Assignee ", null);
        }
        return new SaiResponse(200, "Assignee updated successfully", null);
    }
}
