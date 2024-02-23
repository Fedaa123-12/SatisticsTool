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
import models.Class_member;

/**
 * Servlet implementation class getClassMembers
 */
@WebServlet("/getClassMembers")
public class getClassMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getClassMembers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		int ID = Integer.valueOf(request.getParameter("class_ID"));
		ArrayList<Class_member> allMembers = DAO.getAllClass_members(ID);
		request.setAttribute("getMembers", allMembers);
		RequestDispatcher rd = request.getRequestDispatcher("showClassMembers.jsp");
		rd.forward(request, response);
	}



}
