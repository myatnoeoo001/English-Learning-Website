package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import model.*;

public class loginDao {
	public UserLogin login(String Email,String Password) throws SQLException {
		System.out.println("email : "+Email );
		System.out.println("email : "+Password );
		UserLogin obj=null;
		  MyConnection conobj = new MyConnection();
	        Connection con = conobj.getConnect();
	        String query = "select * from user where  Email = ? and Password = ?";
	        PreparedStatement pstm = con.prepareStatement(query);
	        
	        pstm.setString(1, Email);
	        pstm.setString(2, Password);
	        
	        ResultSet rs = pstm.executeQuery();
	        if(rs.next()) {
	        	int userId=rs.getInt("userId");
	        	String name = rs.getString("Name");
	        	String email=rs.getString("Email");
	            String password = rs.getString("Password");
	            int levelId=rs.getInt("levelId");
	            System.out.println(userId +"user id ");
	            obj = new UserLogin(userId, name, email, password, levelId);
	        }
	        rs.close();
	        pstm.close();
	        con.close();

	        return obj;
	}
	public List<UserLogin> getAllUsers() throws SQLException {
	    List<UserLogin> obj = new ArrayList<UserLogin>();
	    MyConnection conobj = new MyConnection();
        Connection con = conobj.getConnect();
	    PreparedStatement pstm = con.prepareStatement("select * from user ");
	    int count=0;
	    ResultSet rs = pstm.executeQuery();
	    
	    while(rs.next()) {
	    	int userId = rs.getInt("userId");
	        String name = rs.getString("Name");
	        String email = rs.getString("Email");
	        String password = rs.getString("Password");
	        int levelId = rs.getInt("levelId");
	        obj.add(new UserLogin(userId, name, email, password, levelId));
	        count++;
	    }
	  
	    
	    rs.close();
	    pstm.close();
	    con.close();

	    return obj;
	}
	public int getcount()throws SQLException{
		 int count=0;
		 MyConnection conobj = new MyConnection();
	        Connection con = conobj.getConnect();
		 PreparedStatement pstm = con.prepareStatement("select count(userId) from user");
		
		    ResultSet rs = pstm.executeQuery();
		    
		    // Retrieve the count from the result set
		    if (rs.next()) {
		        count = rs.getInt(1);
		    }
		    // Close resources
		    rs.close();
		    pstm.close();
		    con.close();
		    
		    return count;
		}
	public int Basiccount()throws SQLException{
		 int count=0;
		 MyConnection conobj = new MyConnection();
	        Connection con = conobj.getConnect();
		 PreparedStatement pstm = con.prepareStatement("select count(userId) from user  where levelId=1;");
		
		    ResultSet rs = pstm.executeQuery();
		    
		    // Retrieve the count from the result set
		    if (rs.next()) {
		        count = rs.getInt(1);
		    }
		    // Close resources
		    rs.close();
		    pstm.close();
		    con.close();
		    
		    return count;
		}
	public int Intercount()throws SQLException{
		 int count=0;
		 MyConnection conobj = new MyConnection();
	        Connection con = conobj.getConnect();
		 PreparedStatement pstm = con.prepareStatement("select count(userId) from user  where levelId=2;");
		
		    ResultSet rs = pstm.executeQuery();
		    
		    // Retrieve the count from the result set
		    if (rs.next()) {
		        count = rs.getInt(1);
		    }
		    // Close resources
		    rs.close();
		    pstm.close();
		    con.close();
		    
		    return count;
		}
	public int Advancount()throws SQLException{
		 int count=0;
		 MyConnection conobj = new MyConnection();
	        Connection con = conobj.getConnect();
		 PreparedStatement pstm = con.prepareStatement("select count(userId) from user  where levelId=3;");
		
		    ResultSet rs = pstm.executeQuery();
		    
		    // Retrieve the count from the result set
		    if (rs.next()) {
		        count = rs.getInt(1);
		    }
		    // Close resources
		    rs.close();
		    pstm.close();
		    con.close();
		    
		    return count;
		}

}
