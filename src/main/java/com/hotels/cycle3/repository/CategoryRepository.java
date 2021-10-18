package com.hotels.cycle3.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hotels.cycle3.model.Category;
import com.hotels.cycle3.model.InterfaceCategory;

/**
 * @author G28_Group:7
 *
 */
@Repository
public class CategoryRepository {
	
	@Autowired
    private InterfaceCategory RepoCategory;
	
	/**
	 * get all data repository 
	 * @return
	 */
    public List<Category> getAllCategory(){
    	
        return (List<Category>) RepoCategory.findAll();
    }
    
    /**
	 * get specific item data repository 
	 * @return
	 */
    public Optional<Category> getCategory(int id){
    	
        return RepoCategory.findById(id);
    }

    /**
	 * insert specific item data repository 
	 * @return
	 */
    public Category saveCategory(Category category){
    	
        return RepoCategory.save(category);
    }
    
    /**
	 * delete specific item data repository 
	 * @return
	 */
    public void deleteCategory(Category category){
    	
    	RepoCategory.delete(category);
    }

}
