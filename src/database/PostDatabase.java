package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

			statement.setBytes(4, post.getPostImage1());
			statement.setBytes(5, post.getPostImage2());
			statement.setBytes(6, post.getPostImage3());
			statement.setBytes(7, post.getPostImage4());

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

				Timestamp timestamp = result.getTimestamp(3);
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
				post.setPostDateTime(localDateTime);

				post.setPostText(result.getString(4));

				post.setPostImage1(result.getBytes(5));
				post.setPostImage2(result.getBytes(6));
				post.setPostImage3(result.getBytes(7));
				post.setPostImage4(result.getBytes(8));

				post.setNoOfLikes(result.getLong(9));

				allPosts.add(post);

			}

		} catch (Exception exception) {
		}
		return allPosts;

	}

	public boolean likePost(Post post,String userId) {
		boolean returnValue = false;
		try {

			Connection connection = Database.getConnection();
			int postId = post.getPostId().intValue();

			Statement smt = connection.createStatement();

			String updateQuery = "Update user_post set no_of_likes=no_of_likes+1 where post_id="
					+ postId + ";";

			if (smt.executeUpdate(updateQuery) > 0) {

				String insertQuery = "Insert into user_liked_post values(?,?)";
				PreparedStatement statement = connection
						.prepareStatement(insertQuery);
				statement.setLong(1, postId);
				statement.setString(2, userId);
				statement.execute();
				returnValue = true;
			}

		} catch (Exception exception) {
			exception.printStackTrace();

		}

		return returnValue;
	}

	public boolean unLikePost(Post post,String userId) {
		boolean returnValue = false;

		try {

			Connection connection = Database.getConnection();

			int postId = post.getPostId().intValue();

			Statement smt = connection.createStatement();

			String updateQuery = "Update user_post set no_of_likes=no_of_likes-1 where post_id="
					+ postId + ";";

			if (smt.executeUpdate(updateQuery) > 0) {
				String deleteQuery = "Delete from user_liked_post where post_id="
						+ postId + " and user_id='" + userId + "';";
				smt.execute(deleteQuery);
				returnValue = true;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return returnValue;
	}

	public List<Long> likedPost(String userId) {
		List<Long> likedPostIds = new ArrayList<Long>();
		try {

			Connection connection = Database.getConnection();
			String selectQuery = "select post_id from user_liked_post where user_id='"
					+ userId + "';";
			Statement smt = connection.createStatement();

			ResultSet result = smt.executeQuery(selectQuery);

			while (result.next()) {
				likedPostIds.add(result.getLong(1));
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return likedPostIds;
	}
	
	
	public ArrayList<Post> getAllUserPost(String userId) throws Exception {
		ArrayList<Post> allUserPosts = new ArrayList<Post>();

		try {

			Connection connection = Database.getConnection();
			String selectQuery = "select * from user_post where post_owner_id='"+userId+"'";
			Statement smt = connection.createStatement();

			ResultSet result = smt.executeQuery(selectQuery);

			while (result.next()) {
				Post post = new Post();

				post.setPostId(result.getLong(1));
				post.setPostOwnerId(result.getString(2));

				Timestamp timestamp = result.getTimestamp(3);
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
				post.setPostDateTime(localDateTime);

				post.setPostText(result.getString(4));

				post.setPostImage1(result.getBytes(5));
				post.setPostImage2(result.getBytes(6));
				post.setPostImage3(result.getBytes(7));
				post.setPostImage4(result.getBytes(8));

				post.setNoOfLikes(result.getLong(9));

				allUserPosts.add(post);

			}

		} catch (Exception exception) {
		}
		return allUserPosts;

	}
	
	
	public boolean deletePost(Post post) {
		boolean returnValue = false;
		try {

			Connection connection = Database.getConnection();
			int postId = post.getPostId().intValue();

			Statement smt = connection.createStatement();

			String updateQuery1 = "Delete from user_post where post_id="
					+ postId + ";";
			
			String updateQuery2 = "Delete from user_liked_post where post_id="
					+ postId + ";";

			smt.executeUpdate(updateQuery2);
				
				if(smt.executeUpdate(updateQuery1)>0){
					returnValue = true;

				}
				
				returnValue = true;


		} catch (Exception exception) {
			exception.printStackTrace();

		}

		return returnValue;
	}


	

}
