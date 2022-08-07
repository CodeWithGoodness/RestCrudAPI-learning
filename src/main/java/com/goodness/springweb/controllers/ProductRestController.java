package com.goodness.springweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goodness.springweb.entities.Products;
import com.goodness.springweb.repos.ProductRepository;

@RestController

public class ProductRestController {

	@Autowired
	ProductRepository repository;

	// Returns all products
	@RequestMapping(value = "/products/", method = RequestMethod.GET)
	public List<Products> getProducts() {
		return repository.findAll();
	}

	// Returns a single product
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public Products getProduct(@PathVariable("id") int id) {
		return repository.findById(id).get();

	}

	// Create a product
	@RequestMapping(value = "/products/", method = RequestMethod.POST)
	public Products createProduct(@RequestBody Products product) {
		return repository.save(product);
	}

	// Update a product
	@RequestMapping(value = "/products/", method = RequestMethod.PUT)
	public Products updateProduct(@RequestBody Products product) {
		return repository.save(product);
	}

	// Delete a product
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id) {
		repository.deleteById(id);
	}
}
