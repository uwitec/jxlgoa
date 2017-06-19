<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


		<div class="panel panel-default col-lg-6" style="margin-left: 150px">
		    <div class="panel-heading">
		        <h3 class="panel-title">添加班主任页面</h3>
		    </div>
		<form action="${pageContext.request.contextPath}/adviser/addAdviser" method="post" onsubmit="return check()">  
		    <table class="table">
		       <tr>
    				<td>班主任姓名：</td>
    				<td><input type="text" name="adviserName" id="adviserName" class="form-control "></td>
    			</tr>
    			
    			<tr>
    				<td>入职时间</td>
    				<td><input type="text" class="form-control" id="entryTime" name="entryTime" id="entryTime" readonly onClick="showCalendar(this.id)"/></td>
    			</tr>
    			<tr>
    				<td>工作经验（年）</td>
    				<td>
    					<select name="workExperience" id="workExperience" class="form-control">
  							<option value="">请选择</option>
  							<option value="0">0</option>
  							<option value="1">1</option>
  							<option value="2">2</option>
  							<option value="3">3</option>
  							<option value="4">4</option>
  							<option value="5">5</option>
  							<option value="6">6</option>
  							<option value="7">7</option>
  							<option value="8">8</option>
  							<option value="9">9</option>
  							<option value="10">10</option>
  							<option value="11">11</option>
  							<option value="12">12</option>
  							<option value="13">13</option>
  							<option value="14">14</option>
  							<option value="15">15</option>
  							<option value="16">16</option>
  							<option value="17">17</option>
  							<option value="18">18</option>
  							<option value="19">19</option>
  							<option value="20">20</option>
  						</select>
    				</td>
    			</tr>
    			<tr>
    				<td>状态</td>
    				<td>
    					<select name="selectStatus" id="selectStatus" class="form-control">
  							<option value="">请选择</option>
  							<option value="在职">在职</option>
  							<option value="离职">离职</option>
  						</select>
    				</td>
    			</tr>
    			
    			
    			<tr>
    				<td></td>
    				<td><input type="submit" class="btn btn-default" value="提交"></td>
    				<td><input type="reset" class="btn btn-default" value="重置"></td>
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
