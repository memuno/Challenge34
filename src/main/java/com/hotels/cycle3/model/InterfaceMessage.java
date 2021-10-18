/**
 * Interface to Model message table
 */
package com.hotels.cycle3.model;

import org.springframework.data.repository.CrudRepository;

/**
 * @author G28_Group:7
 *
 */
public interface InterfaceMessage extends CrudRepository<Message,Integer> {

}
