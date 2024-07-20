package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;

public class AdminDao {
    public Admin adminLogin(String Email, String Password) throws SQLException {
        Admin obj = null;
        MyConnection con=new MyConnection();
		Connection connect=con.getConnect();
        String query = "select * from admin where Email = ? and Password = ?";
        PreparedStatement pstm = connect.prepareStatement(query);
        pstm.setString(1, Email);
        pstm.setString(2, Password);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            int adminId = rs.getInt("adminId");
            String name = rs.getString("Name");
            String email = rs.getString("Email");
            String password = rs.getString("Password");
            obj = new Admin(adminId, name, email, password);
            System.out.println(email);
        }
       
        rs.close();
        pstm.close();
        connect.close();

        return obj;
    }

	
}