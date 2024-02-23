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
import models.Complaint;
import models.user;

/**
 * Servlet implementation class viewAllComplaints
 */
@WebServlet("/viewAllComplaints")
public class viewAllComplaints extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllComplaints() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		ArrayList<Complaint> allComplaints = DAO.getAllComplaints();
		request.setAttribute("allComplaints", allComplaints);
		RequestDispatcher rd = request.getRequestDispatcher("viewComplaints.jsp");
		rd.forward(request, response);
	}

}
