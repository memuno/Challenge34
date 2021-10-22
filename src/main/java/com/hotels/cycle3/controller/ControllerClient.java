/**
 * 
 */
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

import com.hotels.cycle3.model.Client;
import com.hotels.cycle3.services.ServiceClient;

/**
 * @author MARIO
 *
 */

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class ControllerClient {

	@Autowired
	private ServiceClient service;

	@GetMapping("/all")
	public List<Client> getClient() {
		return service.getAllClient();
	}

	@GetMapping("/{id}")
	public Optional<Client> getClient(@PathVariable("id") int clientId) {
		return service.getClient(clientId);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Client save(@RequestBody Client client) {
		return service.saveClient(client);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Client updateClient(@RequestBody Client client) {
		return service.updateClient(client);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteClient(@PathVariable("id") int clientId) {
		return service.deleteClient(clientId);
	}

}
