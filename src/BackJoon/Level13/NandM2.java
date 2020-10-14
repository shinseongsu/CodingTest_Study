package BackJoon.Level13;

import java.util.Scanner;

/**
 * N과 M (2)
 *
 * 문제
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 고른 수열은 오름차순이어야 한다.
 * 입력
 * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 *
 * 출력
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 *
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 *
 *
 * 예제 입력 1
 * 3 1
 * 예제 출력 1
 * 1
 * 2
 * 3
 * 예제 입력 2
 * 4 2
 * 예제 출력 2
 * 1 2
 * 1 3
 * 1 4
 * 2 3
 * 2 4
 * 3 4
 * 예제 입력 3
 * 4 4
 * 예제 출력 3
 * 1 2 3 4
 *
 */
public class NandM2 {

    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 최대 수
        int M = sc.nextInt();   // 최대 길이

        arr = new int[M];

        dfs(N, 0, 0);
    }

    private static void dfs(int N, int length, int current) {
        if(arr.length == length ) {  // 길이가 같으면 리턴
            for(int value : arr) {
                System.out.print(value + " ");
            }
            System.out.println();
        } else {
            for(int i = current ; i < N ; i++) {
                arr[length] = i + 1;
                dfs(N, length+1, i+1);
            }

        }
    }

}
