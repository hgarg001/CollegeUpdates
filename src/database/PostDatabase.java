package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import models.Post;

public class PostDatabase {

	public void createPost(Post post) throws Exception {
		try {
			Connection connection = Database.getConnection();
			String addQuery = "insert into user_post(post_owner_id,post_date_time,post_text,post_image1,post_image2,post_image3,post_image4,no_of_likes) values(?,?,?,?,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(addQuery);

			statement.setString(1, post.getPostOwnerId());

			Calendar calendar = Calendar.getInstance();
			Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

			statement.setTimestamp(2, timestamp);
			statement.setString(3, post.getPostText());

			statement.setBytes(4, null);
			statement.setBytes(5, null);
			statement.setBytes(6, null);
			statement.setBytes(7, null);

			statement.setInt(8, 0);

			statement.execute();

		} catch (Exception exception) {

			throw new Exception(exception.getMessage());

		}

	}

	public ArrayList<Post> getAllPost() throws Exception {
		ArrayList<Post> allPosts = new ArrayList<Post>();

		try {

			Connection connection = Database.getConnection();
			String selectQuery = "select * from user_post";
			Statement smt = connection.createStatement();

			ResultSet result = smt.executeQuery(selectQuery);

			while (result.next()) {
				Post post = new Post();

				post.setPostId(result.getLong(1));
				post.setPostOwnerId(result.getString(2));
				// post.setPostDateTime(result.getTimestamp(3));

				post.setPostText(result.getString(4));

				post.setPostImage1(null);
				post.setPostImage2(null);
				post.setPostImage3(null);
				post.setPostImage4(null);

				post.setNoOfLikes(result.getLong(9));

				allPosts.add(post);

			}

		} catch (Exception exception) {
			// TODO: handle exception
		}
		return allPosts;

	}

	public boolean likePost(Post post) {
		boolean returnValue = false;

		try {

			Connection connection = Database.getConnection();

			int postId = post.getPostId().intValue();

			Statement smt = connection.createStatement();

			String updateQuery = "Update user_post set no_of_likes=no_of_likes+1 where post_id="
					+ postId + ";";

			if (smt.executeUpdate(updateQuery) > 0) {
				returnValue = true;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return returnValue;
	}
}
