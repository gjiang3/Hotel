
public class User {
	private String username;
	private String password;
	private String name;
	
	private String securityQuestion;
	private String answer;
	
	public User(String username, String password, String name, String securityQuestion, String answer){
		this.username = username;
		this.password = password;
		this.name = name;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getSecurtyQuestion(){
		return this.securityQuestion;
	}
	
	public String getAnswer(){
		return this.answer;
	}
	
}
