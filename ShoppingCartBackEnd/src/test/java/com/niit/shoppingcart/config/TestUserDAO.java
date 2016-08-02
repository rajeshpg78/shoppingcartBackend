package com.niit.shoppingcart.config;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;
import com.niit.shoppingcart.model.UserDetails;

public class TestUserDAO {
	@Autowired
	static UserDAO userDAO;
	static AnnotationConfigApplicationContext context;
	
	
	
	static UserDetails userDetails;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
		userDetails = (UserDetails) context.getBean("userDetails");

	}

	@AfterClass
	public static void close() {
		context.close();
		userDAO = null;
		userDetails = null;
	}

	@Test
	public void UsersTestCase() {
		int size = userDAO.list().size();

		assertEquals("User LIST Test Case1", 1, size);
	}

	@Test
	public void UsersNameTestCase() {
		User user = userDAO.get("111");
		String name = user.getName();
		assertEquals("User Name Test Case2", 4, name.length());
	}
}
