package models;

public class Complaint {

	public Complaint() {
		super();
	}
	public Complaint(int complaint_ID, String complaint_subject,String complaint_description) {
		this.complaint_ID = complaint_ID;
		this.complaint_subject = complaint_subject;
		this.complaint_description = complaint_description;
	}
	public Complaint(String complaint_subject,String complaint_description) {
		this.complaint_subject = complaint_subject;
		this.complaint_description = complaint_description;
	}
	
	

int complaint_ID;
String complaint_subject;
String complaint_description;
public int getComplaint_ID() {
	return complaint_ID;
}
public void setComplaint_ID(int complaint_ID) {
	this.complaint_ID = complaint_ID;
}
public String getComplaint_subject() {
	return complaint_subject;
}
public void setComplaint_subject(String complaint_subject) {
	this.complaint_subject = complaint_subject;
}
public String getComplaint_description() {
	return complaint_description;
}
public void setComplaint_description(String complaint_description) {
	this.complaint_description = complaint_description;
}




}
