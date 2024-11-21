package com.example.CRUDOperation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUDOperation.Service.CategoryService;
import com.example.CRUDOperation.Entity.*;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping()
	public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
		return categoryService.getAllCategories(page,size);
	}
	
	@PostMapping()
	public String createCategory(@RequestBody Category category) {
		String msg = categoryService.createCategory(category);
		return category.getName()+msg;
	}
	
	@GetMapping("/{id}")
	public Category getCategoryByUd(@PathVariable int id) {
		return categoryService.getCategoryById(id);
	}
	
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable int id,@RequestBody Category category) {
		return categoryService.updateCategory(id,category);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable int id) {
		categoryService.deleteCategory(id);
	}
}
