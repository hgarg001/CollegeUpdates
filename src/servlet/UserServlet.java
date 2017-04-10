package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import service.UserService;
import resources.Constants;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private UserService userService = new UserService();
	public String message = "";

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String command = request.getParameter("submit");

		if (command.equalsIgnoreCase("register")) {
			user = new User();
			user.setUserID(request.getParameter("userId"));
			user.setUserName(request.getParameter("userName"));
			user.setPassword(request.getParameter("password"));
			user.setGender(request.getParameter("gender"));

			LocalDate date = LocalDate.parse(request
					.getParameter("dateOfBirth"));
			user.setDateOfBirth(date);

			user.setBranch(request.getParameter("branch"));
			user.setDepartment(request.getParameter("department"));
			user.setEmailId(request.getParameter("emailId"));
			user.setMobileNumber(Long.parseLong(request
					.getParameter("mobileNumber")));
			user.setUserType("E");

			try {
				userService.addUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("pages/login.jsp");
		} else if (command.equalsIgnoreCase("login")) {
			user = new User();
			user.setUserID(request.getParameter("userId"));
			user.setPassword(request.getParameter("password"));
			try {
				user = userService.login(user);
				if (user == null) {
					message = Constants.INVALID_LOGIN_DETAILS;
					response.sendRedirect("pages/login.jsp?message="+message+"");
				} else {
					message = "";
					response.sendRedirect("pages/post.jsp");
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}

		}
	}

}
