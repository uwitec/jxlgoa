<%@page import="com.wuxianedu.domain.Trainer"%>
<%@page import="com.wuxianedu.service.TrainerMapperService"%>
<%@page import="com.wuxianedu.domain.Adviser"%>
<%@page import="com.wuxianedu.service.AdviserMapperService"%>
<%@page import="com.wuxianedu.domain.Types"%>
<%@page import="com.wuxianedu.service.TypersMapperService"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" session = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript" src="/OA/teacher/js/ShowCalendar.js"></script>
	<title>查询班级列表</title>
	<style type="text/css">
		#topic input{
			width: 120px;
		}
		#topic button{
			width: 100px;
		}
		#topic{
			margin-top: 100px;
			margin-left: 150px;
		}
	
		#bottom{
			margin-top: 80px;
			margin-left: 150px;
		}
	</style>
</head>
<body>
	<div id="topic">
	<!--按条件查找班级  -->
		<jsp:useBean id="grade" class="com.wuxianedu.domain.Grade" scope="request" />
		<form:form modelAttribute="grade" action="${pageContext.request.contextPath}/admin/getAllGrades" method="post">
	   			<%  
				AbstractApplicationContext context = (AbstractApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
				TypersMapperService tms = (TypersMapperService)context.getBean("typersMapperService");
				List<Types> typesList = tms.showAllType();
			    pageContext.setAttribute("typesLists", typesList);
			   
			    AdviserMapperService as = (AdviserMapperService)context.getBean("adviserMapperService");
			    List<Adviser> adviserList = as.listAllAdviser();
			    pageContext.setAttribute("adviserLists", adviserList);
			   
			    TrainerMapperService ts = (TrainerMapperService)context.getBean("trainerMapperService");
			    List<Trainer> trainerList = ts.listAllTrainer();
			    pageContext.setAttribute("trainerLists", trainerList);
			%>
	   			
	   			班级名:<form:input path="className"/>
	   			<%-- 班级类型:<form:input path="types.typeName"/> --%>
					班级类型: <select id="typesLists.id">
						<option selected value="请选择">请选择</option>
						<c:forEach var="types" items="${typesLists}">
							<option  value="${types.typeName}">${types.typeName}</option>
						</c:forEach>
					 </select>
	   			<%-- <form:input path="adviser.adviserName"/> --%>
	   				班主任: <select id="adviserLists.adviserName">
						<option selected value="请选择">请选择</option>
						<c:forEach var="advisers" items="${adviserLists}">
							<option  value="${advisers.adviserName}">${advisers.adviserName}</option>
						</c:forEach>
					 </select>
	   			<%-- <form:input path="trainer.trainerName"/> --%>
	   				 讲师:<select id="trainerLists.id">
						<option selected value="请选择">请选择</option>
						<c:forEach var="trainers" items="${trainerLists}">
							<option  value="${trainers.trainerName}">${trainers.trainerName}</option>
						</c:forEach>
					 </select>
	   			开班时间:<form:input path="openTime" onClick="showCalendar(this.id)"/>
	   			状态:<form:input path="status"/>
				<input type="submit" value="搜索"> 
		</form:form>
		<button><a href="/OA/addGrade.jsp"><font color="black">添加</font></font></a></button>
	</div>	
	<div id="bottom">
	<!--列出所有班级  -->
		<form action='<c:url value="${pageContext.request.contextPath}/admin/queryAllGrade" />'>
			<table cellspacing="0px" cellpadding="10px" border="1px" width="1000px">
				<tr>
					<td>班级名称</td>
					<td>班级类型</td>
					<td>班主任</td>
					<td>讲师</td>
					<td>开班时间</td>
					<td>学习时长</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
				
				<c:if test="${not empty gradeLists}">
				
					<c:forEach var="grades" items="${gradeLists}">
						<tr>
							<td>${grades.className}</td>
							<td>${grades.types.typeName}</td>
							<td>${grades.adviser.adviserName}</td>
							<td>${grades.trainer.trainerName}</td>
							<td><fmt:formatDate value="${grades.openTime}" type="date" pattern="yyyy-MM-dd"/></td>
							<td>${grades.learningPhase}</td>
							<td>${student.status}</td>
							<td>
								<SELECT id="selectStatus">
									<OPTION selected value="请选择">请选择</OPTION>
									<OPTION  value="修改">修改</OPTION>
									<OPTION  value="结课">结课</OPTION>
									<OPTION  value="重置密码">重置密码</OPTION>
								</SELECT>
							</td>	
						</tr>
					</c:forEach>
				</c:if>	
			</table>
		
		</form>	
	</div>
</body>
</html>
