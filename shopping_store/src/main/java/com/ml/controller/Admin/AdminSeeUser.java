package com.ml.controller.Admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ml.dao.AdminDao;
import com.ml.entity.User;
import com.ml.service.AdminService;
import com.ml.util.Result;

@Controller
@RequestMapping("/admin")
public class AdminSeeUser {
	@Resource
	private AdminService adminService;
	
	@RequestMapping("/seeAll")
	@ResponseBody
	public Result<List<User>> execute(){
		Result<List<User>> result = adminService.seeAllUser();
		for(User pro:result.getData()){
			System.out.println(pro.getShop_user_name());
			System.out.println(pro.getShop_user_id());
		}
		return result;
	}
}
