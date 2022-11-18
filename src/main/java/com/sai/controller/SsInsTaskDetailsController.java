/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.SaiResponse;
import com.sai.dto.cmnStString;
import com.sai.dao.SsCustomerDao;
import com.sai.dao.SsInsTaskDetailsDao;
import com.sai.dao.SsInsTaskHistoryDao;
import com.sai.dao.UserLoginDao;
import com.sai.dto.SSInsTaskContactYN;
import com.sai.dto.cmnStString;
import com.sai.model.UpdateAssignee;
import com.sai.model.UserLogin;
import java.io.Serializable;
import com.sai.model.insurance.SsInsTaskDetails;
import com.sai.model.insurance.SsInsTaskHistory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
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
 * @author Swaroopcomp
 */
@RestController
@RequestMapping("/ins")
public class SsInsTaskDetailsController implements Serializable {

    @Autowired
    SsInsTaskDetailsDao insTaskDetailsDao;

    @Autowired
    private UserLoginDao userRepository;

    @Autowired
    private SsInsTaskHistoryDao insTaskHistoryDao;

    @Autowired
    private SsCustomerDao customerDao;

    @GetMapping("/task")
    public List<SsInsTaskDetails> getInsTasks() {
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
        //   return (List<SsInsTaskDetails>) insTaskDetailsDao.findAll();
        int locId = new Long(user.getLocId()).intValue();
        if (user.getRole().equals("USER")) {
            return (List<SsInsTaskDetails>) insTaskDetailsDao.findByLocIdAndAssignIdAndCallDueDt(new Integer(locId), user.getTicketNo(), currentDate);
        } else {
            return (List<SsInsTaskDetails>) insTaskDetailsDao.findByLocIdAndCallDueDt(new Integer(locId), currentDate);
        }

    }
    
    
       @GetMapping("/taskNew")
    public List<Map> getInsTasksNew(@RequestParam String inputDate) throws Exception {
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
         Date frmDt1 = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);

        //   return (List<SsInsTaskDetails>) insTaskDetailsDao.findAll();
        int locId = new Long(user.getLocId()).intValue();
        if (user.getRole().equals("USER")) {
            return (List<Map>) insTaskDetailsDao.getTaskData(new Integer(locId), user.getTicketNo(), frmDt1);
        } else {
            return (List<Map>) insTaskDetailsDao.getTaskDataLocWise(new Integer(locId), currentDate);
        }

    }

    @GetMapping("/taskDateWise")
    public List<SsInsTaskDetails> getInsTasksDateWise(@RequestParam String fromDate) throws Exception {
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
          Date frmDt1 = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
          
        UserLogin user = userRepository.findByUsername(username);
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();
        //   return (List<SsInsTaskDetails>) insTaskDetailsDao.findAll();
        int locId = new Long(user.getLocId()).intValue();
        if (user.getRole().equals("USER")) {
            return (List<SsInsTaskDetails>) insTaskDetailsDao.findByLocIdAndAssignIdAndCallDueDt(new Integer(locId), user.getTicketNo(), frmDt1);
        } else {
            return (List<SsInsTaskDetails>) insTaskDetailsDao.findByLocIdAndCallDueDt(new Integer(locId), frmDt1);
        }

    }

    @PostMapping("/task")
    SaiResponse addInsTask(@RequestBody SsInsTaskDetails insTask) {
        SaiResponse apiResponse;
        try {
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

            String eventStatus = insTask.getEventStatus();
            if (eventStatus.equalsIgnoreCase("NEW")) {
                insTask.setEventStatus("INPROGRESS");
            }
            int userId = new Long(user.getUserId()).intValue();
            insTask.setCreatedBy(userId);
            insTask.setLstUpdBy(userId);
            insTask.setCreationDt(currentDate);
            insTask.setLstUpdDt(currentDate);
//            insTask.setContactYN(insTask);
            SsInsTaskDetails insTaskDetails = insTaskDetailsDao.save(insTask);

            SsInsTaskHistory insTaskHistory = new SsInsTaskHistory("Y", currentDate, insTask.getDisposition(), insTask.getRemark(), insTask.getCallDueDt(), insTaskDetails);
            insTaskHistory.setCreatedBy(userId);
            insTaskHistory.setLstUpdatedBy(userId);
            insTaskHistory.setCreationDate(currentDate);
            insTaskHistory.setLstUpdatedDate(currentDate);
            insTaskHistoryDao.save(insTaskHistory);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Error while Inserting Insurance Policy details", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.PUT, produces = {"application/JSON"})
    SaiResponse updateInsTask(@RequestBody SsInsTaskDetails insTask, @PathVariable Integer id) {
        SaiResponse apiResponse;
        try {
            SsInsTaskDetails taskDetail = insTaskDetailsDao.findByTaskId(id);
            if (taskDetail != null) {

                //{"taskId":5,"callDueDt":"2020-07-31","custStatus":"HOT","remark":"TEST","disposition":"TEST","apptYN":"Y",
                //"apptAddress":"PUNE","apptDate":"2020-07-25"}
                taskDetail.setCallDueDt(insTask.getCallDueDt());
                taskDetail.setCustStatus(insTask.getCustStatus());
                taskDetail.setRemark(insTask.getRemark());
                taskDetail.setDisposition(insTask.getDisposition());
                taskDetail.setApptYN(insTask.getApptYN());
                taskDetail.setApptAddress(insTask.getApptAddress());
                taskDetail.setApptDate(insTask.getApptDate());
                //    SsVehicleMaster vehicle = taskDetail.getVehicleNo();
                //   taskDetail.setVehicleNo(insTask.getVehicleNo());

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

                taskDetail.setEventStatus("INPROGRESS");

                int userId = new Long(user.getUserId()).intValue();

                taskDetail.setLstUpdBy(userId);
                taskDetail.setLstUpdDt(currentDate);
                SsInsTaskDetails insTaskDetails = insTaskDetailsDao.save(taskDetail);

                SsInsTaskHistory insTaskHistory = new SsInsTaskHistory("Y", currentDate, insTask.getDisposition(), insTask.getRemark(), insTask.getCallDueDt(), insTaskDetails);
                insTaskHistory.setCreatedBy(userId);
                insTaskHistory.setLstUpdatedBy(userId);
                insTaskHistory.setCreationDate(currentDate);
                insTaskHistory.setLstUpdatedDate(currentDate);
                insTaskHistoryDao.save(insTaskHistory);

                apiResponse = new SaiResponse(200, "OK", insTaskDetails);
            } else {
                apiResponse = new SaiResponse(400, " Insurance Policy Task not found", null);

            }
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Error while Inserting Insurance Policy details", e.getMessage());
            e.printStackTrace();
        }

        return apiResponse;
    }

    @DeleteMapping("/task/{id}")
    SaiResponse deleteInsTask(@PathVariable Integer id) {
        SaiResponse apiResponse;
        try {
            SsInsTaskDetails insTask = insTaskDetailsDao.findByTaskId(id);

            if (insTask != null) {
                insTaskDetailsDao.delete(insTask);
            }
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Not Deleted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    @GetMapping("/task/{id}")
    public SSInsTaskContactYN getInsTaskDetailsById(@PathVariable Integer id) {
        SsInsTaskDetails taskDetails = insTaskDetailsDao.findByTaskId(id);
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();
        List<SsInsTaskHistory> historyList = insTaskHistoryDao.findByTaskIdAndContactedDate(id, currentDate);
        SSInsTaskContactYN tskconYN = new SSInsTaskContactYN();
        BeanUtils.copyProperties(taskDetails, tskconYN);
        BeanUtils.copyProperties(historyList, tskconYN);
        return tskconYN;
    }

    @GetMapping("/taskbyloc/{locId}")
    public List<SsInsTaskDetails> getInsTaskDetailsByLocId(@PathVariable Integer locId) {
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();
        List<SsInsTaskDetails> taskDetails = insTaskDetailsDao.findByLocIdAndCallDueDt(locId, currentDate);
        return taskDetails;
    }

    //////////////TO UPDATE THE ASSIGNEE ID AUTOMATICALLY TO ALL THE TASK-///////
    @RequestMapping(value = "/update/autoassingee/{login_name}", method = RequestMethod.GET, produces = {"application/JSON"})
    public List<UserLogin> assignInsTaskToUsers(@PathVariable String login_name) {
        //  return taskGenImpl.getUserList(login_name);

        //[{"login_name":"M28795","loc_access":"124","username":"M12345","LOCNAME":"11MU.201",emp_name:JyotiT}
        try {
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

            List<UserLogin> userDetail = userRepository.findByReportedTo(login_name);
            // List<Map> userDetail = insTaskDetailsDao.getUserList(login_name);
            int totalusercnt = userDetail.size();
            List<UpdateAssignee> toAssignee = new ArrayList<>();

            int perUsertaskcount = 0;
            long location = 0;
            int incrementalCnt = 0;
            Long toCount = 0L;
            Long fromCount = 0L;
            List<SsInsTaskDetails> taskList = null;

            Map<Long, Integer> locUserMap = new HashMap<>();
            for (UserLogin map1 : userDetail) {
                if (locUserMap.containsKey(map1.getLocId())) {
                    int val = locUserMap.get(map1.getLocId());
                    locUserMap.put(map1.getLocId(), val + 1);
                } else {
                    locUserMap.put(map1.getLocId(), 1);
                }

            }
            System.out.println("==userloc map==" + locUserMap.toString());
            int totalusercntfrLoc = 0;
            int totalTaskCount = 0;
            int remainingTaskCount = 0;
            int equalTaskPerUserCount = 0;
            for (UserLogin map1 : userDetail) {
                if (!(location == (map1.getLocId()))) {

                    taskList = insTaskDetailsDao.findByLocIdAndCallDueDt(new Long(map1.getLocId()).intValue(), currentDate);
                    //     Map userCount = taskGenImpl.getUsercountList(login_name);//newly added
                    //  BigInteger userCount = (BigInteger) insTaskDetailsDao.getUsercount(login_name);
                    totalTaskCount = taskList.size();
                    totalusercntfrLoc = locUserMap.get(map1.getLocId());
                    equalTaskPerUserCount = totalTaskCount / totalusercntfrLoc;
                    remainingTaskCount = totalTaskCount % totalusercntfrLoc;
                    incrementalCnt = 0;
                }
                fromCount = taskList.get(incrementalCnt).getTaskId().longValue();
                int nextCount = 0;
                if (remainingTaskCount > 0) {
                    nextCount = incrementalCnt + equalTaskPerUserCount + 1;
                    remainingTaskCount = remainingTaskCount - 1;
                } else {
                    nextCount = incrementalCnt + equalTaskPerUserCount;
                }
                toCount = taskList.get(nextCount - 1).getTaskId().longValue();
                UpdateAssignee assineeDetails = new UpdateAssignee((String) map1.getTicketNo(), (String) map1.getTicketNo(), 0, fromCount, toCount);
                toAssignee.add(assineeDetails);
                incrementalCnt = nextCount;
                location = map1.getLocId();
            }

            for (UpdateAssignee detail : toAssignee) {
                int start = new Long(detail.getFromTaskId()).intValue();
                int end = new Long(detail.getToTaskId()).intValue();
                insTaskDetailsDao.updateAssignId(detail.getAssigneeId(), start, end);
            }
            return userDetail;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /////////////New Method to autoassign all by jyoti t 15-11-2022
    @RequestMapping(value = "/LocAccessLoginwise", method = RequestMethod.GET, produces = {"application/JSON"})
    public List<cmnStString> updateTaskAssignee(@RequestParam String login_name, @RequestParam Integer locId) throws Exception {
        List<cmnStString> userDetail = null;
        try {
            //  userDetail = taskGenImpl.getUserList(login_name, locId);
           userDetail = userRepository.totalLogins(login_name, locId);

            List<UpdateAssignee> toAssignee = new ArrayList<>();

            Calendar calendar = Calendar.getInstance();
            java.util.Date currentDate = calendar.getTime();
            int perUsertaskcount = 0;

            List<SsInsTaskDetails> taskList = null;
            int leftTaskCount = 0;
            taskList = insTaskDetailsDao.findByLocIdAndCallDueDt(locId, currentDate);
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

            List<SsInsTaskDetails> orgList = taskList;

            for (cmnStString map1 : userDetail) {

                for (int i = 0; i < perUsertaskcount; i++) {
                    insTaskDetailsDao.UpdateAssigneeTaskIdwise((String) map1.getTicketNo(), ((SsInsTaskDetails) taskList.get(i)).getTaskId());
                    System.out.println("i Value" + i);//locId ,ticketNo,username,dept

                    assignTaskCnt++;
                }
                System.out.println("assignTaskCnt Value" + assignTaskCnt);
            }

            int assignPendingTaskCnt = assignTaskCnt;

            while (assignPendingTaskCnt < taskList.size()) {
                for (cmnStString map1 : userDetail) {

                    if (assignPendingTaskCnt >= taskList.size()) {
                        break;
                    }
                    //    taskGenImpl.UpdateAssigneeTaskIdwise((String) map1.get("emp_name"), (String) map1.get("username"), (long) orgList.get(assignPendingTaskCnt));
                    insTaskDetailsDao.UpdateAssigneeTaskIdwise((String) map1.getTicketNo(), ((SsInsTaskDetails) orgList.get(assignPendingTaskCnt)).getTaskId());

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

    @RequestMapping(value = "/update/assingee", method = RequestMethod.GET, produces = {"application/JSON"})
    public SaiResponse assignInsTaskToUsersManually(@RequestParam Map<String, Object> map) {
        try {
            Integer fromTask = null;
            Integer toTask = null;
            String assigneeId = null;
            Integer locId = null;

            for (String searchKey : map.keySet()) {
                if (searchKey.equals("fromTask")) {
                fromTask = Integer.parseInt((String) map.get("fromTask"));
                    toTask = Integer.parseInt((String) map.get("toTask"));
                    assigneeId = (String) map.get("assigneeId");
                    locId = Integer.parseInt((String) map.get("locId"));
                }
            }
            insTaskDetailsDao.updateAssignIdwithLoc(assigneeId, fromTask, toTask, locId);
//insTaskDetailsDao.updateAssignIdwithLoc(ua.getAssigneeId() ,new Long(ua.getFromTaskId()).intValue(), new Long(ua.getToTaskId()).intValue(), ua.getLocId());
        } catch (Exception e) {
            e.printStackTrace();
            return new SaiResponse(400, "Error while updating Assignee ", null);
        }
        return new SaiResponse(200, "Assignee updated successfully", null);
    }
}
