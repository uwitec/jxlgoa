<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.wuxianedu.domain.Types"%>
<%@page import="com.wuxianedu.service.GetTypesService"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<body>
	<div class="header">
		<font size="5px">创建考试</font>

	</div>
	<div class="body1">
	<jsp:useBean id="examBean" class="com.wuxianedu.domain.ExamBean" scope="request"></jsp:useBean>
	<form:form modelAttribute="examBean" action="exam/createExam" method="POST">
		<div class="bodytext0">
			<font size="5px">名称:&nbsp;&nbsp;</font>
		</div>
		
		<div class="bodytext1">
		<!-- <input type="text" class="form-control" placeholder="请输入题目"> -->
		<form:input path="examName" cssClass="form-control"/>
		</div>
		<div class="error">
			<form:errors path="examName"/>
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
		<div class="bodytext1">
		<select id="getType" name="types" class="form-control" onchange="getTypes()" style="width:150px;">
			<option disabled="disabled" selected="selected" >-请选择类型-</option>
			<c:forEach var="typ" items="${types }">
				<option value="${typ.id}">${typ.typeName }</option>
			</c:forEach>
		</select>
		</div>
		<br>
		<div class="bodytext0">
			<font size="5px">班级:&nbsp;&nbsp;</font>
		</div>
		
		<div class="bodytext1">
		<!-- <select id="getGrade" name="cid" class="form-control" style="width:150px;">
			<option value='' disabled='disabled' selected='selected'>-请选择-</option>
		</select> -->
		<form:select id="getGrade" path="cid" class="form-control" style="width:150px;" >
			<form:option value="" disabled="true" >-请选择-</form:option>
		</form:select>
		</div>
		<br>
		<div class="bodytext0">
			<font size="5px">试卷:&nbsp;&nbsp;</font>
		</div>
		
		<div class="bodytext1">
		<!-- <select id="getPaper" name="pid" class="form-control" style="width:150px;">
			<option value='' disabled='disabled' selected='selected'>-请选择-</option>
		</select> -->
		<form:select id="getPaper" path="pid" class="form-control" style="width:150px;" >
			<option value='' disabled='disabled' selected='selected'>-请选择-</option>
		</form:select>
		</div>
		<br>
		<div class="bodytext0">
			<font size="5px">开始时间</font>
		</div>
		<div class="bodytext1 " >
		<!-- <input type="text" class="form-control" placeholder="请输入A选项内容"> -->
		<form:input path="startTime" cssClass="form-control input_cxcalendar" cssStyle="width:200px;" />
		</div>
		<div class="error">
			<form:errors path="startTime"/>
		</div>
		
		<br>
		
		<div class="bodytext0">
			<font size="5px">结束时间</font>
		</div>
		<div class="bodytext1 " >
		<!-- <input type="text" class="form-control" placeholder="请输入A选项内容"> -->
		<form:input path="endTime" cssClass="form-control input_cxcalendar" cssStyle="width:200px;"/>
		</div>
		<div class="error">
			<form:errors path="endTime"/>
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
<script>
		function getTypes(){
			var value = $('#getType').children("option:selected").val();
			$('#getGrade').empty();
			$('#getGrade').append("<option value='' disabled='true'>-请选择-</option>");
			$.ajax({
				url:'admin/findGradeByTypesId?id='+value,
				type:'GET',
				dataType:'json',
				success:function (msg) {
					var jsonData = msg;
					$.each(jsonData, function (k, v) {
						$('#getGrade').append('<option value="' + v.cid + '" >' + v.className + '</option>');
					});
				}
				
			});
			$('#getPaper').empty();
			$('#getPaper').append("<option value='' disabled='disabled' selected='selected'>-请选择-</option>");
			$.ajax({
				url:'paper/findPaperByTypesID?id='+value,
				type:'GET',
				dataType:'json',
				success:function (msg) {
					var jsonData = msg;
					$.each(jsonData, function (k, v) {
						$('#getPaper').append('<option value="' + v.pid + '" >' + v.paperName + '</option>');
					});
				}
				
			});
		}
	
		$('.input_cxcalendar').each(function(){
			var a = new Calendar({
				targetCls: $(this),
				type: 'yyyy-mm-dd HH:MM',
				wday:2
			},function(val){
				console.log(val);
			});
		});
	</script>
