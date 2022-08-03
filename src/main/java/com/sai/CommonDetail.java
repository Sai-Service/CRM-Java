/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai;

import com.sai.dao.UserLoginDao;
import com.sai.model.UserLogin;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Swaroopcomp
 */
public class CommonDetail {

     @Autowired
    private UserLoginDao userRepository;
    
    public  String getLoggedInUser() throws Exception {
        ////Reading usernameand userId
        java.util.Date currentDate = Calendar.getInstance().getTime();
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
//        UserLogin user = userRepository.findByUsername(username);
//        if (user != null) {
//            return user;
//        }
//            return null;
        }
    
}
