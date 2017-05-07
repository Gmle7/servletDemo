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
		UpdateField updatebean = new UpdateField();// ����bean���������
		req.setAttribute("updatebean", updatebean);
		// ��ȡǰ̨�ύ���û���������
		String userpwd = req.getParameter("userpwd").trim();
		String updatepwd = req.getParameter("updatepwd").trim();
		String againUpdatepwd = req.getParameter("againUpdatepwd").trim();
		if (userpwd.length() == 0) {
			message = "ԭʼ���벻��Ϊ��";
			updatebean.setUpdateMessage(message);
			req.getRequestDispatcher("MessageUpdate.jsp").forward(req, resp);// ת�����޸���Ϣҳ��
			return;
		}
		if (updatepwd.length() == 0) {
			message = "�¸����벻��Ϊ��";
			updatebean.setUpdateMessage(message);
			req.getRequestDispatcher("MessageUpdate.jsp").forward(req, resp);// ת�����޸���Ϣҳ��
			return;
		}
		if (againUpdatepwd.length() == 0) {
			message = "ȷ�����벻��Ϊ��";
			updatebean.setUpdateMessage(message);
			req.getRequestDispatcher("MessageUpdate.jsp").forward(req, resp);// ת�����޸���Ϣҳ��
			return;
		}
		if (!updatepwd.equals(againUpdatepwd)) {
			updatebean.setUpdateMessage("������������벻��ͬ��������ע��");
			req.getRequestDispatcher("MessageUpdate.jsp").forward(req, resp);// ת����ע����Ϣҳ��
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
				if (n == 1) {// �޸ĳɹ�
					updatebean.setUpdateMessage("�޸ĳɹ�");
					System.out.println("�޸ĳɹ�");
				} else {// ���ݿ����Ѿ�������� �û���
					message = "�޸�ʧ�ܣ������������Ƿ�Ϸ�";
					updatebean.setUpdateMessage(message);
				}
			}

		} catch (Exception e) {
			System.out.println("islogin��û��ֵ�������ݿ���ִ���");
			// TODO: handle exception
		}
		req.getRequestDispatcher("MessageUpdate.jsp").forward(req, resp);// ת�����޸���Ϣҳ��
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
