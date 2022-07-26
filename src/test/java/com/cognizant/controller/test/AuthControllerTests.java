package com.cognizant.controller.test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.controller.AuthorizationController;
import com.cognizant.filter.JwtFilter;
import com.cognizant.model.AuthRequest;
import com.cognizant.service.CustomUserDetailService;
import com.cognizant.util.JwtUtil;


@SpringBootTest
@AutoConfigureMockMvc


public class AuthControllerTests {
	/*@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private AuthorizationController authorizationController;
	@Autowired
	private MockMvc mockMvc;*/
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private AuthorizationController authorizationController;

	@Mock
	private UserDetails userDetails;

	@MockBean
	private CustomUserDetailService authService;

	@MockBean
	private JwtUtil jwtUtil;

	@Autowired
	private JwtFilter filter;

	@MockBean
	private AuthenticationManager authenticationManager;

	private AuthRequest user;

	@BeforeEach
	void generateUserCredentials() {
	}
	@Test
	public void contextLoads() {
		assertNotNull(authorizationController);
	}

	@Test
	@DisplayName("Generate token for valid user")
	public void createAuthenticationTokenTest() throws Exception {
		
		User user = new User("user1", "user1", new ArrayList<>());
		String body = "{\"username\":\"" + user.getUsername() + "\", \"password\":\" " + user.getPassword() + "\"}";
		String jwtToken = jwtUtil.generateToken(user.getUsername());
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/authenticate").content(body)
				.header("Authorization", "Bearer " + jwtToken).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON);
		when(authService.loadUserByUsername(eq("user1"))).thenReturn(user);
		
		mockMvc.perform(request).andExpect(status().is2xxSuccessful()).andExpect(status().isOk()).andReturn();
		
	}
	@Test
	@DisplayName("Invalid token")
	public void authorizationTest() throws Exception {
	
		User user = new User("user1", "user1", new ArrayList<>());
		String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MjcwMzk2NzcsInN1YiI6ImFkbWluMSIsImV4cCI6MTY1ODU3NTY3N30.trkCUngtLG8C1W6obvcGvQhCK1J9qg2Hsbcn8GJB95Y";
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.get("/authorize")
				.header("Authorization", token)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_VALUE);
		when(authService.loadUserByUsername(eq("user1"))).thenReturn(user);
		when(jwtUtil.validateToken(token.substring(7), user)).thenReturn(true);
		
		mockMvc.perform(request).andExpect(status().isForbidden()).andReturn();
		
	}

	
	
	

}