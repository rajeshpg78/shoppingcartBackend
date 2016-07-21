package com.niit.shoppingcart.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class ProductTest {

	public static void main(String[] args) {
		System.out.println("context object create");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		System.out.println("scan package");
		context.refresh();
		System.out.println("refreshing ....");
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		System.out.println("I am here***");

		Product product = (Product) context.getBean("product");
		System.out.println(product.toString());
		product.setId("hd01");
		product.setName("sony");
		product.setPrice("10000");

		try {
			productDAO.saveOrUpdate(product);
		}

		catch (Exception e) {
			//e.printStackTrace();
			System.out.println("gt exception");
		}
		if (productDAO.get("sdf") == null) {
			System.out.println("product does not exists");
		} else {
			System.out.println("product exists");
		}
	}
}
