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

import project1.bean.Post;
import project1.bean.User;
import project1.bean.Comment;
import project1.dbconnect.DBConnect;
import project1.ultil.*;

@WebServlet(urlPatterns = { "/createComment" })
public class CreateCommentServlet extends HttpServlet {

	Connection conn;

	public CreateCommentServlet() {
		super();
	}

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User loginedUser = MyUltil.getLoginedUser(session);
		String name = loginedUser.getName();
		User user = new User();
		Post post = new Post();
		Comment comment = new Comment();
		String content = request.getParameter("content");
		String errorString = null;

		try {
			conn = DBConnect.getConnection();
			user = DBUltil.findUserbyName(conn, name);
			int userId = user.getUserId();
			int postId = Integer.parseInt(request.getParameter("commentPostId"));
			post = DBUltil.findPostbyId(conn, postId);
			DBUltil.creatComment(conn, content, postId, userId);
			request.setAttribute("errorString", errorString);
			request.setAttribute("comment", comment);
			request.setAttribute("post", post);
			request.getRequestDispatcher("/bodycontent/post/createComment.jsp").forward(request, response);


		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}finally {
			DBConnect.closeQuietly(conn);
		}

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		int postId = Integer.parseInt(request.getParameter("commentPostId"));
		request.setAttribute("commentPostId", postId);
		request.getRequestDispatcher("/bodycontent/post/createComment.jsp").forward(request, response);
	}
}