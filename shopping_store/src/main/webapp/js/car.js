//提交订单后自动删除已购买的商品
function sendOrder(){
			//获取选中复选框的tr标签
				  var sum = $("input[id=cr]:checked").length; 
				  var $trs =$("input[id=cr]:checked").parent().parent().parent();  
				  //var productId = $trs.data("productId");
			    	//遍历这些行
		    		var boxIds="";
		    		for(var i=0;i<sum;i++) {
			    		var productId = $trs.eq(i).data("productId");
			    		if(i==0){
			    			boxIds += (productId);
			    		}else{
			    			boxIds += (","+productId);
			    		}
		    		}
		    			
				    //发送ajax请求   可进行批量删除
					$.ajax({
			    		url:path+"/car/del.do?productId="+boxIds,
			    		success:function(result){
			    			if(result.status==0){
			    			alert("订单提交成功！");
			 			 window.location.href="logined.html";
			    			}
			    		},
			    		error:function(){
			    			alert("删除失败");
			    		}
			    	});
			   }


//计算总价
function total(){
			       	 //求和
			       	     $("#tot").html("");
					    //获取tbody下所有选中的行数
			             var sum = $("input[id=cr]:checked").length; 
					     //获取选中的行
					  	 var $trs =$("input[id=cr]:checked").parent().parent().parent();  
					     //var $tr = $(this).parent().parent().parent();
					  	 //alert($trs.eq(0).children().eq(4).text());
					    		//遍历这些行
					    		var s = 0;
					    		var boxIds = new Array();
					    		for(var i=0;i<sum;i++) {
					    			//获取本行内第4个td的内容
					    			var mny = 
					    				$trs.eq(i).children().eq(4).text();
					    			s += parseFloat(mny);
						    		var productId = $trs.eq(i).data("productId");
						    		boxIds.push(productId);
						    		//alert(productId);
					    		}
					    		//将结果写入合计列
					    		$("#tot").text(s);	 
//					    		alert(boxIds);
			    		     //发送ajax请求   更新选中订单的状态为2
					    		var productId = $(this).parent().parent().parent().data("productId");    
					    		$.ajax({
									url:path+"/car/update.do",
									type:"post",
									data:{"productId":productId},
									dataType:"json",
									success:function(result){
										if(result.status==0){
											    alert("订单状态更新成功！");
											}		
									},
									error:function(){
										alert("订单信息更新失败！");
									}
								});	
			    		     
			        
			    }

//商品购买订单提交
function buyCarProduct(){
	//将复选框没选中的隐藏
	$("#carShow tr").hide();
	$("input[id=cr]:checked").parent().parent().parent().show();
				    $(".all").hide();
					$(".all2").hide();
					$(".all3").hide();
					$(".all4").show();
					$(".all5").show();
					//发送ajax请求
//					$.ajax({
//						url:path+"/car/see.do",
//						type:"post",
//						data:{"userId":userId},
//						dataType:"json",
//						success:function(result){
//							if(result.status==0){
//								//获取返回值
//								 var products = result.data;
//								for(var i=0;i<products.length;i++){
//									var productId    = products[i].shop_product_id;
//									//获取商品名称
//									var productName  = products[i].shop_product_name;
//									//获取商品价格
//									var productPrice = products[i].shop_product_price;
//							     
//									//拼接
//									    var sli="";
//										sli+='<tr>';	
//										sli+='<th>';
//										sli+= productName;
//										sli+='</th>';
//									    sli+='<th>';
//									    sli+= productPrice;
//									    sli+='</th>';
//										sli+='<th>';
//										sli+='1</th>';
//										sli+='<th>';
//										sli+= productPrice;
//										sli+='</th>';
//									    sli+='</tr>';
//								        var $tr = $(sli);//将sli字符串转成jQuery对象td元素
//								        $tr.data("productId",productId);//将值与jQuery对象元素绑定
//								    	$("#carShow1").append($tr);
//									       
//								}
//							 	
//							
//								
//							}
//						},
//						error:function(){
//							alert("购物车加载失败！");
//						}
//					});
	}		

//删除商品
function delCarProduct(){
				    $(".all").hide();
					$(".all2").hide();
					$(".all3").hide();
					$(".all4").show();
					$(".all5").hide();
					//获取tr标签
					var $tr = $(this).parent().parent();
					var productId = $tr.data("productId");
				    //发送ajax请求
					$.ajax({
			    		url:path+"/car/del.do",
			    		type:"post",
			    		data:{"productId":productId},
			    		dataType:"json",
			    		
			    		success:function(result){
			    			if(result.status==0){
			    				$tr.remove();
			    				alert(result.msg);
			    			}
			    		},
			    		error:function(){
			    			alert("删除失败");
			    		}
			    	});
			   }
//查看购物车
function seeCarProduct(){
		    	    $(".all").hide();
					$(".all2").hide();
					$(".all3").hide();
					$(".all4").show();
					$(".all5").hide();
					
					
					//获取请求参数
					var userId = getCookie("userId");
					alert(userId);
					//发送ajax请求
					$.ajax({
						url:path+"/car/see.do",
						type:"post",
						data:{"userId":userId},
						dataType:"json",
						success:function(result){
							if(result.status==0){
								//获取返回值
								 var products = result.data;
								for(var i=0;i<products.length;i++){
									var productId    = products[i].shop_product_id;
									//获取商品名称
									var productName  = products[i].shop_product_name;
									//获取商品价格
									var productPrice = products[i].shop_product_price;
									//获取商品图片
									var productImg  = products[i].shop_image_address;
									var productCount = products[i].shop_order_count;
									
									//拼接
									    var sli="";
										sli+='<tr>';
										sli+='<th >';
										sli+='<img style="width: 97px; padding:8px;" src=';
										sli+=productImg;
									    sli+='>';       
								        sli+='</th>';
										sli+='<th class="te">';
										sli+= productName;
										sli+='</th>';
									    sli+='<th class="te">';
									    sli+= productPrice;
									    sli+='</th>';
										sli+='<th class="te">';
										sli+='1</th>';
										sli+='<th class="te allP">';
										sli+= productPrice;
										sli+='</th>';
										sli+='<th class="te">';
										sli+='<a href="javascript:;" style="cursor:pointer;" id="del">删除</a>';
										sli+=' &nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;"  style="cursor:pointer;padding-right:5px;">';
										sli+='<input type="checkbox" id="cr"/><label for="cr">';
										sli+='购买</label>';
										sli+='</a>';
										sli+='</th>';
									    sli+='</tr>';
									        var $tr = $(sli);//将sli字符串转成jQuery对象td元素
									        $tr.data("productId",productId);//将值与jQuery对象元素绑定
									    	$("#carShow").append($tr);
									
								}
							    	}
							
						},
						error:function(){
							alert("购物车加载失败！");
						}
					});
		       }
//加入购物车
function addCarProduct(){
				    $(".all").hide();
					$(".all2").hide();
					$(".all3").show();
					$(".all4").hide();
					$(".all5").hide();
					//获取请求参数
				    var productId=$("#span_id").text().trim();
				    var userId = getCookie("userId");
				    var count = $("#quantity").val();
					//发送ajax请求
					$.ajax({  
						url:path+"/car/add.do",		
						type:"post",
						data:{"productId":productId,"userId":userId,"count":count},
						dataType:"json",
						success:function(result){
							if(result.status==0){
						       alert(result.msg);
							}
						},
						error:function(){
							alert("加入失败");
						}
					});
			   }