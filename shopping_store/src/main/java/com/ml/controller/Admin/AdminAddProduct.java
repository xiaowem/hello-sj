package com.ml.controller.Admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ml.service.AdminService;
import com.ml.util.Result;
import com.ml.util.UploadUtils;

@Controller
@RequestMapping("/admin")
public class AdminAddProduct {
	@Resource
	private AdminService adminService;
	@RequestMapping("/insert")
	@ResponseBody
	public Result exe(String shop_product_name,String shop_product_price,
			String shop_product_count,String shop_product_list,String postfix) {
		Result result = adminService.saveProduct(shop_product_name, shop_product_price, 
				shop_product_count, shop_product_list, postfix);
//	public Result execute(String productName,String productPrice,
//			String productCount,String productList,String img){
//		Result result = adminService.addProduct(productName, productPrice, productCount, productList, img);
//		System.out.println(result.getMsg());
//		
////		UploadUtils up=new UploadUtils();
////		up.setBasePath("F:/");
////		up.uploadFile(request);
		//System.out.println(shop_product_list);
		/*System.out.println(postfix);*/
		return result;
		
	}
	
}
