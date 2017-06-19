<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.wuxianedu.domain.Paper"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<div class="header">
		<font size="5px">考试管理</font>

	</div>
	<jsp:useBean id="examCondition" class="com.wuxianedu.domain.ExamCondition" scope="request"></jsp:useBean>
	<form:form modelAttribute="examCondition" action="exam/findExamByCondition" method="POST">
		<div class="select">
			<div class="selecttext">
				<h5><font size="4px">按条件查找：</font></h5>
			</div>
			<div class="selectbody1">
				班级名： <form:input path="className" class="form-control" />
			</div>
			<div class="selectbody2">
				考试名称： <form:input path="examName" class="form-control" />
			</div>
			<div class="selectbody3">
				<input type="submit" class="btn btn-success" value="&nbsp;&nbsp;&nbsp;搜索&nbsp;&nbsp;&nbsp;" />
			</div>
			<div class="selectbody4">
				<a href="/OA/admin/exam/createExam.jsp" class="btn btn-primary"><font color="white">&nbsp;&nbsp;&nbsp;添加+&nbsp;&nbsp;&nbsp;</font></a>
			</div>
		</div>
	</form:form>

	<div class="body">
		<c:if test="${not empty examPageBean.list}">
			<table class="table table-striped">
				<tr>
					<th>名称</th>
					<th>班级</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${examPageBean.list}" var="exam">
					<!-- 情景颜色 -->
					<tr class="active">
						<td class="success ">${exam.examName }</td>
						<td class="info">${exam.grade.className }</td>
						
						<td class="warning"><fmt:formatDate value="${exam.startTime }" type="Date" pattern="yyyy-MM-dd HH:mm" /></td>
						<td class="danger"><fmt:formatDate value="${exam.endTime }" type="Date" pattern="yyyy-MM-dd HH:mm" /></td>
						<td>
							<div class="opration">
								<select id="selectId${exam.eid}" class="form-control" onchange="change(${exam.eid})">
									<option disabled="disabled" selected="selected" >-操作-</option>
									<option value="1" >预览</option>
									<option value="2" >修改</option>
								</select>
							</div>
						</td>
					</tr>
				</c:forEach>	
			</table>
		</c:if>
		<c:if test="${empty examPageBean.list }">
			<h2 align="center">没有考试</h2>
		</c:if>
	</div>
	<div class="page">
		 <div class="person-bottom" style="padding-top: 10px; float: right;">
		    <button class="btn btn-default" onclick="gotoPage(${examPageBean.previousPage})">&lt;&nbsp;上一页</button>
       		<c:forEach items="${examPageBean.pageBar}" var="pageNum">
			    <button  class="btn btn-default" onclick="gotoPage(${pageNum})">
					<c:if test="${examPageBean.currentPage ==  pageNum}">
						<font color="red">${examPageBean.currentPage}</font>
					</c:if>
					<c:if test="${examPageBean.currentPage ne  pageNum}">
						${pageNum}
					</c:if>
				</button>
			</c:forEach>
           <button class="btn btn-default" onclick="gotoPage(${examPageBean.nextPage})">下一页&nbsp;&gt;</button>
				<span class='bottom-txt' style=''>共${examPageBean.totalPage}页  共${examPageBean.totalRecord}条记录</span>
				<span class="bottom-txt">到第<input type="text" value="${examPageBean.currentPage}" id="currentPage" style="width: 40px; height: 35px; text-align: center;">页</span>
           <button class="btn btn-default" onclick='gotoPage(document.getElementById("currentPage").value)'>确定</button>
        </div>
	</div>
<script type="text/javascript">

	function change(id){
		var value = $('#selectId'+id).children("option:selected").val();
		if(value==1){
			window.location.href="/OA/paper/findPaperAndItem?pid="+id;
		}
		if(value==2){
			window.location.href="/OA/exam/findExamByEid?eid="+id;
		}
	}
	
	function gotoPage(currentPage){
		if(parseInt(currentPage) !=currentPage){
 			alert("输入不符合规范,请重新输入有效的数字");
 			return;
 		}
		window.location.href="/OA/exam/findAllExam?currentPage=" + currentPage;
	}
</script>