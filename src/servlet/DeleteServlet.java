package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoRegister;

import bean.DeleteField;

public class DeleteServlet extends HttpServlet{
	public String message = "";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("gb2312");
		DeleteField deletebean = new DeleteField();// 创建bean对象存数据
		req.setAttribute("deletebean", deletebean);
		// 获取前台提交的用户名和密码
		String supername = req.getParameter("supername").trim();
		String superpwd = req.getParameter("superpwd").trim();
		String deletename = req.getParameter("deletename").trim();
		String againname = req.getParameter("againname").trim();
		Integer newsupername=Integer.parseInt(supername);//转换成int型，好比较
		Integer newsuperpwd=Integer.parseInt(superpwd);
		if (supername.length() == 0) {
			message = "管理员帐号不能为空";
			deletebean.setDeleteMessage(message);
			req.getRequestDispatcher("MessageDelete.jsp").forward(req, resp);// 转发到修改信息页面
			return;
		}
		if (superpwd.length() == 0) {
			message = "管理员密码不能为空";
			deletebean.setDeleteMessage(message);
			req.getRequestDispatcher("MessageDelete.jsp").forward(req, resp);// 转发到修改信息页面
			return;
		}
		if (deletename.length() == 0) {
			message = "请输入要删除的用户名";
			deletebean.setDeleteMessage(message);
			req.getRequestDispatcher("MessageDelete.jsp").forward(req, resp);// 转发到修改信息页面
			return;
		}
		if (againname.length() == 0) {
			message = "为了你的数据安全，请再次输入要删除的用户名";
			deletebean.setDeleteMessage(message);
			req.getRequestDispatcher("MessageDelete.jsp").forward(req, resp);// 转发到修改信息页面
			return;
		}
		if (!deletename.equals(againname)) {
			deletebean.setDeleteMessage("两次输入的用户名不相同，请确认后再删除");
			req.getRequestDispatcher("MessageDelete.jsp").forward(req, resp);// 转发到注册信息页面
			return;
		}
		if (newsupername!=888888) {
			message = "管理员帐号错误，请确认您有管理员权限";
			deletebean.setDeleteMessage(message);
			req.getRequestDispatcher("MessageDelete.jsp").forward(req, resp);// 转发到修改信息页面
			return;
		}
		if (newsuperpwd!=888888) {
			message = "管理员密码错误，请确认您有管理员权限";
			deletebean.setDeleteMessage(message);
			req.getRequestDispatcher("MessageDelete.jsp").forward(req, resp);// 转发到修改信息页面
			return;
		}
		try {
			DaoRegister DR = new DaoRegister();
				int n = DR.delete(deletename);
				if (n == 1) {// 删除成功
					deletebean.setDeleteMessage("删除成功");
					System.out.println("删除成功");
				} else {
					message = "删除失败";
					deletebean.setDeleteMessage(message);
				}

		} catch (Exception e) {
			System.out.println("删除的过程中出错");
			// TODO: handle exception
		}
		req.getRequestDispatcher("MessageDelete.jsp").forward(req, resp);// 转发到修改信息页面
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
