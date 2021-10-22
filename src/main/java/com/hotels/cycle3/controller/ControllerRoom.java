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

import com.hotels.cycle3.model.Room;
import com.hotels.cycle3.services.ServiceRoom;

/**
 * @author MARIO
 *
 */
@RestController
@RequestMapping("/api/Room")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class ControllerRoom {

	@Autowired
	private ServiceRoom service;

	@GetMapping("/all")
	public List<Room> getRoom() {
		return service.getAllRoom();
	}

	@GetMapping("/{id}")
	public Optional<Room> getRoom(@PathVariable("id") int roomId) {
		return service.getRoom(roomId);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Room save(@RequestBody Room room) {
		return service.saveRoom(room);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Room updateRoom(@RequestBody Room room) {
		return service.updateRoom(room);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteRoom(@PathVariable("id") int roomId) {
		return service.deleteRoom(roomId);
	}

}
