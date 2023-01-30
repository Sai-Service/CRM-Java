/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

/**
 *
 * @author Lenovo
 */
@Service
public class CrmReportsImpl {
    
    @Autowired
    protected DataSource localDataSource;
    
    public ByteArrayInputStream getCrmDtls(Map<String, Object> parameters, String fileNme) throws Exception {
        //  File file = ResourceUtils.getFile("classpath:SparesIssueDetailsReport11.jrxml");
        File file = ResourceUtils.getFile("classpath:CrmRep1.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        java.sql.Connection con = localDataSource.getConnection();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
        JRXlsExporter exporter = new JRXlsExporter();

        SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
        configuration.setOnePagePerSheet(false);
        configuration.setDetectCellType(true);
        // configuration.setCollapseRowSpan(false);
        configuration.setWhitePageBackground(false);
        configuration.setRemoveEmptySpaceBetweenColumns(true);
        configuration.setRemoveEmptySpaceBetweenRows(true);
        configuration.setWhitePageBackground(false);
        configuration.setCollapseRowSpan(true);
        configuration.setIgnoreGraphics(false);
        configuration.setWrapText(false);
        configuration.setPrintHeaderMargin(10);

        //File outputFile = new File(fileNme);
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArray));
        exporter.setConfiguration(configuration);
        exporter.exportReport();
        con.close();
        byte[] bytes = byteArray.toByteArray();
        return new ByteArrayInputStream(bytes);

    }

    //getCrmApptDtls
            
public ByteArrayInputStream getCrmApptDtls(Map<String, Object> parameters, String fileNme) throws Exception {
       
        File file = ResourceUtils.getFile("classpath:CrmAppointmentDtls.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        java.sql.Connection con = localDataSource.getConnection();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
        JRXlsExporter exporter = new JRXlsExporter();

        SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
        configuration.setOnePagePerSheet(false);
        configuration.setDetectCellType(true);
        // configuration.setCollapseRowSpan(false);
        configuration.setWhitePageBackground(false);
        configuration.setRemoveEmptySpaceBetweenColumns(true);
        configuration.setRemoveEmptySpaceBetweenRows(true);
        configuration.setWhitePageBackground(false);
        configuration.setCollapseRowSpan(true);
        configuration.setIgnoreGraphics(false);
        configuration.setWrapText(false);
        configuration.setPrintHeaderMargin(10);

        //File outputFile = new File(fileNme);
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArray));
        exporter.setConfiguration(configuration);
        exporter.exportReport();
        con.close();
        byte[] bytes = byteArray.toByteArray();
        return new ByteArrayInputStream(bytes);

    }         

public ByteArrayInputStream getCrmInsRepDtls(Map<String, Object> parameters, String fileNme) throws Exception {
       
        File file = ResourceUtils.getFile("classpath:CrmInsuRep.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        java.sql.Connection con = localDataSource.getConnection();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
        JRXlsExporter exporter = new JRXlsExporter();

        SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
        configuration.setOnePagePerSheet(false);
        configuration.setDetectCellType(true);
        // configuration.setCollapseRowSpan(false);
        configuration.setWhitePageBackground(false);
        configuration.setRemoveEmptySpaceBetweenColumns(true);
        configuration.setRemoveEmptySpaceBetweenRows(true);
        configuration.setWhitePageBackground(false);
        configuration.setCollapseRowSpan(true);
        configuration.setIgnoreGraphics(false);
        configuration.setWrapText(false);
        configuration.setPrintHeaderMargin(10);

        //File outputFile = new File(fileNme);
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArray));
        exporter.setConfiguration(configuration);
        exporter.exportReport();
        con.close();
        byte[] bytes = byteArray.toByteArray();
        return new ByteArrayInputStream(bytes);

    }         

public ByteArrayInputStream getVehHistPdf(Map<String, Object> parameters, String fileNme) throws Exception {

         //  File file = ResourceUtils.getFile("classpath:\\serviceHistory\\SS_SERVICE_HISTORY.jrxml");
       //   File subFile = ResourceUtils.getFile("classpath:\\serviceHistory\\SS_SERVICE_HIS_DTLS.jrxml");
        File file = ResourceUtils.getFile("classpath://serviceHistory//SS_SERVICE_HISTORY.jrxml");//linux
      File subFile = ResourceUtils.getFile("classpath://serviceHistory//SS_SERVICE_HIS_DTLS.jrxml");//linux

        System.out.println("VehicleHistory" + file.getAbsolutePath());
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JasperReport subJasperReport = JasperCompileManager.compileReport(subFile.getAbsolutePath());
        parameters.put("subreportParameter", subJasperReport);
        parameters.put("Subreport1", file.getParent() + "//SS_SERVICE_HIS_DTLS.jasper");
     //     parameters.put("Subreport1", file.getParent() + "\\SS_SERVICE_HIS_DTLS.jasper");
        java.sql.Connection con = localDataSource.getConnection();
        //JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(gpList);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
        byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
        con.close();
        return new ByteArrayInputStream(bytes);

    }
        
}
