package com.agencyapp.dao.messaging;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agencyapp.model.messaging.MessagesEntity;
@Repository
public interface MessagesDao extends JpaRepository<MessagesEntity, Integer>{
	
	@Query(value = "SELECT * FROM messages as m WHERE m.conversation_id = :idP", nativeQuery = true)
	public List<MessagesEntity> findByConversationsID(@Param("idP") int id);
	public MessagesEntity findById(int id);
}
