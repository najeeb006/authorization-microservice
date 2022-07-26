package com.cognizant.filter.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.filter.JwtFilter;

@SpringBootTest
public class FilterTest {
	@Autowired
	private JwtFilter jwtFilter;
	@Test
	public void test() {
		assertNotNull(jwtFilter);
		
	}

}
