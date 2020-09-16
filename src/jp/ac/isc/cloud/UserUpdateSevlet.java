package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class UserUpdateSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

			Connection users = null;
			try {

				users = DBConnection.openConnection();//1
				String id = request.getParameter("updateId");
				String name = request.getParameter("updateName");
				String picture = request.getParameter("updatePicture");
				Statement state = users.createStatement();
				if(name.length() != 0 && picture.length() != 0){
					state.executeUpdate("UPDATE user_table SET name='" + name + "',picture='" + picture + "' WHERE id ='" + id + "'");
				}else if(picture.length() != 0){
					state.executeUpdate("UPDATE user_table SET picture='" + picture + "' WHERE id ='" + id + "'");
				}else if(name.length() != 0){
					state.executeUpdate("UPDATE user_table SET name='" + name + "' WHERE id ='" + id + "'");
				}
				DBConnection.closeConnection(users, state);
				response.sendRedirect("/select"); //UserSelectServletを呼び出す

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
