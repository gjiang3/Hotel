
public class User {
	private String username;
	private String password;
	private String lastName;
	private String firstName;
	private String userRole;
	private int age;
	private String gender;
	private String securityQuestion;
	private String answer;
	
	public User(String username, String password, String firstName, String lastName, String userRole, int age, String gender, 
			String securityQuestion, String answer){
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.userRole = userRole;
		this.age = age;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	
	public String getSecurtyQuestion(){
		return this.securityQuestion;
	}
	
	public String getAnswer(){
		return this.answer;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getUserRole() {
		return userRole;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}
	
	public String toString(){
		return username + "  " + firstName + "  " + lastName + "  " + userRole + "  " + age + "  " + gender;
	}

}
