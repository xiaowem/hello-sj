package service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ml.dao.AdminDao;
import com.ml.dao.UserDao;
import com.ml.entity.Admin;
import com.ml.entity.User;
import com.ml.service.AdminService;
import com.ml.service.UserService;
import com.ml.util.Result;

public class TestAdminService {	
	
	AdminService service;
	AdminDao adminDao;
	
	@Before
	public void init(){
		String[] conf = {
			"conf/spring-mybatis.xml",
			"conf/spring-mvc.xml"};
		ApplicationContext ac = 
	     	new ClassPathXmlApplicationContext(conf);
	    service = ac.getBean(
			"adminService",AdminService.class);
	}
	@Test  //登录成功
	public void test1(){
	Result<Admin> result = service.checkAdmin("xw", "123456");
  	System.out.println(result.getMsg());
  	System.out.println(result.getStatus());
  	System.out.println(result.getData());
  	System.out.println(result);
  
	}
	@Test  //登录成功
	public void test2(){
      Result<List<User>> result = service.seeAllUser();
//      for(User pro:list){
//    	  System.out.println(pro.getShop_user_id());
//    	  System.out.println(pro.getShop_user_name());
//    	  System.out.println(pro.getShop_user_email());
//      }
      System.out.println(result.getStatus());
      for(User pro:result.getData()){
    	  System.out.println(pro.getShop_user_id()+"\t");
    	  System.out.println(pro.getShop_user_name()+"\t");
    	  System.out.println(pro.getShop_user_password()+"\t");
      }
    
	}
	@Test  
	public void test3(){
	Result result =service.delUserA("28940a8568194e8588df12c29094c996");
	//adminDao.delUser("28940a8568194e8588df12c29094c996");
  	System.out.println(result.getMsg());
  	System.out.println(result.getStatus());
  
	}
	@Test  
	public void test4(){
	Result result =service.addProduct("211", "66", "5656","华为", "c:///");
  	System.out.println(result.getMsg());
  	System.out.println(result.getStatus());
  
	}
	@Test  
	public void test5(){
	Result result = service.updateUser("6942f1898252427f9ca0fcf66348db8a", "haha", "12456","456@qq.com");	
  	System.out.println(result.getMsg());
  	System.out.println(result.getStatus());
  
	}
}



  
