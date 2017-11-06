package com.ml.controller.Admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ml.service.AdminService;
import com.ml.util.Result;

@Controller
@RequestMapping("/admin")
public class AdminDelUser {
	@Resource
	private AdminService adminService;
	@RequestMapping("/del")
	@ResponseBody
	public Result execute(String userId){
		Result result = adminService.delUserA(userId);
		System.out.println(result.getMsg());
		return result;
		
	}
}
