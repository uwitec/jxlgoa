<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- 分页显示所有的讲师信息 -->


<form action="${pageContext.request.contextPath}/admin/searchTrainerByPage" method="post" >

		<div style="width:800px;margin-top: 20px;margin-left: 30px" >
			 <div class="input-group col-lg-2 " style="float:left" >
			 	<span class="input-group-addon">姓名</span>
	            <input type="text" class="form-control" name="trainerName">
			 </div>
			 <div style="float:left">
			 	<span style="font-size: 18px;margin-left: 9px;text-align: center;">类型</span>
			 </div>
			<div class="form-group col-lg-2" style="float:left">
				<select class="form-control col-lg-2" name="selectType"> 
					
				     <option value="">请选择</option>
					<c:forEach items="${listType}" var="type">
						<option  value="${type.id}">${type.typeName }</option>
					</c:forEach>
	     		 </select>
			</div>
			<div  style="float:left">
				入职时间：<input type="text" size="9" name="entryTime" id="entryTime" readonly onClick="showCalendar(this.id)"/>
			</div>
			
			<div style="float:left">
			 	<span style="font-size: 18px;margin-left: 9px;text-align: center;">状态</span>
			 </div>
			<div class="form-group col-lg-2" style="float:left">
				<select  class="form-control col-lg-2" name="selectStatus">
						<option value="">请选择</option>
						<option value="结课">结课</option>
						<option value="授课中">授课中</option>
						<option value="离职">离职</option>
  					</select>
			</div>
			
			<div style="float:left">
				<button type="submit" class="btn btn-success">搜索</button>
			</div>
			<div style="float:right">
				<a href="${pageContext.request.contextPath}/admin/addTrainerPre" class="btn btn-success">添加</a>
			</div>
		</div>
  		
</form>
<div style="width:800px;margin-left: 30px;margin-top: 20px">
	<table style="height: 50px;text-align: center" class="table table-bordered  col-lg-2" >
    		
    		<thead>
    			<tr>
				<td >
					<strong>姓名</strong>
				</td>
				<td >
					<strong>类型</strong>
				</td>
				<td >
					<strong>入职时间</strong>
				</td>
				<td >
					<strong>工作经验</strong>
				</td>
				<td >
					<strong>状态</strong>
				</td>
				<td >
					<strong>选择</strong>
				</td>
				<td >
					<strong>操作</strong>
				</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${pageBean.list}" var="trainer">
				<tr>
					<td>${trainer.trainerName}</td>
					<td>${trainer.types.typeName }</td>
					<td>${trainer.entryTime }</td>
					<td>${trainer.workExperience }</td>
					<td id="${trainer.tid }">${trainer.status }</td>
					<td>
						<select  id="type" onchange="doSelect(${trainer.tid}, this)">
							<option value="0">请选择</option>
							<option value="结课">结课</option>
							<option value="离职">离职</option>
						</select>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/admin/updateTrainerPre?id=${trainer.tid}" class="btn btn-default">修改</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
    	</table>
 </div>
 
 <div style="width:800px;margin-left: 30px;margin-top: 30px;text-align: center;">
 	<div class="person-bottom" style="padding-top: 50px; float: right;" >
	<p >
		<span> 共${pageBean.totalPage}页</span>  
  		<a class="btn btn-default" href="javascript:void(0)" onclick="gotoPage(${pageBean.previousPage})">上一页</a>
  		
  		<c:forEach items="${pageBean.pageBar }" var="pageNum">
  			<a class="btn btn-default" href="javascript:void(0)" onclick="gotoPage(${pageNum})">
		<c:if test="${pageBean.currentPage ==pageNum}">
			<font >${pageBean.currentPage}</font>
		</c:if>
		<c:if test="${pageBean.currentPage ne pageNum}">
			${pageNum}
		</c:if>
	</a>
  		</c:forEach>
  		<a class="btn btn-default" href="javascript:void(0)" onclick="gotoPage(${pageBean.nextPage})">下一页</a>
  		转到第<input type="text"  id = "willPage" value ="${pageBean.currentPage }" style="width: 30px">页
  		   <input type="button" class="btn btn-default"  value="GO" onclick='gotoPage(document.getElementById("willPage").value)' />
  		共${pageBean.totalRecord}条记录
  	 </p>
    </div>
 </div>

 <script type="text/javascript">
	 
	 	function gotoPage(currentPage){
	 		if(parseInt(currentPage) !=currentPage){
	 			alert("输入不符合规范,请重新输入有效的数字");
	 			document.getElementById("willPage").value = "";
	 			return;
	 		}
	 		//2：验证val在一个合法的范围内 ：1 - totalPage
			var pageNo = parseInt(currentPage);
			if(pageNo<1 || pageNo>parseInt("${pageBean.totalPage}")){
				alert("输入的是不合法的页码");
				document.getElementById("willPage").value = "";
				return;
			};
  			window.location.href="${pageContext.request.contextPath }/admin/getTrainerByPage?currentPage="+currentPage;
  		};
  </script>
  <script type="text/javascript">
  		function doSelect(tid, selectObj){
  			var value = selectObj.value;
  			var id = tid;
  			console.log(value);
  			if(value=="结课" || value=="离职"){
  				var url = "${pageContext.request.contextPath}/admin/updateStatu";
  				var args = {"id":id,"value":value,"time":new Date()};
	  			$.ajax({   //json对象
						url: url,
						data: args,
						dataType: "json",
						type: "post",
						success: successful,
						async: true,
						cache: false
					});
				  function successful(data){
				  	console.log(data);
					document.getElementById(data.tid).innerHTML = data.status;
				 }
  			}else{
  				return false;
  			}
  		}
  </script>
