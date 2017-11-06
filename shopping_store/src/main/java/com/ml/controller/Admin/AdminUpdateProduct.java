package com.ml.controller.Admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ml.entity.Product;
import com.ml.service.AdminService;
import com.ml.util.Result;

@Controller
@RequestMapping("/admin")
public class AdminUpdateProduct {
	@Resource
	private AdminService adminService;
	@RequestMapping("/update")
	@ResponseBody
	public Result<Product> execute(String productId,String productName,String productPrice,String productCount){
		Result<Product> result = adminService.updatePro(productId,productName,
				                   productPrice, productCount);
		
		System.out.println(result.getMsg());
		return result;
		
	}
}



