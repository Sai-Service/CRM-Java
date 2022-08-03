/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.SaiResponse;
import java.util.List;
import com.sai.dao.SSGatepassAllDao;
import com.sai.model.SSGatepassAll;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Test
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SSGatepassAllController {

    @Autowired
    private SSGatepassAllDao gatepassRepository;

    @GetMapping("/sSGatepassAlls")
    public List<SSGatepassAll> getgPass() {
        return (List<SSGatepassAll>) gatepassRepository.findAll();
    }

    @PostMapping("/sSGatepassAlls")
    SaiResponse addUser(@RequestBody SSGatepassAll gpass) {
        SaiResponse apiResponse;
        try {
            gatepassRepository.save(gpass);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Gatepass not found", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    @PutMapping("/sSGatepassAlls/{id}")
    SaiResponse updategatepass(@RequestBody SSGatepassAll updatedgatepass, @PathVariable Long id) {
        SaiResponse apiResponse;
        Optional<SSGatepassAll> optionalgatepass = gatepassRepository.findById(updatedgatepass.getGatepassId());
        SSGatepassAll gatepass = optionalgatepass.isPresent() ? optionalgatepass.get() : null;
        if (gatepass != null) {
            BeanUtils.copyProperties(updatedgatepass, gatepass);
            gatepassRepository.save(gatepass);
        } else {
            apiResponse = new SaiResponse(400, "Gatepass not found", null);
        }
        apiResponse = new SaiResponse(200, "OK", gatepass);
        return apiResponse;
    }

    @DeleteMapping("/sSGatepassAlls/{id}")
    SaiResponse deletegatepass(@PathVariable Long id) {
        SaiResponse apiResponse;
        try {
            gatepassRepository.deleteById(id);
        } catch (Exception e) {
            apiResponse = new SaiResponse(400, "Not Deleted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }

    /*  @RequestMapping(value ="/opunits/names", method = RequestMethod.GET)
    public List<OpUnit> getOpUnitsNames() {
       List<OpUnit> objLists = UnitRepository.getUnitsNames();
       return objLists;
    }*/
    @GetMapping("/sSGatepassAlls/{id}")
    public SSGatepassAll getOpUnitById(@PathVariable Long id) {
        Optional<SSGatepassAll> optionalUser = gatepassRepository.findById(id);
        SSGatepassAll user = optionalUser.isPresent() ? optionalUser.get() : null;
        return user;
    }

    /////find by GatepassId NO///
    @GetMapping("/ssCustomers/GatepassId/{gatepass_id}")//////////////
    public SSGatepassAll findByOrgId(@PathVariable Long gatepassId) {
        SSGatepassAll custGatepassId = gatepassRepository.findByGatepassId(gatepassId);
        //   HrOperatingUnit user = orgIdUser.isPresent() ? orgIdUser.get() : null;
        return custGatepassId;
    }

}
