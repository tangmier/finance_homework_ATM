<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>行内转账</title>
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
<form id="form1" name="form1" method="post" action="hnTransfer.action">
<table width="60%" border="0" cols="" bgcolor="#3787C1" align="center">
  <tr>
    <td height="41" colspan="2"><div align="center" class="STYLE8">华南学生银行</div></td>
  </tr>
  <tr>
    <td height="41" colspan="2"><div align="right" class="STYLE3 STYLE4">报警电话：110</div></td>
  </tr>
  <tr>
    <td height="85" colspan="2"><div align="center" class="STYLE4">
      <p class="STYLE1">请输入转入账号和金额，核对无误后按确定</p>
      </div></td>
  </tr>
  <tr>
    <td height="76" colspan="2">
      <div align="center">
        <span class="STYLE8">转入账号</span>
        <input name="otherCardID" type="text" class="STYLE1" value="" />
      </div>    </td>
  </tr>
  <tr>
    <td height="70" colspan="2"><div align="center" class="STYLE5"></div></td>
  </tr>
  <tr>
    <td height="70" colspan="2"><div align="center" class="STYLE5">
      <span class="STYLE8">转入金额</span>
      <input name="number" type="text" class="STYLE1" value="" />
    </div></td>
  </tr>
  <tr>
    <td height="70" align="left"><input name="button" type="button" class="STYLE2" value="返回" onclick="window.location.href='transfer.jsp'"/></td>
    <td align="right"><input name="Submit2" type="submit" class="STYLE2" value="确定" /></td>
  </tr>
  <tr>
    <td height="147" colspan="2"><div align="left"><span class="STYLE7">系统服务热线：000-000-000</span></div></td>
  </tr>
</table>

</form>
</body>
</html>
