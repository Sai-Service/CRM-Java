/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.report;

import com.sai.dto.SSInsTaskContactYN;
import com.sai.model.insurance.SsInsTaskDetails;
import com.sai.model.insurance.SsInsuranceDetails;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Test
 */
public class InsExcelGenerator {
    
    
       
    public static void main(String args[]) {
        try {
            ExcelGenerator.generateSimpleReport();
        } catch (Exception ex) {
            Logger.getLogger(ExcelGenerator.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
     }
    
    
    public static ByteArrayInputStream generateInsuDetaiReport(List<SsInsuranceDetails> insdet, String fromDate, String toDate) throws Exception {
        String[] COLUMNs = {"custId", "miNo",  "insCompName",  "policyNo",  "year",  "insType",  "idvAmt",  "prmAmt", "claimAmt",  "remark",  "financeCompName",  "policyType",  "exShowPrice",  "endorsementTaken",  "policyRenewType", 
       "policySubType",  "dealerName",  "currentNCB",  "driverCover",  "legalLibNoPer",  "driverCoverPremium",  "typeOfCustomer", "paymentMode",  "accountNo",  "bankBranch",  "bankName",  "status",  "orgId",  "locId",  "id",  "vehicleNo", 
              "insStDate",  "insPeriod",  "insEndDt",  "claimCount",  "remittanceDate",  "paymentAmt",  "paymentDate", "inactiveDate",  "creationDt",  "createdBy", "lstUpdationDt",  "lstUpdatedby"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("Insurance Details REPORT");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("INSURANCE DETAILS END DATEWISE REPORT");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            cell2.setCellValue("From Date : " + fromDate + "      -      To Date: " + toDate);
            cell2.setCellStyle(headerCellStyle1);

            sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, COLUMNs.length));
            sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, COLUMNs.length));

            //------------------------------------------------------------------------------
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            headerCellStyle.setAlignment(HorizontalAlignment.LEFT);
            //   headerCellStyle.setFillBackgroundColor(IndexedColors.BLUE.getIndex());

            Font rowFont = workbook.createFont();
            CellStyle rowCellStyle = workbook.createCellStyle();
            rowCellStyle.setFont(rowFont);
            rowCellStyle.setAlignment(HorizontalAlignment.LEFT);

            // Row for Header
            Row headerRow = sheet.createRow(3);

            // Header
            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
            }
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("d/m/yyyy hh:mm"));
            CellStyle cs = workbook.createCellStyle();
            cs.setWrapText(true);
            int rowIdx = 4;
            for (SsInsuranceDetails InsDetM : insdet) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(InsDetM.getCustId());
                row.createCell(1).setCellValue(InsDetM.getMiNo());
                row.createCell(2).setCellValue(InsDetM.getInsCompName());
                row.createCell(3).setCellValue(InsDetM.getPolicyNo());
                row.createCell(4).setCellValue(InsDetM.getYear());
                row.createCell(5).setCellValue(InsDetM.getInsType());
                row.createCell(6).setCellValue(InsDetM.getIdvAmt());
                row.createCell(7).setCellValue(InsDetM.getPrmAmt());
                row.createCell(8).setCellValue(InsDetM.getClaimAmt());
                row.createCell(9).setCellValue(InsDetM.getRemark());
                row.createCell(10).setCellValue(InsDetM.getFinanceCompName());
                row.createCell(11).setCellValue(InsDetM.getPolicyType());
                row.createCell(12).setCellValue(InsDetM.getExShowPrice());
                row.createCell(13).setCellValue(InsDetM.getEndorsementTaken());
                
                row.createCell(14).setCellValue(InsDetM.getPolicyRenewType());
                row.createCell(15).setCellValue(InsDetM.getPolicySubType());
                row.createCell(16).setCellValue(InsDetM.getDealerName());
                row.createCell(17).setCellValue(InsDetM.getCurrentNCB());
                row.createCell(18).setCellValue(InsDetM.getDriverCover());
                row.createCell(19).setCellValue(InsDetM.getLegalLibNoPer());
                row.createCell(20).setCellValue(InsDetM.getDriverCoverPremium());
                row.createCell(21).setCellValue(InsDetM.getTypeOfCustomer());
                row.createCell(22).setCellValue(InsDetM.getPaymentMode());
                row.createCell(23).setCellValue(InsDetM.getAccountNo());
                row.createCell(24).setCellValue(InsDetM.getBankBranch());
                row.createCell(25).setCellValue(InsDetM.getBankName());
                row.createCell(26).setCellValue(InsDetM.getStatus());
                row.createCell(27).setCellValue(InsDetM.getOrgId());
                row.createCell(28).setCellValue(InsDetM.getLocId());
                row.createCell(29).setCellValue(InsDetM.getId());
                row.createCell(30).setCellValue(InsDetM.getVehicleNo());
                row.createCell(31).setCellValue(InsDetM.getInsStDate());
                row.createCell(32).setCellValue(InsDetM.getInsPeriod());
                row.createCell(33).setCellValue(InsDetM.getInsEndDt());
                row.createCell(34).setCellValue(InsDetM.getClaimAmt());
                row.createCell(35).setCellValue(InsDetM.getRemittanceDate());
                if(InsDetM.getPaymentAmt() == null)
                {
                    row.createCell(36).setCellValue(0); 
                }
                else
                {
                    row.createCell(36).setCellValue(InsDetM.getPaymentAmt());
               
                }
                 
                row.createCell(37).setCellValue(InsDetM.getPaymentDate());
                row.createCell(38).setCellValue(InsDetM.getInactiveDate());
                row.createCell(39).setCellValue(InsDetM.getCreationDt());
                row.createCell(40).setCellValue(InsDetM.getCreatedBy());
                row.createCell(41).setCellValue(InsDetM.getLstUpdationDt());
                row.createCell(42).setCellValue(InsDetM.getLstUpdatedby());
           
            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    
   ////------------------------------------------------------------------------------------------------------------------------------------------------------
 
       public static ByteArrayInputStream getInsContYCustDetails(List<SSInsTaskContactYN> insTask) throws Exception {
        String[] COLUMNs = {"Task Id", "Customer Id", "Vehicle No", "Event Name", "Call Due Date", "Insurance End Date", "Event Status", "Appointment Status", "Remark", "Disposition", "Appointment Date", "Assignee Id", "Customer Status", "Insurance Type", "Contact No"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("Contacted");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("Todays Contacted Customer List");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            cell2.setCellValue("Report Run Date" +  Calendar.getInstance().getTime());
            cell2.setCellStyle(headerCellStyle1);

            sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, COLUMNs.length));
            sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, COLUMNs.length));

            //------------------------------------------------------------------------------
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            headerCellStyle.setAlignment(HorizontalAlignment.LEFT);
            //   headerCellStyle.setFillBackgroundColor(IndexedColors.BLUE.getIndex());

            Font rowFont = workbook.createFont();
            CellStyle rowCellStyle = workbook.createCellStyle();
            rowCellStyle.setFont(rowFont);
            rowCellStyle.setAlignment(HorizontalAlignment.LEFT);

            // Row for Header
            Row headerRow = sheet.createRow(3);

            // Header
            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
            }
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("d/m/yyyy hh:mm"));
            CellStyle cs = workbook.createCellStyle();
            cs.setWrapText(true);
            int rowIdx = 4;
            for (SSInsTaskContactYN ssInsTask : insTask) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(ssInsTask.getTaskId());
                row.createCell(1).setCellValue(ssInsTask.getCustId());
                row.createCell(2).setCellValue(ssInsTask.getVehicleNo());
                row.createCell(3).setCellValue(ssInsTask.getEventName());
                Cell Callduedt = row.createCell(4);
                Callduedt.setCellValue(ssInsTask.getCallDueDt());
                Callduedt.setCellStyle(dateCellStyle);
                
               // row.createCell(4).setCellValue(ssInsTask.getInsEndDate());
                Cell InsEndDate = row.createCell(5);
                InsEndDate.setCellValue(ssInsTask.getInsEndDate());
                InsEndDate.setCellStyle(dateCellStyle);
                row.createCell(6).setCellValue(ssInsTask.getEventStatus());
                row.createCell(7).setCellValue(ssInsTask.getApptYN());
                row.createCell(8).setCellValue(ssInsTask.getRemark());
                row.createCell(9).setCellValue(ssInsTask.getDisposition());
                row.createCell(10).setCellValue(ssInsTask.getApptDate());
                
                row.createCell(11).setCellValue(ssInsTask.getAssignId());
                row.createCell(12).setCellValue(ssInsTask.getCustStatus());
                row.createCell(13).setCellValue(ssInsTask.getInsType());
                row.createCell(14).setCellValue(String.valueOf(ssInsTask.getContactNo()));
              
           
                 if(ssInsTask.getApptDate() == null)
                {
                    row.createCell(9).setCellValue(0); 
                }
                else
                {
                Cell ApptDate = row.createCell(9);
                ApptDate.setCellValue(ssInsTask.getApptDate());
                ApptDate.setCellStyle(dateCellStyle);
               
                }
                
                
                row.createCell(10).setCellValue(ssInsTask.getAssignId());
                row.createCell(11).setCellValue(ssInsTask.getCustStatus());
                row.createCell(12).setCellValue(ssInsTask.getInsType());
               // row.createCell(13).setCellValue(ssInsTask.getContactYN());
            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
 //=====================================================================================================================================================
      
      
      public static ByteArrayInputStream getInsContNCustDetails(List<SSInsTaskContactYN> insTask) throws Exception {
        String[] COLUMNs = {"Appointment_Id", "Vehicle_No", "Service_Type", "Service_Loc", "Service_Group", "Appointment_Date", "Time_Slot", "Appointment_Status", "Pickup", "Amount", "Pick_Address", "Remark", "LastDesposition", "Appt_Atteneded"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("UnContacted");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("Today's Uncontaced Customer List");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            cell2.setCellValue("Report Run Date" +  Calendar.getInstance().getTime());
            cell2.setCellStyle(headerCellStyle1);

            sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, COLUMNs.length));
            sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, COLUMNs.length));

            //------------------------------------------------------------------------------
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            headerCellStyle.setAlignment(HorizontalAlignment.LEFT);
            //   headerCellStyle.setFillBackgroundColor(IndexedColors.BLUE.getIndex());

            Font rowFont = workbook.createFont();
            CellStyle rowCellStyle = workbook.createCellStyle();
            rowCellStyle.setFont(rowFont);
            rowCellStyle.setAlignment(HorizontalAlignment.LEFT);

            // Row for Header
            Row headerRow = sheet.createRow(3);

            // Header
            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
            }
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("d/m/yyyy hh:mm"));
            CellStyle cs = workbook.createCellStyle();
            cs.setWrapText(true);
            int rowIdx = 4;
            for (SSInsTaskContactYN ssInsTask : insTask) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(ssInsTask.getTaskId());
                row.createCell(1).setCellValue(ssInsTask.getCustId());
                row.createCell(2).setCellValue(ssInsTask.getVehicleNo());
             //   row.createCell(3).setCellValue(ssInsTask.getCallduedt());
                Cell Callduedt = row.createCell(3);
                Callduedt.setCellValue(ssInsTask.getCallDueDt());
                Callduedt.setCellStyle(dateCellStyle);
                
               // row.createCell(4).setCellValue(ssInsTask.getInsEndDate());
                Cell InsEndDate = row.createCell(4);
                InsEndDate.setCellValue(ssInsTask.getInsEndDate());
                InsEndDate.setCellStyle(dateCellStyle);
                row.createCell(5).setCellValue(ssInsTask.getEventStatus());
                row.createCell(6).setCellValue(ssInsTask.getApptYN());
                row.createCell(7).setCellValue(ssInsTask.getRemark());
                row.createCell(8).setCellValue(ssInsTask.getDisposition());
                row.createCell(9).setCellValue(ssInsTask.getApptDate());
              
           
                 if(ssInsTask.getApptDate() == null)
                {
                    row.createCell(9).setCellValue(0); 
                }
                else
                {
                Cell ApptDate = row.createCell(9);
                ApptDate.setCellValue(ssInsTask.getApptDate());
                ApptDate.setCellStyle(dateCellStyle);
               
                }
                
                
                row.createCell(10).setCellValue(ssInsTask.getAssignId());
                row.createCell(11).setCellValue(ssInsTask.getCustStatus());
                row.createCell(12).setCellValue(ssInsTask.getInsType());
               // row.createCell(13).setCellValue(ssInsTask.getContactYN());
            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
 //===================================================================================================================================================
      
        public static ByteArrayInputStream getInsApptYCustDetails(List<SSInsTaskContactYN> insTask) throws Exception {
        String[] COLUMNs = {"Appointment_Id", "Vehicle_No", "Service_Type", "Service_Loc", "Service_Group", "Appointment_Date", "Time_Slot", "Appointment_Status", "Pickup", "Amount", "Pick_Address", "Remark", "LastDesposition", "Appt_Atteneded"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("Appoinment Taken");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("Today Appoinment Taken Customer List");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            cell2.setCellValue("Report Run Date" +  Calendar.getInstance().getTime());
            cell2.setCellStyle(headerCellStyle1);

            sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, COLUMNs.length));
            sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, COLUMNs.length));

            //------------------------------------------------------------------------------
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            headerCellStyle.setAlignment(HorizontalAlignment.LEFT);
            //   headerCellStyle.setFillBackgroundColor(IndexedColors.BLUE.getIndex());

            Font rowFont = workbook.createFont();
            CellStyle rowCellStyle = workbook.createCellStyle();
            rowCellStyle.setFont(rowFont);
            rowCellStyle.setAlignment(HorizontalAlignment.LEFT);

            // Row for Header
            Row headerRow = sheet.createRow(3);

            // Header
            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
            }
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("d/m/yyyy hh:mm"));
            CellStyle cs = workbook.createCellStyle();
            cs.setWrapText(true);
            int rowIdx = 4;
            for (SSInsTaskContactYN ssInsTask : insTask) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(ssInsTask.getTaskId());
                row.createCell(1).setCellValue(ssInsTask.getCustId());
                row.createCell(2).setCellValue(ssInsTask.getVehicleNo());
             //   row.createCell(3).setCellValue(ssInsTask.getCallduedt());
                Cell Callduedt = row.createCell(3);
                Callduedt.setCellValue(ssInsTask.getCallDueDt());
                Callduedt.setCellStyle(dateCellStyle);
                
               // row.createCell(4).setCellValue(ssInsTask.getInsEndDate());
                Cell InsEndDate = row.createCell(4);
                InsEndDate.setCellValue(ssInsTask.getInsEndDate());
                InsEndDate.setCellStyle(dateCellStyle);
                row.createCell(5).setCellValue(ssInsTask.getEventStatus());
                row.createCell(6).setCellValue(ssInsTask.getApptYN());
                row.createCell(7).setCellValue(ssInsTask.getRemark());
                row.createCell(8).setCellValue(ssInsTask.getDisposition());
                row.createCell(9).setCellValue(ssInsTask.getApptDate());
              
           
                 if(ssInsTask.getApptDate() == null)
                {
                    row.createCell(9).setCellValue(0); 
                }
                else
                {
                Cell ApptDate = row.createCell(9);
                ApptDate.setCellValue(ssInsTask.getApptDate());
                ApptDate.setCellStyle(dateCellStyle);
               
                }
                
                
                row.createCell(10).setCellValue(ssInsTask.getAssignId());
                row.createCell(11).setCellValue(ssInsTask.getCustStatus());
                row.createCell(12).setCellValue(ssInsTask.getInsType());
//                row.createCell(13).setCellValue(ssInsTask.getContactYN());
            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
  //=================================================================================================================================================
         public static ByteArrayInputStream getInsApptNCustDetails(List<SSInsTaskContactYN> insTask) throws Exception {
        String[] COLUMNs = {"Appointment_Id", "Vehicle_No", "Service_Type", "Service_Loc", "Service_Group", "Appointment_Date", "Time_Slot", "Appointment_Status", "Pickup", "Amount", "Pick_Address", "Remark", "LastDesposition", "Appt_Atteneded"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("Appoinment not Taken");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("Today Appoinment not Taken Customer List");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            cell2.setCellValue("Report Run Date" +  Calendar.getInstance().getTime());
            cell2.setCellStyle(headerCellStyle1);

            sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, COLUMNs.length));
            sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, COLUMNs.length));

            //------------------------------------------------------------------------------
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            headerCellStyle.setAlignment(HorizontalAlignment.LEFT);
            //   headerCellStyle.setFillBackgroundColor(IndexedColors.BLUE.getIndex());

            Font rowFont = workbook.createFont();
            CellStyle rowCellStyle = workbook.createCellStyle();
            rowCellStyle.setFont(rowFont);
            rowCellStyle.setAlignment(HorizontalAlignment.LEFT);

            // Row for Header
            Row headerRow = sheet.createRow(3);

            // Header
            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
            }
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("d/m/yyyy hh:mm"));
            CellStyle cs = workbook.createCellStyle();
            cs.setWrapText(true);
            int rowIdx = 4;
            for (SSInsTaskContactYN ssInsTask : insTask) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(ssInsTask.getTaskId());
                row.createCell(1).setCellValue(ssInsTask.getCustId());
                row.createCell(2).setCellValue(ssInsTask.getVehicleNo());
             //   row.createCell(3).setCellValue(ssInsTask.getCallduedt());
                Cell Callduedt = row.createCell(3);
                Callduedt.setCellValue(ssInsTask.getCallDueDt());
                Callduedt.setCellStyle(dateCellStyle);
                
               // row.createCell(4).setCellValue(ssInsTask.getInsEndDate());
                Cell InsEndDate = row.createCell(4);
                InsEndDate.setCellValue(ssInsTask.getInsEndDate());
                InsEndDate.setCellStyle(dateCellStyle);
                row.createCell(5).setCellValue(ssInsTask.getEventStatus());
                row.createCell(6).setCellValue(ssInsTask.getApptYN());
                row.createCell(7).setCellValue(ssInsTask.getRemark());
                row.createCell(8).setCellValue(ssInsTask.getDisposition());
                row.createCell(9).setCellValue(ssInsTask.getApptDate());
              
           
                 if(ssInsTask.getApptDate() == null)
                {
                    row.createCell(9).setCellValue(0); 
                }
                else
                {
                Cell ApptDate = row.createCell(9);
                ApptDate.setCellValue(ssInsTask.getApptDate());
                ApptDate.setCellStyle(dateCellStyle);
               
                }
                
                
                row.createCell(10).setCellValue(ssInsTask.getAssignId());
                row.createCell(11).setCellValue(ssInsTask.getCustStatus());
                row.createCell(12).setCellValue(ssInsTask.getInsType());
//                row.createCell(13).setCellValue(ssInsTask.getContactYN());
            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
