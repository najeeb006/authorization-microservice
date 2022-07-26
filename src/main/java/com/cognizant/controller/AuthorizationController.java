package com.cognizant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.exception.ResourceNotFound;
import com.cognizant.model.AuthRequest;
import com.cognizant.model.Token;
import com.cognizant.service.CustomUserDetailService;
import com.cognizant.util.JwtUtil;

import lombok.NoArgsConstructor;



@RestController
@NoArgsConstructor
public class AuthorizationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationController.class);
    @Autowired
	private JwtUtil jwtUtil;
    
    @Autowired
    private CustomUserDetailService userDetailService;
    
    @Autowired
    private AuthenticationManager authenticationManager;

	
	

	
	
	@GetMapping("/")
	public ResponseEntity<String> welcome() {
		LOGGER.info("STARTED authorization microservice welcome");
		LOGGER.info("END - authorization microservice welcome");
		return ResponseEntity.ok("Welcome to security application");
	}


	
	@PostMapping("/authenticate")
	public ResponseEntity<Token> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		LOGGER.info("generateToken has started");
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

		} catch (Exception e) {
			LOGGER.error("EXCEPTION in generateToken");
			throw new ResourceNotFound("user not found");
		}

		LOGGER.info("generateToken has ended");
	
		return ResponseEntity.ok(new Token(jwtUtil.generateToken(authRequest.getUserName())));
	}
	
	

	@GetMapping("/authorize")
	public ResponseEntity<?> authorization(@RequestHeader("Authorization") String token1) {

		LOGGER.info("authorization has started");
		String token = token1.substring(7);

		UserDetails user = userDetailService.loadUserByUsername(jwtUtil.extractUsername(token));

		if (jwtUtil.validateToken(token, user)) {
			LOGGER.info("authorization has ended");
			return new ResponseEntity<>(true, HttpStatus.OK);
		} else {
			LOGGER.info("authorization has ended");
			return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
		}

	}

}
