package com.hotels.cycle3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.cycle3.model.InterfaceClient;
import com.hotels.cycle3.model.Client;

/**
 * @author G28_Group:7
 *
 */
@Repository
public class ClientRepository {

	@Autowired
    private InterfaceClient RepoClient;
	
	/**
	 * get all data repository 
	 * @return
	 */
    public List<Client> getAllClient(){
    	
        return (List<Client>) RepoClient.findAll();
    }
    
    /**
	 * get specific item data repository 
	 * @return
	 */
    public Optional<Client> getClient(int id){
    	
        return RepoClient.findById(id);
    }

    /**
	 * insert specific item data repository 
	 * @return
	 */
    public Client saveClient(Client client){
    	
        return RepoClient.save(client);
    }
    
    /**
	 * delete specific item data repository 
	 * @return
	 */
    public void deleteClient(Client client){
    	
    	RepoClient.delete(client);
    }

}
