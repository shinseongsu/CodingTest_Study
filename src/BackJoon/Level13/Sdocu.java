package BackJoon.Level13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 스도쿠
 *
 * 스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다. 이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데, 게임 시작 전 일부 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.
 *
 * 나머지 빈 칸을 채우는 방식은 다음과 같다.
 *
 * 1. 각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
 * 2. 굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
 * 위의 예의 경우, 첫째 줄에는 1을 제외한 나머지 2부터 9까지의 숫자들이 이미 나타나 있으므로 첫째 줄 빈칸에는 1이 들어가야 한다.
 *
 * 또한 위쪽 가운데 위치한 3x3 정사각형의 경우에는 3을 제외한 나머지 숫자들이 이미 쓰여있으므로 가운데 빈 칸에는 3이 들어가야 한다.
 *
 * 이와 같이 빈 칸을 차례로 채워 가면 다음과 같은 최종 결과를 얻을 수 있다.
 *
 * 게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 아홉 줄에 걸쳐 한 줄에 9개씩 게임 시작 전 스도쿠판 각 줄에 쓰여 있는 숫자가 한 칸씩 띄워서 차례로 주어진다. 스도쿠 판의 빈 칸의 경우에는 0이 주어진다. 스도쿠 판을 규칙대로 채울 수 없는 경우의 입력은 주어지지 않는다.
 *
 * 출력
 * 모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉 줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서 출력한다.
 *
 * 스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다.
 *
 * 제한
 * baekjoon의 백트래킹 알고리즘으로 풀 수 있는 입력만 주어진다. 다음은 그 알고리즘의 수행 시간이다.
 * C++14: 80ms
 * Java: 292ms
 * PyPy3: 1172ms
 * 예제 입력 1
 *
 * 0 3 5 4 6 9 2 7 8
 * 7 8 2 1 0 5 6 0 9
 * 0 6 0 2 7 8 1 3 5
 * 3 2 1 0 4 6 8 9 7
 * 8 0 4 9 1 3 5 0 6
 * 5 9 6 8 2 0 4 1 3
 * 9 1 7 6 5 2 0 8 0
 * 6 0 3 7 0 1 9 5 2
 * 2 5 8 3 9 4 7 6 0
 *
 * 예제 출력 1
 * 1 3 5 4 6 9 2 7 8
 * 7 8 2 1 3 5 6 4 9
 * 4 6 9 2 7 8 1 3 5
 * 3 2 1 5 4 6 8 9 7
 * 8 7 4 9 1 3 5 2 6
 * 5 9 6 8 2 7 4 1 3
 * 9 1 7 6 5 2 3 8 4
 * 6 4 3 7 8 1 9 5 2
 * 2 5 8 3 9 4 7 6 1
 *
 */

public class Sdocu {

    // 내가 푼 ( 틀림 )

    /*private static int[][] arr = new int[9][9];
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        for(int i = 0 ; i < arr.length ; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);

            for(int j = 0; j < arr[i].length ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


       for(int i = 0 ; i < arr.length ; i++) {
           for(int j = 0 ; j < arr[i].length ; j++) {
               if(arr[i][j] == 0) {
                   if (width(i, j)) {
                       if(height(i, j)){
                           threethree(i, j);
                       }
                   }
               }
           }
       }

        for(int i = 0 ; i < arr.length ; i++) {
            for(int j = 0 ; j < arr[i].length ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static boolean width(int x, int y) {
        int[] values = new int[10];
        int zeroindex = 0;

        for(int j = 0; j < arr[x].length ; j++) {
            values[arr[x][j]]++;

            if(arr[x][j] == 0) {
                zeroindex = j;

                if(values[0] == 2) {
                    return true;        // 다음 꺼로 넘어간다.
                }
            }
        }

        for(int j = 0 ; j < values.length ; j++) {
            if(values[j] == 0) {
                arr[x][zeroindex] = j;
                break;
            }
        }

        return false;
    }

    private static boolean height(int x, int y) {
        int[] values = new int[10];
        int zeroindex = 0;

        for(int i = 0 ; i < arr.length ; i++) {
            values[arr[i][y]]++;

            if(arr[i][y] == 0) {
                zeroindex = i;

                if(values[0] == 2) {
                    return true;        // 다음 꺼로 넘어간다.
                }
            }
        }

        for(int i = 0 ; i < values.length ; i++) {
            if(values[i] == 0) {
                arr[zeroindex][y] = i;
                break;
            }
        }

        return false;
    }

    private static void threethree(int i, int j) {
        int[] values = new int[10];

        for(int x = i/3 ; x < i/3 + 2 ; x++) {
            for(int y = j/3 ; y < j/3 + 2 ; y++) {

                values[arr[x][y]]++;

                if(arr[x][y] == 0) {

                    if(values[0] == 2) {
                        return;
                    }
                }
            }
        }

        for(int x = 1; x < values.length ; x++) {
            if(values[x] == 0) {
                arr[i][j] = x;
            }
        }

    }*/


    private static int[][] map;
    private static LinkedList<int[]> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new int[9][9];
        list = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) {
                    list.add(new int[] { i, j });
                }
            }
        }
        solve(0);
    }

    private static void solve(int depth) {
        if (depth == list.size()) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            sb.append("\n");

            System.out.println(sb);
            System.exit(0);
        }

        int r = list.get(depth)[0];
        int c = list.get(depth)[1];

        for (int i = 1; i <= 9; i++) {
            if (check(r, c, i)) {
                map[r][c] = i;
                solve(depth + 1);
                map[r][c] = 0;
            }
        }

    }

    private static boolean check(int r, int c, int num) {
        if (map[r][c] != 0)
            return false;

        for (int i = 0; i < 9; i++) {
            if (map[i][c] == num || map[r][i] == num) // 가로 세로
                return false;
        }
        int sr = (r / 3) * 3, sc = (c / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (map[i][j] == num)  // 3x3
                    return false;
            }
        }

        return true;
    }
}
