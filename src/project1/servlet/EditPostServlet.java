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

@WebServlet(urlPatterns = { "/editPost" })
public class EditPostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Connection conn;

	public EditPostServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String post_name = request.getParameter("name");
		String content = request.getParameter("content");
		String errorString = null;
		HttpSession session = request.getSession();
		User loginedUser = MyUltil.getLoginedUser(session);
		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		String name = loginedUser.getName();
		User user = new User();
		Post post = new Post();
		int postId = Integer.parseInt(request.getParameter("editPostId"));
		try {
			conn = DBConnect.getConnection();
			user = DBUltil.findUserbyName(conn, name);
			post = DBUltil.findPostbyId(conn, postId);
			post.setName(post_name);
			post.setContent(content);
			post.setPostId(postId);
			DBUltil.editPost(conn, post);
			errorString = "Change profile succesfull";
			request.setAttribute("errorString", errorString);
			request.setAttribute("post", post);
			request.getRequestDispatcher("/bodycontent/post/editPost.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		} finally {
			DBConnect.closeQuietly(conn);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		int postId = Integer.parseInt(request.getParameter("editPostId"));
		request.setAttribute("editPostId", postId);
		request.getRequestDispatcher("/bodycontent/post/editPost.jsp").forward(request, response);
	}
}