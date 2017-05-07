package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoRegister;

import bean.LoginField;
import bean.UpdateField;

public class UpdateServlet extends HttpServlet {
	public String message = "";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("gb2312");
		UpdateField updatebean = new UpdateField();// 创建bean对象存数据
		req.setAttribute("updatebean", updatebean);
		// 获取前台提交的用户名和密码
		String userpwd = req.getParameter("userpwd").trim();
		String updatepwd = req.getParameter("updatepwd").trim();
		String againUpdatepwd = req.getParameter("againUpdatepwd").trim();
		if (userpwd.length() == 0) {
			message = "原始密码不能为空";
			updatebean.setUpdateMessage(message);
			req.getRequestDispatcher("MessageUpdate.jsp").forward(req, resp);// 转发到修改信息页面
			return;
		}
		if (updatepwd.length() == 0) {
			message = "新改密码不能为空";
			updatebean.setUpdateMessage(message);
			req.getRequestDispatcher("MessageUpdate.jsp").forward(req, resp);// 转发到修改信息页面
			return;
		}
		if (againUpdatepwd.length() == 0) {
			message = "确认密码不能为空";
			updatebean.setUpdateMessage(message);
			req.getRequestDispatcher("MessageUpdate.jsp").forward(req, resp);// 转发到修改信息页面
			return;
		}
		if (!updatepwd.equals(againUpdatepwd)) {
			updatebean.setUpdateMessage("两次输入的密码不相同，请重新注册");
			req.getRequestDispatcher("MessageUpdate.jsp").forward(req, resp);// 转发到注册信息页面
			return;
		}
		HttpSession session = req.getSession(true);
		LoginField islogin = (LoginField) session.getAttribute("loginbean");
		DaoRegister DR = new DaoRegister();
		try {
			String logname = islogin.getLoginname();
			boolean ok = true;
			if (logname == null) {
				ok = false;
				resp.sendRedirect("Login.jsp");
				return;
			}
			if (ok == true) {
				int n = DR.update(logname, updatepwd);
				if (n == 1) {// 修改成功
					updatebean.setUpdateMessage("修改成功");
					System.out.println("修改成功");
				} else {// 数据库中已经存在这个 用户名
					message = "修改失败，请检查新密码是否合法";
					updatebean.setUpdateMessage(message);
				}
			}

		} catch (Exception e) {
			System.out.println("islogin内没有值或者数据库出现错误");
			// TODO: handle exception
		}
		req.getRequestDispatcher("MessageUpdate.jsp").forward(req, resp);// 转发到修改信息页面
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
