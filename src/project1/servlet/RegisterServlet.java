package project1.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project1.bean.User;
import project1.dbconnect.DBConnect;
import project1.ultil.*;

@WebServlet(urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {

	Connection conn;

	public RegisterServlet() {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		User user = null;
		boolean isError = false;
		String errorString = null;
		try {
			conn = DBConnect.getConnection();
			user = DBUltil.findUser(conn, name);
			if (user == null) {
				isError = true;
				errorString = "User Name or password invalid";
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			isError = true;
			errorString = e.getMessage();
		} finally {
			DBConnect.closeQuietly(conn);
		}
		if (isError) {
			user = new User();
			user.setName(name);
			user.setPassword(password);
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/bodycontent/authentication/register.jsp").forward(request, response);
		} else {
//			todo
//			HttpSession session = request.getSession();
//			MyUltil.storeLoginedUser(session, user);
//			response.sendRedirect(request.getContextPath() + "/home");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
