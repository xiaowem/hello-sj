//获取5个参数
		$(function() {
			//1 点击text框去掉span的提示信息
			$("#name").focus(function(){
					//alert("++++==");
					$("#1_msg").html("");
				});
			$("#price").focus(function(){
					//alert("++++==");
					$("#2_msg").html("");
				});
			$("#count").focus(function(){
					//alert("++++==");
					$("#3_msg").html("");
				});
			$("#submit").click(function(){
				var shop_product_name = $("#name").val().trim();
				var shop_product_price=$("#price").val().trim();
				var shop_product_count=$("#count").val().trim();
				var shop_product_list=$("#list").find("option:selected").text().trim();
				var postfix=$("#postfix").find("option:selected").text().trim();
				//alert(shop_product_name);
				//alert(shop_product_price);
			/*	//alert(shop_product_count);
				if($("#list").find("option:selected").text().trim()=="手机"){
					shop_product_list="mobilephne"
				}*/
				alert(shop_product_list);
		     	alert(postfix);
				
				//2 判断是否为空
				var flag = true;
				if(shop_product_name == "") {
					$("#1_msg").html("名字不能为空");
					flag = false;
				}
				if(shop_product_price == "") {
					$("#2_msg").html("名字不能为空");
					flag = false;
				}
				if(shop_product_count == "") {
					$("#3_msg").html("名字不能为空");
					flag = false;
				}

					//3 发送ajax请求
					if(flag) {
						$.ajax({
							url:"http://localhost:8083/shopping_store/admin/insert.do",
							type:"post",
							data:{"shop_product_name":shop_product_name,
								"shop_product_price":shop_product_price,
								"shop_product_count":shop_product_count,
								"shop_product_list":shop_product_list,
								"postfix":postfix},
							success:function(result){
								if(result.status == 0) {//正确
									alert(result.msg);
								}
							},
							error:function() {
								alert("注册异常！");
							}
							
						});
					}
				
			})

		})