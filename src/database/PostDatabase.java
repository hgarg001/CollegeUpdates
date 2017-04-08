package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Calendar;

import models.Post;

public class PostDatabase {

	public void createPost(Post post) throws Exception {
		try {
			Connection connection = Database.getConnection();
			String addQuery = "insert into user_post values(?,?,?,?,?,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(addQuery);

			statement.setLong(1, 0);
			statement.setString(2, post.getPost_owner_id());

			Calendar calendar = Calendar.getInstance();
			Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

			statement.setTimestamp(3, timestamp);
			
			statement.setString(4, post.getPost_text());
			statement.setBytes(5, null);
			statement.setBytes(6, null);
			statement.setBytes(7, null);
			statement.setBytes(8, null);
			statement.setInt(9, 0);
			statement.execute();
		} catch (Exception exception) {
			throw exception;
		}

	}
}
