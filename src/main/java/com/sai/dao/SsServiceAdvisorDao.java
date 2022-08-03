/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.SsServiceAdvisor;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Test
 */
public interface SsServiceAdvisorDao extends CrudRepository<SsServiceAdvisor, Long> {

    public List<SsServiceAdvisor> findByLocationAndDesginationAndStatus(Integer locId, String desg, String status);

    public Optional<SsServiceAdvisor> findByTicketNo(String ticketNo);

    public List<SsServiceAdvisor> findByLocation(Integer locId);

}
