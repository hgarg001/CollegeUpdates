package service;

import models.Post;
import database.PostDatabase;

public class PostService {

	public void createPost(Post post) throws Exception {
		try {
			new PostDatabase().createPost(post);
		} catch (Exception exception) {
			throw exception;
		}
	}

}
