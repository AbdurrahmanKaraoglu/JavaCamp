package layeredE_commerceBackend.entities.concretes;

import layeredE_commerceBackend.entities.abstracts.Entity;

public class SignUpWithGoogle implements Entity{
	private String email;
	private String password;
	public SignUpWithGoogle(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
