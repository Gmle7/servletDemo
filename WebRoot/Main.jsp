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
	<h2>��ҳ��</h2>
	��ǰ�û���<font size="5" color="cyan">${loginbean.loginname }</font>
   <br>
    ${deletebean.deleteMessage}
    <br>
	<%-- <table align="center">
		<tr><th><%out.print("ѧ��");%></th>
			<th><%out.print("����");%></th>
			<th><%out.print("רҵ");%></th>
			<th><%out.print("�༶");%></th>
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
       <input type="submit" value="��ѯ��������">
    </form>
	<A href="Update.jsp">�޸�����</A>
	<A href="Delete.jsp">ɾ���ʺ�</A>
</body>
</html>
