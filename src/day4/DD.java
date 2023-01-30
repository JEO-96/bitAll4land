package day4;
/*
 *     super()
 *     => 현재 객체가 상속받고 있는 생성자를 호출
 *     => 면시적으로 사용한다는 이야기는 상위클래스의 오버로딩된 생성자를 고르겠다.
 *     
 *     오버라이딩. ( 다형성 ) => 동적바인딩.
 *     : 부모의 메소드를 재정의
 *     : 부모가 제공하는 기능을 가공( 추가, 삭제, 변경 )
 *     : 부모를 부르고 싶으면 => super
 */
public class DD extends CC{
	public DD(){
		// 생성자의 첫번 째 라인에는 항상 super()이 존재
		super(1);
		
		System.out.println("DD 생성");
	}
	
	@Override	// 부모클래스에서 정의된 함수를 자식클래스에서 재정의
	public void dispCC() {
		super.dispCC(); // 부모의 멤버를 접근
		System.out.println("Hello");
	}
	
	public static void main(String[] args) {
		DD dd = new DD(); // DD생성자 호출
		dd.dispCC();
	}
}
