package com.hotels.cycle3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.cycle3.model.Reservation;
import com.hotels.cycle3.repository.ReservationRepository;

/**
 * @author G28_Group:7
 *
 */

@Service
public class ServiceReservation {
	
	@Autowired
    private ReservationRepository servReservation;
	
	/**
	 * Method to get items table Reservation
	 * @return list items
	 */

    public List<Reservation> getAllReservation() {
        return servReservation.getAllReservation();
    }

	/**
	 * Method to get specific item table Reservation
	 * @return item Table Reservation
	 */
    public Optional<Reservation> getReservation(int reservationId) {
        return servReservation.getReservation(reservationId);
    }
    
	/**
	 * Method to save specific item table Reservation
	 * 
	 * @return save item Table Reservation
	 */

	public Reservation saveReservation(Reservation reservation) {
		if (reservation.getIdReservation() == null) {
			return servReservation.saveReservation(reservation);
		} else {
			Optional<Reservation> reservation1 = servReservation.getReservation(reservation.getIdReservation());
			if (reservation1.isEmpty()) {
				return servReservation.saveReservation(reservation);
			} else {
				return reservation;
			}
		}
	}


}
