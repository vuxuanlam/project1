package project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import project1.ultil.DBUltil;
import project1.ultil.MyUltil;
import project1.bean.User;
import project1.dbconnect.DBConnect;

@WebServlet(urlPatterns = { "/showProfile" })
public class ShowProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Connection conn;

	public ShowProfileServlet() {
		super();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loginedUser = MyUltil.getLoginedUser(session);
		String name = loginedUser.getName();
		User user = new User();
		String errorString = null;
		try {
			conn = DBConnect.getConnection();
			user = DBUltil.findUserbyName(conn, name);
			user.getName();
			user.getEmail();
			user.getCreateAt();
			user.getUpdateAt();
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/bodycontent/account/profile.jsp").forward(request, response);
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
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/bodycontent/account/profile.jsp").forward(request, response);

	}

}