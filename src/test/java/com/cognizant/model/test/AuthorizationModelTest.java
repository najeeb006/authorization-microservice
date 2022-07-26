package com.cognizant.model.test;

import org.junit.jupiter.api.Test;

import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;


import com.cognizant.model.User;

@SpringBootTest
public class AuthorizationModelTest {
	

	@Test
	void testPensionerBean() {		
		final BeanTester beanTester = new BeanTester();
		beanTester.getFactoryCollection();
		beanTester.testBean(User.class);
	}

}
