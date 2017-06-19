<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%-- <base href="<%=basePath%>"> --%>
    
    <title>My JSP 'showStudent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <style type="text/css">
  	#like{
  		margin-top:20px;
  		margin-left:300px;
   	}
   	
   	#btna{
   		margin-top:20px;
   	}
   	#btnb{
   		width:300px;
   		heigth:1px;
   	}
  </style>
  </head>
  
  <body>
  	<h2 align="center">学生信息查询</h2>
  	<div id="like">
    	<table cellspacing="0px" cellpadding="10px" border="1px" width="1000px">
    			
    	  <c:choose>
		    	<c:when test="${empty studentBean}">
		    	<div>
		    		<h2>查询条件不正确....<a href="/OA/admin/queryAllStud">返回学生列表</a></h2>
		    	</div>
		    	</c:when>
		  <c:otherwise>
    			
				<tr>
					<td>名称</td>
					<td>性别</td>
					<td>班级</td>
					<td>毕业院校</td>
					<td>出生年月</td>
					<td>手机</td>
					<td>进班时间</td>
					<td>籍贯</td>
					<td>状态</td>
				</tr>
				
				<c:if test="${not empty studentBean}">
				
					<c:forEach var="student" items="${studentBean}">
						<tr>
							<td>${student.studentName}</td>
							<td>${student.gender}</td>
							<td>${student.className}</td>
							<td>${student.graduateInstitutions}</td>
							<td><fmt:formatDate value="${student.birthday}" type="date" pattern="yyyy-MM-dd"/></td>
							<td>${student.phone}</td>
							<td><fmt:formatDate value="${student.registerTime}" type="date" pattern="yyyy-MM-dd"/></td>
							<td>${student.nativePlace}</td>
							<td>${student.status}</td>
						</tr>
					</c:forEach>
				</c:if>	
				<div id="btna">
					<a href="/OA/admin/queryAllStud"><h2>返回学生列表</h2>
				</div>
			 </c:otherwise>
		   </c:choose>
		</table>
	</div>
  </body>
</html>
