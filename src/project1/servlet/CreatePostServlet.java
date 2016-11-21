package project1.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project1.bean.*;
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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User loginedUser = MyUltil.getLoginedUser(session);
		String name = loginedUser.getName();
		User user = new User();
		Post post = new Post();
		Tag tag = new Tag();
		String postName = request.getParameter("name");
		String content = request.getParameter("content");
		String tagName = request.getParameter("tagName");
		String errorString = null;
		try {
			conn = DBConnect.getConnection();
			user = DBUltil.findUserbyName(conn, name);
			int userId = user.getUserId();
			post.setName(postName);
			post.setContent(content);
			post.setUserId(userId);
			tag.setTag_name(tagName);
			DBUltil.creatPost(conn, post, userId);

			DBUltil.insertTag(conn, tag, tagName);
//			List<Tag> listTag = DBUltil.findTag(conn, tagName);
			int tagId = tag.getTag_id();
			int postId = post.getPostId();
//			for (int i = 0; i < listTag.size(); i++) {
				// Tag tag = DBUltil.findTag(conn, tagName);
//				int tagId = listTag.get(i).getTag_id();
				// int tagId = tag.getTag_id();

				DBUltil.insertPostTag(conn, postId, tagId);
//			}
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/bodycontent/post/createPost.jsp").forward(request, response);
	}
}