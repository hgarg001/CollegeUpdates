package service;

import models.User;
import database.UserDatabase;

public class UserService {
	public void addUser(User user) throws Exception{
		try {
			new UserDatabase().addUser(user);
		} catch (Exception exception) {
			throw exception;
		}
	}
}
