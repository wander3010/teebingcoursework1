package teebingcoursework1codemanagementjavapackage;

// start of code
public class User {
	protected String username;
	protected String password;
	protected String email;
	protected String language;

	public User() {}
	public User(String username, String password, String email, String language) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.language = language;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
// end of code
	
}
