package model;

public class UserLogin {
	int userId;
	String Name,Email,Password;
	int levelId;
	public UserLogin() {
		
	}
	public UserLogin(int userId, String name, String email, String password, int levelId) {
		super();
		this.userId = userId;
		Name = name;
		Email = email;
		Password = password;
		this.levelId = levelId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
}
