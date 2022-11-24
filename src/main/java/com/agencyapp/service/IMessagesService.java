package com.agencyapp.service;

import java.util.List;

import com.agencyapp.dto.messaging.MessagesDTO;
import com.agencyapp.model.messaging.MessagesEntity;

public interface IMessagesService {
	public List<MessagesEntity> getAllMessages();
	List<MessagesEntity> findByConversationsID(int id);
	public MessagesEntity addMessages(MessagesEntity messagesEntity);
	public MessagesEntity updateMessages(int id,MessagesEntity messagesEntity);
	public boolean deleteMessages(int id);
}
