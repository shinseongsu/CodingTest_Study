package BackJoon.Level9;

import java.util.Scanner;

/**
 * 네 번째 점
 *
 * 문제
 * 세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
 *
 * 입력
 * 세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.
 *
 * 출력
 * 직사각형의 네 번째 점의 좌표를 출력한다.
 *
 * 예제 입력 1
 * 30 20
 * 10 10
 * 10 20
 *
 * 예제 출력 1
 * 30 10
 *
 */
public class CETVRTA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        int x4 = 0;
        int y4 = 0;

        if(x1 == x2) {
            x4 = x3;
        } else {
            if(x2 == x3) {
                x4 = x1;
            } else {
                x4 = x2;
            }
        }

        if(y1 == y2) {
            y4 = y3;
        } else {
            if(y2 == y3) {
                y4 = y1;
            } else {
                y4 = y2;
            }
        }

        System.out.println(x4);
        System.out.println(y4);
    }
}
