package com.hotels.cycle3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.cycle3.model.InterfaceReservation;
import com.hotels.cycle3.model.Reservation;

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
	 * @return
	 */
    public List<Reservation> getAllReservation(){
    	
        return (List<Reservation>) RepoReservation.findAll();
    }
    
    /**
	 * get specific item data repository 
	 * @return
	 */
    public Optional<Reservation> getReservation(int id){
    	
        return RepoReservation.findById(id);
    }

    /**
	 * insert specific item data repository 
	 * @return
	 */
    public Reservation saveReservation(Reservation reservation){
    	
        return RepoReservation.save(reservation);
    }
    
    /**
	 * delete specific item data repository 
	 * @return
	 */
    public void deleteReservation(Reservation reservation){
    	
    	RepoReservation.delete(reservation);
    }

}
