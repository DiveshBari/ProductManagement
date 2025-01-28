package com.div.mngprod.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.div.mngprod.Model.Product;
import com.div.mngprod.repo.ProductRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ProductController {	
	
	@Autowired
	ProductRepo prodRepo;
	
	@GetMapping(produces = {"application/json", "application/xml"})
	@RequestMapping("products")
	public List<Product> getAllProducts() {
		List<Product> products = prodRepo.findAll();
		return products;
	}
	
	@GetMapping(produces = {"application/json", "application/xml"})
	@RequestMapping("product/{pid}")
	public Product getProductFromPid(@PathVariable("pid") int pid) {
		Product prod = prodRepo.findById(pid).get();
		return prod;
	}
	
	@PostMapping("product")
	public void addProduct(@RequestBody Product prod) {
		prodRepo.save(prod);
	}
	
}
