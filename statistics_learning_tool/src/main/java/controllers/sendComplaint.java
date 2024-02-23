package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.learning_tool_DAO;
import models.Complaint;
import models.Homework;

/**
 * Servlet implementation class sendComplaint
 */
@WebServlet("/sendComplaint")
public class sendComplaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendComplaint() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		String complaint_subject = request.getParameter("complaint_subject");
		String complaint_description = request.getParameter("complaint_description");
		Complaint c = new Complaint(complaint_subject,complaint_description);
		try {
			DAO.insertComplaint(c);
			response.sendRedirect("index.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
