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

public class LoginServlet extends HttpServlet {
	public String message = "";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("gb2312");
		
		LoginField loginbean = new LoginField();// 创建bean对象存数据
		HttpSession session=req.getSession(true);
		try {
			loginbean=(LoginField)session.getAttribute("loginbean");
			if(loginbean==null){
				loginbean=new LoginField();
				session.setAttribute("loginbean", loginbean);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			loginbean=new LoginField();
			session.setAttribute("loginbean", loginbean);
		}
		//req.setAttribute("loginbean", loginbean);
		// 获取前台提交的用户名和密码
		String username = req.getParameter("username").trim();
		String userpwd = req.getParameter("userpwd").trim();
		if (username.length() == 0) {
			message = "帐号不能为空";
			loginbean.setLoginMessage(message);
			req.getRequestDispatcher("MessageLogin.jsp").forward(req, resp);// 转发到登录信息页面
			return;
		}
		if (userpwd.length() == 0) {
			message = "密码不能为空";
			loginbean.setLoginMessage(message);
			req.getRequestDispatcher("MessageLogin.jsp").forward(req, resp);// 转发到登录信息页面
			return;
		}
		boolean ok=loginbean.getisLogin();
		if(ok==true&&username.equals(loginbean.getLoginname())){
			message="已经登陆了";
			loginbean.setLoginMessage(message);
			req.getRequestDispatcher("Main.jsp").forward(req, resp);// 转发到登录信息页面
			return;
		}
		DaoRegister DR = new DaoRegister();
		try {
			boolean isExist = DR.select(username);// 判断当前用户名在数据库中是否存在
			if (isExist == true) {// 如果存在该数据
				boolean isLogin = DR.login(username, userpwd);// 调用登录方法
				if (isLogin == true) {// 登录成功
					message = "登录成功";
					loginbean.setisLogin(true);
					loginbean.setLoginname(username);
					loginbean.setLoginMessage(message);
					req.getRequestDispatcher("Main.jsp").forward(req, resp);// 转发到登录信息页面
					return;
				}else{
					message = "账号或者密码不正确，请重新登陆";
					loginbean.setisLogin(false);
					loginbean.setLoginMessage(message);	
				}
			} else {// 数据库中不存在这个 用户名
				message = "您的帐号还没有注册，请注册之后再登录";
				loginbean.setisLogin(false);
				loginbean.setLoginMessage(message);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "登录失败，数据库发生错误";
			loginbean.setisLogin(false);
			loginbean.setLoginMessage(message);
		}
		req.getRequestDispatcher("MessageLogin.jsp").forward(req, resp);// 转发到登录信息页面

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
