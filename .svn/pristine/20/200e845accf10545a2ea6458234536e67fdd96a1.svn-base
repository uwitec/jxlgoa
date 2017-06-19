<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<div class="header">
		<font size="5px">修改试卷名称</font>
	</div>
	<div class="body1">
	<jsp:useBean id="paper" class="com.wuxianedu.domain.Paper" scope="request"></jsp:useBean>
	<form:form modelAttribute="paper" action="paper/updatePaper" method="POST">
		<form:hidden path="pid"/>
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
		<form:input path="questionNumber" cssClass="form-control" readonly="true"/>
		</div>
		<div class="error">
			<form:errors path="questionNumber"/>
		</div>
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