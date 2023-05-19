/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.impl;

import static com.lowagie.text.xml.simpleparser.EntitiesToUnicode.map;
import com.sai.dto.EventReport;
import com.sai.dto.SsTaskReport;
import com.sai.model.SSAppoinmentDetails;
import com.sai.model.insurance.SsInsuranceDetails;
import com.sai.service.SSTaskCreationService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Swaroopcomp
 */
@Repository
@Transactional(readOnly = true)
public class SSTaskCreationServiceImpl implements SSTaskCreationService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<SsTaskReport> findTaskByConditions(Map<String, String> map) {
        String baseQuery1 = "Select std.taskId,std.callDuDt, std.custId, std.CustName,std.CustAdd,std.contactPerson,std.custType,std.contactNo1,std.contactNo2,"
                + "std.emailAdd,std.vehicleNo,std.chassisNo,std.engineNo,std.Model,std.contacted, std.reason,std.remarks,std.taskReason,std.lstServDt,std.lstServType,std.lstServLoc,std.lstKm,std.nxtServDt,std.nxtServType,"
                + "std.attribute1 as callForService,std.assignee, std.assigneeId from SsTaskDetails std  where  std.taskId=sad.taskId and  std.callDuDt BETWEEN ?1 and ?2 and std.orgId=?3 ";

        String locIdQuery = " and std.locId =?";
        String dtcustTypeQuery = "  and std.custType=?";
        String contactedQuery =  "   and std.contacted =?";
        String modelQuery =  "   and std.Model =?";
        String assignQuery =  "   and  sad.assigneeId=?";
        String taskStatusQuery =  "   and std.taskStatus=?";
        int i = 4;
        Map<Integer, Object> paramsMap = new HashMap<Integer, Object>();
        if (map.containsKey("locId")) {
            if (map.get("locId").trim().length() > 0 ) {
                baseQuery1 = baseQuery1 + locIdQuery + i;
                paramsMap.put(i, Long.parseLong(map.get("locId")));
                i++;
            }
        }

        if (map.containsKey("custType")) {
            if (map.get("custType").trim().length() > 0 ) {
                baseQuery1 = baseQuery1 + dtcustTypeQuery + i;
                 paramsMap.put(i,map.get("custType"));
                i++;
            }
        }
        
         if (map.containsKey("model")) {
           if (map.get("model").trim().length() > 0 ) {
                baseQuery1 = baseQuery1 + modelQuery + i;
                 paramsMap.put(i,map.get("model"));
                i++;
            }
        }
         
         if (map.containsKey("contacted")) {
            if (map.get("contacted").trim().length() > 0 ) {
                baseQuery1 = baseQuery1 + contactedQuery + i;
                 paramsMap.put(i,map.get("contacted"));
                i++;
            }
        }
         
           if (map.containsKey("taskStatus")) {
               System.out.println("----XX" + map.get("taskStatus") +"$----"  );
            if (map.get("taskStatus").trim().length() > 0 ) {
                baseQuery1 = baseQuery1 + taskStatusQuery + i;
                 paramsMap.put(i,map.get("taskStatus"));
                i++;
            }
        }
           
            if (map.containsKey("assigneeId")) {
            if (map.get("assigneeId").trim().length() > 0 ) {
                baseQuery1 = baseQuery1 + assignQuery + i;
                 paramsMap.put(i,map.get("assigneeId"));
                i++;
            }
        }

            Query query1 = entityManager.createQuery(baseQuery1);
            List<SsTaskReport> taskList = new ArrayList<SsTaskReport>();
            try {

                if (map.containsKey("fromDate")) {
                    query1.setParameter(1, new SimpleDateFormat("yyyy-MM-dd").parse(map.get("fromDate")), TemporalType.DATE);
                    query1.setParameter(2, new SimpleDateFormat("yyyy-MM-dd").parse(map.get("toDate")), TemporalType.DATE);
                    query1.setParameter(3, Long.parseLong(map.get("orgId")));
                }
                int x =4;
                for(int j=0; j<paramsMap.size() ;j++){
                    query1.setParameter(x,paramsMap.get(x));
                     x++;
                }
                List<Object[]> list = query1.getResultList();

                for (Object[] obj : list) {
                    SsTaskReport sst = new SsTaskReport((Integer) obj[0], (Date) obj[1], (Integer) obj[2], (String) obj[3], (String) obj[4], (String) obj[5], (String) obj[6], (String) obj[7], (String) obj[8], (String) obj[9], (String) obj[10], (String) obj[11], (String) obj[12], (String) obj[13], (String) obj[14], (String) obj[15], (String) obj[16], (String) obj[17], (Date) obj[18], (String) obj[19], (String) obj[20], (Integer) obj[21], (Date) obj[22], (String) obj[23], (String) obj[24], (String) obj[25], (String) obj[26]);
                    taskList.add(sst);
                }
                System.out.println("======Result size======" + taskList.size());
            } catch (ParseException ex) {
                System.out.println("======error======");
                Logger.getLogger(SSTaskCreationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            return taskList;
        }
    
   //  @Override
    public List<SsTaskReport> findReasonWiseReport(String fromDate,String toDate ,Integer orgId,Integer locId,String reasonCode) {
        String baseQuery1 = "Select std.taskId,std.callDuDt, std.custId, std.custName,std.custAdd,std.contactPerson,std.custType,std.contactNo1,std.contactNo2,"
                + "std.emailAdd,std.vehicleNo,svm.chassis,svm.engine,svm.model,std.contacted, std.reason,std.remarks,std.taskReason,std.lastServcDt,std.lastServcType,std.lastServcLoc,std.lastServcKm,std.nextServcDt,std.nextServcType,"
                + "std.attribute1 as callForService,std.assignee, std.assigneeId from SsTaskDetails std ,SsVehicleMaster svm  where std.custId=svm.custId and std.vehicleNo=svm.vehicleNo and std.callDuDt BETWEEN ?1 and ?2 and std.orgId=?3 ";

        String locIdQuery = " and std.locId =?";
        String taskReasonQuery = "  and std.Reason=?";
        int i = 4;
        Map<Integer, Object> paramsMap = new HashMap<Integer, Object>();
       
            if (locId!=null) {
                baseQuery1 = baseQuery1 + locIdQuery + i;
                paramsMap.put(i, locId);
                i++;
            }
            if (!reasonCode.equalsIgnoreCase("")) {
                baseQuery1 = baseQuery1 + taskReasonQuery + i;
                paramsMap.put(i,reasonCode);
                i++;
            }
   
        
        Query query1 = entityManager.createQuery(baseQuery1);
       
        List<SsTaskReport> taskList = new ArrayList<SsTaskReport>();
        try {
           
                query1.setParameter(1, new SimpleDateFormat("yyyy-MM-dd").parse(fromDate));
                query1.setParameter(2, new SimpleDateFormat("yyyy-MM-dd").parse(toDate));
                query1.setParameter(3, orgId);
           
            int x = 4;
            for (int j = 0; j < paramsMap.size(); j++) {
                query1.setParameter(x, paramsMap.get(x));
                x++;
            }
                System.out.println(baseQuery1);
            List<Object[]> list = query1.getResultList();

            for (Object[] obj : list) {
                SsTaskReport sst = new SsTaskReport((long) obj[0], (Date) obj[1], (long) obj[2], (String) obj[3], (String) obj[4], (String) obj[5], (String) obj[6], (String) obj[7], (String) obj[8], (String) obj[9], (String) obj[10], (String) obj[11], (String) obj[12], (String) obj[13], (String) obj[14], (String) obj[15], (String) obj[16], (String) obj[17], (Date) obj[18], (String) obj[19], (String) obj[20], (Integer) obj[21], (Date) obj[22], (String) obj[23], (String) obj[24], (String) obj[25], (String) obj[26]);
            //                                      (long taskId, Date callDuDt, long custId, String custName, String custAdd, String contactPerson, String custType, String contactNo1, String contactNo2, String emailAdd, String vehicleNo, String chassisNo, String engineNo, String model, String contacted, String reason, String remarks, String taskReason, Date lstServDt, String lstServType, String lstServLoc, long lstKm, Date nxtServDt, String nxtServType, String callForService, String assignee, String assigneeId)
                taskList.add(sst);
            }
            System.out.println("======Result size======" + taskList.size());
        } catch (ParseException ex) {
            System.out.println("======error======");
            Logger.getLogger(SSTaskCreationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return taskList;
    }

    public List<SSAppoinmentDetails> findAppointmentReport(String fromDate,String toDate,Integer orgId,Integer locId) {
        String baseQuery1 = "select appmntId,vehicleNo,servType,servLoc,servGroup,apptDate,apptTimeSlot,apptStatus,pickUp,amount,pickAdd,remark,lastDesposition,apptAttended"
                + " from SSAppoinmentDetails Where apptDate BETWEEN ?1 and ?2 and orgId=?3 ";

        String locIdQuery = " and locationId =?";
        if (locId != null) {
          
                baseQuery1 = baseQuery1 + locIdQuery + 4;
   
        }
         Query query1 = entityManager.createQuery(baseQuery1);
            List<SSAppoinmentDetails> appointments = new ArrayList<SSAppoinmentDetails>();
            try {

                  Date objDate = new Date();
             
                    query1.setParameter(1, new SimpleDateFormat("yyyy-MM-dd").parse(fromDate));
                    query1.setParameter(2, new SimpleDateFormat("yyyy-MM-dd").parse(toDate));
                    query1.setParameter(3, orgId);
                
                 if (locId!=null) {
                     query1.setParameter(4, locId);
                 }
               
                List<Object[]> list = query1.getResultList();

                for (Object[] obj : list) {
                    SSAppoinmentDetails appt = new SSAppoinmentDetails((long) obj[0], (String) obj[1],  (String)obj[2], (String) obj[3], (String) obj[4], (Date) obj[5], (String) obj[6], (String) obj[7], (String) obj[8], (Integer) obj[9], (String) obj[10], (String) obj[11], (String) obj[12], (String) obj[13]);
//                SSAppoinmentDetails(Integer appmntId, String vehNo, String servType, String servLoc, String servGroup, Date apptDate, String apptTimeSlt, String apptStatus, String pickUp, Integer amount, String pickAdd, String remark, String lastDesposition, String apptAttended ){
                    appointments.add(appt);
                }
                System.out.println("======Result size======" + appointments.size());
            } catch (Exception ex) {
                System.out.println("======error======");
                Logger.getLogger(SSTaskCreationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            return appointments;
    }

    @Override
    public List<Object> findEventWiseReport(Map<String, String> map) {
        
//        String baseQuery1 = "select Distinct se.subCategory,sc.custId,sc.custName,concat(sc.address1,',',sc.address2,',',sc.address3,',',sc.pinCode,',',sc.city,',',sc.stateName) as custAddress,\n" +
//"sc.custName as contactPerson,sc.custType,sc.contactNo1,sc.contactNo2,sc.emailId,sga.VehNo,sc.chassisNo,sc.engineNo,sc.model,sc.dtOfPurchase as dateOfPurchase,sc.dealerCd,sga.locId,sga.orgId,sga.refNo,sga.deliveryDate as lastServcDt,sga.servType as lastServcType, sga.servLoc, sga.lastKm,(sga.deliveryDate+interval 90 day) as nextServcDt,se.subCategory  as nextServcType,\n" +
//" (sga.deliveryDate +interval 90  day) as serviceDueDt, sga.deliveryDate from SSGatepassAll sga,SsCustomer sc, SsEvent se Where sga.custId=sc.custId And se.serType not in('FS','PS')  And  sga.locId=se.locId And se.activeStatus='ACTIVE'  And sga.orgId=?1  And sga.locId=?2 ";
   
String baseQuery1 ="select distinct se.sub_category subCategory,\n" +
"\n" +
"sc.cust_id,sc.cust_name, concat(sc.ADDRESS1, ',' , sc.ADDRESS2 , ',' ,  sc.ADDRESS3, ',' ,  sc.PINCODE, ',' ,   sc.CITY, ',' ,  sc.STATE_NAME) cust_address1,\n" +
"\n" +
"sc.cust_name contact_person,sc.cust_type,sc.contact_no1,sc.contact_no2,sc.email_id,sga.veh_no,sc.chassis_no,sc.engine_no,\n" +
"\n" +
"sc.model,sc.DT_OF_PURCHASE Date_of_purchase,sc.Dealer_code,sga.loc_id,sga.org_id,sga.REFERENCE_NO,\n" +
"\n" +
"SGA.DELIVERY_DATE last_servc_dt,\n" +
"\n" +
"sga.service_type last_servc_type,SGA.service_loc,sga.last_km,(SGA.DELIVERY_DATE  + interval SE.DAYS_AFTER_DELIVERY day) next_servc_dt,se.sub_category next_servc_type,\n" +
"\n" +
"(SGA.DELIVERY_DATE  + interval SE.DAYS_AFTER_DELIVERY day) service_due_dt ,SGA.DELIVERY_DATE\n" +
"\n" +
"from test.ss_gatepass_all sga ,ss_cust_new sc,test.ss_event se where\n" +
"\n" +
"sga.cust_id=sc.CUST_ID and se.service_type not in ('FS','PS') AND\n" +
"\n" +
"SGA.DELIVERY_DATE= DATE_SUB(curdate(), INTERVAL SE.WHEN_TO_ACTION DAY)\n" +
"\n" +
"and sga.LOC_ID=se.LOC_ID and se.ACTIVE_STATUS='ACTIVE' and sga.LOC_ID=?1 and sga.org_id=?2\n" +
"\n" +
" AND se.MODEL=?3' and se.COLOR=?4 AND SGA.DEPT_CODE=?5 " ;

          String modelQuery = " And se.model=?";
          String colorQuery = "  And se.color=?";
          String deptQuery = " And sga.deptCode=?";
          
            int i = 3;
        Map<Integer, Object> paramsMap = new HashMap<Integer, Object>();
        if (map.containsKey("model")) {
            if (map.get("model").trim().length() > 0 ) {
                baseQuery1 = baseQuery1 + modelQuery + i;
                paramsMap.put(i, Long.parseLong(map.get("model")));
                i++;
            }
        }

        if (map.containsKey("color")) {
            if (map.get("color").trim().length() > 0 ) {
                baseQuery1 = baseQuery1 +colorQuery + i;
                 paramsMap.put(i,map.get("color"));
                i++;
            }
        }
        
         if (map.containsKey("deptCode")) {
            if (map.get("deptCode").trim().length() > 0 ) {
                baseQuery1 = baseQuery1 + deptQuery + i;
                 paramsMap.put(i,map.get("deptCode"));
                i++;
            }
        }
     //      Query query1 = entityManager.createQuery(baseQuery1);
    //        List<EventReport>eventList = new ArrayList<EventReport>();
    
    Query query1 = entityManager.createNativeQuery(baseQuery1);
     List<Object>eventList = new ArrayList<Object>();
            try {
                if (map.containsKey("orgId")) {
                    query1.setParameter(1, Long.parseLong(map.get("orgId")));
                }
                 if (map.containsKey("locId")) {
                    query1.setParameter(2, Long.parseLong(map.get("locId")));
                }
                int x =3 ;
                for(int j=0; j<paramsMap.size() ;j++){
                    query1.setParameter(x,paramsMap.get(x));
                     x++;
                }
                List<Object[]> list = query1.getResultList();

                for (Object[] obj : list) {
//String subCategory, Integer custId, String custName, String custAddress, String contactPerson, String custType, String contactNo1, String contactNo2, String emailId, String VehNo, String chassisNo, String engineNo, String model, String dealerCd, Date dateOfPurchase, Integer orgId, Integer locId, String servLoc, String refNo, String lastServcType, String lastKM, Date lastServcDt, Date nextServcDt, String nextServcType, Date serviceDueDt, Date deliveryDate) {

                    EventReport eventDetails = new EventReport((String) obj[0], (Integer) obj[1], (String) obj[2], (String) obj[3], (String) obj[4], (String) obj[5], (String) obj[6], (String) obj[7], (String) obj[8], (String) obj[9], (String) obj[10], (String) obj[11], (String) obj[12], (String) obj[13], (Date) obj[14], (Integer) obj[15], (Integer) obj[16], (String) obj[17], (String) obj[18], (String) obj[19], (String) obj[20], (Date) obj[21], (Date) obj[22], (String) obj[23], (Date) obj[24], (Date) obj[25]);
                    eventList.add(eventDetails);
                }
                System.out.println("======Result size======" +eventList.size());
            } catch (Exception ex) {
                System.out.println("======error======");
                Logger.getLogger(SSTaskCreationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            return eventList;
    }
    
   /*  @Override
    public List<SSGatepassAll> findGatepassExceptionReport() {
        String baseQuery1 = "select id,gatepassId,deliveryDate,custName,custId,contactNo,VehNo,orgId,locId,servLoc,refNo,servType,lastKM,model,chassisNo,engineNo,deptCode"
                + " from SSGatepassAll Where deliveryDate=curdate() and taskId is null ";
    
         Query query1 = entityManager.createQuery(baseQuery1);
            List<SSGatepassAll> ssgpass = new ArrayList<SSGatepassAll>();
         
               try{
                List<Object[]> list = query1.getResultList();

                for (Object[] obj : list) {
                    SSGatepassAll gpass = new SSGatepassAll((Integer) obj[0], (Integer) obj[1],  (String)obj[2], (String) obj[3], (Integer) obj[4], (String) obj[5], (String) obj[6], (Integer) obj[7], (Integer) obj[8], (String) obj[9], (String) obj[10], (String) obj[11], (Integer) obj[12], (String) obj[13], (String) obj[14], (String) obj[15], (String) obj[16]);
//    public SSGatepassAll(Integer id, Integer gatepassId, String deliveryDate, String custName, Integer custId, String contactNo, String VehNo, Integer orgId, Integer locId, String servLoc, String refNo, String servType, Integer lastKM, String model, String chassisNo, String engineNo, String deptCode) {
                   ssgpass.add(gpass);
                }
                System.out.println("======Result size======" + ssgpass.size());
               }
               catch(Exception e)
               {
                     System.out.println("======error======");
               Logger.getLogger(SSTaskCreationServiceImpl.class.getName()).log(Level.SEVERE, null, e); 
               }
             return ssgpass;
    }*/
 @Override
    public List<SsInsuranceDetails> findByInsDetailConditions(Map<String, String> map) {
        String baseQuery1 = "select custId, miNo,  insCompName,  policyNo,  year,  insType,  idvAmt,  prmAmt, claimAmt,  remark,  financeCompName,  policyType,  exShowPrice,  endorsementTaken,  policyRenewType, \n" +
         "     policySubType,  dealerName,  currentNCB,  driverCover,  legalLibNoPer,  driverCoverPremium,  typeOfCustomer, paymentMode,  accountNo,  bankBranch,  bankName,  status,  orgId,  locId,  id,  vehicleNo, \n" +
         "               insStDate,  insPeriod,  insEndDt,  claimCount,  remittanceDate,  paymentAmt,  paymentDate, inactiveDate,  creationDt,  createdBy, lstUpdationDt,  lstUpdatedby"
                + " from SsInsuranceDetails Where insEndDt BETWEEN ?1 and ?2 and orgId=?3 ";
// public SsInsuranceDetails(custId, miNo,  insCompName,  policyNo,  year,  insType,  idvAmt,  prmAmt, claimAmt,  remark,  financeCompName,  policyType,  exShowPrice,  endorsementTaken,  policyRenewType, 
 //        policySubType,  dealerName,  currentNCB,  driverCover,  legalLibNoPer,  driverCoverPremium,  typeOfCustomer, paymentMode,  accountNo,  bankBranch,  bankName,  status,  orgId,  locId,  id,  vehicleNo, 
   //              insStDate,  insPeriod,  insEndDt,  claimCount,  remittanceDate,  paymentAmt,  paymentDate, inactiveDate,  creationDt,  createdBy, lstUpdationDt,  lstUpdatedby) 
   
         Query query1 = entityManager.createQuery(baseQuery1);
            List<SsInsuranceDetails> insTaskDet = new ArrayList<SsInsuranceDetails>();
            try {

                if (map.containsKey("fromDate")) {
                    query1.setParameter(1, new SimpleDateFormat("yyyy-MM-dd").parse(map.get("fromDate")), TemporalType.DATE);
                    query1.setParameter(2, new SimpleDateFormat("yyyy-MM-dd").parse(map.get("toDate")), TemporalType.DATE);
                    query1.setParameter(3, (Integer.parseInt(map.get("orgId")) ));
                }

                List<Object[]> list = query1.getResultList();

                for (Object[] obj : list) {
                    SsInsuranceDetails insuDet = new SsInsuranceDetails((int) obj[0], (String) obj[1], (String) obj[2], (String) obj[3], (int) obj[4], (String) obj[5], (String) obj[6], (String) obj[7], (String) obj[8], (String) obj[9], (String) obj[10], (String) obj[11], (String) obj[12], (String) obj[13], (String) obj[14],
                            (String) obj[15], (String) obj[16], (String) obj[17], (String) obj[18], (String) obj[19], (String) obj[20], (String) obj[21], (String) obj[22], (String) obj[23], (String) obj[24], (String) obj[25], (String) obj[26], (int) obj[27], (int) obj[28], (Integer) obj[29], (String) obj[30],
                            (Date) obj[31], (Integer) obj[32], (Date) obj[33], (Integer) obj[34], (Date) obj[35], (Float) obj[36], (Date) obj[37], (Date) obj[38], (Date) obj[39], (Integer) obj[40], (Date) obj[41], (Integer) obj[42]);

// public SsInsuranceDetails((int) obj[0] , (String) obj [1], (String) obj [2] , (String) obj [3] , (int) obj [4], (String) obj [5], (String) obj [6], (String) obj [7], (String) obj [8] , (String) obj [9], (String) obj [10] , (String) obj [11], (String) obj [12], (String) obj [13], (String) obj [14], 
                    //       (String) obj [15], (String) obj [16], (String) obj [17], (String) obj [18], (String) obj [19], (String) obj [20], (String) obj [21], (String) obj [22], (String) obj [23], (String) obj [24], (String) obj [25], (String) obj [26], (int) obj [27], (int) obj [28], (Integer) obj [29], (String) obj [30], 
                    //            (Date) obj  [30], (Integer) obj [31],(Date) obj [32], (Integer) obj  [33],(Date) obj [34], (Float) obj [35], (Date) obj [36],(Date) obj [37], (Date) obj [38],(Integer) obj [39], (Date) obj [40], (Integer) obj[41])
                    insTaskDet.add(insuDet);
                }
                System.out.println("======Result size======" + insTaskDet.size());
            } catch (ParseException ex) {
                System.out.println("======error======");
                Logger.getLogger(SSTaskCreationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            return insTaskDet;
    }
    }
