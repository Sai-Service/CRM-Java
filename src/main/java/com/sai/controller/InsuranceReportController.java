/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;
import com.sai.dao.SsInsTaskHistoryDao;
import com.sai.dto.SSInsTaskContactYN;
import com.sai.model.insurance.SsInsuranceDetails;
import com.sai.report.InsExcelGenerator;
import com.sai.service.SSTaskCreationService;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ins")
public class InsuranceReportController {
    
      
        @Autowired
    private SSTaskCreationService service;
        
        
        @Autowired
    private SsInsTaskHistoryDao insHistory;
        
        
     
     @GetMapping(value = "/download/SS_Insurance_Report.xlsx")
    public ResponseEntity<InputStreamResource> generateInsuDetaiReport(@RequestParam Map<String, String> map) throws Exception {
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
            List<SsInsuranceDetails> insDet = null;
            insDet = service.findByInsDetailConditions(map);///dao.methodname with parameter
         
            in = InsExcelGenerator.generateInsuDetaiReport(insDet, fromDate, toDate);
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
    
    
     @GetMapping(value = "/download/TodaygenSSInsTaskContactY.xlsx/{locId}")
    public ResponseEntity<InputStreamResource> genSSInsTaskContactY(@PathVariable Integer locId) throws Exception {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
           //    long locId = 0;
           List<SSInsTaskContactYN> insTask = null;
            insTask = insHistory.getInsContYCustDetails(locId);
            
            if (insTask.size() > 0)
            {
            in = InsExcelGenerator.getInsContYCustDetails(insTask);
             headers.add("Content-Disposition", "attachment; filename=TodaygenSSInsTaskContactY.xlsx");
            }
            else
            {
            return ResponseEntity
                .ok()
                .headers(headers)
                .body(null);
            }
        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
    
//========================================================================================================================================================
    
     @GetMapping(value = "/download/TodaygenSSInsTaskContactN.xlsx/{locId}")
    public ResponseEntity<InputStreamResource> genSSInsTaskContactN(@PathVariable Integer locId) throws Exception {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
           //    long locId = 0;
           List<SSInsTaskContactYN> insTask = null;
            insTask = insHistory.getInsContNCustDetails(locId);
              
            if (insTask.size() > 0)
            {
          in = InsExcelGenerator.getInsContNCustDetails(insTask);
            headers.add("Content-Disposition", "attachment; filename=TodaygenSSInsTaskContactN.xlsx");
    }
            else
            {
            return ResponseEntity
                .ok()
                .headers(headers)
                .body(null);
            }
            
        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
 
    //=================================================================================================================================================
    
      @GetMapping(value = "/download/TodaygenSSInsApptTakenY.xlsx/{locId}")
    public ResponseEntity<InputStreamResource> genSSInsApptTakenY(@PathVariable Integer locId) throws Exception {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
           //    long locId = 0;
           List<SSInsTaskContactYN> insTask = null;
            insTask = insHistory.getInsApptYDetails(locId);
            
              if (insTask.size() > 0)
            {
         in = InsExcelGenerator.getInsApptYCustDetails(insTask);
         headers.add("Content-Disposition", "attachment; filename=TodaygenSSInsApptTakenY.xlsx");

    }
            else
            {
            return ResponseEntity
                .ok()
                .headers(headers)
                .body(null);
            }
          
            
        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
      //=================================================================================================================================================
    
      @GetMapping(value = "/download/TodaygenSSInsApptTakenN.xlsx/{locId}")
    public ResponseEntity<InputStreamResource> genSSInsApptTakenN(@PathVariable Integer locId) throws Exception {
        ByteArrayInputStream in = null;
        HttpHeaders headers = new HttpHeaders();
        try {
           //    long locId = 0;
           List<SSInsTaskContactYN> insTask = null;
            insTask = insHistory.getInsApptNDetails(locId);
            
           
                
              if (insTask.size() > 0)
            {
            in = InsExcelGenerator.getInsApptNCustDetails(insTask);
            headers.add("Content-Disposition", "attachment; filename=TodaygenSSInsApptTakenN.xlsx");
             }
            else
            {
            return ResponseEntity
                .ok()
                .headers(headers)
                .body(null);
            }
        
            
        } catch (Exception ex) {
           // Logger.getLogger(CrmReportController.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }
    
}
