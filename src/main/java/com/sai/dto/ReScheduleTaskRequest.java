package com.sai.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReScheduleTaskRequest {

@JsonProperty("pickAdd")
private String pickAdd;
@JsonProperty("servGroup")
private String servGroup;
@JsonProperty("amount")
private Integer amount;
@JsonProperty("apptDate")
private Date apptDate;
@JsonProperty("apptTimeSlt")
private String apptTimeSlt;
@JsonProperty("pickUp")
private String pickUp;
@JsonProperty("servType")
private String servType;
@JsonProperty("servLoc")
private LstServLoc servLoc;

private String exename;

    private String pickupMms;
    private String pickupTime;

    public String getPickupMms() {
        return pickupMms;
    }

    public void setPickupMms(String pickupMms) {
        this.pickupMms = pickupMms;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getExename() {
        return exename;
    }

    public void setExename(String exename) {
        this.exename = exename;
    }

@JsonProperty("pickAdd")
public String getPickAdd() {
return pickAdd;
}

@JsonProperty("pickAdd")
public void setPickAdd(String pickAdd) {
this.pickAdd = pickAdd;
}

@JsonProperty("servGroup")
public String getServGroup() {
return servGroup;
}

@JsonProperty("servGroup")
public void setServGroup(String servGroup) {
this.servGroup = servGroup;
}

@JsonProperty("amount")
public Integer getAmount() {
return amount;
}

@JsonProperty("amount")
public void setAmount(Integer amount) {
this.amount = amount;
}

@JsonProperty("apptDate")
public Date getApptDate() {
return apptDate;
}

@JsonProperty("apptDate")
public void setApptDate(Date apptDate) {
this.apptDate = apptDate;
}

@JsonProperty("apptTimeSlt")
public String getApptTimeSlt() {
return apptTimeSlt;
}

@JsonProperty("apptTimeSlt")
public void setApptTimeSlt(String apptTimeSlt) {
this.apptTimeSlt = apptTimeSlt;
}

@JsonProperty("pickUp")
public String getPickUp() {
return pickUp;
}

@JsonProperty("pickUp")
public void setPickUp(String pickUp) {
this.pickUp = pickUp;
}

@JsonProperty("servType")
public String getServType() {
return servType;
}

@JsonProperty("servType")
public void setServType(String servType) {
this.servType = servType;
}

@JsonProperty("servLoc")
public LstServLoc getServLoc() {
return servLoc;
}

@JsonProperty("servLoc")
public void setServLoc(LstServLoc servLoc) {
this.servLoc = servLoc;
}

}