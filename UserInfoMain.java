package pack05.ojdbc2;

import java.util.Scanner;

import javax.swing.InputMap;



public class UserInfoMain {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 1. 메뉴보여주기 ( 1번. 전체 학생 조회, 2번. 로그인 , 3.회원가입)
		// 로그인을 완료( 회원정보보기, 수정, 삭제 )
		//자바코드로만 콘솔창에 다음과 같은 결과가 되게끔 프로그램해보기
		UserInfoDAO dao = new UserInfoDAO();
			Scanner sc = new Scanner(System.in);
			UserInfoDTO dto = null; //로그인하기전
			
			int inputMenu = 0;
			while(true) {
				if(dto == null || dto.getUSER_ID() == null) {
					System.out.print("| 1. 전체 학생 조회 | 2. 로그인 | 4. 회원가입 | 5. 종료 ▶ ");
					inputMenu = Integer.parseInt(sc.nextLine());
					
					//전체학생조회
					if(inputMenu==1) {
						System.out.println("학생 조회");
						//① DTO만들기 : 데이터베이스에 있는 int String타입 묶어서  DTO만들기
	//					dao.getStudentList();
						
						dao.viewList(dao.getStudentList());
						
					//로그인	
					}else if(inputMenu==2){
						
						//아이디 입력받기
						String user_id = dao.rtnString(sc, "ID : ");
						//비밀번호입력받기
						String user_pw = dao.rtnString(sc, "PW : ");
						dto = dao.getLogin(user_id, user_pw);
						
					
					}else if(inputMenu==4){
						System.out.println("회원가입");
						
						dao.joinUser(new UserInfoDTO(dao.rtnInt(sc, "No : "), dao.rtnString(sc, "ID : "), dao.rtnString(sc, "PW : "), dao.rtnString(sc, "이름 : "), dao.rtnString(sc, "성 : ")));
	//					System.out.print("No : ");
	//					int student_no = Integer.parseInt(sc.nextLine());
	//					System.out.print("ID : ");
	//					String user_id = sc.nextLine();
	//					System.out.print("PW : ");
	//					String user_pw = sc.nextLine();
	//					System.out.print("이름 : ");
	//					String frist_name = sc.nextLine();
	//					System.out.print("성 : ");
	//					String last_name = sc.nextLine();
						
					}else if(inputMenu==5){
						System.out.println("종료");
						dao.dbClose();
						break;
					}else {
						System.out.println("잘못 된 입력 입니다.");
					}
				}else {
					if(inputMenu == 3) {
						
					}
					
					System.out.print("1.회원정보 보기, 2.로그아웃, 3.삭제  4.초기화면 5.수정");
					int menu = Integer.parseInt(sc.nextLine());
					if(menu==1) {
						
					}else if(menu ==5) {
						dao.userInfoChange(dto);
						continue;
					}else if(menu ==3) {
						
					}else if(menu == 4) {
						main(null);
					}else if(menu ==2) {
						dto= null;
						break;
					}
					
				}
			}//while
			sc.close();
	}//main()
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
