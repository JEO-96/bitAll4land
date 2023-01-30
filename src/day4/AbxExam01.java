package day4;
/*
 * 동적바인딩
 * : 부모의 레퍼런스로 자식을 접근하는 방식.
 *   하나의 부모클래스로 여러가지 자식클래스에 접근할 수 있다.
 * 
 * 정적바인딩
 * : 내가 나를 접근하는 방식.
 */
public class AbxExam01 {

	public static void main(String[] args) {
		
		Circle cir = new Circle();
		Rect rect = new Rect();
		Tri tri = new Tri();
		Area area;
		
		area = cir;
		
		area.draw(); // cir.draw();
		
		area = rect;
		area.draw(); // rect.draw();
		
		area = tri;
		area.draw(); // tri.draw();
	}

}
