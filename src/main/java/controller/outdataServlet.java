package controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.blank;
import model.choice;
import model.reading;
import model.truefalse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import dao.blankDao;
import dao.choiceDao;
import dao.readingDao;
import dao.truefalseDao;


@WebServlet("/pdf")
/**
 * Servlet implementation class outdataServlet
 */
public class outdataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public outdataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * int value = Integer.parseInt(request.getParameter("data-value"));
		 * System.out.println(value); readingDao rdo = new readingDao(); reading read =
		 * rdo.getReadingInfoById(value);
		 */
        
		int totalscore=0;
		int tfscore=0;
		int bscore=0;
		int cscore=0;
		
		 // Retrieve blank questions
		blankDao bdao = new blankDao();
        List<blank> blankList;
		try {
			blankList = bdao.getAllBlankInfo();
			request.setAttribute("blankList",blankList);
			
			for (blank b : blankList) {
			    String userAnswer = request.getParameter("answerb_" + b.getBlankId());
			    if (userAnswer != null && userAnswer.equalsIgnoreCase(b.getCorrectAnswer())) {
			        bscore++;
			    }
			}
			
	            
	        
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 // Retrieve choice questions
		choiceDao cdao = new choiceDao();
        List<choice> choiceList;
		try {
			choiceList = cdao.getAllChoiceInfo();
			request.setAttribute("choiceList",choiceList);
			
			for (choice c : choiceList) {
			    String userAnswer = request.getParameter("answerc_" + c.getChoiceId());
			    if (userAnswer != null && userAnswer.equalsIgnoreCase(c.getCorrectAnswer())) {
			        cscore++;
			    }
			}
			
	            
	        
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        // Retrieve true/false questions

        truefalseDao tfdao = new truefalseDao();
        List<truefalse> trueFalseList;
		try {
			trueFalseList = tfdao.getAllTrueFalseInfo();
			request.setAttribute("trueFalseList", trueFalseList);
			
			for (truefalse tf : trueFalseList) {
			    String userAnswer = request.getParameter("answer_" + tf.getTrueFalseId());
			    if (userAnswer != null && userAnswer.equalsIgnoreCase(tf.getCorrectAnswer())) {
			        tfscore++;
			    }
			}
			
	        
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session=request.getSession();
		totalscore=tfscore+cscore+bscore;
		session.setAttribute("tfscore", tfscore);
		session.setAttribute("bscore", bscore);
		session.setAttribute("cscore", cscore);
		session.setAttribute("totalscore", totalscore);
		System.out.println("Total Score stored in session: " + totalscore);
		    
		 RequestDispatcher rd=request.getRequestDispatcher("totalscore.jsp");
		 rd.forward(request, response);

        // Process user answers
        
		
        readingDao dao = new readingDao();
        List <reading> readings=dao.getAllReadingInfo();

        if (readings != null && !readings.isEmpty()) {
            response.setContentType("application/pdf");

            PrintWriter out = response.getWriter();
            
            for (reading r : readings) {
                try {
					out.println( r.getTitle() +  r.getDescription()  +Utils. readBlobAsString(r.getParagraph()) );
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

           
        } else {
            response.sendRedirect("error.jsp");
        }
        
        
    }
    
    public class Utils {
        public static String readBlobAsString(Blob blob) throws SQLException, IOException {
            if (blob == null) {
                return null;
            }

            try (InputStream inputStream = blob.getBinaryStream()) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                return new String(outputStream.toByteArray());
            }
        }
    
	}
    
    

}
