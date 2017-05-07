<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'main.jsp' starting page</title>

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
	<h2>主页面</h2>
	当前用户：<font size="5" color="cyan">${loginbean.loginname }</font>
   <br>
    ${deletebean.deleteMessage}
    <br>
	<%-- <table align="center">
		<tr><th><%out.print("学号");%></th>
			<th><%out.print("姓名");%></th>
			<th><%out.print("专业");%></th>
			<th><%out.print("班级");%></th>
	    </tr>
		<%while (rs.next()) {%>
		<tr><td><%out.print(rs.getString(1));%></td>
			<td><%out.print(rs.getString(2));%></td>
			<td><%out.print(rs.getString(3));%></td>
			<td><%out.print(rs.getString(4));%></td>
	    </tr>
		<%}%>
	</table> --%>
    <form action="servlet3" method="post">
       <input type="submit" value="查询所有数据">
    </form>
	<A href="Update.jsp">修改密码</A>
	<A href="Delete.jsp">删除帐号</A>
</body>
</html>
