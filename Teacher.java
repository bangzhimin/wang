package main;

import java.io.Serializable;

public class Teacher extends Personal implements Serializable {
	Course course;
	public String toString(){
		System.out.println("teather toString is operating");
		return id+name+sex+course;
	}
	public Teacher(int id, String name, String sex,Course course) {
		super(id, name, sex);
		this.course=course;
	}

}
