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
public class ExecutiveName {
    
    private long execId;
    private  String ticketNo;
    private String empName ;
    private long locId;

    public ExecutiveName(long execId, String ticketNo, String empName,long locId) {
        this.execId = execId;
        this.ticketNo = ticketNo;
        this.empName = empName;
        this.locId = locId;
    }

    public long getExecId() {
        return execId;
    }

    public void setExecId(long execId) {
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

    public long getLocId() {
        return locId;
    }

    public void setLocId(long locId) {
        this.locId = locId;
    }
    
    
}
