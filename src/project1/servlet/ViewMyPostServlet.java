package project1.servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

import project1.bean.User;
import project1.dbconnect.DBConnect;
import project1.bean.Post;
import project1.ultil.DBUltil;
import project1.ultil.MyUltil;

@WebServlet(urlPatterns = { "/myPost" })
public class ViewMyPostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Connection conn;
	public ViewMyPostServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loginedUser = MyUltil.getLoginedUser(session);
		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		String name = loginedUser.getName();
		User user = new User();
		List<Post> listPost = null;
		String errorString  = null;
		try {
			conn = DBConnect.getConnection();
			user = DBUltil.findUserbyName(conn, name);
			int userId = user.getUserId();
			listPost = DBUltil.viewMyPost(conn, userId);
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
			request.setAttribute("postList", listPost);
			request.getRequestDispatcher("bodycontent/post/mypost.jsp").forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}finally{
			DBConnect.closeQuietly(conn);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/bodycontent/post/mypost.jsp").forward(request, response);
	}
}
