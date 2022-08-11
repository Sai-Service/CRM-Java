/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.ProformaHeadersAll;
import java.math.BigInteger;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lenovo
 */
public interface ProformaHeaderDao extends CrudRepository<ProformaHeadersAll, Integer> {

   

    public Optional<ProformaHeadersAll> findByOrdernumber(BigInteger orderNumber);
    
     @Modifying
    @Transactional
    @Query(value = "update ProformaHeadersAll set lastUpdatedDate=CURRENT_DATE,taskId=?1 where orderNumber=?2")
    public void updateTaskId(long taskId,String orderNumber);

}
