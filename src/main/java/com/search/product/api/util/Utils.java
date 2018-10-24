package com.search.product.api.util;

import java.util.Arrays;
import java.util.List;

import com.search.product.api.model.Product;

public class Utils {

	private Utils() {
		super();
	}

	static List<Product> products = Arrays.asList(
			new Product("0001", "Laptop Acer Aspire E 15",
					"15.6 Full HD, 8th Gen Intel Core i3-8130U, 6GB RAM Memory, 1TB HDD, 8X DVD, E5-576-392H",
					"Acer_Aspire_E15.jpg", "4.5", "Laptops", 359.99F),
			new Product("0002", "Samsung 55NU7100 Flat 55",
					"Smart TV: Access your streaming services all in one place using the Samsung Remote Control",
					"Samsung 55NU7100.jpg", "5", "Televisions", 547.99F),
			new Product("0003", "Pampers Sensitive Water-Based Baby Diaper Wipes",
					"9 Refill Packs for Dispenser Tub - Hypoallergenic and Unscented - 576 Count",
					"81c2+8qlRoL._SX522_.jpg", "4", "Baby Products", 13.86F));

	public static List<Product> getProducts() {
		return products;
	}

}
