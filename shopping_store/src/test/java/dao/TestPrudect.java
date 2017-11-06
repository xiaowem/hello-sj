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

public class TestPrudect {
 

  @Test //测试product
  public void test3() throws SQLException{
		 String[] conf= {"conf/spring-mybatis.xml",
		 				 "conf/spring-mvc.xml"};
			ApplicationContext  ac =
			new ClassPathXmlApplicationContext(conf);
			DataSource dbcp = ac.getBean("dbcp",DataSource.class);
			System.out.println(dbcp.getConnection());
			ProductDao dao = ac.getBean("productDao",ProductDao.class);
//	        Product product1 = dao.seeParticular("电饭煲");
//	        System.out.println(product1.getShop_image_address());
//	        System.out.println(product1.getShop_product_name());
//	        System.out.println(product1.getShop_product_id());
//			System.out.println(product1.getShop_product_name()+"---"+product1.getShop_product_list());
//		    
//			Product pro = dao.findByProductId("45");
//			System.out.println(pro.getShop_product_count());
//			System.out.println(pro.getShop_product_price());
//			System.out.println(pro.getShop_product_name());
			 Product product1 = dao.seeParticular("手机xp");
			System.out.println(product1.getShop_product_name());
			System.out.println(product1.getShop_product_id());
			System.out.println(product1.getShop_product_price());
  	}
  public void test4() throws SQLException{
		 String[] conf= {"conf/spring-mybatis.xml",
		 				 "conf/spring-mvc.xml"};
			ApplicationContext  ac =
			new ClassPathXmlApplicationContext(conf);
			DataSource dbcp = ac.getBean("dbcp",DataSource.class);
			System.out.println(dbcp.getConnection());
			ProductDao dao = ac.getBean("productDao",ProductDao.class);
    
//			Product pro = dao.findByProductId("45");
//			System.out.println(pro.getShop_product_count());
//			System.out.println(pro.getShop_product_price());
//			System.out.println(pro.getShop_product_name());
//			 Product product1 = dao.seeParticular("手机xp");
//			System.out.println(product1.getShop_product_name());
//			System.out.println(product1.getShop_product_id());
//			System.out.println(product1.getShop_product_price());
	}
}


