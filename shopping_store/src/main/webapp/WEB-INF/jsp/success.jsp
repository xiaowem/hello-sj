<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上传成功</title>
</head>
<body>
	<h3>文件上传成功</h3>您上传的文件信息为：<br/>
	文件名称：${fileName }<br/>
	文件大小：${fileSize }<br/>
	文件类型：${fileType }<br/>
	文件路劲：${filePath }<br/>
	<a href='<%=request.getContextPath() %>/file/download1.html?path=${filePath }&fileType=${fileType }&fileName=<%=URLEncoder.encode((String)request.getAttribute("fileName"),"utf-8")%>'>文件下载一</a>
	<br/>
	<a href='<%=request.getContextPath() %>/file/download2.html?path=${filePath }&fileType=${fileType }&fileName=<%=URLEncoder.encode((String)request.getAttribute("fileName"),"utf-8")%>'>文件下载二</a>
</body>
</html>