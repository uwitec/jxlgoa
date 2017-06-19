<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.wuxianedu.domain.Types"%>
<%@page import="com.wuxianedu.service.GetTypesService"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<div class="header">
		<font size="5px">创建试卷</font>

	</div>
	<div class="body1">
	<jsp:useBean id="paperBean" class="com.wuxianedu.domain.PaperBean" scope="request"></jsp:useBean>
	<form:form modelAttribute="paperBean" action="paper/createPaper" method="POST">
		<div class="bodytext0">
			<font size="5px">试卷名称:&nbsp;&nbsp;</font>
		</div>
		
		<div class="bodytext1">
		<!-- <input type="text" class="form-control" placeholder="请输入题目"> -->
		<form:input path="paperName" cssClass="form-control"/>
		</div>
		<div class="error">
			<form:errors path="paperName"/>
		</div>
		
		<br>
		
		<div class="bodytext0">
			<font size="5px">试题数量</font>
		</div>
		<div class="bodytext1 " >
		<!-- <input type="text" class="form-control" placeholder="请输入A选项内容"> -->
		<form:input path="questionNumber" cssClass="form-control"/>
		</div>
		<div class="error">
			<form:errors path="questionNumber"/>
		</div>
		
		<br>
		
		<div class="bodytext0">
			<font size="5px">类 型:&nbsp;&nbsp;</font>
		</div>
		<%AbstractApplicationContext context =  (AbstractApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		GetTypesService leagueSvc = (GetTypesService)context.getBean("getTypesService");
		List<Types> list=leagueSvc.getTypesAll();
		pageContext.setAttribute("types", list);
		%>
		<div class="bodytext2">
		<form:select path="typesId" cssClass="form-control">
			<option disabled="disabled" selected="selected">-请选择-</option>
			<c:forEach var="typ" items="${types }">
				<option value="${typ.id}">${typ.typeName }</option>
			</c:forEach>
		</form:select>
		
		</div>
		<br>
		<br>
		<div class="syserror">
			<p><b>系统错误</b></p>
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
