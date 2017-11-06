package com.ml.entity;

import java.io.Serializable;

public class Admin implements Serializable{
     private String shop_admin_id;
     private String shop_admin_name;
     private String shop_admin_password;
     
	public String getShop_admin_id() {
		return shop_admin_id;
	}
	public void setShop_admin_id(String shop_admin_id) {
		this.shop_admin_id = shop_admin_id;
	}
	public String getShop_admin_name() {
		return shop_admin_name;
	}
	public void setShop_admin_name(String shop_admin_name) {
		this.shop_admin_name = shop_admin_name;
	}
	public String getShop_admin_password() {
		return shop_admin_password;
	}
	public void setShop_admin_password(String shop_admin_password) {
		this.shop_admin_password = shop_admin_password;
	}
     
     
}
