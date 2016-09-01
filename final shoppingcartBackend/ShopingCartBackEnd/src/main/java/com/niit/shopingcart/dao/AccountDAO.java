package com.niit.shopingcart.dao;

import com.niit.shopingcart.model.Account;

public interface AccountDAO {
	public Account get(String id);
	public boolean trasfer(String id, int amount);


}
