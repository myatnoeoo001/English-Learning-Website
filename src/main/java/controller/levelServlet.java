package controller;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.level;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.levelDao;

;/**
 * Servlet implementation class levelServlet
 */
public class levelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public levelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		levelDao dao=new levelDao();
		try {
			List<level> allLevel=dao.getAllLevelInfo();
			
			request.setAttribute("allLevel",allLevel);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("level.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
