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
	public static Integer postCount = 1;
	
	public PostServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		if (request.getParameter("submit").equalsIgnoreCase("post")) {

			Post post = new Post();

			post.setPostOwnerId("DFGDFG");
			post.setPostText(request.getParameter("postText"));

			new PostService().createPost(post);
		} else if (request.getParameter("submit").equalsIgnoreCase("like")) {

			Post post = new Post();
			System.out.println("ajkhdkdh" + request.getParameter("postId"));
			Long postId = Long.parseLong(request.getParameter("postId"));

			post.setPostId(postId);

			if (new PostService().likePost(post)) {

			} else {

			}

		} else if (request.getParameter("submit").equalsIgnoreCase(
				"More Stroies")) {
			PostServlet.postCount++;

		}

		response.sendRedirect("pages/post.jsp");
	}

}
