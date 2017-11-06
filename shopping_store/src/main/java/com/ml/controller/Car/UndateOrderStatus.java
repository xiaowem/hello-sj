package com.ml.controller.Car;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ml.service.CarService;
import com.ml.util.Result;

@Controller
@RequestMapping("/car")
public class UndateOrderStatus {
	@Resource
	  private CarService carService;
	  @RequestMapping("/update")
	  @ResponseBody
	  public Result excute(String productId){
		  Result result = carService.UpdateOrder(productId);
		  System.out.println(result.getMsg());
		  System.out.println(result.getStatus());
		return result;
	  }
}
