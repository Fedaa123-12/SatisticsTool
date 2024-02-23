package controllers;

import java.io.IOException;
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
 * Servlet implementation class getAllHomework
 */
@WebServlet("/getAllHomework")
public class getAllHomework extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAllHomework() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		int class_ID = Integer.valueOf(request.getParameter("class_ID"));
		
		ArrayList<Homework> allHomework = DAO.getAllHomework(class_ID);
		System.out.print(allHomework);
		request.setAttribute("getHomework", allHomework);
		request.setAttribute("class_ID", class_ID);
		RequestDispatcher rd = request.getRequestDispatcher("manageHomework.jsp");
		rd.forward(request, response);
	}
	

}
