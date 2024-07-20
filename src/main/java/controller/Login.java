package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Admin;
import model.UserLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import dao.AdminDao;
import dao.loginDao;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String Email=request.getParameter("email");
	      String Password=request.getParameter("password");
	      System.out.println(Email);
	      System.out.println(Password);
	      response.setContentType("text/html");
	      PrintWriter out=response.getWriter();
	      HttpSession session=request.getSession();
	      
	      
	      try {
	      
	        loginDao loginDao=new loginDao();
	        UserLogin loginUser=loginDao.login(Email,Password);
	        if(loginUser != null) { 
	          session.setAttribute("loginUser", loginUser); 
	          
	        // You can now use userId and levelId as needed
	        request.getRequestDispatcher("user.jsp").include(request, response);
	        UserLogin user = (UserLogin) session.getAttribute("loginUser");
	          if (user != null) {
	              System.out.println(user.getEmail());
	          } else {
	              System.out.println("loginUser is null");
	          }
	        
	        }else { 
	          AdminDao adminDao = new AdminDao(); 
	          Admin loginAdmin = adminDao.adminLogin(Email, Password);
	        
	        if (loginAdmin != null) {
	        
	        session.setAttribute("loginAdmin", loginAdmin);
	        request.getRequestDispatcher("admin.jsp").include(request, response);
	        }
	        else{
	          request.getRequestDispatcher("HomePage.jsp").include(request, response);
	          out.println("<script>alert(\"Login Fail\");</script>");
	          }
	        }
	        
	       
	      /*
	       * loginDao loginDao = new loginDao(); UserLogin login=loginDao.login(Email,
	       * Password); if()
	       */        
	        
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	      
	    }
	  }

}
