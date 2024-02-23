package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.learning_tool_DAO;
import models.topic;

/**
 * Servlet implementation class addTopic
 */
@WebServlet("/addTopic")
public class addTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTopic() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		String topic_name = request.getParameter("topic_name");
		String topic_description = request.getParameter("topic_description");
		String topic_media_link = request.getParameter("topic_media_link");
		
		
		topic t = new topic(topic_name,topic_description,topic_media_link);
		
		try {
			DAO.insertTopic(t);
			response.sendRedirect("./getAllTopics?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
