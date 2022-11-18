/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dto;

/**
 *
 * @author Lenovo
 */
public class cmnStString {
     private  String ticketNo;
      private  String username;

    public String getTicketNo() {
        return ticketNo;
    }

    public cmnStString() {
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public cmnStString(String ticketNo, String username) {
        this.ticketNo = ticketNo;
        this.username = username;
    }
      
      
      
}
