package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.choice;
import model.reading;
import model.truefalse;

public class choiceDao {

	MyConnection con=new MyConnection();
    Connection connect=con.getConnect();
    
  public List<choice> getAllChoiceInfo( ) throws ClassNotFoundException, SQLException {
    ArrayList<choice> list = new ArrayList<choice>();
    
    
    
    String query = "select * from choice ";
    PreparedStatement pstm=connect.prepareStatement(query);
     
    ResultSet rs = pstm.executeQuery( );

    while (rs.next()) {
      int choiceId=rs.getInt(1);
      String Question=rs.getString(2);
      String Option1=rs.getString(3);
      String Option2=rs.getString(4);
      String Option3=rs.getString(5);
      String Option4=rs.getString(6);
       String CorrectAnswer=rs.getString(7);
       int readingId=rs.getInt(8);
       choice obj = new choice( choiceId,Question,Option1,Option2,Option3,Option4,CorrectAnswer,readingId);
      list.add(obj);
  }
  return list;  
  }
  
  public void insetChoice(String question, String option1, String option2,String option3,String option4,String correctAnswer,int readingId) throws SQLException {
  	
  	
      String query = "INSERT INTO choice (question,option1,option2,option3,option4,correctAnswer,readingId) VALUES (?, ?, ?, ?,?,?,?)";
      try {
      
          PreparedStatement pstm = connect.prepareStatement(query);
          pstm.setString(1, question);
          pstm.setString(2, option1);
          pstm.setString(3, option2);
          pstm.setString(4, option3);  // Replace this with the actual levelId
          pstm.setString(5, option4);
          pstm.setString(6,correctAnswer);
          pstm.setInt(7, readingId);
          pstm.executeUpdate();
        
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
  public int getReadingId() throws SQLException {
	  int i=0;
	  PreparedStatement pstm=connect.prepareStatement("select max(readingId) from reading");
	  ResultSet rs=pstm.executeQuery();
	  if(rs.next()) {
		  i=rs.getInt(1);
	  }
	  return i;
  }
  
  public List<choice> getChoiceByParagraphId(int readingId) throws ClassNotFoundException, SQLException {
	    List<choice> list = new ArrayList<>();

	    String query = "SELECT * FROM choice WHERE readingId = ?";

	    try (PreparedStatement pstm = connect.prepareStatement(query)) {
	        pstm.setInt(1, readingId);
	        ResultSet rs = pstm.executeQuery();

	        while (rs.next()) {
	            int choiceId=rs.getInt(1);
	            String Question=rs.getString(2);
	            String Option1=rs.getString(3);
	            String Option2=rs.getString(4);
	            String Option3=rs.getString(5);
	            String Option4=rs.getString(6);
	             String CorrectAnswer=rs.getString(7);
	             
	             choice obj = new choice( choiceId,Question,Option1,Option2,Option3,Option4,CorrectAnswer,readingId);
	            list.add(obj);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}
  public void editchoicequestion(choice ch) throws SQLException {
	    Connection connect = null;
	    PreparedStatement pstm = null;
	   System.out.println(ch.getQuestion());

	    try {
	        MyConnection con = new MyConnection();
	        connect = con.getConnect();

	        String query = "UPDATE choice SET Question=?, Option1=?, Option2=?, Option3=?, Option4=?, CorrectAnswer=? WHERE choiceid=?";
	        pstm = connect.prepareStatement(query);
	        pstm.setInt(1, ch.getChoiceId());
	        // Set parameters for the prepared statement
	        pstm.setString(1, ch.getQuestion());
	        pstm.setString(2, ch.getOption1());
	        pstm.setString(3, ch.getOption2());
	        pstm.setString(4, ch.getOption3());
	        pstm.setString(5, ch.getOption4());
	        pstm.setString(6, ch.getCorrectAnswer());
	        pstm.setInt(7, ch.getChoiceId());

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


public List<choice> getAllChoiceByReadingId(int rid) throws SQLException{
	List<choice> list=new ArrayList<choice>();
	 String query = "select * from choice where readingId=?";
 
   
       PreparedStatement pstm = connect.prepareStatement(query);
       pstm.setInt(1, rid);
       ResultSet rs=pstm.executeQuery();
       while (rs.next()) {
	            int choiceId=rs.getInt(1);
	            String Question=rs.getString(2);
	            String Option1=rs.getString(3);
	            String Option2=rs.getString(4);
	            String Option3=rs.getString(5);
	            String Option4=rs.getString(6);
	             String CorrectAnswer=rs.getString(7);
	             
	             choice obj = new choice( choiceId,Question,Option1,Option2,Option3,Option4,CorrectAnswer,rid);
	            list.add(obj);
       }
return list;        
}
public List<choice> choicelevelTest1() throws ClassNotFoundException, SQLException {
    List<choice> matchingChoices = new ArrayList<>();
    
    readingDao rdo=new readingDao();
   reading randomReading=rdo.levelTest1();
   
    
    String query = "SELECT * FROM choice WHERE readingId = ?";
    
    try (PreparedStatement pstm = connect.prepareStatement(query)) {
        pstm.setInt(1, randomReading.getReadingId());
        
       
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int choiceId = rs.getInt(1);
            String Question = rs.getString(2);
            String Option1 = rs.getString(3);
            String Option2 = rs.getString(4);
            String Option3 = rs.getString(5);
            String Option4 = rs.getString(6);
            String CorrectAnswer = rs.getString(7);
            
            choice obj = new choice(choiceId, Question, Option1, Option2, Option3, Option4, CorrectAnswer, randomReading.getReadingId());
            matchingChoices.add(obj);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return matchingChoices;
}


  public List<choice> getchoicelevelTest2() throws ClassNotFoundException,
  SQLException { List<choice> matchingChoices = new ArrayList<>();
  
  readingDao rdo=new readingDao();
  reading randomReading=rdo.levelTest2();
  
  
  String query = "SELECT * FROM choice WHERE readingId = ?";
  
  try (PreparedStatement pstm = connect.prepareStatement(query)) {
  pstm.setInt(1, randomReading.getReadingId());
  
  ResultSet rs = pstm.executeQuery();
  
  while (rs.next()) { int choiceId = rs.getInt(1); String Question =
  rs.getString(2); String Option1 = rs.getString(3); String Option2 =
  rs.getString(4); String Option3 = rs.getString(5); String Option4 =
  rs.getString(6); String CorrectAnswer = rs.getString(7);
  
  choice obj = new choice(choiceId, Question, Option1, Option2, Option3,
  Option4, CorrectAnswer, randomReading.getReadingId());
  matchingChoices.add(obj);
  }
  } catch (SQLException e) {
	  e.printStackTrace(); }
  
  return matchingChoices; }
}
