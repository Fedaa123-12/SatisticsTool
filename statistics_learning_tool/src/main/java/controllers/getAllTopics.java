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
import models.topic;
import models.user;

/**
 * Servlet implementation class getAllTopics
 */
@WebServlet("/getAllTopics")
public class getAllTopics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAllTopics() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		ArrayList<topic> allTopics = DAO.getAllTopics();
		request.setAttribute("getTopics", allTopics);
		RequestDispatcher rd = request.getRequestDispatcher("ManageTopics.jsp");
		rd.forward(request, response);
	}


}
