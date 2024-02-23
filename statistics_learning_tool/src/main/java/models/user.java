package models;


import java.sql.Date;

public class user {
   public user(int user_ID, String email, String username, String first_name, String second_name,
			String password, Date DOB, String access_level) {
		super();
		this.user_ID = user_ID;
		this.email = email;
		this.username = username;
		this.first_name = first_name;
		this.second_name = second_name;
		this.password = password;
		this.DOB = DOB;
		this.access_level = access_level;
	}
   public user(int user_ID, String email, String username, String first_name, String second_name,
			String password, Date DOB) {
		super();
		this.user_ID = user_ID;
		this.email = email;
		this.username = username;
		this.first_name = first_name;
		this.second_name = second_name;
		this.password = password;
		this.DOB = DOB;
	}
   
   public user(String email, String username, String first_name, String second_name,
			String password, Date DOB, String access_level) {
		this.email = email;
		this.username = username;
		this.first_name = first_name;
		this.second_name = second_name;
		this.password = password;
		this.DOB = DOB;
		this.access_level = access_level;
	}
   
   public user(String email, String first_name, String second_name, Date DOB) {
		this.email = email;
		this.first_name = first_name;
		this.second_name = second_name;
		this.DOB = DOB;
	}
   public user(String email, String username, String first_name, String second_name) {
		this.email = email;
		this.username = username;
		this.first_name = first_name;
		this.second_name = second_name;;
	}
   
   
   public user(String email,String password) {
	   this.email = email;
	   this.password = password;
	} 
   
public user() {
	super();
}


int user_ID;
String email; 
String username; 
String first_name; 
String second_name;
String password;
Date DOB; 
String access_level;

public int getUser_ID() {
	return user_ID;
}

public void setUser_ID(int user_ID) {
	this.user_ID = user_ID;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getFirst_name() {
	return first_name;
}

public void setFirst_name(String first_name) {
	this.first_name = first_name;
}

public String getSecond_name() {
	return second_name;
}

public void setSecond_name(String second_name) {
	this.second_name = second_name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Date getDOB() {
	return DOB;
}

public void setDOB(Date dOB) {
	DOB = dOB;
}

public String getAccess_level() {
	return access_level;
}

public void setAccess_level(String access_level) {
	this.access_level = access_level;
}





//@Override
//public String toString() {
//	return "Film [id=" + id + ", title=" + title + ", year=" + year
//			+ ", director=" + director + ", stars=" + stars + ", review="
//			+ review + "]";
//}   
}