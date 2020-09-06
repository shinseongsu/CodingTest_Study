package Greedy;

import java.util.Arrays;

/*
*
* 숫자 카드 게임
*
* 숫자 카드 게임은 여러 개의 숫자 카드 중에서 가장 높은 숫자가 쓰인 카드 한 장을 뽑는 게임이다.
* 단, 게임의 룰을 지키며 카드를 뽑아야 하고, 룰은 다음과 같다.
*
* 1. 숫자가 쓰인 카드들이 N X M 형태로 놓여 있다. 이때 N은 행의 개수를 의미하며, M은 열의 개수를 의미한다.
* 2. 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.
* 3. 그 다음 선택된 행에 포함된 카드들 중 가장 숫자가 낮은 카드를 뽑아야 한다.
* 4. 따라서 처음에 카드를 골라낼 행을 선택할때, 이후에 해당 행에서 가장 숫자가 낮은 카드를 뽑을 것을 고려하여 최종적으로 가장 높은 숫자의
*    카드를 뽑을 수 있도록 전략을 세워야 한다.
*
 */
public class CardGame {

    public static void main(String[] args) {
        int N = 3;
        int M = 3;

        int[][] arr = {
                { 3, 1, 2},
                { 4, 1, 4},
                { 2, 2, 2}
        };

        int result = solution(N, M, arr);

        System.out.println(result);
    }


    /*
    *
    * @param int N 행
    * @param int M 열
    * @param int[][] arr board 에 넣을 값
    *
    * @return 최솟값 구한 값
    *
     */
    private static int solution(int N, int M, int[][] arr) {

        int[][] board = new int[N][M];
        int max_value = 0;

        // 값 넣는 작업
        for(int i = 0 ; i < N; i++) {
            for(int j = 0; j < M; j++) {
                board[i][j] = arr[i][j];
            }
        }

        // 행마다 최소값 구해서 그중 최댓값 리턴하기
        for (int i = 0 ; i < N ; i++) {
            int[] board_arr = board[i];
            Arrays.sort(board_arr);

            max_value = Math.max(max_value, board_arr[0]);
        }

        return max_value;
    }

}


