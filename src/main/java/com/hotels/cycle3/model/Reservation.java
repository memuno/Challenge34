package com.hotels.cycle3.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * Define Table model : reservation
 * @author: G28_Group:7
 * 
 */

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idReservation;
	private Date startDate;
	private Date devolutionDate;
	private String status = "created";

	@ManyToOne
	@JoinColumn(name = "idClient")
	@JsonIgnoreProperties({"reservations", "messages"})
	private Client client;

	@ManyToOne
	@JoinColumn(name = "id")
	@JsonIgnoreProperties("reservations")
	private Room room;
	
	private String score;

	/**
	 * @return the idReservation
	 */
	public Integer getIdReservation() {
		return idReservation;
	}

	/**
	 * @param idReservation the idReservation to set
	 */
	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the devolutionDate
	 */
	public Date getDevolutionDate() {
		return devolutionDate;
	}

	/**
	 * @param devolutionDate the devolutionDate to set
	 */
	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the score
	 */
	public String getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(String score) {
		this.score = score;
	}
	
	

}
