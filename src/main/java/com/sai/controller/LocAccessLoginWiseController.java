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
import com.sai.dao.SalesTaskDetailsDao;
import com.sai.dao.UpdateAssigneeDao;
import com.sai.dao.UserLoginDao;
import com.sai.dto.Assignee;
import com.sai.dto.UpdateAssigneeRequest;
import com.sai.dto.updateTaskDto;
import com.sai.model.SsTaskDetails;
import com.sai.model.UpdateAssignee;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private SalesTaskDetailsDao ssSalesTaskRepo;

    @Autowired
    private UpdateAssigneeDao updateTaskAssignee;

    @Autowired
    private UserLoginDao userRepository;

    @Autowired
    private SSAdministratorDataDao ssAdminData;

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
            Date frmDt1 = new SimpleDateFormat("yyyy-MM-dd").parse(updatedAssignee.getCallDuDt());
            taskGenImpl.updateAssignIdwithLoc(assignee.getEmpName(), assignee.getTicketNo(), updatedAssignee.getMincount(), updatedAssignee.getMaxcount(), assignee.getLocId(), frmDt1);
//         taskGenImpl.UpdateAssignee(assignee.getEmpName(), assignee.getTicketNo(), updatedAssignee.getMincount(), updatedAssignee.getMaxcount()); 
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Updation not Done", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    ////UPDATE THE ASSIGNEE ID AND ASSIGNEE NAME--Type & assignee Wise
    @RequestMapping(value = "/UpdateAssigneeTypeWise", method = RequestMethod.PUT, produces = {"application/JSON"})
    SaiResponse UpdateAssigneeTypeWise(@RequestBody updateTaskDto updatedAssignee) {
        SaiResponse apiResponse;
        try {
            Assignee frmAssignee = updatedAssignee.getFrmExe();
            Assignee toAssignee = updatedAssignee.getToExe();
            Date frmDt1 = new SimpleDateFormat("yyyy-MM-dd").parse(updatedAssignee.getCallDuDt());

            List<SsTaskDetails> taskList = taskCreation.findByAssigneeIdAndLocIdAndLastServcTypeAndTaskStatusAndCallDuDt(frmAssignee.getTicketNo(), updatedAssignee.getLocId(), updatedAssignee.getSerType(), "NEW", frmDt1);  //findByAssigneeIdAndLocIdAndLastServcTypeAndTaskStatus
            //      List<SsTaskDetails> taskList = taskCreation.findByLocIdAndNextServcTypeAndTaskStatus(updatedAssignee.getLocId(), updatedAssignee.getSerType(), "NEW");  //findByAssigneeIdAndLocIdAndLastServcTypeAndTaskStatus

            System.out.println("TaskList+++" + taskList.size());

            for (SsTaskDetails map1 : taskList) {
                taskGenImpl.UpdateAssigneeTaskIdwise(toAssignee.getEmpName(), toAssignee.getTicketNo(), map1.getTaskId());

            }

        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Updation not Done", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    //Update From Assignee To Some Other Assignee
    @RequestMapping(value = "/UpdateTaskFrmAssigneeToOther", method = RequestMethod.PUT, produces = {"application/JSON"})
    SaiResponse UpdateTaskFrmAssigneeToOther(@RequestBody updateTaskDto updatedAssignee) {
        SaiResponse apiResponse;
        try {
            Assignee frmAssignee = updatedAssignee.getFrmExe();
            Assignee toAssignee = updatedAssignee.getToExe();
            Date frmDt1 = new SimpleDateFormat("yyyy-MM-dd").parse(updatedAssignee.getCallDuDt());

            List<SsTaskDetails> taskList = taskCreation.findByAssigneeIdAndLocIdAndTaskStatusAndCallDuDt(frmAssignee.getTicketNo(), updatedAssignee.getLocId(), "NEW", frmDt1);  //findByAssigneeIdAndLocIdAndLastServcTypeAndTaskStatus

            for (SsTaskDetails map1 : taskList) {
                taskGenImpl.UpdateAssigneeTaskIdwise(toAssignee.getEmpName(), toAssignee.getTicketNo(), map1.getTaskId());

            }

        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Updation not Done", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    ////UPDATE THE ASSIGNEE ID AND ASSIGNEE NAME///Proforma
    @RequestMapping(value = "/UpdateAssigneeIdProforma", method = RequestMethod.PUT, produces = {"application/JSON"})
    SaiResponse UpdateAssigneeProforma(@RequestBody UpdateAssigneeRequest updatedAssignee) {
        SaiResponse apiResponse;
        try {
            Assignee assignee = updatedAssignee.getAssignee();
            //  public void UpdateAssignee(String assignee ,String ASSIGNEE_ID,long FROMTASK_ID,long TOTASK_ID );  
            ssSalesTaskRepo.updateAssignIdwithLocPR(assignee.getEmpName(), assignee.getTicketNo(), updatedAssignee.getMincount(), updatedAssignee.getMaxcount(), assignee.getLocId());
//         taskGenImpl.UpdateAssignee(assignee.getEmpName(), assignee.getTicketNo(), updatedAssignee.getMincount(), updatedAssignee.getMaxcount()); 
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Updation not Done", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    /////////////////////////////////////////////////////////////////////////
    ///NEW---08-SEP-2022
    //////////////TO UPDATE THE ASSIGNEE ID AUTOMATICALLY TO ALL THE TASK-///////
    @RequestMapping(value = "/LocAccessLoginwise", method = RequestMethod.GET, produces = {"application/JSON"})
    public List<Map> updateTaskAssignee(@RequestParam String login_name, @RequestParam Integer locId, @RequestParam String inputDate) throws Exception {
        List<Map> userDetail = null;
        try {
            userDetail = taskGenImpl.getUserList(login_name, locId);
            List<UpdateAssignee> toAssignee = new ArrayList<>();
            Date frmDt1 = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);
            int perUsertaskcount = 0;
            Integer location = 0;
            int incrementalCnt = 0;
            Long toCount = 0L;
            Long fromCount = 0L;
            List<Object> taskList = null;
            int leftTaskCount = 0;
            taskList = taskCreation.getTaskId(frmDt1,locId);//10//Total Number of Task
            Integer userCount = userDetail.size();//Total No. of Users
            int totalTaskCount = taskList.size();
            perUsertaskcount = totalTaskCount / userCount;
            leftTaskCount = totalTaskCount % userCount;
            int leftTaskPerUser = 0;
            if (leftTaskCount >= userCount) {
                leftTaskPerUser = leftTaskCount / userCount;
            } else {
                leftTaskPerUser = leftTaskCount;
            }

            int assignTaskCnt = 0;

            List<Object> orgList = taskList;
            for (Map map1 : userDetail) {

                for (int i = 0; i < perUsertaskcount; i++) {
                    taskGenImpl.UpdateAssigneeTaskIdwise((String) map1.get("emp_name"), (String) map1.get("username"), (long) taskList.get(assignTaskCnt));
                    System.out.println("i Value" + i);

                    assignTaskCnt++;
                }
                System.out.println("assignTaskCnt Value" + assignTaskCnt);
            }

            int assignPendingTaskCnt = assignTaskCnt;

            while (assignPendingTaskCnt < taskList.size()) {
                for (Map map1 : userDetail) {

                    if (assignPendingTaskCnt >= taskList.size()) {
                        break;
                    }
                    taskGenImpl.UpdateAssigneeTaskIdwise((String) map1.get("emp_name"), (String) map1.get("username"), (long) orgList.get(assignPendingTaskCnt));
                    assignPendingTaskCnt++;
                }

            }
        } catch (Exception e) {
            //    apiResponse = new SaiResponse(400, "Updation not Done", null);
            e.printStackTrace();
            throw e;
        }
        return userDetail;

    }

    ///NEW---08-SEP-2022
    //////////////TO UPDATE THE ASSIGNEE ID AUTOMATICALLY TO ALL THE SALES PROFORMA TASK-///////
    @RequestMapping(value = "/LocAccessLoginwise1", method = RequestMethod.GET, produces = {"application/JSON"})
    public List<Map> getUserListProforma(@RequestParam String login_name, @RequestParam Integer locId) throws Exception {
        List<Map> userDetail = null;
        try {
            userDetail = taskGenImpl.getUserListProforma(login_name, locId);
            List<UpdateAssignee> toAssignee = new ArrayList<>();

            int perUsertaskcount = 0;
            Integer location = 0;
            int incrementalCnt = 0;
            Long toCount = 0L;
            Long fromCount = 0L;
            List<Object> taskList = null;
            int leftTaskCount = 0;
            taskList = ssSalesTaskRepo.getTaskProforma(locId);//10//Total Number of Task
            Integer userCount = userDetail.size();//Total No. of Users
            int totalTaskCount = taskList.size();
            perUsertaskcount = totalTaskCount / userCount;
            leftTaskCount = totalTaskCount % userCount;
            int leftTaskPerUser = 0;
            if (leftTaskCount >= userCount) {
                leftTaskPerUser = leftTaskCount / userCount;
            } else {
                leftTaskPerUser = leftTaskCount;
            }

            int assignTaskCnt = 0;

            List<Object> orgList = taskList;
            for (Map map1 : userDetail) {

                for (int i = 0; i < perUsertaskcount; i++) {
                    ssSalesTaskRepo.UpdateAssigneeTaskIdwise((String) map1.get("emp_name"), (String) map1.get("username"), (long) taskList.get(assignTaskCnt));
                    System.out.println("i Value" + i);

                    assignTaskCnt++;
                }
                System.out.println("assignTaskCnt Value" + assignTaskCnt);
            }

            int assignPendingTaskCnt = assignTaskCnt;

            while (assignPendingTaskCnt < taskList.size()) {
                for (Map map1 : userDetail) {

                    if (assignPendingTaskCnt >= taskList.size()) {
                        break;
                    }
                    ssSalesTaskRepo.UpdateAssigneeTaskIdwise((String) map1.get("emp_name"), (String) map1.get("username"), (long) orgList.get(assignPendingTaskCnt));
                    assignPendingTaskCnt++;
                }

            }
        } catch (Exception e) {
            //    apiResponse = new SaiResponse(400, "Updation not Done", null);
            e.printStackTrace();
            throw e;
        }
        return userDetail;

    }
}
