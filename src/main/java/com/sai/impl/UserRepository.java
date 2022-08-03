/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sai.impl;

import com.sai.model.UserLogin;
import com.sai.model.User1;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<UserLogin, Long>{
    //    User1 findByLOGIN_NAME(String username);

  //  public Optional<User1> findByLOGIN_NAME(String username);
    
}

