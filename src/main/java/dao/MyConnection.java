package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	public Connection getConnect() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/elarning","root","root");
			
		}catch(ClassNotFoundException e) {
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return con;
	}

	public Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}
}
