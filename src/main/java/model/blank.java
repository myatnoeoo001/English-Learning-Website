package model;

public class blank {

	int blankId;
	String Question,CorrectAnswer;
	int readingId;
	
	public int getBlankId() {
		return blankId;
	}
	public void setBlankId(int blankId) {
		this.blankId = blankId;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getCorrectAnswer() {
		return CorrectAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		CorrectAnswer = correctAnswer;
	}
	public int getReadingId() {
		return readingId;
	}
	public void setReadingId(int readingId) {
		this.readingId = readingId;
	}
	
	public blank(int blankid,String question,String correctanswer,int readingid) {
		super();
		blankId=blankid;
		Question=question;
		CorrectAnswer=correctanswer;
		readingId=readingid;
	}
	public blank(int blankId, String question, String correctAnswer) {
		super();
		this.blankId = blankId;
		Question = question;
		CorrectAnswer = correctAnswer;
	}
	
}
