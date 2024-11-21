package com.example.CRUDOperation.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.CRUDOperation.Entity.Category;
import com.example.CRUDOperation.Repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepo;

	public Page<Category> getAllCategories(int page, int size) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page, size);
		return categoryRepo.findAll(pageable);
	}

	public String createCategory(Category category) {
		// TODO Auto-generated method stub
		categoryRepo.save(category);
		return "Category is added";
	}

	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(id).orElseThrow(()->
				new RuntimeException("Category not found"));
	}
	
	public Category updateCategory(int id,Category category) {
		Category cat = getCategoryById(id);
		cat.setName(category.getName());
		return categoryRepo.save(cat);
	}

	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		categoryRepo.deleteById(id);
	}
	
	
	

}
