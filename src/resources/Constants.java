package resources;

public class Constants {
	
	/* UserDatabase Queries */
	public static final String INSERT_USER_QUERY = "INSERT INTO USER(USER_ID,USER_NAME,PASSWORD,GENDER,DATE_OF_BIRTH,BRANCH,DEPARTMENT_NAME,EMAIL_ID,MOBILE_NUMBER,PROFILE_PIC,USER_TYPE) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	public static final String GET_USER_BY_ID_QUERY = "SELECT USER_ID,USER_NAME,PASSWORD,GENDER,DATE_OF_BIRTH,BRANCH,DEPARTMENT_NAME,EMAIL_ID,MOBILE_NUMBER,PROFILE_PIC,USER_TYPE FROM USER WHERE USER_ID = '";
	/* UserDatabase Queries End */

	/* User messages */
	public static final String INVALID_LOGIN_DETAILS = "Invalid user Id or password";

	public static final String INVALID_REGISTRATION_NUMBER = "Invalid r";
	public static final String INVALID_USERNAME = "Invalid u";
	public static final String INVALID_DATE_OF_BIRTH = "Invalid d";
	public static final String INVALID_EMAIL_ID = "Invalid e";
	public static final String INVALID_MOBILE_NUMBER = "Invalid m";
	public static final String INVALID_PASSWORD_FORMAT = "Invalid p";
	/* User message end */

}
