package day7;
/*
 * inner class : 독립적이지 않고 외부클래스에 종속적인 클래스
 *             : outter class를 생성하고 inner class를 생성해서 사용.
 *             : static inner class는 outter class를 생성하지 앟고도 사용이 가능.
 *             : outter의 member를 내것처럼 사용이 가능하다.
 * 1. member inner class // 
 *    
 * 2. static inner class // 거의 안씀
 * 3. local inner class	// 거의 안씀
 * 4. anonymous inner class // event 처리 할때 많이 사용
 */
public class InnerClass {	// outter class
	
	class B{	// member inner class
		
	}
	void disp() {
		
		
	}
	public static void main(String[] args) {
		InnerClass ic = new InnerClass();
	}
	
}
