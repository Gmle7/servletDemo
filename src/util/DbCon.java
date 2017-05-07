package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	 public Connection con;
	    String url="jdbc:sqlserver://localhost:1433;DatabaseName=test";
	    String user="sa";
	    String pwd="123456";
	public Connection DBConnection(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(url,user,pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库驱动错误");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接出错");
			e.printStackTrace();
		}
		return con;
	}
}
