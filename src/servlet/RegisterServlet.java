package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RegisterField;
import dao.DaoRegister;

public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("gb2312");
		RegisterField userbean=new RegisterField();//创建bean对象存数据
		req.setAttribute("userbean", userbean);
		//获取前台提交的用户名和密码,手机号等数据
		String username=req.getParameter("username").trim();
		String userpwd=req.getParameter("userpwd").trim();
		String againpwd=req.getParameter("againpwd").trim();
		String userphone=req.getParameter("userphone").trim();
		if(username==null){
			username="";
		}
		if(userpwd==null){
			userpwd="";
		}
		if(!userpwd.equals(againpwd)){
			userbean.setRegisterMessage("两次输入的密码不相同，请重新注册");
			req.getRequestDispatcher("MessageRegister.jsp").forward(req, resp);//转发到注册信息页面
			return;
		}
		boolean isLD=true;//定义一个布尔类型的对象来判断用户名字符问题
		for(int i=0;i<username.length();i++){
			char c=username.charAt(i);
			if(!((c<='z'&&c>='a')||(c<='Z'&&c>='A')||(c<='9'&&c>='0'))){
				isLD=false;
			}
		}
		boolean boo=username.length()>0&&userpwd.length()>0&&isLD;//是否都符合要求
		String message="";//定义一个字符串放注册提示信息
		//创建Dao类对象DR
		if (boo) {//只有符合要求是  才能存数据 库
			DaoRegister DR = new DaoRegister();
			try {
				boolean isExist =DR.select(username);//判断当前注册用户名在数据库中是否已存在
				 if(isExist==false){//如果不存在该数据
					 int n = DR.register(username, userpwd, userphone);//调用插入数据方法
					 if (n == 1) {//插入成功
							message="注册成功";
							userbean.setUsername(username);
							userbean.setRegisterMessage(message);
						}
				 }else{//数据库中已经存在这个 用户名
					 message="该用户名已经被注册！请重新注册";
					 userbean.setRegisterMessage(message);
				 }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message="注册失败，数据库发生错误";
				userbean.setRegisterMessage(message);
			}
		}
		else{
			message="信息填写不完整或者名字中有非法字符";
			userbean.setRegisterMessage(message);
		}
		req.getRequestDispatcher("MessageRegister.jsp").forward(req, resp);//转发到注册信息页面
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
