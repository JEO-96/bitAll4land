/*
 * 성적처리프로그램
 * 1. 입력 : 이름,국,영,수
 * 2. 연산 : 총점, 평균
 * 3. 출력 : 이름, 국어, 영어, 수학, 총점, 평균
 * 4. 여러사람성적, 배열할당.
 */
package day2;

import java.util.Scanner;

public class Hello3 {

	public static void main(String[] args) {
		
		String []name;
		int [][]score; // 국,영,수,총
		float []avg;
		int manCount;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("입력받을 사람 수: ");
		manCount = sc.nextInt();
		score = new int[manCount][4];
		name = new String[manCount];
		avg = new float[manCount];
		System.out.println("이름,국어,영어,수학 입력: ");
		for(int i = 0; i < manCount; i++) {
			String temp = sc.next();
			String[] temp2 = temp.split(",");
			name[i] = temp2[0];
			for(int j = 1; j < temp2.length; j++) {
				score[i][j-1] = Integer.valueOf(temp2[j]); 
			}
			score[i][3] = score[i][0] + score[i][1] + score[i][2];
			avg[i] = score[i][3] / ((float)score[i].length - 1);
		}
		
		
		for(int i = 0; i < manCount; i++) {
			System.out.println("이름: " + name[i] + 
					", 국어: " + score[i][0] + 
					", 영어: " + score[i][1] +
					", 수학: " + score[i][2] +
					", 총점: " + score[i][3] +
					", 평균: " + avg[i]);
		}
		

	}

}
