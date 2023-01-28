/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.dao.SSAppoinmentDetailsDao;
import com.sai.dao.SSGatepassAllDao;
import com.sai.dao.SSTaskCreationDao;
import com.sai.dto.SsTaskReport;
import com.sai.impl.CrmReportsImpl;
import com.sai.model.PendingApptCurDate;
import com.sai.model.SSAppoinmentDetails;
import com.sai.model.SSGatepassAll;
//import com.sai.dto.SsTaskReport;
import com.sai.model.SsTaskDetails;
import com.sai.report.ExcelGenerator;
import com.sai.service.SSTaskCreationService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class CrmReportController {

    @Autowired
    private SSTaskCreationDao taskDao;
    
        @Autowired
    private SSTaskCreationService service;
        
        
    @Autowired
    private SSGatepassAllDao ssgatepass;
    
     @Autowired
    private  SSAppoinmentDetailsDao apptdetails;
     
      @Autowired
    private CrmReportsImpl crmRepService;
      
      @Value("${ReportFiles.path}")
    private String filesPath;

    @GetMapping(value = "/download/SS_Task_Detail_Report.xlsx")
    public ResponseEntity<InputStreamResource> excelTaskReport() throws IOException {
        List<SsTaskDetails> tasks = (List<SsTaskDetails>) taskDao.findAll();

        ByteArrayInputStream in = ExcelGenerator.generateTaskReport(tasks);
        // return IOUtils.toByteArray(in);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=SS_Task_Detail_Report.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
    

    @GetMapping(value = "/download/SS_Task_Assignee_Report.xlsx")
    public ResponseEntity<InputStreamResource> excelTaskAssigneeReport(@RequestParam Map<String, String> map) throws IOException {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
            String fromDate = null;
            String toDate = null;
            for (String searchKey : map.keySet()) {
                if (searchKey.equals("fromDate") ) {
                    fromDate = map.get("fromDate");
                    toDate = map.get("toDate");
                }
               
            }
            List<SsTaskReport> ssTaskReports = null;
            ssTaskReports = service.findTaskByConditions(map);
         
            in = ExcelGenerator.generateTaskReportWithAssignee(ssTaskReports, fromDate, toDate);
            headers.add("Content-Disposition", "attachment; filename=SS_Task_Assignee_Report.xlsx");

        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
    
     @GetMapping(value = "/download/SS_Task_Reason_Report.xlsx")
    public ResponseEntity<InputStreamResource> excelTaskReasonReport(@RequestParam String fromDate,@RequestParam String toDate ,@RequestParam Integer orgId,@RequestParam Integer locId,@RequestParam String reasonCode) throws IOException {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
       //     String fromDate = null;
        //    String toDate = null;
              
            List<SsTaskReport> ssTaskReports = null;
            ssTaskReports = service.findReasonWiseReport(fromDate,toDate,orgId,locId,reasonCode);
         
            in = ExcelGenerator.generateTaskReportWithAssignee(ssTaskReports, fromDate, toDate);
            headers.add("Content-Disposition", "attachment; filename=SS_Task_Reason_Report.xlsx");

        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }

@GetMapping(value = "/download/Appointment_Report.xlsx")
    public ResponseEntity<InputStreamResource> excelAppointmentReport(@RequestParam String fromDate,@RequestParam String toDate,@RequestParam Integer orgId,@RequestParam Integer locId) throws Exception {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
           
//            for (String searchKey : map.keySet()) {
//                if (searchKey.equals("fromDate") ) {
//                    fromDate = map.get("fromDate");
//                    toDate = map.get("toDate");
//                }
//            }
            List<SSAppoinmentDetails> appts = null;
            appts = service.findAppointmentReport(fromDate,toDate,orgId,locId);
         
            in = ExcelGenerator.generateAppointmentReport(appts, fromDate, toDate);
            headers.add("Content-Disposition", "attachment; filename=Appointment_Report.xlsx");

        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
    
@GetMapping(value = "/download/EventBased_Report.xlsx")
    public ResponseEntity<InputStreamResource> excelEventWiseReport(@RequestParam Map<String, String> map) throws Exception {
   
     ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
            List<Object> events = null;
            events = service.findEventWiseReport(map);
         
//            in = ExcelGenerator.generatetEventWiseReport(events);
//            headers.add("Content-Disposition", "attachment; filename=EventBased_Report.xlsx");

        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
            }
    ////////////////////////////for GATEPASS EXCEPTION REPORT Details//////////////////////////////
    @GetMapping(value = "/download/ExceptionGatepassDetailsRep.xlsx")
    public ResponseEntity<InputStreamResource> findGatepassExceptionReport() throws Exception {
   
     ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
            List<SSGatepassAll> sgatepass= ssgatepass.findGatepassExceptionReport();
            List<Map> sgatepassSumm = ssgatepass.getSummGPExceptionReport();
            
               in = ExcelGenerator.generatetExceptionReport(sgatepassSumm,sgatepass);
              headers.add("Content-Disposition", "attachment; filename=EventBased_Report.xlsx");

        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
            }
  
    ///////////////////pending appointment///////////////
    
      @GetMapping(value = "/download/TodayPendingAppt_Report.xlsx/{location}")
    public ResponseEntity<InputStreamResource> genPendingApptReport(@PathVariable Integer location) throws Exception {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
           //    long locId = 0;
            List<PendingApptCurDate> appts = null;
            appts = apptdetails.getPendingApptCurDate(location);
            
            in = ExcelGenerator.generatPendingAppCurDateReport(appts);
            headers.add("Content-Disposition", "attachment; filename=TodayPendingAppt_Report.xlsx");

        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
  
    
    
   
    ////////////////////////ADMIN DASH BOARD///////////////////////////////
    @GetMapping(value = "/download/OnClickTodayAppt_Report.xlsx/{locId}")
    public ResponseEntity<InputStreamResource> genHomePageClickApptReport(@PathVariable Integer locId) throws Exception {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
           //    long locId = 0;
            List<SSAppoinmentDetails> appts = null;
            appts = apptdetails.findByLocationIdtApptCntDetails(locId);
            
            in = ExcelGenerator.genHomePageClickApptReport(appts);
            headers.add("Content-Disposition", "attachment; filename=OnClickTodayAppt_Report.xlsx");

        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
    
    ////////////////////////EXECUTIVE DASH BOARD///////////////////////////////
    @GetMapping(value = "/download/OnClickTodayApptExeWise.xlsx/{apptAttended}")
    public ResponseEntity<InputStreamResource> genHomePageClickApptReport(@PathVariable String apptAttended) throws Exception {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
           //    long locId = 0;
            List<SSAppoinmentDetails> appts = null;
            appts = apptdetails.findByLocationIdtApptCntDetailsExewise(apptAttended);
            
            in = ExcelGenerator.genHomePageClickApptExewiseReport(appts);
            headers.add("Content-Disposition", "attachment; filename=OnClickTodayApptExeWise.xlsx");

        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
    
    
      @GetMapping(value = "/download/OnClickTodayPickUp_Report.xlsx/{locId}")
    public ResponseEntity<InputStreamResource> genHomePageClickPickUpReport(@PathVariable Integer locId) throws Exception {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
           //    long locId = 0;
            List<SSAppoinmentDetails> appts = null;
            appts = apptdetails.findByLocationIdApptPickup(locId);
            
            in = ExcelGenerator.genHomePageClickPickUpReport(appts);
            headers.add("Content-Disposition", "attachment; filename=OnClickTodayPickUp_Report.xlsx");

        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
    
  
         //////////////////////////////////////EXECUTIVE DASHBOARD////////////
    @GetMapping(value = "/download/OnClickTodayPickUpExecWise.xlsx/{apptAttended}")
    public ResponseEntity<InputStreamResource> genHomePageClickPickUpExecWise(@PathVariable String apptAttended) throws Exception {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
           //    long locId = 0;
            List<SSAppoinmentDetails> appts = null;
            appts = apptdetails.findByLocationIdApptPickupExecwise(apptAttended);
            
            in = ExcelGenerator.genHomePageClickPickUpExeWiseReport(appts);
            headers.add("Content-Disposition", "attachment; filename=OnClickTodayPickUpExecWise.xlsx");

        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
////////////////////////////////ADMIN HOME PAGE////////////////////
    @GetMapping(value = "/download/OnClickTodayGetUnContactedCustExewiseDetails.xlsx/{locId}")
    public ResponseEntity<InputStreamResource> genGetUnContactedCustDetails(@PathVariable int locId) throws Exception {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
           //    long locId = 0;
            List<SsTaskDetails> sstask = null;
            sstask = taskDao.getUnContactedCustDetails(locId);
            
            in = ExcelGenerator.genGetUnContactedCustDetails(sstask);
            headers.add("Content-Disposition", "attachment; filename=OnClickTodayGetUnContactedCustDetails.xlsx");

        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
    
    ///////////////////////////////EXECUTIVE HOME PAGE//////////////
       @GetMapping(value = "/download/GetUnContactedCustExewiseDetails.xlsx/{apptAttended}")
    public ResponseEntity<InputStreamResource> genGetUnContactedCustExewiseDetails(@PathVariable String apptAttended) throws Exception {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
           //    long locId = 0;
            List<SsTaskDetails> sstask = null;
            sstask = taskDao.getUnContactedCustDetailsExewise(apptAttended);
            
            in = ExcelGenerator.genGetUnContactedCustExeWiseDetails(sstask);
            headers.add("Content-Disposition", "attachment; filename=OnClickTodayGetUnContactedCustDetails.xlsx");

        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
    
    
    //////////////////////////ADMIN HOME PAGE///////////////////
    @GetMapping(value = "/download/OnClickTodayGetContactedCustDetails.xlsx/{locId}")
    public ResponseEntity<InputStreamResource> genGetContactedCustDetails(@PathVariable int locId) throws Exception {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
           //    long locId = 0;
            List<SsTaskDetails> sstask = null;
            sstask = taskDao.getContactedCustDetails(locId);
            
            in = ExcelGenerator.genGetContactedCustDetails(sstask);
            headers.add("Content-Disposition", "attachment; filename=OnClickTodayGetContactedCustDetails.xlsx");

        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
    
    //////////////////////////EXECUTIVE HOME PAGE///////////////////
    @GetMapping(value = "/download/TodayGetContactedCustExewiseDetails.xlsx/{apptAttended}")
    public ResponseEntity<InputStreamResource> genGetContactedCustExeWiseDetails(@PathVariable String apptAttended) throws Exception {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
           //    long locId = 0;
            List<SsTaskDetails> sstask = null;
            sstask = taskDao.getContactedCustDetailsExewise(apptAttended);
            
            in = ExcelGenerator.genGetContactedCustExeWiseDetails(sstask);
            headers.add("Content-Disposition", "attachment; filename=TodayGetContactedCustExewiseDetails.xlsx");

        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
  
    
    
    ///////////////////////ADMIN REPORT//////////////////////////////
    @GetMapping(value = "/download/OnClickTodayGetSMSSendDetails.xlsx/{locId}")
    public ResponseEntity<InputStreamResource> genGetTotalSMSSendDetails(@PathVariable Integer locId) throws Exception {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
           //    long locId = 0;
            List<SSAppoinmentDetails> appts = null;
            appts = taskDao.getTotalSMSSendDetails(locId);
            
            in = ExcelGenerator.genGetTotalSMSSendDetails(appts);
            headers.add("Content-Disposition", "attachment; filename=OnClickTodayGetSMSSendDetails.xlsx");

        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
    
     ///////////////////////EXECUTIVE REPORT//////////////////////////////
    @GetMapping(value = "/download/OnClickTodayGetSMSSendExeWiseDetails.xlsx/{apptAttended}")
    public ResponseEntity<InputStreamResource> genGetTotalSMSSendExeWiseDetails(@PathVariable String apptAttended) throws Exception {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
           //    long locId = 0;
            List<SSAppoinmentDetails> appts = null;
            appts = taskDao.getTotalSMSSendDetailsExewise(apptAttended);
            
            in = ExcelGenerator.genGetTotalSMSSendExewiseDetails(appts);
            headers.add("Content-Disposition", "attachment; filename=OnClickTodayGetSMSSendExeWiseDetails.xlsx");

        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
    
     @GetMapping("/CrmTaskDetails")
    public ResponseEntity<InputStreamResource> CrmTasDtlsRep(@RequestParam Date fromDate, @RequestParam Date toDate, @RequestParam Integer ouId,
            @RequestParam Integer locId) throws Exception {
        try {
            Map<String, Object> parameter = new HashMap<>();
            String fileName = null;
            fileName = filesPath + "CrmTaskDtls" + ouId + ".xls";
            parameter.put("fromDate", fromDate);
            parameter.put("toDate", toDate);
            parameter.put("ouId", ouId);
            parameter.put("locId", locId);
            ByteArrayInputStream in;
            try {
                in = crmRepService.getCrmDtls(parameter, fileName);
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Disposition", "attachment; filename=/download/" + fileName);
                return ResponseEntity
                        .ok()
                        .headers(headers)
                        .body(new InputStreamResource(in));
            } catch (Exception ex) {
                Logger.getLogger(this.getClass()
                        .getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            Logger.getLogger(CrmReportController.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return null;
    }
    
    
   @GetMapping("/vehHistory/{regNo}")
    public ResponseEntity<InputStreamResource> gatVehHis(@PathVariable String regNo) throws Exception {
        try {
            System.out.println("entered....");
            String fileName = "vehHistory " + regNo + ".pdf";
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("regNo", regNo);
            ByteArrayInputStream in;
            try {
               
                in = crmRepService.getVehHistPdf(parameter, fileName);
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Disposition", "attachment; filename=/download/" + fileName);
                return ResponseEntity
                        .ok()
                        .headers(headers)
                        .body(new InputStreamResource(in));
            } catch (Exception ex) {
                Logger.getLogger(this.getClass()
                        .getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            Logger.getLogger(CrmReportController.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;
    }
 
    
}
