package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dao.*;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
		
		
		Connection conn;
		PreparedStatement pst;
		
		RegisterDao reg = new RegisterDao();
		try {
			if(new RegisterDao().checkMail(email)){
				request.getRequestDispatcher("HomePage.jsp").include(request, response);
				out.println("<script>alert(\"already have account plz login in again\");</script>");
			}else {
				int effect = reg.RegisterUserRegister(name, email, password, cpassword);
				if(effect!=0) {
					request.getRequestDispatcher("HomePage.jsp").include(request, response);
					out.println("<script>alert(\"please login in again\");</script>");
				}else {
					request.getRequestDispatcher("HomePage.jsp").include(request, response);
					out.println("<script>alert(\"Login Fail\");</script>");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
