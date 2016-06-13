<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>用户登录</title>
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
<form id="form1" name="form1" method="post" action="login.action">
<table width="60%" border="0" bgcolor="#3787C1" align="center">
  <tr>
    <td height="41"><div align="center" class="STYLE8">华南学生银行</div></td>
  </tr>
  <tr>
    <td height="41"><div align="right" class="STYLE3 STYLE4">报警电话：110</div></td>
  </tr>
  <tr>
    <td height="85"><div align="center" class="STYLE4">
      <p class="STYLE1">请输入密码</p>
      <p class="STYLE2">输入密码前，请确认周边安全</p>
    </div></td>
  </tr>
  <tr>
    <td height="76">
      <div align="center">
        <input name="passWord" type="password" class="STYLE1" />
      </div>
    </td>
  </tr>
  <tr>
    <td height="70"><div align="center" class="STYLE5">请插入银行卡：
        <input name="cardID" type="text" class="STYLE1" />
    </div></td>
  </tr>
  <tr>
    <td height="70">
      <div align="center" class="STYLE2">
        <p>
          <input type="submit" name="Submit" class="STYLE2" value="确认" />
          <input type="reset" name="reset" class="STYLE2" value="取消" />
        </p>
      </div>
    </td>
  </tr>
  <tr>
    <td height="147"><div align="left"><span class="STYLE7">系统服务热线：000-000-000</span></div></td>
  </tr>
</table>

</form>
</body>
</html>
