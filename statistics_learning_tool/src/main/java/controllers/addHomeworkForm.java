package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.learning_tool_DAO;
import models.Homework;
import models.topic;

/**
 * Servlet implementation class showAvailableTopicsToSet
 */
@WebServlet("/addHomeworkForm")
public class addHomeworkForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addHomeworkForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		ArrayList<topic> allTopics = DAO.getAllTopics();
		String class_ID = request.getParameter("class_ID");
		request.setAttribute("getTopics", allTopics);
		request.setAttribute("class_ID", class_ID);
		RequestDispatcher rd = request.getRequestDispatcher("addHomework.jsp");
		rd.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		int topic_ID = Integer.valueOf(request.getParameter("topic_ID"));
		int class_ID = Integer.valueOf(request.getParameter("class_ID"));
		String homework_title = request.getParameter("homework_title");
		String homework_description = request.getParameter("homework_description");
		
		
		String redirectEmail = (String) request.getSession().getAttribute("user_email");
		
		Homework h = new Homework(topic_ID,class_ID,homework_title,homework_description);
		
		try {
			DAO.setClassHomework(h);
			response.sendRedirect("teacherClasses?email="+redirectEmail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}