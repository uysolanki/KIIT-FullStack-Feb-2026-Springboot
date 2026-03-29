package com.kiit.lms.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiit.lms.dto.ProductDTO;
import com.kiit.lms.dto.RatingDTO;
import com.kiit.lms.exception.ResourseNotFoundException;
import com.kiit.lms.model.Product;
import com.kiit.lms.model.Rating;
import com.kiit.lms.repository.ProductRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	@Autowired
	ModelMapper modelMapper;
	
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
	public ProductDTO addProductByDTO(ProductDTO productDto)
	{
		// Convert DTO → Entity
        Product product = modelMapper.map(productDto, Product.class);

        Product savedProduct = productRepository.save(product);

        // Convert Entity → ResponseDTO
        return modelMapper.map(savedProduct, ProductDTO.class);

	}
	public List<Product> findProductByPrice(double prodPrice) {
		return productRepository.findByPriceGreaterThan(prodPrice);
	}
	public void deleteProduct(int prodId) {
		if(!productRepository.existsById(prodId))
			throw new ResourseNotFoundException("Product with ID " +prodId + " does not exist");
		
		productRepository.deleteById(prodId);
	}
	public ProductDTO updateProduct(int prodId, @Valid ProductDTO newValues) {
		if(!productRepository.existsById(prodId))
			throw new ResourseNotFoundException("Product with ID " +prodId + " does not exist");
		
		Product productFromDB=getProduct(prodId);
		productFromDB.setCategory(newValues.getCategory());
		productFromDB.setDescription(newValues.getDescription());
		productFromDB.setImage(newValues.getImage());
		productFromDB.setPrice(newValues.getPrice());
		productFromDB.setRating(Rating.builder()
				.rate(newValues.rating.rate)
				.count(newValues.rating.count)
				.build());
		productFromDB.setTitle(newValues.getTitle());
		
		return modelMapper.map(productRepository.save(productFromDB), ProductDTO.class);
		
	}
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

}
