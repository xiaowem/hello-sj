package com.ml.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ml.dao.CarDao;
import com.ml.entity.Car;
import com.ml.entity.Product;
import com.ml.util.IdUtil;
import com.ml.util.Result;
@Service("carService")
public class CarServiceImpl implements CarService{
 //点击加入购物车
	@Resource
	private CarDao carDao;
	//更新商品状态
	public Result UpdateOrder(String productId) {
		Result result = new Result();
		//构建返回结果
		carDao.updateStatus(productId);
		result.setStatus(0);
		result.setMsg("订单状态更新成功");
		return result;
	}
	
	//删除商品
	public Result delProduct(String productId) {
		Result result = new Result();
		//循环接收productId  遍历删除
		String[] lis = productId.split(",");
		//List list = productId;
        for(String str:lis){
        	carDao.delProduct(str);
        }
		result.setStatus(0);
		result.setMsg("删除成功");
		return result;
	}
	
	public Result<Car> addCar(String productId, String userId,String count) {
		Result<Car> result = new Result<Car>();
		Car car = new Car();
		String carId = IdUtil.createId();
		car.setShop_order_id(carId);
		car.setShop_product_id(productId);
		car.setShop_user_id(userId);
		car.setShop_order_status("1");//状态1未购买   2购买
		car.setShop_order_count(count);
		carDao.insertCar(car);
		//构建返回参数
		result.setStatus(0);
		result.setMsg("加入购物车成功");
		return result;
	}
	//查看购物车
	public Result<List<Product>> seeProductCar(String userId) {
		Result<List<Product>> result = new Result<List<Product>>();
		List<Product> pro = carDao.seeCar(userId);
		//构建返回结果
		result.setStatus(0);
		result.setMsg("查看购物车成功");
		result.setData(pro);
		return result;
	}


}



