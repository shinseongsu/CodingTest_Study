package BackJoon.Level10;

import java.util.Scanner;

/**
 * 팩토리얼
 *
 * 문제
 * 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.
 *
 * 출력
 * 첫째 줄에 N!을 출력한다.
 *
 * 예제 입력 1
 * 10
 * 예제 출력 1
 * 3628800
 *
 */
public class factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        int result = solution(input);

        System.out.println(result);
    }

    private static int solution(int number) {
        if(number <= 1) {
            return 1;
        } else {
            return number * solution(number-1);
        }
    }
}
