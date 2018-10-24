package com.search.product.api.model;

import java.io.Serializable;

public class SearchCriteria implements Serializable {
	private static final long serialVersionUID = -8103376319898813887L;
	private String name;
	private String description;
	private String rating;
	private String category;
	private Float price;

	public SearchCriteria() {
		super();
	}

	public SearchCriteria(String name, String description, String rating, String category, Float price) {
		super();
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.category = category;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}
