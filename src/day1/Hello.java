package day1;
import java.lang.*;

/*
 *  사용자정의 이름 짓는 규칙.
 *  1. 첫글자는 영문자.
 *  2. 특수문자 사용불가
 *  3. 키워드 사용불가
 *  4. 최대 32자 지원.
 *  5. 중요 : 의미부여 ( 알기 쉽게 )
 *  
 */
public class Hello extends Object {

	public static void main(String[] args) {
		int a = 1;
		if (a == 1) {

		}
		if (a == 1) {

		} else {

		}

		if (a == 1) {
			System.out.println("1");
		} else if (a == 2) {
			System.out.println("2");
		} else if (a == 3) {
			System.out.println("3");
		} else {
			System.out.println("Nothing");
		}
		switch (a) {

		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		case 3:
			System.out.println("3");
			break;
		default:
			System.out.println("Nothing");
			break;
		}
	}
}
