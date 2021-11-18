package com.axis.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.axis.model.Product;

public interface IProductDao extends MongoRepository<Product, Integer> {
List<Product> findProductByCategory(String category);//parameter name and type (category) must be same as defined in model class
}
