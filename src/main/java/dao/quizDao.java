package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.question;
public class quizDao {
	public List<question> getRandomQuestions(int number) {
        List<question> questionList = new ArrayList<>();
        
        PreparedStatement pst;
        MyConnection conobj = new MyConnection();
        Connection conn = conobj.getConnect();
        String sql = "select * from question ORDER BY RAND() LIMIT ?;"; 	
        
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, number);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String text = rs.getString("text");
                String one = rs.getString("option1");
                String two = rs.getString("option2");
                String three = rs.getString("option3");
                String four = rs.getString("option4");
                String answer = rs.getString("correct");
                
                question qobj = new question(id, text, one, two, three, four, answer);
                questionList.add(qobj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return questionList;
    }
}