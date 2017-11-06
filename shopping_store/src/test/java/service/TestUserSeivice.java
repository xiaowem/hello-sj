package service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ml.dao.UserDao;
import com.ml.entity.User;
import com.ml.service.UserService;
import com.ml.util.Result;

public class TestUserSeivice {	
	
	UserService service;
	UserDao userDao;
	
	@Before
	public void init(){
		String[] conf = {
			"conf/spring-mybatis.xml",
			"conf/spring-mvc.xml"};
		ApplicationContext ac = 
	     	new ClassPathXmlApplicationContext(conf);
	    service = ac.getBean(
			"userService",UserService.class);
	}
	@Test  //登录成功
	public void test1(){
	Result<User> result = service.checkLogin("xw","123123");
  	System.out.println(result.getMsg());
  	System.out.println(result.getStatus());
  	System.out.println(result.getData());
  	System.out.println(result);
   }
	@Test
	public void test2(){
		Result<User> result = service.checkLogin("lml","123123");
	  	System.out.println(result.getMsg());
	  	System.out.println(result.getStatus());
	  	System.out.println(result.getData());
	  	System.out.println(result);
	   }
	@Test
	public void test3(){
		Result<User> result = 
				service.addUser("lml", "123123", "1419325945@qq.com");
		//执行用户名检测
		
//		User hasUser = userDao.findByName("lml");
//		if(hasUser !=null){//用户名存在
//			System.out.println("用户被占用");
//			
//		}
//		//执行用户添加
//		User user = new User();
//		user.setShop_user_name("1ml");
//		user.setShop_user_password("123123");
//		user.setShop_user_email("1419325945@qq.com");
//		
//		userDao.save(user);//保存user
		System.out.println(result.getMsg());
		System.out.println(result.getStatus());
	
	}
	
	
}




