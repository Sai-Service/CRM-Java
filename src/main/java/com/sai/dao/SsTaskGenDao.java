/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.SSTaskGen;
import com.sai.model.SsTaskDetails;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Test
 */

public interface SsTaskGenDao extends CrudRepository<SsTaskDetails, Long> {

    @Query(value = "SELECT A.* FROM (\n"
            + "select distinct null task_id,'SERVICE' TASK_TYPE,'NEW' STATUS,null apptmt_id,SGA.DELIVERY_DATE + interval se.when_to_action DAY CALL_DUE_DATE,\n"
            + "sc.cust_id,sc.cust_name, concat(sc.ADDRESS1,\",\", sc.ADDRESS2 , \",\", sc.ADDRESS3, \",\", sc.PINCODE,\",\",  sc.CITY,\",\", sc.STATE_NAME) cust_address1,\n"
            + "sc.cust_name contact_person,sc.cust_type,sc.contact_no1,sc.contact_no2,sc.email_id,sga.veh_no,sga.chassis_no,sga.engine_no,\n"
            + "sga.model,svm.dtOfPurchase Date_of_purchase,svm.Dealercode Dealer_code,'N' AMC,null sales_exec_name,sga.loc_id,sga.org_id,sga.REFERENCE_NO,\n"
            + "null servc_grp,sga.item_id,null contacted,null reason,null remarks,null task_reason,null last_servc_dt,\n"
            + "sga.service_type last_servc_type,null service_loc,sga.last_km,(SGA.DELIVERY_DATE  + interval SE.DAYS_AFTER_DELIVERY day) next_servc_dt,se.sub_category next_servc_type,\n"
            + "curdate() creation_date,'1111' created_by, curdate() last_update_date,'1111' last_updated_by,'1FS' attribute1,\n"
            + "null attribute2,null attribute3,null attribute4,null attribute5,\n"
            + "(SGA.DELIVERY_DATE + interval SE.days_after_delivery day) SERVICE_DUE_DT,SGA.DELIVERY_DATE,sga.GATEPASS_ID as gatepassId \n"
            + " from test.ss_gatepass_all SGA ,test.ss_event se,test.ss_customer sc ,test.ss_vehicle_master svm \n"
            + " WHERE  SGA.DELIVERY_DATE= curdate() AND se.sub_category='1FS'\n"
            + "AND sga.dept_code='SA' AND  sga.loc_id=se.LOC_ID and sc.cust_id=sga.cust_id and se.type='C' and se.ACTIVE_STATUS='ACTIVE'\n"
            + " and sga.service_type IS NULL  and svm.vehicleno=sga.veh_no  and sga.task_id='0'\n"
            + "UNION\n"
            + "select distinct null task_id, 'SERVICE' TASK_TYPE,'NEW' STATUS,null apptmt_id,SGA.DELIVERY_DATE + interval se.when_to_action DAY CALL_DUE_DATE,\n"
            + "sc.cust_id,sc.cust_name, concat(sc.ADDRESS1,\",\", sc.ADDRESS2 , \",\", sc.ADDRESS3, \",\", sc.PINCODE,\",\",  sc.CITY,\",\", sc.STATE_NAME) cust_address1,\n"
            + "sc.cust_name contact_person,sc.cust_type,sc.contact_no1,sc.contact_no2,sc.email_id,sga.veh_no,sga.chassis_no,sga.engine_no,\n"
            + "sga.model,svm.dtOfPurchase Date_of_purchase,svm.Dealercode Dealer_code,'N' AMC,null sales_exec_name,sga.loc_id,sga.org_id,sga.REFERENCE_NO,\n"
            + "null servc_grp,sga.item_id,null contacted,null reason,null remarks,null task_reason,SGA.DELIVERY_DATE  last_servc_dt,\n"
            + "sga.service_type last_servc_type,SGA.service_loc,sga.last_km,ifnull((case when sga.service_type='1FS' then ((select distinct delivery_date from test.ss_gatepass_all where veh_no=SGA.veh_no and dept_code='SA') + interval se.days_after_delivery day) else SGA.DELIVERY_DATE  + interval se.days_after_delivery day end ),svm.dtOfPurchase  + interval se.days_after_delivery day) next_servc_dt,se.sub_category next_servc_type,\n"
            + "curdate() creation_date,'1111' created_by, curdate() last_update_date,'1111' last_updated_by,'2FS' attribute1,\n"
            + "null attribute2,null attribute3,null attribute4,null attribute5,\n"
            + "ifnull((case when sga.service_type='1FS' then ((select distinct delivery_date from test.ss_gatepass_all where veh_no=SGA.veh_no and dept_code='SA') + interval se.days_after_delivery day) else SGA.DELIVERY_DATE  + interval se.days_after_delivery day end ),svm.dtOfPurchase   + interval se.days_after_delivery day) SERVICE_DUE_DT,\n"
            + "SGA.DELIVERY_DATE,sga.GATEPASS_ID as gatepassId \n"
            + "from test.ss_gatepass_all SGA,test.ss_event se,test.ss_customer sc, test.ss_vehicle_master svm WHERE \n"
            + "SGA.DELIVERY_DATE= curdate() AND  sga.loc_id=se.LOC_ID and sc.cust_id=sga.cust_id and  svm.vehicleno=sga.veh_no and sga.dept_code='SR' AND se.sub_category!='1FS' and \n"
            + " sga.service_type='1FS' and se.sub_category='2FS' and se.type='C' and se.ACTIVE_STATUS='ACTIVE' and sga.task_id ='0'\n"
            + " UNION \n"
            + "select distinct null task_id,'SERVICE' TASK_TYPE,'NEW' STATUS,null apptmt_id,SGA.DELIVERY_DATE + interval se.when_to_action DAY CALL_DUE_DATE,\n"
            + "sc.cust_id,sc.cust_name, concat(sc.ADDRESS1,\",\", sc.ADDRESS2 , \",\", sc.ADDRESS3, \",\", sc.PINCODE,\",\",  sc.CITY,\",\", sc.STATE_NAME) cust_address1,\n"
            + "sc.cust_name contact_person,sc.cust_type,sc.contact_no1,sc.contact_no2,sc.email_id,sga.veh_no,sga.chassis_no,sga.engine_no,\n"
            + "sga.model,svm.dtOfPurchase Date_of_purchase,svm.Dealercode Dealer_code,'N' AMC,null sales_exec_name,sga.loc_id,sga.org_id,sga.REFERENCE_NO,\n"
            + "null servc_grp,sga.item_id,null contacted,null reason,null remarks,null task_reason,SGA.DELIVERY_DATE  last_servc_dt,\n"
            + "sga.service_type last_servc_type,SGA.service_loc,sga.last_km,ifnull((case when sga.service_type='2FS' then ((select distinct delivery_date from test.ss_gatepass_all where veh_no=SGA.veh_no and dept_code='SA') + interval se.days_after_delivery day) else SGA.DELIVERY_DATE  + interval se.days_after_delivery day end ),svm.dtOfPurchase   + interval se.days_after_delivery day) next_servc_dt,se.sub_category next_servc_type,\n"
            + "curdate() creation_date,'1111' created_by, curdate() last_update_date,'1111' last_updated_by,'3FS' attribute1,\n"
            + "null attribute2,null attribute3,null attribute4,null attribute5,\n"
            + "ifnull((case when sga.service_type='2FS' then ((select distinct delivery_date from test.ss_gatepass_all where veh_no=SGA.veh_no and dept_code='SA') + interval se.days_after_delivery day) else SGA.DELIVERY_DATE  + interval se.days_after_delivery day end ),svm.dtOfPurchase   + interval se.days_after_delivery day) SERVICE_DUE_DT,\n"
            + "SGA.DELIVERY_DATE,sga.GATEPASS_ID as gatepassId from test.ss_gatepass_all SGA,test.ss_event se,test.ss_customer sc ,test.ss_vehicle_master svm \n"
            + " WHERE  SGA.DELIVERY_DATE= CURDATE()  AND  sga.loc_id=se.LOC_ID and sc.cust_id=sga.cust_id and svm.vehicleno=sga.veh_no   and sga.dept_code='SR' AND se.sub_category!='1FS' AND se.sub_category!='2FS' and \n"
            + " sga.service_type='2FS' and se.sub_category='3FS' and se.type='C' and se.ACTIVE_STATUS='ACTIVE' and sga.task_id ='0'\n"
            + " union\n"
            + " select distinct null task_id, 'SERVICE' TASK_TYPE,'NEW' STATUS,null apptmt_id,SGA.DELIVERY_DATE + interval se.when_to_action DAY CALL_DUE_DATE,\n"
            + "sc.cust_id,sc.cust_name, concat(sc.ADDRESS1,\",\", sc.ADDRESS2 , \",\", sc.ADDRESS3, \",\", sc.PINCODE,\",\",  sc.CITY,\",\", sc.STATE_NAME) cust_address1,\n"
            + "sc.cust_name contact_person,sc.cust_type,sc.contact_no1,sc.contact_no2,sc.email_id,sga.veh_no,sga.chassis_no,sga.engine_no,\n"
            + "sga.model,svm.dtOfPurchase Date_of_purchase,svm.Dealercode Dealer_code,'N' AMC,null sales_exec_name,sga.loc_id,sga.org_id,sga.REFERENCE_NO,\n"
            + "null servc_grp,sga.item_id,null contacted,null reason,null remarks,null task_reason,SGA.DELIVERY_DATE last_servc_dt,\n"
            + "sga.service_type last_servc_type,SGA.service_loc,sga.last_km,ifnull((case when sga.service_type='3FS' then (SGA.DELIVERY_DATE  + interval se.days_after_delivery day) ELSE (svm.dtOfPurchase   + interval se.days_after_delivery day)end ),svm.dtOfPurchase   + interval se.days_after_delivery day) next_servc_dt,se.sub_category next_servc_type,\n"
            + "curdate() creation_date,'1111' created_by, curdate() last_update_date,'1111' last_updated_by,case when sga.service_type='3FS' then 'PS' else sga.service_type end attribute1,\n"
            + "null attribute2,null attribute3,null attribute4,null attribute5,\n"
            + "(case when sga.service_type='3FS' then ifnull(((select distinct delivery_date from test.ss_gatepass_all where veh_no=SGA.veh_no and dept_code='SA') + interval se.days_after_delivery day),svm.dtOfPurchase   + interval se.days_after_delivery day) else svm.dtOfPurchase   + interval se.days_after_delivery day end ) SERVICE_DUE_DT,\n"
            + "SGA.DELIVERY_DATE,sga.GATEPASS_ID as gatepassId  from test.ss_gatepass_all SGA,test.ss_event se,test.ss_customer sc, ss_vehicle_master svm  WHERE \n"
            + "  SGA.DELIVERY_DATE= curdate()  AND  sga.loc_id=se.LOC_ID and sc.cust_id=sga.cust_id and svm.vehicleno=sga.veh_no    and sga.dept_code='SR' AND se.sub_category!='1FS' AND se.sub_category!='2FS' and \n"
            + " (sga.service_type='3FS' or  sga.service_type='PS') and se.sub_category='PS' and se.type='C' and se.ACTIVE_STATUS='ACTIVE' and sga.task_id='0') A order by a.loc_id", nativeQuery = true)

    public List<Map> getTasksGeneration();

    public SsTaskDetails findTopByVehicleNoOrderByCallDuDtDesc(String vehicle_no);

    @Query(value = "SELECT 'SALES-PROFORMA' TASK_TYPE,'NEW' STATUS,pha.orderedDate+when_to_action CALL_DUE_DATE,\n"
            + "pha.custAcctNo, pha.custDetails cust_address1,cm.custname cust_name,cm.custname contact_person,cm.mobile1 contact_no1\n"
            + ",CM.MOBILE2 contact_no2,cm.emailid email_id,\n"
            + "pha.variant chassis_no, pha.color engine_no,pha.model,pha.orderedDate Date_of_purchase,pha.orderNumber REFERENCE_NO,\n"
            + "pha.issuedBy sales_exec_name,pha.locationId loc_id,pha.orgid org_id,PHA.divisionId divId\n"
            + " FROM PROFORMA_HEADERS_ALL PHA,ss_crm_event se,customer_master cm where pha.orgId=21\n"
            + "    AND pha.locationId=SE.LOC_ID and pha.orgId=SE.org_id and se.dept='SA' and se.active_status='ACTIVE'\n"
            + "    AND SE.service_type='PRF' and pha.custAcctNo=cm.custAccountNo and se.type='C'\n"
            + "    and pha.orderedDate like sysdate and pha.dept=1 \n"
            + "    ", nativeQuery = true)
    public List<SSTaskGen> getTasksGenProformaOracle();

    @Query(value = "select distinct 'SALES-PROFORMA' TASK_TYPE,'NEW' STATUS,pha.orderedDate + interval se.when_to_action DAY CALL_DUE_DATE, \n"
            + " pha.custAcctNo,sc.cust_name, concat(sc.ADDRESS1, sc.ADDRESS2 , sc.ADDRESS3, sc.PINCODE, sc.CITY, sc.STATE_NAME) cust_address1, \n"
            + "sc.cust_name contact_person,sc.cust_type,sc.contact_no1,sc.contact_no2,sc.email_id,\n"
            + "variant chassis_no, pha.color engine_no,pha.model,pha.orderedDate Date_of_purchase,null dealer_code,'N' AMC, pha.issuedBy sales_exec_name,pha.locationId loc_id,pha.orgid org_id, \n"
            + "pha.orderNumber REFERENCE_NO,( pha.orderedDate  + interval SE.DAYS_AFTER_DELIVERY day) next_servc_dt,se.sub_category next_servc_type, \n"
            + "curdate() creation_date,'1111' created_by, curdate() last_update_date,'1111' last_updated_by,'1FS' attribute1,(pha.orderedDate + interval SE.days_after_delivery day) SERVICE_DUE_DT,\n"
            + "pha.orderedDate,pha.headerId as gatepassId \n"
            + " FROM PROFORMA_HEADERS_ALL PHA,ss_event se,ss_customer sc where pha.locationId=SE.LOC_ID \n"
            + " and pha.orgId=SE.org_id and se.dept='SA' and se.active_status='ACTIVE'\n"
            + " AND SE.service_type='PRF' and pha.custAcctNo=sc.CUST_ID and se.type='C'\n"
            + " and pha.orderedDate like curdate() ", nativeQuery = true)
    public List<SSTaskGen> getTasksGenPrfMysql();

}
