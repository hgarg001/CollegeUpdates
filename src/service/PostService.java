package service;

import java.util.ArrayList;
import java.util.List;

import models.Post;
import database.PostDatabase;

public class PostService {

	public void createPost(Post post) {
		try {
			new PostDatabase().createPost(post);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public ArrayList<Post> getAllPost() {
		ArrayList<Post> allPosts = new ArrayList<Post>();
		try {

			allPosts = new PostDatabase().getAllPost();

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return allPosts;
	}

	public boolean likePost(Post post,String userId) {
		try {
			return new PostDatabase().likePost(post,userId);
		} catch (Exception exception) {
			exception.printStackTrace();

		}
		return false;

	}

	public boolean unLikePost(Post post,String userId) {

		try {

			return new PostDatabase().unLikePost(post,userId);

		} catch (Exception exception) {
			// TODO: handle exception
			exception.printStackTrace();

		}

		return false;

	}

	public List<Long> likedPost(String userId) {
		List<Long> likedPostIds = new ArrayList<Long>();
		try {

			likedPostIds = new PostDatabase().likedPost(userId);

		} catch (Exception exception) {
			// TODO: handle exception
			exception.printStackTrace();
		}

		return likedPostIds;
	}
	
	
	public ArrayList<Post> getAllUserPost(String userId) {
		ArrayList<Post> allUserPosts = new ArrayList<Post>();
		try {

			allUserPosts = new PostDatabase().getAllUserPost(userId);

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return allUserPosts;
	}
	
	public boolean deletePost(Post post) {

		try {

			return new PostDatabase().deletePost(post);

		} catch (Exception exception) {
			// TODO: handle exception
			exception.printStackTrace();

		}

		return false;

	}


}
