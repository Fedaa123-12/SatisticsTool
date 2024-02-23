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

/**
 * Servlet implementation class teacherClasses
 */
@WebServlet("/teacherClasses")
public class teacherClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacherClasses() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		String email = request.getParameter("email");
		System.out.print(email);
		ArrayList<Classs> allClasses = DAO.getAllClasses(email);
		request.setAttribute("getClsses", allClasses);
		RequestDispatcher rd = request.getRequestDispatcher("teacherClasses.jsp");
		rd.forward(request, response);
	}


}
