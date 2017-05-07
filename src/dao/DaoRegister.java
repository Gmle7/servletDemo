package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DbCon;

public class DaoRegister {
	public PreparedStatement prst;
	public ResultSet rs;
	//连接数据库
	DbCon db=new DbCon();
	Connection con=db.DBConnection();
	//实现注册功能的方法，插入数据到数据库
	public int register(String username,String userpwd,
			String userphone)throws SQLException{
		prst=con.prepareStatement("insert into chenchao08 values(?,?,?)");
		prst.setString(1, username);
		prst.setString(2, userpwd);
		prst.setString(3, userphone);
		int n=prst.executeUpdate();
		return n;
	}
	public boolean select(String username)throws SQLException{
		prst=con.prepareStatement("select * from chenchao08 where username=?");
		prst.setString(1, username);
		rs=prst.executeQuery();
		boolean isExist=rs.next();
		return isExist;
	}
	public boolean login(String username,String userpwd)throws SQLException{
		prst=con.prepareStatement("select *from chenchao08 where username=? and userpwd=?");
		prst.setString(1, username);
		prst.setString(2, userpwd);
		rs=prst.executeQuery();
		boolean isLogin=rs.next();
		return isLogin;
	}
	public ResultSet selectAll() throws SQLException{
		prst=con.prepareStatement("select *  from chenchao08",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs=prst.executeQuery();
		return rs;
	}
	public int update(String username,String userpwd) throws SQLException{
		prst=con.prepareStatement("update chenchao08 set userpwd=? where username=?");
		prst.setString(1, userpwd);
		prst.setString(2, username);
	    int n=prst.executeUpdate();
		return n;
	}
	public int delete(String username)throws SQLException{
		prst=con.prepareStatement("delete from chenchao08 where username=?");
		prst.setString(1, username);
		int n=prst.executeUpdate();
		return n;
	}

}
