<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#9999aa">
  <center>
     <h2>我要登录</h2>
     <form action="servlet2">
     <table cellspacing="10" cellpadding="10" width="500" align="center" border="2">
     <tr><td>账号:</td><td><input type="text" name="username"/></td></tr>
     <tr><td>密码:</td><td><input type="password" name="userpwd"/></td></tr>
     </table>
      <input type="submit" name="submit" value="确定"/>
      <input type="reset" name="reset" value="重置"/>
     </form>
  </center>
  </body>
</html>
