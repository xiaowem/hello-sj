package com.ml.controller.Car;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ml.entity.Product;
import com.ml.service.CarService;
import com.ml.util.Result;

@Controller
@RequestMapping("/car")
public class SeeProductCar {
	@Resource
	  private CarService carService;
	  @RequestMapping("/see")
	  @ResponseBody
	public Result<List<Product>> execute(String userId){
	    Result<List<Product>> result =carService.seeProductCar(userId);
		List<Product> pro =result.getData();
		for(Product li:pro){
			System.out.println(li.getShop_product_name());
			System.out.println(li.getShop_product_price());
			System.out.println(li.getShop_product_id());
		}
	    
	    return result;
	}
}
