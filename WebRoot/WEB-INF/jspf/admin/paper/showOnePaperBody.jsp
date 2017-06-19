<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<table width="1003" height="485" border="0" cellpadding="0" cellspacing="0" class="centerbg">
  <tr>
    <td width="149" height="485">&nbsp;</td>
    <td width="741" valign="top" class="rightbian">
    <jsp:useBean id="paper" class="com.wuxianedu.domain.Paper" scope="request"></jsp:useBean>
	<form:form modelAttribute="paper" action="javascript:void(0)" method="post">
		<form:hidden path="pid" />
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="10">
      <tr>
        <td><div align="center" class="STYLE3">考试时间：120 分钟</div></td>
        <td><div align="center" class="STYLE3">考生：</div></td>
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
      <%
      	Integer i = 0;
      	pageContext.setAttribute("num", i);
      %>
      <c:forEach items="${paper.setItem}" var="item">
	  <!--题目开始-->
	  <%
	  	i = (Integer)pageContext.getAttribute("num");
	  	i++;
	  	pageContext.setAttribute("num", i);
	  %>
	  <tr>
        <td colspan="3"><strong>第<span class="STYLE5">${num}</span>题&nbsp;${item.topic}</strong></td>
      </tr>
      <tr>
        <td colspan="3"><strong>A．</strong>${item.optionA}</td>
      </tr>
      <tr>
        <td colspan="3"><strong>B．</strong>${item.optionB}</td>
      </tr>
      <tr>
        <td colspan="3"><strong>C．</strong>${item.optionC}</td>
      </tr>
      <tr>
        <td colspan="3"><strong>D．</strong>${item.optionD}</td>
      </tr>
      <tr>
        <td height="32" colspan="3" bgcolor="#CCCCCC">选择答案：
          <input type="radio" name="subjectAnswer${item.iid}" value="A" checked="checked"/>
          A
          <input type="radio" name="subjectAnswer${item.iid}" value="B" />
          B
          <input type="radio" name="subjectAnswer${item.iid}" value="C" />
          C
          <input type="radio" name="subjectAnswer${item.iid}" value="D" />
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
     </form:form>
    </td>
    <td width="113">&nbsp;</td>
  </tr>
</table>

