<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8"%> 
<%@ page import="java.text.*"%> 


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
</head>


<style type="text/css">
	.header1{
		height: 40px;
		width: 2000px;
		margin-top: 0px;
		margin-left: 0px;
		position: relative;
	
		background-color: #3C5E7C;
	}
	.header2{
		height: 20px;
		width: 2000px;
		margin-top: 0px;
		margin-left: 0px;
		background-color: #DFE5EC;
		border-bottom: 1px solid gray;
		border-top: 1px solid gray;
	}
	.header3{
		height: 20px;
		width: 2000px;
		margin-top: 0px;
		margin-left: 0px;
		background-color: #EEF2FB;
	}
	.text1{
		float: left;
		line-height: 50px;
		margin-left: 100px;
		width: 350px;
		height: 40px;
	}
	.text2{
		float: left;
		line-height: 50px;
		width: 200px;
		height: 40px;
		margin-left: 700px;
	}
</style>
<body>
<div class="header1">
	<div class="text1">
		<font size="4px;"color="white"><span id="today"></span></font>
	</div>
	<div class="text2">
		<font size="4px;"color="white"><span>学生：${studentInfo.studentName }/<a href="javascript:void(0)"onclick="check()"><font color="orange">注销</font></a></span></font>
	</div>
</div>
<div class="header2">
	
</div>
<div class="header3">
	
</div>
</body>
<script type="text/javascript">



	  function setDateTime() {

		var date =new Date();
		var day = date.getDay();
		var week;
		switch (day) {
		case 0:
			week = "星期日";
			break;
		case 1:
			week = "星期一";
			break;
		case 2:
			week = "星期二";
			break;
		case 3:
			week = "星期三";
			break;
		case 4:
			week = "星期四";
			break;
		case 5:
			week = "星期五";
			break;
		case 6:
			week = "星期六";
			break;
		}
		var today = date.getFullYear() + "年" + (date.getMonth() + 1) + "月"
				+ date.getDate() + "日  " + week + " " + date.getHours() + ":"
				+ date.getMinutes() + ":" + date.getSeconds();
		document.getElementById("today").innerHTML = today;
		
	}
	 
	window.setInterval("setDateTime()", 1000);
	
	 function check() {
	     if(confirm("您确定要退出吗?")){
	   	  window.parent.location.href="/OA/studentCancel";
	     }
	 }
</script>
</html>