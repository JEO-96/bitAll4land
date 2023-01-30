package day4;

import java.util.Scanner;

public class Test1 {

	static void choiceMode(Scanner sc, MyStack1 stack, MyQueue1 queue) {
		while (true) {
			System.out.print("1(Stack), 2(Queue), 3(Quit): ");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("스택 선택");
				stackLoop(stack);
				break;
			case 2:
				System.out.println("큐 선택");
				queueLoop(queue);
				break;
			case 3:
				System.out.println("종료");
				System.exit(0);
			}
		}
	}

	static void stackLoop(MyStack1 stack) {
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		do {
			System.out.print("1. Push, 2. Pop, 3. Quit: ");
			switch (sc.nextInt()) {
			case 1:
				stack.push();
				break;
			case 2:
				stack.pop();
				break;
			case 3:
				check = false;
				break;
			}
		} while (check);
	}

	static void queueLoop(MyQueue1 queue) {
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		do {
			System.out.print("1. Push, 2. Pop, 3. Quit: ");
			switch (sc.nextInt()) {
			case 1:
				sc.nextLine();
				queue.push();
				break;
			case 2:
				queue.pop();
				break;
			case 3:
				check = false;
				break;
			}
		} while (check);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyStack1 stack = new MyStack1();
		MyQueue1 queue = new MyQueue1();
		choiceMode(sc, stack, queue);

	}

}
