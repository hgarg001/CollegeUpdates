package service;

import java.util.ArrayList;

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

	public boolean likePost(Post post) {
		try {
			return new PostDatabase().likePost(post);
		} catch (Exception exception) {
			exception.printStackTrace();

		}
		return false;

	}

}
