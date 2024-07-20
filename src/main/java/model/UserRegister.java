package model;

public class UserRegister {
	 int userid;
	 String Name,Email,Password,Confirmpassword;
	 public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getConfirmpassword() {
		return Confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		Confirmpassword = confirmpassword;
	}
	
	public UserRegister(int userid, String name, String email, String password, String confirmpassword) {
		super();
		this.userid = userid;
		Name = name;
		Email = email;
		Password = password;
		Confirmpassword = confirmpassword;
	}
	public UserRegister() {
		
	}
}