package com.lambazon.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.lambazon.domain.Product;
import com.lambazon.service.ProductService;


/**
 * 
 * @author stanlick
 *
 *   This class will demonstrate whether Spring MVC controllers are working as expected
 *   
 *   @WebMvcTest also auto-configures MockMvc. Mock MVC offers a powerful way to quickly test MVC controllers without needing to start a full HTTP server.
 *   	used in combination with @MockBean to provide mock implementations for required collaborators
 */

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerMockTests {
	
	@Inject
	private MockMvc mvc;
	
	@MockBean
	private ProductService userVehicleService;

	@Test
	public void request_valid_product() throws Exception  {
		given(userVehicleService.product(42L))
								.willReturn(new Product(42, 1, 25.00, "name", "description"));
		
		mvc.perform(get("/products/42/details")
					.accept(MediaType.TEXT_HTML))
					.andExpect(status().isOk());
	}
}
