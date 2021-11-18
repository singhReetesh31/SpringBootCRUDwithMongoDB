package com.axis.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.exception.IDNotFoundException;
import com.axis.exception.IdMisMatchedException;
import com.axis.model.Product;
import com.axis.service.IProductService;

@RestController
@RequestMapping(value="/product")
public class ProductController {
	@Autowired
private IProductService service;
	@PostMapping(value="/addProduct")
	public void addProduct(@RequestBody Product product) {
		service.addProduct(product);
	}
	
	@GetMapping(value="/getAllProduct")
	public ResponseEntity<List<Product>> getAllProduct(){
		return new ResponseEntity<List<Product>>(service.getAllProduct(),HttpStatus.OK);
	}
	
	@GetMapping(value="/getProductById/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) throws IDNotFoundException{
		
		try {
		Product	p=service.getProductById(id);
		return new ResponseEntity<Product>(p,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			throw new IDNotFoundException("Id is not Found");
		}
		
	}
	@DeleteMapping(value="/deleteProduct/{id}")
	public void deleteProduct(@PathVariable int id) throws IDNotFoundException {
		try {
			Product p=service.getProductById(id);
			service.deleteProduct(id);
		}catch(NoSuchElementException e) {
			throw new IDNotFoundException("No Id Found to delete a product");
		}
		
	}
	@PutMapping(value="/updateProduct/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable int id) throws IDNotFoundException, IdMisMatchedException{
		try {
			Product p=service.getProductById(id);
			if(product.getId()!=id) {//one user can't edit other user product
			throw new IdMisMatchedException("ID doesn't match");
			}
			service.addProduct(product);
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			throw new IDNotFoundException("No Id found to update");
		}
	}
	//===================Find product by Category======================
	@GetMapping(value="/getProductByCategory/{category}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category){
		return new ResponseEntity<List<Product>>(service.getProductByCategory(category),HttpStatus.OK);
	}
}
