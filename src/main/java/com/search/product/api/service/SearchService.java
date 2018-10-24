package com.search.product.api.service;

import java.util.List;

import com.search.product.api.model.Product;
import com.search.product.api.model.SearchCriteria;

public interface SearchService {

	List<Product> getProductsByName(SearchCriteria searchCriteria);

	List<Product> getProductsByCategory(SearchCriteria searchCriteria);

	List<Product> getProductsByRating(SearchCriteria searchCriteria);

	List<Product> getProductsUnderGivenPrice(SearchCriteria searchCriteria);

	List<Product> getAllProducts();

}
