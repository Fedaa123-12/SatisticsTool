package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import models.Bookmark;
import models.Class_member;
import models.Classs;
import models.Complaint;
import models.Homework;
import models.topic;
import models.user;

public class learning_tool_DAO {
	user one_user = null;
	topic one_topic = null;
	Classs one_class = null;
	Class_member one_member = null;
	Homework one_Homework = null;
	Bookmark one_Bookmark = null;
	Complaint one_Complaint = null;
	Connection conn = null;
    Statement stmt = null;
	String user = "chamatfe";
    String password = "worgFlew3";
    // Note none default port used, 6306 not 3306
    String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/"+user;

	public learning_tool_DAO() {}

	public void getUser() {
		System.out.println(user + password + " " + url);
	}
	private void openConnection(){
		// loading jdbc driver for mysql
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(Exception e) { System.out.println(e); }

		// connecting to database
		try{
			// connection string for demos database, username demos, password demos
 			conn = DriverManager.getConnection(url, user, password);
		    stmt = conn.createStatement();
		} catch(SQLException se) { System.out.println(se); }	   
    }
	private void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	//-----------------------------USERS-----------------------------//
	
	private user getNextUser(ResultSet rs){
    	user thisUser=null;
		try {
			thisUser = new user(
					rs.getInt("user_ID"),
					rs.getString("email"),
					rs.getString("username"),
					rs.getString("first_name"),
					rs.getString("second_name"),
					rs.getString("password"),
					rs.getDate("DOB"),
					rs.getString("access_level"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return thisUser;		
	}
	
	private user getNextStudent(ResultSet rs){
    	user thisUser=null;
		try {
			thisUser = new user(
					rs.getString("email"),
					rs.getString("username"),
					rs.getString("first_name"),
					rs.getString("second_name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return thisUser;		
	}
	
	public void insertUser(user u) throws SQLException {
		try {
			openConnection();
			
			String insertSql = "insert into users (email,username,first_name,second_name,password,DOB,access_level) values "
			+ "('" + u.getEmail() + "','" + u.getUsername() + "','" + u.getFirst_name() + "','"  
					+ u.getSecond_name()+ "','" +u.getPassword()+ "','" + u.getDOB() + "','" 
			+ u.getAccess_level()  +"');";
			
			System.out.print(insertSql);
			stmt.executeUpdate(insertSql);
			stmt.close();
			closeConnection();
		} catch (SQLException s) {
			throw new SQLException(s);
		}
	}
	
	public Boolean authenticateUser(user u) throws SQLException {
		
		openConnection();
		String sqlQuery = "Select * from users where email='"+ u.getEmail() 
										  + "' AND password ='" + u.getPassword() + "'";
		ResultSet rs = stmt.executeQuery(sqlQuery);
		
		if(rs.next()) {
			closeConnection();
			return true;
		}
		else {
			closeConnection();
			return false;
		}
	}
	
		
	
	public user getUserAccessLevel(user u) throws SQLException {
		
		openConnection();
		one_user = null;
		String sqlQuery = "Select * from users where email='"+ u.getEmail() 
										  + "' AND password ='" + u.getPassword() + "'";
		ResultSet rs = stmt.executeQuery(sqlQuery);
		
		while(rs.next()) {
			one_user = getNextUser(rs);
		}
		closeConnection();
		return one_user;	
	}
	
	
	public Boolean checkResetDetails(user u) throws SQLException {
		
		openConnection();
		String sqlQuery = "Select * from users where email='"+ u.getEmail() 
										  + "' AND first_name ='" + u.getFirst_name() 
										  + "' AND second_name ='" + u.getSecond_name()
										  + "' AND DOB ='" + u.getDOB() + "'";
		
		ResultSet rs = stmt.executeQuery(sqlQuery);
		
		
		if(rs.next()) {
			closeConnection();
			return true;
		}
		else {
			closeConnection();
			return false;
		}
	}
	
	
	public user getUserLostDetail(user u) throws SQLException {
		
		openConnection();
		one_user = null;
		String sqlQuery = "Select * from users where email='"+ u.getEmail() 
										  + "' AND DOB ='" + u.getDOB() + "'";
		ResultSet rs = stmt.executeQuery(sqlQuery);
		
		while(rs.next()) {
			one_user = getNextUser(rs);
		}
		closeConnection();
		return one_user;	
	}
	
	public void updatePassword(String email, String password) throws SQLException {
		try {
			openConnection();
			
			String insertSql = "update users set password = '"+ password  + "' where email = '" +email  +"'" ;

			stmt.executeUpdate(insertSql);
			stmt.close();
			closeConnection();
		} catch (SQLException s) {
			throw new SQLException(s);
		}
	}
	
	
	  public ArrayList<user> getAllUsers(){
		   
			ArrayList<user> allUsers = new ArrayList<user>();
			openConnection();
			
			
		    // Create select statement and execute it
			try{
			    String selectSQL = "select * from users WHERE access_level != 'Admin'";
			    ResultSet rs = stmt.executeQuery(selectSQL);
		    // Retrieve the results
			    while(rs.next()){
			    	one_user = getNextUser(rs);
			    	allUsers.add(one_user);
			   }

			    stmt.close();
			    closeConnection();
			} catch(SQLException se) { System.out.println(se); }

		   return allUsers;
	   }
	  
	  public ArrayList<user> getAllStudents(){
		   
			ArrayList<user> allUsers = new ArrayList<user>();
			openConnection();
			
			
		    // Create select statement and execute it
			try{
			    String selectSQL = "select email,username,first_name,second_name from users WHERE access_level = 'Student'\r\n"
			    		+ "AND email NOT IN(select email from class_members)";
			    ResultSet rs = stmt.executeQuery(selectSQL);
		    // Retrieve the results
			    while(rs.next()){
			    	one_user = getNextStudent(rs);
			    	allUsers.add(one_user);
			   }

			    stmt.close();
			    closeConnection();
			} catch(SQLException se) { System.out.println(se); }

		   return allUsers;
	   }
	  
	  
	  public void deleteUser(int ID) throws SQLException {
		  openConnection();
		  
		  
		  String selectSQL = "Delete from users where user_ID = '"+ ID + "'";
		  stmt.executeUpdate(selectSQL);
		  stmt.close();
		  closeConnection();
	  }
	  
	  
	  public void updateUser(user u) throws SQLException {
		  openConnection();
		  
		  
		  String updateQuery = "update users "
		  		+ "set "
		  		+ "email = '" + u.getEmail() +"',"
		  		+ "username = '"+ u.getUsername() +"',"
		  		+ "first_name = '"+ u.getFirst_name() +"',"
		  		+ "second_name = '"+ u.getSecond_name() +"',"
		  		+ "password = '"+ u.getPassword() +"',"
		  		+ "DOB = '"+ u.getDOB() +"',"
		  		+ "access_level = '"+ u.getAccess_level() +"' "
		  		+ "where user_ID =" + u.getUser_ID();
		  stmt.executeUpdate(updateQuery);
		  stmt.close();
		  closeConnection();
	  }
	  
	  public void userUpdateAccount(user u) throws SQLException {
		  openConnection();
		  
		  
		  String updateQuery = "update users "
		  		+ "set "
		  		+ "email = '" + u.getEmail() +"',"
		  		+ "username = '"+ u.getUsername() +"',"
		  		+ "first_name = '"+ u.getFirst_name() +"',"
		  		+ "second_name = '"+ u.getSecond_name() +"',"
		  		+ "password = '"+ u.getPassword() +"',"
		  		+ "DOB = '"+ u.getDOB() +"' "
		  		+ "where user_ID =" + u.getUser_ID();
		  stmt.executeUpdate(updateQuery);
		  stmt.close();
		  closeConnection();
	  }
	  
	  
	  public user getUserByID(int id){
		   
			openConnection();
			try{
			    String selectSQL = "select * from users where user_id="+id;
			    ResultSet rs = stmt.executeQuery(selectSQL);
			    while(rs.next()){
			    	one_user = getNextUser(rs);
			    }

			    stmt.close();
			    closeConnection();
			} catch(SQLException se) { System.out.println(se); }

		   return one_user;
	   }
	
	
	//-----------------------------Topics-----------------------------//
	  private topic getNextTopic(ResultSet rs){
	    	topic thisTopic=null;
			try {
				thisTopic = new topic(
						rs.getInt("topic_ID"),
						rs.getString("topic_name"),
						rs.getString("topic_description"),
						rs.getString("topic_media_link"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return thisTopic;		
		}
	  
	  
	  public ArrayList<topic> getAllTopics(){
		   
			ArrayList<topic> allTopics = new ArrayList<topic>();
			openConnection();
			
			
		    // Create select statement and execute it
			try{
			    String selectSQL = "select * from topics";
			    ResultSet rs = stmt.executeQuery(selectSQL);
		    // Retrieve the results
			    while(rs.next()){
			    	one_topic = getNextTopic(rs);
			    	allTopics.add(one_topic);
			   }

			    stmt.close();
			    closeConnection();
			} catch(SQLException se) { System.out.println(se); }

		   return allTopics;
	   }
	  
	  
	  public ArrayList<topic> getTopicBySearch(String input){
		   
			ArrayList<topic> allTopics = new ArrayList<topic>();
			openConnection();
			
			
		    // Create select statement and execute it
			try{
			    String selectSQL = "select * from topics WHERE topic_name LIKE '%" + input + "%'" ;
			   
			    ResultSet rs1 = stmt.executeQuery(selectSQL);
		    // Retrieve the results
			    while(rs1.next()){
			    	one_topic = getNextTopic(rs1);
			    	allTopics.add(one_topic);
			   }

			    stmt.close();
			    closeConnection();
			} catch(SQLException se) { System.out.println(se); }

		   return allTopics;
	  }
	  
	  
	  public topic getTopicByID(int id){
		   
			openConnection();
			try{
			    String selectSQL = "select * from topics where topic_ID="+id;
			    ResultSet rs = stmt.executeQuery(selectSQL);
			    while(rs.next()){
			    	one_topic = getNextTopic(rs);
			    }

			    stmt.close();
			    closeConnection();
			} catch(SQLException se) { System.out.println(se); }

		   return one_topic;
	   }
	  
	  
	  
	  public void deleteTopic(int ID) throws SQLException {
		  openConnection();
		  String selectSQL = "Delete from topics where topic_ID = '"+ ID + "'";
		  stmt.executeUpdate(selectSQL);
		  stmt.close();
		  closeConnection();
	  }
	  
	  public void insertTopic(topic u) throws SQLException {
			try {
				openConnection();
				
				String insertSql = "insert into topics (topic_name,topic_description,topic_media_link) values "
				+ "('" + u.getTopic_name() + "','" + u.getTopic_description() + "','" + u.getTopic_media_link() +"');";  

				stmt.executeUpdate(insertSql);
				stmt.close();
				closeConnection();
			} catch (SQLException s) {
				throw new SQLException(s);
			}
		}
	  
	  
//-----------------------------Classes-----------------------------//
	  
	  
	  private Classs getNextClass(ResultSet rs){
		  	Classs thisClass=null;
			try {
				thisClass = new Classs(
						rs.getInt("class_ID"),
						rs.getString("email"),
						rs.getString("class_name"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return thisClass;		
		}
	  
	  public ArrayList<Classs> getAllClasses(String email){
		   
			ArrayList<Classs> allClasses = new ArrayList<Classs>();
			openConnection();
			
			
		    // Create select statement and execute it
			try{
			    String selectSQL = "select * from classes WHERE email = '" + email + "';";
			    ResultSet rs = stmt.executeQuery(selectSQL);
		    // Retrieve the results
			    while(rs.next()){
			    	one_class = getNextClass(rs);
			    	allClasses.add(one_class);
			   }

			    stmt.close();
			    closeConnection();
			} catch(SQLException se) { System.out.println(se); }

		   return allClasses;
	   }
	  
	  public void insertTeacherMadeClass(Classs C) throws SQLException {
			try {
				openConnection();
				
				String insertSql = "insert into classes (email,class_name) values "
				+ "('" + C.getEmail() + "','" + C.getClass_name() + "')";  
				stmt.executeUpdate(insertSql);
				stmt.close();
				closeConnection();
			} catch (SQLException s) {
				throw new SQLException(s);
			}
		}
	  
	  public void deleteClass(int ID) throws SQLException {
		  openConnection();
		  String selectSQL = "Delete from classes where class_ID = '"+ ID + "'";
		  stmt.executeUpdate(selectSQL);
		  stmt.close();
		  closeConnection();
	  }
	  
	  
	//-----------------------------Class Members-----------------------------//
	  
	  
	  
	  private Class_member getNextClass_member(ResultSet rs){
		  Class_member thisClass=null;
			try {
				thisClass = new Class_member(
						rs.getInt("class_ID"),
						rs.getString("email"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return thisClass;		
		}
	  
	  public ArrayList<Class_member> getAllClass_members(int ID){
		   
			ArrayList<Class_member> allClass_members = new ArrayList<Class_member>();
			openConnection();
			
			
		    // Create select statement and execute it
			try{
			    String selectSQL = "select * from class_members WHERE class_ID = '" + ID + "';";
			    ResultSet rs = stmt.executeQuery(selectSQL);
		    // Retrieve the results
			    while(rs.next()){
			    	one_member = getNextClass_member(rs);
			    	allClass_members.add(one_member);
			   }

			    stmt.close();
			    closeConnection();
			} catch(SQLException se) { System.out.println(se); }

		   return allClass_members;
	   }
	  
	  
	  public void deleteFromClass_members(int ID) throws SQLException {
		  openConnection();
		  String selectSQL = "Delete from class_members where class_ID = '"+ ID + "'";
		  stmt.executeUpdate(selectSQL);
		  stmt.close();
		  closeConnection();
	  }
	  
	  
	  public void addStudentToClass(int class_ID, String Email)throws SQLException{
		  try {
				openConnection();
				
				String insertSql = "insert into class_members (class_ID,email) values "
				+ "('" + class_ID + "','" + Email + "')";  

				stmt.executeUpdate(insertSql);
				stmt.close();
				closeConnection();
			} catch (SQLException s) {
				throw new SQLException(s);
			}
	  }
	  
	  
	  public void deleteClass_member(String email) throws SQLException {
		  openConnection();
		  String selectSQL = "Delete from class_members where email = '"+ email + "'";
		  stmt.executeUpdate(selectSQL);
		  stmt.close();
		  closeConnection();
	  }
	  
	  
	  public boolean checkIfUserInClass(String email) throws SQLException {
		  openConnection();
		  String selectSql=  "SELECT c.email,c.class_ID,cl.class_name from class_members c "
		  + "INNER JOIN classes cl "
		  + "on cl.class_ID = c.class_ID "
		  + "where c.email = '" + email+ "';";
			ResultSet rs = stmt.executeQuery(selectSql);
			
			if(rs.next()) {
				stmt.close();
				closeConnection();
				return true;
				
			}
			else {
				closeConnection();
				return false;
			}
	  }
	  
	  
	  
	  public ArrayList<String> getClassUserIN(String email) throws SQLException {
		  openConnection();
		  String selectSql=  "SELECT c.email,c.class_ID,cl.class_name from class_members c "
		  + "INNER JOIN classes cl "
		  + "on cl.class_ID = c.class_ID "
		  + "where c.email = '" + email+ "'";
		  
			ResultSet rs = stmt.executeQuery(selectSql);
			ResultSetMetaData rsmd = rs.getMetaData(); 
			int colCount = rsmd.getColumnCount();
			
		  ArrayList<String> allClassEnt = new ArrayList<>(colCount);
		 	
		  while (rs.next()) {              
			   int i = 1;
			   while(i <= colCount) {
				   allClassEnt.add(rs.getString(i++));
			   }
		  }
		  
		  closeConnection();
		  stmt.close();
		  return allClassEnt;	
	  }
	  
	  
	  
	  private Homework getNextUserHomework(ResultSet rs){
		  Homework thisHomework=null;
			try {
				thisHomework = new Homework(
						rs.getString("topic_name"),
						rs.getString("homework_title"),
						rs.getString("homework_description"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return thisHomework;		
		}
	  
	  public ArrayList<Homework> getUserHomework(String email) throws SQLException {
		  openConnection();
		  
		  String selectSql=  "SELECT t.topic_name,h.homework_title,h.homework_description from class_members c "
		  + "INNER JOIN classes cl "
		  + "on cl.class_ID = c.class_ID "
		  + "Inner join homework h "
		  + "ON cl.class_ID = h.class_ID "
		  + "INNER join topics t "
		  + "on h.topic_ID = t.topic_ID "
		  + "where c.email = '" + email + "'";
			ResultSet rs = stmt.executeQuery(selectSql);
			
		  ArrayList<Homework> allClassEnt = new ArrayList<>();
		 	
		  while(rs.next()){
		    	one_Homework = getNextUserHomework(rs);
		    	allClassEnt.add(one_Homework);
		   }
		  
		  return allClassEnt;	
	  }
	  
	  
	  
//-----------------------------Homework-----------------------------//	  
	  private Homework getNextHomework(ResultSet rs){
		  Homework thisHomework=null;
			try {
				thisHomework = new Homework(
						rs.getInt("homework_ID"),
						rs.getInt("topic_ID"),
						rs.getInt("class_ID"),
						rs.getString("homework_title"),
						rs.getString("homework_description"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return thisHomework;		
		}
	  
	  public ArrayList<Homework> getAllHomework(int ID){
		   
			ArrayList<Homework> allHomework = new ArrayList<Homework>();
			openConnection();
			
			
		    // Create select statement and execute it
			try{
			    String selectSQL = "select * from homework where class_ID = " + ID;
			   
			    ResultSet rs = stmt.executeQuery(selectSQL);
		    // Retrieve the results
			    while(rs.next()){
			    	one_Homework = getNextHomework(rs);
			    	
			    	allHomework.add(one_Homework);
			   }

			    stmt.close();
			    closeConnection();
			} catch(SQLException se) { System.out.println(se); }

		   return allHomework;
	   }
	  
	  public void setClassHomework(Homework h)throws SQLException{
		  try {
				openConnection();
				
				String insertSql = "insert into homework (topic_ID,class_ID,homework_title,homework_description) values "
				+ "('" + h.getTopic_ID() + "','" + h.getClass_ID() + "','" + h.getHomework_title()+ "','" + h.getHomework_description() + "')" ;  
				stmt.executeUpdate(insertSql);
				stmt.close();
				closeConnection();
			} catch (SQLException s) {
				throw new SQLException(s);
			}
	  }
	  
	  public void deleteHomework(int ID) throws SQLException {
		  openConnection();
		  String selectSQL = "Delete from homework where homework_ID = '"+ ID + "'";
		  stmt.executeUpdate(selectSQL);
		  stmt.close();
		  closeConnection();
	  }
	  
//-----------------------------Bookmark-----------------------------//	    
	  public void addBookmark(Bookmark b) throws SQLException {
			try {
				openConnection();
				
				String insertSql = "insert into bookmarks (topic_ID,user_ID) values "
				+ "('" + b.getTopic_ID() + "','" + b.getUser_ID()  + "');";
				stmt.executeUpdate(insertSql);
				stmt.close();
				closeConnection();
			} catch (SQLException s) {
				throw new SQLException(s);
			}
		}
	  
	  
	  private Bookmark getNextBookmark(ResultSet rs){
		  	Bookmark thisBookmark=null;
			try {
				thisBookmark = new Bookmark(
						rs.getInt("bookmark_ID"),
						rs.getInt("topic_ID"),
						rs.getInt("user_ID"),
						rs.getString("topic_name"),
						rs.getString("topic_description"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return thisBookmark;		
		}
	  
	  
	  public ArrayList<Bookmark> getBookmarkByUserID(int ID){
		   
			ArrayList<Bookmark> userBookmarks = new ArrayList<Bookmark>();
			openConnection();
			
			
		    // Create select statement and execute it
			try{
			    String selectSQL = "SELECT bookmark_ID,b.topic_ID,user_ID,t.topic_name,t.topic_description "
			    		+ "from bookmarks b "
			    		+ "inner join topics t on t.topic_ID = b.topic_ID "
			    		+ "WHERE b.user_ID = '"+ ID +"';";
			    ResultSet rs = stmt.executeQuery(selectSQL);
		    // Retrieve the results
			    while(rs.next()){
			    	one_Bookmark = getNextBookmark(rs);
			    	userBookmarks.add(one_Bookmark);
			   }

			    stmt.close();
			    closeConnection();
			} catch(SQLException se) { System.out.println(se); }

		   return userBookmarks;
	   }
	  
	  public void deleteBookmark(int ID) throws SQLException {
		  openConnection();
		  String selectSQL = "Delete from bookmarks where bookmark_ID = '"+ ID + "'";
		  stmt.executeUpdate(selectSQL);
		  stmt.close();
		  closeConnection();
	  }
	  
	//-----------------------------Complaints-----------------------------//	  
	  private Complaint getNextComplaint(ResultSet rs){
		  Complaint thisComplaint=null;
			try {
				thisComplaint = new Complaint(
						rs.getInt("complaint_ID"),
						rs.getString("complaint_subject"),
						rs.getString("complaint_description"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return thisComplaint;		
		}
	  
	  public ArrayList<Complaint> getAllComplaints(){
		   
			ArrayList<Complaint> allComplaints = new ArrayList<Complaint>();
			openConnection();
			
			
		    // Create select statement and execute it
			try{
			    String selectSQL = "select * from complaints";
			   
			    ResultSet rs = stmt.executeQuery(selectSQL);
			    System.out.print(rs);
		    // Retrieve the results
			    while(rs.next()){
			    	one_Complaint = getNextComplaint(rs);
			    	
			    	allComplaints.add(one_Complaint);
			   }

			    stmt.close();
			    closeConnection();
			} catch(SQLException se) { System.out.println(se); }

		   return allComplaints;
	   }
	  
	  
	  
	  public void insertComplaint(Complaint c) throws SQLException {
			try {
				openConnection();
				
				String insertSql = "INSERT INTO complaints"
						+ " (complaint_subject, complaint_description) "
						+ "VALUES('"+ c.getComplaint_subject() + "','" + c.getComplaint_description()+"')";
				stmt.executeUpdate(insertSql);
				stmt.close();
				closeConnection();
			} catch (SQLException s) {
				throw new SQLException(s);
			}
		}
	  
	  public void deleteComplaint(int ID) throws SQLException {
		  openConnection();
		  String selectSQL = "Delete from complaints where complaint_ID = '"+ ID + "'";
		  stmt.executeUpdate(selectSQL);
		  stmt.close();
		  closeConnection();
	  }
	  
	//-----------------------------Encrypt/Decrypt-----------------------------//	  
	  
//https://www.baeldung.com/java-cipher-class
	  
	private static final String ALGORITHM = "AES";
	private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public String encrypt(String input) throws Exception {
    	String key = "statsLearningTool1234567";
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    
    
    
    public String decrypt(String encryptedInput) throws Exception {
    	String key = "statsLearningTool1234567";
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedInput));
        return new String(decryptedBytes);
    }
	  
	  
	  
	  
}


