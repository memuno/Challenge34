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
	 * 
	 * @return list items
	 */

	public List<Reservation> getAllReservation() {
		return servReservation.getAllReservation();
	}

	/**
	 * Method to get specific item table Reservation
	 * 
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

	/**
	 * Method to Update specific item table Reservation
	 * 
	 * @return Update item Table Reservation
	 */

	public Reservation updateReservation(Reservation reservation) {
		if (reservation.getIdReservation() != null) {
			Optional<Reservation> itemReservation = servReservation.getReservation(reservation.getIdReservation());
			if (!itemReservation.isEmpty()) {

				if (reservation.getStartDate() != null) {
					itemReservation.get().setStartDate(reservation.getStartDate());
				}
				if (reservation.getDevolutionDate() != null) {
					itemReservation.get().setDevolutionDate(reservation.getDevolutionDate());
				}
				if (reservation.getStatus() != null) {
					itemReservation.get().setStatus(reservation.getStatus());
				}
				servReservation.saveReservation(itemReservation.get());
				return itemReservation.get();
			} else {
				return reservation;
			}
		} else {
			return reservation;
		}
	}

	/**
	 * Method to Delete specific item table Reservation
	 * 
	 * @return Delete item Table Reservation
	 */

	public boolean deleteReservation(int reservationId) {
		Boolean item1Reservation = getReservation(reservationId).map(reservation -> {
			servReservation.deleteReservation(reservation);
			return true;
		}).orElse(false);
		return item1Reservation;
	}

}
