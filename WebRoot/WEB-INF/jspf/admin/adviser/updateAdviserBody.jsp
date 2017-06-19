<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<center><h3>更新班主任页面</h3></center>
	<div class="panel panel-default col-lg-6" style="margin-left: 220px">
			<div class="panel-heading">
		        <h3 class="panel-title">更新讲师页面</h3>
		    </div>
    	<form action="${pageContext.request.contextPath}/adviser/updateAdviser" method="post" onsubmit="return check()">
    	
    		<table  style="height: 50px"  class="table table-bordered" >
    			
    			<tr>
    				<td>班主任姓名：</td>
    				<td><input type="text" name="adviserName"  class="form-control" value="${adviser.adviserName}">
    					<input type="hidden" name="aid" value="${adviser.aid}">
    				</td>
    			</tr>
    			
    			<tr>
    				<td>入职时间</td>
    				<td><input type="text" size="9"  class="form-control" name="entryTime" id="entryTime" value="${adviser.entryTime }" readonly onClick="showCalendar(this.id)"/></td>
    			</tr>
    			<tr>
    				<td>工作经验（年）</td>
    				<td><input type="text" name="workExperience"  class="form-control" value="${adviser.workExperience }" size="3" ></td>
    			</tr>
    			<tr>
    				<td>状态</td>
    				<td>
    					<select name="selectStatus" class="form-control">
  							<option value="请选择" >请选择</option>
  							<option value="在职">在职</option>
  							<option value="离职">离职</option>
  						</select>
    				</td>
    			</tr>
    			
    			<tr>
    				<td></td>
    				<td><input type="submit" value="提交"></td>
    			</tr>
    		</table>
    	</form>
   </div>
   
   
    <script type="text/javascript">
		function check(){
			var adviserName = document.getElementById("adviserName").value;
			var entryTime = document.getElementById("entryTime").value;
			var workExperience = document.getElementById("workExperience").value;
			var selectStatus = document.getElementById("selectStatus").value;
			console.log(adviserName+";"+entryTime+";"+workExperience+";"+selectStatus);
			if(adviserName==null ||adviserName==""){
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
   