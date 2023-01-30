package day4;

import java.util.Scanner;

public class Subject1 {
	int score;

	public Subject1() {

	}
	public Subject1(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	
	public void setScore() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하시오: ");
		score = sc.nextInt();
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
