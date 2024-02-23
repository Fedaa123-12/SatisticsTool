package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.learning_tool_DAO;
import models.user;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		try {
			String encryptedPassword = DAO.encrypt(password);
			user u = new user(email,encryptedPassword);
			if(DAO.authenticateUser(u)) {
				String acces_level = DAO.getUserAccessLevel(u).getAccess_level();
				int user_ID = DAO.getUserAccessLevel(u).getUser_ID();
				String user_email = DAO.getUserAccessLevel(u).getEmail();
				request.getSession().setAttribute("logged_in", true);
				request.getSession().setAttribute("user_ID", user_ID);
				request.getSession().setAttribute("user_email", user_email);
				request.getSession().setAttribute("access_level", acces_level);
				response.sendRedirect("index.jsp");
			}
			else {
				request.getSession().setAttribute("error", "Wrong details");
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
