package day4;

import java.util.Scanner;

public class StudentMnay {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생수를 입력하시오: ");
		StudentScoreMag1 []ssm = new StudentScoreMag1[sc.nextInt()];
		for(int i = 0; i < ssm.length; i++) {
			ssm[i] = new StudentScoreMag1();
			System.out.print("이름을 입력하시오: ");
			ssm[i].setName(sc.next());
			System.out.print("국어 점수를 입력하시오: ");
			ssm[i].setKor(sc.nextInt());
			System.out.print("영어 점수를 입력하시오: ");
			ssm[i].setEng(sc.nextInt());
			System.out.print("수학 점수를 입력하시오: ");
			ssm[i].setMat(sc.nextInt());
		}
		for(int i = 0; i < ssm.length; i++) {
			ssm[i].dispName();
			ssm[i].dispScore();
		}
			
	}
	
}
