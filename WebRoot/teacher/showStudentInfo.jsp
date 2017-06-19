<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<title></title>
	<link rel="stylesheet" type="text/css" href="teacher/js/bootstrap.css">
	<script type="text/javascript" src="teacher/js/jquery.js"></script>
	<script type="text/javascript" src="teacher/js/bootstrap.js"></script>
</head>
	<style type="text/css">

	.body{
		background-color:#EEF2FB;
	}
	.bodyinfo{
		width: 800px;
		margin: auto;
		margin-top: 80px;
		height: 600px;
	}
	.bodyinfo1{
	
		width: 650px;
		height: 350px;
	}
	.info{
		width: 450px;
		display: inline-block;
		height: 350px;
		float: left;
	}
	.photo{
		display: inline-block;
		background-color: blue;
		width: 160px;
		float: right;
		height: 200px;
		margin-bottom: 150px;
	}
	.butt{
		width: 100px;
		height: 50px;
		margin-left: 100px;

	}
	.textinfo1{
		width: 450px;
		height: 35px;
	}
	.textinfo2{
		width: 450px;
		height: 35px;
		margin-top: 20px;
	}
	.textinfoin{
		display: inline-block;
		width: 223px;
		height: 33px;
	}
	</style>
<body class="body">
	<div class="bodyinfo">
		<div class="bodyinfo1">
			<div class="info">
				<div class="textinfo1">
					<div class="textinfoin">
						<h4>姓名:${studentInfo.studentName }</h4>
					</div>
					<div class="textinfoin">
						<h4>性别:${studentInfo.gender }</h4>
					</div>
					
				</div>
				<div class="textinfo2">
					
					<div class="textinfoin">
						<h4>籍贯:${studentInfo.nativePlace }</h4>
					</div>
					<div class="textinfoin">
						<h4>手机:${studentInfo.phone }</h4>
					</div>
				</div>
				<div class="textinfo2">
					
					<div class="textinfoin">
						<h4>毕业院校:${studentInfo.graduateInstitutions }</h4>
					</div>
					<div class="textinfoin">
						<h4>出生年月:${studentInfo.birthday }</h4>
					</div>
				</div>
				<div class="textinfo2">
					
					<div class="textinfoin">
						<h4>班级:${studentInfo.grade.className }</h4>
					</div>
					<div class="textinfoin">
						<h4>类型:${studentInfo.grade.types.typeName }</h4>
					</div>
				</div>
				<div class="textinfo2">
				<div class="textinfoin">
						<h4>学习状态:${studentInfo.status }</h4>
					</div>
					<div class="textinfoin">
						<h4>进班时间:${studentInfo.registerTime }</h4>
					</div>
					
				</div>
			</div>
			<div class="photo">
				<img src="${studentInfo.photoAddress}" width="160px" height="200px">
			</div>
		</div>
		
	</div>

</body>
</html>
