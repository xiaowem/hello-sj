package com.ml.service;

import java.util.List;

import com.ml.entity.Product;
import com.ml.util.Result;

public interface ProductService {
	public Result<Product> mainProduct(String productName);//根据商品名查看主页商品
	//public Result<List<Product>> findProduct(String productList);//根据list模糊查询products
    public Result<List<Product>> SearchList(String productList);//根据类别搜索商品
    //根据name模糊查询products
  	Result<List<Product>> findProduct(String productName);
  	
}
