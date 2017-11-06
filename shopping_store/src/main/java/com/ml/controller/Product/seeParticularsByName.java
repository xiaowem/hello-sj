package com.ml.controller.Product;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ml.entity.Product;
import com.ml.service.ProductService;
import com.ml.util.Result;
//查看详情
@Controller
@RequestMapping("/product")
public class seeParticularsByName {
	@Resource
	private ProductService productService;
	@RequestMapping("/seeO")
	@ResponseBody
    public Result<Product> execute(String productName){
    	Result<Product> result =productService.mainProduct(productName);
	 // System.out.println(result.getMsg());
	//	System.out.println(result.getData().getShop_product_name());
		return result;
    	
    }
}
