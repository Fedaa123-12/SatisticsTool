package models;

public class Homework {
	public Homework() {
		super();
	}
	
	public Homework(int homework_ID,int topic_ID,int class_ID,String homework_title,String homework_description) {
		 this.homework_ID = homework_ID;
		 this.topic_ID = topic_ID;
		 this.class_ID = class_ID;
		 this.homework_title = homework_title;
		 this.homework_description = homework_description;
	}
	
	public Homework(int topic_ID,int class_ID,String homework_title,String homework_description) {
		 this.topic_ID = topic_ID;
		 this.class_ID = class_ID;
		 this.homework_title = homework_title;
		 this.homework_description = homework_description;
	}
	
	int homework_ID;
	int topic_ID;
	int class_ID;
	
	
	
	public Homework(String topic_name,String homework_title,String homework_description) {
		 this.topic_name = topic_name;
		 this.homework_title = homework_title;
		 this.homework_description = homework_description;
	}
	
	//to create Arrays for user's homework 
	String topic_name;
	String homework_title;
	String homework_description;
	
	
	
	
	
	
	
	
	
	
	
	
	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

	
	
	public int getHomework_ID() {
		return homework_ID;
	}
	public void setHomework_ID(int homework_ID) {
		this.homework_ID = homework_ID;
	}
	public int getTopic_ID() {
		return topic_ID;
	}
	public void setTopic_ID(int topic_ID) {
		this.topic_ID = topic_ID;
	}
	public int getClass_ID() {
		return class_ID;
	}
	public void setClass_ID(int class_ID) {
		this.class_ID = class_ID;
	}
	public String getHomework_title() {
		return homework_title;
	}
	public void setHomework_title(String homework_title) {
		this.homework_title = homework_title;
	}
	public String getHomework_description() {
		return homework_description;
	}
	public void setHomework_description(String homework_description) {
		this.homework_description = homework_description;
	}
}
