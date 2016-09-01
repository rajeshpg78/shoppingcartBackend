package com.niit.shopingcart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "userorder")
@Component
public class UserOrder {


	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private int UserOrderId;

	    @OneToOne
	    @JoinColumn(name = "ID")
	    private UserDetails userDetails;

	    
	    public UserDetails getUserDetails() {
			return userDetails;
		}

		public void setUserDetails(UserDetails userDetails) {
			this.userDetails = userDetails;
		}

		private String billingAddress;

	    
	    private String shippingAddress;
	    
	    
	    private String pay_type;

		public String getPay_type() {
			return pay_type;
		}

		public void setPay_type(String pay_type) {
			this.pay_type = pay_type;
		}

		public int getUserOrderId() {
			return UserOrderId;
		}

		public void setUserOrderId(int userOrderId) {
			UserOrderId = userOrderId;
		}

	

		public String getBillingAddress() {
			return billingAddress;
		}

		public void setBillingAddress(String billingAddress) {
			this.billingAddress = billingAddress;
		}

		public String getShippingAddress() {
			return shippingAddress;
		}

		public void setShippingAddress(String shippingAddress) {
			this.shippingAddress = shippingAddress;
		}

	   
	
}
