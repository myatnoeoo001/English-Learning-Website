package model;

import com.mysql.cj.jdbc.Blob;

public class leveltest {
	
	int levelTestId;
	Blob Paragraph;
	String MCQuestion,Option1,Option2,Option3,Option4,CorrectAnswer,TFQuestion,TFCorrectAnswer,BQuestion,BCorrectAnswer;
	int levelId;
	public int getLevelTestId() {
		return levelTestId;
	}
	public void setLevelTestId(int levelTestId) {
		this.levelTestId = levelTestId;
	}
	public Blob getParagraph() {
		return Paragraph;
	}
	
	public void setParagraph(Blob paragraph) {
		Paragraph = paragraph;
	}
	public String getMCQuestion() {
		return MCQuestion;
	}
	public void setMCQuestion(String mCQuestion) {
		MCQuestion = mCQuestion;
	}
	public String getOption1() {
		return Option1;
	}
	public void setOption1(String option1) {
		Option1 = option1;
	}
	public String getOption2() {
		return Option2;
	}
	public void setOption2(String option2) {
		Option2 = option2;
	}
	public String getOption3() {
		return Option3;
	}
	public void setOption3(String option3) {
		Option3 = option3;
	}
	public String getOption4() {
		return Option4;
	}
	public void setOption4(String option4) {
		Option4 = option4;
	}
	public String getCorrectAnswer() {
		return CorrectAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		CorrectAnswer = correctAnswer;
	}
	public String getTFQuestion() {
		return TFQuestion;
	}
	public void setTFQuestion(String tFQuestion) {
		TFQuestion = tFQuestion;
	}
	public String getTFCorrectAnswer() {
		return TFCorrectAnswer;
	}
	public void setTFCorrectAnswer(String tFCorrectAnswer) {
		TFCorrectAnswer = tFCorrectAnswer;
	}
	public String getBQuestion() {
		return BQuestion;
	}
	public void setBQuestion(String bQuestion) {
		BQuestion = bQuestion;
	}
	public String getBCorrectAnswer() {
		return BCorrectAnswer;
	}
	public void setBCorrectAnswer(String bCorrectAnswer) {
		BCorrectAnswer = bCorrectAnswer;
	}
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public leveltest(int leveltestId,String MCQuestion,String Option1,String Optionn2,String Option3,String Option4,
			String CorrectAnswer,String TFQuestion,String TFCorrectAnswer,String BQuestion,String BCorrectAnswer,int levelId) {
		super();
		this.levelTestId=leveltestId;
		this.MCQuestion=MCQuestion;
		this.Option1=Option1;
		this.Option2=Option2;
		this.Option3=Option3;
		this.Option4=Option4;
		this.TFQuestion=TFQuestion;
		this.TFCorrectAnswer=TFCorrectAnswer;
		this.BQuestion=BQuestion;
		this.BCorrectAnswer=BCorrectAnswer;
		this.levelId=levelId;
	}
	public leveltest(Blob paragraph, String mCQuestion, String option1, String option2, String option3, String option4,
			String correctAnswer, String tFQuestion, String tFCorrectAnswer, String bQuestion, String bCorrectAnswer,
			int levelId) {
		super();
		Paragraph = paragraph;
		MCQuestion = mCQuestion;
		Option1 = option1;
		Option2 = option2;
		Option3 = option3;
		Option4 = option4;
		CorrectAnswer = correctAnswer;
		TFQuestion = tFQuestion;
		TFCorrectAnswer = tFCorrectAnswer;
		BQuestion = bQuestion;
		BCorrectAnswer = bCorrectAnswer;
		this.levelId = levelId;
	}
	
	
}

