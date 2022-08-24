/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.dao.ProformaHeaderDao;
import com.sai.dao.SSAdministratorDataDao;
import com.sai.dao.SSGatepassAllDao;
import com.sai.dao.SSTaskCreationDao;
import com.sai.dao.SsTaskGenDao;
import com.sai.model.SSGatepassAll;
import com.sai.model.SSTaskGen;
import com.sai.model.SsTaskDetails;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Test
 */
@RestController
public class SsTaskGenController {

    @Autowired
    private SsTaskGenDao taskGenImpl;

    @Autowired
    private SSTaskCreationDao taskCreation;

    @Autowired
    private SSAdministratorDataDao adminSumm;

    @Autowired
    private SSGatepassAllDao gatePassAll;
    
    @Autowired
    private ProformaHeaderDao proformHead;

    @RequestMapping(value = "/getTasksGeneration", method = RequestMethod.GET, produces = {"application/JSON"})
    public List<SSTaskGen> getTasksGeneration() throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
        List<Map> map = taskGenImpl.getTasksGeneration();
//        SSTaskGen pojo = mapper.convertValue(map, SSTaskGen.class);

        List<SSTaskGen> pojos = new ArrayList<SSTaskGen>();

        for (Map<String, Object> objectMap : map) {
            SSTaskGen pojo = new SSTaskGen();

            for (Map.Entry<String, Object> property : objectMap.entrySet()) {

                if (property.getValue() != null) {
                    Method setter = SSTaskGen.class.getMethod("set" + property.getKey().substring(0, 1).toUpperCase()
                            + property.getKey().substring(1), property.getValue().getClass());
                    setter.invoke(pojo, property.getValue());
                }
                if (property.getValue() == null) {
                    String fieldName = property.getKey();
                    Class c = Class.forName("com.sai.model.SSTaskGen");
                    Field field = c.getDeclaredField(fieldName);
                    Type type = field.getGenericType();
                    Class c1 = Class.forName(field.getType().getTypeName());
                    Method setter = SSTaskGen.class.getMethod("set" + property.getKey().substring(0, 1).toUpperCase() + property.getKey().substring(1), c1);
                    setter.invoke(pojo, property.getValue());
                }

            }
            pojos.add(pojo);

        }

        for (SSTaskGen task : pojos) {
            SsTaskDetails details = new SsTaskDetails();
            //  details.setTask_id(task.getTask_id());
            //\    details.setTaskId(task.getTask_id());
            details.setTaskType(task.getTASK_TYPE());
            details.setTaskStatus(task.getSTATUS());
            // details.setApptmtId();
            details.setCallDuDt(task.getCALL_DUE_DATE());
            details.setCustId(task.getCust_id());
          //  details.setCustName(task.getCust_name());
            details.setCustAdd(task.getCust_address1());
            details.setContactPerson(task.getContact_person());
          //  details.setCustType(task.getCust_type());
            details.setContactNo1(String.valueOf(task.getContact_no1()));
            details.setContactNo2(task.getContact_no2());
            details.setEmailAdd(task.getEmail_id());
            details.setVehicleNo(task.getVeh_no());
//            details.setChassisNo(task.getChassis_no());
//            details.setEngineNo(task.getEngine_no());
//            details.setModel(task.getModel());
//            details.setDtOfPurchase(task.getDate_of_purchase());
//            details.setDealerCode(task.getDealer_code());
//            details.setAmc(task.getAMC());
            details.setSalesExecName(task.getSales_exec_name());
            details.setLocId(task.getLoc_id());
            details.setOrgId(task.getOrg_id());
            details.setReferenceNo(task.getREFERENCE_NO());
            details.setServcGrp(task.getServc_grp());
            details.setInventoryItemId(task.getItem_id());
            details.setContacted(task.getContacted());
            details.setReason(task.getReason());
            details.setRemarks(task.getRemarks());
            details.setTaskReason(task.getTask_reason());
            if (task.getLast_servc_dt() != null) {
                details.setLastServcDt(task.getLast_servc_dt());
            }
            details.setLastServcType(task.getLast_servc_type());
            details.setLastServcLoc(task.getService_loc());
            details.setLastServcKm(task.getLast_km());
            if (task.getNext_servc_dt() != null) {
                details.setNextServcDt(task.getNext_servc_dt());
            }
            details.setNextServcType(task.getNext_servc_type());
            details.setCreationDate(task.getCreation_date());
            details.setCreatedBy(Integer.parseInt(task.getCreated_by()));
            details.setLastUpdateDate(task.getLast_update_date());
            details.setLastUpdatedBy(Integer.parseInt(task.getLast_updated_by()));
            //   details.setLstUpLogin(Integer.parseInt(task.getLast_updated_by()));
            details.setAttribute1(task.getAttribute1());
            details.setAttribute2(task.getAttribute2());
            details.setAttribute3(task.getAttribute3());
            details.setAttribute4(task.getAttribute4());
            details.setAttribute5(task.getAttribute5());
            details.setCustAdd(task.getCust_name());
            details.setCustType(task.getCust_type());
            
         //   details.setServDuDt(task.getSERVICE_DUE_DT());
     //       details.setDelvDt(task.getDELIVERY_DATE());

            // SsTaskDetails details = new SsTaskDetails();
            SsTaskDetails sd1 = taskCreation.save(details);
            ////////////////////ENTER DATA IN THE ADMINISTRATOR TABLE//////////////////////////   
//            SsAdministratorData adminData = new SsAdministratorData();
//
//            adminData.setTaskType(task.getTASK_TYPE());
//            adminData.setCustName(task.getCust_name());
//            adminData.setCustType(task.getCust_type());
//            adminData.setContactNo(String.valueOf(task.getContact_no1()));
//            adminData.setVehicleNo(task.getVeh_no());
//            adminData.setCheckFlag("N");
//            adminData.setServcType(task.getAttribute1());
//            adminData.setCallDueDt(task.getCALL_DUE_DATE());
//            if (task.getSERVICE_DUE_DT() != null) {
//                adminData.setServDueTo(task.getSERVICE_DUE_DT());
//            }
//            adminData.setStatus(task.getSTATUS());
//            adminData.setCreationDt(task.getCreation_date());
//            adminData.setCreatedBy(Integer.parseInt(task.getCreated_by()));
//            adminData.setLstUpdDt(task.getLast_update_date());
//            adminData.setLstUpdLogin(Integer.parseInt(task.getLast_updated_by()));
//            adminData.setTaskId(sd1.getTaskId());
//            adminData.setOrgid(task.getOrg_id());
//            adminData.setServcLoc(task.getService_loc());
//
//            adminSumm.save(adminData);

            SSGatepassAll ssGtPass = gatePassAll.findByGatepassId(task.getGatepassId().longValue());
            //  SSGatepassAll ssGtPass = new SSGatepassAll();
            ssGtPass.setTaskId(new Integer((int) sd1.getTaskId()));
            ssGtPass.setInterStatus("Data Generated Successfully");
            gatePassAll.save(ssGtPass);

            //   ssGtPass.getTaskId()
        }
        return pojos;
    }
    
    
    
    @RequestMapping(value = "/NewPost", method = RequestMethod.GET, produces = {"application/JSON"})
    public  List<SSTaskGen>  postProformaCall() throws Exception {
       // SaiResponse apiResponse = null;
        try {

            List<Map> input=taskGenImpl.getTasksGenPrfMysql();
            
              for (Map task : input) {
            SsTaskDetails details = new SsTaskDetails();
            details.setTaskType((String)task.get("TASK_TYPE"));
            details.setTaskStatus((String)task.get("STATUS"));
            details.setCallDuDt((Date)task.get("CALL_DUE_DATE"));
            details.setCustId((Integer)task.get("custAcctNo"));
            details.setCustAdd((String)task.get("cust_address1"));
            details.setContactPerson((String)task.get("contact_person"));
            details.setVehicleNo("1");
            String conNo1St = null;
          if(task.get("contact_no1")!=null)
            {
                BigInteger conNo1=(BigInteger)task.get("contact_no1");
               conNo1St=  conNo1.toString();
            
            }
            details.setContactNo1(conNo1St);
            details.setContactNo2((String)task.get("contact_no2"));
            details.setEmailAdd((String)task.get("email_id"));
         //   details.setVehicleNo((String)task.get("Veh_no"));
            details.setSalesExecName((String)task.get("sales_exec_name"));
            details.setLocId((Integer)task.get("loc_id"));
            details.setOrgId((Integer)task.get("org_id"));
            details.setReferenceNo(((BigInteger)task.get("REFERENCE_NO")).toString());
           //     details.set((String)task.get("REFERENCE_NO"));
            //details.setServcGrp(task.getServc_grp());
          //  details.setInventoryItemId(task.getItem_id());
          //  details.setContacted(task.getContacted());
          //  details.setReason(task.getReason());
          //  details.setRemarks(task.getRemarks());
          //  details.setTaskReason(task.getTask_reason());
          //  details.setLastServcLoc(task.getService_loc());
          //  details.setLastServcKm(task.getLast_km());
            details.setCreationDate((Date)task.get("creation_date"));
            details.setCreatedBy(1);
            details.setLastUpdateDate((Date)task.get("creation_date"));
            details.setLastUpdatedBy(1);
            
            SsTaskDetails sd1 = taskCreation.save(details);
          
            proformHead.updateTaskId(sd1.getTaskId(),((BigInteger)task.get("REFERENCE_NO")).toString());
         

        }
      
            
           // apiResponse = new SaiResponse(200, " Order Inserted Successfully Done", orderNo);

        } catch (Exception e) {
            e.printStackTrace();
          //  apiResponse = new SaiResponse(400, "Error while inserting Order ", e.getMessage());
        }
        return null;

    }
 

    
}


 //private BigInteger contact_no1;
