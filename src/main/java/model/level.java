package model;

public class level {


	int levelId;
	String Name;
	
	public level(int levelid,String name) {
		  super();
		 levelId=levelid;
		 Name=name;
		}
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
}
