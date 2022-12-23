/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.SaiResponse;
import com.sai.dao.UserLoginDao;
import com.sai.impl.UserRepository;
import com.sai.model.UserLogin;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class UserController {

    // standard constructors
    @Autowired
    private UserRepository userRepository;
    
    

    @Autowired
    private UserLoginDao userLoginDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public List<UserLogin> getUsers() {
        return (List<UserLogin>) userRepository.findAll();
    }

    @PostMapping("/users")
    public SaiResponse addUser(@RequestBody UserLogin user) {
        SaiResponse apiResponse;
        if (user == null) {
            apiResponse = new SaiResponse(400, "Invalid  User Inputs", null);
        } else {
            try {
                Calendar calendar = Calendar.getInstance();
                java.util.Date currentDate = calendar.getTime();

                          String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        UserLogin user1 = userLoginDao.findByUsername(username);
                 int userId = new Long(user1.getUserId()).intValue();
          
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                String ticketNo = user.getTicketNo();
                String[] userDetails = ticketNo.split("-");
                user.setTicketNo(userDetails[0]);
                user.setUsername(userDetails[0]);
                user.setCreatedBy(userId);
                user.setCreationDt(currentDate);
                user.setLastUpdatedBy(userId);
                user.setLstUpDate(currentDate);
                user.setReportTo(user.getReportTo());

                userRepository.save(user);
            } catch (Exception ex) {
                apiResponse = new SaiResponse(400, "Error while inserting user", ex.getMessage());
            }
        }
        apiResponse = new SaiResponse(200, "User Inserted Successfully", null);
        return apiResponse;
    }

    @RequestMapping(value = "/UserLogin/findByLocation/{loc_id}", method = RequestMethod.GET, produces = {"application/JSON"})
    // Map getUsercountList(@PathVariable String vehicle_no)
    public List<Map> findByLocation(@PathVariable long loc_id) {
        return userLoginDao.findByLocation(loc_id);
    }

    @GetMapping("/UserLogin/{username}")//////////////
    public UserLogin findLoginName(@PathVariable String username) {
        UserLogin exeLocId = userLoginDao.findByUsername(username);
        return exeLocId;
    }

    //To Find the EW Customer Reminder Date///////////
    @RequestMapping(value = "/executive/executiveName/{ticketno}", method = RequestMethod.GET, produces = {"application/JSON"})
    // Map getUsercountList(@PathVariable String vehicle_no)
    Map getexeName(@PathVariable String ticketno) {
        return userLoginDao.getexeName(ticketno);
    }

}
