package com.ml.controller.Admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ml.entity.User;
import com.ml.service.AdminService;
import com.ml.util.Result;

@Controller
@RequestMapping("/admin")
public class AdminUpdateUser {
	@Resource
	private AdminService adminService;
	@RequestMapping("/updateUser")
	@ResponseBody
	public Result<User> execute(String userId, String userName, String userPass, String userEm){
		Result<User> result = adminService.updateUser(userId, userName, userPass, userEm);
        System.out.println(result.getMsg());
        System.out.println(result.getStatus());
      
        System.out.println(userId);
       
		return result;
		
	}
}
