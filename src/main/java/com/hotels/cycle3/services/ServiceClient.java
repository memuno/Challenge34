package com.hotels.cycle3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.cycle3.model.Client;
import com.hotels.cycle3.repository.ClientRepository;

/**
 * @author G28_Group:7
 *
 */

@Service
public class ServiceClient {

	@Autowired
	private ClientRepository servClient;

	/**
	 * Method to get items table Client
	 * 
	 * @return list items
	 */

	public List<Client> getAllClient() {
		return servClient.getAllClient();
	}

	/**
	 * Method to get specific item table Client
	 * 
	 * @return item Table Client
	 */
	public Optional<Client> getClient(int clientId) {
		return servClient.getClient(clientId);
	}

	/**
	 * Method to save specific item table Client
	 * 
	 * @return save item Table Client
	 */

	public Client saveClient(Client client) {
		if (client.getIdClient() == null) {
			return servClient.saveClient(client);
		} else {
			Optional<Client> client1 = servClient.getClient(client.getIdClient());
			if (client1.isEmpty()) {
				return servClient.saveClient(client);
			} else {
				return client;
			}
		}
	}

	/**
	 * Method to Update specific item table Client
	 * 
	 * @return Update item Table Client
	 */

	public Client updateClient(Client client) {
		if (client.getIdClient() != null) {
			Optional<Client> itemClient = servClient.getClient(client.getIdClient());
			if (!itemClient.isEmpty()) {
				if (client.getEmail() != null) {
					itemClient.get().setEmail(client.getEmail());
				}
				if (client.getPassword() != null) {
					itemClient.get().setPassword(client.getPassword());
				}
				if (client.getName() != null) {
					itemClient.get().setName(client.getName());
				}
				if (client.getAge() != null) {
					itemClient.get().setAge(client.getAge());
				}

				servClient.saveClient(itemClient.get());
				return itemClient.get();
			} else {
				return client;
			}
		} else {
			return client;
		}
	}

	/**
	 * Method to Delete specific item table Client
	 * 
	 * @return Delete item Table Client
	 */

	public boolean deleteClient(int clientId) {
		Boolean item1Client = getClient(clientId).map(client -> {
			servClient.deleteClient(client);
			return true;
		}).orElse(false);
		return item1Client;
	}

}
