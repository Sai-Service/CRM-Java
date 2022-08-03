package com.sai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;


public class RegenerateCallDuDt {
    
    @JsonProperty("callDuDt")
    private Date callDuDt;

    public Date getCallDuDt() {
        return callDuDt;
    }

    public void setCallDuDt(Date callDuDt) {
        this.callDuDt = callDuDt;
    }
    
}
