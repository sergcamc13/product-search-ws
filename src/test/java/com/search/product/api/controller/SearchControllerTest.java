package com.search.product.api.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.search.product.api.dao.SearchDao;
import com.search.product.api.model.Product;
import com.search.product.api.model.SearchCriteria;
import com.search.product.api.service.SearchService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:*/application-context-test.xml")
@WebAppConfiguration
public class SearchControllerTest {

	@Mock
	private SearchService searchService;

	@Mock
	private SearchDao searchDao;

	@InjectMocks
	private SearchController searchController;

	private MockMvc mockMvc;

	private List<Product> products;

	private SearchCriteria searchCriteria;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(searchController).build();

		products = Arrays.asList(
				new Product("0001", "Laptop Acer Aspire E 15",
						"15.6 Full HD, 8th Gen Intel Core i3-8130U, 6GB RAM Memory, 1TB HDD, 8X DVD, E5-576-392H",
						"Acer_Aspire_E15.jpg", "4.5", "Laptops", 359.99F),
				new Product("0002", "Samsung 55NU7100 Flat 55",
						"Smart TV: Access your streaming services all in one place using the Samsung Remote Control",
						"Samsung 55NU7100.jpg", "5", "Televisions", 547.99F));

		searchCriteria = new SearchCriteria("Laptop Acer Aspire E 15",
				"15.6 Full HD, 8th Gen Intel Core i3-8130U, 6GB RAM Memory, 1TB HDD, 8X DVD, E5-576-392H", "4.5",
				"Laptops", 359.99F);

	}

	@Test
	public void testGetProductsByCategory() throws Exception {
		when(searchService.getProductsByCategory(searchCriteria)).thenReturn((List<Product>) products);
		mockMvc.perform(MockMvcRequestBuilders.get("/products/bycategory"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(MockMvcResultHandlers.print()).andReturn();
	}

	@Test
	public void testGetProductsByName() throws Exception {
		when(searchService.getProductsByCategory(searchCriteria)).thenReturn((List<Product>) products);
		mockMvc.perform(MockMvcRequestBuilders.get("/products/byname")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(MockMvcResultHandlers.print()).andReturn();
	}

	@Test
	public void testGetProductsByRating() throws Exception {
		when(searchService.getProductsByCategory(searchCriteria)).thenReturn((List<Product>) products);
		mockMvc.perform(MockMvcRequestBuilders.get("/products/byrating"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(MockMvcResultHandlers.print()).andReturn();
	}

	@Test
	public void testGetProductsUnderGivenPrice() throws Exception {
		when(searchService.getProductsByCategory(searchCriteria)).thenReturn((List<Product>) products);
		mockMvc.perform(MockMvcRequestBuilders.get("/products/undergivenprice"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(MockMvcResultHandlers.print()).andReturn();
	}

}
