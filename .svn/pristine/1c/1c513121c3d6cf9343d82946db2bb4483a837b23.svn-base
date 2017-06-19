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
		#all{
		
			margin-top:20px;
			margin-left:300px;
		}
		
	</style>

  </head>
  
  <body>
  	<h2 align="center">班级信息</h2>
  	<div id="all">
    	<table cellspacing="0px" cellpadding="10px" border="1px" width="1000px">
    			
    	  <c:choose>
		    	<c:when test="${empty AllGrades}">
		    	<div>
		    		<h2>无此班级信息，查看条件是否正确....<a href="/OA/admin/queryAllGrade">查看所有班级</a></h2>
		    	</div>
		    	</c:when>
		  <c:otherwise>
    			
				<tr>
					<td>班级名称</td>
					<td>班级类型</td>
					<td>班主任</td>
					<td>讲师</td>
					<td>开班时间</td>
					<td>学习时长</td>
					<td>状态</td>
				</tr>
				
				<c:if test="${not empty AllGrades}">
				
					<c:forEach var="grades" items="${AllGrades}">
						<tr>
							<td>${grades.className}</td>
							<td>${grades.types.typeName}</td>
							<td>${grades.adviser.adviserName}</td>
							<td>${grades.trainer.trainerName}</td>
							<td><fmt:formatDate value="${grades.openTime}" type="date" pattern="yyyy-MM-dd"/></td>
							<td>${grades.learningPhase}</td>
							<td>${grades.status}</td>
						</tr>
					</c:forEach>
				</c:if>	
				<h2><a href="/OA/admin/queryAllGrade">返回班级列表</a></h2>
			 </c:otherwise>
		   </c:choose>
		</table>
	  </div>
  </body>
</html>
