package javacamp3;

public class User {
	private int id;
	private String userNumber;
	private String fullName;
	private String emailAddress;
	private String password;
	private String profilePicture;
	private String address;
	
	public User() {
		
	}

	public User(int id, String userNumber, String fullName, String emailAddress, String password, String profilePicture,
			String address) {
		super();
		this.id = id;
		this.userNumber = userNumber;
		this.fullName = fullName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.profilePicture = profilePicture;
		this.address = address;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
