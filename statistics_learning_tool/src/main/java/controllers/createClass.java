package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.learning_tool_DAO;
import models.Classs;

/**
 * Servlet implementation class createClass
 */
@WebServlet("/createClass")
public class createClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public createClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		String email = request.getParameter("email");
		String class_name = request.getParameter("class_name");
		
		Classs c = new Classs(email,class_name);
		
		try {
			DAO.insertTeacherMadeClass(c);
			response.sendRedirect("teacherClasses?email="+email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
