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
import javax.servlet.http.HttpSession;

import project1.bean.Post;
import project1.bean.User;
import project1.dbconnect.DBConnect;
import project1.ultil.*;

@WebServlet(urlPatterns = { "/createPost" })
public class CreatePostServlet extends HttpServlet {

	Connection conn;

	public CreatePostServlet() {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loginedUser = MyUltil.getLoginedUser(session);
		String name = loginedUser.getName();
		User user = new User();
		Post post = new Post();
		String postName = request.getParameter("name");
		String content = request.getParameter("content");
		PrintWriter out = response.getWriter();
		String errorString = null;
		try {
			conn = DBConnect.getConnection();
			user = DBUltil.findUserbyName(conn, name);
			int userId = user.getUserId();
			post.setName(postName);
			post.setContent(content);
			post.setUserId(userId);
			DBUltil.creatPost(conn, post, userId);
			errorString = "Creat Post Success";
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
		response.sendRedirect(request.getContextPath() + "/createPost");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		} finally {
			DBConnect.closeQuietly(conn);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/bodycontent/post/createPost.jsp").forward(request, response);
	}
}