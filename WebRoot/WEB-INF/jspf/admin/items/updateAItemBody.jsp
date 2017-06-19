<%@page import="com.wuxianedu.domain.Types"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.wuxianedu.service.GetTypesService"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
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
	<title>updateItem</title>
	<link rel="stylesheet" type="text/css" href="teacher/js/bootstrap.css">
	<script type="text/javascript" src="teacher/js/jquery.js"></script>
	<script type="text/javascript" src="teacher/js/bootstrap.js"></script>
	<style type="text/css">
	.header{
		width: 80%;
		height: 25px;
		text-align: center;
	}
	.body1{
		margin: auto;
		margin-top: 0px;
		width: 80%;
		height: 500px;
	}
	.bodytext0{
		display: inline-block;
		height: 40px;
		margin-top: 5px;
		width: 80px;
		display: inline-block;
		line-height: 30px;
	}
	.bodytext1{
		height: 30px;
		margin-top: 5px;
		width: 60%;
		display: inline-block;
		line-height: 30px;

	}
	.bodytext3{
		height: 30px;
		margin-top: 0px;
		width: 60%;
		display: inline-block;
		line-height: 30px;
	}
	.bodytext2{
		height: 30px;
		margin-top: 0px;
		width: 60%;
		display: inline-block;
		line-height: 30px;
	}

	.sub{
		height: 30px;
		margin-top: 0px;
		margin-left: 200px;
		width: 40%;
	}
	.error{
		display: inline-block;
		margin-top: 10px;
		margin-left: 20px;
		width: 15%;
		height: 30px;
		line-height: 30px;
		font-size: 5px;
		color: red;
	}
	.syserror{
		height: 20px;
		margin-top: 0px;
		margin-left: 260px;
		width: 40%;
		color: red;
		text-align: center;
	}
	.bb{
		display: inline-block;
		width:40px;
	}
	
</style>
</head>

<body>
<jsp:useBean id="items" class="com.wuxianedu.domain.ItemBean" scope="request"></jsp:useBean>
	<form:form modelAttribute="items" action="updateItem" method="POST">
	<div class="header">
	
		<font size="5px">修改试题<form:hidden path="iid"/></font>
	
	</div>
	<div class="body1">
	
		
		
		<div class="bodytext0">
			<font size="5px">题 目:&nbsp;&nbsp;</font>
		</div>
		
		<div class="bodytext1">
		<!-- <input type="text" class="form-control" placeholder="请输入题目"> -->
		<form:input path="topic" cssClass="form-control" />
		</div>
		<div class="error">
			&nbsp;<form:errors path="topic"/>
		</div>
		<br>
		<div class="bodytext0">
			<font size="5px">选项A:</font>
		</div>
		
		<div class="bodytext1 " >
		<!-- <input type="text" class="form-control" placeholder="请输入A选项内容"> -->
		<form:input path="optionA" cssClass="form-control"/>
		</div>
		<div class="error">
			&nbsp;<form:errors path="optionA"/>
		</div>
		<br>
		<div class="bodytext0">
			<font size="5px">选项B:</font>
		</div>
		
		<div class="bodytext1">
		<!-- <input type="text" class="form-control" placeholder="请输入B选项内容"> -->
		<form:input path="optionB"  cssClass="form-control"/>
		</div>
		<div class="error">
			&nbsp;<form:errors path="optionB"/>
		</div>
		<br>
		<div class="bodytext0">
			<font size="5px">选项C:</font>
		</div>
		<div class="bodytext1">
		<!-- <input type="text" class="form-control" placeholder="请输入C选项内容"> -->
		<form:input path="optionC" cssClass="form-control" />
		</div>
		<div class="error">
			&nbsp;<form:errors path="optionC"/>
		</div>
		<br>
		<div class="bodytext0">
			<font size="5px">选项D:</font>
		</div>
		<div class="bodytext1">
		<!-- <input type="text" class="form-control" placeholder="请输入D选项内容"> -->
		<form:input path="optionD" cssClass="form-control"/>
		</div>
		<div class="error">
			&nbsp;<form:errors path="optionD"/>
		</div>
		<br>
		<div class="bodytext0">
			<font size="5px">答 案:&nbsp;&nbsp;</font>
		</div>
		
		<div class="bodytext3">
		<form:radiobutton path="answer" value="A" cssClass="form-control bb"/><font size="5px">A&nbsp;&nbsp;&nbsp;&nbsp;</font>
		<form:radiobutton path="answer" value="B" cssClass="form-control bb"/><font size="5px">B&nbsp;&nbsp;&nbsp;&nbsp;</font>
		<form:radiobutton path="answer" value="C" cssClass="form-control bb"/><font size="5px">C&nbsp;&nbsp;&nbsp;&nbsp;</font>
		<form:radiobutton path="answer" value="D" cssClass="form-control bb"/><font size="5px">D&nbsp;&nbsp;&nbsp;&nbsp;</font>
		</div>
		<div class="error">
			&nbsp;<form:errors path="answer"/>
		</div>
		<br>
		<div class="bodytext0">
			<font size="5px">类 型:&nbsp;&nbsp;</font>
		</div>
		
		<div class="bodytext2">
			<%  AbstractApplicationContext context =  (AbstractApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
				GetTypesService leagueSvc = (GetTypesService)context.getBean("getTypesService");
				List<Types> list=leagueSvc.getTypesAll();
				pageContext.setAttribute("types", list);
		    %>	
		<form:select path="types" cssClass="form-control" >
			<option disabled="disabled" selected="selected">-请选择-</option>
			<c:forEach var="typ" items="${types }">
			<form:option value="${typ.id}">${typ.typeName }</form:option>
			</c:forEach>
		</form:select>
		
		
		</div>
		<div class="error">
			&nbsp;<form:errors path="types"/>
		</div>
		<br>
		<br>
		<div class="syserror">
			<b><p> </p></b>
		</div>
		<br>

		<div class="sub">
			<input type="submit"value="&nbsp;&nbsp;&nbsp;&nbsp;提交&nbsp;&nbsp;&nbsp;&nbsp;" class="btn btn-success">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="&nbsp;&nbsp;&nbsp;&nbsp;重置&nbsp;&nbsp;&nbsp;&nbsp;" class="btn btn-success">
		</div>
		
		</form:form>
	</div>

</body>
</html>
