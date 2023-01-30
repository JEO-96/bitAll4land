package day5;

import java.util.Scanner;

public class StudentScoreMag1 {
	Name1 name;
	Subject1 kor;
	Subject1 eng;
	Subject1 mat;
	int total;
	float avg;
	
	public StudentScoreMag1() {
		name = new Name1();
		kor = new Subject1();
		eng = new Subject1();
		mat = new Subject1();
	}
	
	public StudentScoreMag1(String name, int kor, int eng, int mat) {
		this.name = new Name1(name);
		this.kor = new Subject1(kor);
		this.eng = new Subject1(eng);
		this.mat = new Subject1(mat);
		this.total = kor + eng + mat;
		this.avg = (float)total / 3;
	}
	
	public void setName(String name) {
		this.name.setName(name);
	}
	public void setKor(int kor) {
		this.kor.setScore(kor);
		total = this.kor.getScore() + eng.getScore() + mat.getScore();
		avg = (float)total / 3;
	}
	public void setEng(int eng) {
		this.eng.setScore(eng);
		total = kor.getScore() + this.eng.getScore() + mat.getScore();
		avg = (float)total / 3;
	}
	public void setMat(int mat) {
		this.mat.setScore(mat);
		total = kor.getScore() + eng.getScore() + this.mat.getScore();
		avg = (float)total / 3;
	}
	
	public int getKor() {
		return kor.getScore();
	}
	
	
	public int getEng() {
		return eng.getScore();
	}
	
	public int getMat() {
		return mat.getScore();
	}
	
	public int getTotal() {
		return total;
	}

	public String getName() {
		return name.getName();
	}
	public void dispName() {
		System.out.println("이름: " + name.getName());
	}
	
	public void dispScore() {
		System.out.println("국어: " + kor.getScore() + 
				" 영어: " + eng.getScore() +
				" 수학: " + mat.getScore() +
				" 총점: " + total +
				" 평균: " + avg) ;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentScoreMag1 ssm = new StudentScoreMag1();
		System.out.print("이름을 입력하시오: ");
		ssm.setName(sc.next());
		System.out.print("국어 점수를 입력하시오: ");
		ssm.setKor(sc.nextInt());
		System.out.print("영어 점수를 입력하시오: ");
		ssm.setEng(sc.nextInt());
		System.out.print("수학 점수를 입력하시오: ");
		ssm.setMat(sc.nextInt());
		ssm.dispScore();
	}
}
