package day4;
/*
 *  추상클래스 : 구체화가 되지 않는 클래스
 *          : 객체를 생성할 수 없다.
 *          - 기본적으로 상속을 목적으로 사용.
 *          - super class로 사용 
 *          
 *  - 추상메소드를 하나이상 가지고 있는 클래스
 *  - 추상메소드란 바디가 없는 메소드 즉, 이름만 가지고 있는 메소드
 *  - 추상메소드는 오버라이드 ( 강제성을 부여 ): 추상메소드는 객체를 생성할 수 없음
 */


abstract class Abs{  // 추상클래스
	abstract void disp();  // 추상메소드
}
public class AbsClass extends Abs {
	public static void main(String[] args) {
		// Abs abs = new Abs();     추상클래스는 객체를 생성할 수 없다.
	}

	@Override
	void disp() {
		
	}
}
