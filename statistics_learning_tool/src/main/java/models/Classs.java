package models;

public class Classs {
	public Classs() {
		super();
	}
	
	public Classs(int class_ID,String email,String class_name) {
		this.class_ID = class_ID;
		this.email = email;
		this.class_name = class_name;
	}
	
	public Classs(String email,String class_name) {
		this.email = email;
		this.class_name = class_name;
	}
	
	
	
	int class_ID;
	String email;
	String class_name;
	
	public int getClass_ID() {
		return class_ID;
	}
	public void setClass_ID(int class_ID) {
		this.class_ID = class_ID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
}
