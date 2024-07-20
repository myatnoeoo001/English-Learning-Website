package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.leveltest;

public class levelTestDao {

	 MyConnection con=new MyConnection();
	    Connection connect=con.getConnect();
	
		
		  public List<leveltest> getAlllevelTestInfo() throws ClassNotFoundException,
		  SQLException { List<leveltest> list = new ArrayList<>();
		  
		  String query = "SELECT * FROM leveltest ";
		  
		  try (PreparedStatement pstm = connect.prepareStatement(query)) {
		  
		  
		  ResultSet rs = pstm.executeQuery();
		  
		  while (rs.next()) { int levletestId = rs.getInt("levelTestId");
		  
		  String MCQuestion=rs.getString("MCQuestion"); String
		  Option1=rs.getString("Option1"); String Option2=rs.getString("Option2");
		  String Option3=rs.getString("Option3"); String
		  Option4=rs.getString("Option4"); String
		  CorrectAnswer=rs.getString("CorrectAnswer"); String
		  TFQuestion=rs.getString("TFQuestion"); String
		  TFCorrectAnswer=rs.getString("TFCorrectAnswer"); String
		  BQuestion=rs.getString("BQuestion"); String
		  BCorrectAnswer=rs.getString("BCorrectAnswer"); int
		  levelId=rs.getInt("levelId");
		  
		  leveltest obj = new leveltest(levletestId, MCQuestion, Option1, Option2,
		  Option3, Option4, CorrectAnswer, TFQuestion, TFCorrectAnswer, BQuestion,
		  BCorrectAnswer, levelId); list.add(obj); } } catch (SQLException e) {
		  e.printStackTrace(); }
		  
		  return list; }
		  
		 
		/*
		 * public List<leveltest> getinterleveltest() throws ClassNotFoundException,
		 * SQLException { List<leveltest> list = new ArrayList<>();
		 * 
		 * String query = "SELECT * FROM leveltest where levelId=2";
		 * 
		 * try (PreparedStatement pstm = connect.prepareStatement(query)) {
		 * 
		 * 
		 * ResultSet rs = pstm.executeQuery();
		 * 
		 * while (rs.next()) { int levletestId = rs.getInt("levelTestId"); String
		 * MCQuestion=rs.getString("MCQuestion"); String
		 * Option1=rs.getString("Option1"); String Option2=rs.getString("Option2");
		 * String Option3=rs.getString("Option3"); String
		 * Option4=rs.getString("Option4"); String
		 * CorrectAnswer=rs.getString("CorrectAnswer"); String
		 * TFQuestion=rs.getString("TFQuestion"); String
		 * TFCorrectAnswer=rs.getString("TFCorrectAnswer"); String
		 * BQuestion=rs.getString("BQuestion"); String
		 * BCorrectAnswer=rs.getString("BCorrectAnswer"); int
		 * levelId=rs.getInt("levelId");
		 * 
		 * leveltest obj = new leveltest(levletestId, MCQuestion, Option1, Option2,
		 * Option3, Option4, CorrectAnswer, TFQuestion, TFCorrectAnswer, BQuestion,
		 * BCorrectAnswer, levelId); list.add(obj); } } catch (SQLException e) {
		 * e.printStackTrace(); }
		 * 
		 * return list; }
		 * 
		 * 
		 * public List<leveltest> getadvleveltest() throws ClassNotFoundException,
		 * SQLException { List<leveltest> list = new ArrayList<>();
		 * 
		 * String query = "SELECT * FROM leveltest where ";
		 * 
		 * try (PreparedStatement pstm = connect.prepareStatement(query)) {
		 * 
		 * 
		 * ResultSet rs = pstm.executeQuery();
		 * 
		 * while (rs.next()) { int levletestId = rs.getInt("levelTestId"); String
		 * MCQuestion=rs.getString("MCQuestion"); String
		 * Option1=rs.getString("Option1"); String Option2=rs.getString("Option2");
		 * String Option3=rs.getString("Option3"); String
		 * Option4=rs.getString("Option4"); String
		 * CorrectAnswer=rs.getString("CorrectAnswer"); String
		 * TFQuestion=rs.getString("TFQuestion"); String
		 * TFCorrectAnswer=rs.getString("TFCorrectAnswer"); String
		 * BQuestion=rs.getString("BQuestion"); String
		 * BCorrectAnswer=rs.getString("BCorrectAnswer"); int
		 * levelId=rs.getInt("levelId");
		 * 
		 * leveltest obj = new leveltest(levletestId, MCQuestion, Option1, Option2,
		 * Option3, Option4, CorrectAnswer, TFQuestion, TFCorrectAnswer, BQuestion,
		 * BCorrectAnswer, levelId); list.add(obj); } } catch (SQLException e) {
		 * e.printStackTrace(); }
		 * 
		 * return list; }
		 */
		 
	    
	    
	    public void insertPDF(InputStream file, String MCQuestion, String Option1, String Option2, String Option3, String Option4, String CorrectAnswer, String TFQuestion, String TFCorrectAnswer, String BQuestion, String BCorrectAnswer, int levelId) {
	        String query = "INSERT INTO leveltest (Paragraph, MCQuestion, Option1, Option2, Option3, Option4, CorrectAnswer, TFQuestion, TFCorrectAnswer, BQuestion, BCorrectAnswer, levelId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	        try {
	            PreparedStatement pstm = connect.prepareStatement(query);
	            
	            pstm.setBlob(1, file); // Assuming "Paragraph" is a BLOB or similar type
	            pstm.setString(2, MCQuestion);
	            pstm.setString(3, Option1);
	            pstm.setString(4, Option2);
	            pstm.setString(5, Option3);
	            pstm.setString(6, Option4);
	            pstm.setString(7, CorrectAnswer);
	            pstm.setString(8, TFQuestion);
	            pstm.setString(9, TFCorrectAnswer);
	            pstm.setString(10, BQuestion);
	            pstm.setString(11, BCorrectAnswer);
	            pstm.setInt(12, levelId); // Replace this with the actual levelId
	            
	           System.out.println(Option1);
	           
	           pstm.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }}
