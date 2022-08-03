package com.sai.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ticketNo",
    "empName",
    "locId"
})
public class TicketNo {

    @JsonProperty("ticketNo")
    private String ticketNo;
    @JsonProperty("empName")
    private String empName;
    @JsonProperty("locId")
    private long locId;

    @JsonProperty("ticketNo")
    public String getTicketNo() {
        return ticketNo;
    }

    @JsonProperty("ticketNo")
    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    @JsonProperty("empName")
    public String getEmpName() {
        return empName;
    }

    @JsonProperty("empName")
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @JsonProperty("locId")
    public long getLocId() {
        return locId;
    }

    @JsonProperty("locId")
    public void setLocId(long locId) {
        this.locId = locId;
    }

}
