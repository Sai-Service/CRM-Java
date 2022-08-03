/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.service;

//import com.sai.dao.UserDao;
import com.sai.dao.UserLoginDao;
import com.sai.model.UserLogin;
import java.util.Arrays;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserLoginDao userDao;

    /**
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        System.out.println("======inside loadUserByUsername===================" + user.getPassword());
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
        System.out.println("======inside loadUserByUsername===================" + userDetails.toString());
        return userDetails;
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public UserLogin findOne(String username) {
        UserLogin user = userDao.findByUsername(username);
        System.out.println("======inside fineone===================");
        return user;
    }

}
