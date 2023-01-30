package day4;

import java.util.Scanner;

public class MyStack1 extends Memory1 {

	@Override
	public void pop() {
		if (point == 0) {
			System.out.println("메모리가 비어있습니다");
		}
		else {
			int val = memory[point - 1];
			System.out.println("값: " + val);
			memory[--point] = 0;
		}
		showMemory();
	}
}
