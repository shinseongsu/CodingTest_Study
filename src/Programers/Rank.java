package Programers;


import java.util.ArrayList;
import java.util.List;

/**
 * n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다. 권투 경기는 1대1 방식으로 진행이 되고,
 * 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다. 심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다.
 * 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.
 *
 * 선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때 정확하게 순위를 매길 수 있는 선수의 수를
 * return 하도록 solution 함수를 작성해주세요.
 *
 *
 * n	results                                 	return
 * 5	[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]	2
 *
 */
public class Rank {

    public static void main(String[] args) {
        int n = 5;
        int[][] result = {{4,3}, {4,2}, {3,2}, {1,2}, {2,5}};

        System.out.println(solution(n, result));
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        int maxValues = 1000000;
        int[][] FW = new int[n+1][n+1];
        for(int i = 1; i <= n ; i++) {
            for(int j = 1; j <= n ; j++) {
                FW[i][j] = maxValues;
            }
        }

        for(int[] e : results) {
            FW[e[0]][e[1]] = 1;
        }

        for(int k = 1; k <= n ; k++) {
            for(int i = 1; i <= n ; i++) {
                for(int j = 1; j <= n; j++) {
                    if(FW[i][j] > FW[i][k] + FW[k][j]) FW[i][j] = FW[i][k] + FW[k][j];
                }
            }
        }

        for(int i = 1; i <= n; i++){
            boolean flag = true;
            for(int j = 1; j <=n; j++) {
                if(i == j) continue;
                if(FW[i][j] == maxValues && FW[j][i] == maxValues) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }

}
