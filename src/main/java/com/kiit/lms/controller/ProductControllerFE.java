package com.kiit.lms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiit.lms.dto.ProductDTO;
import com.kiit.lms.model.Product;
import com.kiit.lms.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/kiit/ecom")
@RequiredArgsConstructor
public class ProductControllerFE {
	
	private final ProductService productService;
	
	@GetMapping("/test")
	public String test(Model model)
	{
		model.addAttribute("player","Virat Kohli");
		return "virat";
	}
	
	@GetMapping("/add-product-form")
	public String addProductForm(Model model)
	{
		Product product=new Product();
		model.addAttribute("product",product);
		return "add-product-form";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute ProductDTO product, Model model)
	{
		model.addAttribute("title" , product.getTitle());
		productService.addProductByDTO(product);
		//return "confirm";
		return "redirect:/kiit/ecom/showProducts";
	}
	
	@GetMapping("/showProducts")
	public String showProducts(Model model)
	{
		
		List<Product> allProducts=productService.getAllProducts();
		model.addAttribute("products", allProducts);
		return "show-products";
	}
	
	@GetMapping("/deleteProductFE/{pno}")
	public String showProducts(@PathVariable int pno)
	{
		productService.deleteProduct(pno);
		return "redirect:/kiit/ecom/showProducts";
	}

}
