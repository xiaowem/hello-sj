package dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ml.dao.AdminDao;
import com.ml.dao.CarDao;
import com.ml.entity.Admin;
import com.ml.entity.Car;
import com.ml.entity.Product;
import com.ml.entity.User;
import com.ml.util.IdUtil;

public class TestAdmin {
 
@Test
public void test1() throws SQLException{
		String[] conf= {"conf/spring-mybatis.xml",
			 "conf/spring-mvc.xml"};
		ApplicationContext  ac =
				new ClassPathXmlApplicationContext(conf);
				DataSource dbcp = ac.getBean("dbcp",DataSource.class);
				System.out.println(dbcp.getConnection());
				AdminDao dao = ac.getBean("adminDao",AdminDao.class);
				Admin admin =dao.findAdminPass("lml");
				System.out.println(admin.getShop_admin_password());
	}


@Test
public void test2() throws SQLException{
		String[] conf= {"conf/spring-mybatis.xml",
			 "conf/spring-mvc.xml"};
		ApplicationContext  ac =
				new ClassPathXmlApplicationContext(conf);
				DataSource dbcp = ac.getBean("dbcp",DataSource.class);
				System.out.println(dbcp.getConnection());
				AdminDao dao = ac.getBean("adminDao",AdminDao.class);
			     dao.delUser("28940a8568194e8588df12c29094c996");
			     System.out.println("删除成功");
	}

@Test
public void test3() throws SQLException{
		String[] conf= {"conf/spring-mybatis.xml",
			 "conf/spring-mvc.xml"};
		ApplicationContext  ac =
				new ClassPathXmlApplicationContext(conf);
				DataSource dbcp = ac.getBean("dbcp",DataSource.class);
				System.out.println(dbcp.getConnection());
				AdminDao dao = ac.getBean("adminDao",AdminDao.class);
				Product pro = new Product();
				String id = IdUtil.createId();
				pro.setShop_product_id(id);
				pro.setShop_image_address("c://ss");
				pro.setShop_product_count("20");
				pro.setShop_product_list("手机");
				pro.setShop_product_name("54545");
				pro.setShop_product_price("121");
				dao.addP(pro);
				System.out.println(pro.getShop_product_count());
	}

@Test
public void test4() throws SQLException{
		String[] conf= {"conf/spring-mybatis.xml",
			 "conf/spring-mvc.xml"};
		ApplicationContext  ac =
				new ClassPathXmlApplicationContext(conf);
				DataSource dbcp = ac.getBean("dbcp",DataSource.class);
				System.out.println(dbcp.getConnection());
				AdminDao dao = ac.getBean("adminDao",AdminDao.class);
				User pro = new User();
				pro.setShop_user_id("6942f1898252427f9ca0fcf66348db8a");
				pro.setShop_user_name("傻洁");
				pro.setShop_user_password("789456");
				pro.setShop_user_email("453@qq.com");
				dao.upUser(pro);
				System.out.println(pro.getShop_user_name());
	}

}




