package project1.servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project1.bean.User;
import project1.dbconnect.DBConnect;
import project1.ultil.*;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	Connection conn;

	public LoginServlet() {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Boolean isActive = true;
		User user = null;
		String errorString = null;
		try {
			conn = DBConnect.getConnection();
			user = DBUltil.findUser(conn, name, password, isActive);
			if (user == null) {
				errorString = "User or password is not invalid ";
				request.setAttribute("errorString", errorString);
				request.getRequestDispatcher("/bodycontent/authentication/login.jsp").forward(request, response);
			}
			Boolean isRole = user.isRole();
			if (isRole == false) {
				request.setAttribute("errorString", errorString);
				request.setAttribute("user", user);
				HttpSession session = request.getSession();
				MyUltil.storeLoginedUser(session, user);
				response.sendRedirect(request.getContextPath() + "/allPost");
			} else {

				request.setAttribute("errorString", errorString);
				request.setAttribute("user", user);
				HttpSession session = request.getSession();
				MyUltil.storeLoginedUser(session, user);
				response.sendRedirect(request.getContextPath() + "/adminManageUser");
			}

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
