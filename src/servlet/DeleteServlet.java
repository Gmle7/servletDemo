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
		DeleteField deletebean = new DeleteField();// ����bean���������
		req.setAttribute("deletebean", deletebean);
		// ��ȡǰ̨�ύ���û���������
		String supername = req.getParameter("supername").trim();
		String superpwd = req.getParameter("superpwd").trim();
		String deletename = req.getParameter("deletename").trim();
		String againname = req.getParameter("againname").trim();
		Integer newsupername=Integer.parseInt(supername);//ת����int�ͣ��ñȽ�
		Integer newsuperpwd=Integer.parseInt(superpwd);
		if (supername.length() == 0) {
			message = "����Ա�ʺŲ���Ϊ��";
			deletebean.setDeleteMessage(message);
			req.getRequestDispatcher("MessageDelete.jsp").forward(req, resp);// ת�����޸���Ϣҳ��
			return;
		}
		if (superpwd.length() == 0) {
			message = "����Ա���벻��Ϊ��";
			deletebean.setDeleteMessage(message);
			req.getRequestDispatcher("MessageDelete.jsp").forward(req, resp);// ת�����޸���Ϣҳ��
			return;
		}
		if (deletename.length() == 0) {
			message = "������Ҫɾ�����û���";
			deletebean.setDeleteMessage(message);
			req.getRequestDispatcher("MessageDelete.jsp").forward(req, resp);// ת�����޸���Ϣҳ��
			return;
		}
		if (againname.length() == 0) {
			message = "Ϊ��������ݰ�ȫ�����ٴ�����Ҫɾ�����û���";
			deletebean.setDeleteMessage(message);
			req.getRequestDispatcher("MessageDelete.jsp").forward(req, resp);// ת�����޸���Ϣҳ��
			return;
		}
		if (!deletename.equals(againname)) {
			deletebean.setDeleteMessage("����������û�������ͬ����ȷ�Ϻ���ɾ��");
			req.getRequestDispatcher("MessageDelete.jsp").forward(req, resp);// ת����ע����Ϣҳ��
			return;
		}
		if (newsupername!=888888) {
			message = "����Ա�ʺŴ�����ȷ�����й���ԱȨ��";
			deletebean.setDeleteMessage(message);
			req.getRequestDispatcher("MessageDelete.jsp").forward(req, resp);// ת�����޸���Ϣҳ��
			return;
		}
		if (newsuperpwd!=888888) {
			message = "����Ա���������ȷ�����й���ԱȨ��";
			deletebean.setDeleteMessage(message);
			req.getRequestDispatcher("MessageDelete.jsp").forward(req, resp);// ת�����޸���Ϣҳ��
			return;
		}
		try {
			DaoRegister DR = new DaoRegister();
				int n = DR.delete(deletename);
				if (n == 1) {// ɾ���ɹ�
					deletebean.setDeleteMessage("ɾ���ɹ�");
					System.out.println("ɾ���ɹ�");
				} else {
					message = "ɾ��ʧ��";
					deletebean.setDeleteMessage(message);
				}

		} catch (Exception e) {
			System.out.println("ɾ���Ĺ����г���");
			// TODO: handle exception
		}
		req.getRequestDispatcher("MessageDelete.jsp").forward(req, resp);// ת�����޸���Ϣҳ��
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
