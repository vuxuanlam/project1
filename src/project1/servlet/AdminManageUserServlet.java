package project1.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

import project1.bean.*;

import project1.dbconnect.DBConnect;
import project1.ultil.DBUltil;
import project1.ultil.MyUltil;

@WebServlet(urlPatterns = { "/adminManageUser" })
public class AdminManageUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Connection conn;

	public AdminManageUserServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User loginedUser = MyUltil.getLoginedUser(session);
		if (loginedUser == null) {
			request.getRequestDispatcher("/bodycontent/authentication/login.jsp").forward(request, response);
			return;
		}
		String errorString = null;
		try {
			conn = DBConnect.getConnection();
			List<User> listUser = DBUltil.viewAllUser(conn);
			request.setAttribute("userList", listUser);
			// List<UserCommentPost> listUserCommentPost
			// =DBUltil.viewAllPost(conn);
			request.setAttribute("errorString", errorString);
			// request.setAttribute("postList", listUserCommentPost);
			request.getRequestDispatcher("/bodycontent/admin/userlist.jsp").forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		} finally {
			DBConnect.closeQuietly(conn);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/homepage.jsp").forward(request, response);
	}
}