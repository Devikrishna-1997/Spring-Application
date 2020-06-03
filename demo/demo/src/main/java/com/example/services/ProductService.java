package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.example.models.Products;

@Service
public class ProductService {
	
	public List<Products> getAllProducts(){
		List<Products> listOfProducts = new ArrayList();
		listOfProducts.add(new Products("111","Iphone","Awesome",100000.00,"Apple"));
		listOfProducts.add(new Products("222","Redmi k20 Pro","Awesome",30000.00,"MI"));
		listOfProducts.add(new Products("333","Realme","ok",10000.00,"mi"));
		
		return listOfProducts;
		
	}
	public Products getProductById(String id) {

		Predicate<Products> byId = p -> p.getId().equals(id);
		return filterProducts(byId);
	}

	public Products filterProducts(Predicate<Products> strategy) {
		return getAllProducts().stream().filter(strategy).findFirst().orElse(null);
	}

}
