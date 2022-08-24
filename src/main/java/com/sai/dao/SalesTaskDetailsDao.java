/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.SalesTaskDetails;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Lenovo
 */
public interface SalesTaskDetailsDao extends CrudRepository<SalesTaskDetails, Integer>{

    public List<SalesTaskDetails> findByLocId(Integer locId);
 ///SalesTaskDetails

    public Optional<SalesTaskDetails> findByTaskId(Integer taskId);
    
    
}
