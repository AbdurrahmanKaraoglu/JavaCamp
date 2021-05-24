package javacamp3;

public class Instructor extends User{
	private String homework;
	private String course;
	public Instructor() {
		super();
	}
	public Instructor(String homework, String course) {
		super();
		this.homework = homework;
		this.course = course;
	}
	public String getHomework() {
		return homework;
	}
	public void setHomework(String homework) {
		this.homework = homework;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	

}
