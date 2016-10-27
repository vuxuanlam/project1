package project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("/bodycontent/authentication/login.jsp").include(request, response);

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if (password.equals("lamvx2512")) {
			 response.sendRedirect("homepage.jsp");
			 out.println("Welcome, " + name);
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
		} else {
			out.print("Sorry, username or password error!");
			request.getRequestDispatcher("/bodycontent/authentication/login.jsp");
		}
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
