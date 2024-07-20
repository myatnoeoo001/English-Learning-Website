package model;

public class choice {


	int choiceId;
	String Question,Option1,Option2,Option3,Option4,CorrectAnswer;
	int readingId;
	
	public int getChoiceId() {
		return choiceId;
	}

	public void setChoiceId(int choiceId) {
		this.choiceId = choiceId;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
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

	public int getReadingId() {
		return readingId;
	}

	public void setReadingId(int readingId) {
		this.readingId = readingId;
	}

	public choice(int choiceid,String question,String option1,String  option2,String option3,String option4,String correctanswer,int readingid) {
		  super();
		  choiceId=choiceid;
		  Question =question;
		  Option1=option1;
		  Option2=option2;
		  Option3=option3;
		  Option4=option4;
		  CorrectAnswer=correctanswer;
		  readingId=readingid;
		}

	public choice(int choiceId, String question, String option1, String option2, String option3, String option4,
			String correctAnswer) {
		super();
		this.choiceId = choiceId;
		Question = question;
		Option1 = option1;
		Option2 = option2;
		Option3 = option3;
		Option4 = option4;
		CorrectAnswer = correctAnswer;
	}
	
}
