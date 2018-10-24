package com.search.product.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.search.product.api.model.Product;
import com.search.product.api.model.SearchCriteria;
import com.search.product.api.service.SearchService;

@RestController
@RequestMapping("/products")
public class SearchController {

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@Autowired
	private SearchService searchService;

	@PostMapping("/bycategory")
	public ResponseEntity<Object> findProductsByCategory(HttpServletRequest request,
			@RequestBody SearchCriteria searchCriteria) {
		logger.info("Search Criteria: " + searchCriteria.toString());
		List<String> validationErrors = new ArrayList<>();
		if (searchCriteria == null || StringUtils.isEmpty(searchCriteria.getCategory())) {
			validationErrors.add("Product Category must be provided.");
		}
		if (CollectionUtils.isNotEmpty(validationErrors)) {
			return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
		}
		List<Product> products = searchService.getProductsByCategory(searchCriteria);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@PostMapping("/byname")
	public ResponseEntity<Object> findProductsByName(HttpServletRequest request,
			@RequestBody SearchCriteria searchCriteria) {
		logger.info("Search Criteria: " + searchCriteria.toString());
		List<String> validationErrors = new ArrayList<>();
		if (searchCriteria == null || StringUtils.isEmpty(searchCriteria.getName())) {
			validationErrors.add("Product Name must be provided.");
		}
		if (CollectionUtils.isNotEmpty(validationErrors)) {
			return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
		}
		List<Product> products = searchService.getProductsByName(searchCriteria);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@PostMapping("/byrating")
	public ResponseEntity<Object> findProductsByRating(HttpServletRequest request,
			@RequestBody SearchCriteria searchCriteria) {
		logger.info("Search Criteria: " + searchCriteria.toString());
		List<String> validationErrors = new ArrayList<>();
		if (searchCriteria == null || StringUtils.isEmpty(searchCriteria.getRating())) {
			validationErrors.add("Product Rating must be provided.");
		}
		if (CollectionUtils.isNotEmpty(validationErrors)) {
			return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
		}
		List<Product> products = searchService.getProductsByRating(searchCriteria);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@PostMapping("/undergivenprice")
	public ResponseEntity<Object> findProductsUnderGivenPrice(HttpServletRequest request,
			@RequestBody SearchCriteria searchCriteria) {
		logger.info("Search Criteria: " + searchCriteria.toString());
		List<String> validationErrors = new ArrayList<>();
		if (searchCriteria == null || StringUtils.isEmpty(searchCriteria.getPrice())) {
			validationErrors.add("Product Price must be provided.");
		}
		if (CollectionUtils.isNotEmpty(validationErrors)) {
			return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
		}
		List<Product> products = searchService.getProductsUnderGivenPrice(searchCriteria);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@RequestMapping("/all")
	public ResponseEntity<Object> getAllProducts(HttpServletRequest request) {
		List<Product> products = searchService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

}
