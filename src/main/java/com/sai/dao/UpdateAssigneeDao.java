/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sai.dao;

import com.sai.model.SsAdministratorData;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Test
 */
public interface UpdateAssigneeDao extends CrudRepository<SsAdministratorData, Long> 
{
  //@Modifying
  //@Query(value="update test.SsAdministratorData set assignee=?1,assigneeId=?2 WHERE taskId BETWEEN ?3 AND ?4",nativeQuery=true)
  //UpdateAssignee UpdateAssigneeAdmin(String assignee ,String assigneeId,Long fromTaskId,Long toTaskId );  

}
