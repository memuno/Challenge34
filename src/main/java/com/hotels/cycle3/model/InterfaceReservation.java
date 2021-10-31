/**
 * Interface to Model reservation table
 */
package com.hotels.cycle3.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author G28_Group:7
 *
 */
public interface InterfaceReservation extends CrudRepository<Reservation, Integer> {

	/*
	 * Query to Reservation table by Status Field
	 */
	public List<Reservation> findAllByStatus(String status);

	/*
	 * Query to Reservation table by startDate Field -- (between DateOne-
	 * DateTwo)---
	 */

	public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

	/*
	 * Query to Reservation table by client Field group by client and count and
	 * order DESC
	 */

	@Query("SELECT f.client, COUNT(f.client) from Reservation AS f group by f.client order by COUNT(f.client)DESC")
	public List<Object[]> countTotalReservationsByClient();

}
