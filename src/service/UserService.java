package service;

import validator.UserValidator;
import models.User;
import database.UserDatabase;
import resources.Constants;

public class UserService {

	UserDatabase userDatabase = new UserDatabase();
	UserValidator userValidator = new UserValidator();

	public void addUser(User user) throws Exception {
		try {
			if (!userValidator.isValidRegistrationNumber(user.getUserID())) {
				throw new Exception(Constants.INVALID_REGISTRATION_NUMBER);
			}
			if (!userValidator.isValidUserNamber(user.getUserName())) {
				throw new Exception(Constants.INVALID_USERNAME);
			}
			if (!userValidator.isValidBateOfBirth(user.getDateOfBirth())) {
				throw new Exception(Constants.INVALID_DATE_OF_BIRTH);
			}
			if (!userValidator.isValidEmailId(user.getEmailId())) {
				throw new Exception(Constants.INVALID_EMAIL_ID);
			}
			if (!userValidator.isValidMobileNumber(user.getMobileNumber())) {
				throw new Exception(Constants.INVALID_MOBILE_NUMBER);
			}
			if (!userValidator.isValidPassword(user.getPassword())) {
				throw new Exception(Constants.INVALID_PASSWORD_FORMAT);
			}
			userDatabase.addUser(user);
		} catch (Exception exception) {
			throw exception;
		}
	}

	public User login(User user) throws Exception {
		try {
			user = userDatabase.login(user);
		} catch (Exception exception) {
			throw exception;
		}
		return user;
	}
}
