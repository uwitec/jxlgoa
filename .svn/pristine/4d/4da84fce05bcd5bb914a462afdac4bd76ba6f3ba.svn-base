<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'admin_Login.jsp' starting page</title>
     <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    
    
  </head>
  <jsp:useBean id="adminUser" class="com.wuxianedu.domain.Administrator" scope="request"></jsp:useBean>
  <body>
   		
   		 <div id="login_dialog" class="panel panel-success" style="width: 530px;margin-left: 430px;margin-top: 50px">
             <div class="panel-heading"> 
                <h3 class="panel-title" style="text-align:center">管理员登录</h3> 
            </div> 
            
            <div style="background-color:#ffffff;margin:10px;" class="panel-body">
              <form:form modelAttribute="adminUser" action="${pageContext.request.contextPath}/admin/adminLogin" method="post" onsubmit="check()">
                                    
                       <div class="input-group col-lg-6" style="margin-left: 130px">
				            <span class="input-group-addon">用户名</span>
				               <form:input path="username" class="form-control"/>
        			   </div>
        			   <center>
        			   <font color='red' size="-1">
                			  <form:errors path="username" />
                	   </font>
                	   </center>
        			   
        			   <div style="height: 30px"></div>
        			   <div class="input-group col-lg-6" style="margin-left: 130px">
				            <span class="input-group-addon">密&nbsp;&nbsp;&nbsp;码</span>
				            <form:input path="password" type="password" class="form-control"/>
				            
        				</div>
        				<center>
        				<font color='red' size="-1" >
                			<form:errors path="password" />
                		</font>
                		</center>
        				
        				 <div style="height: 20px"></div>
                    <div class="btn-group col-lg-2" style="margin-left: 150px">
        				<button type="submit" class="btn btn-default">登录</button>
        			</div>
        			<div class="btn-group col-lg-2" style="margin-left: 50px">
        				<button type="reset" class="btn btn-default">重置</button>
        			</div>             
                </form:form>
            </div>
            
        </div>
  </body>
</html>
