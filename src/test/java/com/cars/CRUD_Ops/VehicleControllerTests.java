package com.cars.CRUD_Ops;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cars.CRUD_Ops.controllers.VehicleController;

@RunWith(SpringJUnit4ClassRunner.class)
class VehicleControllerTests {
	@Autowired
	@InjectMocks
	protected VehicleController vehicleController;	
	private MockMvc mvc;

	
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(this.vehicleController).build();
	}
	
	@Test
	public void getAllVehiclesTest() throws Exception {
		String uri = "/vehicles";
		mvc.perform(
				MockMvcRequestBuilders.get(uri)
				).andExpect(MockMvcResultMatchers.status().isOk());
		
	}

}
