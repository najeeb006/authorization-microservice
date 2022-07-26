package com.cognizant.swagger.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.config.SwaggerConfig;

@SpringBootTest
public class SwaggerTest {
	@Autowired
	private SwaggerConfig swaggerConfig;
	@Test
	public void contextLoads() {
		assertNotNull(swaggerConfig);
	}

}
