package com.niit.shoppingcart.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		System.out.println("context object create");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		System.out.println("scan package");
		context.refresh();
		System.out.println("refreshing ....");
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		System.out.println("I am here***");

		Supplier supplier = (Supplier) context.getBean("supplier");
		System.out.println(supplier.toString());
		supplier.setId("A343443411");
		supplier.setName("john");
		supplier.setAddress("krishnanpalya bangalore");

		try {
			supplierDAO.saveOrUpdate(supplier);
		}

		catch (Exception e) {
			//e.printStackTrace();
			System.out.println("gt exception");
		}
		if (supplierDAO.get("sdf") == null) {
			System.out.println("supplier does not exists");
		} else {
			System.out.println("supplier exists");
		}
	}
}
