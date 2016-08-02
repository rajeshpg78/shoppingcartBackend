package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.User;

public interface UserDAO {
	public List<User> list();

	public User get(String id);

	public void saveOrUpdate(User User);

	public void delete(String id);
	public boolean isValidUser(String id,String name);
}