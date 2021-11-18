package com.axis.service;

import java.util.List;

import com.axis.model.Product;

public interface IProductService {
void addProduct(Product product);
List<Product> getAllProduct();
Product getProductById(int id);
void deleteProduct(int id);
List<Product> getProductByCategory(String category);
}
