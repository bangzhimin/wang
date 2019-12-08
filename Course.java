package main;

import java.io.Serializable;

public class Course implements Serializable{
	int id;
	String name;
	String place;
	int time;
	int mark;
	
	public String toString(){
//		System.out.println("Course toString is operating");
		return id+","+name+","+place+","+time+","+mark;
	}
	public Course(int id,String name,String place,int time,int mark){
		this.id=id;
		this.name=name;
		this.place=place;
		this.time=time;
		this.mark=mark;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
}
