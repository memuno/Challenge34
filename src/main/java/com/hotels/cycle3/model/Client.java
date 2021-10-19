package com.hotels.cycle3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * Define Table model : client
 * @author: G28_Group:7
 * 
 */

@Entity
@Table(name = "client")
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClient;
	private String name;
	private String email;
	private String password;
	private Integer age;
	
	@OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
	@JsonIgnoreProperties("client")
	private List<Message> Messages;
	

	@OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
	@JsonIgnoreProperties("client")
	private List<Reservation> reservations;

	/**
	 * @return the idClient
	 */
	public Integer getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the messages
	 */
	public List<Message> getMessages() {
		return Messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<Message> messages) {
		Messages = messages;
	}

	/**
	 * @return the reservations
	 */
	public List<Reservation> getReservations() {
		return reservations;
	}

	/**
	 * @param reservations the reservations to set
	 */
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
}
