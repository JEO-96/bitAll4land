package day4;

import java.util.Scanner;

public class Test2 {
	static void choiceMode(Scanner sc, MyStack1 stack, MyQueue1 queue, Memory1 memory) {
		while (true) {
			System.out.print("1(Stack), 2(Queue), 3(Quit): ");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("스택 선택");
				memory = stack;
				break;
			case 2:
				System.out.println("큐 선택");
				memory = queue;
				break;
			case 3:
				System.out.println("종료");
				System.exit(0);
			}
			loop(memory);
		}
	}

	static void loop(Memory1 memory) {
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		do {
			System.out.print("1. Push, 2. Pop, 3. Quit: ");
			switch (sc.nextInt()) {
			case 1:
				sc.nextLine();
				memory.push();
				break;
			case 2:
				memory.pop();
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
		Memory1 memory = null;
		choiceMode(sc, stack, queue, memory);

	}

}
