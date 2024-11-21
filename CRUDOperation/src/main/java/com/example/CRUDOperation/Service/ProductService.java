package com.example.CRUDOperation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.CRUDOperation.Entity.Category;
import com.example.CRUDOperation.Entity.Product;
import com.example.CRUDOperation.Repository.CategoryRepository;
import com.example.CRUDOperation.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	

	public Page<Product> getAllProducts(int page, int size) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page, size);
		return productRepo.findAll(pageable);
	}

	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		if(product.getCategory() != null) {
			Category category = categoryRepo.findById(product.getCategory().getId()).orElseThrow(
								()-> new RuntimeException("Category not found"));
			product.setCategory(category);			
		}
		return productRepo.save(product);
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).orElseThrow(()->new RuntimeException("Product Not Found"));
	}
	
	public Product updateProducr(int id, Product product) {
		// TODO Auto-generated method stub
		Product pro = getProductById(id);
		pro.setName(product.getName());
		pro.setPrice(product.getPrice());
		pro.setDescription(product.getDescription());
		
		if(product.getCategory() != null) {
			Category category = categoryRepo.findById(product.getCategory().getId())
					.orElseThrow(()->new RuntimeException("Category not found"));
			pro.setCategory(category);
		}
		return productRepo.save(pro);
	}

	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
	}

	

}
