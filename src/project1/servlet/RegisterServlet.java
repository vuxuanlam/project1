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

import project1.bean.User;
import project1.dbconnect.DBConnect;
import project1.ultil.*;

@WebServlet(urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {

	Connection conn;

	public RegisterServlet() {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		PrintWriter out = response.getWriter();

		User user = new User(name, password, email);

		String errorString = null;

		try {
			conn = DBConnect.getConnection();
			user = DBUltil.findUser(conn, name);
			if (user != null) {
				errorString = ("Username already exists ");
				request.setAttribute("errorString", errorString);
				request.getRequestDispatcher("/bodycontent/authentication/register.jsp").forward(request, response);
			} else {
				user = new User();
				String smtpMS = "smtp.gmail.com";
				String to = email;
				String from = "lam.vuxuan2512@gmail.com";
				String pass = "xuanlam2512";
				String subject = "Register Mail";
				String content = "Please check link to activate acount " + "http://localhost:8080/project1/active?name="+ name+"&password="+password ;
				user.setPassword(password);
				user.setEmail(email);
				user.setName(name);

				DBUltil.insertUser(conn, user);
				MailUltil.sendMail(smtpMS, to, from, pass, subject, content);
				out.println("<html><body>");
				out.println("<p><big>Register Successful !!!</big></br>");
				out.println(
						"<p1>Please Check Mail To Activate Account and Click OK to Come Back Login Form</p1></br></p>");
				out.println("<a href='http://localhost:8080/project1/'>OK</a>");
				out.println("</body></html>");
			}
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
			// response.sendRedirect(request.getContextPath() + "/login");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			errorString = e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		} finally {
			DBConnect.closeQuietly(conn);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/bodycontent/authentication/register.jsp").forward(request, response);
	}
}
