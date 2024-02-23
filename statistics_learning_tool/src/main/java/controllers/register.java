package controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.learning_tool_DAO;
import models.user;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		learning_tool_DAO DAO = new learning_tool_DAO();
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String first_name = request.getParameter("first_name");
		String second_name = request.getParameter("second_name");
		String password = request.getParameter("password");
		Date DOB = Date.valueOf(request.getParameter("DOB"));
		String access_level = "Student";

		
		
		try {
			String encryptedPassword = DAO.encrypt(password);
			user u = new user(email, username, first_name, second_name, encryptedPassword, DOB, access_level);
			
			DAO.insertUser(u);
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String error = e.toString();
			error = error.replace("java.sql.SQLException:", "");
			error = error.replace("key", "");
			request.getSession().setAttribute("error", error);
			response.sendRedirect("register.jsp");
		}
	}
}
