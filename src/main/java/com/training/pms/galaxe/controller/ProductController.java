package com.training.pms.galaxe.controller;

import java.util.List;


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

import com.training.pms.galaxe.dao.ProductDao;
import com.training.pms.galaxe.modal.Product;
import com.training.pms.galaxe.service.ProductServiice;

@RestController
@RequestMapping("product")
public class ProductController {
		
		@Autowired
		ProductServiice productservice;
		@GetMapping
		
		public ResponseEntity<List<Product>> getProducts() {
			List<Product> products = productservice.getProduct();
					
			ResponseEntity<List<Product>> responseEntity;

			if(products.isEmpty()) {
				responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.NO_CONTENT);
			}
			else
			{
				responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.OK);
			}
			return responseEntity;
		}
		
//		@GetMapping("{productid}")
//		public ResponseEntity<Product>getProduct(@PathVariable("productid") Integer productid ) {
//			Product products = productservice.getProduct(productid);
//			ResponseEntity<Product> responseEntity;
//			if(productservice.products.isEmpty(productid)) {
//				responseEntity = new ResponseEntity<Product>(products, HttpStatus.NO_CONTENT);
//			}
//			else
//			{
//				responseEntity = new ResponseEntity<Product>(products, HttpStatus.OK);
//			}
//			return responseEntity;
//			
//			
//			
//		}
		@GetMapping("{productId}")
		public ResponseEntity<Product> getProduct(@PathVariable("productId") Integer productId) {
		
			ResponseEntity<Product> responseEntity;
			Product message = new Product();
			if(productservice.isProductExists(productId)) {
				
				message = productservice.getProduct(productId);
				responseEntity = new ResponseEntity<Product>(message, HttpStatus.OK);
				
			}
			
			else {
				responseEntity = new ResponseEntity<Product>(message, HttpStatus.CONFLICT);
			}
			return responseEntity;
		}
		
		@DeleteMapping("{productId}") 
	    public ResponseEntity<String> deleteProduct(@PathVariable("productId") Integer productId) {
	        ResponseEntity<String> responseEntity;
	        if (productservice.isProductExists(productId)) {
	            String message = productservice.deleteProduct(productId);
	            responseEntity = new ResponseEntity<String>(message,
	                    HttpStatus.OK);
	        } else {
	            String errorMessage = "No Such Product ID Exists";
	            responseEntity = new ResponseEntity<String>(errorMessage, HttpStatus.NO_CONTENT);
	        }
	        return responseEntity;
	    }
		@PostMapping()					//http://localhost:9090/product/		-POST		-BODY (product) 102
		public ResponseEntity<String> saveProduct(@RequestBody Product product) {
			ResponseEntity<String> responseEntity;
			int pId = product.getProductid();
			if(productservice.isProductExists(pId)) {
				responseEntity = new ResponseEntity<String>("Product with product id :"+pId+" already exists", HttpStatus.CONFLICT);
			}
			else
			{
				String message = productservice.saveProduct(product);
				responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
			}
			return responseEntity;
		}
		
		@PutMapping()
	    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
	        ResponseEntity<String> responseEntity;
	        int pId = product.getProductid();
	        if(!productservice.isProductExists(pId)) {
	            responseEntity = new ResponseEntity<String>("Product with product id :"+pId+" Doesn't Exists", HttpStatus.NOT_FOUND);
	        }
	        else
	        {
	            String message = productservice.updateProduct(product);
	            responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
	        }
	        return responseEntity;


	        
	     
	        
	    }
		@GetMapping("searchByProductName/{productName}")
		public ResponseEntity<List<Product>> getProductByName(@PathVariable("productName") String productName) {
		
			ResponseEntity<List<Product>> responseEntity;
			List<Product> products  = productservice.searchProduct(productName);
			if(products.isEmpty()) {
				responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.NO_CONTENT);
			}
			else
			{
				responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.OK);
			}
			return responseEntity;
		}
		
		@GetMapping("searchByPriceRange/{min}/{max}") 
		public ResponseEntity<List<Product>> getProductByPriceRange(@PathVariable("min") Integer min,@PathVariable("max") Integer max) {
		
			ResponseEntity<List<Product>> responseEntity;
			List<Product> products  = productservice.searchProduct( min, max);
			if(products.isEmpty()) {
				responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.NO_CONTENT);
			}
			else
			{
				responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.OK);
			}
			return responseEntity;}

		
}
