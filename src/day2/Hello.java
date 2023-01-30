package day2;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		int[] arr = new int[size];

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("=============================");
		for(int i:arr) {
			System.out.println(i);
		}
		
//		int [][]arr2 = new int[2][3];
//		
//		for(int i = 0; i<arr2.length;i++) {
//			for(int j = 0; j < arr2[i].length;j++) {
//				System.out.println(arr2[i][j]);
//			}
//		}
//		
//		int [][]arr3 = new int[2][];
//		
//		arr3[0] = new int[3];
//		arr3[1] = new int[2];
//		
//		for(int i = 0; i < arr3.length; i++) {
//			for(int j = 0; j < arr3[i].length; j++) {
//				System.out.println(arr3[i][j]);
//			}
//		}

	}

}
