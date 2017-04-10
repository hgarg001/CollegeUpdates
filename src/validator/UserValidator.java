package validator;

import java.time.LocalDate;

public class UserValidator {

	public Boolean isValidRegistrationNumber(String registrationNumber) {
		return registrationNumber.matches("0901[a-zA-Z0-9]+");
	}

	public Boolean isValidUserNamber(String userName) {
		return userName.matches("[a-zA-Z0-9\\s]+");
	}

	public Boolean isValidBateOfBirth(LocalDate dateOfBirth) {
		return false;
	}

	public Boolean isValidEmailId(String emailId) {
		return false;
	}

	public Boolean isValidPhoneNumber(Long phoneNumber) {
		return (phoneNumber+"").matches("[987][0-9]{9}");
	}

	public Boolean isValidPassword(String password) {
		return password.matches("\\w");
	}
	
	public static void main(String[] args) {
		UserValidator validator = new UserValidator();
		System.out.println(validator.isValidPassword("gkj"));
	}
}
