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
import models.Classs;
import models.user;

/**
 * Servlet implementation class showStudentList
 */
@WebServlet("/showStudentList")
public class showStudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showStudentList() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		String email = request.getParameter("email");
		
		ArrayList<user> allStudents = DAO.getAllStudents();
		ArrayList<Classs> allClasses = DAO.getAllClasses(email);
		request.setAttribute("getClsses", allClasses);
		request.setAttribute("getStudents", allStudents);
		RequestDispatcher rd = request.getRequestDispatcher("addStudentsToClass.jsp");
		rd.forward(request, response);
	}


}
