package com.kiit.lms.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import com.kiit.lms.model.Product;
import com.kiit.lms.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	public List<Product> addProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}
	public Product getProduct(int prodId) {
		return productRepository.findById(prodId).get();
	}
	public List<Product> getProductByCategory(String prodCategory) {
		return productRepository.findByCategory(prodCategory);
	}

}
