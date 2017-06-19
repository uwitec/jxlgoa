<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>添加学生</title>
	<style type="text/css">
		#all{
		margin-left:600px;
		margin-top:50px;
		}
	</style>
</head>
<body>
<h2 align="center"> 学生信息每项均为必填</h2>
	<div id="all">
		<jsp:useBean id="student" class="com.wuxianedu.domain.Student" scope="request" />
		<form:form modelAttribute="student" action="${pageContext.request.contextPath}/admin/insertStudent" method="post">
			<table>
				<tr>
		   			<td>学生姓名:</td><td><form:input path="studentName"/></td>
		   			<td>毕业院校:</td><td><form:input path="graduateInstitutions"/></td>
		   		</tr>
		   		<tr>
		   			<td>出生日期:</td><td><form:input path="birthday"/></td>
		   			<td>电&nbsp;&nbsp;话:</td><td><form:input path="phone"/></td>
		   		</tr>
		   		<tr>
		   			<td>性&nbsp;&nbsp;别:</td><td><form:input path="gender"/></td>
		   			<td>籍&nbsp;&nbsp;贯:</td><td><form:input path="nativePlace"/></td>
		   		</tr>
		   		<tr>
		   			<td>密&nbsp;&nbsp;码:</td><td><form:password path="password"/></td>
		   			<td>注册时间:</td><td><form:input path="registerTime"/></td>
		   		</tr>
		   		<tr>
		   			<td>状&nbsp;&nbsp;态:</td><td><form:input path="status"/></td>
		   			<td>照片路径:</td><td><form:input path="photoAddress"/></td>
		   		</tr>
		   		<tr>
		   			<td>班&nbsp;&nbsp;级:</td><td><input type="text"  name="grade.gid"/></td> 
		   			<td></td><td align="center"><input type="submit" value="注册"></td>
		   		</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
