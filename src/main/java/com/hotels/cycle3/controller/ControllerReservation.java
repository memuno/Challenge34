package com.hotels.cycle3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hotels.cycle3.model.Reservation;
import com.hotels.cycle3.reports.CounterClients;
import com.hotels.cycle3.reports.StatusReservation;
import com.hotels.cycle3.services.ServiceReservation;

/**
 * @author MARIO
 *
 */

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class ControllerReservation {

	@Autowired
	private ServiceReservation service;

	@GetMapping("/all")
	public List<Reservation> getReservation() {
		return service.getAllReservation();
	}

	@GetMapping("/{id}")
	public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
		return service.getReservation(reservationId);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation save(@RequestBody Reservation reservation) {
		return service.saveReservation(reservation);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation updateReservation(@RequestBody Reservation reservation) {
		return service.updateReservation(reservation);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteReservation(@PathVariable("id") int reservationId) {
		return service.deleteReservation(reservationId);
	}

	@GetMapping("/report-status")
	public StatusReservation getReservations() {
		return service.getReportStatusReservations();
	}

	@GetMapping("/report-dates/{dateOne}/{dateTwo}")
	public List<Reservation> getReservationByTime(@PathVariable("dateOne") String dateOne,
			@PathVariable("dateTwo") String dateTwo) {
		return service.getReportByTimeReservations(dateOne, dateTwo);
	}

	@GetMapping("/report-clients")
	public List<CounterClients> getTopClients() {
		return service.getReportTopClients();

	}

}
