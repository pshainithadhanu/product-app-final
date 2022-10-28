package com.training.pms.galaxe.service;

import java.util.List;


import com.training.pms.galaxe.modal.Product;

public interface ProductServiice {
public String saveProduct(Product product);
	
	
	public String updateProduct(Product product);
	public String deleteProduct(int productId);
	public Product getProduct(int productId);
	public List<Product> getProduct();
	
	public boolean isProductExists(int productId);
	
	public List<Product> searchProduct(String productname);
	public List<Product> searchProduct(String productname,int price,int qoh);
	public List<Product> searchPrice(int price);
	public List<Product> searchProduct(int min,int max);
	public List<Product> checkStockStatus(int minStock);
}
