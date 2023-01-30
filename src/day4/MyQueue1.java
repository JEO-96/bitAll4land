package day4;

import java.util.Scanner;

public class MyQueue1 extends Memory1 {
	@Override
	public void pop() {
		if (point == 0) {
			System.out.println("메모리가 비었습니다");
		} else {
			int val = memory[0];
			for (int i = 1; i < memory.length; i++) {
				memory[i - 1] = memory[i];
			}
			System.out.println("값: " + val);
			memory[--point] = 0;
		}
		showMemory();
	}
}
