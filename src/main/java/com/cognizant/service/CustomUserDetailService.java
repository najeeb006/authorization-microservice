package com.cognizant.service;

import java.util.ArrayList;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.exception.ResourceNotFound;
import com.cognizant.model.User;
import com.cognizant.repository.UserRepository;

@Service

public class CustomUserDetailService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailService.class);

	private UserRepository userRepository;

	@Autowired
	public CustomUserDetailService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
		LOGGER.info("loadUserByUsername has started");
		User user = userRepository.findByUserName(username);
		LOGGER.info("loadUserByUsername has ended");
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				new ArrayList<>());
		
		}catch(Exception e)
		{
			LOGGER.error("ERROR-username not found");
			throw new ResourceNotFound("User by the given username not found");
		}
		
	}

}
