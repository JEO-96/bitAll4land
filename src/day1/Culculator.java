package day1;
import java.util.Scanner;

public class Culculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		double num1 = sc.nextDouble();
//		String operator = sc.next();
//		double num2 = sc.nextInt();
//
//		double result = 0;

//		switch (operator) {
//		case "+":
//			result = num1 + num2;
//			break;
//		case "-":
//			result = num1 - num2;
//			break;
//		case "*":
//			result = num1 * num2;
//			break;
//		case "/":
//			result = num1 / num2;
//			break;
//		}
//		System.out.println(String.format("%.2f %s %.2f = %.2f", num1, operator, num2, result));
		char check = 'n';		
		do {
			double num1 = sc.nextDouble();
			String operator = sc.next();
			double num2 = sc.nextInt();
			double result = 0;
			switch (operator) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				result = num1 / num2;
				break;
			}
			System.out.println(String.format("%.2f %s %.2f = %.2f", num1, operator, num2, result));
			System.out.println("계속하기:'y', 중단하기:'n': ");
			check = sc.next().charAt(0);
		}while(check == 'y');
	}
}
