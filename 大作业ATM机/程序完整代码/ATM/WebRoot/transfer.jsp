<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>转账</title>
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
.STYLE9 {
	color: #FFFFFF;
	font-size: x-large;
}
.STYLE13 {color: #CC0000; font-size: x-large; }
-->
</style>
</head>

<body>
<table width="60%" border="0" cols="" bgcolor="#3787C1" align="center">
  <tr>
    <td height="41" colspan="2"><div align="center" class="STYLE8">华南学生银行</div></td>
  </tr>
  <tr>
    <td height="41" colspan="2"><div align="right" class="STYLE3 STYLE4">报警电话：110</div></td>
  </tr>
  <tr>
    <td height="85" colspan="2"><div align="center" class="STYLE4">
      <p class="STYLE1">你好！请选择需要的服务</p>
      <p class="STYLE2">&nbsp;</p>
    </div></td>
  </tr>
  <tr>
    <td height="76">
      <div align="justify">
        <input name="Submit5" type="button" class="STYLE2" value="行内转账" onclick="window.location.href='hnTransfer.jsp'"/>
      </div>
    </td>
    <td><div align="right">
      
        <input name="Submit2" type="button" class="STYLE2" value="跨行转账" onclick="window.location.href='khTransfer.jsp'"/>
      
      </div></td>
  </tr>
  <tr>
    <td height="70"><div align="center" class="STYLE5">
      <form id="form5" name="form5" method="post" action="">
        <div align="left"></div>
      </form>
      </div></td>
    <td height="70"><div align="right"></div></td>
  </tr>
  <tr>
    <td height="77"><div align="left"></div></td>
    <td height="77">
      <div align="right">
        <input name="Submit6" type="button" class="STYLE13" value="返回" onclick="window.location.href='funtion.jsp'"/>
        </div>
    </td>
  </tr>
  <tr>
    <td height="147" colspan="2"><div align="left"><span class="STYLE7">系统服务热线：000-000-000</span></div></td>
  </tr>
</table>
</body>
</html>
