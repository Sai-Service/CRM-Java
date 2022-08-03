/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

/**
 *
 * @author Test
 */
public class UpdateAssignee {
     private String ticketNo;
     private String empName;
     private long taskId ;
     private long mincount;
     private long maxcount;

    public UpdateAssignee(String ticketNo, String empName, long taskId, long mincount, long maxcount) {
        this.ticketNo = ticketNo;
        this.empName = empName;
        this.taskId = taskId;
        this.mincount = mincount;
        this.maxcount = maxcount;
    }

    
    public String getAssigneeId() {
        return ticketNo;
    }

    public void setAssigneeId(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getAssignee() {
        return empName;
    }

    public void setAssignee(String empName) {
        this.empName = empName;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public long getFromTaskId() {
        return mincount;
    }

    public void setFromTaskId(long mincount) {
        this.mincount = mincount;
    }

    public long getToTaskId() {
        return maxcount;
    }

    public void setToTaskId(long maxcount) {
        this.maxcount = maxcount;
    }

     
     
     
}
