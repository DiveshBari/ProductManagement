package com.div.mngprod.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.div.mngprod.Model.Product;
import com.div.mngprod.repo.ProductRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("prodapi")
public class ProductController {	
	
	@Autowired
	ProductRepo prodRepo;
	
	@GetMapping(value = "products", produces = {"application/json", "application/xml"})
	public List<Product> getAllProducts() {
		List<Product> products = prodRepo.findAll();
		return products;
	}
	
	@GetMapping(value = "product/{pid}", produces = {"application/json", "application/xml"})
	public Product getProductFromPid(@PathVariable("pid") int pid) {
		Product prod = prodRepo.findById(pid).get();
		return prod;
	}
	
	@PostMapping(value = "product")
	public Product addProduct(@RequestBody Product prod) {
		Product savedProd = prodRepo.save(prod);
		return savedProd;
	}
	
	@DeleteMapping(value = "product")
	public void deleteProduct(@RequestParam("pid") int pid) {
		prodRepo.deleteById(pid);
	}	
}
