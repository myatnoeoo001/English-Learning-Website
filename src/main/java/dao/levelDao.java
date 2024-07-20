package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.level;

public class levelDao {

	public List<level> getAllLevelInfo() throws ClassNotFoundException,SQLException{
		ArrayList<level> list=new ArrayList<level>();
		MyConnection con=new MyConnection();
		Connection connect=con.getConnect();
		
		String query="select * from level";
		PreparedStatement pstm=connect.prepareStatement(query);
		
		ResultSet rs=pstm.executeQuery();
		
		while(rs.next()) {
			int levelId=rs.getInt(1);
			String Name=rs.getString(2);
			
			level obj=new level(levelId,Name);
			list.add(obj);
		}
		return list;
	}
}
