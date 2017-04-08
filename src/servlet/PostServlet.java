package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PostService;
import models.Post;

@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PostServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		Post post = new Post();

		post.setPost_owner_id("DFGDFG");

		post.setPost_text(request.getParameter("postText"));

		try {
			new PostService().createPost(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("index.html");
	}

}
