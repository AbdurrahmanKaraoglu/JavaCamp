package javacamp3;

public class InstructorManager extends UserManager{
	@Override
	public void add(User user) {
		System.out.println("Eðitmen "+user.getFullName() + " kaydedildi.");
	}
	@Override
	public void addMultiple(User[] users) {
		for (User user : users) {
			add(user);
		}
	}
	@Override
	public void logIn(User user) {
		System.out.println("Eðitmen "+ user.getFullName() + " giriþ yaptý.");
	}
	@Override
	public void logOut(User user) {
		System.out.println("Eðitmen "+ user.getFullName() + " çýkýþ yaptý.");
	}
	
	public void addCourses(Instructor instructor) {
		System.out.println(instructor.getFullName()+ ", "+instructor.getCourse()+ " kursunu ekledi.");
	}
	
	public void addHomeworks(Instructor instructor) {
		System.out.println(instructor.getFullName()+ ", "+instructor.getHomework()+ " ödevini ekledi.");
	}
}
