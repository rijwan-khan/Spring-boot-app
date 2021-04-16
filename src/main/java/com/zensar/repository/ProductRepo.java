package com.zensar.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.entity.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
	
	Optional<Set<Product>> findByName(String name);
	

}
