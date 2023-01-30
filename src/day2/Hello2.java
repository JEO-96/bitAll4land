package day2;

import java.util.Scanner;

/*
 * function, 함수, => method
 * 
 * -> instance method
 *    : 객체를 생성해야지만 사용할 수 있는 메소드
 *    : 매개변수의 첫번째 매개변수자리에는 항상 this 를 가지고 있다.
 *    : this는 객체를 구별해준다
 *    Hello2 h = new Hello2();
 *    h.disp();
 * 
 * -> static method
 * 	  : 컴파일타임에 생성이 되고 객체생성유무와 상관없이 미리 만들어진다.
 *      모든 곳에서 공유하는 개념.
 *    : this를 가지고 있지 않다.
 *    Hello2 h = new Hello2();
 *    h.disp(); // 인스턴스로 착각할 수 있다.
 *    Hello2.disp();  // 스태틱 메소드로 인식하게 된다.
 *    
 * -> 주로 public으로 지정을 합니다. (외부에서 접근을 허용하기 위해)
 *    
 *    모듈화
 *    1. call by name
 *    2. call by value
 *    3. call by reference
 *    
 */
// 접근지정자 defualt 패키지 안에서 사용 가능
public class Hello2 {

	static String[] inputLine() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("입력받을 사람 수: ");
		int manCount = sc.nextInt();
		String lines[] = new String[manCount];
		System.out.println("이름,국어,영어,수학 입력: ");
		sc.nextLine();
		for(int i = 0; i < manCount; i++) {
			lines[i] = sc.nextLine();
		}
		return lines;
	}
	
	static String[] inputNames(String[] lines) {
		String[] names = new String[lines.length];
		for(int i = 0; i < lines.length; i++) {
			 names[i] = lines[i].split(" ")[0];
		}
		return names;
	}
	
	static int[][] inputScore(String[] lines) {
		int[][] scores = new int[lines.length + 1][4];
		for(int i = 0; i < lines.length; i++) {
			String[] temp = lines[i].split(" ");
			scores[i][0] = Integer.valueOf(temp[1]);
			scores[i][1] = Integer.valueOf(temp[2]);
			scores[i][2] = Integer.valueOf(temp[3]);
			scores[i][3] = scores[i][0] + scores[i][1] + scores[i][2];
		}
		return scores;
	}
	static float[] calculate(int[][] score) {
		float []avgs = new float[score.length];
		for (int i = 0; i < score.length; i++) {
			avgs[i] = score[i][3] / ((float) score[i].length - 1);
		}
		return avgs;
	}

	static void printResult(String[] name, int[][] score, float[] avg) {
		for (int i = 0; i < name.length; i++) {
			System.out.println("이름: " + name[i] + ", 국어: " + score[i][0] + ", 영어: " + score[i][1] + ", 수학: "
					+ score[i][2] + ", 총점: " + score[i][3] + ", 평균: " + avg[i]);
		}
	}


	public static void main(String[] args) {

		/*
		 * 입력함수호출 ( 이름, 국, 영,수) 연산함수 (총점, 평균)
		 * 
		 * 출력 (이름, 국, 영, 수, 총, 평)
		 * 
		 */
		String []lines; // 입력받는 줄 수
		String []names; // 이름
		int [][]scores; // 국,영,수,총
		float []avgs;	// 평균
		lines = Hello2.inputLine();				// 라인별로 입력받기
		names = Hello2.inputNames(lines);		// 입력받은 라인에서 이름 추출
		scores = Hello2.inputScore(lines);		// 입력받은 라인에서 점수 추출
		avgs = Hello2.calculate(scores);		// 평균 계산
		Hello2.printResult(names, scores, avgs);// 결과 출력
	}
}
