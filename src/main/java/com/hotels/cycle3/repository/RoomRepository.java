package com.hotels.cycle3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hotels.cycle3.model.InterfaceRoom;
import com.hotels.cycle3.model.Room;

/**
 * @author G28_Group:7
 *
 */
@Repository
public class RoomRepository {

	@Autowired
    private InterfaceRoom RepoRoom;
	
	/**
	 * get all data repository 
	 * @return
	 */
    public List<Room> getAllRoom(){
    	
        return (List<Room>) RepoRoom.findAll();
    }
    
    /**
	 * get specific item data repository 
	 * @return
	 */
    public Optional<Room> getRoom(int id){
    	
        return RepoRoom.findById(id);
    }

    /**
	 * insert specific item data repository 
	 * @return
	 */
    public Room saveRoom(Room room){
    	
        return RepoRoom.save(room);
    }
    
    /**
	 * delete specific item data repository 
	 * @return
	 */
    public void deleteRoom(Room room){
    	
    	RepoRoom.delete(room);
    }

}
