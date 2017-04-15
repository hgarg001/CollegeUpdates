package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import resources.Constants;
import models.User;

public class UserDatabase {

	public void addUser(User user) throws Exception {
		try {
			Connection connection = Database.getConnection();
			PreparedStatement statement = connection
					.prepareStatement(Constants.INSERT_USER_QUERY);
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
			throw exception;
		}
	}

	public User login(User user) throws Exception {
		try {
			Connection connection = Database.getConnection();
			Statement smt = connection.createStatement();

			ResultSet result = smt.executeQuery(Constants.GET_USER_BY_ID_QUERY
					+ user.getUserID() + "';");

			if (result.next() && user.getPassword().equals(result.getString(2))) {
				System.out.println(result.getString(2));
			} else {
				throw new Exception(Constants.INVALID_LOGIN_DETAILS);
			}
		} catch (Exception exception) {
			throw exception;
		}
		return user;
	}
}
