package day3;

import java.util.Scanner;

class Student {
	// 멤버변수
	String name;	// 이름
	int kor;		// 국어점수
	int eng;		// 영어점수
	int math;		// 수학점수
	int totalScore;	// 총점
	float avgs;		// 평균
	 
	// 멤버함수
	public void printResult() {
		System.out.println(
				"이름: " + this.name +
				", 국어: " + this.kor +
				", 영어: " + this.eng +
				", 수학: " + this.math +
				", 총점: " + this.totalScore +
				", 평균: " + this.avgs);
	}
	// 생성자
	Student(){
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하시오: ");
		this.name = sc.next();
		System.out.println("점수를 입력하시오(국어 영어 수학): ");
		this.kor = sc.nextInt();
		this.eng = sc.nextInt();
		this.math = sc.nextInt();
		sc.nextLine();
		this.totalScore = kor + eng + math;
		this.avgs = ((float)kor + eng + math) / 3;
	}
}


public class GradeProcessing {
	
	public static int inputCount() {
		Scanner sc = new Scanner(System.in);
		System.out.print("사람 수를 입력하시오: ");
		int count = sc.nextInt();
		
		return count;
	}
	
	
	public static void main(String[] args) {
		int count;
		count = GradeProcessing.inputCount();
		Student[] list = new Student[count];	// 학생 리스트
		for(int i = 0; i < count; i++) {		// 학생 정보 생성
			list[i] = new Student();
		}
		for(int i = 0; i < count; i++) {		// 학생 정보 출력
			list[i].printResult();
		}
	}


}
