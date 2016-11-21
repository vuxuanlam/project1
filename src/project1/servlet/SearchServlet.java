package project1.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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

@WebServlet(urlPatterns = { "/search" })
public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Connection conn;

	public SearchServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User loginedUser = MyUltil.getLoginedUser(session);
		if (loginedUser == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		String errorString = null;
		String tagName = request.getParameter("tagName");
		PostTag postTag = new PostTag();
		List<UserCommentPost> listUserCommentPost= new ArrayList<UserCommentPost>();
		try {
			conn = DBConnect.getConnection();
			List<Tag> listTag = DBUltil.findTag(conn, tagName);
			for (int i = 0; i < listTag.size(); i++) {
				int tagId = listTag.get(i).getTag_id();
				postTag = DBUltil.findPostTag(conn, tagId);
				int postId = postTag.getPost_Id();
				listUserCommentPost.add(DBUltil.search(conn, postId));
			}
			request.setAttribute("errorString", errorString);
			request.setAttribute("postList", listUserCommentPost);
			request.getRequestDispatcher("/searchpage.jsp").forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		} finally {
			DBConnect.closeQuietly(conn);
		}

	}
}