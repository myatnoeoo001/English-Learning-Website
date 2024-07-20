package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.reading;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.MyConnection;
import dao.readingDao;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 100)
/**
 * Servlet implementation class readingServlet
 */
public class readingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { MyConnection con = new MyConnection(); 
		  Connection connect = con.getConnect();
		  
		  readingDao dao = new readingDao();
		  List<reading> allReadings = dao.getAllReadingInfo();
		  
		  int levelId =Integer.parseInt(request.getParameter("levelId")) ;

		  String title= request.getParameter("title"); 
		  String des = request.getParameter("des");
		  
		  Part filePart = request.getPart("pdfile"); 
		  System.out.println(filePart);
		  
		  
		  String fileName = filePart.getSubmittedFileName();
		  request.setAttribute("allReadings", allReadings);
		  
		  String upload = filePart + fileName;
		  
		  try (InputStream input = filePart.getInputStream()) 
		  { try 
		  (FileOutputStream output = new FileOutputStream(upload)) 
		  { byte[] buffer = new byte[1024]; 
		  int bytesRead; 
		  while ((bytesRead = input.read(buffer)) != -1) {
		  output.write(buffer, 0, bytesRead); } 
		  } 
		  }
		  
		  dao.insertWritePDF(title, des, filePart.getInputStream(),levelId); 
		  } catch (SQLException e)
		  { e.printStackTrace(); // Handle exceptions }
		  }
		  response.sendRedirect("multiplechoice.jsp");
		 
		  
	}

}
