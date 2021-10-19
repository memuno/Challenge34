package com.hotels.cycle3.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * Define Table model : message
 * @author: G28_Group:7
 * 
 */

@Entity
@Table(name = "message")
public class Message implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMessage;
	private String messageText;
	
	@ManyToOne
	@JoinColumn(name = "id")
	@JsonIgnoreProperties({"messages", "client","reservations"})
	private Room room;
	
	@ManyToOne
	@JoinColumn(name = "idClient")
	@JsonIgnoreProperties({"messages", "reservations", "client"})
	private Client client;

	/**
	 * @return the idMessage
	 */
	public Integer getIdMessage() {
		return idMessage;
	}

	/**
	 * @param idMessage the idMessage to set
	 */
	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}

	/**
	 * @return the messageText
	 */
	public String getMessageText() {
		return messageText;
	}

	/**
	 * @param messageText the messageText to set
	 */
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
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