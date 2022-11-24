package com.agencyapp.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencyapp.dao.messaging.MessagesDao;
import com.agencyapp.dto.messaging.MessagesDTO;
import com.agencyapp.model.messaging.MessagesEntity;
import com.agencyapp.service.IMessagesService;

@Service
public class MessagesServiceImpl implements IMessagesService {
	private SimpleDateFormat fm = new SimpleDateFormat("yyyy/MM/dd");
	@Autowired
	private MessagesDao messagesDao;

	@Override
	public List<MessagesEntity> getAllMessages() {
		return messagesDao.findAll();
	}

	@Override
	public List<MessagesEntity> findByConversationsID(int id) {
		return messagesDao.findByConversationsID(id);
	}

	@Override
	public MessagesEntity addMessages(MessagesEntity messagesEntity) {
		messagesEntity.setCreated(fm.format(new Date()));
		return messagesDao.save(messagesEntity);
	}

	@Override
	public MessagesEntity updateMessages(int id, MessagesEntity messagesEntity) {
		if (messagesEntity != null) {
			MessagesEntity messagesFound = messagesDao.findById(id);
			if (messagesFound != null) {
				messagesFound.setSender_id(messagesEntity.getSender_id());
				messagesFound.setConversation_id(messagesEntity.getConversation_id());
				messagesFound.setType(messagesEntity.getType());
				messagesFound.setMessage(messagesEntity.getMessage());
				messagesFound.setStatus(messagesEntity.getStatus());
				messagesFound.setCreated(messagesEntity.getCreated());
				messagesFound.setDeleted(messagesEntity.getDeleted());
				return messagesDao.save(messagesFound);
			}
		}
		return null;
	}

	@Override
	public boolean deleteMessages(int id) {
		if(messagesDao.findById(id) != null) {
			messagesDao.deleteById(id);
			return true;
		}else {
			return false;
		}
		
	}

}
