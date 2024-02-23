package models;

public class Bookmark {
	public Bookmark() {
		super();
	}
	public Bookmark(int bookmark_ID, int topic_ID, int user_ID) {
		this.bookmark_ID = bookmark_ID;
		this.topic_ID = topic_ID;
		this.user_ID = user_ID;
	}
	public Bookmark(int topic_ID, int user_ID) {
		this.topic_ID = topic_ID;
		this.user_ID = user_ID;
	}
	public Bookmark(int bookmark_ID, int topic_ID, int user_ID,String topic_name,String topic_description) {
		this.bookmark_ID = bookmark_ID;
		this.topic_ID = topic_ID;
		this.user_ID = user_ID;
		this.topic_name = topic_name;
		this.topic_description = topic_description;
	}
	
	
int bookmark_ID;
int topic_ID;
int user_ID;
String topic_name;
String topic_description;

public String getTopic_name() {
	return topic_name;
}
public void setTopic_name(String topic_name) {
	this.topic_name = topic_name;
}
public String getTopic_description() {
	return topic_description;
}
public void setTopic_description(String topic_description) {
	this.topic_description = topic_description;
}





public int getBookmark_ID() {
	return bookmark_ID;
}
public void setBookmark_ID(int bookmark_ID) {
	this.bookmark_ID = bookmark_ID;
}
public int getTopic_ID() {
	return topic_ID;
}
public void setTopic_ID(int topic_ID) {
	this.topic_ID = topic_ID;
}
public int getUser_ID() {
	return user_ID;
}
public void setUser_ID(int user_ID) {
	this.user_ID = user_ID;
}
}
