package com.hotels.cycle3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.cycle3.model.Room;
import com.hotels.cycle3.repository.RoomRepository;

/**
 * @author G28_Group:7
 *
 */

@Service
public class ServiceRoom {
	
	@Autowired
    private RoomRepository servRoom;
	
	/**
	 * Method to get items table Room
	 * @return list items
	 */

    public List<Room> getAllRoom() {
        return servRoom.getAllRoom();
    }

	/**
	 * Method to get specific item table Room
	 * @return item Table Room
	 */
    public Optional<Room> getRoom(int roomId) {
        return servRoom.getRoom(roomId);
    }
    
    /**
	 * Method to save specific item table Room
	 * @return save item Table Room
	 */
    
	public Room saveRoom(Room room) {
		if (room.getId() == null) {
			return servRoom.saveRoom(room);
		} else {
			Optional<Room> Room1 = servRoom.getRoom(room.getId());
			if (Room1.isEmpty()) {
				return servRoom.saveRoom(room);
			} else {
				return room;
			}
		}
	}

 

}
