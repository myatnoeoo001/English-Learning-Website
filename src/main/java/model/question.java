package model;

public class question {
	private int qid;
	private String txt;
	private String one,two,three,four,ans;
	public question() {
		
	}
	public question(int qid, String txt, String one, String two, String three, String four, String ans) {
		super();
		this.qid = qid;
		this.txt = txt;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.ans = ans;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public String getOne() {
		return one;
	}
	public void setOne(String one) {
		this.one = one;
	}
	public String getTwo() {
		return two;
	}
	public void setTwo(String two) {
		this.two = two;
	}
	public String getThree() {
		return three;
	}
	public void setThree(String three) {
		this.three = three;
	}
	public String getFour() {
		return four;
	}
	public void setFour(String four) {
		this.four = four;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	
}
