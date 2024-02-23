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
 * Servlet implementation class updateUserDetails
 */
@WebServlet("/userUpdateDetails")
public class userUpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userUpdateDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		int user_ID = Integer.valueOf(request.getParameter("updateId"));
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String first_name = request.getParameter("first_name");
		String second_name = request.getParameter("second_name");
		String password = request.getParameter("password");
		Date DOB = Date.valueOf(request.getParameter("DOB"));
		
		
		try {
			String encryptedPassword = DAO.encrypt(password);
			user u = new user(user_ID,email, username, first_name, second_name, encryptedPassword, DOB);
		
			DAO.userUpdateAccount(u);
			response.sendRedirect("user_page.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
