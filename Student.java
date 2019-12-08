package main;

import java.io.Serializable;

public class Student extends Personal implements Serializable{

	private Course course;
	private String teather;
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getTeather() {
		return teather;
	}
	public void setTeather(String teather) {
		this.teather = teather;
	}
	public String toString(){
//		System.out.println("Student toString is operating");
		return id+name+sex+course+teather;
	}

	public Student(int id, String name, String sex,Course course,Teacher teather) {
		super(id, name, sex);
		this.course=course;
		this.teather=teather.name;
	}
	public Course delete() {
		return course=null;
	}
	public void putcourse(){
		if(course==null){
			System.out.println("Not to choose course");
		}else{
		this.toString();
		}
	}

}
