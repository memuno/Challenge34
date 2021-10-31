package com.hotels.cycle3.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.cycle3.model.InterfaceReservation;
import com.hotels.cycle3.model.Reservation;
import com.hotels.cycle3.reports.CounterClients;
import com.hotels.cycle3.model.Client;


/**
 * @author G28_Group:7
 *
 */
@Repository
public class ReservationRepository {

	@Autowired
	private InterfaceReservation RepoReservation;

	/**
	 * get all data repository
	 * 
	 * @return
	 */
	public List<Reservation> getAllReservation() {

		return (List<Reservation>) RepoReservation.findAll();
	}

	/**
	 * get specific item data repository
	 * 
	 * @return
	 */
	public Optional<Reservation> getReservation(int id) {

		return RepoReservation.findById(id);
	}

	/**
	 * insert specific item data repository
	 * 
	 * @return
	 */
	public Reservation saveReservation(Reservation reservation) {

		return RepoReservation.save(reservation);
	}

	/**
	 * delete specific item data repository
	 * 
	 * @return
	 */
	public void deleteReservation(Reservation reservation) {

		RepoReservation.delete(reservation);
	}

	/**
	 * list Reservations by status field
	 * 
	 * @return
	 */

	public List<Reservation> statusReservation(String status) {
		return RepoReservation.findAllByStatus(status);
	}

	/**
	 * list Reservations between startDate (dateOne-DateTwo) field Table Reservation
	 * 
	 * @return
	 */
	public List<Reservation> timeReservation(Date dateOne, Date dateTwo) {
		return RepoReservation.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
	}
	
	/**
	 * list Clients  field Table Reservation
	 * 
	 * @return
	 */
    public List<CounterClients> getTopClients(){
        List<CounterClients> topClients=new ArrayList<>();
        List<Object[]> report = RepoReservation.countTotalReservationsByClient();
        for(int i=0; i<report.size();i++){
            topClients.add(new CounterClients((Long)report.get(i)[1],(Client) report.get(i)[0]));
        
        }
        return topClients;
    }
	
}
