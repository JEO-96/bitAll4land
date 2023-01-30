package day5;
/*
 * 1. 추상클래스를 더 추상화 시킨 개념.
 * 2. 다중상속을 대체할 수 있게 사용.
 * 3. 구성요소 : 상수 + 추상메소드
 * 4. 식당의 메뉴판. 눈에는 보이지만 구체화 된것이 없다.
 * 5. 다중상속이 가능하다.
 * 6. 강제성
 * 7. 동적바인딩 가능
 * 
 * interface 이름{
 * 상수
 * 추상메소드
 * }
 */

interface Aaa {
	final static int a = 100; // interface 에는 final static 이 생략되어있음

	abstract void disp1(); // interface 에는 abstract가 생략되어있음
}

interface Bbb {
	final static int a = 100; // interface 에는 final static 이 생략되어있음

	abstract void disp2(); // interface 에는 abstract가 생략되어있음
}

interface Acc extends Aaa, Bbb { // 같은 성질을 가진 클래스는 다중상속이 가능 

}

public class InterExam implements Acc {

	public static void main(String[] args) {
		Acc aaa = new InterExam(); // 동적바인딩.
		aaa.disp1();
		aaa.disp2();
	}

	@Override
	public void disp1() {
		System.out.println("Aaa");
	}

	@Override
	public void disp2() {
		// TODO Auto-generated method stub

	}

}
