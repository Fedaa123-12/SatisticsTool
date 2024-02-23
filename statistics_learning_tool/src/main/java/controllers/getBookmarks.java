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
import models.Bookmark;
import models.topic;

/**
 * Servlet implementation class getBookmarks
 */
@WebServlet("/getBookmarks")
public class getBookmarks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getBookmarks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		learning_tool_DAO DAO = new learning_tool_DAO();
		int ID = Integer.valueOf(request.getParameter("user_ID"));
		ArrayList<Bookmark> userBookmarks = DAO.getBookmarkByUserID(ID);
		if(userBookmarks.isEmpty()) {
			request.setAttribute("MSG", "You have no bookmarks");
			RequestDispatcher rd = request.getRequestDispatcher("Bookmarks.jsp");
			rd.forward(request, response);
		}
		else {
		request.setAttribute("userBookmarks", userBookmarks);
		RequestDispatcher rd = request.getRequestDispatcher("Bookmarks.jsp");
		rd.forward(request, response);}
		
		
	}


}
