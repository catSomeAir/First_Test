package pack05.ojdbc2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInfoDAO extends StudentDAO{
	// 현 StudentDAO 를 상속받아서 썻다면 나중에는 접속객체를 초기화 접속객체닫기등등을
	// 하나의 공통 클래스로 몰아 넣기. 재사용이 편함.
	//공통사용 로직은 commons, common 이라는 공동의 패키지를 별도로 두고
	//프로젝트 인원들이 같이 사용하도록 유도함. (디비접속, 숫자를 리턴하는 메소드 등등)
	
//	UserInfoDAO dao = new UserInfoDAO();
	//전체 정보
	public ArrayList<UserInfoDTO> getUserList(){
		conn = getConn();
		ArrayList<UserInfoDTO> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement("select * from Student");
			rs = ps.executeQuery();
			UserInfoDTO dto = new UserInfoDTO(rs.getInt("STUDENT_NO"), rs.getString("USER_ID"), rs.getString("USER_PW"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("CREATE_YMD"), rs.getString("UPDATE_YMD"));
			while(rs.next()) {
				list.add(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}//getUserList()
	
	//로그인
	public UserInfoDTO getLogin(String user_id , String user_pw) {
		UserInfoDTO dto = new UserInfoDTO();
		conn = getConn();
		//로그인 처리할때 sql문은 어떻게 해야할까
		String sql = "SELECT *  FROM   user_info WHERE  user_id = ? AND user_pw = ?";
		try {
			ps = conn.prepareStatement(sql);
			
			// ?물음표로 처리한 sql문에 대한 값 넣어주기
			ps.setString(1, user_id);  //왼쪽을 기준으로 첫번째 물음표를 찾고 그 물음표에 어떤 값을 넣음
			ps.setString(2, user_pw);
			rs = ps.executeQuery();
//			int chk= -1;
			while(rs.next()) {
//				System.out.println("정보얻어옴");
				dto.setUSER_ID(rs.getString("user_id"));
				dto.setUSER_PW(rs.getString("user_pw"));
				dto.setFIRST_NAME(rs.getString("first_name"));
				dto.setLAST_NAME(rs.getString("last_name"));
				
//				if(user_id.equals(rs.getString("user_id"))&& user_pw.equals(rs.getString("user_pw"))) {
//					System.out.println("로그인성공");
//					chk= 1;
//				}else {
//					System.out.println("로그인실패");
//				}
			}
			
//			int chk = -1;
//			while(rs.next()) {
//				if(user_id.equals(rs.getString("user_id"))&& user_pw.equals(rs.getString("user_pw"))) {
//					System.out.println("로그인성공");
//					chk= 1;
//					return true;
//				}
//			}//while
//			
//			if(chk==-1) {
//				System.out.println("로그인실패");
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return dto;
		
	}//getLogin()
	
//	//중복확인
	public boolean joinCheck(UserInfoDTO dto) {		
	conn = getConn();
	String sql = "SELECT *  FROM   user_info WHERE  user_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUSER_ID());  
			rs = ps.executeQuery();
			while(rs.next()) {
				if(!(dto.getUSER_ID().equals(rs.getString("user_id")))) {
					return true;
				}else {
					System.out.println("중복된 아이디입니다.");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
	
	//메인에서 회원정보를 입력받고 입력받은 결과로 회원가입처리.
	
	return false;
	
}//joinCheck()
	
	
	//회원가입
	public boolean joinUser(UserInfoDTO dto) {
		//1.SQLD <- 되는 INSERT 쿼리를 만든다. ROLLBACK, COMMIT 을 꼮 함
		//2. JAVA작업 ( dto에 사용자가 입력한 정보를 묶어서 저장)
		//3. JAVA작업 ( dto를 메소드에 넘기고 출력해보기)
		//4. JDBC작업
		//(STUDENT_NO, USER_ID, USER_PW,FIRST_NAME,LAST_NAME, CREATE_YMD, UPDATE_YMD)
		conn = getConn();
		String sql = "INSERT INTO user_info VALUES (? , ?, ?, ?, ?, sysdate, sysdate)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, dto.getSTUDENT_NO()); 
				ps.setString(2, dto.getUSER_ID());
				ps.setString(3, dto.getUSER_PW());
				ps.setString(4, dto.getFIRST_NAME());
				ps.setString(5, dto.getLAST_NAME());
//				ps.setString(6, "SYSDATE");
//				ps.setString(7, "SYSDATE");
				int rs;
				rs = ps.executeUpdate();
				
					
//						
//							System.out.println("회원가입이 되었습니다.");
//					
//							System.out.println("회원가입 실패.");
//						}
//						
//						return true;
//					}else {
//						System.out.println("중복된 아이디입니다.");
//						
//					}
				dbClose();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				dbClose();
			}
		
		//메인에서 회원정보를 입력받고 입력받은 결과로 회원가입처리.
		
		return false;
		
	}//joinUser()
	
	//회원정보수정
	public void userInfoChange(UserInfoDTO dto) {
				
		conn = getConn();
		Scanner sc = new Scanner(System.in);
		System.out.println("| 1. 비밀번호 수정 | 2. 이름 수정 : ");
		String change = sc.nextLine();
		if(change.equals("1")) {
			change = "user_pw" ;
		}else if(change.equals("2")) {
			change = "first_name" ;
			
		}
		String sql = "UPDATE  user_info SET "+ change +" = ? WHERE user_id = ?";
			try {
				ps = conn.prepareStatement(sql);
				
				if (change.equals("user_pw")) {
					System.out.print("변경할 비밀번호를 입력하세요 : ");
					ps.setString(1, sc.nextLine());
				}else if(change.equals("first_name")) {
					System.out.println("변경할 이름을 입력하세요 : ");
					ps.setString(1, sc.nextLine());
				}
				
				ps.setString(2, dto.getUSER_ID());
				int rs;
				rs = ps.executeUpdate();
				if(rs!=-1) {
					System.out.println("회원 정보가 수정 되었습니다.");
				}else {
					System.out.println("회원 정보가 수정되지 않았습니다.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbClose();
			}
		
	}
	
	
	//정수입력
	public int rtnInt (Scanner sc, String msg) {
		while(true) {
			try {
				System.out.print(msg);
				 return Integer.parseInt(sc.nextLine()) ;
			}catch (Exception e) {
				System.out.println("다시 입력");
			}
		}
		
	}	
	//문자입력
		public String rtnString (Scanner sc, String msg) {
			while(true) {
				try {
					System.out.print(msg);
					 return sc.nextLine();
				}catch (Exception e) {
					System.out.println("다시 입력");
				}
			}
		}	

}
