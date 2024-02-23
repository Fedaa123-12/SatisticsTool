package models;

public class Class_member {
	public Class_member() {
		super();
	}
	
	public Class_member(int class_ID, String email) {
		this.class_ID = class_ID;
		this.email = email;
	}
	
	
	int class_ID;
	String email;
	
	
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
}
