package com.project.product.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.product.domain.Product;
import com.project.product.service.ProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	private static final String REDIRECT_LIST = "redirect:/product/";
	private static final String REDIRECT_CREATE = REDIRECT_LIST + "create";
	
	private static final String LIST_VIEW = "product/list";
	private static final String CREATE_VIEW = "product/create";
	private static final String EDIT_VIEW = "product/edit";
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;

	private Logger log = LoggerFactory.getLogger(ProductController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String listAllProducts(Model model) {
		
		log.info("Get all product list.");
		model.addAttribute("productList", productService.getAllProducts());
		return LIST_VIEW;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createProduct(Model model) {
		log.info("Adding new Product");
		model.addAttribute("product", new Product());
		return CREATE_VIEW;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String saveProduct(@Valid Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("product", product);
			log.error("Product properties are not valid, please enter valid data.");
			return CREATE_VIEW;
		}
		
		Product newProduct =  productService.storeProduct(product);
		
		if(newProduct == null) {
			log.error("Product not created successfully.");
			return CREATE_VIEW;
		}
		
		log.info("Product create successfully.");
		return REDIRECT_LIST;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editProduct(@PathVariable ("id") long id, Model model) {
		
		log.info("Editing Product with product id : " + id);
		Product product = productService.getProductById(id);
		
		if(product == null) {
			log.error("Product not found with product id : " + id);
			return REDIRECT_LIST;
		}

		model.addAttribute("product", product);
		return EDIT_VIEW;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String updateProduct(@PathVariable ("id") long id, @Valid Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			log.error("Product properties are not valid, please enter valid data.");
			model.addAttribute("product", product);
			return EDIT_VIEW;
		}
		
		Product updatedProduct = productService.storeProduct(product);
		if(updatedProduct == null) {
			log.error("Product not updated with product id : " + id);
			return EDIT_VIEW;
		}
		
		log.info("Product updated successfully with product id : " + id);
		return REDIRECT_LIST;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable ("id") long id) {
		boolean isDeleted = productService.deleteProductById(id);
		
		if(!isDeleted) 
			log.info("Product not deleted successfully, may be product not found with provided id.");
		else log.info("Product removed successfully with product id : " + id);
		return REDIRECT_LIST;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> addProduct(HttpServletResponse response, Product product, Model model) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		//response.setStatus(HttpStatus.CREATED);

		Product newProduct = productService.storeProduct(product);

		jsonMap.put("status", "created");
		jsonMap.put("product", newProduct);
		return jsonMap;
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, Object> updateProduct(Product product) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		Product updatedProduct = productService.storeProduct(product);

		jsonMap.put("status", "updated");
		jsonMap.put("product", updatedProduct);
		return jsonMap;
	}
}
