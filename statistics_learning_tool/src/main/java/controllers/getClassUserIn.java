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
 * Servlet implementation class getClassUserIn
 */
@WebServlet("/getClassUserIn")
public class getClassUserIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getClassUserIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		String email = request.getParameter("user_email");
		try {
			if(DAO.checkIfUserInClass(email)){
				ArrayList<String> userClass = DAO.getClassUserIN(email);
				ArrayList<Homework> userClassHomework = DAO.getUserHomework(email);
				
				request.setAttribute("userClass", userClass);
				request.setAttribute("userClassHomework", userClassHomework);
				RequestDispatcher rd = request.getRequestDispatcher("StudentClass.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
