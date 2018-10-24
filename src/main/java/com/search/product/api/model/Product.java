package com.search.product.api.model;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 4216891139942269567L;
	private String id;
	private String name;
	private String description;
	private String image;
	private String rating;
	private String category;
	private Float price;

	public Product(String id, String name, String description, String image, String rating, String category,
			Float price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.rating = rating;
		this.category = category;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
