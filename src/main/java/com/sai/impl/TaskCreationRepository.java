/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.impl;

import com.sai.model.SsTaskDetails;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Test
 */
public interface TaskCreationRepository extends CrudRepository<SsTaskDetails, Long>{
   //for native query from model///
     SsTaskDetails findByVehNo(String vehicle_no);
     
     SsTaskDetails findByTaskId(long task_id);
      
    // SsTaskDetails findCountByLoc(long loc_id);
    /**
    @Autowired
   @PersistenceContext private EntityManager em;
    
    
    // Stores a new guest:
   @Transactional
    public void persist(SSTaskGen task) {
        em.persist(task);
    }
    
     public List<SSTaskGen> getAlltask() {
        TypedQuery<SSTaskGen> query = em.createQuery( "SSTaskGen.find", SSTaskGen.class);
        return query.getResultList();
    }
     
     */ 
}
