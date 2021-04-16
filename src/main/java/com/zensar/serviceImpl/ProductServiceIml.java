package com.zensar.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.ProductRequest;
import com.zensar.dto.ProductResponse;
import com.zensar.entity.Product;
import com.zensar.repository.ProductCategoryRepo;
import com.zensar.repository.ProductRepo;
import com.zensar.service.ProductService;

@Service
public class ProductServiceIml implements ProductService {
	@Autowired
	private ProductRepo repo;
	@Autowired
	private ProductCategoryRepo productCatRepo;
	// private static ProductMapper mapper = (ProductMapper) new Product();

	@Override
	public Product createProduct(
			Product product) {/*
								 * String catName = product.getCategory().getCategoryName(); ProductCategory
								 * pCat = productCatRepo.findByCategoryName(catName); product.setCategory(pCat);
								 */
		// Product product = mapper.reqToProduct(productRequest);
		// return mapper.prodToResponse(repo.save(product));
		return repo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {

		return repo.findAll();
	}

	@Override
	public Product getOneProduct(Long pid) {

		return repo.findById(pid).get();
	}

	@Override
	public Optional<Set<Product>> getByName(String catName) {
		// Set<Product> prod=productCatRepo.findByCategoryName(catName).getProducts();
		Optional<Set<Product>> prod = repo.findByName(catName);
		return prod;
	}

	@Override
	public Set<Product> getProdByCat(String catName) {
     Set<Product> product = productCatRepo.findByCategoryName(catName).getProducts();
		return product;
	}

}
