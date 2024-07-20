package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.choice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.choiceDao;
import model.*;

/**
 * Servlet implementation class ChoiceEditServlet
 */
public class ChoiceEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChoiceEditServlet() {
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
		int choiceid=Integer.parseInt(request.getParameter("choiceid"));
		System.out.println("choice id"+choiceid);
		String choiceQuestion=request.getParameter("chquestion");
		System.out.println("chquest"+choiceQuestion);
		String Option1=request.getParameter("option1");
		String Option2=request.getParameter("option2");
		String Option3=request.getParameter("option3");
		String Option4=request.getParameter("option4");
		String CorrectAnswer=request.getParameter("choiceCorrect");
		choice ch=new choice(choiceid,choiceQuestion,Option1,Option2,Option3,Option4, CorrectAnswer);
		choiceDao dao=new choiceDao();
		try {
			dao.editchoicequestion(ch);
			
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


