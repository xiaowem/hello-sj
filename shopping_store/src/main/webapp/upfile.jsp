<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/bootstrap.min.new.css"/>
    <link rel="stylesheet" href="css/bootstrap-maizi.css"/>
    <script src="js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="js/basevalue.js"></script>
		<!--导入jquery.js-->
		<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
		<!--导入bootstrap.js-->
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/upfile.js"></script>
		<script src="js/admin.js"></script>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		.del,.revise{
	        background:#51636b;
		    border-radius: 10px 10px;
		    padding-right: 3px;
		    text-align: center;
		    cursor: pointer;
		} 
		.del:hover{
		    background:#0f6f9a;
		}  
		.revise:hover{
		    background:#0f6f9a;
		}    
		.modal-body{
     	   height: 500px;
		
		}
		.modal-body1{
		 height: 372px;
		}
		label {
		    display: inline-block;
		    max-width: 100%;
		    margin-bottom: 5px;
		    font-weight: bold;
		    font-size: 21px;
		    }
		.xg{
			height:400px;
		}
     </style>
	<script type="text/javascript">
 $(function(){
		 //查看商品
	   $(".dropdown-menu li").on("click","a",showProductList1);
	     //删除商品
	   $("tbody").on("click","tr .del",delProduct);
	     //点击修改  出现修改页面
	    $("tbody").on("click","tr .revise",updateProduct);
 });
	</script>
  </head>
  
  <body>
   <!--导航-->
<nav class="navbar navbar-default">
    <div class="container">
        <!--小屏幕导航按钮F和logo-->
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <!--小屏幕导航按钮和logo-->
        <!--导航-->
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="ad_index.html"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;后台首页</a></li>
                <li><a href="ad_user_list.html"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;用户管理</a></li>
                <li class="active"><a href="upfile.jsp"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;商品管理</a></li>
                  <li id="out"><a href="#bbs"><span class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;退出</a></li>
            </ul>
        </div>
        <!--导航-->

    </div>
</nav>

   
 <div class="container">
    <div class="row">
        <div class="col-md-2">
            <div class="list-group">
                <a href="javascript:;" class="list-group-item active">商品管理</a>
                
                <a href="" role="button"  class="list-group-item" data-toggle="modal" data-target="#myModal">添加商品</a>
            </div>
        </div>
        <div class="col-md-10">
                 	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
								<ul class="nav navbar-nav" >
									<li class="dropdown" >
										<a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">家用电器<span class="caret"></span></a>
										<ul class="dropdown-menu" id="nav_menu">
											<li>
												<a href="javascript:;">热水器</a>
											</li>
											<li>
												<a href="javascript:;">洗衣机</a>
											</li>
										</ul>
										</li>
										<li class="dropdown">
											<a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">电子产品<span class="caret"></span></a>
											<ul class="dropdown-menu">
												<li>
													<a href="javascript:;">手机</a>
												</li>
												<li>
													<a href="javascript:;">电视机</a>
												</li>
												<li>
													<a href="javascript:;">电脑</a>
												</li>
											</ul>
										</li>
										<li class="dropdown">
											<a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">服装<span class="caret"></span></a>
											<ul class="dropdown-menu">
												<li>
													<a href="javascript:;">夹克</a>
												</li>
												<li>
													<a href="javascript:;">裤子</a>
												</li>
												<li>
													<a href="javascript:;">鞋</a>
												</li>
											</ul>
										</li>
										<li class="dropdown">
											<a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">日常用品<span class="caret"></span></a>
											<ul class="dropdown-menu">
												<li>
													<a href="javascript:;">水杯</a>
												</li>
												<li>
													<a href="javascript:;">牙刷</a>
												</li>
											</ul>
								</ul>
							</div>
			<table class="table">
                <thead>
                    <tr>
                        <th>商品ID</th>
                       <div> <th>商品名称</th></div>
                       <div> <th>商品价格</th></div>
                       <div> <th>商品数量</th></div>
                        <th>商品类别</th>
                        <th style="padding-left: 29px;">操作</th>
                    </tr>
                </thead>
                <tbody>
                        <!--拼接的内容-->
                        
                </tbody>
            </table>
            <nav class="pull-right">
                <ul class="pagination">
                    <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2 </a></li>
                    <li><a href="#">3 </a></li>
                    <li><a href="#">4 </a></li>
                    <li><a href="#">5 </a></li>
                    <li><a href="#">6 </a></li>
                    <li><a href="#"><span aria-hidden="true">&raquo;</span></a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">上传商品</h4>
            </div>
 <form method="post" action="<%=request.getContextPath()%>/file/fileUpLoad1.do" enctype="multipart/form-data">
 <!-- 	 -->
	<input type="file" name="file" style="color: white;"/><br/>
	
	<label for="">名称：</label>
	<input id="name" type="text" name="shop_product_name" /><span id="1_msg"></span><br>
	<label for="">价格：</label>
	<input id="price"  type="text" name="shop_product_price" /><span id="2_msg"></span><br>
	<label for="">数量：</label>
	<input id="count"  type="text" name="shop_product_count" /><span id="3_msg"></span><br>
	<label for="">类型：</label>
	<select id="list"  name="shop_product_list" style="color: black;">
	  <option value ="calorifier">热水器</option>
	  <option value ="washer">洗衣机</option>
	  <option value="mobilephone">手机</option>
	  <option value="television">电视机</option>
	  <option value ="computer">电脑</option>
	  <option value ="jacket">夹克</option>
	  <option value="pants">裤子</option>
	  <option value="7">鞋</option>
	  <option value ="cup">杯子</option>
	  <option value ="toothpaste">牙刷</option>
	</select>

	<select id="postfix" style="color: black;">
	  <option value="10">jpg</option>
	  <option value ="11">png</option>
	  <option value ="12">bmp</option>
	</select>
	<br>
	<input id="submit" type="submit" value="上传">
	</form>
         </div>
       </div>
    </div>



<!--    编辑商品信息部分-->
<div class="modal fade" id="myModal0" tabindex="-2" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog xg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">编辑商品信息</h4>
            </div>
            <div class="modal-body1">
                <form action="#">
                    <div class="form-group">
                        <label for="addId">商品ID:</label>
                        <input type="text" id="addId" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="addNa">商品名称：</label>
                        <input type="text" id="addNa" class="form-control" placeholder="商品名称">
                    </div>
                    <div class="form-group">
                        <label for="addPr">商品价格：</label>
                        <input type="text" id="addPr" class="form-control" placeholder="商品价格">
                    </div>
                    <div class="form-group">
                        <label for="addNum">商品数量：</label>
                        <input type="email" id="addNum" class="form-control" placeholder="商品数量">
                    </div>
                    
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="send1">提交</button>
            </div>
        </div>
    </div>
</div>

  </body>
</html>
