/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.report;

import com.sai.dto.SsTaskReport;
import com.sai.model.PendingApptCurDate;
import com.sai.model.SSAppoinmentDetails;
import com.sai.model.SSGatepassAll;
import com.sai.model.SsTaskDetails;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.BorderExtent;
import org.apache.poi.ss.usermodel.BorderStyle;

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
import org.apache.poi.ss.util.PropertyTemplate;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Swaroopcomp
 */
public class ExcelGenerator {

    public static ByteArrayInputStream generateTaskReport(List<SsTaskDetails> tasks) throws IOException {
        String[] COLUMNs = {"Task Id", "Task Type", "Task Status", "Apptmt Id", "Call Du Dt", "Cust Name", "Cust Add", "Contact Person", "Cust Type", "Contact No", "Vehicle No", "Contacted", "Reason", "Remarks", "Creation Date ", "Created By", "Last Update Date ", "Last Updated By", "Last Update Login", "Org Id1", "Email Add", "Contact No2", "Cust Id", "Chasis No", "Dealer Code", "Model", "Engine No", "Date Of Purchase", "Amc", "Task Reason", "Sales Exec Name", "Item Id", "Last Servc Dt", "Last Servc Type", "Last Servc Loc", "Last Servc Km", "Servc Grp", "Next Servc Dt", "Next Servc Type"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("SS TASK DETAIL REPORT");

            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("SS TASK DETAIL REPORT");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            cell2.setCellValue("From Date : 01-JAN-2020             To Date  : 10-JAN-2020");
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

            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("d/m/yy h:mm"));

            // Row for Header
            Row headerRow = sheet.createRow(3);

            // Header
            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
            }

            // CellStyle for Age row.createCell(0).
            CellStyle ageCellStyle = workbook.createCellStyle();
            ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

            CellStyle cs = workbook.createCellStyle();
            cs.setWrapText(true);

            int rowIdx = 4;
            for (SsTaskDetails task : tasks) {
                Row row = sheet.createRow(rowIdx++);
                // row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(task.getTaskId());
                row.createCell(1).setCellValue(task.getTaskType());
                row.createCell(2).setCellValue(task.getTaskStatus());
                row.createCell(3).setCellValue(task.getApptmtId());
                System.out.println("============Call due date====" + task.getCallDuDt());
                Cell cellDueDate = row.createCell(4);
                cellDueDate.setCellValue(task.getCallDuDt());
                cellDueDate.setCellStyle(dateCellStyle);

                //          row.createCell(5).setCellValue(task.getCustName());
                row.createCell(5).setCellValue("");
                Cell cellAddress = row.createCell(6);
                cellAddress.setCellValue(task.getCustAdd());
                cellAddress.setCellStyle(cs);

                row.createCell(7).setCellValue(task.getContactPerson());
                //    row.createCell(8).setCellValue(task.getCustType());
                row.createCell(8).setCellValue("");
                row.createCell(9).setCellValue(task.getContactNo1());
                row.createCell(10).setCellValue(task.getVehicleNo());
                row.createCell(11).setCellValue(task.getContacted());
                row.createCell(12).setCellValue(task.getReason());
                row.createCell(13).setCellValue(task.getRemarks());
                if (task.getCreationDate() != null) {
                    row.createCell(14).setCellValue(simpleDateFormat.format(task.getCreationDate()));
                } else {
                    row.createCell(14).setCellValue("NULL");
                }
                row.createCell(15).setCellValue(task.getCreatedBy());
                if (task.getLastUpdateDate() != null) {
                    row.createCell(16).setCellValue(simpleDateFormat.format(task.getLastUpdateDate()));
                } else {
                    row.createCell(16).setCellValue("NULL");
                }

                row.createCell(17).setCellValue(task.getLastUpdateDate());
                row.createCell(18).setCellValue(task.getLastUpdatedBy());
                row.createCell(19).setCellValue(task.getOrgId());
                row.createCell(20).setCellValue(task.getEmailAdd());
                row.createCell(21).setCellValue(task.getContactNo2());
                row.createCell(22).setCellValue(task.getCustId());
                row.createCell(23).setCellValue(task.getVehicleNo());
                row.createCell(24).setCellValue("");//task.getDealerCode());
                row.createCell(25).setCellValue("");//task.getModel());
                row.createCell(26).setCellValue("");//task.getEngineNo());
                row.createCell(27).setCellValue("");//task.getDtOfPurchase());
                row.createCell(28).setCellValue("");//task.getAmc());
                row.createCell(29).setCellValue(task.getTaskReason());
                row.createCell(30).setCellValue(task.getSalesExecName());
                row.createCell(31).setCellValue(task.getInventoryItemId());
                row.createCell(32).setCellValue(task.getLastServcDt());
                row.createCell(33).setCellValue(task.getLastServcType());
                row.createCell(34).setCellValue(task.getLastServcLoc());
                row.createCell(35).setCellValue(task.getLastServcKm());
                row.createCell(36).setCellValue(task.getServcGrp());
                row.createCell(37).setCellValue(task.getNextServcDt());
                row.createCell(38).setCellValue(task.getNextServcType());

            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);

            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    public static ByteArrayInputStream generateTaskReportWithAssignee(List<SsTaskReport> tasks, String fromDate, String toDate) throws IOException {
        {
            String[] COLUMNs = {"Task Id", "Call Due Date", "Customer Id ", "Customer Name", "Customer Address", "Contact Person", "Customer Type", "Contact No1", "Contact No2", "Email ", "Vehicle No", "Chasis No", "Engine No", "Model", "Contacted", "Reason", "Remarks", "Task Reason", "Last Service Datet", "Last Service Type", "Last Service Location", "Last Service Km", "Next Service Date", "Next Service Type", "Call For Service", "Assignee", "Assignee Id"};
            try (
                    Workbook workbook = new XSSFWorkbook();
                    ByteArrayOutputStream out = new ByteArrayOutputStream();) {
                CreationHelper createHelper = workbook.getCreationHelper();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
                Sheet sheet = workbook.createSheet("SS TASK -ASSIGNEE REPORT");

                Font headerFont1 = workbook.createFont();
                headerFont1.setBold(true);
                headerFont1.setColor(IndexedColors.BLACK.getIndex());

                CellStyle headerCellStyle1 = workbook.createCellStyle();
                headerCellStyle1.setFont(headerFont1);
                headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

                Row row1 = sheet.createRow(1);
                Cell cell1 = row1.createCell(1);
                cell1.setCellValue("SS TASK - ASSIGNEE REPORT");
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
                for (SsTaskReport task : tasks) {
                    Row row = sheet.createRow(rowIdx++);
                    row.setRowStyle(rowCellStyle);
                    row.createCell(0).setCellValue(task.getTaskId());
                    //  row.createCell(1).setCellValue(task.getCallDuDt());
                    Cell cellDueDate = row.createCell(1);
                    cellDueDate.setCellValue(task.getCallDuDt());
                    cellDueDate.setCellStyle(dateCellStyle);
                    row.createCell(2).setCellValue(task.getCustId());
                    row.createCell(3).setCellValue(task.getCustName());
                    Cell cellAddress = row.createCell(4);
                    cellAddress.setCellValue(task.getCustAdd());
                    cellAddress.setCellStyle(cs);

                    row.createCell(5).setCellValue(task.getContactPerson());
                    row.createCell(6).setCellValue(task.getCustType());
                    row.createCell(7).setCellValue(task.getContactNo1());
                    row.createCell(8).setCellValue(task.getContactNo2());

                    row.createCell(9).setCellValue(task.getEmailAdd());
                    row.createCell(10).setCellValue(task.getVehicleNo());
                    row.createCell(11).setCellValue(task.getChassisNo());
                    row.createCell(12).setCellValue(task.getEngineNo());
                    row.createCell(13).setCellValue(task.getModel());
                    row.createCell(14).setCellValue(task.getContacted());
                    row.createCell(15).setCellValue(task.getReason());
                    row.createCell(16).setCellValue(task.getRemarks());
                    row.createCell(17).setCellValue(task.getTaskReason());

                    // row.createCell(18).setCellValue(task.getLstServDt());
                    Cell cellLstDate = row.createCell(18);
                    cellLstDate.setCellValue(task.getLstServDt());
                    cellLstDate.setCellStyle(dateCellStyle);
                    row.createCell(19).setCellValue(task.getLstServType());
                    row.createCell(20).setCellValue(task.getLstServLoc());
                    if(task.getLstKm()!=null){
                    row.createCell(21).setCellValue(task.getLstKm());
                    }
                    //        row.createCell(22).setCellValue(task.getNxtServDt());
                    Cell cellNxtDate = row.createCell(22);
                    cellNxtDate.setCellValue(task.getNxtServDt());
                    cellNxtDate.setCellStyle(dateCellStyle);

                    row.createCell(23).setCellValue(task.getNxtServType());
                    row.createCell(24).setCellValue(task.getCallForService());
                    row.createCell(25).setCellValue(task.getAssignee());
                    row.createCell(26).setCellValue(task.getAssigneeId());
                }
                for (int col = 0; col < COLUMNs.length; col++) {
                    sheet.autoSizeColumn(col);
                }
                workbook.write(out);
                return new ByteArrayInputStream(out.toByteArray());
            }
        }
    }

    public static ByteArrayInputStream generateAppointmentReport(List<SSAppoinmentDetails> appts, String fromDate, String toDate) throws Exception {
        String[] COLUMNs = {"Appointment_Id", "Vehicle_No", "Service_Type", "Service_Loc", "Service_Group", "Appointment_Date", "Time_Slot", "Appointment_Status", "Pickup", "Amount", "Pick_Address", "Remark", "LastDesposition", "Appt_Atteneded"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("APPOINTMENT REPORT");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("APPOINTMENT REPORT");
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
            for (SSAppoinmentDetails appt : appts) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(appt.getAppmntId());
                row.createCell(1).setCellValue(appt.getVehicleNo());
                row.createCell(2).setCellValue(appt.getServType());
                row.createCell(3).setCellValue(appt.getServLoc());
                row.createCell(4).setCellValue(appt.getServGroup());
                Cell apptDate = row.createCell(5);
                apptDate.setCellValue(appt.getApptDate());
                apptDate.setCellStyle(dateCellStyle);
                row.createCell(6).setCellValue(appt.getApptTimeSlot());
                row.createCell(7).setCellValue(appt.getApptStatus());
                row.createCell(8).setCellValue(appt.getPickUp());
                if (appt.getAmount() != null) {
                    row.createCell(9).setCellValue(appt.getAmount());
                }
                row.createCell(10).setCellValue(appt.getPickAdd());
                row.createCell(11).setCellValue(appt.getRemark());
                row.createCell(12).setCellValue(appt.getLastDesposition());
                row.createCell(13).setCellValue(appt.getApptAttended());
            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    /////////////////////////PENDING APPOINMENTS CURRENT DATE////
    public static ByteArrayInputStream generatPendingAppCurDateReport(List<PendingApptCurDate> pendingappt) throws Exception {
        String[] COLUMNs = {"Appointment_Id", "Vehicle_No", "Service_Type", "Service_Loc", "Service_Group", "Appointment_Date", "Time_Slot", "Appointment_Status", "Pickup", "Amount", "Pick_Address", "Remark", "LastDesposition", "Appt_Atteneded"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("APPOINTMENT REPORT");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("APPOINTMENT REPORT");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            //     cell2.setCellValue("From Date : " +  + "      -      To Date: " + toDate);
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
            for (PendingApptCurDate appt : pendingappt) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(appt.getAppmntId());
                row.createCell(1).setCellValue(appt.getVehicleNo());
                row.createCell(2).setCellValue(appt.getContactPerson());
                row.createCell(3).setCellValue(appt.getContactNo1());
                row.createCell(4).setCellValue(appt.getContactNo2());
                row.createCell(5).setCellValue(appt.getServType());
                row.createCell(6).setCellValue(appt.getServLoc());
                row.createCell(7).setCellValue(appt.getServGroup());
                row.createCell(8).setCellValue(appt.getAdvName());
                Cell apptDate = row.createCell(9);
                apptDate.setCellValue(appt.getApptDate());
                apptDate.setCellStyle(dateCellStyle);
                row.createCell(10).setCellValue(appt.getapptTimeSlot());
                row.createCell(11).setCellValue(appt.getApptStatus());
                row.createCell(12).setCellValue(appt.getPickUp());
                row.createCell(13).setCellValue(appt.getPickupMms());
                row.createCell(14).setCellValue(appt.getPickupTime());
                row.createCell(15).setCellValue(appt.getAmount());
                row.createCell(16).setCellValue(appt.getPickAdd());
                row.createCell(17).setCellValue(appt.getRemark());
                row.createCell(18).setCellValue(appt.getLastDesposition());
                row.createCell(19).setCellValue(appt.getApptAttended());
            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    public static ByteArrayInputStream generatetEventWiseReport(List<SsTaskReport> events) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ByteArrayInputStream generatetExceptionReport(List<Map> sgatepassSumm, List<SSGatepassAll> gatePassList) throws Exception {

        String[] COLUMNs = {"Sr No.", "Organization Id", "Location Id", "Task Not Generated", "Task Generated"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet1 = workbook.createSheet("All City Summary");
            Sheet sheet2 = workbook.createSheet("All City Details");
            //Font
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.CENTER);

            Row row1 = sheet1.createRow(1);
            Cell cell1 = row1.createCell(0);
            cell1.setCellValue("Sai Service Private Limited");
            cell1.setCellStyle(headerCellStyle1);

            sheet1.addMergedRegion(new CellRangeAddress(1, 1, 0, COLUMNs.length));

            Row row2 = sheet1.createRow(2);
            Row row3 = sheet1.createRow(3);

            Cell r3c1 = row3.createCell(0);
            r3c1.setCellValue("Summary Exception Report -Gatepass and Task Generation");
            r3c1.setCellStyle(headerCellStyle1);

            sheet1.addMergedRegion(new CellRangeAddress(3, 3, 0, COLUMNs.length));

            Row row4 = sheet1.createRow(4);

            Row row5 = sheet1.createRow(5);
            Cell r5c1 = row5.createCell(0);
            r5c1.setCellValue("Report Run Date : " + Calendar.getInstance().getTime());
            r5c1.setCellStyle(headerCellStyle1);
            sheet1.addMergedRegion(new CellRangeAddress(5, 5, 0, COLUMNs.length));
            Row row6 = sheet1.createRow(6);

            //------------------------------------------------------------------------------
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
            headerCellStyle.setFillBackgroundColor(IndexedColors.BLUE.getIndex());

            Font rowFont = workbook.createFont();
            CellStyle rowCellStyle = workbook.createCellStyle();
            rowCellStyle.setFont(rowFont);
            rowCellStyle.setAlignment(HorizontalAlignment.LEFT);

            // Row for Header
            Row headerRow = sheet1.createRow(7);

            // Header
            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
            }

            int rowIdx = 8;
            int srNo = 1;

            for (Map map1 : sgatepassSumm) {
                Row row = sheet1.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(srNo++);
                row.createCell(1).setCellValue((Integer) map1.get("org_id"));
                row.createCell(2).setCellValue((Integer) map1.get("loc_id"));
                row.createCell(3).setCellValue(((BigInteger) map1.get("TaskNotGen")).longValue());
                row.createCell(4).setCellValue(((BigInteger) map1.get("TaskGen")).longValue());

            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet1.autoSizeColumn(col);
            }
            PropertyTemplate pt = new PropertyTemplate();
            pt.drawBorders(new CellRangeAddress(7, 8 + sgatepassSumm.size() - 1, 0, COLUMNs.length - 1),
                    BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
            pt.drawBorders(new CellRangeAddress(7, 8 + sgatepassSumm.size() - 1, 0, COLUMNs.length - 1), BorderStyle.THIN, BorderExtent.INSIDE);
            pt.applyBorders(sheet1);

            //////////////////////////////////////////////////////////////////////////////////////Sheet -2 ..report
            String[] s2COLUMNs = {"ID", "Gatepasss ID", "Delivery Date", "Customer Name", "Customer ID", "Contact No", "Vehicle No", "Org ID", "Location Id", "Location Name", "Reference No", "Service Type", "Last KM", "Model", "Chassis", "Engine", "Department"};
            Row s2r1 = sheet2.createRow(1);
            Cell s2r1c1 = s2r1.createCell(0);
            s2r1c1.setCellValue("Sai Service Private Limited");
            s2r1c1.setCellStyle(headerCellStyle1);
            sheet2.addMergedRegion(new CellRangeAddress(1, 1, 0, s2COLUMNs.length));

            Row s2r2 = sheet2.createRow(2);

            Row s2r3 = sheet2.createRow(3);
            Cell s2r3c1 = s2r3.createCell(0);
            s2r3c1.setCellValue("Detail Exception Report -Gatepass and Task Generation");
            s2r3c1.setCellStyle(headerCellStyle1);
            sheet2.addMergedRegion(new CellRangeAddress(3, 3, 0, s2COLUMNs.length));

            Row s2r4 = sheet2.createRow(4);

            Row s2r5 = sheet2.createRow(5);
            Cell s2r5c1 = s2r5.createCell(0);
            s2r5c1.setCellValue("Report Run Date:-" + Calendar.getInstance().getTime());
            s2r5c1.setCellStyle(headerCellStyle1);
            sheet2.addMergedRegion(new CellRangeAddress(5, 5, 0, s2COLUMNs.length));

            Row s2r6 = sheet2.createRow(6);
            // Row for Header
            Row s2headerRow = sheet2.createRow(7);

            // Header
            for (int col = 0; col < s2COLUMNs.length; col++) {
                Cell cell = s2headerRow.createCell(col);
                cell.setCellValue(s2COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
            }

            rowIdx = 8;
            srNo = 1;

            for (SSGatepassAll gatePass : gatePassList) {
                Row s2Row = sheet2.createRow(rowIdx++);
                s2Row.setRowStyle(rowCellStyle);
                s2Row.createCell(0).setCellValue(srNo++);
                s2Row.createCell(1).setCellValue(gatePass.getGatepassId());
                s2Row.createCell(2).setCellValue(gatePass.getDeliveryDate());
                s2Row.createCell(3).setCellValue(gatePass.getCustName());
                s2Row.createCell(4).setCellValue(gatePass.getCustId());
                s2Row.createCell(5).setCellValue(gatePass.getContactNo());
                s2Row.createCell(6).setCellValue(gatePass.getVehNo());
                s2Row.createCell(7).setCellValue(gatePass.getOrgId());
                s2Row.createCell(8).setCellValue(gatePass.getLocId());
                s2Row.createCell(9).setCellValue(gatePass.getServLoc());
                s2Row.createCell(10).setCellValue(gatePass.getRefNo());
                s2Row.createCell(11).setCellValue(gatePass.getServType());
                s2Row.createCell(12).setCellValue(gatePass.getLastKM());
                s2Row.createCell(13).setCellValue(gatePass.getModel());
                s2Row.createCell(14).setCellValue(gatePass.getChassisNo());
                s2Row.createCell(15).setCellValue(gatePass.getEngineNo());
                s2Row.createCell(16).setCellValue(gatePass.getDeptCode());
            }
            for (int col = 0; col < s2COLUMNs.length; col++) {
                sheet2.autoSizeColumn(col);
            }
            PropertyTemplate pt2 = new PropertyTemplate();
            pt2.drawBorders(new CellRangeAddress(7, 8 + gatePassList.size() - 1, 0, s2COLUMNs.length - 1),
                    BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
            pt2.drawBorders(new CellRangeAddress(7, 8 + gatePassList.size(), 0, s2COLUMNs.length - 1), BorderStyle.THIN, BorderExtent.ALL);
            pt2.applyBorders(sheet2);

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }

    }

    public static ByteArrayInputStream generateSimpleReport() throws Exception {
        String[] COLUMNs = {"Sr No.", "Organization Id", "Location Id", "Task Not Generated", "Task Generated"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet1 = workbook.createSheet("Exception  Count");
            Sheet sheet2 = workbook.createSheet("Exception Details");
            //Font
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet1.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("Sai Service Private Limited");
            cell1.setCellStyle(headerCellStyle1);

            sheet1.addMergedRegion(new CellRangeAddress(1, 1, 1, COLUMNs.length));

            Row row2 = sheet1.createRow(2);
            Row row3 = sheet1.createRow(3);

            Cell r3c1 = row3.createCell(1);
            r3c1.setCellValue("Summary Exception Report -Gatepass and Task Generation");
            r3c1.setCellStyle(headerCellStyle1);

            Row row4 = sheet1.createRow(4);
            Row row5 = sheet1.createRow(5);
            Cell r5c1 = row2.createCell(1);
            r5c1.setCellValue("Report Run Date" + Calendar.getInstance().getTime());
            r5c1.setCellStyle(headerCellStyle1);

            Row row6 = sheet1.createRow(6);

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
            Row headerRow = sheet1.createRow(7);

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

            int rowIdx = 8;
            int srNo = 0;
            for (int i = 0; i < 5; i++) {
                Row row = sheet1.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(srNo++);
                row.createCell(1).setCellValue(1);
                row.createCell(2).setCellValue(2);
                row.createCell(3).setCellValue(3);
                row.createCell(4).setCellValue(4);

            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet1.autoSizeColumn(col);
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    public static void main(String args[]) {
        try {
            ExcelGenerator.generateSimpleReport();
        } catch (Exception ex) {
            Logger.getLogger(ExcelGenerator.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    //////////////////////////////ADMIN REPORT///////////////////////////////////////////////
    public static ByteArrayInputStream genHomePageClickApptReport(List<SSAppoinmentDetails> appts) throws Exception {
        String[] COLUMNs = {"Appointment_Id", "Vehicle_No", "Service_Type", "Service_Loc", "Service_Group", "Appointment_Date", "Time_Slot", "Appointment_Status", "Pickup", "Amount", "Pick_Address", "Remark", "LastDesposition", "Appt_Atteneded"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("APPOINTMENT REPORT");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("APPOINTMENT REPORT");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            cell2.setCellValue("Report Run Date" + Calendar.getInstance().getTime());
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
            for (SSAppoinmentDetails appt : appts) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(appt.getAppmntId());
                row.createCell(1).setCellValue(appt.getVehicleNo());
                row.createCell(2).setCellValue(appt.getServType());
                row.createCell(3).setCellValue(appt.getServLoc());
                row.createCell(4).setCellValue(appt.getServGroup());
                Cell apptDate = row.createCell(5);
                apptDate.setCellValue(appt.getApptDate());
                apptDate.setCellStyle(dateCellStyle);
                row.createCell(6).setCellValue(appt.getApptTimeSlot());
                row.createCell(7).setCellValue(appt.getApptStatus());
                row.createCell(8).setCellValue(appt.getPickUp());
                row.createCell(9).setCellValue(appt.getAmount());
                row.createCell(10).setCellValue(appt.getPickAdd());
                row.createCell(11).setCellValue(appt.getRemark());
                row.createCell(12).setCellValue(appt.getLastDesposition());
                row.createCell(13).setCellValue(appt.getApptAttended());
            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

//////////////////////////////EXECUTIVE REPORT///////////////////////////////////////////////
    public static ByteArrayInputStream genHomePageClickApptExewiseReport(List<SSAppoinmentDetails> appts) throws Exception {
        String[] COLUMNs = {"Appointment_Id", "Vehicle_No", "Service_Type", "Service_Loc", "Service_Group", "Appointment_Date", "Time_Slot", "Appointment_Status", "Pickup", "Amount", "Pick_Address", "Remark", "LastDesposition", "Appt_Atteneded"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("APPOINTMENT TAKEN REPORT");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("APPOINTMENT REPORT");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            cell2.setCellValue("Report Run Date" + Calendar.getInstance().getTime());
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
            for (SSAppoinmentDetails appt : appts) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(appt.getAppmntId());
                row.createCell(1).setCellValue(appt.getVehicleNo());
                row.createCell(2).setCellValue(appt.getServType());
                row.createCell(3).setCellValue(appt.getServLoc());
                row.createCell(4).setCellValue(appt.getServGroup());
                Cell apptDate = row.createCell(5);
                apptDate.setCellValue(appt.getApptDate());
                apptDate.setCellStyle(dateCellStyle);
                row.createCell(6).setCellValue(appt.getApptTimeSlot());
                row.createCell(7).setCellValue(appt.getApptStatus());
                row.createCell(8).setCellValue(appt.getPickUp());
                row.createCell(9).setCellValue(appt.getAmount());
                row.createCell(10).setCellValue(appt.getPickAdd());
                row.createCell(11).setCellValue(appt.getRemark());
                row.createCell(12).setCellValue(appt.getLastDesposition());
                row.createCell(13).setCellValue(appt.getApptAttended());
            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

//////////////////////////////////ADMIN HOME PAGE////////////////////////////////////////////
    public static ByteArrayInputStream genHomePageClickPickUpReport(List<SSAppoinmentDetails> appts) throws Exception {
        String[] COLUMNs = {"Appointment_Id", "Vehicle_No", "Service_Type", "Service_Loc", "Service_Group", "Appointment_Date", "Time_Slot", "Appointment_Status", "Pickup", "Amount", "Pick_Address", "Remark", "LastDesposition", "Appt_Atteneded"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("APPOINTMENT REPORT");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("Appoinment Taken today with PickUp REPORT");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            cell2.setCellValue("Report Run Date" + Calendar.getInstance().getTime());
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
            for (SSAppoinmentDetails appt : appts) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(appt.getAppmntId());
                row.createCell(1).setCellValue(appt.getVehicleNo());
                row.createCell(2).setCellValue(appt.getServType());
                row.createCell(3).setCellValue(appt.getServLoc());
                row.createCell(4).setCellValue(appt.getServGroup());
                Cell apptDate = row.createCell(5);
                apptDate.setCellValue(appt.getApptDate());
                apptDate.setCellStyle(dateCellStyle);
                row.createCell(6).setCellValue(appt.getApptTimeSlot());
                row.createCell(7).setCellValue(appt.getApptStatus());
                row.createCell(8).setCellValue(appt.getPickUp());
                row.createCell(9).setCellValue(appt.getAmount());
                row.createCell(10).setCellValue(appt.getPickAdd());
                row.createCell(11).setCellValue(appt.getRemark());
                row.createCell(12).setCellValue(appt.getLastDesposition());
                row.createCell(13).setCellValue(appt.getApptAttended());
            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    //////////////////////////////////EXECUTIVE HOME PAGE////////////////////////////////////////////
    public static ByteArrayInputStream genHomePageClickPickUpExeWiseReport(List<SSAppoinmentDetails> appts) throws Exception {
        String[] COLUMNs = {"Appointment_Id", "Vehicle_No", "Service_Type", "Service_Loc", "Service_Group", "Appointment_Date", "Time_Slot", "Appointment_Status", "Pickup", "Amount", "Pick_Address", "Remark", "LastDesposition", "Appt_Atteneded"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("Pick up REPORT");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("Appoinment Taken today with PickUp REPORT");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            cell2.setCellValue("Report Run Date" + Calendar.getInstance().getTime());
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
            for (SSAppoinmentDetails appt : appts) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(appt.getAppmntId());
                row.createCell(1).setCellValue(appt.getVehicleNo());
                row.createCell(2).setCellValue(appt.getServType());
                row.createCell(3).setCellValue(appt.getServLoc());
                row.createCell(4).setCellValue(appt.getServGroup());
                Cell apptDate = row.createCell(5);
                apptDate.setCellValue(appt.getApptDate());
                apptDate.setCellStyle(dateCellStyle);
                row.createCell(6).setCellValue(appt.getApptTimeSlot());
                row.createCell(7).setCellValue(appt.getApptStatus());
                row.createCell(8).setCellValue(appt.getPickUp());
                row.createCell(9).setCellValue(appt.getAmount());
                row.createCell(10).setCellValue(appt.getPickAdd());
                row.createCell(11).setCellValue(appt.getRemark());
                row.createCell(12).setCellValue(appt.getLastDesposition());
                row.createCell(13).setCellValue(appt.getApptAttended());
            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    //////////////////////ADMIN HOME PAGE////////////////////////////////////
    public static ByteArrayInputStream genGetUnContactedCustDetails(List<SsTaskDetails> ssTask) throws Exception {
        String[] COLUMNs = {"Task Type", "Task Status", "call Due Date", "customer Id", "Customer Name", "Customer Address", "Contact Person", "Customer Type", "contactNo1", "contactNo2", "Email Id", "Vehicle No", "Chassis No", "Engine No", "Model", "Purchase Date", "Dealer Code", "Reason", "Remarks", "Task Reason", "LastServ Date", "LastServ Type", "LastServ Loc", "Last Km", "NextServ Date", "NextServ Type"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("Uncontacted Customer Report");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("Uncontacted today Report");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            cell2.setCellValue("Report Run Date" + Calendar.getInstance().getTime());
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
            for (SsTaskDetails task : ssTask) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(task.getTaskType());
                row.createCell(1).setCellValue(task.getTaskStatus());
                Cell apptDate = row.createCell(2);
                apptDate.setCellStyle(dateCellStyle);
                apptDate.setCellValue(task.getCallDuDt());
                row.createCell(3).setCellValue(task.getCustId());
                row.createCell(4).setCellValue("");//task.getCustName());
                row.createCell(5).setCellValue(task.getCustAdd());
                row.createCell(6).setCellValue(task.getContactPerson());
                row.createCell(7).setCellValue("");//task.getCustType());
                row.createCell(8).setCellValue(task.getContactNo1());
                row.createCell(9).setCellValue(task.getContactNo2());
                row.createCell(10).setCellValue(task.getEmailAdd());
                row.createCell(11).setCellValue(task.getVehicleNo());
                row.createCell(12).setCellValue("");//task.getChassisNo());
                row.createCell(13).setCellValue("");//task.getEngineNo());

                row.createCell(14).setCellValue("");//task.getModel());
                Cell apptDate1 = row.createCell(15);
                apptDate1.setCellStyle(dateCellStyle);
                apptDate1.setCellValue("");//task.getDtOfPurchase());

                row.createCell(16).setCellValue("");//task.getDealerCode());
                row.createCell(17).setCellValue(task.getReason());
                row.createCell(18).setCellValue(task.getRemarks());
                row.createCell(19).setCellValue(task.getTaskReason());
                Cell apptDate2 = row.createCell(20);
                apptDate2.setCellStyle(dateCellStyle);
                apptDate2.setCellValue(task.getLastServcDt());

                row.createCell(21).setCellValue(task.getLastServcType());
                row.createCell(22).setCellValue(task.getLastServcLoc());
                row.createCell(23).setCellValue(task.getLastServcKm());
                Cell apptDate3 = row.createCell(24);
                apptDate3.setCellStyle(dateCellStyle);
                apptDate3.setCellValue(task.getNextServcDt());
                row.createCell(25).setCellValue(task.getNextServcType());

            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    //////////////////////EXECUTIVE HOME PAGE////////////////////////////////////
    public static ByteArrayInputStream genGetUnContactedCustExeWiseDetails(List<SsTaskDetails> ssTask) throws Exception {
        String[] COLUMNs = {"Task Type", "Task Status", "call Due Date", "customer Id", "Customer Name", "Customer Address", "Contact Person", "Customer Type", "contactNo1", "contactNo2", "Email Id", "Vehicle No", "Chassis No", "Engine No", "Model", "Purchase Date", "Dealer Code", "Reason", "Remarks", "Task Reason", "LastServ Date", "LastServ Type", "LastServ Loc", "Last Km", "NextServ Date", "NextServ Type"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("Uncontacted Customer Report");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("Uncontacted today Report");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            cell2.setCellValue("Report Run Date" + Calendar.getInstance().getTime());
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
            for (SsTaskDetails task : ssTask) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(task.getTaskType());
                row.createCell(1).setCellValue(task.getTaskStatus());
                Cell apptDate = row.createCell(2);
                apptDate.setCellStyle(dateCellStyle);
                apptDate.setCellValue(task.getCallDuDt());
                row.createCell(3).setCellValue(task.getCustId());
                row.createCell(4).setCellValue("");//task.getCustName());
                row.createCell(5).setCellValue(task.getCustAdd());
                row.createCell(6).setCellValue(task.getContactPerson());
                row.createCell(7).setCellValue("");//task.getCustType());
                row.createCell(8).setCellValue(task.getContactNo1());
                row.createCell(9).setCellValue(task.getContactNo2());
                row.createCell(10).setCellValue(task.getEmailAdd());
                row.createCell(11).setCellValue(task.getVehicleNo());
                row.createCell(12).setCellValue("");//task.getChassisNo());
                row.createCell(13).setCellValue("");//task.getEngineNo());

                row.createCell(14).setCellValue("");//task.getModel());
                Cell apptDate1 = row.createCell(15);
                apptDate1.setCellStyle(dateCellStyle);
                apptDate1.setCellValue("");//task.getDtOfPurchase());

                row.createCell(16).setCellValue("");//task.getDealerCode());
                row.createCell(17).setCellValue(task.getReason());
                row.createCell(18).setCellValue(task.getRemarks());
                row.createCell(19).setCellValue(task.getTaskReason());
                Cell apptDate2 = row.createCell(20);
                apptDate2.setCellStyle(dateCellStyle);
                apptDate2.setCellValue(task.getLastServcDt());

                row.createCell(21).setCellValue(task.getLastServcType());
                row.createCell(22).setCellValue(task.getLastServcLoc());
                row.createCell(23).setCellValue(task.getLastServcKm());
                Cell apptDate3 = row.createCell(24);
                apptDate3.setCellStyle(dateCellStyle);
                apptDate3.setCellValue(task.getNextServcDt());
                row.createCell(25).setCellValue(task.getNextServcType());

            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    ////////////////////////////ADMIN HOME PAGE REPORT/////////////////////////////////////////
    public static ByteArrayInputStream genGetContactedCustDetails(List<SsTaskDetails> ssTask) throws Exception {
        String[] COLUMNs = {"Task Type", "Task Status", "call Due Date", "customer Id", "Customer Name", "Customer Address", "Contact Person", "Customer Type", "contactNo1", "contactNo2", "Email Id", "Vehicle No", "Chassis No", "Engine No", "Model", "Purchase Date", "Dealer Code", "Reason", "Remarks", "Task Reason", "LastServ Date", "LastServ Type", "LastServ Loc", "Last Km", "NextServ Date", "NextServ Type"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("Contacted Customer Report");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("contacted today Report");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            cell2.setCellValue("Report Run Date" + Calendar.getInstance().getTime());
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
            for (SsTaskDetails task : ssTask) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(task.getTaskType());
                row.createCell(1).setCellValue(task.getTaskStatus());
                Cell apptDate = row.createCell(2);
                apptDate.setCellStyle(dateCellStyle);
                apptDate.setCellValue(task.getCallDuDt());
                row.createCell(3).setCellValue(task.getCustId());
                row.createCell(4).setCellValue("");//task.getCustName());
                row.createCell(5).setCellValue(task.getCustAdd());
                row.createCell(6).setCellValue(task.getContactPerson());
                row.createCell(7).setCellValue("");//task.getCustType());
                row.createCell(8).setCellValue(task.getContactNo1());
                row.createCell(9).setCellValue(task.getContactNo2());
                row.createCell(10).setCellValue(task.getEmailAdd());
                row.createCell(11).setCellValue(task.getVehicleNo());
                row.createCell(12).setCellValue("");//task.getChassisNo());
                row.createCell(13).setCellValue("");//task.getEngineNo());

                row.createCell(14).setCellValue("");//task.getModel());
                Cell apptDate1 = row.createCell(15);
                apptDate1.setCellStyle(dateCellStyle);
                apptDate1.setCellValue("");//task.getDtOfPurchase());

                row.createCell(16).setCellValue("");//task.getDealerCode());
                row.createCell(17).setCellValue(task.getReason());
                row.createCell(18).setCellValue(task.getRemarks());
                row.createCell(19).setCellValue(task.getTaskReason());
                Cell apptDate2 = row.createCell(20);
                apptDate2.setCellStyle(dateCellStyle);
                apptDate2.setCellValue(task.getLastServcDt());

                row.createCell(21).setCellValue(task.getLastServcType());
                row.createCell(22).setCellValue(task.getLastServcLoc());
                row.createCell(23).setCellValue(task.getLastServcKm());
                Cell apptDate3 = row.createCell(24);
                apptDate3.setCellStyle(dateCellStyle);
                apptDate3.setCellValue(task.getNextServcDt());
                row.createCell(25).setCellValue(task.getNextServcType());

            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    ////////////////////////////EXECUTIVE HOME PAGE REPORT/////////////////////////////////////////
    public static ByteArrayInputStream genGetContactedCustExeWiseDetails(List<SsTaskDetails> ssTask) throws Exception {
        String[] COLUMNs = {"Task Type", "Task Status", "call Due Date", "customer Id", "Customer Name", "Customer Address", "Contact Person", "Customer Type", "contactNo1", "contactNo2", "Email Id", "Vehicle No", "Chassis No", "Engine No", "Model", "Purchase Date", "Dealer Code", "Reason", "Remarks", "Task Reason", "LastServ Date", "LastServ Type", "LastServ Loc", "Last Km", "NextServ Date", "NextServ Type"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("contacted Customer Report");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("Contacted today Report");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            cell2.setCellValue("Report Run Date" + Calendar.getInstance().getTime());
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
            for (SsTaskDetails task : ssTask) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(task.getTaskType());
                row.createCell(1).setCellValue(task.getTaskStatus());
                Cell apptDate = row.createCell(2);
                apptDate.setCellStyle(dateCellStyle);
                apptDate.setCellValue(task.getCallDuDt());
                row.createCell(3).setCellValue(task.getCustId());
                row.createCell(4).setCellValue("");//task.getCustName());
                row.createCell(5).setCellValue(task.getCustAdd());
                row.createCell(6).setCellValue(task.getContactPerson());
                row.createCell(7).setCellValue("");//task.getCustType());
                row.createCell(8).setCellValue(task.getContactNo1());
                row.createCell(9).setCellValue(task.getContactNo2());
                row.createCell(10).setCellValue(task.getEmailAdd());
                row.createCell(11).setCellValue(task.getVehicleNo());
                row.createCell(12).setCellValue("");//task.getChassisNo());
                row.createCell(13).setCellValue("");//task.getEngineNo());

                row.createCell(14).setCellValue("");//task.getModel());
                Cell apptDate1 = row.createCell(15);
                apptDate1.setCellStyle(dateCellStyle);
                apptDate1.setCellValue("");//task.getDtOfPurchase());

                row.createCell(16).setCellValue("");//task.getDealerCode());
                row.createCell(17).setCellValue(task.getReason());
                row.createCell(18).setCellValue(task.getRemarks());
                row.createCell(19).setCellValue(task.getTaskReason());
                Cell apptDate2 = row.createCell(20);
                apptDate2.setCellStyle(dateCellStyle);
                apptDate2.setCellValue(task.getLastServcDt());

                row.createCell(21).setCellValue(task.getLastServcType());
                row.createCell(22).setCellValue(task.getLastServcLoc());
                row.createCell(23).setCellValue(task.getLastServcKm());
                Cell apptDate3 = row.createCell(24);
                apptDate3.setCellStyle(dateCellStyle);
                apptDate3.setCellValue(task.getNextServcDt());
                row.createCell(25).setCellValue(task.getNextServcType());

            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    ////////////////////////ADMIN PAGE//////////////////////////////////////////
    public static ByteArrayInputStream genGetTotalSMSSendDetails(List<SSAppoinmentDetails> appts) throws Exception {
        String[] COLUMNs = {"Appointment_Id", "Vehicle_No", "Service_Type", "Service_Loc", "Service_Group", "Appointment_Date", "Time_Slot", "Appointment_Status", "Pickup", "Amount", "Pick_Address", "Remark", "LastDesposition", "Appt_Atteneded"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("Total SMS Send Today REPORT");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("SMS send for acppoinment taken today with PickUp Report");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            cell2.setCellValue("Report Run Date" + Calendar.getInstance().getTime());
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
            for (SSAppoinmentDetails appt : appts) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(appt.getAppmntId());
                row.createCell(1).setCellValue(appt.getVehicleNo());
                row.createCell(2).setCellValue(appt.getServType());
                row.createCell(3).setCellValue(appt.getServLoc());
                row.createCell(4).setCellValue(appt.getServGroup());
                Cell apptDate = row.createCell(5);
                apptDate.setCellValue(appt.getApptDate());
                apptDate.setCellStyle(dateCellStyle);
                row.createCell(6).setCellValue(appt.getApptTimeSlot());
                row.createCell(7).setCellValue(appt.getApptStatus());
                row.createCell(8).setCellValue(appt.getPickUp());
                row.createCell(9).setCellValue(appt.getAmount());
                row.createCell(10).setCellValue(appt.getPickAdd());
                row.createCell(11).setCellValue(appt.getRemark());
                row.createCell(12).setCellValue(appt.getLastDesposition());
                row.createCell(13).setCellValue(appt.getApptAttended());
            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    ////////////////////////EXECUTIVE PAGE//////////////////////////////////////////
    public static ByteArrayInputStream genGetTotalSMSSendExewiseDetails(List<SSAppoinmentDetails> appts) throws Exception {
        String[] COLUMNs = {"Appointment_Id", "Vehicle_No", "Service_Type", "Service_Loc", "Service_Group", "Appointment_Date", "Time_Slot", "Appointment_Status", "Pickup", "Amount", "Pick_Address", "Remark", "LastDesposition", "Appt_Atteneded"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper createHelper = workbook.getCreationHelper();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
            Sheet sheet = workbook.createSheet("Total SMS Send Today REPORT");
            Font headerFont1 = workbook.createFont();
            headerFont1.setBold(true);
            headerFont1.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerCellStyle1 = workbook.createCellStyle();
            headerCellStyle1.setFont(headerFont1);
            headerCellStyle1.setAlignment(HorizontalAlignment.GENERAL);

            Row row1 = sheet.createRow(1);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue("SMS send for acppoinment taken today Report");
            cell1.setCellStyle(headerCellStyle1);

            Row row2 = sheet.createRow(2);
            Cell cell2 = row2.createCell(1);
            cell2.setCellValue("Report Run Date" + Calendar.getInstance().getTime());
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
            for (SSAppoinmentDetails appt : appts) {
                Row row = sheet.createRow(rowIdx++);
                row.setRowStyle(rowCellStyle);
                row.createCell(0).setCellValue(appt.getAppmntId());
                row.createCell(1).setCellValue(appt.getVehicleNo());
                row.createCell(2).setCellValue(appt.getServType());
                row.createCell(3).setCellValue(appt.getServLoc());
                row.createCell(4).setCellValue(appt.getServGroup());
                Cell apptDate = row.createCell(5);
                apptDate.setCellValue(appt.getApptDate());
                apptDate.setCellStyle(dateCellStyle);
                row.createCell(6).setCellValue(appt.getApptTimeSlot());
                row.createCell(7).setCellValue(appt.getApptStatus());
                row.createCell(8).setCellValue(appt.getPickUp());
                row.createCell(9).setCellValue(appt.getAmount());
                row.createCell(10).setCellValue(appt.getPickAdd());
                row.createCell(11).setCellValue(appt.getRemark());
                row.createCell(12).setCellValue(appt.getLastDesposition());
                row.createCell(13).setCellValue(appt.getApptAttended());
            }
            for (int col = 0; col < COLUMNs.length; col++) {
                sheet.autoSizeColumn(col);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

}
