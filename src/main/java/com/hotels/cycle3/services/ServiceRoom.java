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
	
	/**
	 * Method to Update specific item table Room
	 * 
	 * @return Update item Table Room
	 */

	public Room updateRoom(Room room) {
		if (room.getId() != null) {
			Optional<Room> itemRoom = servRoom.getRoom(room.getId());
			if (!itemRoom.isEmpty()) {
				if (room.getName() != null) {
					itemRoom.get().setName(room.getName());
				}
				if (room.getHotel() != null) {
					itemRoom.get().setHotel(room.getHotel());
				}
				if (room.getStars() != null) {
					itemRoom.get().setStars(room.getStars());
				}
				if (room.getDescription() != null) {
					itemRoom.get().setDescription(room.getDescription());
				}
				if (room.getCategory() != null) {
					itemRoom.get().setCategory(room.getCategory());
				}
				servRoom.saveRoom(itemRoom.get());
				return itemRoom.get();
			} else {
				return room;
			}
		} else {
			return room;
		}
	}

	/**
	 * Method to Delete specific item table Room
	 * 
	 * @return Delete item Table Room
	 */

	public boolean deleteRoom(int roomId) {
		Boolean item1Room = getRoom(roomId).map(room -> {
			servRoom.deleteRoom(room);
			return true;
		}).orElse(false);
		return item1Room;
	}

}
