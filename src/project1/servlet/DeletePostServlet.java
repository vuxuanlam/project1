package project1.servlet;

import java.io.IOException;
import java.sql.Connection;
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
import project1.bean.Post;
import project1.dbconnect.DBConnect;

@WebServlet(urlPatterns = { "/deletePost" })
public class DeletePostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Connection conn;

	public DeletePostServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		HttpSession session = request.getSession();

		User loginedUser = MyUltil.getLoginedUser(session);
		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		String name = loginedUser.getName();
		int postId = Integer.parseInt(request.getParameter("deletePostId"));
		User user = new User();
		Post post = new Post();
		try {
			conn = DBConnect.getConnection();
			user = DBUltil.findUserbyName(conn, name);
			int userId = user.getUserId();
			post = DBUltil.findPost(conn, userId);
			DBUltil.deletePost(conn, postId);
			request.setAttribute("user", user);
			request.setAttribute("post", post);
			response.sendRedirect(request.getContextPath() + "/myPost");
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
		request.getRequestDispatcher("/bodycontent/post/mypost.jsp").forward(request, response);

	}
}