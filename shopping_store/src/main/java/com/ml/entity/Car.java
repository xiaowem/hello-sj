package com.ml.entity;

import java.io.Serializable;

//订单的实体类
public class Car implements Serializable{
	private String  shop_order_id ;  //订单Id    
	private String  shop_user_id;  //外键用户Id     
	private String  shop_product_id ;  //外键商品Id
	private String  shop_order_status;//订单状态
	private String  shop_order_count; //订单商品数量
	
	
	public String getShop_order_count() {
		return shop_order_count;
	}
	public void setShop_order_count(String shop_order_count) {
		this.shop_order_count = shop_order_count;
	}
	public String getShop_order_id() {
		return shop_order_id;
	}
	public void setShop_order_id(String shop_order_id) {
		this.shop_order_id = shop_order_id;
	}
	public String getShop_user_id() {
		return shop_user_id;
	}
	public void setShop_user_id(String shop_user_id) {
		this.shop_user_id = shop_user_id;
	}
	public String getShop_product_id() {
		return shop_product_id;
	}
	public void setShop_product_id(String shop_product_id) {
		this.shop_product_id = shop_product_id;
	}
	public String getShop_order_status() {
		return shop_order_status;
	}
	public void setShop_order_status(String shop_order_status) {
		this.shop_order_status = shop_order_status;
	}
	
	
	
}
