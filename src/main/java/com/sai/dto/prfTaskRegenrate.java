/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dto;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class prfTaskRegenrate {

    private Integer taskId;
    private Date callDuDt;
    private String contacted;
    private String reason;
    private String remark;
    private Date nextflwupDt;
    private String taskStatus;

    public prfTaskRegenrate() {
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
    
    

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Date getCallDuDt() {
        return callDuDt;
    }

    public void setCallDuDt(Date callDuDt) {
        this.callDuDt = callDuDt;
    }

    public String getContacted() {
        return contacted;
    }

    public void setContacted(String contacted) {
        this.contacted = contacted;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getNextflwupDt() {
        return nextflwupDt;
    }

    public void setNextflwupDt(Date nextflwupDt) {
        this.nextflwupDt = nextflwupDt;
    }

}
