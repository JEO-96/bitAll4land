package day4;
/*
 * 클래스 관계
 * 
 * Is ~ A 관계 ( 상속 ): ~는 ~이다.
 * -> is like a 관계 : ~는 ~와 같다.
 * 
 * Has ~ A 관계 ( 포함오브젝트 ): ~는 ~를 가지고 있다.
 * 
 * 
 */

class A{  // 데이터클래스 : 항상 독립적으로 만들어라. 
	public A(){
		System.out.println("A");
	}
	public void dispA() {
		System.out.println("Disp::A");
	}
}

class B{  // 
	public B() {
		System.out.println("B");
	}
	public void dispB() {
		System.out.println("Disp::B");
	}
}

public class Hello2 {
	
	A aa;  // has ~ a 관계
	B bb;
	
	public Hello2() {
		aa = new A();
		bb = new B();
	}
	
	public void dispA() {
		aa.dispA();
	}
	
	public static void main(String[] args) {
		Hello2 h2 = new Hello2();
		
		h2.dispA();
	}

}