package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.learning_tool_DAO;
import models.user;

/**
 * Servlet implementation class updateUsersGetDetails
 */
@WebServlet("/updateUsersGetDetails")
public class updateUsersGetDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUsersGetDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO dao = new learning_tool_DAO();
		int ID = Integer.valueOf(request.getParameter("update"));	
		user user = dao.getUserByID(ID);
		try {
			String decrypt = dao.decrypt(user.getPassword());
			user.setPassword(decrypt);
			request.setAttribute("user", user);
			request.getRequestDispatcher("updateUserData.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
