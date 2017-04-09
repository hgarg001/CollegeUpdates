package resources;

public class Constants {
	/* UserDatabase Queries */
	public static final String INSERT_USER_QUERY = "INSERT INTO USER(USER_ID,USER_NAME,PASSWORD,GENDER,DATE_OF_BIRTH,BRANCH,DEPARTMENT_NAME,EMAIL_ID,MOBILE_NUMBER,PROFILE_PIC,USER_TYPE) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	public static final String GET_USER_BY_ID_QUERY = "SELECT USER_ID,USER_NAME,PASSWORD,GENDER,DATE_OF_BIRTH,BRANCH,DEPARTMENT_NAME,EMAIL_ID,MOBILE_NUMBER,PROFILE_PIC,USER_TYPE FROM USER WHERE USER_ID = '";
	/* UserDatabase Queries End */
	
	/*User messages*/
	public static final String INVALID_LOGIN_DETAILS = "Invalid user Id or password";
	/*User message end*/
}
