package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Product;
import com.zensar.entity.ProductCategory;
import com.zensar.repository.ProductCategoryRepo;
import com.zensar.repository.ProductRepo;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@CrossOrigin("*")
public class ProductCategoryController {
	
	private static final Logger logger = LogManager.getLogger(ProductCategoryController.class);
	 
	@Autowired
	private ProductCategoryRepo repo;
	@Autowired
	private ProductRepo pRepo;

	@PostMapping("/saveProd")
	public ProductCategory productCategory(@RequestBody ProductCategory category) {
		//logger.info("store product by category");
		Set<Product> data = category.getProducts();
		data.stream().forEach((dt) -> pRepo.save(dt));
		ProductCategory categoryData = repo.save(category);
		return categoryData;
	}

}
