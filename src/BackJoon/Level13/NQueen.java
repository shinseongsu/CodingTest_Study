package BackJoon.Level13;

import java.util.Scanner;

/**
 * N-Queen
 *
 * 문제
 * N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
 *
 * N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N이 주어진다. (1 ≤ N < 15)
 *
 * 출력
 * 첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
 *
 * 예제 입력 1
 * 8
 * 예제 출력 1
 * 92
 *
 *
 */
public class NQueen {

    private static int n;
    private static int count;
    private static int[] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            map = new int[n + 1]; // 1행부터 고려하기 때문에 , map[0]은 사용하지 않음.

            map[1] = i; // 1행 i열에 퀸을 놓는다.

            dfs(map, 1);

        }
        System.out.println(count);

    }

    private static void dfs(int[] map, int col) {
        if (col == n) {
            count++;
        }

        else {
            for (int i = 1; i <= n; i++) {
                map[col + 1] = i; // 다음 행의 i열에 퀸을 배치 할 수 있는지 ?
                if (check(map, col + 1)) { // 이 위치에 퀸을 놓을 수 있다면
                    dfs(map, col + 1); // 다시 dfs로 다음 퀸을 놓으러 간다.

                }

            }
        }
    }

    private static boolean check(int[] map, int col) {
        for (int i = 1; i < col; i++) {
            if (map[i] == map[col])
                //같은 열이면 퀸을 배치할 수 없으므로 false
                return false;
            if (Math.abs(i - col) == Math.abs(map[i] - map[col]))
                return false;
            //서로 대각선에 위치하고 있으면 퀸을 배치할 수 없으므로 false
        }
        return true;

    }


}
