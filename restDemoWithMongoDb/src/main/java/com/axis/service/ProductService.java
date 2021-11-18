package com.axis.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dao.IProductDao;
import com.axis.model.Product;
@Service
public class ProductService implements IProductService {
	@Autowired
private IProductDao dao;
	@Override
	public void addProduct(Product product) {
		dao.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return dao.findAll();
	}

	@Override
	public Product getProductById(int id) throws NoSuchElementException{
		Product p=dao.findById(id).get();
		return p;
	}

	@Override
	public void deleteProduct(int id) {
		dao.deleteById(id);
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		return dao.findProductByCategory(category);
	}

}
