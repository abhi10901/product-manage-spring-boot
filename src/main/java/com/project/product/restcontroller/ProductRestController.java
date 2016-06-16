package com.project.product.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.product.domain.Product;
import com.project.product.service.ProductService;

@RestController
@RequestMapping("/rest/product")
public class ProductRestController {
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Product>> getAllProductList() {
		List<Product> productList = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Product> createProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
		Product newProduct = productService.storeProduct(product);
		return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductById(@PathVariable ("id") long id) {
		Product product = productService.getProductById(id);
		
		if(product != null)
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, 
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Product> updateProduct(@PathVariable ("id") long id, @RequestBody Product product) {
		//Product product = productService.getProductById(id);
		Product updatedProduct = productService.storeProduct(product);
		if(updatedProduct != null)
			return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> removeProduct(@PathVariable ("id") long id) {
		Boolean isDeleted = productService.deleteProductById(id);
		if(isDeleted)
			return new ResponseEntity<Product>(HttpStatus.OK);
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}

}
