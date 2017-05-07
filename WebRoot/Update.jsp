<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center>
     <h2>我要修改密码</h2>
    当前用户：<font size="5" color="cyan">${loginbean.loginname }</font>
   <br>
    <form action="servlet4" method="post">
    当前密码：<input type="password" name="userpwd" ><br>
    修改密码：<input type="password" name="updatepwd" ><br>
    确认密码：<input type="password" name="againUpdatepwd" ><br>
    <input type="submit" name="submit"  value="确认修改">
    <input type="reset" name="reset" value="重置"><br>
    <A href="Main.jsp">返回主页</A>
    </form>
    </center>
  </body>
</html>
