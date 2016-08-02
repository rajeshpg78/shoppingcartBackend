package com.niit.shoppingcart.config;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class TestCaseCategory {

	static Category category;

	static CategoryDAO categoryDAO;

	static AnnotationConfigApplicationContext context;

	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		category = (Category) context.getBean("category");
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	}
	public static void categoryNameTest() {
		category=(Category) context.getBean("category");
		System.out.println(category.getId() +"\t"+category.getName()+"\t"+category.getDescription());
		
	}

}
