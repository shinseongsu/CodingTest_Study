package Programers;

/**
 * 위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다.
 * 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.
 *
 * 삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.
 *
 *triangle	                                                    result
 * [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	    30
 */
public class IntegerTriangle {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] accTriangle = new int[n][n];
        int max=0;

        accTriangle[0][0] = triangle[0][0];
        for(int i=1; i<n; i++){
            accTriangle[i][0] = accTriangle[i-1][0] + triangle[i][0];
            accTriangle[i][i] = accTriangle[i-1][i-1] + triangle[i][i];
        }

        for(int i=2; i<n; i++){
            for(int j=1; j<i; j++){
                accTriangle[i][j] = Math.max(accTriangle[i-1][j-1], accTriangle[i-1][j]) + triangle[i][j];
            }
        }

        for(int i=0; i<n; i++){
            if(max < accTriangle[n-1][i])
                max = accTriangle[n-1][i];
        }
        answer = max;
        return answer;
    }

}
