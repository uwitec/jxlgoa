<%@page import="com.wuxianedu.domain.Types"%>
<%@page import="com.wuxianedu.service.GetTypesService"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
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
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>showItem</title>
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

</style>
</head>

<body>
	<div class="header">
		<font size="5px">试题管理</font>

	</div>
	<div class="select">
	<jsp:useBean id="researchItemBean" class="com.wuxianedu.domain.ResearchItemBean" scope="request"></jsp:useBean>
		<form:form modelAttribute="researchItemBean" action="findItemByCondition" method="POST">
		<div class="selecttext">
			<h5><font size="4px">按条件查找：</font></h5>

		</div>
		<%AbstractApplicationContext context =  (AbstractApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		GetTypesService leagueSvc = (GetTypesService)context.getBean("getTypesService");
		List<Types> list=leagueSvc.getTypesAll();
		pageContext.setAttribute("types", list);
		%>
		
		<div class="selectbody1">
			<form:select path="type_id" cssClass="form-control" >
			<option  selected="selected" value="0">-全部-</option>
			<c:forEach var="typ" items="${types }">
			<form:option value="${typ.id}">${typ.typeName }</form:option>
			</c:forEach>
			</form:select>
		</div>
		<div class="selectbody2">
				<form:input path="topic" cssClass="form-control"/>
		</div>
		<div class="selectbody3">
				<input type="submit" value="&nbsp;&nbsp;&nbsp;搜索&nbsp;&nbsp;&nbsp;" class="btn btn-primary">
		</div>
		<div class="selectbody4">
			<a href="/OA/admin/items/addItem.jsp" class="btn btn-primary"><font color="white">&nbsp;&nbsp;&nbsp;添加+&nbsp;&nbsp;&nbsp;</font></a>
		</div>
		</form:form>
		
	</div>
	
		<c:choose>
		    	<c:when test="${empty Itemlist.list}">
		    	<div>
		    		<h2>没有找到类似的题目....<a href="/OA/findAllItem">查看全部题目</a></h2>
		    	</div>
		    	</c:when>
		  <c:otherwise>
	<div class="body">
		<table class="table table-striped">
		<tr>
			<th>题目</th>
			<th>选项A</th>
			<th>选项B</th>
			<th>选项C</th>
			<th>选项D</th>
			<th>答案</th>
			<th>类型</th>
			<th>操作</th>
		</tr>

		<c:forEach var="ite" items="${Itemlist.list }">
		<!-- 情景颜色 -->
		
		<tr class="active" id="${ite.iid}">
			<td class="success">${ite.topic }</td>
			<td class="info">${ite.optionA }</td>
			<td class="warning">${ite.optionB }</td>
			<td class="danger">${ite.optionC }</td>
			<td class="success ">${ite.optionD }</td>
			<td class="info ">${ite.answer }</td>
			<td class="warning ">${ite.types.typeName }</td>
			<td class="danger ">
			<div class="opration">
				<select id="selectId${ite.iid}" class="form-control" onchange="change(${ite.iid})">
				<option disabled="disabled" selected="selected">-请选择-</option>
				<option value=1>修改</option>
				<option value=2>删除</option>
			</select>
			</div>
			</td>
		</tr>

		</c:forEach>
	</table>

<div class="page">


		 <div class="person-bottom" style="padding-top: 10px; float: right;">
				    <button class="btn btn-default" onclick="gotoPage(${Itemlist.previousPage})">&lt;&nbsp;上一页</button>
             			<c:forEach items="${Itemlist.pageBar}" var="pageNum">
				        <button  class="btn btn-default" onclick="gotoPage(${pageNum})">
						<c:if test="${Itemlist.currentPage ==  pageNum}">
							<font color="red">${Itemlist.currentPage}</font>
						</c:if>
						<c:if test="${Itemlist.currentPage ne  pageNum}">
							${pageNum}
						</c:if>
						</button>
						</c:forEach>
                     <button class="btn btn-default" onclick="gotoPage(${Itemlist.nextPage})">下一页&nbsp;&gt;</button>
                     <span class='bottom-txt' style=''>共${Itemlist.totalPage}页  共${Itemlist.totalRecord}条记录</span>
                    <span class="bottom-txt">到第<input type="text" value="${Itemlist.currentPage}" id="currentPage"style="width: 40px; height: 35px; text-align: center;">页</span>
                    <button class="btn btn-default" onclick='gotoPage(document.getElementById("currentPage").value)'>确定</button>
                </div>
	</div>
	</div>
	</c:otherwise>
	</c:choose>

</body>

<script type="text/javascript">
	function change(id){
		var value = $('#selectId'+id).children("option:selected").val();
		if(value==1){
			window.location.href="/OA/findAItem?iid="+id;
		}
		else{
			if(confirm("确定要删除该商品？")){
				 $.ajax({
						url:"deleteItem?iid="+id,
						type:'GET',
						dataType:'text',
						success:function(map1){
							$("#"+id).remove();
						}
					});
			}	
		}
	}
	
	function additem(){
		window.location.href="/OA/addItem.jsp";
	}
	
	function gotoPage(currentPage){
		window.location.href="/OA/findItemByCondition?currentPage=" + currentPage;
	}
	
</script>
 
</html>
