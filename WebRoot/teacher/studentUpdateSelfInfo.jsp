<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<script type="text/javascript" src="teacher/js/ShowCalendar.js"></script>
</head>
	<style type="text/css">

	.bodyinfo{
		width: 980px;
		margin: auto;
		margin-top: 80px;
		height: 600px;
	}
	.bodyinfo1{

		width: 880px;
		height: 350px;
	}
	.info{
		width: 690px;
		display: inline-block;
		height: 350px;
		float: left;
	}
	.photo{
		display: inline-block;
	
		width: 180px;
		float: right;
		height: 200px;
		margin-bottom: 150px;
	}
	.photo1{
		
		width: 150px;
		height: 200px;
	}
	.butt{
		width: 100px;
		height: 50px;
		margin-left: 100px;

	}
	.textinfo1{

		width: 770px;
		height: 35px;
	}
	.textinfo2{

		width: 770px;
		height: 35px;
		margin-top: 20px;
	}
	.textinfoin{

		display: inline-block;
		width: 330px;
		height: 33px;
		color: black;
	}
	</style>
<body>
	<div class="bodyinfo">
	<jsp:useBean id="studentSelfUpdateBean" class="com.wuxianedu.domain.StudentSelfUpdateBean" scope="request"></jsp:useBean>
	<form:form modelAttribute="studentSelfUpdateBean" action="updateStudentInfo" method="POST">
		<div class="bodyinfo1">
			<div class="info">
				<div class="textinfo1">
					<div class="textinfoin">
						姓名:<form:input path="studentName"/><font color="red"><form:errors path="studentName"/></font>
					</div>
					<div class="textinfoin">
						性别: <form:radiobutton path="gender" value="男"/>男  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<form:radiobutton path="gender" value="女"/>女<font color="red"><form:errors path="gender"/></font>
					</div>
					
				</div>
				<div class="textinfo2">
					
					<div class="textinfoin">
						籍贯:<form:input path="nativePlace"/><font color="red"><form:errors path="nativePlace"/></font>
					</div>
					<div class="textinfoin">
						手机:<form:input path="phone"/><font color="red"><form:errors path="phone"/></font>
					</div>
				</div>
				<div class="textinfo2">
					
					<div class="textinfoin">
						密码:<form:input path="password"/><font color="red"><form:errors path="password"/></font>
					</div>
					<div class="textinfoin">
						生日:<form:input path="birthday"	 onClick="showCalendar(this.id)" readonly="true"/><font color="red"><form:errors path="birthday"/></font>
					</div>
					
				</div>
				
			</div>
			<div class="photo">
				<div class="photo1">
					<img src="${studentInfo.photoAddress}" width="150px" height="200px">
					
				</div>
				<input type="file" name="file">
			</div>
		</div>
		<div class="butt">
			<button class="btn btn-primary">更新资料</button>
		</div>
		</form:form>
	</div>

</body>
</html>