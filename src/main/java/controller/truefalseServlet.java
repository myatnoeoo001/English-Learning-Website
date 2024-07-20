package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import dao.truefalseDao;

/**
 * Servlet implementation class truefalseServlet
 */
public class truefalseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public truefalseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 truefalseDao truefalsedao = new truefalseDao();
	        try {
	        	
	            

	            HttpSession session = request.getSession();
	            
	            int readingId=Integer.parseInt(session.getAttribute("readingId").toString());
	            System.out.println("Reading ID" + readingId);
	            
	            String question=request.getParameter("question");
	            String correctAnswer=request.getParameter("correctAnswer");
	            
	            truefalsedao.inserttruefalse(question,  correctAnswer, readingId);
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        response.sendRedirect("truefalse.jsp");
	   
	}

}
