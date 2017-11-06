package com.ml.dao;

import java.util.List;

import com.ml.entity.Admin;
import com.ml.entity.Product;
import com.ml.entity.User;

public interface AdminDao {
	
	//插入商品
	void insertProduct(Product product);
	
   public Admin findAdminPass(String name);//用户登录
   public List<User> seeAll();//查看所有用户
   public int delUser(String userId);//删除用户
   public void addP(Product pro);//添加商品
   public int upProduct(Product produ);//编辑商品信息
   public int upUser(User user);//编辑用户信息
   public int delPro(String productId);//删除商品
}
