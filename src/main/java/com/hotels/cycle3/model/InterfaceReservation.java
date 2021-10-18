/**
 * Interface to Model reservation table
 */
package com.hotels.cycle3.model;

import org.springframework.data.repository.CrudRepository;

/**
 * @author G28_Group:7
 *
 */
public interface InterfaceReservation extends CrudRepository<Reservation,Integer> {

}
