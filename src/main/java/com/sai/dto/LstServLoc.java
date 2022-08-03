
package com.sai.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LstServLoc {

   @JsonProperty("locId")
private Integer locId;
@JsonProperty("locName")
private String locName;

@JsonProperty("locId")
public Integer getLocId() {
return locId;
}

@JsonProperty("locId")
public void setLocId(Integer locId) {
this.locId = locId;
}

@JsonProperty("locName")
public String getLocName() {
return locName;
}

@JsonProperty("locName")
public void setLocName(String locName) {
this.locName = locName;
}

}
