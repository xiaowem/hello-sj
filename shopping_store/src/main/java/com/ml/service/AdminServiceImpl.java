package com.ml.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ml.dao.AdminDao;
//后台管理员登录
import com.ml.entity.Admin;
import com.ml.entity.Product;
import com.ml.entity.User;
import com.ml.util.IdUtil;
import com.ml.util.Result;
@Service("adminService")
public class AdminServiceImpl implements AdminService{
	@Resource
	private AdminDao adminDao;
	
	/*
	 * 
	 * 保存商品
	 */
	public Result saveProduct(String shop_product_name,String shop_product_price,
			String shop_product_count,String shop_product_list,String postfix) {
		
		Result result = new Result();
		Product p = new Product();
		String shop_product_id = IdUtil.createId();
		p.setShop_product_id(shop_product_id);
        //判断 
		if(shop_product_list.equals("手机")){
			p.setShop_product_list(shop_product_list);
			String shop_product_list1="mobilephone";
			String shop_image_address = "products/1/"+shop_product_list1+"/"+shop_product_name+"."+postfix;
			p.setShop_image_address(shop_image_address);
			p.setShop_product_count(shop_product_count);
			p.setShop_product_name(shop_product_name);
			p.setShop_product_price(shop_product_price);
			adminDao.insertProduct(p);
		}else if(shop_product_list.equals("热水器")){
			p.setShop_product_list(shop_product_list);
			String shop_product_list1="calorifier";
			String shop_image_address = "products/1/"+shop_product_list1+"/"+shop_product_name+"."+postfix;
			p.setShop_image_address(shop_image_address);
			p.setShop_product_count(shop_product_count);
			p.setShop_product_name(shop_product_name);
			p.setShop_product_price(shop_product_price);
			adminDao.insertProduct(p);
		}else if(shop_product_list.equals("洗衣机")){
			p.setShop_product_list(shop_product_list);
			String shop_product_list1="washer";
			String shop_image_address = "products/1/"+shop_product_list1+"/"+shop_product_name+"."+postfix;
			p.setShop_image_address(shop_image_address);
			p.setShop_product_count(shop_product_count);
			p.setShop_product_name(shop_product_name);
			p.setShop_product_price(shop_product_price);
			adminDao.insertProduct(p);
		}else if(shop_product_list.equals("电视机")){
			p.setShop_product_list(shop_product_list);
			String shop_product_list1="television";
			String shop_image_address = "products/1/"+shop_product_list1+"/"+shop_product_name+"."+postfix;
			p.setShop_image_address(shop_image_address);
			p.setShop_product_count(shop_product_count);
			p.setShop_product_name(shop_product_name);
			p.setShop_product_price(shop_product_price);
			adminDao.insertProduct(p);
		}else if(shop_product_list.equals("电脑")){
			p.setShop_product_list(shop_product_list);
			String shop_product_list1="computer";
			String shop_image_address = "products/1/"+shop_product_list1+"/"+shop_product_name+"."+postfix;
			p.setShop_image_address(shop_image_address);
			p.setShop_product_count(shop_product_count);
			p.setShop_product_name(shop_product_name);
			p.setShop_product_price(shop_product_price);
			adminDao.insertProduct(p);
		}else if(shop_product_list.equals("夹克")){
			p.setShop_product_list(shop_product_list);
			String shop_product_list1="jacket";
			String shop_image_address = "products/1/"+shop_product_list1+"/"+shop_product_name+"."+postfix;
			p.setShop_image_address(shop_image_address);
			p.setShop_product_count(shop_product_count);
			p.setShop_product_name(shop_product_name);
			p.setShop_product_price(shop_product_price);
			adminDao.insertProduct(p);
		}else if(shop_product_list.equals("裤子")){
			p.setShop_product_list(shop_product_list);
			String shop_product_list1="kz";
			String shop_image_address = "products/1/"+shop_product_list1+"/"+shop_product_name+"."+postfix;
			p.setShop_image_address(shop_image_address);
			p.setShop_product_count(shop_product_count);
			p.setShop_product_name(shop_product_name);
			p.setShop_product_price(shop_product_price);
			adminDao.insertProduct(p);
		}else if(shop_product_list.equals("鞋")){
			p.setShop_product_list(shop_product_list);
			String shop_product_list1="shoes";
			String shop_image_address = "products/1/"+shop_product_list1+"/"+shop_product_name+"."+postfix;
			p.setShop_image_address(shop_image_address);
			p.setShop_product_count(shop_product_count);
			p.setShop_product_name(shop_product_name);
			p.setShop_product_price(shop_product_price);
			adminDao.insertProduct(p);
		}else if(shop_product_list.equals("水杯")){
			p.setShop_product_list(shop_product_list);
			String shop_product_list1="cup";
			String shop_image_address = "products/1/"+shop_product_list1+"/"+shop_product_name+"."+postfix;
			p.setShop_image_address(shop_image_address);
			p.setShop_product_count(shop_product_count);
			p.setShop_product_name(shop_product_name);
			p.setShop_product_price(shop_product_price);
			adminDao.insertProduct(p);
		}
			//这种设置合理吗？有没有简单的方法  路劲由类别+商品名称组成
		
		
		System.out.println(p.getShop_product_name());
		System.out.println(p.getShop_product_price());
		System.out.println(p.getShop_image_address());
		result.setMsg("插入成功");
		result.setStatus(0);
		return result;
	}

	
	
	//添加商品
	public Result<Product> addProduct(String productName,String productPrice,
			String productCount,String productList,String img) {
		Result<Product> result =
				new Result<Product>();
//		String[] lis = product.split(",");
//		for(String p:lis){
//			Product pro = new Product();
//			String id = IdUtil.createId();
//			pro.setShop_product_id(id);
//			pro.setShop_image_address(p.);
//		}
		Product pro = new Product();
		pro.setShop_image_address(img);
		pro.setShop_product_count(productCount);
		String id = IdUtil.createId();
		pro.setShop_product_id(id);
		pro.setShop_product_list(productList);
		pro.setShop_product_name(productName);
		pro.setShop_product_price(productPrice);
		adminDao.addP(pro);
		
		result.setStatus(0);
		result.setMsg("添加成功");
		result.setData(pro);
		return result;
	}
	
	
	
	//删除用户
	public Result delUserA(String userId) {
		Result result = new Result();
		adminDao.delUser(userId);
		result.setStatus(0);
		result.setMsg("删除成功");
		return result;
	}
	
	public Result<List<User>> seeAllUser() {//查看所有用户
		Result<List<User>> result = new Result<List<User>>();
		List<User> list = adminDao.seeAll();
		//构建返回参数
		result.setStatus(0);
		result.setMsg("已返回所有用户");
		result.setData(list);
		return result;
	}
	
	
	public Result<Admin> checkAdmin(String name, String password) {
		Result<Admin> result = new Result<Admin>();
		//检查用户名
		Admin admin = adminDao.findAdminPass(name);
		if(admin==null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		//检查密码
	   String password1 = admin.getShop_admin_password();
	   if(!password1.equals(password)){
		   result.setStatus(2);
		   result.setMsg("密码错误");
		   return result;
	   }
	   //用户名和密码正确
	        result.setStatus(0);
	        result.setMsg("登录成功");
	        result.setData(admin);
	        return result;
	}

	//编辑商品


	public Result<Product> updatePro(String productId,String productName, String productPrice, String productCount) {
		Product product = new Product();
		product.setShop_product_id(productId);
		product.setShop_product_name(productName);
		product.setShop_product_price(productPrice);
		product.setShop_product_count(productCount);
		
		int prod= adminDao.upProduct(product);
		Result<Product> result =
				new Result<Product>();
		//构建返回参数
				result.setStatus(0);
				result.setMsg("商品信息编辑成功");
				/*result.setData(list);*/
				return result;
	}


//编辑用户
	public Result<User> updateUser(String userId, String userName, String userPass, String userEm) {
		
		  User user = new User();
		  user.setShop_user_id(userId);
		  user.setShop_user_name(userName);
		  user.setShop_user_password(userPass);
		  user.setShop_user_email(userEm);
	      int row = adminDao.upUser(user);
	     Result<User> result = new Result<User>();
		//构建返回参数
		  result.setStatus(0);
		  result.setMsg("用户信息编辑成功");
		 return result;
	}
//删除商品
	public Result delAdminProduct(String productId) {
		Result result = new Result();
		adminDao.delPro(productId);
		result.setStatus(0);
		result.setMsg("删除成功");
		return result;
	}




}
