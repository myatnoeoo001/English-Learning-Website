package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.blank;
import model.choice;
import model.reading;
import model.truefalse;

public class truefalseDao {

	 MyConnection con=new MyConnection();
	    Connection connect=con.getConnect();
	
	    public List<truefalse> getAllTrueFalseInfo() throws ClassNotFoundException, SQLException {
	        List<truefalse> list = new ArrayList<>();

	        String query = "SELECT * FROM truefalse ";
	        
	        try (PreparedStatement pstm = connect.prepareStatement(query)) {
	            
	           
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {
	                int truefalseId = rs.getInt("truefalseId");
	                String question = rs.getString("Question");
	                String correctAnswer = rs.getString("CorrectAnswer");
	                int readingIdFromDB = rs.getInt("readingId");
	                
	                truefalse obj = new truefalse(truefalseId, question, correctAnswer, readingIdFromDB);
	                list.add(obj);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

public void inserttruefalse(String question ,String correctAnswer,int readingId) throws SQLException {
	  	
	  	
	
String query = "INSERT INTO truefalse (question,correctAnswer,readingId) VALUES (?, ?, ?)";
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

public List<truefalse> getTrueFalseByParagraphId(int readingId) throws ClassNotFoundException, SQLException {
    List<truefalse> list = new ArrayList<>();

    String query = "SELECT * FROM truefalse WHERE readingId = ?";

    try (PreparedStatement pstm = connect.prepareStatement(query)) {
        pstm.setInt(1, readingId);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int trueFalseId = rs.getInt("trueFalseId");
            String question = rs.getString("Question");
            String correctAnswer = rs.getString("CorrectAnswer");

            truefalse tf = new truefalse(trueFalseId,question,correctAnswer,readingId);
            list.add(tf);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}
public List<truefalse> getAllTrueFalseByReadingId(int rid) throws SQLException{
	List<truefalse> list=new ArrayList<truefalse>();
	 String query = "select * from truefalse where readingId=?";
   
     
         PreparedStatement pstm = connect.prepareStatement(query);
         pstm.setInt(1, rid);
         ResultSet rs=pstm.executeQuery();
         while (rs.next()) {
	            int trueFalseId=rs.getInt(1);
	            String Question=rs.getString(2);
	             String CorrectAnswer=rs.getString(3);
	             
	             truefalse obj = new truefalse( trueFalseId,Question,CorrectAnswer,rid);
	            list.add(obj);
         }
 return list;        
}
public void edittruefalsequestion(truefalse ch) throws SQLException {
    Connection connect = null;
    PreparedStatement pstm = null;

    try {
        MyConnection con = new MyConnection();
        connect = con.getConnect();

        String query = "UPDATE truefalse SET Question=?, CorrectAnswer=? WHERE trueFalseid=?";
        pstm = connect.prepareStatement(query);
        
        // Set parameters for the prepared statement
        pstm.setString(1, ch.getQuestion());
        pstm.setString(2, ch.getCorrectAnswer());
        pstm.setInt(3, ch.getTrueFalseId());

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

public List<truefalse> truefalselevelTest1() throws ClassNotFoundException, SQLException {
    List<truefalse> matchingtruefalse = new ArrayList<>();
    
    readingDao rdo=new readingDao();
   reading randomReading=rdo.levelTest1();
  
    
    String query = "SELECT * FROM truefalse WHERE readingId = ?";
    
    try (PreparedStatement pstm = connect.prepareStatement(query)) {
        pstm.setInt(1, randomReading.getReadingId());
       
       
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int truefalseId = rs.getInt(1);
            String Question=rs.getString(2);
            String CorrectAnswer = rs.getString(3);
            
            truefalse obj = new truefalse(truefalseId,Question,CorrectAnswer,randomReading.getReadingId());
            matchingtruefalse.add(obj);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return matchingtruefalse;
}


public List<truefalse> truefalselevelTest2() throws ClassNotFoundException, SQLException {
    List<truefalse> matchingtruefalse = new ArrayList<>();
    
    readingDao rdo=new readingDao();
   reading randomReading=rdo.levelTest2();
  
    
    String query = "SELECT * FROM truefalse WHERE readingId = ?";
    
    try (PreparedStatement pstm = connect.prepareStatement(query)) {
        pstm.setInt(1, randomReading.getReadingId());
       
       
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int truefalseId = rs.getInt(1);
            String Question=rs.getString(2);
            String CorrectAnswer = rs.getString(3);
            
            truefalse obj = new truefalse(truefalseId,Question,CorrectAnswer,randomReading.getReadingId());
            matchingtruefalse.add(obj);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return matchingtruefalse;
}
}
