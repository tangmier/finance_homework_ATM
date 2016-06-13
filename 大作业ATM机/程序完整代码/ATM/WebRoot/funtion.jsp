<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>功能选择</title>
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
      <form id="form1" name="form1" method="post" action="check.action">
        <input name="check" type="submit" class="STYLE2" value="查询" />
      </form>
      </div>
    </td>
    <td><div align="right">
        <input name="getMoney" type="button" class="STYLE2" value="取款" onclick="window.location.href='getMoney.jsp'"/>
      </div></td>
  </tr>
  <tr>
    <td height="70"><div align="center" class="STYLE5">
        <div align="left">
          <input name="Submit" type="button" class="STYLE2" value="转账" onclick="window.location.href='transfer.jsp'"/>
        </div>
      </div></td>
    <td height="70"><div align="right">
        <input name="putMoney" type="button" class="STYLE2" value="存款" onclick="window.location.href='putMoney.jsp'"/>
      </div></td>
  </tr>
  <tr>
    <td height="77"><div align="left"><span class="STYLE13">
      <input name="Submit4" type="button" class="STYLE2" value="修改密码" onclick="window.location.href='changePassword.jsp'"/>
    </span></div></td>
    <td height="77">
      <div align="right">
        <input name="Submit6" type="button" class="STYLE13" value="退卡" onclick="window.location.href='login.jsp'"/>
        </div>
    </td>
  </tr>
  <tr>
    <td height="147" colspan="2"><div align="left"><span class="STYLE7">系统服务热线：000-000-000</span></div></td>
  </tr>
</table>
</body>
</html>

