package BackJoon.Level9;

import java.util.Scanner;

/**
 * 소수 찾기
 *
 * 문제
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 *
 * 출력
 * 주어진 수들 중 소수의 개수를 출력한다.
 *
 * 예제 입력 1
 * 4
 * 1 3 5 7
 *
 * 예제 출력 1
 * 3
 *
 *
 */
public class SosuSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TestCase = sc.nextInt();
        int count = 0;

        for(int i = 0 ; i < TestCase ; i++) {
            int number = sc.nextInt();

            if(number > 1 && solution(number)) {
                count += 1;
            }
        }

        System.out.println(count);
    }

    private static boolean solution(int number) {
        int i = 2;
        boolean result = true;

        while(Math.sqrt(number) >= i) {
            if(number % i == 0) {
                return false;
            } else {
                i += 1;
            }
        }

        return result;
    }
}
