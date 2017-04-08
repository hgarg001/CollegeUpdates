package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Connection connection;

	public static Connection getConnection() {
		if (connection != null) {
			return connection;
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/collegeupdates", "root",
					"root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection(Connection toBeClosed) {
		if (toBeClosed == null) {
			return;
		}
		try {
			toBeClosed.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
