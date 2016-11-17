package project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project1.bean.User;
import project1.dbconnect.DBConnect;
import project1.ultil.*;

@WebServlet(urlPatterns = { "/active" })
public class ActiveServlet extends HttpServlet {

	Connection conn;

	public ActiveServlet() {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String errorString = null;
		User user = new User();
		try {
			conn = DBConnect.getConnection();

			user.setName(name);
			User user2 = DBUltil.findUserbyName(conn, name);
			String password2 = user2.getPassword();
			DBUltil.activateAccount(conn, name);

			user.setPassword(password2);
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		} finally {
			DBConnect.closeQuietly(conn);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}