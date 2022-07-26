package com.cognizant.service.test ;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cognizant.model.User;
import com.cognizant.repository.UserRepository;
import com.cognizant.service.CustomUserDetailService;

@SpringBootTest
public class CustomUserDetailServiceTest {

	
	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private CustomUserDetailService service;
	
	@Test
	public void contextLoads() {
		assertNotNull(service);
	}
	@Test
	public void contextLoads1() {
		assertNotNull(userRepository);
	}
	
	

	@Test
	public void loadUserByUserNameTest() {
		when(userRepository.findByUserName("admin")).thenReturn(new User(1,"admin","admin"));
		assertThat(service.loadUserByUsername("admin")).isNotNull();
		verify(userRepository, Mockito.times(1)).findByUserName("admin");
	}
	

	
	

	
}
