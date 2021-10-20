package com.hotels.cycle3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * Define Table model : room
 * @author: G28_Group:7
 * 
 */

@Entity
@Table(name = "room")
public class Room implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String hotel;
	private Integer stars;	
	private String description;
	
	@ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("rooms")
    private Category category;
	
	@OneToMany(cascade = {CascadeType.PERSIST},mappedBy="room")
	@JsonIgnoreProperties({"room", "client"})
	private List<Message> messages;
	
	@OneToMany(cascade = {CascadeType.PERSIST},mappedBy="room")
	@JsonIgnoreProperties({"room", "client"})
	private List<Reservation> reservations;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the stars
	 */
	public Integer getStars() {
		return stars;
	}

	/**
	 * @param stars the stars to set
	 */
	public void setStars(Integer stars) {
		this.stars = stars;
	}

	/**
	 * @return the hotel
	 */
	public String getHotel() {
		return hotel;
	}

	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the messages
	 */
	public List<Message> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<Message> message) {
		messages = message;
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
