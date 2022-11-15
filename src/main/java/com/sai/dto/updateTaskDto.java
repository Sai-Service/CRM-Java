/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class updateTaskDto {

    @JsonProperty("frmExe")
    private Assignee frmExe;
    @JsonProperty("toExe")
    private Assignee toExe;
    private String serType;
    private String callDuDt;
    private Integer locId;

    public String getCallDuDt() {
        return callDuDt;
    }

    public void setCallDuDt(String callDuDt) {
        this.callDuDt = callDuDt;
    }

    public Integer getLocId() {
        return locId;
    }

    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    public Assignee getFrmExe() {
        return frmExe;
    }

    public void setFrmExe(Assignee frmExe) {
        this.frmExe = frmExe;
    }

    public Assignee getToExe() {
        return toExe;
    }

    public void setToExe(Assignee toExe) {
        this.toExe = toExe;
    }

    public String getSerType() {
        return serType;
    }

    public void setSerType(String serType) {
        this.serType = serType;
    }

}
