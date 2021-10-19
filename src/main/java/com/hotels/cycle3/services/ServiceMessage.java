package com.hotels.cycle3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.cycle3.model.Message;
import com.hotels.cycle3.repository.MessageRepository;

/**
 * @author G28_Group:7
 *
 */

@Service
public class ServiceMessage {
	
	@Autowired
    private MessageRepository servMessage;
	
	/**
	 * Method to get items table Message
	 * @return list items
	 */

    public List<Message> getAllMessage() {
        return servMessage.getAllMessage();
    }

	/**
	 * Method to get specific item table Message
	 * @return item Table Message
	 */
    public Optional<Message> getMessage(int messageId) {
        return servMessage.getMessage(messageId);
    }

	/**
	 * Method to save specific item table Message
	 * 
	 * @return save item Table Message
	 */

	public Message saveMessage(Message message) {
		if (message.getIdMessage() == null) {
			return servMessage.saveMessage(message);
		} else {
			Optional<Message> message1 = servMessage.getMessage(message.getIdMessage());
			if (message1.isEmpty()) {
				return servMessage.saveMessage(message);
			} else {
				return message;
			}
		}
	}

}
