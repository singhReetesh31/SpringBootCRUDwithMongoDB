package com.axis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document(collection = "product") //replacement for mySQL @Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Product {
	@Id
private int id;
private String name;
private String category;
private double price;

}
