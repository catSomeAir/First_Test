package pack05.ojdbc2;

public class StudentDTO {
	private int student_no;
	private String student_name;
	//★ 생성자 만드는 이유 ( get, set을 이용해서도 필드 값을 세팅할 수 있지만(private)
	//객체를 생성하자마자 필드에 바로 값을 주는게 편할 때 사용을 함
	//ex) StudentDTO dto = new StudentDTO();
	//dto.setField,...
	//StudentDTO dto = new StudentDTO(field1, field2); <==더편함
	
	//Field에 비어있는 값이 없게 생성을 해야하는 경우에는 반드시 생성자메소드
	
	public StudentDTO(int student_no, String student_name) {
		this.student_no = student_no;
		this.student_name = student_name;
	}
	public int getStudent_no() {
		return student_no;
	}
	public void setStudent_no(int student_no) {
		this.student_no = student_no;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
	
	
}
