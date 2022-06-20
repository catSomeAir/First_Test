package pack05.ojdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pack04.odjbc.JdbcDTO;

public class StudentDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	//jdbc를 통해서 연결과 연결해제 등등의 기능이 필요하다면 가지고 와야함.
	//API의 경우 내가 직접 코딩하는게 적음(==> 이미 만들어진 기능을 호출해서 사용)
	//따라서 어떤게 필요한지 외우고 빠지면 복붙해도 상관x
	// 연결, 전송 , 결과
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@221.144.89.105:3301:XE";
		String user = "hanul";
		String password = "0000";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
		
		return conn;
	}	
		
	public void dbClose() {
			
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	
	//① 전체 학생 정보 조회 목록메소드 : getStudentList();
	public ArrayList<JdbcDTO> getStudentList() {
		//커넥션등등을 이용해서 DB에서 정보를 가지고와 그결과를 리턴
		conn = getConn();
		ArrayList<JdbcDTO> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement("select * from student");
			rs = ps.executeQuery();
			while(rs.next()) {
//				System.out.println(rs.getInt("student_no") + " " + rs.getString("student_name"));
				list.add(new JdbcDTO(rs.getInt("STUDENT_NO"),rs.getString("STUDENT_NAME")));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return list;
	}
	
	//viewList라는 메소드는 조회된 결과를 전체 콘솔창에 출력
	public void viewList(ArrayList<JdbcDTO> list) {
		
		if(list == null || list.size()==0) {
			System.out.println("보여줄 목록이 없습니다.");
		}
		for (int i = 0; i < list.size() ; i++) {
			System.out.println(list.get(i).getStudent_no() + " " + list.get(i).getStudent_name());
		}
	}
	
	
	//② 로그인 처리를 위한 메소드 만들기 loginUser(); // 파라메타가 필요할까?
	public boolean loginUser(int student_no, String student_name) {
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 내가 알고 있는 어떤것이든 메소드의 리턴타입이 될 수 있음. 한계를 두지 말 것!.
	
	// 1. public, protected, default(생략), private = ( 접근제한자 ) : 어디까지 쓰게 해줄까
			//①
		// 2. 멤버의 구분 : static의 유무 = instacne화 해야 사용할수 있는가 없는가 판단.
		// 3. 리턴타입 : void 유무 - 리턴을 하는지 안하는지 구분.
		// 4. 메소드이름 : 소문자로 시작해서 그 기능을 구별할 수 있는 단어가 좋다.
		// 5. 매개변수 : 메소드() 의 괄호에 들어감. 메소드가 실행될 때 필요한 매개변수가 있다면 넘겨주는 부분.
	
//	public static void main(String[] args) {		//String[] args : 문자열 타입의 배열, args 메인메소드 시작시 문자열 담아두고 시작하는건데 뭐 딱히 잘안쓴단다..
//	
//	
//}
//	public ArrayList<String> getListString(){
//		return null;
//	}
//	public ArrayList<Integer> getListInteger(){
//		return null;
//	}
//	public void voidMethod() {
//		return ;		//이건 그냥 리턴없이 아무것도 실행안되기때문에 return이 존재할 수 있음. 리턴값이 있는경우는 바로 경고문 뜸
//	}
//
//	public ArrayList<String> voidMethod2() {
//		return new ArrayList<String>();
//	}
	
	
	
}
