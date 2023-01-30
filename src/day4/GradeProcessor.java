package day4;

import java.util.Scanner;

class Name {
	private String name;

	public Name() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하시오: ");
		this.name = sc.next();
	}

	public void dispName() {
		System.out.println("이름: " + name);
	}
}

class Subject {
	// 멤버 변수
	
	private int[] score;
	private int totalScore;
	private float avgScore;

	public Subject() {
		Scanner sc = new Scanner(System.in);

		int subjectCount = sc.nextInt();
		score = new int[subjectCount];
		for (int i = 1; i <= score.length; i++) {
			System.out.print(i + "번째 과목의 점수를 입력하시오: ");
			score[i - 1] = sc.nextInt();
		}
		totalScore = 0;
		for (int i = 0; i < score.length; i++) {
			totalScore += score[i];
		}
		avgScore = (float) (totalScore) / score.length;
	}

	public void dispScore() {
		for(int i = 1; i <= score.length; i++) {
			System.out.println(i + "번째 과목: " + score[i - 1]);
		}
		System.out.println("총점: " + totalScore);
		System.out.println("평균: " + avgScore);
	}
}

class Student {
	Name name;
	Subject subject;

	public Student() {
		name = new Name();
		subject = new Subject();
	}

	public void dispData() {
		System.out.println("\n[학생 정보 출력]");
		name.dispName();
		subject.dispScore();
	}
}

public class GradeProcessor {

	public static void main(String[] args) {
		Student student = new Student();
		student.dispData();
	}

}
