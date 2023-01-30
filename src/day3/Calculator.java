package day3;

import java.util.Scanner;

/*
 * 사칙연산 계산기 => 클래스화
 * 
 * 필드, 메소드
 */
public class Calculator {

	private int a;
	private int b;
	private char sign;

	public void inputNumNSign() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하시오: ");
		this.setA(sc.nextInt());
		System.out.println("기호를 입력하시오: ");
		this.setSign(sc.next().charAt(0));
		System.out.println("숫자를 입력하시오: ");
		this.setB(sc.nextInt());
	}

	public void setA(int a) {
		this.a = a;
	}

	public void setB(int b) {
		this.b = b;
	}

	public void setSign(char sign) {
		this.sign = sign;
	}

	public int getA() {
		return this.a;
	}

	public int getB() {
		return this.b;
	}

	public char getSign() {
		return this.sign;
	}

	public int sum() {
		return this.a + this.b;
	}

	public int sub() {
		return this.a - this.b;
	}

	public int mul() {
		return this.a * this.b;
	}

	public float div() {
		return this.a / (float) this.b;
	}

	public void printResult() {

		switch (this.getSign()) {
		case '+':
			System.out.println("결과는 " + this.sum() + "입니다."); 
			break;
		case '-':
			System.out.println("결과는 " + this.sub() + "입니다."); 
			break;
		case '*':
			System.out.println("결과는 " + this.mul() + "입니다."); 
			break;
		case '/':
			System.out.println("결과는 " + this.div() + "입니다."); 
			break;
		}
	}
	public static boolean check() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계속 하시겠습니까?: ");
		boolean check;
		if ('y' == sc.next().charAt(0)) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}
	public static void main(String[] args) {

		Calculator Cal = new Calculator();
		boolean boolCheck = true;
		do {
			Cal.inputNumNSign();
			Cal.printResult();
			boolCheck = Calculator.check();
			
		} while (boolCheck);

	}

}
