package BackJoon.Level9;

import java.util.Scanner;

/**
 * 소수 구하기
 *
 * 문제
 * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
 *
 * 출력
 * 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 *
 * 예제 입력 1
 * 3 16
 * 예제 출력 1
 * 3
 * 5
 * 7
 * 11
 * 13
 */
public class Sosu2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        StringBuffer sb = new StringBuffer();

        for(int i = M ; i <= N ; i++) {

            if(solution(i) && i > 1) {
                sb.append(i + " ");
            }
        }

        String[] result = sb.toString().split(" ");

        for(int i = 0 ; i < result.length ; i++) {
            System.out.println(result[i]);
        }
    }

    private static boolean solution(int number) {
        boolean isPrime = true;
        int i = 2;

        while(Math.sqrt(number) >= i) {
            if(number % i == 0) {
                return false;
            } else {
                i++;
            }
        }

        return isPrime;
    }
}
