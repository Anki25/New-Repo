package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Cart")
@Component

public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String cartId;
	@ManyToOne
	@JoinColumn(name="userID", insertable=false ,updatable=false)
	private User user;
	@ManyToOne
	@JoinColumn(name="pro_Id", insertable=false ,updatable=false)
	private Product product;
	private int quantity;
	private float price;
	private String pro_Id;
	private String userID;
	
	
	public String getPro_Id() {
		return pro_Id;
	}
	public void setPro_Id(String pro_Id) {
		this.pro_Id = pro_Id;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	

}
