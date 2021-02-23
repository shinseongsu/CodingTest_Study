package Programers;

/**
 * 도둑이 어느 마을을 털 계획을 하고 있습니다.
 * 이 마을의 모든 집들은 아래 그림과 같이 동그랗게 배치되어 있습니다.
 *
 * 각 집들은 서로 인접한 집들과 방범장치가 연결되어 있기 때문에 인접한 두 집을 털면 경보가 울립니다.
 *
 * 각 집에 있는 돈이 담긴 배열 money가 주어질 때,
 * 도둑이 훔칠 수 있는 돈의 최댓값을 return 하도록 solution 함수를 작성하세요.
 *
 *   money	        return
 * [1, 2, 3, 1]	       4
 *
 */
public class Still {

    public static void main(String[] args) {

        int[] money = {1, 2, 3, 1};
        System.out.println(solution(money));
    }

    public static int solution(int[] money) {
        int answer = 0;
        int length = money.length;
        int[] dp = new int[length - 1];
        int[] dp2 = new int[length];

        dp[0] = money[0];
        dp[1] = money[0];
        dp2[0] = 0;
        dp2[1] = money[1];
        for (int i = 2; i < length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
        }
        for (int i = 2; i < length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
        }

        return Math.max(dp[length - 2], dp2[length - 1]);
    }


}
