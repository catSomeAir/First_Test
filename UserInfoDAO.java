package pack05.ojdbc2;

import java.sql.SQLException;
import java.util.ArrayList;

import pack04.odjbc.JdbcDTO;

public class UserInfoDAO extends StudentDAO{
	// 현 StudentDAO 를 상속받아서 썻다면 나중에는 접속객체를 초기화 접속객체닫기등등을
	// 하나의 공통 클래스로 몰아 넣기. 재사용이 편함.
	//공통사용 로직은 commons, common 이라는 공동의 패키지를 별도로 두고
	//프로젝트 인원들이 같이 사용하도록 유도함. (디비접속, 숫자를 리턴하는 메소드 등등)
	
	
	//로그인
	public UserInfoDTO getLogin(ArrayList<JdbcDTO> list) {
		conn = getConn();
		//로그인 처리할때 sql문은 어떻게 해야할까
		String sql = "SELECT * \r\n"
				+ " FROM   user_info\r\n"
				+ " WHERE  user_id = 'girok'\r\n"
				+ " AND    user_pw = '1212'";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	//회원가입
	public boolean joinUser() {
		return false;
	}
	

}
