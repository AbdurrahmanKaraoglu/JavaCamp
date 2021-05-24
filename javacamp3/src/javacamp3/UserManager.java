package javacamp3;

public class UserManager {
	public void add(User user) {
		System.out.println(user.getFullName() + " kaydedildi.");
	}

	public void addMultiple(User[] users) {
		for (User user : users) {
			add(user);
		}
	}
	
	public void logIn(User user) {
		System.out.println(user.getFullName() + " giriþ yaptý.");
	}
	
	public void logOut(User user) {
		System.out.println(user.getFullName() + " çýkýþ yaptý.");
	}
}
