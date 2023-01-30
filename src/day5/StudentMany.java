package day5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class StudentKorComparator implements Comparator<StudentScoreMag1> {

	@Override
	public int compare(StudentScoreMag1 o1, StudentScoreMag1 o2) {
		if (o1.getKor() > o2.getKor()) {
			return 1;
		} else if (o1.getKor() < o2.getKor()) {
			return -1;
		}
		return 0;
	}

}

class StudentEngComparator implements Comparator<StudentScoreMag1> {
	@Override
	public int compare(StudentScoreMag1 o1, StudentScoreMag1 o2) {
		if (o1.getEng() > o2.getEng()) {
			return 1;
		} else if (o1.getEng() < o2.getEng()) {
			return -1;
		}
		return 0;
	}
}

class StudentMatComparator implements Comparator<StudentScoreMag1> {
	@Override
	public int compare(StudentScoreMag1 o1, StudentScoreMag1 o2) {
		if (o1.getMat() > o2.getMat()) {
			return 1;
		} else if (o1.getMat() < o2.getMat()) {
			return -1;
		}
		return 0;
	}
}

class StudentTotalComparator implements Comparator<StudentScoreMag1> {
	@Override
	public int compare(StudentScoreMag1 o1, StudentScoreMag1 o2) {
		if (o1.getTotal() > o2.getTotal()) {
			return 1;
		} else if (o1.getTotal() < o2.getTotal()) {
			return -1;
		}
		return 0;
	}
}

public class StudentMany {

	public static void inputData(ArrayList<StudentScoreMag1> ssm) { // 학생 정보를 입력하는 함수
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하시오: ");
		String name = sc.next();
		System.out.print("국어 점수를 입력하시오: ");
		int kor = sc.nextInt();
		System.out.print("영어 점수를 입력하시오: ");
		int eng = sc.nextInt();
		System.out.print("수학 점수를 입력하시오: ");
		int mat = sc.nextInt();
		sc.nextLine();
		ssm.add(new StudentScoreMag1(name, kor, eng, mat)); // 입력받은 정보로 학생 생성
	}

	public static void search(ArrayList<StudentScoreMag1> ssm) { // 학생 정보를 이름으로 검색하는 함수
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하시오: ");
		String name = sc.next();
		for (int i = 0; i < ssm.size(); i++) {
			if (ssm.get(i).getName().equals(name)) { // 입력받은 이름으로 index 검색
				ssm.get(i).dispName(); // 해당하는 index의 이름 출력
				ssm.get(i).dispScore(); // 해당하는 index의 점수 출력
			}
		}
	}

	public static void remove(ArrayList<StudentScoreMag1> ssm) { // 학생 정보를 이름으로 삭제하는 함수
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하시오: ");
		String name = sc.next(); // 이름 입력
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < ssm.size(); i++) {
			if (ssm.get(i).getName().equals(name)) { // 입력받은 이름과 같은 이름을 가진 index를 발견하면 제거
				list.add(i);
			}
		}
		if (list.size() == 1) {
			ssm.remove(list.get(0));
		} else if (list.size() > 1) {

			for (int i = 0; i < list.size(); i++) {
				System.out.println("이름이 같은 인덱스 번호: " + list.get(i));
			}
			System.out.print("삭제할 인덱스를 입력하시오: ");
			ssm.remove(sc.nextInt());
			sc.nextLine(); // 개행문자 제거
		}
	}

	public static void dispAllData(ArrayList<StudentScoreMag1> ssm) { // 모든 학생 정보를 출력하는 함수
		ArrayList<StudentScoreMag1> temp = ssm;
		Scanner sc = new Scanner(System.in);
		System.out.print("1. 국어, 2. 영어, 3. 수학, 4. 총점 정렬할 과목을 고르시오:");
		int subject = sc.nextInt();
		switch(subject) {
		case 1:
			temp.sort(new StudentKorComparator().reversed());
			break;
		case 2:
			temp.sort(new StudentEngComparator().reversed());
			break;
		case 3:
			temp.sort(new StudentMatComparator().reversed());
			break;
		case 4:
			temp.sort(new StudentTotalComparator().reversed());
			break;
		}
		
		for (int i = 0; i < ssm.size(); i++) { // ArrayList 만큼 반복하여 모든 이름과 점수를 출력
			temp.get(i).dispName(); // 이름 출력
			temp.get(i).dispScore(); // 점수 출력
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<StudentScoreMag1> ssm = new ArrayList<StudentScoreMag1>(); // 학생 정보를 저장할 ArryList
		boolean check = true; // 반복문 탈출 확인
		int mode = 0; // 기능 선택
		do {
			System.out.println("1. 성적입력, 2. 검색(이름), 3. 삭제(이름), 4. 출력, 5. 종료: ");
			mode = sc.nextInt(); // 기능 선택
			sc.nextLine(); // 개행 문자 제거
			switch (mode) {
			case 1:
				inputData(ssm); // 학생 정보 입력
				break;
			case 2:
				search(ssm); // 이름으로 배열 안에 있는 index 탐색
				break;
			case 3:
				remove(ssm); // 이름으로 배열 안에있는 index를 탐색 후 해당하는 데이터 제거
				break;
			case 4:
				dispAllData(ssm); // 모든 학생정보 출력
				break;
			case 5:
				check = false; // 반복문 탈출
				break;
			}
		} while (check);
	}

}
