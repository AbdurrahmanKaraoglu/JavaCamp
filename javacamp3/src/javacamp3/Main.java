package javacamp3;


public class Main {

	public static void main(String[] args) {
		Instructor instructor = new Instructor();
		instructor.setId(1);
		instructor.setFullName("Engin Demirog");
		instructor.setEmailAddress("deneme@hotmail.com");
		instructor.setPassword("deneme");
		instructor.setUserNumber("1111");
		instructor.setAddress("denemeadresi1");
		instructor.setProfilePicture("resim1");
		instructor.setCourse("Java");
		instructor.setHomework("3.Gün");
		
		Student student = new Student();
		student.setId(2);
		student.setFullName("Abdurrahman Karaoglu");
		student.setEmailAddress("deneme2@hotmail.com");
		student.setPassword("deneme2");
		student.setUserNumber("2222");
		student.setAddress("denemeadresi1");
		student.setProfilePicture("resim2");
		
		StudentManager studentManager = new StudentManager();	
		InstructorManager instructorManager = new InstructorManager();
		
		
		Instructor[] instructors = {instructor};		
		instructorManager.addMultiple(instructors);
		instructorManager.logIn(instructor);
		instructorManager.addCourses(instructor);
		instructorManager.addHomeworks(instructor);
		
		System.out.println("--------------------");
		
		Student[] students = {student};
		studentManager.addMultiple(students);
		studentManager.logIn(student);
		studentManager.rollCall(student);
		
	}

}
