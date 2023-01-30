package day4;

import java.util.Scanner;

public abstract class Memory1 {
	protected int[] memory;
	protected int point;
	
	public Memory1() {
		memory = new int [5];
		point = 0;
	}
	
	protected void showMemory() {
		System.out.print("[메모리]:");
		for(int i = 0; i < memory.length; i++) {
			System.out.print(memory[i] + " ");
		}
		System.out.println();
	}
	
	public void push() {
		Scanner sc = new Scanner(System.in);
		if (point == memory.length) {
			System.out.println("메모리가 가득 찼습니다.");
		}
		else {
			System.out.println("Push 할 숫자 입력: ");
			memory[point++] = sc.nextInt();
		}
		showMemory();
		
	}
	public abstract void pop();
	
}
