package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import models.User;

public class UserDatabase {

	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			Connection connection = Database.getConnection();
			String addQuery = "insert into User values(?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(addQuery);
			statement.setString(1, user.getUserID());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getUserName());
			statement.setString(4, user.getGender());

			LocalDate dateofBirth1 = user.getDateOfBirth();
			Date dateofBirth2 = Date.valueOf(dateofBirth1);
			statement.setDate(5, dateofBirth2);	
			
			statement.setString(6, user.getBranch());
			statement.setString(7, user.getDepartment());
			statement.setString(8, user.getEmailId());
			statement.setLong(9, user.getMobileNumber());
			statement.setString(10, null);
			// statement.setString(9, user.getProfilePicPath());
			statement.setString(11, user.getUserType());

			statement.execute();
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
}
