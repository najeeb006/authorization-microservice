package com.cognizant.model.test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.User;

@SpringBootTest
public class UserModelTest {
	@Test
	public void NoArgsUserTest() {
		User user =new User();
		assertNotNull(user);
	}
	@Test
	public void AllArgsUserTest() {
		User user =new User(1,"Najeeb","password");
		assertNotNull(user);
	}
	@Test
	public void SetterArgsUserTest() {
		User user =new User();
		user.setId(1);
		user.setUserName("Najeeb");
		user.setPassword("password");
		assertNotNull(user);
	}
	@Test
	public void GetterArgsUserTest() {
		User user =new User(1,"Najeeb","password");
		assertEquals(1,user.getId());
		assertEquals("Najeeb",user.getUserName());
		assertEquals("password",user.getPassword());
	}
	

}
