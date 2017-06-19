<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


        
    	<form action="${pageContext.request.contextPath}/admin/updateTrainer" method="post" onsubmit="return check()">
    	<div class="panel panel-default col-lg-6" style="margin-left: 150px">
    		 <div class="panel-heading">
		        <h3 class="panel-title">更新讲师页面</h3>
		    </div>
    
    		<table  style="height: 50px"  class="table table-bordered" >
    			
    			<tr>
    				<td>讲师姓名：</td>
    				<td><input type="text" name="trainerName" class="form-control" value="${trainer.trainerName}">
    					<input type="hidden" name="tid"  value="${trainer.tid}">
    				</td>
    			</tr>
    			<tr>
    				<td>类型</td>
    				<td>
    					<select name="selectType" class="form-control">
  							<!-- <option value="">请选择</option> -->
  							<c:forEach items="${listType}" var="type">
	  							<option  value="${type.id}" laceholder="请选择" >${type.typeName }</option>
  							</c:forEach>
  						</select>
    				</td>
    			</tr>
    			<tr>
    				<td>入职时间</td>
    				<td><input type="text"  class="form-control" size="9" name="entryTime" id="entryTime" value="${trainer.entryTime }" readonly onClick="showCalendar(this.id)"/></td>
    			</tr>
    			<tr>
    				<td>工作经验（年）</td>
    				<td><input type="text" class="form-control" name="workExperience" value="${trainer.workExperience }" size="3" ></td>
    			</tr>
    			<tr>
    				<td>状态</td>
    				<td>
    					<select name="selectStatus" class="form-control" >
  							<option value="${trainer.status}" placeholder="请选择" >${trainer.status}</option>
  							<option value="未授课">未授课</option>
  							<option value="授课中">授课中</option>
  							<option value="离职">离职</option>
  						</select>
    				</td>
    			</tr>
    			
    			<tr>
    				<td></td>
    				<td><input type="submit" class="form-control" value="提交"></td>
    			</tr>
    		</table>
    
    </div>
    	</form>
    	
   <script type="text/javascript">
		function check(){
			var trainerName = document.getElementById("trainerName").value;
			var selectType = document.getElementById("selectType").value;
			var entryTime = document.getElementById("entryTime").value;
			var workExperience = document.getElementById("workExperience").value;
			var selectStatus = document.getElementById("selectStatus").value;
			console.log(trainerName+";"+selectType+";"+entryTime+";"+selectStatus);
			if(trainerName==null ||trainerName==""){
				alert("输入不能为空");
				return false;
			}
			if(entryTime==null ||entryTime==""){
				alert("请选择入职时间");
				return false;
			}
			if(workExperience==null ||workExperience==""){
				alert("请选择工作经验");
				return false;
			}
			if(selectStatus==null ||selectStatus==""){
				alert("请输入工作状态");
				return false;
			}
			
		};
</script>
   