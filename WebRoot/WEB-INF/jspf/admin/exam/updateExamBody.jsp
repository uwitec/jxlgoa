<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<div class="header">
		<font size="5px">修改考试名称</font>

	</div>
	<div class="body1">
	<jsp:useBean id="examBean" class="com.wuxianedu.domain.ExamBean" scope="request"></jsp:useBean>
	<form:form modelAttribute="examBean" action="exam/updateExam" method="POST">
		<form:hidden path="eid"/>
		<form:hidden path="cid"/>
		<form:hidden path="pid"/>
		<div class="bodytext0">
			<font size="5px">考试名称:&nbsp;&nbsp;</font>
		</div>
		
		<div class="bodytext1">
		<!-- <input type="text" class="form-control" placeholder="请输入题目"> -->
		<form:input path="examName" cssClass="form-control"/>
		</div>
		<div class="error">
			<form:errors path="examName"/>
		</div>
		
		<br>
		
		<%-- <div class="bodytext0">
			<font size="5px">班级名称</font>
		</div>
		<div class="bodytext1 " >
		<!-- <input type="text" class="form-control" placeholder="请输入A选项内容"> -->
		<form:input path="grade.className" cssClass="form-control" readonly="true"/>
		</div>
		<div class="error">
			<form:errors path="grade.className"/>
		</div>
		
		<br> --%>
		
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
