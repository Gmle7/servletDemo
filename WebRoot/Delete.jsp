<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Delete.jsp' starting page</title>
    
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
                <h2>删除数据</h2>超级帐号：888888密码：888888<br>
                当前用户：<font size="5" color="cyan">${loginbean.loginname }</font>
   <br>
     <form action="servlet5" name="" method="post">
     <table cellspacing="10" cellpadding="10" width="500" align="center" border="2">
     <tr><td>超级帐号:</td> <td><input type="text" name="supername" size="30"/><br></td></tr>
     <tr><td>超级密码:</td> <td><input type="password" name="superpwd" size="32"/><br></td></tr>
     <tr><td>删除用户:</td> <td><input type="text" name="deletename" size="32"/><br></td></tr>
     <tr><td>确认用户:</td> <td><input type="text" name="againname" size="30"/></td></tr>
     </table>
     <input type="submit" name="submit" value="确定" />
     <input type="reset" name="reset" value="重置" />
     </form>
  </center>
  </body>
</html>
