package com.niit.shoppingcart.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

public class UserTest {

	public static void main(String[] args) {
		System.out.println("context object create");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		System.out.println("scan package");
		context.refresh();
		System.out.println("refreshing ....");
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		System.out.println("I am here***");

		User user = (User) context.getBean("user");
		System.out.println(user.toString());
		user.setId("A343443411");
		user.setName("john");
		user.setAddress("krishnanpalya bangalore");

		try {
			userDAO.saveOrUpdate(user);
		}

		catch (Exception e) {
			//e.printStackTrace();
			System.out.println("gt exception");
		}
		if (userDAO.get("sdf") == null) {
			System.out.println("user does not exists");
		} else {
			System.out.println("user exists");
		}
	}

	}


