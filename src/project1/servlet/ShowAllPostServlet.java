package project1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

import project1.bean.User;
import project1.ultil.MyUltil;

@WebServlet(urlPatterns = { "/showAllPost" })
public class ShowAllPostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ShowAllPostServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loginedUser = MyUltil.getLoginedUser(session);
		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		request.setAttribute("user", loginedUser);
		request.getRequestDispatcher("homepage.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
