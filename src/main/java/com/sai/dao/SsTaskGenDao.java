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
            + "curdate() creation_date,'1111' created_by, curdate() last_update_date,'1111' last_updated_by,'FS1' attribute1,\n"
            + "null attribute2,null attribute3,null attribute4,null attribute5,\n"
            + "(SGA.DELIVERY_DATE + interval SE.days_after_delivery day) SERVICE_DUE_DT,SGA.DELIVERY_DATE,sga.GATEPASS_ID as gatepassId \n"
            + " from test.ss_gatepass_all SGA ,test.ss_event se,test.ss_cust_new sc ,test.ss_vehicle_master svm \n"
            + " WHERE  se.sub_category='FS1'\n"
            + "AND sga.dept_code='SA'  AND  sga.loc_id=se.LOC_ID and sc.cust_id=sga.cust_id and se.type='C' and se.ACTIVE_STATUS='ACTIVE'\n"
            + " and sga.service_type='NA'  and svm.vehicleno=sga.veh_no  and sga.task_id='0') A order by a.loc_id", nativeQuery = true)
    public List<Map> getTasksGeneration1FS();//and SGA.DELIVERY_DATE=curdate()-1 
//SGA.DELIVERY_DATE= curdate() AND 

    @Query(value = "SELECT A.* FROM (select distinct  distinct null task_id,'SERVICE' TASK_TYPE,'NEW' STATUS,null apptmt_id,\n"
            + "ifnull(ifnull(svm.delvDate+ interval se.when_to_action day,svm.dtOfPurchase  + interval se.when_to_action day),curdate()) CALL_DUE_DATE, sc.cust_id,sc.cust_name,sga.CUST_ADDRESS1 cust_address1 , sc.cust_name contact_person,\n"
            + "sc.cust_type,sc.contact_no1, sc.contact_no2, sc.email_id,sga.veh_no,sga.chassis_no,sga.engine_no, sga.model,\n"
            + "svm.dtOfPurchase Date_of_purchase,svm.Dealercode Dealer_code, 'N' AMC, null sales_exec_name, sga.loc_id,\n"
            + "sga.org_id, sga.REFERENCE_NO,null servc_grp,sga.item_id,null contacted, null reason, null remarks,null task_reason,\n"
            + "SGA.DELIVERY_DATE  last_servc_dt, sga.service_type last_servc_type, SGA.service_loc,sga.last_km ,  \n"
            + "ifnull(svm.delvDate+ interval se.days_after_delivery day,svm.dtOfPurchase  + interval se.days_after_delivery day)  next_servc_dt, se.sub_category next_servc_type,\n"
            + "curdate() creation_date, '1' created_by,curdate() last_update_date, '1' last_updated_by, 'FS2' attribute1,\n"
            + "null attribute2,null attribute3,null attribute4, null attribute5 ,  ifnull(svm.delvDate+ interval se.days_after_delivery day,svm.dtOfPurchase  + interval se.days_after_delivery day) SERVICE_DUE_DT, \n"
            + "SGA.DELIVERY_DATE,sga.GATEPASS_ID as gatepassId from test.ss_gatepass_all sga  ,   test.ss_event se,   test.ss_vehicle_master svm ,test.ss_cust_new sc\n"
            + "where sga.dept_code='SR' and sga.cust_id=sc.cust_id\n"
            + " and sga.service_type='FS1'    and sga.task_id ='0' and svm.custId=sc.CUST_ID AND  sga.loc_id=se.LOC_ID     AND se.sub_category!='FS1'   and se.sub_category='FS2' \n"
            + "and se.type='C'  and  svm.vehicleno=sga.veh_no  and se.ACTIVE_STATUS='ACTIVE'  ) A order by a.loc_id", nativeQuery = true)
    public List<Map> getTasksGeneration2FS();//SGA.DELIVERY_DATE= curdate()   and and SGA.DELIVERY_DATE=curdate()-1

    @Query(value = "SELECT A.* FROM (select distinct  null task_id,'SERVICE' TASK_TYPE,'NEW' STATUS,null apptmt_id,\n"
            + "ifnull(ifnull(svm.delvDate+ interval se.when_to_action day,svm.dtOfPurchase  + interval se.when_to_action day),curdate()) CALL_DUE_DATE, sc.cust_id,sc.cust_name,sga.CUST_ADDRESS1 cust_address1 , sc.cust_name contact_person,\n"
            + "sc.cust_type,sc.contact_no1, sc.contact_no2, sc.email_id,sga.veh_no,sga.chassis_no,sga.engine_no, sga.model,\n"
            + "svm.dtOfPurchase Date_of_purchase,svm.Dealercode Dealer_code, 'N' AMC, null sales_exec_name, sga.loc_id,\n"
            + "sga.org_id, sga.REFERENCE_NO,null servc_grp,sga.item_id,null contacted, null reason, null remarks,null task_reason,\n"
            + "SGA.DELIVERY_DATE  last_servc_dt, sga.service_type last_servc_type, SGA.service_loc,sga.last_km ,  \n"
            + "ifnull(svm.delvDate+ interval se.days_after_delivery day,svm.dtOfPurchase  + interval se.days_after_delivery day)  next_servc_dt, se.sub_category next_servc_type,\n"
            + "curdate() creation_date, '1' created_by,curdate() last_update_date, '1' last_updated_by, 'FS3' attribute1,\n"
            + "null attribute2,null attribute3,null attribute4, null attribute5 , ifnull(svm.delvDate+ interval se.days_after_delivery day,svm.dtOfPurchase  + interval se.days_after_delivery day)  SERVICE_DUE_DT, \n"
            + "SGA.DELIVERY_DATE,sga.GATEPASS_ID as gatepassId from test.ss_gatepass_all sga  ,   test.ss_event se,   test.ss_vehicle_master svm ,test.ss_cust_new sc\n"
            + "where sga.dept_code='SR' and sga.cust_id=sc.cust_id\n"
            + " AND se.sub_category!='FS1' AND se.sub_category!='FS2'   \n"
            + "  and sga.service_type='FS2' and sga.task_id ='0' and svm.custId=sc.CUST_ID AND  sga.loc_id=se.LOC_ID  \n"
            + " and se.sub_category='FS3' and se.type='C'  and  svm.vehicleno=sga.veh_no  and se.ACTIVE_STATUS='ACTIVE') A order by a.loc_id", nativeQuery = true)
    public List<Map> getTasksGeneration3FS();//and SGA.DELIVERY_DATE=curdate()-1

    @Query(value = "SELECT A.* FROM (select distinct  null task_id,'SERVICE' TASK_TYPE,'NEW' STATUS,null apptmt_id,\n"
            + "ifnull(ifnull(svm.delvDate+ interval se.when_to_action day,svm.dtOfPurchase  + interval se.when_to_action day),curdate()) CALL_DUE_DATE, sc.cust_id,sc.cust_name,sga.CUST_ADDRESS1 cust_address1 , sc.cust_name contact_person,\n"
            + "sc.cust_type,sc.contact_no1, sc.contact_no2, sc.email_id,sga.veh_no,sga.chassis_no,sga.engine_no, sga.model,\n"
            + "svm.dtOfPurchase Date_of_purchase,svm.Dealercode Dealer_code, 'N' AMC, null sales_exec_name, sga.loc_id,\n"
            + "sga.org_id, sga.REFERENCE_NO,null servc_grp,sga.item_id,null contacted, null reason, null remarks,null task_reason,\n"
            + "SGA.DELIVERY_DATE  last_servc_dt, sga.service_type last_servc_type, SGA.service_loc,sga.last_km ,  \n"
            + "ifnull(svm.delvDate+ interval se.days_after_delivery day,svm.dtOfPurchase  + interval se.days_after_delivery day) next_servc_dt, se.sub_category next_servc_type,\n"
            + "curdate() creation_date, '1' created_by,curdate() last_update_date, '1' last_updated_by, 'PS' attribute1,\n"
            + "null attribute2,null attribute3,null attribute4, null attribute5 , ifnull(svm.delvDate+ interval se.days_after_delivery day,svm.dtOfPurchase  + interval se.days_after_delivery day) SERVICE_DUE_DT, \n"
            + "SGA.DELIVERY_DATE,sga.GATEPASS_ID as gatepassId from test.ss_gatepass_all sga  ,   test.ss_event se,   test.ss_vehicle_master svm ,test.ss_cust_new sc\n"
            + " where sga.dept_code='SR' and sga.cust_id=sc.cust_id\n"
            + " and  (sga.service_type='FS3' or  sga.service_type='PS') and se.sub_category='PS'\n"
            + " and svm.custId=sc.CUST_ID AND  sga.loc_id=se.LOC_ID   and sga.TASK_ID=0 \n"
            + " and se.type='C'  and  svm.vehicleno=sga.veh_no  and se.ACTIVE_STATUS='ACTIVE') A order by a.loc_id", nativeQuery = true)
    public List<Map> getTasksGenerationPaidSR();//and SGA.DELIVERY_DATE=curdate()-1 

    @Query(value = "SELECT A.* FROM (select distinct null task_id,'SERVICE' TASK_TYPE,'NEW' STATUS, null apptmt_id, SGA.DELIVERY_DATE + interval se.when_to_action DAY CALL_DUE_DATE,\n"
            + "            sc.cust_id,sc.cust_name,sc.cust_name contact_person, sc.cust_type, sc.contact_no1,sc.contact_no2,\n"
            + "            sc.email_id,sga.veh_no,sga.chassis_no, sga.engine_no, sga.model,  svm.dtOfPurchase Date_of_purchase, svm.Dealercode Dealer_code,\n"
            + "            'N' AMC,null sales_exec_name, sga.loc_id,sga.org_id, sga.REFERENCE_NO, null servc_grp,sga.item_id, null contacted,\n"
            + "            null reason,null remarks,null task_reason, SGA.DELIVERY_DATE last_servc_dt, sga.service_type last_servc_type,\n"
            + "            SGA.service_loc, sga.last_km, SGA.DELIVERY_DATE  + interval se.days_after_delivery day\n"
            + "            next_servc_dt, se.attribute2 next_servc_type,\n"
            + "            curdate() creation_date,'1' created_by, curdate() last_update_date,'1' last_updated_by,\n"
            + "           se.attribute2 attribute1, null attribute2,\n"
            + "             null attribute3, null attribute4,  null attribute5, SGA.DELIVERY_DATE   + interval se.days_after_delivery day \n"
            + "             SERVICE_DUE_DT, SGA.DELIVERY_DATE, sga.GATEPASS_ID as gatepassId  from\n"
            + "             test.ss_gatepass_all SGA,test.ss_event se,test.ss_cust_new sc,ss_vehicle_master svm  \n"
            + "            WHERE sga.loc_id=se.LOC_ID and sc.cust_id=sga.cust_id and svm.vehicleno=sga.veh_no    \n"
            + "             and sga.dept_code='SR' AND se.sub_category!='PS' and se.sub_category!='FS1' AND se.sub_category!='FS2' AND se.sub_category!='FS3' \n"
            + "             and se.sub_category=sga.SERVICE_TYPE   and se.type='C' and se.ACTIVE_STATUS='ACTIVE' and sga.task_id='0'\n"
            + "            ) A order by a.loc_id", nativeQuery = true)
    public List<Map> getTasksGenAllOtherType();

    ///GENERATED TILL 2023-05-25 00:00:00--DONT RUN
    @Query(value = "SELECT A.* FROM (select distinct   null task_id,'SERVICE' TASK_TYPE,'NEW' STATUS,null apptmt_id,\n"
            + "           sga.delivery_date  + interval se.when_to_action day CALL_DUE_DATE, sc.cust_id,sc.cust_name,sga.CUST_ADDRESS1 cust_address1 , sc.cust_name contact_person,\n"
            + "          sc.cust_type,sc.contact_no1, sc.contact_no2, sc.email_id,sga.veh_no,sga.chassis_no,sga.engine_no, sga.model,\n"
            + "           svm.dtOfPurchase Date_of_purchase,svm.Dealercode Dealer_code, 'N' AMC, null sales_exec_name, sga.loc_id,\n"
            + "            sga.org_id, sga.REFERENCE_NO,null servc_grp,sga.item_id,null contacted, null reason, null remarks,null task_reason,\n"
            + "            SGA.DELIVERY_DATE  last_servc_dt, sga.service_type last_servc_type, SGA.service_loc,sga.last_km ,  \n"
            + "            sga.delivery_date + interval se.days_after_delivery day next_servc_dt, se.sub_category next_servc_type,\n"
            + "            curdate() creation_date, '1' created_by,curdate() last_update_date, '1' last_updated_by, 'PS' attribute1,\n"
            + "            null attribute2,null attribute3,null attribute4, null attribute5 ,  sga.delivery_date   + interval se.days_after_delivery day SERVICE_DUE_DT, \n"
            + "            SGA.DELIVERY_DATE,sga.GATEPASS_ID as gatepassId from test.ss_gatepass_all sga  ,   test.ss_event se,   test.ss_vehicle_master svm ,test.ss_cust_new sc\n"
            + "            where   sga.dept_code='SR' and sga.cust_id=sc.cust_id\n"
            + "            and  sga.service_type='FS3' and se.sub_category='PS3'\n"
            + "             and svm.custId=sc.CUST_ID AND  sga.loc_id=se.LOC_ID  \n"
            + "             and se.type='C'  and  svm.vehicleno=sga.veh_no  and se.ACTIVE_STATUS='ACTIVE' \n"
            + "            ) A  where a.call_due_date = '2023-01-22' order by a.loc_id", nativeQuery = true)
    public List<Map> getTasksGenPSAft3Month();

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
            + "             pha.custAcctNo,sc.cust_name, concat(sc.ADDRESS1, sc.ADDRESS2 , sc.ADDRESS3, sc.PINCODE, sc.CITY, sc.STATE_NAME) cust_address1, \n"
            + "            sc.cust_name contact_person,sc.cust_type,sc.contact_no1,ifnull(contact_no2,0)contact_no2,sc.email_id,\n"
            + "            variant chassis_no, pha.color engine_no,pha.model,pha.orderedDate Date_of_purchase,1 dealer_code,'N' AMC, pha.issuedBy sales_exec_name,pha.locationId loc_id,pha.orgid org_id, \n"
            + "            pha.orderNumber REFERENCE_NO,( pha.orderedDate  + interval SE.DAYS_AFTER_DELIVERY day) next_servc_dt,se.sub_category next_servc_type, \n"
            + "            curdate() creation_date,'1111' created_by, curdate() last_update_date,'1111' last_updated_by,'FS1' attribute1,(pha.orderedDate + interval SE.days_after_delivery day) SERVICE_DUE_DT,\n"
            + "            pha.orderedDate,pha.headerId as gatepassId \n"
            + "             FROM PROFORMA_HEADERS_ALL PHA,ss_event se,ss_cust_new sc where pha.locationId=SE.LOC_ID \n"
            + "             and pha.orgId=SE.org_id and se.dept='SA' and se.active_status='ACTIVE'\n"
            + "             AND SE.service_type='PRF' and pha.custAcctNo=sc.CUST_ID and se.type='C'\n"
            + "             and pha.orderedDate like curdate()", nativeQuery = true)
    public List<Map> getTasksGenPrfMysql();

}
