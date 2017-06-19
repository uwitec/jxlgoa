<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<title>添加班级</title>
	<style type="text/css">
		#all{
			margin-top:100px;
			margin-left:600px;
		}
	</style>
</head>
<body>
	<div id="all">
		<jsp:useBean id="grade" class="com.wuxianedu.domain.Grade" scope="request" />
		<form:form modelAttribute="grade" action="${pageContext.request.contextPath}/admin/insertGrad" method="post">
			<table>
				<tr>
		   			<td>班级名称:</td><td><form:input path="className"/></td>
		   		</tr>
		   		<tr>
		   			<td>开班时间:</td><td><form:input path="openTime"/></td>
		   		</tr>
		   		<tr>
		   			<td>学习时长:</td><td><form:input path="learningPhase"/></td>
		   		</tr>
		   		<tr>
		   			<td>状&nbsp;&nbsp;态:</td><td><form:input path="status"/></td>
		   		</tr>
		   		<tr>
		   			<td>班级类型:</td><td><input type="text" name="types.id"/></td>
		   		</tr>
		   		<tr>
		   			<td>讲师姓名:</td><td><input type="text" name="trainser.tid"/></td>
		   		</tr>
		   		<tr>
		   			<td>班主任姓名:</td><td><input type="text" name="adviser.aid"/></td>
		   		</tr>
			</table>
			<input type="submit" value="注册">
		</form:form>
	</div>
</body>
</html>
