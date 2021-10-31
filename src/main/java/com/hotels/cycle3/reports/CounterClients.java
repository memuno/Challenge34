package com.hotels.cycle3.reports;

import com.hotels.cycle3.model.Client;


/**
 * @author MARIO
 *
 */
public class CounterClients {

	private Long total;
	private Client client;

	public CounterClients(Long total, Client client) {
		this.total = total;
		this.client = client;
	}

	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Long total) {
		this.total = total;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

}
