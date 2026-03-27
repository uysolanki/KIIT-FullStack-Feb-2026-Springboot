package com.kiit.lms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kiit.lms.model.Product;
import com.kiit.lms.model.Rating;
import com.kiit.lms.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/kiit/ecom/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	@PostMapping("/add-product-by-requestparam")
	public ResponseEntity<Product> addProductByRequestparam(
			@RequestParam("a") String prodTitle,
			@RequestParam("b") double prodPrice,
			@RequestParam("c") String prodDesc,
			@RequestParam("d") String prodCategory,
			@RequestParam("e") String prodImage,
			@RequestParam("f") double prodRatingRate,
			@RequestParam("g") int prodRatingCount)
	{
		Product product=Product.builder()
				.title(prodTitle)
				.price(prodPrice)
				.description(prodDesc)
				.category(prodCategory)
				.image(prodImage)
				.rating(
						Rating.builder()
						.rate(prodRatingRate)
						.count(prodRatingCount)
						.build())
				.build();
		
		
		Product savedPrduct=productService.addProduct(product);
		return  new ResponseEntity<Product>(savedPrduct,HttpStatus.CREATED);	
	}
	
	
	@PostMapping("/add-product-by-requestparam1")
	public ResponseEntity<Product> addProductByRequestparam1(
			@RequestParam String prodTitle,
			@RequestParam double prodPrice,
			@RequestParam String prodDesc,
			@RequestParam String prodCategory,
			@RequestParam String prodImage,
			@RequestParam double prodRatingRate,
			@RequestParam int prodRatingCount)
	{
		Product product=Product.builder()
				.title(prodTitle)
				.price(prodPrice)
				.description(prodDesc)
				.category(prodCategory)
				.image(prodImage)
				.rating(
						Rating.builder()
						.rate(prodRatingRate)
						.count(prodRatingCount)
						.build())
				.build();
		
		
		Product savedPrduct=productService.addProduct(product);
		return  new ResponseEntity<Product>(savedPrduct,HttpStatus.CREATED);	
	}
	
	@PostMapping("/add-product-by-path-variable/{a}/{b}/{c}/{d}/{e}/{f}/{g}")
	public ResponseEntity<Product> addProductByPathVariable(
			@PathVariable("a") String prodTitle,
			@PathVariable("b") double prodPrice,
			@PathVariable("c") String prodDesc,
			@PathVariable("d") String prodCategory,
			@PathVariable("e") String prodImage,
			@PathVariable("f") double prodRatingRate,
			@PathVariable("g") int prodRatingCount)
	{
		Product product=Product.builder()
				.title(prodTitle)
				.price(prodPrice)
				.description(prodDesc)
				.category(prodCategory)
				.image(prodImage)
				.rating(
						Rating.builder()
						.rate(prodRatingRate)
						.count(prodRatingCount)
						.build())
				.build();
		
		
		Product savedPrduct=productService.addProduct(product);
		return  new ResponseEntity<Product>(savedPrduct,HttpStatus.CREATED);	
	}
	
	@PostMapping("/add-product-by-path-variable1/{prodTitle}/{prodPrice}/{prodDesc}/{prodCategory}/{prodImage}/{prodRatingRate}/{prodRatingCount}")
	public ResponseEntity<Product> addProductByPathVariable1(
			@PathVariable String prodTitle,
			@PathVariable double prodPrice,
			@PathVariable String prodDesc,
			@PathVariable String prodCategory,
			@PathVariable String prodImage,
			@PathVariable double prodRatingRate,
			@PathVariable int prodRatingCount)
	{
		Product product=Product.builder()
				.title(prodTitle)
				.price(prodPrice)
				.description(prodDesc)
				.category(prodCategory)
				.image(prodImage)
				.rating(
						Rating.builder()
						.rate(prodRatingRate)
						.count(prodRatingCount)
						.build())
				.build();
		
		
		Product savedPrduct=productService.addProduct(product);
		return  new ResponseEntity<Product>(savedPrduct,HttpStatus.CREATED);	
	}
	
	@PostMapping("/add-product-by-body")
	public ResponseEntity<Product> addProductByRequestBody(@RequestBody Product product)
	{		
		Product savedPrduct=productService.addProduct(product);
		return  new ResponseEntity<Product>(savedPrduct,HttpStatus.CREATED);	
	}
	
	@PostMapping("/add-product-list")
	public ResponseEntity<List<Product>> addProductList(@RequestBody List<Product> products)
	{		
		return  new ResponseEntity<List<Product>>(productService.addProducts(products),HttpStatus.CREATED);	
	}
}


/*
{
"id": 3,
"title": "Mens Casual Premium Slim Fit T-Shirts",
"price": 22.3,
"description": "Slim-fitting style, contrast raglan long sleeve",
"category": "men's clothing",
"image": "testimage",
"rating": {
    "ratingId": 3,
    "rate": 4.1,
    "count": 259
}
}
*/