package javacamp3;

public class InstructorManager extends UserManager{
	@Override
	public void add(User user) {
		System.out.println("E�itmen "+user.getFullName() + " kaydedildi.");
	}
	@Override
	public void addMultiple(User[] users) {
		for (User user : users) {
			add(user);
		}
	}
	@Override
	public void logIn(User user) {
		System.out.println("E�itmen "+ user.getFullName() + " giri� yapt�.");
	}
	@Override
	public void logOut(User user) {
		System.out.println("E�itmen "+ user.getFullName() + " ��k�� yapt�.");
	}
	
	public void addCourses(Instructor instructor) {
		System.out.println(instructor.getFullName()+ ", "+instructor.getCourse()+ " kursunu ekledi.");
	}
	
	public void addHomeworks(Instructor instructor) {
		System.out.println(instructor.getFullName()+ ", "+instructor.getHomework()+ " �devini ekledi.");
	}
}
