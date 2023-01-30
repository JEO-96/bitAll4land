package day4;

/*
 * final (마지막, 바꿀수없다.) => 상수화
 * 1. field : max(변수, 상수), Max(클래스), MAX(상수)  final static int MAX = 100; 선언과 동시에 초기화해야 한다.
 * 2. class : (상속)is ~ a 관계를 사용하지 않겠다. => Has ~ a 관계로 사용만 해라.
 * 3. method : 오버라이드 (재정의 하겠다)를 할 수 없다.
 */
public class Hello {
	public static void main(String[] args) {
		Hello22 hello = Hello22.HelloObject();
	}

}

class Hello22{
	
	int a;
	int b;
	
	private Hello22() { // 외부에서 절대 접근할 수 없다. 내부에서만 접근해라.
		System.out.println("Hello. 생성자");
	}
	
	public static Hello22 HelloObject() {
		Hello22 hello = new Hello22();
		return hello;
	}
}