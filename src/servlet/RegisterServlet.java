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
		RegisterField userbean=new RegisterField();//����bean���������
		req.setAttribute("userbean", userbean);
		//��ȡǰ̨�ύ���û���������,�ֻ��ŵ�����
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
			userbean.setRegisterMessage("������������벻��ͬ��������ע��");
			req.getRequestDispatcher("MessageRegister.jsp").forward(req, resp);//ת����ע����Ϣҳ��
			return;
		}
		boolean isLD=true;//����һ���������͵Ķ������ж��û����ַ�����
		for(int i=0;i<username.length();i++){
			char c=username.charAt(i);
			if(!((c<='z'&&c>='a')||(c<='Z'&&c>='A')||(c<='9'&&c>='0'))){
				isLD=false;
			}
		}
		boolean boo=username.length()>0&&userpwd.length()>0&&isLD;//�Ƿ񶼷���Ҫ��
		String message="";//����һ���ַ�����ע����ʾ��Ϣ
		//����Dao�����DR
		if (boo) {//ֻ�з���Ҫ����  ���ܴ����� ��
			DaoRegister DR = new DaoRegister();
			try {
				boolean isExist =DR.select(username);//�жϵ�ǰע���û��������ݿ����Ƿ��Ѵ���
				 if(isExist==false){//��������ڸ�����
					 int n = DR.register(username, userpwd, userphone);//���ò������ݷ���
					 if (n == 1) {//����ɹ�
							message="ע��ɹ�";
							userbean.setUsername(username);
							userbean.setRegisterMessage(message);
						}
				 }else{//���ݿ����Ѿ�������� �û���
					 message="���û����Ѿ���ע�ᣡ������ע��";
					 userbean.setRegisterMessage(message);
				 }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message="ע��ʧ�ܣ����ݿⷢ������";
				userbean.setRegisterMessage(message);
			}
		}
		else{
			message="��Ϣ��д�����������������зǷ��ַ�";
			userbean.setRegisterMessage(message);
		}
		req.getRequestDispatcher("MessageRegister.jsp").forward(req, resp);//ת����ע����Ϣҳ��
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
