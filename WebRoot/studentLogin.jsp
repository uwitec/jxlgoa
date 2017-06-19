<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>OA系统（学生）登录页面</title>
    <style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
		background-color: #1D3647;
	}
	.STYLE1 {color: #E6EBF1}
	-->
	</style>
	<link href="teacher/images/skin.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
	  <table width="100%" height="166" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td height="42" valign="top"><table width="100%" height="42" border="0" cellpadding="0" cellspacing="0" class="login_top_bg">
	      <tr>
	        <td width="1%" height="21">&nbsp;</td>
	        <td height="42">&nbsp;</td>
	        <td width="17%">&nbsp;</td>
	      </tr>
	    </table></td>
	  </tr>
	  <tr>
	    <td valign="top"><table width="100%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg">
	      <tr>
	        <td width="49%" align="right"><table width="91%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg2">
	            <tr>
	              <td height="138" valign="top"><table width="89%" height="427" border="0" cellpadding="0" cellspacing="0">
	                <tr>
	                  <td height="149">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td height="80" align="right" valign="top">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td height="198" align="right" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
	                    <tr>
	                      <td width="35%">&nbsp;</td>
	                      <td width="65%" height="25" class="left_txt"><p>1- 教师录入考试题目以及答案信息</p></td>
	                    </tr>
	                    <tr>
	                      <td>&nbsp;</td>
	                      <td height="25" class="left_txt"><p>2- 学生参加考试并自动评分和查看正确答案</p></td>
	                    </tr>
	                    <tr>
	                      <td>&nbsp;</td>
	                      <td height="25" class="left_txt"><p>3- 教师查看学生考试成绩</p></td>
	                    </tr>
	                  </table></td>
	                </tr>
	              </table></td>
	            </tr>
	            
	        </table></td>
	        <td width="1%" >&nbsp;</td>
	        <td width="50%" valign="bottom"><table width="100%" height="59" border="0" align="center" cellpadding="0" cellspacing="0">
	            <tr>
	              <td width="4%">&nbsp;</td>
	              <td width="96%" height="38"><span class="login_txt_bt">OA系统-（学生登录）</span></td>
	            </tr>
	            <tr>
	              <td>&nbsp;</td>
	              <td height="21"><table cellSpacing="0" cellPadding="0" width="100%" border="0" id="table211" height="328">
	                  <tr>
	                    <td height="164" colspan="2" align="middle">
	                    <jsp:useBean id="studentLoginBean" class="com.wuxianedu.domain.StudentLoginBean" scope="request"></jsp:useBean>
							<form:form modelAttribute="studentLoginBean" action="studentLogin" method="POST">
	                        <table cellSpacing="0" cellPadding="0" width="100%" border="0" height="143" id="table212">
	                          <tr>
	                          	
	                          </tr>
	                          <tr>
	                            <td width="14%" height="38" class="top_hui_text"><span class="login_txt">账号：&nbsp;&nbsp; </span></td>
	                            <td height="38" colspan="2" class="top_hui_text"><form:input path="phone" cssClass="editbox4"/>
	                            <font color="red"> <form:errors path="phone"/> </font>                            </td>
	                          </tr>
	                          <tr>
	                            <td width="14%" height="35" class="top_hui_text"><span class="login_txt"> 密 码： &nbsp;&nbsp; </span></td>
	                            <td height="35" colspan="2" class="top_hui_text"><form:input path="password" cssClass="editbox4"/>
	                              <img src="teacher/images/luck.gif" width="19" height="18"><font color="red"> <form:errors path="password"/></font> </td>
	                          </tr>
	                          <tr>
	                            <td width="14%" height="35" ><span class="login_txt"></span></td>
	                            <td height="35" colspan="2" class="login_txt"></td>
	                          </tr>
	                          <tr>
	                            <td height="35" >&nbsp;</td>
	                            <td width="19%" height="35" ><input name="Submit" type="submit" class="button" id="Submit" value="登 录"> </td>
	                            <td width="67%" class="top_hui_text"><input name="cs" type="button" class="button" id="cs" value="取 消" onClick="showConfirmMsg1()"></td>
	                          </tr>
	                        </table>
	                        <br>
	                    </form:form></td>
	                  </tr>
	                  <tr>
	                    <td width="433" height="164" align="right" valign="bottom"><img src="teacher/images/login-wel.gif" width="242" height="138"></td>
	                    <td width="57" align="right" valign="bottom">&nbsp;</td>
	                  </tr>
	              </table></td>
	            </tr>
	          </table>
	          </td>
	      </tr>
	    </table></td>
	  </tr>
	  <tr>
	    <td height="20"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="login-buttom-bg">
	      <tr>
	        <td align="center"><span class="login-buttom-txt STYLE1">OASYSTEM &copy; 2016 </span></td>
	      </tr>
	    </table></td>
	  </tr>
	</table>
  </body>
</html>