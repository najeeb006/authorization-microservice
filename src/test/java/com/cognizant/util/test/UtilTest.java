package com.cognizant.util.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.exception.ResourceNotFound;
import com.cognizant.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class UtilTest {
	@Autowired
	private JwtUtil jwtUtil;
	@Test
	public void test() {
		assertNotNull(jwtUtil);
		
		
	}
	


}
