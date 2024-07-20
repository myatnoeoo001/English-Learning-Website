package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.*;
public class blankDao {
	MyConnection con=new MyConnection();
    Connection connect=con.getConnect();

	public List<blank> getAllBlankInfo( ) throws ClassNotFoundException, SQLException {
	    ArrayList<blank> list = new ArrayList<blank>();
	    
	    
	    String query = "select * from blank ";
	    PreparedStatement pstm=connect.prepareStatement(query);
	     
	    ResultSet rs = pstm.executeQuery( );

	    while (rs.next()) {
	      int blankId=rs.getInt(1);
	      String Question=rs.getString(2);
	       String CorrectAnswer=rs.getString(3);
	       int readingId=rs.getInt(4);
	      blank obj = new blank(blankId,Question,CorrectAnswer,readingId );
	      list.add(obj);
	  }
	  return list;  
	  }
	
	public void insertblank(String question ,String correctAnswer,int readingId) throws SQLException {
	  	
	  	
		
		String query = "INSERT INTO blank (question,correctAnswer,readingId) VALUES (?, ?, ?)";
		try {

		   PreparedStatement pstm = connect.prepareStatement(query);
		   pstm.setString(1, question);
		   
		   pstm.setString(2,correctAnswer);
		   pstm.setInt(3, readingId);
		   pstm.executeUpdate();
		 
		} catch (SQLException e) {
		   e.printStackTrace();
		}
		}
	
	public List<blank> getblankByParagraphId(int readingId) throws ClassNotFoundException, SQLException {
	    List<blank> list = new ArrayList<>();

	    String query = "SELECT * FROM blank WHERE readingId = ?";

	    try (PreparedStatement pstm = connect.prepareStatement(query)) {
	        pstm.setInt(1, readingId);
	        ResultSet rs = pstm.executeQuery();

	        while (rs.next()) {
	  	      int blankId=rs.getInt(1);
	  	      String Question=rs.getString(2);
	  	       String CorrectAnswer=rs.getString(3);
	  	       blank obj=new blank(blankId,Question,CorrectAnswer,readingId);
	  	      list.add(obj);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	 public void editblankquestion(blank ch) throws SQLException {
		    Connection connect = null;
		    PreparedStatement pstm = null;

		    try {
		        MyConnection con = new MyConnection();
		        connect = con.getConnect();

		        String query = "UPDATE blank SET Question=?,CorrectAnswer=? WHERE blankid=?";
		        pstm = connect.prepareStatement(query);
		        
		        // Set parameters for the prepared statement
		        pstm.setString(1, ch.getQuestion());
		        pstm.setString(2, ch.getCorrectAnswer());
		        pstm.setInt(3, ch.getBlankId());

		        // Execute the update query
		        pstm.executeUpdate();
		    } finally {
		        // Close resources in a finally block
		        try {
		            if (pstm != null) {
		                pstm.close();
		            }
		            if (connect != null) {
		                connect.close();
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		}

		public List<blank> blanklevelTest1() throws ClassNotFoundException, SQLException {
		    List<blank> matchingBlank = new ArrayList<>();
		    
		    readingDao rdo=new readingDao();
		   reading randomReading=rdo.levelTest1();
		   reading randomReading2 =rdo.levelTest2();
		    
		    String query = "SELECT * FROM blank WHERE readingId = ?";
		    
		    try (PreparedStatement pstm = connect.prepareStatement(query)) {
		        pstm.setInt(1, randomReading.getReadingId());
		        pstm.setInt(1,randomReading2.getReadingId());
		       
		        ResultSet rs = pstm.executeQuery();

		        while (rs.next()) {
		            int blankId = rs.getInt(1);
		            String Question=rs.getString(2);
		            String CorrectAnswer = rs.getString(3);
		            
		            blank obj = new blank(blankId,Question,CorrectAnswer,randomReading.getReadingId());
		            matchingBlank.add(obj);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return matchingBlank;
		}
		
		public List<blank> blanklevelTest2() throws ClassNotFoundException, SQLException {
		    List<blank> matchingBlank = new ArrayList<>();
		    
		    readingDao rdo=new readingDao();
		   reading randomReading=rdo.levelTest2();
		  
		    
		    String query = "SELECT * FROM blank WHERE readingId = ?";
		    
		    try (PreparedStatement pstm = connect.prepareStatement(query)) {
		        pstm.setInt(1, randomReading.getReadingId());
		       
		       
		        ResultSet rs = pstm.executeQuery();

		        while (rs.next()) {
		            int blankId = rs.getInt(1);
		            String Question=rs.getString(2);
		            String CorrectAnswer = rs.getString(3);
		            
		            blank obj = new blank(blankId,Question,CorrectAnswer,randomReading.getReadingId());
		            matchingBlank.add(obj);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return matchingBlank;
		}
}
