package com.search.product.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.search.product.api.dao.SearchDao;
import com.search.product.api.model.Product;
import com.search.product.api.model.SearchCriteria;
import com.search.product.api.service.SearchService;

@Transactional
@Service("searchService")
public class SearchServiceImpl implements SearchService {
	private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

	@Autowired
	private SearchDao searchDao;

	@Override
	public List<Product> getProductsByName(SearchCriteria searchCriteria) {
		List<Product> products = searchDao.getProducts(searchCriteria);
		List<Product> filteredProducts = products.stream()
				.filter(product -> product.getName().equalsIgnoreCase(searchCriteria.getName()))
				.collect(Collectors.toList());
		products.forEach(product -> logger.info(product.toString() + " "));
		return filteredProducts;
	}

	@Override
	public List<Product> getProductsByRating(SearchCriteria searchCriteria) {
		List<Product> products = searchDao.getProducts(searchCriteria);
		List<Product> filteredProducts = products.stream()
				.filter(product -> product.getRating().equalsIgnoreCase(searchCriteria.getRating()))
				.collect(Collectors.toList());
		products.forEach(product -> logger.info(product.toString() + " "));
		return filteredProducts;
	}

	@Override
	public List<Product> getProductsUnderGivenPrice(SearchCriteria searchCriteria) {
		List<Product> products = searchDao.getProducts(searchCriteria);
		List<Product> filteredProducts = products.stream()
				.filter(product -> product.getPrice() < searchCriteria.getPrice()).collect(Collectors.toList());
		products.forEach(product -> logger.info(product.toString() + " "));
		return filteredProducts;
	}

	@Override
	public List<Product> getProductsByCategory(SearchCriteria searchCriteria) {
		List<Product> products = searchDao.getProducts(searchCriteria);
		List<Product> filteredProducts = products.stream()
				.filter(product -> product.getCategory().equalsIgnoreCase(searchCriteria.getCategory()))
				.collect(Collectors.toList());
		products.forEach(product -> logger.info(product.toString() + " "));
		return filteredProducts;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = searchDao.getAllProducts();
		products.forEach(product -> logger.info(product.toString() + " "));
		return products;
	}

}
