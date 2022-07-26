package com.cognizant.model.test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.AuthRequest;

@SpringBootTest
public class AuthRequestModelTest {
	@Test
	public void NoAuthRequestTest() {
		AuthRequest auth = new AuthRequest();
		assertNotNull(auth);
	}
	@Test
	public void AllAuthRequestTest() {
		AuthRequest auth = new AuthRequest("Najeeb","password");
		assertNotNull(auth);
	}
	@Test
	public void SetterAuthRequestTest() {
		AuthRequest auth = new AuthRequest();
		auth.setUserName("Najeeb");
		auth.setPassword("password");
		assertEquals("Najeeb",auth.getUserName());
		assertEquals("password",auth.getPassword());
		assertNotNull(auth);
	}
	@Test
	public void GetterAuthRequestTest() {
		AuthRequest auth = new AuthRequest("Najeeb","password");
		
		assertEquals("Najeeb",auth.getUserName());
		assertEquals("password",auth.getPassword());
	}

}
