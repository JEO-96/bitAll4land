package day3;
/*
 * field : 클래스 내에서 지속적으로 사용되어지는 데이터.
 *        - 접근지정자 private 주로 지정.
 * 
 * method : 주목적으로 외부와 내부를 연결시켜주는 기능.
 *          setter: 외부에서 필드의 값을 입력
 *          getter: 외부에서 필드의 값을 사용
 *          
 *          주로 public 으로 지정.
 *          
 *          this는 instance method의 첫번째 매개변수로 항상 존재.
 *          this: 자기자신의 객체를 인식하는 레퍼런스변수 
 *              - 객체구별 -> 메모리절약효과.
 *              
 *               
 *          this를 명시적으로 사용해야 하는 경우
 *          1. 지역변수와 필드명이 같을 경우 필드를 인식하기 위해 명시적으로 사용해라.
 *          2. 인스턴스메소드에서 자기자신의 객체를 리턴하고자 할 경우
 *          
 *          
 *     static method : this가 존재하지 않음
 *                     this는 객체를 구분하기위해 만든것 static은 객체를 구분할 필요 없음 
 *                     객체를 구별하지 않는 경우에 사용 static 관리
 *                     
 *          
 */
public class Hello {
	
	private int a;
	private int b;
	
	public void setA(int a) {  // DI public void setA(Hello this, int aa)
		this.a = a;
	}
	public void setB(int b) {  // public void setB(Hello this, int bb)
		this.a = b;
	}
	public Hello getThis() {
		return this;
	}
	
	public int getA() { // public int getA(Hello this)
		return this.a;
	}
	
	public int getB() { // public int getB(Hello this)
		return this.b;
	}
	public static void main(String[] args) {  // 외부라고 생각하고 작업
		Hello h = new Hello(); // 객체생성
		
		h.setA(1000);
		h.setB(2000);
		System.out.println(h.getA());
		System.out.println(h.getB());
		
	}

}
