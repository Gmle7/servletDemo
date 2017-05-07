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
		
		LoginField loginbean = new LoginField();// ����bean���������
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
		// ��ȡǰ̨�ύ���û���������
		String username = req.getParameter("username").trim();
		String userpwd = req.getParameter("userpwd").trim();
		if (username.length() == 0) {
			message = "�ʺŲ���Ϊ��";
			loginbean.setLoginMessage(message);
			req.getRequestDispatcher("MessageLogin.jsp").forward(req, resp);// ת������¼��Ϣҳ��
			return;
		}
		if (userpwd.length() == 0) {
			message = "���벻��Ϊ��";
			loginbean.setLoginMessage(message);
			req.getRequestDispatcher("MessageLogin.jsp").forward(req, resp);// ת������¼��Ϣҳ��
			return;
		}
		boolean ok=loginbean.getisLogin();
		if(ok==true&&username.equals(loginbean.getLoginname())){
			message="�Ѿ���½��";
			loginbean.setLoginMessage(message);
			req.getRequestDispatcher("Main.jsp").forward(req, resp);// ת������¼��Ϣҳ��
			return;
		}
		DaoRegister DR = new DaoRegister();
		try {
			boolean isExist = DR.select(username);// �жϵ�ǰ�û��������ݿ����Ƿ����
			if (isExist == true) {// ������ڸ�����
				boolean isLogin = DR.login(username, userpwd);// ���õ�¼����
				if (isLogin == true) {// ��¼�ɹ�
					message = "��¼�ɹ�";
					loginbean.setisLogin(true);
					loginbean.setLoginname(username);
					loginbean.setLoginMessage(message);
					req.getRequestDispatcher("Main.jsp").forward(req, resp);// ת������¼��Ϣҳ��
					return;
				}else{
					message = "�˺Ż������벻��ȷ�������µ�½";
					loginbean.setisLogin(false);
					loginbean.setLoginMessage(message);	
				}
			} else {// ���ݿ��в�������� �û���
				message = "�����ʺŻ�û��ע�ᣬ��ע��֮���ٵ�¼";
				loginbean.setisLogin(false);
				loginbean.setLoginMessage(message);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "��¼ʧ�ܣ����ݿⷢ������";
			loginbean.setisLogin(false);
			loginbean.setLoginMessage(message);
		}
		req.getRequestDispatcher("MessageLogin.jsp").forward(req, resp);// ת������¼��Ϣҳ��

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
