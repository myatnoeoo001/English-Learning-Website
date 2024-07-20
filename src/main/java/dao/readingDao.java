package dao;

import java.io.InputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.cj.jdbc.Blob;
import model.reading;

public class readingDao {

	MyConnection con=new MyConnection();
	Connection connect=con.getConnect();
	

	public List<reading> getAllReadingInfo()  {
        ArrayList<reading> list = new ArrayList<reading>();
        String query = "select * from reading";
        try {
            PreparedStatement pstm = connect.prepareStatement(query);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int readingId = rs.getInt("readingId");
                String Title = rs.getString("Title");
                String Description = rs.getString("Description");
                java.sql.Blob Paragraph = rs.getBlob("Paragraph");
                int levelId = rs.getInt("levelId");
               reading obj=new reading(readingId,Title,Description,Paragraph,levelId);
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    

    public void insertWritePDF(String title, String des, InputStream file,int levelId) throws SQLException {
    	
    	
        String query = "INSERT INTO reading (Title, Description, Paragraph, levelId) VALUES (?, ?, ?, ?)";
        try {
    
            PreparedStatement pstm = connect.prepareStatement(query);
            pstm.setString(1, title);
            pstm.setString(2, des);
           
            pstm.setInt(4, levelId);  // Replace this with the actual levelId
            pstm.setBlob(3, file);

            pstm.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public reading getReadingInfoById(int readingId) {
        reading r = null;
        String query = "SELECT * FROM reading WHERE readingId = ?";
        try {
            PreparedStatement pstm = connect.prepareStatement(query);
            pstm.setInt(1, readingId);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                Blob paragraphBlob = (Blob) rs.getBlob("Paragraph");
                

				/*
				 * // Convert Blob to byte array for PDF content byte[] pdfContent = null; if
				 * (paragraphBlob != null) { pdfContent = paragraphBlob.getBytes(1, (int)
				 * paragraphBlob.length()); }
				 */
                r = new reading(readingId, title, description, paragraphBlob);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }
    
    public List<reading> getReadingBybasiclevel()  {
        ArrayList<reading> list = new ArrayList<reading>();
        String query = "select * from reading where levelId=1";
        try {
            PreparedStatement pstm = connect.prepareStatement(query);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int readingId = rs.getInt("readingId");
                String Title = rs.getString("Title");
                String Description = rs.getString("Description");
                java.sql.Blob Paragraph = rs.getBlob("Paragraph");
                int levelId = rs.getInt("levelId");
               reading obj=new reading(readingId,Title,Description,Paragraph,levelId);
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
    public List<reading> getReadingByinterMediatelevel()  {
        ArrayList<reading> list = new ArrayList<reading>();
        String query = "select * from reading where levelId=2";
        try {
            PreparedStatement pstm = connect.prepareStatement(query);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int readingId = rs.getInt("readingId");
                String Title = rs.getString("Title");
                String Description = rs.getString("Description");
                java.sql.Blob Paragraph = rs.getBlob("Paragraph");
                int levelId = rs.getInt("levelId");
               reading obj=new reading(readingId,Title,Description,Paragraph,levelId);
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<reading> getReadingByadvancelevel()  {
        ArrayList<reading> list = new ArrayList<reading>();
        String query = "select * from reading where levelId=3";
        try {
            PreparedStatement pstm = connect.prepareStatement(query);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int readingId = rs.getInt("readingId");
                String Title = rs.getString("Title");
                String Description = rs.getString("Description");
                java.sql.Blob Paragraph = rs.getBlob("Paragraph");
                int levelId = rs.getInt("levelId");
               reading obj=new reading(readingId,Title,Description,Paragraph,levelId);
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public reading levelTest1() {
        reading randomReading = null;
        String query = "SELECT * FROM reading WHERE levelId=1 ORDER BY RAND() LIMIT 1";
        try {
            PreparedStatement pstm = connect.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                int readingId = rs.getInt("readingId");
                String Title = rs.getString("Title");
                String Description = rs.getString("Description");
                java.sql.Blob Paragraph = rs.getBlob("Paragraph");
                int levelId = rs.getInt("levelId");
                randomReading = new reading(readingId, Title, Description, Paragraph, levelId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return randomReading;
    }
    public reading levelTest2() {
        reading randomReading = null;
        String query = "SELECT * FROM reading WHERE levelId=2 ORDER BY RAND() LIMIT 1";
        try {
            PreparedStatement pstm = connect.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                int readingId = rs.getInt("readingId");
                String Title = rs.getString("Title");
                String Description = rs.getString("Description");
                java.sql.Blob Paragraph = rs.getBlob("Paragraph");
                int levelId = rs.getInt("levelId");
                randomReading = new reading(readingId, Title, Description, Paragraph, levelId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return randomReading;
    }
    
}
