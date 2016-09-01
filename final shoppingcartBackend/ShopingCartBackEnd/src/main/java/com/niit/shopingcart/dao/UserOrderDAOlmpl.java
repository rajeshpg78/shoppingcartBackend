package com.niit.shopingcart.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopingcart.model.UserOrder;

@Repository("userOrderDAO")
public class UserOrderDAOlmpl implements UserOrderDAO{
	
	
	@Autowired
		private SessionFactory session; 
	@Transactional
	public void saveOrUpdate(UserOrder userOrder) {
	
		session.getCurrentSession().saveOrUpdate(userOrder);
		
	}
	

}
