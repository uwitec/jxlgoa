<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8"%> 
<%@ page import="java.text.*"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
Date datetime=new Date();
pageContext.setAttribute("date", datetime);
%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>开始考试</title>
<link href="student/images/css2.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="teacher/js/jquery.js"></script>
<style type="text/css">
<!--
.STYLE3 {font-size: 18px; }
.STYLE4 {font-size: 18px; font-weight: bold; }
.STYLE5 {color: #FF0000}
-->
</style>


</head>

<body onload="timeget(${begintime})" id="bodyid">
<table width="1003" height="485" border="0" cellpadding="0" cellspacing="0" class="centerbg">
  <tr>
    <td width="149" height="485">&nbsp;</td>
    <td width="741" valign="top" class="rightbian">
	<form action="examResult" method="POST">
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="10">
      <tr>
        <td><div align="center" class="STYLE3">考试时间：120 分钟</div></td>
        <td><div align="center" class="STYLE3">考生：${studentInfo.studentName}</div></td>
        <td><div align="center" class="STYLE3">总分 ：100 分</div></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><div id="tTime"></div></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td colspan="3" bgcolor="#999999" class="STYLE4">选择题(每小题5分，共20个)</td>
      </tr>
	  <!--题目开始-->
	 <c:forEach var="items" items="${examingPaper }">
	  <tr>
        <td colspan="3"><strong>第<span class="STYLE5">1</span>题&nbsp;${items.item.topic}</strong>		</td>
      </tr>
      <tr>
        <td colspan="3"><strong>A．</strong>${items.item.optionA}</td>
      </tr>
      <tr>
        <td colspan="3"><strong>B．</strong>${items.item.optionB}</td>
      </tr>
      <tr>
        <td colspan="3"><strong>C．</strong>${items.item.optionC}</td>
      </tr>
      <tr>
        <td colspan="3"><strong>D．</strong>${items.item.optionD}</td>
      </tr>
      <tr>
        <td height="32" colspan="3" bgcolor="#CCCCCC">选择答案：
          <input type="radio" name="answer${items.id }" value="A" />
          A
          <input type="radio" name="answer${items.id }" value="B" />
          B
          <input type="radio" name="answer${items.id }" value="C" />
          C
          <input type="radio" name="answer${items.id }" value="D" />
          D</td>
      </tr>
	   <!--题目结束-->
	   </c:forEach>
      <tr>
        <td colspan="3"><div align="center">
          <input type="submit" value=" 提交答卷 " name="Submit" />
        </div></td>
      </tr>
      
      
    </table>
    </form>
    </td>
    <td width="113">&nbsp;</td>
  </tr>
</table>
</body>

<script type="text/javascript">

var time1=<%=System.currentTimeMillis()%>;
var begintimew;
var tt;

function timeget(begintime){
	begintimew=begintime;
	time1=parseInt(time1)-parseInt(begintime);
	tt=(-parseInt(time1/1000));
	
}

window.setInterval("getState()", 1000*60*5);
function getState(){
	$.ajax({  //json对象
		url:"/OA/getNowtime",
		type:"get",
		dataType:"html",
		cache: false,
		success: function(msg){
			time1=parseInt(msg)-parseInt(begintime);
			tt=(-parseInt(time1/1000));
		}
	});
}


function show()  //显示隐藏层和弹出层
{

   document.getElementById("bodyid").style.display="block";  //显示弹出层
}

function hide()  //去除隐藏层和弹出层
{
   document.getElementById("bodyid").style.display="none";
}

xx=1;
yy=1;
function time(){
	if(time1<0){
		tt=tt-1;
		hide();
		
		if(xx==1){
			alert("未到考试时间，请稍后！还差"+tt);
			xx++;
		}
		
	}else{
		show();
	}
	
		time1=time1+1000;
		time2=1000*120*60-time1;
		kf=parseInt(time2/(60*1000));
		km=parseInt((time2%(60*1000))/1000);
		sf=119-kf;
		sm=60-km;
		document.getElementById("tTime").innerHTML = "考试已经开始了" +  sf+ "分" +sm + "秒" + ",剩余"  + kf + "分" + km + "秒";
	 if(time2<60){
		 if(yy==1){
			 alert("离考试结束还有60秒，请准备交卷！");
			 yy++;
		 }

		 }
	if(time2==0){
		alert("考试时间到!\n即将提交试卷!");
		document.forms[0].submit();
	}
	}
	window.setInterval("time()", 1000);
 </script>
</html>