package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoRegister;

import bean.SelectAll;

public class MainServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String currentPage=req.getParameter("currentPage");
		//String pageSize=req.getParameter("pageSize");
		
		SelectAll resultbean=null;
		try {
			resultbean=(SelectAll)req.getAttribute("resultbean");
			if(resultbean==null){
				resultbean=new SelectAll();
				req.setAttribute("resultbean", resultbean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resultbean=new SelectAll();
			req.setAttribute("resultbean", resultbean);
		}
		DaoRegister DR = new DaoRegister();
		try {
			ResultSet rs=DR.selectAll();
			ResultSetMetaData metaData=rs.getMetaData();
			int columnCount=metaData.getColumnCount();
			String[]columnName=new String[columnCount];
			for(int i=0;i<columnName.length;i++){
				columnName[i]=metaData.getColumnName(i+1);
			}
			resultbean.setColumnName(columnName);
			rs.last();
			int  rowNumber=rs.getRow();
			String[][] userMessage=resultbean.getUserMessage();
			userMessage=new String[rowNumber][columnCount];
			rs.beforeFirst();
			int i=0;
			while(rs.next()){
				for(int k=0;k<columnCount;k++){
					userMessage[i][k]=rs.getString(k+1);
				}
				i++;
			}resultbean.setUserMessage(userMessage);
			//resultbean.setCurrentPage(Integer.parseInt(currentPage));
			//resultbean.setPageSize(Integer.parseInt(pageSize));
			req.getRequestDispatcher("SelectAll.jsp").forward(req, resp);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("获取数据出错");
			System.out.println(e);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
