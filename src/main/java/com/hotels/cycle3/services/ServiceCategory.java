package com.hotels.cycle3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.cycle3.model.Category;
import com.hotels.cycle3.repository.CategoryRepository;

/**
 * @author G28_Group:7
 *
 */

@Service
public class ServiceCategory {
	
	@Autowired
    private CategoryRepository servCategory;
    
	/**
	 * Method to get items table Category
	 * @return list items
	 */
    public List<Category> getAllCategory() {
        return servCategory.getAllCategory();
    }

	/**
	 * Method to get specific item table Category
	 * @return item Table Category
	 */
    public Optional<Category> getCategory(int categoryId) {
        return servCategory.getCategory(categoryId);
    }
    
    /**
	 * Method to save specific item table Category
	 * @return save item Table Category
	 */
    
	public Category saveCategory(Category category) {
		if (category.getId() == null) {
			return servCategory.saveCategory(category);
		} else {
			Optional<Category> category1 = servCategory.getCategory(category.getId());
			if (category1.isEmpty()) {
				return servCategory.saveCategory(category);
			} else {
				return category;
			}
		}
	}
	
    /**
	 * Method to Update specific item table Category
	 * @return Update item Table Category
	 */
	
	public Category updateCategory(Category category) {
		if (category.getId() != null) {
			Optional<Category> itemCategory = servCategory.getCategory(category.getId());
			if (!itemCategory.isEmpty()) {
				if (category.getDescription() != null) {
					itemCategory.get().setDescription(category.getDescription());
				}
				if (category.getName() != null) {
					itemCategory.get().setName(category.getName());
				}
				servCategory.saveCategory(itemCategory.get());
				return itemCategory.get();
			} else {
				return category;
			}
		} else {
			return category;
		}

	}

	/**
	 * Method to Delete specific item table Category
	 * 
	 * @return Delete item Table Category
	 */

	public boolean deleteCategory(int categoryId) {
		Boolean item1Category = getCategory(categoryId).map(category -> {
			servCategory.deleteCategory(category);
			return true;
		}).orElse(false);
		return item1Category;
	}

}
