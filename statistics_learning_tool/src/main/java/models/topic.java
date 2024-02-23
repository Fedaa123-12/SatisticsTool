package models;

public class topic {
	public topic
	(int topic_ID, String topic_name, String topic_description, String topic_media_link ) {
		super();
		this.topic_ID = topic_ID; 
		this.topic_name = topic_name; 
		this.topic_description = topic_description;
		this.topic_media_link = topic_media_link;
	}
	
	public topic
	(String topic_name, String topic_description, String topic_media_link ) {
		this.topic_name = topic_name; 
		this.topic_description = topic_description;
		this.topic_media_link = topic_media_link;
	}
	
	public topic() {
		super();
		}
	
	
	
	
	int topic_ID; 
	String topic_name; 
	String topic_description;
	String topic_media_link;
	
	
	public int getTopic_ID() {
		return topic_ID;
	}

	public void setTopic_ID(int topic_ID) {
		this.topic_ID = topic_ID;
	}

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

	public String getTopic_media_link() {
		return topic_media_link;
	}

	public void setTopic_media_link(String topic_media_link) {
		this.topic_media_link = topic_media_link;
	}




	
}
