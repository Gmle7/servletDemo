<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MessageUpdate.jsp' starting page</title>
    
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
   ��ǰ�û���<font size="5" color="cyan">${loginbean.loginname }</font>
   <br>
    ${deletebean.deleteMessage}
    <br>
    <A href="Main.jsp">������ҳ</A>
    <form action="servlet3" method="post">
       <input type="submit" value="�ٴβ�ѯ">
    </form>
    <A href="Delete.jsp">����ɾ��</A>
    </center>
  </body>
</html>
