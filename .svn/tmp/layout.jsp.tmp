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
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/ShowCalendar.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.0.js"></script>
  <script type="text/javascript">
	  function setDateTime() {
		var date = new Date();
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
		        window.location.href = "adminLogin.jsp";
	           }
	       }
</script>
  	<base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="/OA/teacher/js/jquery.js"></script>
	<script type="text/javascript" src="/OA/teacher/js/bootstrap.js"></script>
  	<link rel="stylesheet" type="text/css" href="/OA/css/bootstrap.css">
  	<link rel="stylesheet" href="/OA/teacher/js/css/cxcalendar.css">
  	<link href="/OA/student/images/css2.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="/OA/teacher/js/calendar.js"></script>
  	<style type="text/css">
  		.top{
  			width:90%;
  			height:60px;
  			margin: 0 auto;
  			border-bottom: 1px solid #EEEEEE;
  		}
  		.top h2{
  			line-height: 60px;
  			text-align: center;
  		}
  		.mainBody{
  			width:100%;
  			height: 420px;
  			
  		}
  		.leftBody{
  			width:20%;
  			float:left;
  			border-right: 1px solid #EEEEEE;
  			margin-left: 60px;
  			
  		}
  		 .leftBody h3{color: gray;}
		 .leftBody a{font-size: 16px; font-weight: bold;}
		 .leftBody a:link{color: black;}
		 .leftBody a:visited{color: black;}
		 .leftBody a:active{color: black;}
		 .act{
	     	background-color: rgb(244,242,239);
	     	border-right: 5px solid orange;
     	}
     	.rightBody{
     		margin-top:20px;
     		float:right;
     		width:75%;
     		text-align:center;
     		
     	}
     	.box{
     		width:100%;
     		height: 30px;
     	}
     	.leftDiv{
     		float:left;
     		margin-left: 30px;
     		line-height:30px;
     	}
     	.rightDiv{
     		margin-right:40px;
     		line-height:30px;
     		float:right;
     	}
     	
     	.header{
		width: 100%;
		height: 25px;
		text-align: center;
	}
	.select{
		margin-top: 10px;
		margin-bottom:20px;
		width: 900px;
		height: 50px;
	}
	.selecttext{
		text-align: right;
		display: inline-block;
		width: 130px;

	}
	.selectbody1{
		margin-left: 0px;
		width: 100px;
		display: inline-block;

	}
	.selectbody2{
		margin-left: 30px;
		width: 300px;
		display: inline-block;
	}
	.selectbody3{
		margin-left: 30px;
		width: 50px;
		display: inline-block;
	}
	.selectbody4{
		margin-left:120px;
		width: 50px;
		display: inline-block;
	}
	.body{
		width: 95%;
		height: 425px;
		margin: auto;
	}
	.page{
		width: 70%;
		height: 50px;
		margin: auto;
	}
	.opration{
		width: 80px;
	}
	.body1{
		margin: auto;
		margin-top: 10px;
		width: 80%;
		height: 500px;
		text-align: left;
	}
	.bodytext0{
		display: inline-block;
		height: 40px;
		margin-top: 10px;
		width: 80px;
		display: inline-block;
		line-height: 30px;
	}
	.bodytext1{
		height: 40px;
		margin-top: 10px;
		width: 60%;
		display: inline-block;
		line-height: 30px;

	}
	.bodytext3{
		height: 30px;
		margin-top: 10px;
		width: 20%;
		display: inline-block;
		line-height: 30px;
	}
	.bodytext2{
		height: 30px;
		margin-top: 10px;
		width: 10%;
		display: inline-block;
		line-height: 30px;
	}

	.sub{
		height: 60px;
		margin-top: 10px;
		margin-left: 260px;
		width: 40%;
	}
	.error{
		display: inline-block;
		margin-top: 10px;
		margin-left: 20px;
		width: 20%;
		height: 30px;
		line-height: 30px;
		font-size: 5px;
		color: red;
	}
	.syserror{
		height: 30px;
		margin-top: 10px;
		margin-left: 260px;
		width: 40%;
		color: red;
		text-align: center;
	}
	.STYLE3 {font-size: 18px; }
	.STYLE4 {font-size: 18px; font-weight: bold; }
	.STYLE5 {color: #FF0000} 	
  	</style>
  </head>
  <body >
    
    	<!--1:头部部分  -->
    	<div class="box">
    		<div class="leftDiv"><i class="icon-time"></i>&nbsp;&nbsp;<font id="today"></font></div>
    		<div class="rightDiv"><font color="red">欢迎管理员：<%=session.getAttribute("admin")%></font></div>
    	</div>
    	<div class="top">
    		
    		<h2>OA管理系统</h2>
    		
    	</div>
    	
    	<!-- 2:主体部分 -->
    	<div class="mainBody">
    	
    		<!-- 2-1:左部部分 -->
    		<div class="leftBody">
    			 <ul class="nav nav-pills nav-stacked">
			 	 	<li><h3>管理项</h3></li>
			 	 	<li value="1"><a href="${pageContext.request.contextPath}/admin/getTrainerByPage">讲师管理</a></li>
			 	 	<li value="2"><a href="${pageContext.request.contextPath}/adviser/getAdviserByPage">班主任管理</a></li>
			 	 	<li value="3"><a href="#">班级管理</a></li>
			 	 	<li value="4"><a href="#">学生管理</a></li>
			 	 	<li value="5"><a href="/OA/findAllItem">试题管理</a></li>
			 	 	<li value="6"><a href="/OA/paper/findAllPaper">试卷管理</a></li>
			 	 	<li value="7"><a href="/OA/exam/findAllExam">考试管理</a></li>
		 		 </ul>
    		</div>
    		
    		
    		<!--2-2：右边主体部分  -->
    		<div class="rightBody">
    			  <jsp:include page="/WEB-INF/jspf/${mainBody}" />
    		</div>
    		
    	</div>
    	
  </body>
  
</html>
