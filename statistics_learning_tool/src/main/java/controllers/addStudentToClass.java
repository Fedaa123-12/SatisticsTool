package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.learning_tool_DAO;

/**
 * Servlet implementation class addStudentToClass
 */
@WebServlet("/addStudentToClass")
public class addStudentToClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStudentToClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		int class_ID = Integer.valueOf(request.getParameter("class_ID"));
		String email = request.getParameter("addStudent");
		String teacherEmail = request.getParameter("teacherEmail");
		
		try {
			DAO.addStudentToClass(class_ID, email);
			response.sendRedirect("showStudentList?email="+teacherEmail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
