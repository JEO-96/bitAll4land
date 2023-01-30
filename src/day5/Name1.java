package day5;

public class Name1 {
	String name;	// 학생 이름
	
	public Name1() {	// 생성자
		
	}
	public Name1(String name) {	// 받은 이름으로 name 초기화
		this.name = name;
	}
	
	public String getName() {	// 이름 반환
		return name;
	}
	
	public void setName(String name) {	// 이름 설정
		this.name = name;
	}
	
	
}
