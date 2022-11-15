/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Swaroopcomp
 */
public class UpdateAssigneeRequest {

    @JsonProperty("mincount")
    private long mincount;
    @JsonProperty("maxcount")
    private long maxcount;
    @JsonProperty("assignee")
    private Assignee assignee;
     private String callDuDt;

    public String getCallDuDt() {
        return callDuDt;
    }

    public void setCallDuDt(String callDuDt) {
        this.callDuDt = callDuDt;
    }
    
     
     

    @JsonProperty("mincount")
    public long getMincount() {
        return mincount;
    }

    @JsonProperty("mincount")
    public void setMincount(long mincount) {
        this.mincount = mincount;
    }

    @JsonProperty("maxcount")
    public long getMaxcount() {
        return maxcount;
    }

    @JsonProperty("maxcount")
    public void setMaxcount(long maxcount) {
        this.maxcount = maxcount;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }


}
