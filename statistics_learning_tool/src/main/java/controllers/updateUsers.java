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
 * Servlet implementation class updateUsers
 */
@WebServlet("/updateUsers")
public class updateUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUsers() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO dao = new learning_tool_DAO();
		int ID = Integer.valueOf(request.getParameter("update"));	
		user user = dao.getUserByID(ID);
		request.setAttribute("user", user);
		request.getRequestDispatcher("updateUserData.jsp").forward(request, response); 
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
		String access_level = request.getParameter("access_level");
		
		
		
		try {
			String encryptedPassword = DAO.encrypt(password);
			user u = new user(user_ID,email, username, first_name, second_name, encryptedPassword, DOB, access_level);
		
			DAO.updateUser(u);
			response.sendRedirect("./getAllUsers");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
