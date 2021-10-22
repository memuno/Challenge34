package com.hotels.cycle3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hotels.cycle3.model.Message;
import com.hotels.cycle3.services.ServiceMessage;

/**
 * @author MARIO
 *
 */

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class ControllerMessage {

	@Autowired
	private ServiceMessage service;

	@GetMapping("/all")
	public List<Message> getMessage() {
		return service.getAllMessage();
	}

	@GetMapping("/{id}")
	public Optional<Message> getMessage(@PathVariable("id") int messageId) {
		return service.getMessage(messageId);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Message save(@RequestBody Message message) {
		return service.saveMessage(message);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Message updateMessage(@RequestBody Message message) {
		return service.updateMessage(message);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteMesssage(@PathVariable("id") int messageId) {
		return service.deleteMessage(messageId);
	}

}
