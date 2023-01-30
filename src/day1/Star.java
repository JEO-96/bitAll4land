package day1;

import java.util.Scanner;
import java.lang.Math;
public class Star {

    static void chooseCase() {
        char check = 'y';
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("출력할 별의 종류를 고르시오 (1~6): ");
            int starCase = sc.nextInt();
            switch (starCase) {
                case 1:
                    star1();
                    break;
                case 2:
                    star2();
                    break;
                case 3:
                    star3();
                    break;
                case 4:
                    star4();
                    break;
                case 5:
                    star5();
                    break;
                case 6:
                    star6();
                    break;
                default:
                    System.out.println("1에서 6 사이의 숫자를 입력하지 않았습니다.");
            }

            System.out.print("계속 하시겠습니까? y or n: ");
            check = sc.next().charAt(0);
        } while (check == 'y');
    }

    static void star1() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    static void star2() {
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    static void star3() {
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4 - i; j++) {
                System.out.print(' ');
            }
            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    static void star4() {
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3 - i; j++) {
                System.out.print(' ');
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print('*');
            }

            System.out.println();
        }
    }

    static void star5() {
        for (int i = 0; i < 5; i++) {
            if (i <= 5 / 2) {
                for (int j = 1; j < 3 - i; j++) {
                    System.out.print(' ');
                }
                for (int j = 0; j < i * 2 + 1; j++) {
                    System.out.print('*');
                }
            } else {
                for (int j = 1; j < i - 1; j++) {
                    System.out.print(' ');
                }
                for (int j = 0; j < 9 - i * 2; j++) {
                    System.out.print('*');
                }
            }
            System.out.println();
        }
    }

    static void star6() {
        Scanner sc = new Scanner(System.in);
        System.out.println("반복할 수를 입력하시오:");
        int input = sc.nextInt();
        int col = 0;
        int low = 0;
        for (int i = 0; i < input * input; i++) {
            col = i % input;
            if (low <= input / 2) {
                if ((input - 1) / 2 - low <= col && col < input / 2 + low + 1) {
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
            } else {
                if (-(input / 2 - low) - 1 < col && col < input - low + input / 2) {
                    System.out.print('*');

                } else {
                    System.out.print(' ');
                }
            }


            if (i % input == input - 1) { // 열 끝에 도달하면 줄바꾸기
                low++;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        chooseCase();

    }
}
