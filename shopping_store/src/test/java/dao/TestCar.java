package dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ml.dao.CarDao;
import com.ml.entity.Car;
import com.ml.entity.Product;

public class TestCar {
 
	@Test
public void test1() throws SQLException{
		String[] conf= {"conf/spring-mybatis.xml",
			 "conf/spring-mvc.xml"};
		ApplicationContext  ac =
				new ClassPathXmlApplicationContext(conf);
				DataSource dbcp = ac.getBean("dbcp",DataSource.class);
				System.out.println(dbcp.getConnection());
				CarDao dao = ac.getBean("carDao",CarDao.class);
				Car car = new Car();
				car.setShop_order_id("0025");
				car.setShop_product_id("00000000001");
				car.setShop_user_id("1234568");
				car.setShop_order_status("0");
				car.setShop_order_count("10");
			    dao.insertCar(car);
			    System.out.println("插入成功");
			    System.out.println(car.getShop_order_id());
			    System.out.println(car.getShop_order_status());
	}
@Test
public void test2() throws SQLException{
	String[] conf= {"conf/spring-mybatis.xml",
	 "conf/spring-mvc.xml"};
  ApplicationContext  ac =
		new ClassPathXmlApplicationContext(conf);
		DataSource dbcp = ac.getBean("dbcp",DataSource.class);
		System.out.println(dbcp.getConnection());
		CarDao dao = ac.getBean("carDao",CarDao.class);
		List<Product> car = dao.seeCar("1234568");
		for(Product pro:car){
			System.out.println(pro.getShop_product_name());
			System.out.println(pro.getShop_product_price());
		}
  }
@Test
public void test3() throws SQLException{
	String[] conf= {"conf/spring-mybatis.xml",
	 "conf/spring-mvc.xml"};
  ApplicationContext  ac =
		new ClassPathXmlApplicationContext(conf);
		DataSource dbcp = ac.getBean("dbcp",DataSource.class);
		System.out.println(dbcp.getConnection());
		CarDao dao = ac.getBean("carDao",CarDao.class);
	    int car = dao.delProduct("47");
		System.out.println("删除成功");
		}
 
//更新状态
@Test
public void test4() throws SQLException{
	String[] conf= {"conf/spring-mybatis.xml",
	 "conf/spring-mvc.xml"};
  ApplicationContext  ac =
		new ClassPathXmlApplicationContext(conf);
		DataSource dbcp = ac.getBean("dbcp",DataSource.class);
		System.out.println(dbcp.getConnection());
		CarDao dao = ac.getBean("carDao",CarDao.class);
	    dao.updateStatus("5a825455a0ac4385ae0822eef6c81542");
	    System.out.println("更新成功！");
	    
	    //System.out.println();
		
		}
  }




