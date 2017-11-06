//根据商品name搜索商品
function searchProductName(){   
				 	//alert("-----");
				 	var productName = $(".form-control").val().trim()
				 	$(".all").hide();//隐藏首页
					 $(".all2").show();//显示商品页
					 $(".all3").hide();//隐藏商品详情页
					 $(".all4").hide();
					 $(".all5").hide();
				 	//alert(productName);
				 	  $.ajax({					  
						  url:path+"/product/findname.do",
						  type:"post",
						  data:{"productName":productName},
						  dataType:"json",
						  success:function(result){
							if(result.status==1) {//
								alert(result.msg);
								//alert(result.data)
							}else if(result.status==0){
								
								 var products = result.data;
								 
								for(var i=0;i<products.length;i++){
									//获取商品ID
									var productId    = products[i].shop_product_id;
									//获取商品名称
									var productName  = products[i].shop_product_name;
									//获取商品名称
									var productPrice = products[i].shop_product_price;
									//获取图片地址
									var productImg   = products[i].shop_image_address;
									
									//创建一个商品列表项<div>元素					
								 var sli="";
								   sli+='<div align="center" class="col-md-2">';
								   sli+='<a style="display: inline-block width="170" height="170">';
								   sli+='<img src=';
								   sli+=productImg;
								   sli+='>';
								   sli+='</a>';
								   sli+='<p>';
								   sli+='<a id="check">';
								   sli+=productName;
								   sli+='</a>';
								   sli+='</p>';
								   sli+='<p>';
								   sli+='<font color="#FF0000">商城价：&yen;';
								   sli+=productPrice;
								   sli+='</font>';
								   sli+='</p>';
							       sli+='</div>';
							       var $li = $(sli);//将sli字符串转成jQuery对象li元素
							       $li.data("productId",productId);//将值与jQuery对象元素绑定
							    	//将li元素添加到笔记本div列表区
							    	$("#image_all").append($li);
							       
								}
							  }	
							
						  },
						  error:function(){
							  alert("跳转失败");
						  }
						  
					  });
					
				 	
				 }

//分类查询产品后点击出现详情
function seeLoginedProductParticular1(){
					//alert("111");
					//获取商品名称
					var productName = $(this).text().trim();
							$(".all").hide();
							$(".all2").hide();
							$(".all3").show();
							$(".all4").hide();
							$(".all5").hide();
							//发送ajsx请求
						  //alert(productName);
							$.ajax({
								url:path+"/product/seeO.do",
								type:"post",
								data:{"productName":productName},
								dataType:"json",
								success:function(result){
									if(result.status==0){
									   var product    = result.data;	
										var productId    =product.shop_product_id;   
										var productName  =product.shop_product_name; 
										var productPrice =product.shop_product_price;
										var productCount =product.shop_product_count;  
										var productImg   =product.shop_image_address;
										//alert(productImg);
										$("#span_id").text(productId);
										$("#span_price").text(productPrice);
										$("#span_count").text(productCount);
										$("#productImg").html('<img src="'+productImg+'"/>').attr("style","height:200px;width:260px;text-align:center");           
//										//绑定
//										var $div=$("#showAll");
//										$div.data("productId",productId);
									}
								},
								error:function(){
									alert("查看失败");
								}
							});
						}

//登录后查看详情
function seeLoginedProductParticular(){
							//获取请求参数
						   var productName=$(this).text().trim();
							//alert(productName);
							//window.location.href="product_info.html";
							$(".all").hide();
							$(".all2").hide();
							$(".all3").show();
							$(".all4").hide();
							$(".all5").hide();
							//发送ajsx请求
							$.ajax({
								url:path+"/product/seeO.do",
								type:"post",
								data:{"productName":productName},
								dataType:"json",
								success:function(result){
									if(result.status==0){
										  var product    = result.data;	
										var productId    =product.shop_product_id;   
										var productName  =product.shop_product_name; 
										var productPrice =product.shop_product_price;
										var productCount =product.shop_product_count;  
										var productImg   =product.shop_image_address;
										//alert(productImg);
										$("#span_id").text(productId);
										$("#span_price").text(productPrice);
										$("#span_count").text(productCount);
										$("#productImg").html('<img src="'+productImg+'"/>').attr("style","height:200px;width:260px;text-align:center");           
//										//绑定
//										var $div=$("#showAll");
//										$div.data("productId",productId);
									}
								},
								error:function(){
									alert("查看失败");
								}
							});
						}

//主页提示用户登录后才可加入购物车
function alertUserLogin(){
		alert("请用户登录");					     
 }

//查看主页商品详情
function seeProductParticular(){
							//获取请求参数
						   var productName=$(this).text().trim();
							//alert(productName);
							//window.location.href="product_info.html";
							$(".all").hide();
							$(".all2").hide();
							$(".all3").show();
							$(".all4").hide();
							$(".all5").hide();
							//发送ajsx请求
							$.ajax({
								url:path+"/product/seeO.do",
								type:"post",
								data:{"productName":productName},
								dataType:"json",
								success:function(result){
									if(result.status==0){
										  var product    = result.data;	
										var productId    =product.shop_product_id;   
										var productName  =product.shop_product_name; 
										var productPrice =product.shop_product_price;
										var productCount =product.shop_product_count;  
										var productImg   =product.shop_image_address;
										//alert(productImg);
										$("#span_id").text(productId);
										$("#span_price").text(productPrice);
										$("#span_count").text(productCount);
										$("#productImg").html('<img src="'+productImg+'" />').attr("style","height:200px;width:260px;text-align:center");           
										
									}
								},
								error:function(){
									alert("查看失败");
								}
							});
						}


//搜索商品
function searchProductList(){   
				 	//alert("-----");
				 	var productList = $(".form-control").val().trim()
				     $(".all").hide();//隐藏首页
					 $(".all2").show();//显示商品页
					 $(".all3").hide();//隐藏商品详情页
					 $(".all4").hide();
					 $(".all5").hide();
				 	//alert(productList);
				 	  $.ajax({					  
						  url:path+"/product/find.do",						  type:"post",
						  data:{"productList":productList},
						  dataType:"json",
						  success:function(result){
							if(result.status==1) {//
								alert(result.msg);
//								//alert(result.data)
							}else if(result.status==0){
//								
								 var products = result.data;
//								 
								for(var i=0;i<products.length;i++){
//									//获取商品ID
									var productId    = products[i].shop_product_id;
									//获取商品名称
									var productName  = products[i].shop_product_name;
									//获取商品价格名称
									var productPrice = products[i].shop_product_price;
//									//获取图片地址									var productImg   = products[i].shop_image_address;
									
									//创建一个商品列表项<div>元素					
									var sli="";
								   sli+='<div align="center" class="col-md-2">';
								   sli+='<a style="display: inline-block width="170" height="170">';
								   sli+='<img src=';
								   sli+=productImg;
								   sli+='>';
								   sli+='</a>';
								   sli+='<p>';
								   sli+='<a id="check">';
								   sli+=productName;
								   sli+='</a>';
								   sli+='</p>';
								   sli+='<p>';
								   sli+='<font color="#FF0000">商城价：&yen;';
								   sli+=productPrice;
								   sli+='</font>';
								   sli+='</p>';
							       sli+='</div>';
							       var $li = $(sli);//将sli字符串转成jQuery对象li元素
							       $li.data("productId",productId);//将值与jQuery对象元素绑定
							    	//将li元素添加到笔记本div列表区
							    	$("#image_all").append($li);
							       
								}
							  }	
							
						  },
						  error:function(){
							  alert("跳转失败");
						  }
						  
					  });
					
				 	
				 }




/**
 * 显示商品
 */

function showProductList(){   
						
					  $(".all").hide();//隐藏首页
					  $(".all2").show();//显示商品页  
					  $(".all4").hide();
					  $(".all5").hide();
					  $(".all3").hide();
					 //获取请求参数
					 var productList = $(this).parent().text().trim();	
					 
					 // alert(productList);
					  //发送Ajax请求
					  $.ajax({					  
						  url:path+"/product/list.do",
						  type:"post",
						  data:{"productList":productList},
						  dataType:"json",
						  success:function(result){
							  	
							if(result.status==0){
								
								 var products = result.data;
								 
								for(var i=0;i<products.length;i++){
									//获取商品ID
									var productId    = products[i].shop_product_id;
									//获取商品名称
									var productName  = products[i].shop_product_name;
									//获取商品名称
									var productPrice = products[i].shop_product_price;
									//获取图片地址
									var productImg   = products[i].shop_image_address;
									
									//创建一个商品列表项<div>元素					
								 var sli="";
								   sli+='<div align="center" class="col-md-2">';
								   sli+='<a style="display: inline-block width="170" height="170">';
								   sli+='<img src=';
								   sli+=productImg;
								   sli+='>';
								   sli+='</a>';
								   sli+='<p>';
								   sli+='<a id="check">';
								   sli+=productName;
								   sli+='</a>';
								   sli+='</p>';
								   sli+='<p>';
								   sli+='<font color="#FF0000">商城价：&yen;';
								   sli+=productPrice;
								   sli+='</font>';
								   sli+='</p>';
							       sli+='</div>';
							       var $li = $(sli);//将sli字符串转成jQuery对象li元素
							       $li.data("productId",productId);//将值与jQuery对象元素绑定
							    	//将li元素添加到笔记本div列表区
							    	$("#image_all").append($li);
							       
								}
							  }	
							
						  },
						  error:function(){
							  alert("跳转失败");
						  }
						  
					  });
					
					 }