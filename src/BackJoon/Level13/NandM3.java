package BackJoon.Level13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과 M (3)
 *
 * 문제
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 입력
 * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
 *
 * 출력
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 *
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 *
 * 예제 입력 1
 * 3 1
 * 예제 출력 1
 * 1
 * 2
 * 3
 *
 * 예제 입력 2
 * 4 2
 * 예제 출력 2
 * 1 1
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 2
 * 2 3
 * 2 4
 * 3 1
 * 3 2
 * 3 3
 * 3 4
 * 4 1
 * 4 2
 * 4 3
 * 4 4
 *
 * 예제 입력 3
 * 3 3
 * 예제 출력 3
 * 1 1 1
 * 1 1 2
 * 1 1 3
 * 1 2 1
 * 1 2 2
 * 1 2 3
 * 1 3 1
 * 1 3 2
 * 1 3 3
 * 2 1 1
 * 2 1 2
 * 2 1 3
 * 2 2 1
 * 2 2 2
 * 2 2 3
 * 2 3 1
 * 2 3 2
 * 2 3 3
 * 3 1 1
 * 3 1 2
 * 3 1 3
 * 3 2 1
 * 3 2 2
 * 3 2 3
 * 3 3 1
 * 3 3 2
 * 3 3 3
 *
 */
public class NandM3 {

    private static int[] arr;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N;

    public static void main(String[] args) throws Exception {

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken());   // 최대 수
        int M = Integer.parseInt(st.nextToken());   // 길이

        arr = new int[M];
        solution(0);

        System.out.println(sb.toString());
    }

    private static void solution(int length) {

        if(length == arr.length ) {
            for(int value : arr) {
                sb.append(value + " ");
            }
            sb.append("\n");
        } else {
            for(int i = 1 ; i <= N ; i++) {
                arr[length] = i;
                solution(length + 1);
            }
        }
    }

}
