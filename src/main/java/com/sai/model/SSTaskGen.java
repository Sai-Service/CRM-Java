/*
 * To change this license header; choose License Headers in Project Properties.
 * To change this template file; choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.model;

import java.math.BigInteger;
import java.sql.Date;

/**
 *
 * @author Test
 */

public class SSTaskGen{
    private String task_id;
         private String TASK_TYPE;
         private String STATUS;
        private String apptmt_id;
         private Date CALL_DUE_DATE;
        private Integer cust_id ;
        private String cust_name;
        private String  cust_address1;
        private String contact_person;
        private String cust_type;
        private BigInteger contact_no1;
       private String contact_no2;
        private String  email_id;
        
        private String  veh_no;
        private String chassis_no;
        private String engine_no;
        private String model;
         private Date Date_of_purchase;
        private String Dealer_code;
        private String AMC;
        private String sales_exec_name;
        private Integer loc_id;
        private Integer org_id;
        private String REFERENCE_NO;
        private String servc_grp;
        private Integer item_id;
        
        private String contacted;
        private String reason;
        private String remarks;
        private String task_reason;
        private Date last_servc_dt;///changed type by jyoti t
       //private String service_type;
        private String last_servc_type;
        private String service_loc;
        private Integer last_km;
        private Date next_servc_dt;//changed type by jyoti t
        private String next_servc_type;
        
        private Date creation_date;
        private String created_by;
        private Date last_update_date;
        private String last_updated_by;
        private String attribute1;
        private String attribute2;
        private String attribute3;
        private String attribute4;
        private String attribute5;
        private Date SERVICE_DUE_DT;
        private Date DELIVERY_DATE;
        private Integer gatepassId;
        
    public SSTaskGen(){}

    public SSTaskGen(String task_id, String TASK_TYPE, String STATUS, String apptmt_id, Date CALL_DUE_DATE, Integer cust_id, String cust_name, String cust_address1, String contact_person, String cust_type, BigInteger contact_no1, String contact_no2, String email_id, String veh_no, String chassis_no, String engine_no, String model, Date Date_of_purchase, String Dealer_code, String AMC, String sales_exec_name, Integer loc_id, Integer org_id, String REFERENCE_NO, String servc_grp, Integer item_id, String contacted, String reason, String remarks, String task_reason, Date last_servc_dt, String last_servc_type, String service_loc, Integer last_km, Date next_servc_dt, String next_servc_type, Date creation_date, String created_by, Date last_update_date, String last_updated_by, String attribute1, String attribute2, String attribute3, String attribute4, String attribute5, Date SERVICE_DUE_DT, Date DELIVERY_DATE, Integer gatepassId) {
        this.task_id = task_id;
        this.TASK_TYPE = TASK_TYPE;
        this.STATUS = STATUS;
        this.apptmt_id = apptmt_id;
        this.CALL_DUE_DATE = CALL_DUE_DATE;
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.cust_address1 = cust_address1;
        this.contact_person = contact_person;
        this.cust_type = cust_type;
        this.contact_no1 = contact_no1;
        this.contact_no2 = contact_no2;
        this.email_id = email_id;
        this.veh_no = veh_no;
        this.chassis_no = chassis_no;
        this.engine_no = engine_no;
        this.model = model;
        this.Date_of_purchase = Date_of_purchase;
        this.Dealer_code = Dealer_code;
        this.AMC = AMC;
        this.sales_exec_name = sales_exec_name;
        this.loc_id = loc_id;
        this.org_id = org_id;
        this.REFERENCE_NO = REFERENCE_NO;
        this.servc_grp = servc_grp;
        this.item_id = item_id;
        this.contacted = contacted;
        this.reason = reason;
        this.remarks = remarks;
        this.task_reason = task_reason;
        this.last_servc_dt = last_servc_dt;
        this.last_servc_type = last_servc_type;
        this.service_loc = service_loc;
        this.last_km = last_km;
        this.next_servc_dt = next_servc_dt;
        this.next_servc_type = next_servc_type;
        this.creation_date = creation_date;
        this.created_by = created_by;
        this.last_update_date = last_update_date;
        this.last_updated_by = last_updated_by;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
        this.SERVICE_DUE_DT = SERVICE_DUE_DT;
        this.DELIVERY_DATE = DELIVERY_DATE;
        this.gatepassId = gatepassId;
    }

    public SSTaskGen(String TASK_TYPE, String STATUS, Date CALL_DUE_DATE, Integer cust_id, String cust_name, String cust_address1, String contact_person, String cust_type, BigInteger contact_no1, String contact_no2, String email_id, String chassis_no, String engine_no, String model, Date Date_of_purchase, String Dealer_code, String AMC, String sales_exec_name, Integer loc_id, Integer org_id, String REFERENCE_NO, Date next_servc_dt, String next_servc_type, Date creation_date, String created_by, Date last_update_date, String last_updated_by, String attribute1, Date SERVICE_DUE_DT, Date DELIVERY_DATE, Integer gatepassId) {
        this.TASK_TYPE = TASK_TYPE;
        this.STATUS = STATUS;
        this.CALL_DUE_DATE = CALL_DUE_DATE;
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.cust_address1 = cust_address1;
        this.contact_person = contact_person;
        this.cust_type = cust_type;
        this.contact_no1 = contact_no1;
        this.contact_no2 = contact_no2;
        this.email_id = email_id;
        this.chassis_no = chassis_no;
        this.engine_no = engine_no;
        this.model = model;
        this.Date_of_purchase = Date_of_purchase;
        this.Dealer_code = Dealer_code;
        this.AMC = AMC;
        this.sales_exec_name = sales_exec_name;
        this.loc_id = loc_id;
        this.org_id = org_id;
        this.REFERENCE_NO = REFERENCE_NO;
        this.next_servc_dt = next_servc_dt;
        this.next_servc_type = next_servc_type;
        this.creation_date = creation_date;
        this.created_by = created_by;
        this.last_update_date = last_update_date;
        this.last_updated_by = last_updated_by;
        this.attribute1 = attribute1;
        this.SERVICE_DUE_DT = SERVICE_DUE_DT;
        this.DELIVERY_DATE = DELIVERY_DATE;
        this.gatepassId = gatepassId;
    }

    
    
    
    
    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getTASK_TYPE() {
        return TASK_TYPE;
    }

    public void setTASK_TYPE(String TASK_TYPE) {
        this.TASK_TYPE = TASK_TYPE;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getApptmt_id() {
        return apptmt_id;
    }

    public void setApptmt_id(String apptmt_id) {
        this.apptmt_id = apptmt_id;
    }

    public Date getCALL_DUE_DATE() {
        return CALL_DUE_DATE;
    }

    public void setCALL_DUE_DATE(Date CALL_DUE_DATE) {
        this.CALL_DUE_DATE = CALL_DUE_DATE;
    }

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_address1() {
        return cust_address1;
    }

    public void setCust_address1(String cust_address1) {
        this.cust_address1 = cust_address1;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getCust_type() {
        return cust_type;
    }

    public void setCust_type(String cust_type) {
        this.cust_type = cust_type;
    }

    public BigInteger getContact_no1() {
        return contact_no1;
    }

    public void setContact_no1(BigInteger contact_no1) {
        this.contact_no1 = contact_no1;
    }

    public String getContact_no2() {
        return contact_no2;
    }

    public void setContact_no2(String contact_no2) {
        this.contact_no2 = contact_no2;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getVeh_no() {
        return veh_no;
    }

    public void setVeh_no(String veh_no) {
        this.veh_no = veh_no;
    }

    public String getChassis_no() {
        return chassis_no;
    }

    public void setChassis_no(String chassis_no) {
        this.chassis_no = chassis_no;
    }

    public String getEngine_no() {
        return engine_no;
    }

    public void setEngine_no(String engine_no) {
        this.engine_no = engine_no;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDate_of_purchase() {
        return Date_of_purchase;
    }

    public void setDate_of_purchase(Date Date_of_purchase) {
        this.Date_of_purchase = Date_of_purchase;
    }

    public String getDealer_code() {
        return Dealer_code;
    }

    public void setDealer_code(String Dealer_code) {
        this.Dealer_code = Dealer_code;
    }

    public String getAMC() {
        return AMC;
    }

    public void setAMC(String AMC) {
        this.AMC = AMC;
    }

    public String getSales_exec_name() {
        return sales_exec_name;
    }

    public void setSales_exec_name(String sales_exec_name) {
        this.sales_exec_name = sales_exec_name;
    }

    public Integer getLoc_id() {
        return loc_id;
    }

    public void setLoc_id(Integer loc_id) {
        this.loc_id = loc_id;
    }

    public Integer getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Integer org_id) {
        this.org_id = org_id;
    }

    public String getREFERENCE_NO() {
        return REFERENCE_NO;
    }

    public void setREFERENCE_NO(String REFERENCE_NO) {
        this.REFERENCE_NO = REFERENCE_NO;
    }

    public String getServc_grp() {
        return servc_grp;
    }

    public void setServc_grp(String servc_grp) {
        this.servc_grp = servc_grp;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getContacted() {
        return contacted;
    }

    public void setContacted(String contacted) {
        this.contacted = contacted;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTask_reason() {
        return task_reason;
    }

    public void setTask_reason(String task_reason) {
        this.task_reason = task_reason;
    }

    public Date getLast_servc_dt() {
        return last_servc_dt;
    }

    public void setLast_servc_dt(Date last_servc_dt) {
        this.last_servc_dt = last_servc_dt;
    }

    public String getLast_servc_type() {
        return last_servc_type;
    }

    public void setLast_servc_type(String last_servc_type) {
        this.last_servc_type = last_servc_type;
    }

    public String getService_loc() {
        return service_loc;
    }

    public void setService_loc(String service_loc) {
        this.service_loc = service_loc;
    }

    public Integer getLast_km() {
        return last_km;
    }

    public void setLast_km(Integer last_km) {
        this.last_km = last_km;
    }

    public Date getNext_servc_dt() {
        return next_servc_dt;
    }

    public void setNext_servc_dt(Date next_servc_dt) {
        this.next_servc_dt = next_servc_dt;
    }

    public String getNext_servc_type() {
        return next_servc_type;
    }

    public void setNext_servc_type(String next_servc_type) {
        this.next_servc_type = next_servc_type;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Date last_update_date) {
        this.last_update_date = last_update_date;
    }

    public String getLast_updated_by() {
        return last_updated_by;
    }

    public void setLast_updated_by(String last_updated_by) {
        this.last_updated_by = last_updated_by;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public Date getSERVICE_DUE_DT() {
        return SERVICE_DUE_DT;
    }

    public void setSERVICE_DUE_DT(Date SERVICE_DUE_DT) {
        this.SERVICE_DUE_DT = SERVICE_DUE_DT;
    }

    public Date getDELIVERY_DATE() {
        return DELIVERY_DATE;
    }

    public void setDELIVERY_DATE(Date DELIVERY_DATE) {
        this.DELIVERY_DATE = DELIVERY_DATE;
    }

    public Integer getGatepassId() {
        return gatepassId;
    }

    public void setGatepassId(Integer gatepassId) {
        this.gatepassId = gatepassId;
    }

  
}
