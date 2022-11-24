package com.agencyapp.dao.messaging;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencyapp.model.messaging.ConversationsEntity;

@Repository
public interface ConversationsDao extends JpaRepository<ConversationsEntity, Integer>{

}
