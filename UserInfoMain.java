package pack05.ojdbc2;

import java.util.ArrayList;
import java.util.Scanner;

import pack04.odjbc.JdbcDAO;
import pack04.odjbc.JdbcDTO;


public class UserInfoMain {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 1. 메뉴보여주기 ( 1번. 전체 학생 조회, 2번. 로그인 , 3.회원가입)
		// 로그인을 완료( 회원정보보기, 수정, 삭제 )
		//자바코드로만 콘솔창에 다음과 같은 결과가 되게끔 프로그램해보기
		StudentDAO dao = new StudentDAO();
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.print("| 1. 전체 학생 조회 | 2. 로그인 | 3.회원가입 | 4. 종료 ▶ ");
				int inputMenu = Integer.parseInt(sc.nextLine());
				if(inputMenu==1) {
					System.out.println("학생 조회");
					//① DTO만들기 : 데이터베이스에 있는 int String타입 묶어서  DTO만들기
//					dao.getStudentList();
					
					dao.viewList(dao.getStudentList());
				}else if(inputMenu==2){
					System.out.println("로그인");
					if(true) {
						System.out.println("1.회원정보 보기, 2.수정, 3.삭제");
					}
				
				}else if(inputMenu==3){
					System.out.println("회원가입");
				}else if(inputMenu==4){
					System.out.println("종료");
					break;
				}else {
					System.out.println("잘못 된 입력 입니다.");
				}
			}
	}
}//class


//
//UserInfoMain info = new UserInfoMain();
//
//
//JdbcDAO dao = new JdbcDAO();
//
//try {
//	if(dao.getConn().isClosed()) {
//		System.out.println("닫힘");
//	}else {
////		System.out.println("열림");
//		System.out.print("1번. 전체 학생 조회, 2번. 로그인 , 3.회원가입 ▶");
//		int chk = Integer.parseInt(sc.nextLine());
//		if(chk==1) {
//			
//			ArrayList<JdbcDTO> list = dao.studentMember();
//			for (int i = 0; i < list.size(); i++) {
//				System.out.print(list.get(i).getStudent_no()+"\t");
//				System.out.println(list.get(i).getStudent_name()+'\n');
//			}
//			
//		}else if(chk==2) {
//			System.out.println("로그인 완료");
//			info.login();
//		}else if(chk==3){
//			
//		}else {
//			info.main(null);
//		}
//
//		dao.dbClose();
//	}
//} catch (Exception e) {
//	
//	e.printStackTrace();
//}
//	
//
//
//}//main()
//
//public void login() {
//
//System.out.print("1번. 회원정보보기, 2번. 수정 , 3.삭제 ▶");
//int login = Integer.parseInt(sc.nextLine());
