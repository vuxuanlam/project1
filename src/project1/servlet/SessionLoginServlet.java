package project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project1.bean.User;
import project1.dbconnect.PsqlConn;
import project1.dbconnect.JDBCConnect;
import project1.ultil.*;

public class SessionLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String password = request.getParameter("password");


		if (password.equals("123456")) {
			out.println("Welcome, " + name);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			request.getRequestDispatcher("homepage.jsp").forward(request, response);
		} else {
			out.print("Sorry, username or password error!");
			request.getRequestDispatcher("/bodycontent/authentication/login.jsp").include(request, response);
		}
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
