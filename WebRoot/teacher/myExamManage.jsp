<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

	<title>examManage</title>
	<link rel="stylesheet" type="text/css" href="teacher/js/bootstrap.css">
	<script type="text/javascript" src="teacher/js/jquery.js"></script>
	<script type="text/javascript" src="teacher/js/bootstrap.js"></script>
	<style type="text/css">
	.header{
		width: 100%;
		height: 25px;
		text-align: center;
	}
	.select{
		margin-top: 10px;
		width: 100%;
		height: 50px;
	}
	.selecttext{
		text-align: right;
		display: inline-block;
		width: 150px;

	}
	.selectbody1{
		margin-left: 0px;
		width: 150px;
		display: inline-block;

	}
	.selectbody2{
		margin-left: 100px;
		width: 300px;
		display: inline-block;
	}
	.selectbody3{
		margin-left: 50px;
		width: 100px;
		display: inline-block;
	}
	.body{
		width: 95%;
		height: 425px;
		margin: auto;
	}
	
	.opration{
		width: 80px;
	}

</style>
</head>

<body>
	<div class="header">
		<font size="5px">考试管理</font>

	</div>
	<div class="select">
		<div class="selecttext">
			

		</div>
		<div class="selectbody1">
			
		</div>
		<div class="selectbody2">
			
		</div>
		<div class="selectbody3">
		</div>
	
	</div>

	<div class="body">
		<table class="table table-striped">
		<tr>
			<th>考试名称</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>分数</th>
			<th>考试状态</th>
		</tr>

		<!-- 情景颜色 -->
		<c:forEach var="exam" items="${exams}">
		<tr class="active" id="${exam.exam.eid }">
			<td class="success ">${exam.exam.examName }</td>
			<td class="info"><fmt:formatDate value="${exam.exam.startTime }" type="date" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td class="info"><fmt:formatDate value="${exam.exam.endTime }" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
			<td class="danger">${exam.score }</td>
			<td class="info " id="entryExam">${exam.state }</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	
</body>
<script type="text/javascript">
	window.setInterval("getState()", 1000*60*9);
	function getState(){
		$.ajax({  //json对象
			url:"/OA/examState",
			type:"get",
			dataType:"json",
			cache: false,
			success: function(msg){
				$.each(msg,function(k,v){
					$('#'+v.exam.eid + " > #entryExam").html(v.state);
				});
			}
		});
	}
</script>
</html>