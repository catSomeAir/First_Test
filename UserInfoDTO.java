package pack05.ojdbc2;

public class UserInfoDTO {
	String USER_ID, USER_PW, FIRST_NAME, LAST_NAME, CREATE_YMD, UPDATE_YMD;
	int STUDENT_NO;
	
	public UserInfoDTO() {}
	public UserInfoDTO(int sTUDENT_NO, String uSER_ID, String uSER_PW, String fIRST_NAME, String lAST_NAME,
			String cREATE_YMD, String uPDATE_YMD) {
		super();
		STUDENT_NO = sTUDENT_NO;
		USER_ID = uSER_ID;
		USER_PW = uSER_PW;
		FIRST_NAME = fIRST_NAME;
		LAST_NAME = lAST_NAME;
		CREATE_YMD = cREATE_YMD;
		UPDATE_YMD = uPDATE_YMD;
	}
	public UserInfoDTO(int student_no2, String user_id2, String user_pw2, String frist_name, String last_name2) {
		// TODO Auto-generated constructor stub
		STUDENT_NO = student_no2;
		USER_ID = user_id2;
		USER_PW = user_pw2;
		FIRST_NAME = frist_name;
		LAST_NAME = last_name2;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_PW() {
		return USER_PW;
	}
	public void setUSER_PW(String uSER_PW) {
		USER_PW = uSER_PW;
	}
	public String getFIRST_NAME() {
		return FIRST_NAME;
	}
	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}
	public String getLAST_NAME() {
		return LAST_NAME;
	}
	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}
	public String getCREATE_YMD() {
		return CREATE_YMD;
	}
	public void setCREATE_YMD(String cREATE_YMD) {
		CREATE_YMD = cREATE_YMD;
	}
	public String getUPDATE_YMD() {
		return UPDATE_YMD;
	}
	public void setUPDATE_YMD(String uPDATE_YMD) {
		UPDATE_YMD = uPDATE_YMD;
	}
	public int getSTUDENT_NO() {
		return STUDENT_NO;
	}
	public void setSTUDENT_NO(int sTUDENT_NO) {
		STUDENT_NO = sTUDENT_NO;
	}
	
	
}
