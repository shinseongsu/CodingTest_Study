package Programers;

/**
 *
 * 아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.
 *
 * 12 = 5 + 5 + (5 / 5) + (5 / 5)
 * 12 = 55 / 5 + 5 / 5
 * 12 = (55 + 5) / 5
 *
 * 5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
 * 이처럼 숫자 N과 number가 주어질 때,
 * N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을
 * return 하도록 solution 함수를 작성하세요.
 *
 * N	number	return
 * 5	12	        4
 * 2	11	        3
 *
 */

public class NView {

    private static int N;
    private static int number;
    private static int answer = 9;

    public static void main(String[] args) {
        int N = 5;
        int number = 12;

        int result = solution(N, number);
        System.out.println(result);
    }

    public static int solution(int N, int number) {
        NView.N = N;
        NView.number = number;
        dfs(0, 0);
        if (answer == 9) answer = -1;
        return answer;
    }

    public static void dfs(int count, int prev) {
        if (count > 8) {
            answer = -1;
            return;
        }
        if (number == prev && answer > count) { //답과 같고 최소의 답인 경우
            answer = count;
            return;
        }
        int n2 = N;
        for (int i = 0; i < 8 - count; i++) { // 남은 최소 개수만큼  5, 55,555... 사칙연산 경우의 수 모두 탐색
            dfs(count + i + 1, prev + n2);
            dfs(count + i + 1, prev - n2);
            dfs(count + i + 1, prev * n2);
            dfs(count + i + 1, prev / n2);
            n2 += N * (Math.pow(10, i + 1)); //5, 55, 555, 5555..
        }
    }


}
