package com.niit.shoppingcart.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		System.out.println("scan package");
		context.refresh();
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		System.out.println("I m here***");

		Category category = (Category) context.getBean("category");
		System.out.println(category.toString());
		category.setId("A3411");
		category.setName("john");
		category.setDescription("hello");

		try {
			categoryDAO.saveOrUpdate(category);
		}

		catch (Exception e) {
			//e.printStackTrace();
			System.out.println("gt exception");
		}
		
		}
	}


