package com.search.product.api.dao;

import java.util.List;

import com.search.product.api.model.Product;
import com.search.product.api.model.SearchCriteria;

public interface SearchDao {

	List<Product> getProducts(SearchCriteria searchCriteria);

	List<Product> getAllProducts();

}
