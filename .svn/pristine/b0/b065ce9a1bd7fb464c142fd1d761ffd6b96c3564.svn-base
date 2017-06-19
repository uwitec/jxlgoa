<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@page import="com.wuxianedu.service.GradeService"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" session = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.wuxianedu.service.StudentService"%>
<%@page import="com.wuxianedu.domain.Student"%>
<%@page import="com.wuxianedu.domain.Grade"%>
<%@page import="java.util.List"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>查询学生列表</title>
	<script type="text/javascript" src="/OA/teacher/js/ShowCalendar.js"></script>
	<style type="text/css">
		#topic input{
			width: 120px;
		}
		#topic button{
			width: 100px;
		}
		#topic{
			margin-top: 30px;
			margin-left: 300px;
		}
	
		#bottom{
			margin-top: 30px;
			margin-left: 300px;
		}
	</style>
	
</head>
<body>
<h1 align="center">学生列表信息</h1>
	<div id="topic">
		<jsp:useBean id="studentBean" class="com.wuxianedu.domain.StudentBean" scope="request" />
		<form:form modelAttribute="studentBean" action="${pageContext.request.contextPath}/admin/getAllStudents" method="post">
			<%  
				AbstractApplicationContext context = (AbstractApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
				GradeService gradeSvc = (GradeService)context.getBean("gradeService");
				List<Grade> list = gradeSvc.queryAllGrad();
			    pageContext.setAttribute("grades", list);
			%>
			
	            <%-- <select name="grades.gid">
			       <option disabled="disabled" selected="selected">-选择班级-</option>
			       <c:forEach var="grade" items="${grades}">
			           <option value="${grade.className}">${grade.className}</option>
			       </c:forEach>
	   			</select> --%>
	   			<c:if test="${not empty studentBean}">
	   			<form:select path="gid">
					<option>-选择班级-</option>	   			
					<c:forEach var="grade" items="${grades}">
						<form:option value="${grade}">${grade.className}</form:option>	
					</c:forEach>	   			
	   			</form:select>
	   			</c:if>
	   			姓名:<form:input path="studentName"/>
	   			毕业院校:<form:input path="graduateInstitutions"/>
	   			出生年月:<form:input path="birthday" onClick="showCalendar(this.id)"/>
	   			进班时间:<form:input path="registerTime" onClick="showCalendar(this.id)"/>
	   			状态:<form:input path="status"/>
				<input type="submit" value="搜索"> 
				
		</form:form>
		<button id="one"><a href="/OA/addStudent.jsp"><font color="black">添加</font></font></a></button>
	</div>	
	<div id="bottom">
	
		<form action='<c:url value="${pageContext.request.contextPath}/admin/queryAllStud" />'>
			<table cellspacing="0px" cellpadding="10px" border="1px" width="1000px">
				<tr>
					<td>名称</td>
					<td>毕业院校</td>
					<td>出生年月</td>
					<td>手机</td>
					<td>进班时间</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
				
				<c:if test="${not empty allStudents}">
				
					<c:forEach var="student" items="${allStudents}">
						<tr>
							<td>${student.studentName}</td>
							<td>${student.graduateInstitutions}</td>
							<td><fmt:formatDate value="${student.birthday}" type="date" pattern="yyyy-MM-dd"/></td>
							<td>${student.phone}</td>
							<td><fmt:formatDate value="${student.registerTime}" type="date" pattern="yyyy-MM-dd"/></td>
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
