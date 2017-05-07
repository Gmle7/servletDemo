<%@ page language="java" import="java.util.*,bean.SelectAll" pageEncoding="gb2312"%>
<jsp:useBean id="selectall" class="bean.SelectAll" scope="session"/>
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

<title>My JSP 'SelectAll.jsp' starting page</title>

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
<jsp:setProperty name="selectall" property="pageSize" param="pageSize"/>
<jsp:setProperty name="selectall" property="currentPage" param="currentPage"/>
	<center>
		<h2>查询所有数据</h2>
		当前用户： ${loginbean.loginname }
		<table border=1>
			<%
				SelectAll resultbean = null;
				resultbean = (SelectAll) request.getAttribute("resultbean");
				String[] columnName = resultbean.getColumnName();
			%>
			<tr>
				<%
					for (String s : columnName) {
				%>
				<th><%=s%></th>
				<%
					}
				%>
			</tr>

			<%
				String[][] usermessage = resultbean.getUserMessage();
				int pageSize = resultbean.getPageSize();
				int totalPages = resultbean.getTotalPages();
				if (usermessage.length % pageSize == 0)
					totalPages = usermessage.length / pageSize;
				else
					totalPages = usermessage.length / pageSize + 1;
				resultbean.setPageSize(pageSize);
				resultbean.setTotalPages(totalPages);
				if (totalPages >= 1) {
					if (resultbean.getCurrentPage() < 1)
						resultbean.setCurrentPage(resultbean.getTotalPages());
					if (resultbean.getCurrentPage() > resultbean.getTotalPages())
						resultbean.setCurrentPage(1);
					int index = (resultbean.getCurrentPage() - 1) * pageSize;
					int start = index;//数据表中的cuttentpage页的起始位置
					for (int i = index; i < pageSize + index; i++) {
						if (i == usermessage.length)
							break;
			%>
			<tr>
				<%
					for (int j = 0; j < columnName.length; j++) {
				%>
				<td><%=usermessage[i][j]%></td>
				<%
					}
				%>
			</tr>
			<%
				}
				}
			%>
		</table>
		<br>一共有<%=usermessage.length%>条记录 <br>每页最多显示<%=resultbean.getPageSize()%>条信息，
		当前显示第<%=resultbean.getCurrentPage()%>页， 一共有<%=resultbean.getTotalPages()%>页
		<br>
		<table>
			<tr>
				<td>
					<form action="" method="post">
						<input type=hidden name="currentPage"
							value="<%=resultbean.getCurrentPage() - 1%>"> <input
							type="submit" name="g" value="上一页">
					</form>
				</td>

				<td>
					<form action="" method="post">
						<input type=hidden name="currentPage"
							value="<%=resultbean.getCurrentPage() + 1%>"> <input
							type="submit" name="g" value="下一页">
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<form action="" method="post">
						每页显示<input type=text name="pageSize" value="2" size="3">条记录
						<input type="submit" name="g" value="确定">
					</form>
				</td>
				<td>
					<form action="" method="post">
						输入页码：<input type=text name="currentPage" size="2"> <input
							type="submit" name="g" value="提交">
					</form>
				</td>
			</tr>
		</table>
		<A href="Main.jsp">返回主页</A>&nbsp;&nbsp;&nbsp; <A href="Delete.jsp">删除数据</A>&nbsp;&nbsp;&nbsp;
		<A href="Update.jsp">修改密码</A>
	</center>
</body>
</html>
