package com.ml.controller.Admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ml.service.AdminService;
import com.ml.util.Result;
//删除商品
	@Controller
	@RequestMapping("/admin")
public class AdminDelProduct {
		@Resource
		  private AdminService adminService;
		  @RequestMapping("/del0")
		  @ResponseBody
		  public Result execute(String productId){
			Result result = adminService.delAdminProduct(productId);
			System.out.println(result.getStatus());
			System.out.println(result.getMsg());

			return result;
			  
		  }
	}

