package com.div.mngprod.repo;

import org.springframework.stereotype.Repository;
import com.div.mngprod.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
}
