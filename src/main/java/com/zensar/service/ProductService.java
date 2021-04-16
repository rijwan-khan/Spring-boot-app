package com.zensar.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.zensar.entity.Product;


public interface ProductService {

	Product createProduct(Product product);
	List<Product> getAllProduct();
	Product getOneProduct(Long pid);
	Optional<Set<Product>> getByName(String catName);
    Set<Product> getProdByCat(String catName);
}
