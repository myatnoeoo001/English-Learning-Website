package controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import dao.choiceDao;

/**
 * Servlet implementation class choiceServlet
 */
public class choiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public choiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		choiceDao choicedao = new choiceDao();
        try {
            int readingId = choicedao.getReadingId();

            HttpSession session = request.getSession();
            session.setAttribute("readingId", readingId);

            System.out.println("Reading ID" + readingId);
            
            String question=request.getParameter("question");
            String option1=request.getParameter("option1");
            String option2=request.getParameter("option2");
            String option3=request.getParameter("option3");
            String option4=request.getParameter("option4");
            String correctAnswer=request.getParameter("correctAnswer");
            
            choicedao.insetChoice(question, option1, option2, option3, option4, correctAnswer, readingId);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("multiplechoice.jsp");
    
	}

}
