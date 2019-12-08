package main;

import java.io.Serializable;

public class Personal implements Serializable{
	int id;
	String name;
	String sex;
	
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String toString(){
//		System.out.println("toString is operating");
		return id+name+sex;
	}
	public Personal(int id,String name,String sex){
		this.id=id;
		this.name=name;
		this.sex=sex;
	}

}
