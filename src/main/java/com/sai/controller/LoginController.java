/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.controller;

import com.sai.config.JwtTokenUtil;
import com.sai.SaiResponse;
import com.sai.dao.UserLoginDao;
import com.sai.dto.AuthUser;
import com.sai.model.UserLogin;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class LoginController {

    @Autowired
    private UserLoginDao userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/JSON"})
    public SaiResponse login(@RequestBody UserLogin loginUser, HttpServletRequest request) throws AuthenticationException {
        SaiResponse apiResponse = null;
        try{
        if (loginUser == null) {
            apiResponse = new SaiResponse(400, "Invalid Inputs", null);

        } else {
            if (loginUser.getUsername() != null && loginUser.getPassword() != null) {
                apiResponse = new SaiResponse(400, "Invalid Inputs", null);
            }

        //    UserLogin user = userRepository.findLoginName(loginUser.getUsername());
             UserLogin user = userRepository.findByUsername(loginUser.getUsername());
           

            if (user != null) {
               // if (user.getPassword().equals(loginUser.getPassword())) {

                    //               UsernamePasswordAuthenticationToken authReq  = new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword());
//                   // Authentication auth = authManager.authenticate(authReq);
//
//                    SecurityContext sc = SecurityContextHolder.getContext();
//                    sc.setAuthentication(authReq);
//                    HttpSession session = request.getSession(true);
//                    session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
                    final Authentication authentication = authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    loginUser.getUsername(),
                                    loginUser.getPassword()
                            )
                    );
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                    final String token = jwtTokenUtil.generateToken(user);
 System.out.println("=====" + token);
                    apiResponse = new SaiResponse(200, "login sucessful", new AuthUser(token, user));
//                } else {
//                    apiResponse = new SaiResponse(400, "Invalid password", null);
//                }
            } else {
                apiResponse = new SaiResponse(400, "Invalid Inputs", null);

            }
        }
        }catch(BadCredentialsException bex){
            apiResponse = new SaiResponse(400, "Invalid user name or password", bex.getMessage());
        }catch(Exception ex){
          ex.printStackTrace();
        }
       return apiResponse;
    }

    /* @GetMapping("/userLogins")//////////////////
    public List<UserLogin> getLoginDetails() {
        return (List<UserLogin>) userRepository.findAll();
    }

    @PostMapping("/userLogins")
    void adduserLogin(@RequestBody UserLogin userLogin) {
        userRepository.save(userLogin);
    }  
    
      @PutMapping("/userLogins/{id}")
    UserLogin updateOpUnit(@RequestBody UserLogin upUserLogin, @PathVariable Long id) {
        Optional<UserLogin> optionalOpUnit = userRepository.findById(upUserLogin.getUserId());
        UserLogin uLogin = optionalOpUnit.isPresent() ? optionalOpUnit.get() : null;
        if (uLogin != null) {
            BeanUtils.copyProperties(upUserLogin, uLogin);
            userRepository.save(uLogin);
        }
        return uLogin;
    }

    @DeleteMapping("/userLogins/{id}")
    void deleteuLogin(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
     */
}
