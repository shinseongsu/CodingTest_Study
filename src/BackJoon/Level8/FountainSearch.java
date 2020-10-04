package BackJoon.Level8;

import java.util.Scanner;

/**
 * 분수찾기
 *
 * 무한히 큰 배열에 다음과 같이 분수들이 적혀있다.
 *
 * 1/1	1/2	1/3	1/4	1/5	1/7
 * 2/1	2/2	2/3	2/4	2/6	…
 * 3/1	3/2	3/3	3/4	…	…
 * 4/1	4/2 4/3	…	…	…
 * 5/1	5/2	…	…	…	…
 * 6/1	…	…	…	…	…
 * 이와 같이 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
 *
 * X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
 *
 * 출력
 * 첫째 줄에 분수를 출력한다.
 *
 *
 * 예제 입력 1
 * 14
 * 예제 출력 1
 * 2/4
 *
 */
public class FountainSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int bottom = 0;
        int top = 0;
        String result = "";

        int line = 0;
        int cnt = 0;
        while(cnt < target) {
            line++;
            cnt = line * (line+1) / 2;
        }

        if(line % 2 != 0) {
            top = 1 + (cnt - target);
            bottom = line - (cnt - target);
            result = top + "/" + bottom;
        } else {
            top = line - (cnt - target);
            bottom = 1 + (cnt - target);
            result = top + "/" + bottom;
        }

        System.out.println(result);
    }
}
