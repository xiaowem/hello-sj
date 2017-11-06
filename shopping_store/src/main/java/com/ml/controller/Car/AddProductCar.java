package com.ml.controller.Car;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ml.service.CarService;
import com.ml.util.Result;
//添加商品
@Controller
@RequestMapping("/car")
public class AddProductCar {
  @Resource
  private CarService carService;
  @RequestMapping("/add")
  @ResponseBody
  public Result execute(String productId,String userId,String count){
	  Result result = carService.addCar(productId, userId,count);
	  System.out.println(result.getMsg());
	  return result;
	  
  }
}




