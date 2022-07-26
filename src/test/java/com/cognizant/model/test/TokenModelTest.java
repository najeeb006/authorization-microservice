package com.cognizant.model.test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.Token;

@SpringBootTest
public class TokenModelTest {
	@Test
	public void NoArgsTokenTest() {
		Token token = new Token();
		assertNotNull(token);
		
	}
	@Test
	public void AllArgsTokenTest() {
		Token token = new Token("ewhejwrewfrew");
		assertNotNull(token);
	}
	@Test
	public void SetterTokenTest() {
		Token token = new Token();
		token.setToken("eqweqweqw");
		assertEquals("eqweqweqw",token.getToken());
		assertNotNull(token);
	}
	@Test
	public void GetterTokenTest() {
		Token token = new Token("eqweqweqw");
		assertEquals("eqweqweqw",token.getToken());
	}
	

}
