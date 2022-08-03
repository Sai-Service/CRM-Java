/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;
import com.sai.SaiResponse;
import com.sai.model.SsSlotAvailable;
import java.util.List;
import com.sai.dao.SsSlotAvailableDao;
import com.sai.dao.UserLoginDao;
import com.sai.model.UserLogin;
import java.util.Calendar;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Test
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SsSlotAvailableController {
    
    @Autowired
    private UserLoginDao userRepository; 

    @Autowired
     private  SsSlotAvailableDao slotRepository;
 
    @GetMapping("/ssSlotAvailables")
    public List<SsSlotAvailable> getSlots() {
        return (List<SsSlotAvailable>) slotRepository.findAll();
    }
    
     
    @GetMapping("/ssSlotAvailablesbyLoc")
    public SsSlotAvailable getSlots(@RequestParam long serv_loc_id,@RequestParam Date serviceDate,@RequestParam  String timing) throws Exception {
        return (SsSlotAvailable) slotRepository.findBySerLocIdAndServiceDateAndTiming(serv_loc_id,serviceDate,timing);
    }
 
    @PostMapping("/ssSlotAvailables")
    SaiResponse addUser(@RequestBody SsSlotAvailable slots) {
           SaiResponse apiResponse;
        try
        {
               String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        UserLogin user = userRepository.findByUsername(username);
          
         Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();
       
        slots.setCreatedBy(user.getUserId());
            slots.setCreationDt(currentDate);
            slots.setLstUpBy(user.getUserId());
            slots.setLstUpDate(currentDate);
 
        slotRepository.save(slots);
         } 
        catch (Exception e) 
         {
            apiResponse = new SaiResponse(400, "Not inserted", null);
        }
        return apiResponse = new SaiResponse(200, "Ok", null);
    }
    
 @PutMapping("/ssSlotAvailables/{id}")
    SaiResponse updateSsSlot(@RequestBody SsSlotAvailable updatedSsSlot, @PathVariable Long id) {
  SaiResponse apiResponse;
        Optional<SsSlotAvailable> optionalSsSlot = slotRepository.findById(updatedSsSlot.getSlotId());
        SsSlotAvailable SsSlot = optionalSsSlot.isPresent() ? optionalSsSlot.get() : null;
        if(SsSlot != null) {
            BeanUtils.copyProperties(updatedSsSlot, SsSlot);
            slotRepository.save(SsSlot);
        }
             else {
            apiResponse = new SaiResponse(400, "Location Master found", null);
        }
        apiResponse = new SaiResponse(200, "OK", SsSlot);
        return apiResponse;
       
    }
 
     @DeleteMapping("/ssSlotAvailables/{id}")
    void deleteSsSlot(@PathVariable Long id) {
       slotRepository.deleteById(id);
    }
    
     /*  @RequestMapping(value ="/opunits/names", method = RequestMethod.GET)
    public List<OpUnit> getOpUnitsNames() {
       List<OpUnit> objLists = UnitRepository.getUnitsNames();
       return objLists;
    }*/
    
     @GetMapping("/ssSlotAvailables/{id}")
    public SsSlotAvailable getOpUnitById(@PathVariable Long id){
       Optional<SsSlotAvailable> optionalUser = slotRepository.findById(id);
        SsSlotAvailable user = optionalUser.isPresent() ? optionalUser.get() : null;
        return user;
    }
    
    
}