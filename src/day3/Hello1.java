package day3;
/*
 * 생성자함수
 * 1. 목적: 객체 생성시 필드 초기화 -> 사용자 기준 (명시적으로 만들어서 사용) + 객체등록 
 *       : 디폴트 기준 -> 객체등록
 * 2. default constructor 는 명시적으로 생성자를 제공하지 않을 경우
 * 3. 명시적으로 생성자를 만들경우 디폴트 생성자는 제공되지 않는다.
 * 4. 오버로딩이 가능.
 * 5. 외부에서 접근을 하기때문에 주로 public으로 사용한다..
 * 6. 리턴타입이 존재하지 않고, 함수명은 클래스명과 동일,
 * 
 * 
 * this호출 
 * : 생성자에서 또 다른 (오버로딩된) 생성자를 호출하기 위해서 제공.
 * 
 */
public class Hello1 {

	int a;
	int b;
	
	
	public Hello1() { // default constructor
		this(0 ,0);
	}
	
	public Hello1(int a) {
		// this.a = a;
		this(a, 0);
	}
	
	public Hello1(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public static void main(String[] args) {
		Hello1 hello1 = new Hello1(); // 생성자함수 호출
		Hello1 hello2 = new Hello1(1); // 생성자함수 호출
		Hello1 hello3 = new Hello1(2, 3); // 생성자함수 호출
		
		System.out.println(hello1.getA() + " " + hello1.getB()); // 0 0
		System.out.println(hello2.getA() + " " + hello2.getB()); // 1 0
		System.out.println(hello3.getA() + " " + hello3.getB()); // 2 3
	}

}
