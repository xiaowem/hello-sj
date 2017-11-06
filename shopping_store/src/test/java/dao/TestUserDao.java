package dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ml.dao.ProductDao;
import com.ml.dao.UserDao;
import com.ml.entity.Product;
import com.ml.entity.User;
import com.ml.util.IdUtil;

public class TestUserDao {
 @Test
  public void test1() throws SQLException{
	 String[] conf= {"conf/spring-mybatis.xml",
			         "conf/spring-mvc.xml"};
     ApplicationContext  ac =
    		 new ClassPathXmlApplicationContext(conf);
     DataSource dbcp = ac.getBean("dbcp",DataSource.class);
     System.out.println(dbcp.getConnection());
     UserDao dao = ac.getBean("userDao",UserDao.class);
     User user = dao.findByName("xw");
     if(user !=null){
    	 System.out.println("存在此用户");
     }else{
    	 System.out.println("不存在");
     }
 }
 @Test //测试注册
 public void test2() throws SQLException{
	 String[] conf= {"conf/spring-mybatis.xml",
	 				 "conf/spring-mvc.xml"};
		ApplicationContext  ac =
		new ClassPathXmlApplicationContext(conf);
		DataSource dbcp = ac.getBean("dbcp",DataSource.class);
		System.out.println(dbcp.getConnection());
		UserDao dao = ac.getBean("userDao",UserDao.class);
		User user = new User();
		String id = IdUtil.createId();
		user.setShop_user_id(id);
		user.setShop_user_name("xh");
		user.setShop_user_password("123123");
		user.setShop_user_email("15489963.@qq.com");
		dao.save(user);
		System.out.println(user.getShop_user_id());
		System.out.println(user.getShop_user_email());
		System.out.println(user.getShop_user_name());
		System.out.println(user.getShop_user_password());
		System.out.println("插入成功");
		
 }
//  @Test //测试product
//  public void test3() throws SQLException{
//		 String[] conf= {"conf/spring-mybatis.xml",
//		 				 "conf/spring-mvc.xml"};
//			ApplicationContext  ac =
//			new ClassPathXmlApplicationContext(conf);
//			DataSource dbcp = ac.getBean("dbcp",DataSource.class);
//			System.out.println(dbcp.getConnection());
//			ProductDao dao = ac.getBean("productDao",ProductDao.class);
//	        List<Product> product1 = dao.findByList("手机");
//			System.out.println(product1);
//		    for(Product pro:product1){
//		    	System.out.println(pro.getShop_image_address());
//		    	System.out.println(pro.getShop_product_name());
//		    	System.out.println(pro.getShop_product_price());
//		    	System.out.println(pro.getShop_product_count());
//		    	
//		    }
			
			
//  	}
}


