package com.sai.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.sai.CommonDetail;
import com.sai.SaiResponse;
import com.sai.dao.SSGatepassAllDao;
import com.sai.dao.SsCustomerDao;
import com.sai.dao.SsInsuranceDetailsDao;
import com.sai.dao.SsSlotAvailableDao;
import com.sai.dao.SsVehicleMasterDao;
import com.sai.dao.UserLoginDao;
import com.sai.model.SSGatepassAll;
import com.sai.model.SsCustomer;
import com.sai.model.SsSlotAvailable;
import com.sai.model.SsVehicleMaster;
import com.sai.model.UserLogin;
import com.sai.model.insurance.SsInsuranceDetails;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.text.CaseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private SsSlotAvailableDao slotRepository;

    @Autowired
    private SSGatepassAllDao gatePassDao;

    @Autowired
    private SsCustomerDao customerDao;

    @Autowired
    private SsVehicleMasterDao vehicleDao;

    @Autowired
    private UserLoginDao userDao;

    @Autowired
    private SsInsuranceDetailsDao insuranceRepo;

    /////To UPload Slots
    @PostMapping("/uploadFile")
    public SaiResponse uploadFile(@RequestParam("file") MultipartFile file) {

        try {

            InputStream initialStream = new ByteArrayInputStream(file.getBytes());
            Reader reader = new InputStreamReader(initialStream);
            CSVParser parser = new CSVParser(reader, CSVFormat.INFORMIX_UNLOAD_CSV.withFirstRecordAsHeader().withIgnoreHeaderCase());
            List<CSVRecord> records = parser.getRecords();
            for (CSVRecord record : records) {

                Map<String, String> ssSlotDetails = record.toMap();
                ObjectMapper mapper = new ObjectMapper();
                mapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
                mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                SsSlotAvailable ssSlotAvailable = mapper.convertValue(ssSlotDetails, SsSlotAvailable.class);

                slotRepository.save(ssSlotAvailable);

            }

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return new SaiResponse(200, "OK", null);

    }

    @PostMapping("/InsuploadFile")
    public SaiResponse InsuploadFile(@RequestParam("file") MultipartFile file) {

        try {

            InputStream initialStream = new ByteArrayInputStream(file.getBytes());
            Reader reader = new InputStreamReader(initialStream);
            CSVParser parser = new CSVParser(reader, CSVFormat.INFORMIX_UNLOAD_CSV.withFirstRecordAsHeader().withIgnoreHeaderCase());
            List<CSVRecord> records = parser.getRecords();
            for (CSVRecord record : records) {

                Map<String, String> ssInsuDetails = record.toMap();
                for (Map.Entry<String, String> entry : ssInsuDetails.entrySet()) {
                    //  String updatedKey = CaseUtils.toCamelCase(entry.getKey(), false, new char[]{'_'});
                    if (entry.getKey().equalsIgnoreCase("remittanceDate") && entry.getValue().equalsIgnoreCase("NULL")) {
                        entry.setValue(null);
                    }
                    if (entry.getKey().equalsIgnoreCase("inactiveDate") && entry.getValue().equalsIgnoreCase("NULL")) {
                        entry.setValue(null);
                    }
                }
                ObjectMapper mapper = new ObjectMapper();
                mapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
                mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                SsInsuranceDetails insuranceDetails = mapper.convertValue(ssInsuDetails, SsInsuranceDetails.class);

                insuranceRepo.save(insuranceDetails);

            }

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return new SaiResponse(400, "Error while processing file", null);
        }

        return new SaiResponse(200, "OK", null);

    }

    @PostMapping("/uploadFile/getpass")
    public SaiResponse uploadFileGetPass(@RequestParam("file") MultipartFile file) {
        try {
            InputStream initialStream = new ByteArrayInputStream(file.getBytes());
            Reader reader = new InputStreamReader(initialStream);

            CSVParser parser = new CSVParser(reader, CSVFormat.INFORMIX_UNLOAD_CSV.withFirstRecordAsHeader().withIgnoreHeaderCase());

            List<CSVRecord> records = parser.getRecords();

            java.util.Date currentDate = Calendar.getInstance().getTime();

            long userId = 0;
            try {
                String username = new CommonDetail().getLoggedInUser();
                UserLogin user = userDao.findByUsername(username);
                userId = new Long(user.getUserId()).intValue();
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(TaskCreationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (CSVRecord record : records) {

                Map<String, String> recordMap = record.toMap();
                Map<String, String> ssGetPassDetails = new HashMap<String, String>();
                for (Map.Entry<String, String> entry : recordMap.entrySet()) {
                    String updatedKey = CaseUtils.toCamelCase(entry.getKey(), false, new char[]{'_'});
                    if (updatedKey.equalsIgnoreCase("deliveryDate")) {
                        Date date1 = new SimpleDateFormat("dd-mm-yyyy").parse(entry.getValue());
                        ssGetPassDetails.put(updatedKey, new SimpleDateFormat("yyyy-mm-dd").format(date1));
                    } else {
                        ssGetPassDetails.put(updatedKey, entry.getValue());
                    }
                }
                for (Map.Entry<String, String> entry : ssGetPassDetails.entrySet()) {
                    System.out.println("--" + entry.getKey() + "---" + entry.getValue());
                }
                //ssGetPassDetails.remove("gatepassId");
                ObjectMapper mapper = new ObjectMapper();
                mapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
                mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                mapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
                SSGatepassAll gatePass = mapper.convertValue(ssGetPassDetails, SSGatepassAll.class);
                gatePass.setCreatedBy(userId);

                gatePass.setCreationDate(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
                gatePass.setLstUpBy(userId);
                gatePass.setLstUpDate(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
                gatePassDao.save(gatePass);

                String vehicleNo = gatePass.getVehNo();
                if (vehicleNo != null) {

                    SsVehicleMaster vehicleCustomer = vehicleDao.findByVehicleNo(vehicleNo);
                    if (vehicleCustomer == null) {
                        System.out.println("--new customer entry for veh ----" + vehicleNo);
                        SsCustomer customer = new SsCustomer();
                        customer.setCreatedBy(new Long(userId).intValue());
                        customer.setCreationDate(currentDate);
                        customer.setCustName(gatePass.getCustName());
                        customer.setCustType(gatePass.getCustType());
                        customer.setAddress1(gatePass.getCustAddress1());
                        //    customer.setEmailId(gatePass.ge);
                        //  customer.setContactNo1(new BigInteger(gatePass.getContactNo()));
                        customer.setContactNo1(gatePass.getContactNo());

                        Integer custId = customerDao.findTopByInputTypeOrderByIdDesc("DMS").getCustId();
                        //  long count = Long.parseLong(custId.substring(3, custId.length()));
                        System.out.println("--new dms ----" + custId);
                        custId = custId + 1;
                        customer.setCustId(custId);
                        customer.setInputType("DMS");
                        customer.setCreatedBy(new Long(userId).intValue());
                        customer.setCreationDate(currentDate);
                        customer.setLastUpdatedBy(new Long(userId).intValue());
                        customer.setLastUpdationDate(currentDate);
                        SsCustomer customer1 = customerDao.save(customer);

                        SsVehicleMaster vehicle = new SsVehicleMaster();
                        vehicle.setCustId(customer1.getId());
                        vehicle.setVehicleNo(gatePass.getVehNo());
                        vehicle.setChassis(gatePass.getChassisNo());
                        vehicle.setEngine(gatePass.getEngineNo());
                        vehicle.setModel(gatePass.getModel());
                        vehicle.setDealerCode(gatePass.getEngineNo());
                        vehicle.setDtOfPurchase(new SimpleDateFormat("yyyy-mm-dd").parse(gatePass.getDeliveryDate()));
                        vehicle.setCreatedBy(new Long(userId).intValue());
                        vehicle.setCreationDt(currentDate);
                        vehicle.setLstUpdatedBy(new Long(userId).intValue());
                        vehicle.setLstUpdatedDt(currentDate);
                        vehicleDao.save(vehicle);
                    }
                } else {
                    System.out.println("-- customer entry for vehicle present----" + vehicleNo);
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return new SaiResponse(400, "Error while processing records", null);
        }
        return new SaiResponse(200, "OK", null);
    }

}
