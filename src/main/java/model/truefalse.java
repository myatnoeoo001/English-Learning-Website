package model;

public class truefalse {


	int trueFalseId;
	String Question,CorrectAnswer;
	int readingId;
	
	public int getTrueFalseId() {
		return trueFalseId;
	}
	public void setTrueFalseId(int trueFalseId) {
		this.trueFalseId = trueFalseId;
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
	public int  getReadinId() {
		return readingId;
	}
	public void setReadinId(int readinId) {
		this.readingId = readinId;
	}
	
	public truefalse(int id,String question,String correctanswer,int readingid) {
		super();
		trueFalseId=id;
		Question=question;
		CorrectAnswer=correctanswer;
		readingId=readingid;
	}
	public truefalse(int trueFalseId, String question, String correctAnswer) {
		super();
		this.trueFalseId = trueFalseId;
		Question = question;
		CorrectAnswer = correctAnswer;
	}
	
	
}
