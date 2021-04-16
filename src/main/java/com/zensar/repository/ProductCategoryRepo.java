package com.zensar.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.entity.ProductCategory;


@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Integer>{

	ProductCategory findByCategoryName(String catName);
	

}
