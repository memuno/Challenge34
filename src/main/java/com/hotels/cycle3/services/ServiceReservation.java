package com.hotels.cycle3.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.cycle3.model.Reservation;
import com.hotels.cycle3.reports.CounterClients;
import com.hotels.cycle3.reports.StatusReservation;
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

	/**
	 * Method to extract Cancelled-Completed items table Reservation
	 * 
	 * @return object items: Cancelled and Completed Table Reservation
	 */
	public StatusReservation getReportStatusReservations() {
		List<Reservation> completed = servReservation.statusReservation("completed");
		List<Reservation> cancelled = servReservation.statusReservation("cancelled");
		return new StatusReservation(completed.size(), cancelled.size());
	}

	/**
	 * Method to extract report table Reservation
	 * 
	 * @return object items: reservations by date-one to date-Two Table Reservation
	 */

	public List<Reservation> getReportByTimeReservations(String dateIni, String dateEnd) {
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOne = new Date();
		Date dateTwo = new Date();

		try {
			dateOne = parser.parse(dateIni);
			dateTwo = parser.parse(dateEnd);
		} catch (ParseException evt) {
			evt.printStackTrace();
		}
		if (dateOne.before(dateTwo)) {
			return servReservation.timeReservation(dateOne, dateTwo);
		} else {
			return new ArrayList<>();
		}
	}

	/**
	 * Method to extract report table Reservation
	 * 
	 * @return object items: reservations by clients with total reservations Table
	 *         Reservation
	 */
	public List<CounterClients> getReportTopClients() {
		return servReservation.getTopClients();
	}

}
