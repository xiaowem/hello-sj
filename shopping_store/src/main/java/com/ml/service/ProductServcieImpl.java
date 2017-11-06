package com.ml.service;


import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.ml.dao.ProductDao;
import com.ml.entity.Product;
import com.ml.util.Result;
@Service("productService")
public class ProductServcieImpl implements ProductService{
	@Resource//注入Dao
	private ProductDao productDao;
	
	

	
	
	//查看商品详情
	public Result<Product> mainProduct(String productName) {
		Result<Product> result = new Result<Product>();
		Product product =productDao.seeParticular(productName);
		//构建返回结果
		if(product==null){
			result.setStatus(1);
			result.setMsg("没查到");
		    return result;
		}
		result.setStatus(0);
		result.setMsg("查到了！");
		result.setData(product);
		return result;
	}
	
	/*
	 * 模糊查询商品
	 */
//	public Result<List<Product>> findProduct(String productList) {
//		Result<List<Product>> result = new Result<List<Product>>();
//		if(productList == "" || productList == " " || productList == null) {
//			result.setStatus(1);
//			result.setMsg("参数不能为空!");
//			return result;
//		}
//		List<Product> list = productDao.findByProductList(productList);
//		result.setStatus(0);
//		result.setMsg("查到了！");
//		result.setData(list);
//		
//		return result;
//	}
	public Result<List<Product>> findProduct(String productName) {
		Result<List<Product>> result = new Result<List<Product>>();
		if(productName == "" || productName == " " || productName == null) {
			result.setStatus(1);
			result.setMsg("参数不能为空!");
			return result;
		}
		List<Product> list = productDao.findByProductName(productName);
		if(null==list || list.size()==0) {
			result.setStatus(2);
			result.setMsg("没有这个关键词的商品!");
			return result;
		}else{
			result.setStatus(0);
			result.setMsg("查到了！");
			result.setData(list);
			return result;
		}
	}
	
	//根据商品类别查询
	public Result<List<Product>> SearchList(String productList) {
		List<Product> allList = productDao.findByList(productList);

      //构建返回对象
	Result<List<Product>> result = new Result<List<Product>>();
//      if(allList == null) {
//    	  result.setStatus(1);
//    	  result.setMsg("没查到！");
//    	  return result;
//      }
      result.setStatus(0);
      result.setMsg("加载商品信息完成");
      result.setData(allList);
	  return result;     		
	}



	
}
