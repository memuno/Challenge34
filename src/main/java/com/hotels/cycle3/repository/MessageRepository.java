package com.hotels.cycle3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.cycle3.model.InterfaceMessage;
import com.hotels.cycle3.model.Message;

/**
 * @author G28_Group:7
 *
 */
@Repository
public class MessageRepository {

	@Autowired
    private InterfaceMessage RepoMessage;
	
	/**
	 * get all data repository 
	 * @return
	 */
    public List<Message> getAllMessage(){
    	
        return (List<Message>) RepoMessage.findAll();
    }
    
    /**
	 * get specific item data repository 
	 * @return
	 */
    public Optional<Message> getMessage(int id){
    	
        return RepoMessage.findById(id);
    }

    /**
	 * insert specific item data repository 
	 * @return
	 */
    public Message saveMessage(Message message){
    	
        return RepoMessage.save(message);
    }
    
    /**
	 * delete specific item data repository 
	 * @return
	 */
    public void deleteMessage(Message message){
    	
    	RepoMessage.delete(message);
    }

}
