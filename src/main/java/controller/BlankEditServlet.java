package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.blank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.blankDao;

/**
 * Servlet implementation class BlankEditServlet
 */
public class BlankEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlankEditServlet() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int readingid=Integer.parseInt(request.getParameter("editrid"));
		int blankid=Integer.parseInt(request.getParameter("blankid"));
		String blankQuestion=request.getParameter("blankQuestion");
		String blankCorrectAnswer=request.getParameter("blankCorrectAnswer");
		System.out.println(blankQuestion);
		System.out.println(blankCorrectAnswer);
		blank ch=new blank(blankid,blankQuestion,blankCorrectAnswer);
		blankDao dao=new blankDao();
		try {
			dao.editblankquestion(ch);
			
			 RequestDispatcher rd=request.getRequestDispatcher("admineditclickview.jsp");
			 request.setAttribute("rid",readingid);
			 rd.forward(request, response);
			 
			out.print("<script>alert(' Your Update quizes are successful!!! ');</script>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}
