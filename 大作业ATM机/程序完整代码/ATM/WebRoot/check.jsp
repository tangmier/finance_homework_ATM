<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>查询余额</title>
<style type="text/css">
<!--
.STYLE1 {font-size: xx-large}
.STYLE2 {font-size: x-large}
.STYLE3 {font-size: large; }
.STYLE4 {
	color: #FFFFFF;
	font-weight: bold;
}
.STYLE5 {
	font-size: x-large;
	color: #FFFFFF;
	font-weight: bold;
}
.STYLE7 {
	font-size: large;
	color: #FFFFFF;
	font-weight: bold;
}
.STYLE8 {
	font-size: xx-large;
	color: #FFFFFF;
	font-weight: bold;
}
-->
</style>
</head>

<body>
<table width="60%" border="0" cols="" bgcolor="#3787C1" align="center">
  <tr>
    <td height="41"><div align="center" class="STYLE8">华南学生银行</div></td>
  </tr>
  <tr>
    <td height="41"><div align="right" class="STYLE3 STYLE4">报警电话：110</div></td>
  </tr>
  <tr>
    <td height="85"><div align="center" class="STYLE4">
      <p class="STYLE1">你好！你的账户里可使用金额为</p>
      </div></td>
  </tr>
  <tr>
    <td height="76">
      <div align="center">
        <p class="STYLE8"><s:property value="#request.number"/></p>
      </div>
    </td>
  </tr>
  <tr>
    <td height="70"><div align="center" class="STYLE5"></div></td>
  </tr>
  <tr>
    <td height="70">
      <div align="center" class="STYLE2">
        <p>
          <input name="Submit" type="button" class="STYLE2" value="返回" onclick="window.location.href='funtion.jsp'"/>
        </p>
      </div>
    </td>
  </tr>
  <tr>
    <td height="147"><div align="left"><span class="STYLE7">系统服务热线：000-000-000</span></div></td>
  </tr>
</table>
</body>
</html>