package com.ml.controller.Admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ml.entity.Admin;
import com.ml.service.AdminService;
import com.ml.util.Result;

@Controller
@RequestMapping("/admin")
public class AdminLogin {
	@Resource
	private AdminService adminService;
	@RequestMapping("/logined")
	@ResponseBody
	public Result<Admin> execute(String name,String password){
		Result<Admin> result = adminService.checkAdmin(name, password);
		System.out.println(result.getData().getShop_admin_password());
		return result;
	}
}
