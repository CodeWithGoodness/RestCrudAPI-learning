package com.goodness.springweb;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.goodness.springweb.entities.Products;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductrestapiApplicationTests {
	
	@Value("${productrestapi.services.url}")
	private String baseURL;

	@Test
	public void testGetProduct() {
		System.out.println (baseURL);
		RestTemplate restTemplate = new RestTemplate();
		Products products = restTemplate.getForObject(baseURL+"1",
				Products.class);
		assertNotNull(products);
		assertEquals("Weavon", products.getName());
	}

	@Test
	public void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Products product = new Products();
		product.setName("Calculator");
		product.setDescription("Casio");
		product.setPrice(1200);
		Products newProduct = restTemplate.postForObject(baseURL, product,Products.class);
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Calculator", newProduct.getName());
	}

	@Test
	public void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Products newProduct = restTemplate.getForObject(baseURL + "1",Products.class);
		newProduct.setName("Weavon");
		restTemplate.put(baseURL, newProduct);

	}

}
