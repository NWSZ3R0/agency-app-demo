package com.agencyapp.dao.messaging;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencyapp.model.messaging.ParticipantsEntity;

@Repository
public interface ParticipantsDao extends JpaRepository<ParticipantsEntity, Integer>{

}
