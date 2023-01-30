package day3;

import java.util.Scanner;

class Calc{
	//field
	private float num1;
	private float num2;
	private char op;
	private float result;
	
	//method
	public float getNum1() {
		return num1;
	}
	public void setNum1(float num1) {
		this.num1 = num1;
	}
	public float getNum2() {
		return num2;
	}
	public void setNum2(float num2) {
		this.num2 = num2;
	}
	public char getOp() {
		return op;
	}
	public void setOp(char op) {
		this.op = op;
	}
	public float getResult() {
		return result;
	}
	public void setResult(float result) {
		this.result = result;
	}
	
	public float plus() {
		return result = num1 + num2;
	}
	public int plus( int num1, int num2) {
		return num1 + num2;
	}
}
public class Hello3 {

	public static void main(String[] args) {
		Calc calc = new Calc();
		Scanner sc = new Scanner(System.in);
		float num1 = sc.nextFloat();
		char op = sc.next().charAt(0);
		float num2 = sc.nextFloat();
		
		calc.setNum1(num1);
		calc.setOp(op);
		calc.setNum2(num2);

		// 계산기능 사용
		
		calc.plus();
		calc.plus(3,4);
	}

}
