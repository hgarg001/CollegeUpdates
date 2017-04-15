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
		LocalDate date = LocalDate.now();
		return (dateOfBirth.compareTo(date) < 0) ? true : false;
	}

	public Boolean isValidEmailId(String emailId) {
		return emailId.toLowerCase().matches(
				"[a-z][a-z0-9\\.]{6,38}[a-z]@[a-z]+\\.[a-z]+");
	}

	public Boolean isValidMobileNumber(Long phoneNumber) {
		return (phoneNumber + "").matches("[987][0-9]{9}");
	}

	public Boolean isValidPassword(String password) {
		return password.matches("\\w");
	}

	public static void main(String[] args) {
		UserValidator validator = new UserValidator();
		System.out.println(validator.isValidBateOfBirth(LocalDate.now()
				.plusDays(3)));
	}
}
