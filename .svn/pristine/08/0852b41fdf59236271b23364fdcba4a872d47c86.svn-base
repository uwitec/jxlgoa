<%@page import="com.wuxianedu.domain.Types"%>
<%@page import="com.wuxianedu.service.GetTypesService"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.wuxianedu.domain.Paper"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<div class="header">
		<font size="5px">试卷管理</font>

	</div>
	<jsp:useBean id="paperCondition" class="com.wuxianedu.domain.PaperCondition" scope="request"></jsp:useBean>
	<form:form modelAttribute="paperCondition" action="paper/findPaperByNameOrTypes" method="POST">
		<div class="select">
			<div class="selecttext">
				<h5><font size="4px">按条件查找：</font></h5>
			</div>
			<%AbstractApplicationContext context =  (AbstractApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
			GetTypesService leagueSvc = (GetTypesService)context.getBean("getTypesService");
			List<Types> list=leagueSvc.getTypesAll();
			pageContext.setAttribute("types", list);
			%>
			<div class="selectbody1">
				类型：
				<select name="typeName" class="form-control" value="">
					<option disabled="disabled" selected="selected">-请选择-</option>
					<c:forEach var="typ" items="${types }">
						<option value="${typ.typeName}" ${paperCondition.typeName == typ.typeName ? "selected" : "" } >${typ.typeName }</option>
					</c:forEach>
				</select>
			</div>
			<div class="selectbody2">
				试卷名称： <form:input path="paperName" class="form-control" />
			</div>
			<form:errors>paperName</form:errors>
			<div class="selectbody3">
				<input type="submit" class="btn btn-success" value="&nbsp;&nbsp;&nbsp;搜索&nbsp;&nbsp;&nbsp;" />
			</div>
			<div class="selectbody4">
				<a href="/OA/admin/paper/createPaper.jsp" class="btn btn-primary"><font color="white">&nbsp;&nbsp;&nbsp;添加+&nbsp;&nbsp;&nbsp;</font></a>
			</div>
		</div>
	</form:form>

	<div class="body">
		<c:if test="${not empty paperPageBeanByCondition.list}">
			<table class="table table-striped">
				<tr>
					<th>名称</th>
					<th>类型</th>
					<th>试题数量</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${paperPageBeanByCondition.list}" var="paper">
					<!-- 情景颜色 -->
					<tr class="active" id="${paper.pid}">
						<td class="success ">${paper.paperName }</td>
						<td class="info">${paper.types.typeName }</td>
						<td class="warning">${paper.questionNumber }</td>
						<td class="danger"><fmt:formatDate value="${paper.createTime }" type="Date" pattern="yyyy-MM-dd hh:mm" /></td>
						<td>
							<div class="opration">
								<select id="selectId${paper.pid}" class="form-control" onchange="change(${paper.pid})">
									<option disabled="disabled" selected="selected" >-操作-</option>
									<option value="1" >预览</option>
									<option value="2" >修改</option>
									<option value="3" >删除</option>
								</select>
							</div>
						</td>
					</tr>
				</c:forEach>	
			</table>
		</c:if>
		<c:if test="${empty paperPageBeanByCondition.list }">
			<h2 align="center">没有试卷</h2>
		</c:if>
	</div>
	<div class="page">
		 <div class="person-bottom" style="padding-top: 10px; float: right;">
		    <button class="btn btn-default" onclick="gotoPage(${paperPageBeanByCondition.previousPage})">&lt;&nbsp;上一页</button>
       		<c:forEach items="${paperPageBeanByCondition.pageBar}" var="pageNum">
			    <button  class="btn btn-default" onclick="gotoPage(${pageNum})">
					<c:if test="${paperPageBeanByCondition.currentPage ==  pageNum}">
						<font color="red">${paperPageBeanByCondition.currentPage}</font>
					</c:if>
					<c:if test="${paperPageBeanByCondition.currentPage ne  pageNum}">
						${pageNum}
					</c:if>
				</button>
			</c:forEach>
           <button class="btn btn-default" onclick="gotoPage(${paperPageBeanByCondition.nextPage})">下一页&nbsp;&gt;</button>
				<span class='bottom-txt' style=''>共${paperPageBeanByCondition.totalPage}页  共${paperPageBeanByCondition.totalRecord}条记录</span>
				<span class="bottom-txt">到第<input type="text" value="${paperPageBeanByCondition.currentPage}" id="currentPage" style="width: 40px; height: 35px; text-align: center;">页</span>
           <button class="btn btn-default" onclick='gotoPage(document.getElementById("currentPage").value)'>确定</button>
        </div>
	</div>
<script type="text/javascript">

	function change(id){
		var value = $('#selectId'+id).children("option:selected").val();
		if(value==1){
			window.location.href="/OA/paper/findPaperAndItem?pid="+id;
		}
		else if(value==2){
			window.location.href="/OA/paper/findPaperById?pid="+id;
		}
		else{
			if(confirm("确定要删除该商品？")){
				 $.ajax({
					url:"paper/deletePaper?pid="+id,
					type:'GET',
					dataType:'text',
					success:function(map1){
						if("success" == map1){
							$("#"+id).remove();
						}else{
						}
						alert(map1);
					}
				});
			}
		}
	}
	
	function gotoPage(currentPage){
		if(parseInt(currentPage) !=currentPage){
 			alert("输入不符合规范,请重新输入有效的数字");
 			return;
 		}
		window.location.href="/OA/paper/findPaperByNameOrTypes?currentPage=" + currentPage;
	}
</script>
