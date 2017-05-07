<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#ffaa99">
    <center>
                <h2>我要注册</h2>
     <form action="servlet1" name="registerForm" method="post">
     <table cellspacing="10" cellpadding="10" width="500" align="center" border="2">
     <tr><td>用户账号:</td> <td><input type="text" name="username" size="30"/><br></td></tr>
     <tr><td>用户密码:</td> <td><input type="password" name="userpwd" size="32"/><br></td></tr>
     <tr><td>确认密码:</td> <td><input type="password" name="againpwd" size="32"/><br></td></tr>
     <tr><td>绑定手机:</td> <td><input type="text" name="userphone" size="30" value="手机号码"/></td></tr>
     </table>
     <input type="submit" name="submit" value="确定" />
     <input type="reset" name="reset" value="重置" />
     </form>
  </center>
  </body>
</html>
