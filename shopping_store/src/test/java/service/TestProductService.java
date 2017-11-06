package service;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ml.dao.ProductDao;
import com.ml.entity.Product;
import com.ml.service.ProductService;
import com.ml.util.Result;

public class TestProductService {
	
	ProductDao productDao;
	ProductService	service ;
	@Test
	public void test1(){
		    String[] conf = {
				"conf/spring-mybatis.xml",
				"conf/spring-mvc.xml"};
			ApplicationContext ac = 
		     	new ClassPathXmlApplicationContext(conf);
			//System.out.println(ac);
			service = ac.getBean("productService",ProductService.class );

//		List<Product> allList = 
//		          productDao.findByList("手机");
//		for(Product pro:allList){
//			System.out.println(pro.getShop_product_name());		
//			System.out.println(pro.getShop_product_price());		
//			System.out.println(pro.getShop_product_count());
//			System.out.println(pro.getShop_image_address());
//			System.out.println(	pro.getShop_product_id());				
//		}
//			Result<List<Product>> result= service.SearchList("手机");
//			System.out.println(result.getData()+"--"+result.getMsg());
			
//			System.out.println(result.getData().getShop_product_price());
//	        Result<Product> product = service.mainProduct("电饭");
//	       System.out.println(product.getMsg());
//	       System.out.println(product.getStatus());
			
	}
}



