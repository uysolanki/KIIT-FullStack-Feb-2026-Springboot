package com.kiit.lms.service;

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

}
