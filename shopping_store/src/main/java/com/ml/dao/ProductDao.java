package com.ml.dao;

import java.util.List;

import com.ml.entity.Product;

public interface ProductDao {
	public Product seeParticular(String productName);//查询主页商品详情
	public List<Product> findByProductList(String productList);//根据类别搜索商品
    public List<Product> findByList(String productList);//根据类别查询商品
  	//根据name模糊查询商品
  	public List<Product> findByProductName(String productName);
  	
}
