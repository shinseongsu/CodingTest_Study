package DFS;

import java.util.Scanner;

/**
 * 음료수 얼려 먹기
 *
 * N * M 크기의 얼음 틀이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
 * 구멍이 뚫려 있는 부분끼리 상, 하, 좌, 우로 붙여 있는 경우 서로 연결되어 있는 것으로 간주한다.
 * 이떄 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하시오.
 *
 * 0 0 1 1 0
 * 0 0 0 1 1
 * 1 1 1 1 1
 * 0 0 0 0 0
 *
 *
 */
public class FreezingDrinks {
    private static int[][] arr;     // 전체 틀
    private static int count = 0;   // 얼음 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // width
        int M = sc.nextInt();   // height

        arr = new int[N][M];

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(dfs(i, j)) count++;
            }
        }

        System.out.println(count);
    }

    private static boolean dfs(int i, int j) {
        if ( i <= -1 || i >= arr.length || j <= -1 || j >= arr[0].length || arr[i][j] == 1 ) {
            return false;
        }

        if(arr[i][j] == 0) {
            arr[i][j] = 1;

            dfs(i-1, j);
            dfs(i+1, j);
            dfs(i, j-1);
            dfs(i, j+1);
            return true;
        }
        return false;
    }

}
