//修改商品
function updateProduct(){
	    	  var $li= $(this).parent().parent();
			  var productId = $li.data("productId");
			 // alert(productId);
			  $("#addId").val(productId);
	    //点击提交  修改商品
      $(".xg").on("click","#send1",
		 function(){
		   //获取请求参数
				var productId = $("#addId").val();
				var productName  = $("#addNa").val();
				var productPrice  = $("#addPr").val();
				var productCount = $("#addNum").val();
				$.ajax({
		    		url:path+"/admin/update.do",
		    		type:"post",
		    		data:{"productId":productId,"productName":productName,"productPrice":productPrice,"productCount":productCount},
		    		dataType:"json",
		    		success:function(result){
						alert(result.msg);
						window.location.href="upfile.jsp";
		    		},
		    		error:function(){
		    			} 
		     });
       });
    }

//删除商品
function delProduct(){
				//获取li标签
				var $li= $(this).parent().parent();
				var productId = $li.data("productId");
				//alert(productId);
			    //发送ajax请求
				$.ajax({
		    		url:path+"/admin/del0.do",
		    		type:"post",
		    		data:{"productId":productId},
		    		dataType:"json",
		    		
		    		success:function(result){
		    			if(result.status==0){
		    				$li.remove();
		    				alert(result.msg);
		    			}
		    		},
		    		error:function(){
		    			alert("删除失败");
		    		}
		    	});
   		 }


//查看类别商品
function showProductList1(){   					
					$(".tsa").html("");
					 //获取请求参数
					 var productList = $(this).parent().text().trim();	
					// alert(productList);
					// alert("sajdkas");
					  //发送Ajax请求
					  $.ajax({					  
						  url:path+"/product/list.do",
						  type:"post",
						  data:{"productList":productList},
						  dataType:"json",
						  success:function(result){
							  	
							if(result.status==0){
								//alert(productList);
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
									var productCount = products[i].shop_product_count;
										
									//创建一个商品列表项<div>元素					
									var sli="";
					    		     sli+='<tr class="tsa">';
			                      	 sli+='<td scope="row">';
			                      	 sli+=productId ;
			                      	 sli+='</td>';
			                      	 sli+='<td class="name">';
			                      	 sli+=productName;
			                      	 sli+='</td>';
			                      	 sli+='<td class="price">';
			                         sli+=productPrice;
			                         sli+='</td>';
			                      	 sli+='<td class="count">';
			                         sli+=productCount ;
			                         sli+='</td>';
			                         sli+='<td>';
			                         sli+=productList ;
			                         sli+='</td>';
			                         sli+='<td>';
			                         sli+='<span class="del">删除</span>&nbsp;&nbsp;&nbsp;';
			                         sli+='<span class="revise" data-toggle="modal" data-target="#myModal0">修改</span>';
			                         sli+='</td>';
			                         sli+='</tr>';
			                         var $li = $(sli);//将sli字符串转成jQuery对象li元素
			  				         $li.data("productId",productId);//将值与jQuery对象元素绑定
			  				    	$("tbody").append($li);
							      
								}
							  }	
							
						  },
						  error:function(){
							  alert("跳转失败");
						  }
						  
					  });
					
					 }

//删除用户
function delUser(){
				//获取tr标签
				var $li= $(this).parent().parent();
				var userId = $li.data("userId");
				//alert(userId);
			    //发送ajax请求
				$.ajax({
		    		url:path+"/admin/del.do",
		    		type:"post",
		    		data:{"userId":userId},
		    		dataType:"json",
		    		success:function(result){
		    			if(result.status==0){
		    				$li.remove();
		    				alert(result.msg);
		    			}
		    		},
		    		error:function(){
		    			alert("删除失败");
		    		}
		    	});
   		 }

//查看所有用户信息
function seeAllUser(){ 
		   //发送ajax请求
		   $.ajax({
		      url:path+"/admin/seeAll.do",
		      type:"post",
		      dataType:"json",	  
		     
		      success:function(result){
		    	  if(result.status==0){
				      var list = result.data;
					for(var i=0;i<list.length;i++){
						//获取用户ID
						var userId    = list[i].shop_user_id;
						//获取用户名称
						var userName  = list[i].shop_user_name;
						//获取用户邮箱
						var userEmail = list[i].shop_user_email;
						//获取用户密码
						var userPassword = list[i].shop_user_password;
					  //拼出返回结果
				       var sli="";
		    		     sli+='<tr>';
                      	 sli+='<th scope="row"  width:60px;>';
                      	 sli+=userId;
                      	 sli+='</th>';
                      	 sli+='<td>';
                      	 sli+=userName;
                      	 sli+='</td>';
                      	 sli+='<td>';
                     	 sli+=userPassword;
                     	 sli+='</td>';
                         sli+='<td>';
                         sli+=userEmail;
                         sli+='</td>';
                         sli+='<td>';
                         sli+='<span class="del">删除</span>&nbsp;&nbsp;&nbsp;&nbsp';
                         sli+='<span class="revise1" data-toggle="modal" data-target="#myModal0">修改</span>';
                         sli+='</td>';
                         sli+='</tr>';
                         var $li = $(sli);//将sli字符串转成jQuery对象li元素
  				         $li.data("userId",userId);//将值与jQuery对象元素绑定
  				    	$("tbody").append($li);
		    	     }
		    	  }
		      },
		      error:function(){
		    	  alert("查看用户失败");
		      }
		      
		     });
		   
    	}