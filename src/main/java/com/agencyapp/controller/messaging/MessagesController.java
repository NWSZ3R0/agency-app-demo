package com.agencyapp.controller.messaging;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agencyapp.dto.ResponseObjectDTO;
import com.agencyapp.dto.messaging.MessagesDTO;
import com.agencyapp.model.messaging.MessagesEntity;
import com.agencyapp.service.IMessagesService;

@RestController
public class MessagesController {
	@Autowired
	private IMessagesService iMessagesService;

	// Get all messages
	@GetMapping(value = "/messages")
	public ResponseEntity<ResponseObjectDTO> getAllMessages() {
		List<MessagesEntity> messagesList = iMessagesService.getAllMessages();
		if (messagesList != null && messagesList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObjectDTO("ok", "Querry successfully", messagesList));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseObjectDTO("failed", "Cannot find messages", ""));
		}
	}

	// Get all messages by province id
	@GetMapping(value = "/messages/{id}")
	public ResponseEntity<ResponseObjectDTO> getMessagesByConversationsID(@PathVariable("id") int id) {
		List<MessagesEntity> messagesList = iMessagesService.findByConversationsID(id);
		if (messagesList != null && messagesList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObjectDTO("ok", "Querry successfully", messagesList));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseObjectDTO("failed", "Cannot find messages with id_conversation = " + id, ""));
		}

	}

	@PostMapping(value = "/messages/send")
	public ResponseEntity<ResponseObjectDTO> sendMessages(@RequestBody MessagesEntity messagesEntity) {
		if (messagesEntity != null) {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObjectDTO("ok", "Insert successfully", iMessagesService.addMessages(messagesEntity)));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
					.body(new ResponseObjectDTO("failed", "Cannot insert", ""));
		}
	}

	@PutMapping(value = "/messages/update/{id}")
	public ResponseEntity<ResponseObjectDTO> updateMessages(@PathVariable("id") int id,
			@RequestBody MessagesEntity messagesEntity) {
		MessagesEntity messagesUpdated = iMessagesService.updateMessages(id, messagesEntity);
		if (messagesUpdated != null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObjectDTO("ok", "Update successfully", messagesUpdated));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
					.body(new ResponseObjectDTO("failed", "Cannot update message id= "+ id, ""));
		}
	}

	@DeleteMapping("/messages/delete/{id}")
	public ResponseEntity<ResponseObjectDTO> deleteMessages(@PathVariable("id") int id) {
		if (iMessagesService.deleteMessages(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObjectDTO("ok", "Delete successfully", ""));
		} else {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObjectDTO("failed", "Cannot delete message id= " + id, ""));
		}

	}
}
