<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�޸�����</title>
    
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
     <h2>��Ҫ�޸�����</h2>
    ��ǰ�û���<font size="5" color="cyan">${loginbean.loginname }</font>
   <br>
    <form action="servlet4" method="post">
    ��ǰ���룺<input type="password" name="userpwd" ><br>
    �޸����룺<input type="password" name="updatepwd" ><br>
    ȷ�����룺<input type="password" name="againUpdatepwd" ><br>
    <input type="submit" name="submit"  value="ȷ���޸�">
    <input type="reset" name="reset" value="����"><br>
    <A href="Main.jsp">������ҳ</A>
    </form>
    </center>
  </body>
</html>
