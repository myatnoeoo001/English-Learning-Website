package model;

import com.mysql.cj.jdbc.Blob;

public class reading {


	int readingId;
	String Title,Description;
	java.sql.Blob Paragraph;
	int levelId;
	public int getReadingId() {
		return readingId;
	}
	public void setReadingId(int readingId) {
		this.readingId = readingId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public java.sql.Blob getParagraph() {
		return Paragraph;
	}
	public void setParagraph(Blob paragraph) {
		Paragraph = paragraph;
	}
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	
	public reading(int readingid,String title,String description,java.sql.Blob paragraph2,int levelid) {
		super();
		readingId=readingid;
		Title=title;
		Description=description;
		Paragraph=paragraph2;
		levelId=levelid;
	}
	
	public reading(int readingid,String title,String description,java.sql.Blob paragraph2) {
		super();
		readingId=readingid;
		Title=title;
		Description=description;
		Paragraph=paragraph2;
		
	}
}
