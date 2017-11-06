package service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ml.dao.CarDao;
import com.ml.dao.UserDao;
import com.ml.entity.Car;
import com.ml.entity.Product;
import com.ml.entity.User;
import com.ml.service.CarService;
import com.ml.service.UserService;
import com.ml.util.Result;

public class TestCarService {
	CarService service;
	CarDao carDao;
	
	@Before
	public void init(){
		String[] conf = {
			"conf/spring-mybatis.xml",
			"conf/spring-mvc.xml"};
		ApplicationContext ac = 
	     	new ClassPathXmlApplicationContext(conf);
	    service = ac.getBean(
			"carService",CarService.class);
	}
	@Test 
	public void test1(){
	Result<Car> result = service.addCar("00000000003", "3816fb25efd4421ca3500a518997133a","");
  	System.out.println(result.getStatus());
  	System.out.println(result.getMsg());
	Car car = new Car();
	System.out.println(car.getShop_order_status());
   }
	//更新状态
	@Test 
	public void test2(){
	Result result = service.UpdateOrder("009b9a5cc866473a9d52ebfc1517e6d5");
  	System.out.println(result.getStatus());
  	System.out.println(result.getMsg());
   }
	//更新状态
		@Test 
		public void test3(){
			Result result = new Result();
		String[] str = {"43","55"};
		for(String st:str){
		 result = service.delProduct(st);
		}
	  	System.out.println(result.getStatus());
	  	System.out.println(result.getMsg());
	   }

}
