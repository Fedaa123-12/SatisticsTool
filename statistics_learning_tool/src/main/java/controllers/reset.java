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
 * Servlet implementation class reset
 */
@WebServlet("/reset")
public class reset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reset() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		String email = request.getParameter("email");
		String first_name = request.getParameter("first_name");
		String second_name = request.getParameter("second_name");
		Date DOB = Date.valueOf(request.getParameter("DOB"));
		
		user u = new user(email,first_name,second_name,DOB);
		
		try {
			if(DAO.checkResetDetails(u)) {
				String oldPassword = DAO.getUserLostDetail(u).getPassword();
				String oldPasswordDecrypt = DAO.decrypt(oldPassword);
				request.getSession().setAttribute("Old_password", oldPasswordDecrypt);
				response.sendRedirect("changePassword.jsp");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
