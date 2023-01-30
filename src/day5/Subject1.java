package day5;

import java.util.Scanner;

public class Subject1 {
	private int score;	// 과목 점수

	public Subject1() {	// 생성자

	}
	public Subject1(int score) {	// 전달 받은 변수로 점수 입력 
		this.score = score;
	}
	public int getScore() {	// 점수 반환
		return score;
	}
	
	public void setScore() {	// 점수 설정
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하시오: ");
		score = sc.nextInt();
	}
	public void setScore(int score) {	// 전달 받은 변수로 점수 설정
		this.score = score;
	}
	
	
}
