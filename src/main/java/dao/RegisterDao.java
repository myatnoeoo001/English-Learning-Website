package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import model.UserRegister;
public class RegisterDao {
	public int RegisterUserRegister( String name, String email, String password, String confirmpassword) throws SQLException {
		
		MyConnection con=new MyConnection();
		Connection connect=con.getConnect();
        String query = "INSERT INTO user(Name, Email, Password, ConfirmPassword,levelId) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst = connect.prepareStatement(query);
        pst=connect.prepareStatement(query);
		pst.setString(1, name);
		pst.setString(2, email);
		pst.setString(3, password);
		pst.setString(4, confirmpassword);
		pst.setInt(5, 1);
		int rowcount=pst.executeUpdate();
		System.out.println(rowcount);
		if(rowcount!=0) {
			return 1;
			
		}else
		return 0;
}
	
	
	// giving email and ucstgi mail for checking is like this email or not 
    public boolean checkMail(String Inputemail  ) {
      String email = "";
      String query = "";
      MyConnection con=new MyConnection();
		Connection connect=con.getConnect();
      boolean alreadyHadOrNot = false  ; 
      
    query = "select * from user ";
      
      try {
        PreparedStatement pst = connect.prepareStatement(query);
        
        ResultSet rs = pst.executeQuery();
        boolean matchFound = false;
        
        while (rs.next() && !matchFound) {
                email = rs.getString("Email");
             
            
            if (email.equalsIgnoreCase(Inputemail)) {
            
                alreadyHadOrNot = true;
                matchFound = true; // Set flag to indicate match found
            }
        } 
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return alreadyHadOrNot;
    }
}