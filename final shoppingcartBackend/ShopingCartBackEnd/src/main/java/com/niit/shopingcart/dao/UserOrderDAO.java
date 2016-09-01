package com.niit.shopingcart.dao;

import com.niit.shopingcart.model.UserDetails;
import com.niit.shopingcart.model.UserOrder;

public interface UserOrderDAO {
	
	public void saveOrUpdate(UserOrder  userOrder);

}
