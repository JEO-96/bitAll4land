package day4;
/*
 * 상속
 * 1. 100프로 상속구조로 구성이 되어있다.
 * 2. Object 클래스가 최상위 클래스
 * 3. 확장성, 재사용성 => is ~ a 관계 
 * 4. 단일상속이 원칙 ( 복잡성을 피하기 위해서 )
 * 5. 다중상속은 객체끼리는 허용불가. 인터페이스는 다중상속을 허용.
 * 6. 상속해주는 클래스 => super class, 부모클래스 
 *    상속받는 클래스 => sub class, 자식클래스
 * 7. super class는 항상 sub class의 공통된 사항이 멤버로 제공
 * 
 * 8. 상속받는다라는 의미는 super class의 모든 것을 내 것처럼 사용할 수 있다란 의미.
 * 9. superclass의 private member는 subclass에서 직접적으로 접근할 수 없다.
 */
public class InhertanceExam extends Object{

	public static void main(String[] args) {
		InhertanceExam in = new InhertanceExam();
		System.out.println(in.toString());
	}

}
