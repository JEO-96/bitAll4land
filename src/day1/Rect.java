package day1;
public class Rect {

	public static void main(String[] args) {

//		int count = 0;
//		int rect = 1;
//		for (; rect < 500; rect <<= 1) {
//			count++;
//		}
//		System.out.println("접은 횟수: " + count + " 사각형 개수:" + rect);
		int count = 0;
		int rect = 1;
		
		while(rect < 500) {
			count += 1;
			rect <<= 1;

		}
		System.out.println("접은 횟수: " + count + " 사각형 개수:" + rect);
	}

}
