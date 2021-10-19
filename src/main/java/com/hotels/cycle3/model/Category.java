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
 * Define Table model : category
 * @author: G28_Group:7
 * 
 */

@Entity
@Table(name = "category")
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;


	@OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "category")
	@JsonIgnoreProperties("category")
	private List<Room> rooms;

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
	 * @return the rooms
	 */
	public List<Room> getRooms() {
		return rooms;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	
}
