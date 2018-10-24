package com.search.product.api.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.search.product.api.dao.SearchDao;
import com.search.product.api.model.Product;
import com.search.product.api.model.SearchCriteria;
import com.search.product.api.util.Utils;

@Repository("searchDao")
public class SearchDaoImpl implements SearchDao {

	@Override
	public List<Product> getProducts(SearchCriteria searchCriteria) {
		return Utils.getProducts();
	}

	@Override
	public List<Product> getAllProducts() {
		return Utils.getProducts();
	}

}
