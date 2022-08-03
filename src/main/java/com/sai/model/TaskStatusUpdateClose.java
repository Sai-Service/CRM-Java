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
public class TaskStatusUpdateClose {
       private long taskId;
       private String taskStatus;

    public TaskStatusUpdateClose(long taskId, String taskStatus) {
        this.taskId = taskId;
        this.taskStatus = taskStatus;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
       
       
}
