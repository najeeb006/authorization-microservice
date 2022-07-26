package com.cognizant.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.exception.ResourceNotFound;

@SpringBootTest
public class ResourceNotFoundTest {
	@Test
	public void NoArgsTest() {
		ResourceNotFound resource = new ResourceNotFound();
		assertNotNull(resource);
		
	}
	@Test
	public void AllArgsTest() {
		ResourceNotFound resource = new ResourceNotFound("message");
		assertNotNull(resource);
		
	}
	@Test
	public void SetterArgsTest() {
		ResourceNotFound resource = new ResourceNotFound();
		resource.setMessage("message");
		assertNotNull(resource);
		
	}
	@Test
	public void GetterArgsTest() {
		ResourceNotFound resource = new ResourceNotFound("message");
		assertEquals("message",resource.getMessage());
		
	}

}
