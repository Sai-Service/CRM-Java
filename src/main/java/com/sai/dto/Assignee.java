package com.sai.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "assigneeId",
    "assignee",
    "exicutive"
})
public class Assignee {

    @JsonProperty("assigneeId")
    private String assigneeId;
    @JsonProperty("assignee")
    private String assignee;
    @JsonProperty("exicutive")
    private String exicutive;
    @JsonProperty("locId")
    private long locId;

    @JsonProperty("lstServDt")
    private Date lstServDt;
    @JsonProperty("lstKm")
    private Integer lstKm;
    @JsonProperty("lstServType")
    private String lstServType;
    @JsonProperty("lstServLoc")
    private String lstServLoc;
    @JsonProperty("apptAttDt")
    private Date apptAttDt;

    @JsonProperty("ticketNo")
    private String ticketNo;
    @JsonProperty("empName")
    private String empName;

    @JsonProperty("execId")
    private String execId;

    @JsonProperty("reason")
    private String reason;
    @JsonProperty("servDuDt")
    private Date servDuDt;
    @JsonProperty("delvDt")
    private Date delvDt;
    @JsonProperty("attribute1")
    private String attribute1;

    public String getExecId() {
        return execId;
    }

    public void setExecId(String execId) {
        this.execId = execId;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @JsonProperty("assigneeId")
    public String getAssigneeId() {
        return assigneeId;
    }

    @JsonProperty("assigneeId")
    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    @JsonProperty("assignee")
    public String getAssignee() {
        return assignee;
    }

    @JsonProperty("assignee")
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    @JsonProperty("exicutive")
    public String getExicutive() {
        return exicutive;
    }

    @JsonProperty("exicutive")
    public void setExicutive(String exicutive) {
        this.exicutive = exicutive;
    }

    public long getLocId() {
        return locId;
    }

    public void setLocId(long locId) {
        this.locId = locId;
    }

    public Date getLstServDt() {
        return lstServDt;
    }

    public void setLstServDt(Date lstServDt) {
        this.lstServDt = lstServDt;
    }

    public Integer getLstKm() {
        return lstKm;
    }

    public void setLstKm(Integer lstKm) {
        this.lstKm = lstKm;
    }

    public String getLstServType() {
        return lstServType;
    }

    public void setLstServType(String lstServType) {
        this.lstServType = lstServType; 
    }

    public String getLstServLoc() {
        return lstServLoc;
    }

    public void setLstServLoc(String lstServLoc) {
        this.lstServLoc = lstServLoc;
    }

    public Date getApptAttDt() {
        return apptAttDt;
    }

    public void setApptAttDt(Date apptAttDt) {
        this.apptAttDt = apptAttDt;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getServDuDt() {
        return servDuDt;
    }

    public void setServDuDt(Date servDuDt) {
        this.servDuDt = servDuDt;
    }

    public Date getDelvDt() {
        return delvDt;
    }

    public void setDelvDt(Date delvDt) {
        this.delvDt = delvDt;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    
}
