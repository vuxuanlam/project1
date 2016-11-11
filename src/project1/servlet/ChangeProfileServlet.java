package project1.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import project1.ultil.MyUltil;
import project1.bean.User;

@WebServlet(urlPatterns = { "/changeProfile" })
public class ChangeProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ChangeProfileServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		User loginedUser = MyUltil.getLoginedUser(session);
		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
//		String email =loginedUser.getEmail();

		request.setAttribute("user", loginedUser);

		request.getRequestDispatcher("/bodycontent/account/changeProfile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
