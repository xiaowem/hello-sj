package com.ml.controller.Car;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ml.dao.CarDao;
import com.ml.service.CarService;
import com.ml.util.Result;
//删除商品
@Controller
@RequestMapping("/car")
public class DelCarProduct {
	@Resource
	  private CarService carService;
	  @RequestMapping("/del")
	  @ResponseBody
	  public Result execute(String productId){
		Result result = carService.delProduct(productId);
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());

		return result;
		  
	  }
}


