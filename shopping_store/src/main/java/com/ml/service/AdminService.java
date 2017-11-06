package com.ml.service;

import java.util.List;

import com.ml.entity.Admin;
import com.ml.entity.Product;
import com.ml.entity.User;
import com.ml.util.Result;

public interface AdminService {
	//保存商品
	Result saveProduct(String shop_product_name,String shop_product_price,
			String shop_product_count,String shop_product_list,String postfix);
   
	
	public Result<Admin> checkAdmin(String name,String password);//登录
    public Result<List<User>>  seeAllUser();//查看所有用户
    public Result delUserA(String userId);//删除用户
    public Result<Product> addProduct(String productName,String productPrice,
    			 String productCount,String productList,String img);
    public Result<Product> updatePro(String productId,String  productName,
    		     String productPrice,String productCount);//更改商品
    public Result<User> updateUser(String userId,String  userName,
		     String userPass,String userEm);//更改用户信息
    public Result delAdminProduct(String productId);//删除商品
}
