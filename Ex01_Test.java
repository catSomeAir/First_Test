package pack04.odjbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Ex01_Test {
	
	//● Oracle Java DataBase Connection : OJDBC 오라클이랑 자바랑 연결해주는 라이브러리
	//		→ DTO(데이터에 접근해서 뿌릴때), DAO(데이터에 접속하기위해) 
	public static void main(String[] args) {
		Ex01_Test et = new Ex01_Test();
		et.connTest2();
	}//main()
	
	//Connection <= 연결로를 만드는 객체( 연결 객체 )
	// PreparedStatement <= 어떤 데이터를 전송하기위한 객체 ( 연결된 연결 객체로를 통해서 전송함 )
	// ResultSet <= 전송하고 나서 응답을 받으면 그 결과를 담는 객체 ( 결과 객체 )
	
	//오라클에 연결되는지 테스트 메소드 
//	public boolean connTest() {	//url, user, password, Ojdbc Class ( 동적 로딩 = 자주안씀)
//		
//		// oracle.jdbc.driver.OracleDriver
//		
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
//		String user = "hanul";
//		String password = "0000";
//		
//		//커넥션을 위한 Class 동적로딩 forName
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection conn = DriverManager.getConnection(url, user, password);
//			if(conn.isClosed()) {
//				System.out.println("닫힘");
//			}else {
//				System.out.println("열림");
//				
//				//★ 통신이 열린상태에서 연결상태에서 데이터가 오갈 수 있게 해줘야함 : PreparedStatement ps로만들자 prepareStatement("sQL 데이터") ←세미콜론 NO
//				PreparedStatement ps = conn.prepareStatement(" select 1 num from dual");
//				ResultSet rs = ps.executeQuery();		//
//				//데이터 가지고왔을때 뽑아내는 방식은 rs.next() 메소드 → bool타입이라 while문 조건식에 사용가능 데이터가 있으면 true 없으면  false임
//				while(rs.next()) {
//					System.out.println(rs.getInt("num"));	//컬럼명
//					System.out.println(rs.getInt(1));		//index 0은 오라클이 쓰고있어서 index는 1번부터시작이다.
//					//↑ 속성인덱스로 바꾸면 안된다. 왜냐하면 SQL 속성순서는 얼마든지 바뀔 수 있으므로 타입도 달라지고 오류날 수 있따.
//					
//					
//				}
//				
//				
//				conn.close();//통신이 열렸을때 닫는거는 Connection 클래스의 close()메소드 : 동시접속자 수가 정해져있어서 닫아줘야함.
//				//닫혔는지 체크
//				if(conn.isClosed())System.out.println("닫힘(내가 닫음)");
//			}
//					
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return false;
//	}
	
	public boolean connTest2() {
		Scanner sc = new Scanner(System.in);
		
		// oracle.jdbc.driver.OracleDriver
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hanul";
		String password = "0000";
		
		//커넥션을 위한 Class 동적로딩 forName
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, password);
			if(conn.isClosed()) {
				System.out.println("닫힘");
			}else {
				System.out.println("열림");
				
				//★ 통신이 열린상태에서 연결상태에서 데이터가 오갈 수 있게 해줘야함 : PreparedStatement ps로만들자 prepareStatement("sQL 데이터") ←세미콜론 NO
				PreparedStatement ps = conn.prepareStatement(sc.nextLine());
				ResultSet rs = ps.executeQuery();		//
				//데이터 가지고왔을때 뽑아내는 방식은 rs.next() 메소드 → bool타입이라 while문 조건식에 사용가능 데이터가 있으면 true 없으면  false임
				while(rs.next()) {
					System.out.println(rs.getString("name"));	//컬럼명
//					System.out.println(rs.getString(2));		//index 0은 오라클이 쓰고있어서 index는 1번부터시작이다.
					//↑ 속성인덱스로 바꾸면 안된다. 왜냐하면 SQL 속성순서는 얼마든지 바뀔 수 있으므로 타입도 달라지고 오류날 수 있따.
					
					
				}
				
				
				conn.close();//통신이 열렸을때 닫는거는 Connection 클래스의 close()메소드 : 동시접속자 수가 정해져있어서 닫아줘야함.
				//닫혔는지 체크
				if(conn.isClosed())System.out.println("닫힘(내가 닫음)");
			}
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}//class