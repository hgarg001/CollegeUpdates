package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Post;
import service.PostService;

@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Integer postCount = 1;
	public String userId = "DFGDFG";

	public PostServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String redirect="";
		
		String command = request.getParameter("submit");
		if (command.equalsIgnoreCase("post")) {

			Post post = new Post();

			post.setPostOwnerId(userId);
			post.setPostText(request.getParameter("postText"));

			new PostService().createPost(post);
			
			redirect="pages/post.jsp";

			
		} else if (command.equalsIgnoreCase("like")) {

			Post post = new Post();
			System.out.println("ajkhdkdh" + request.getParameter("postId"));
			Long postId = Long.parseLong(request.getParameter("postId"));

			post.setPostId(postId);

			new PostService().likePost(post, userId);
			
			redirect="pages/post.jsp";

		} else if (command.equalsIgnoreCase("unlike")) {
			Post post = new Post();
			Long postId = Long.parseLong(request.getParameter("postId"));

			post.setPostId(postId);

			new PostService().unLikePost(post, userId);
			redirect="pages/post.jsp";
			
		} else if (command.equalsIgnoreCase("More Stroies")) {
			PostServlet.postCount++;
			redirect="pages/post.jsp";
			
		} else if (command.equalsIgnoreCase("delete")) {
			Post post = new Post();
			Long postId= Long.parseLong(request.getParameter("postId"));
			
			post.setPostId(postId);
			
			new PostService().deletePost(post);
			
			redirect="pages/myPost.jsp";		
			
		} else if (command.equalsIgnoreCase("See More")) {
			PostServlet.postCount++;
			redirect="pages/myPost.jsp";
			
		}

		  response.sendRedirect(redirect);
		
	
		
	}

}
