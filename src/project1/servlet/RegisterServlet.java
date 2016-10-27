package project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();

	String name = request.getParameter("userName");
	String password = request.getParameter("password");
	String phoneNumber = request.getParameter("phoneNumber");
	String email = request.getParameter("email");
	 RequestDispatcher rd=request.getRequestDispatcher("servlet2");

	}

}
