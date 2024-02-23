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
 * Servlet implementation class deleteClass
 */
@WebServlet("/deleteClass")
public class deleteClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteClass() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		String email = request.getParameter("email");
		int ID = Integer.valueOf(request.getParameter("delete"));
		
		
		try {
			DAO.deleteFromClass_members(ID);
			DAO.deleteClass(ID);
			response.sendRedirect("teacherClasses?email="+email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
