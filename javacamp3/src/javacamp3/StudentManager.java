package javacamp3;

public class StudentManager extends UserManager{
	@Override
	public void add(User user) {
		System.out.println("Öðrenci "+user.getFullName() + " kaydedildi.");
	}
	@Override
	public void addMultiple(User[] users) {
		for (User user : users) {
			add(user);
		}
	}
	@Override
	public void logIn(User user) {
		System.out.println("Öðrenci "+user.getFullName() + " giriþ yaptý.");
	}
	@Override
	public void logOut(User user) {
		System.out.println("Öðrenci "+user.getFullName() + " çýkýþ yaptý.");
	}
	
	public void rollCall(User user) {
		System.out.println("Öðrenci "+user.getFullName() + " yoklamasý alýndý.");
	}
}
