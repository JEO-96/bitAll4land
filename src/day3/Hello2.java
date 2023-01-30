package day3;
/*
 * 오버로딩.
 * - 동일한 함수명으로 여러개의 함수를 제공하는 방법
 * - 같은 기능을 가지고 있는 함수끼리만 사용. ( 혼란을 피하기 위해 )
 * - 다형성
 * - 규칙
 *   1) 매개변수의 타입이 다를경우
 *   2) 매개변수의 개수가 다를경우
 *   3) 리턴타입이 다를경우 ( X )
 */

public class Hello2 {

	public void disp() {
		System.out.println("1");
	}
	public void disp(int a) {
		System.out.println("2");
	}
	public void disp(double b) {
		System.out.println("3");
	}
	public void disp(int a, int b) {
		System.out.println("4");
	}
	
	public static void main(String[] args) {
		
		Hello2 h = new Hello2();
		
		h.disp();
		h.disp(1);
		h.disp(2.4);
		h.disp(3, 4);

	}

}
