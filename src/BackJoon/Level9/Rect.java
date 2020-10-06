package BackJoon.Level9;

import java.util.Scanner;

/**
 * 직사각형에서 탈출
 *
 * 문제
 * 한수는 지금 (x, y)에 있다. 직사각형의 왼쪽 아래 꼭짓점은 (0, 0)에 있고,
 * 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 x y w h가 주어진다. w와 h는 1,000보다 작거나 같은 자연수이고,
 * x는 1보다 크거나 같고, w-1보다 작거나 같은 자연수이고, y는 1보다 크거나 같고, h-1보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄에 문제의 정답을 출력한다.
 *
 * 예제 입력 1
 * 6 2 10 3
 * 예제 출력 1
 * 1
 *
 *
 * (10,3)         (10, 3)
 *          (6,2)
 *
 * (0,0)          (10, 0)
 *
 *
 */
public class Rect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();   // 최대 가로 길이
        int h = sc.nextInt();   // 최대 세로 길이

        int MinWidth = Math.min(w-x, x-0);
        int MinHeight = Math.min(h-y, y-0);

        int result = Math.min(MinWidth, MinHeight);

        System.out.println(result);
    }
}
