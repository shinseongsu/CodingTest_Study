package Programers;

import java.util.Arrays;

/**
 * 출발지점부터 distance만큼 떨어진 곳에 도착지점이 있습니다.
 * 그리고 그사이에는 바위들이 놓여있습니다. 바위 중 몇 개를 제거하려고 합니다.
 *
 * 예를 들어, 도착지점이 25만큼 떨어져 있고,
 * 바위가 [2, 14, 11, 21, 17] 지점에 놓여있을 때 바위 2개를 제거하면 출발지점, 도착지점, 바위 간의 거리가 아래와 같습니다.
 *
 * 제거한 바위의 위치	각 바위 사이의 거리	거리의 최솟값
 * [21, 17]	        [2, 9, 3, 11]	    2
 * [2, 21]	        [11, 3, 3, 8]	    3
 * [2, 11]	        [14, 3, 4, 4]	    3
 * [11, 21]	        [2, 12, 3, 8]	    2
 * [2, 14]	        [11, 6, 4, 4]	    4
 *
 * 위에서 구한 거리의 최솟값 중에 가장 큰 값은 4입니다.
 *
 * 출발지점부터 도착지점까지의 거리 distance, 바위들이 있는 위치를 담은 배열 rocks,
 * 제거할 바위의 수 n이 매개변수로 주어질 때, 바위를 n개 제거한 뒤 각 지점 사이의 거리의 최솟값 중에 가장 큰 값을 return 하도록 solution 함수를 작성해주세요.
 *
 * distance	         rocks	             n	    return
 * 25	        [2, 14, 11, 21, 17]	     2	    4
 *
 */
public class River {

    public static void main(String[] args) {

    }

    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        return binerySearch(distance, rocks, n);
    }

    public static int binerySearch(int distance, int[] rocks, int n) {
        long ans = 0;
        long left = 1, right = distance, mid = 0;

        while(left <= right) {
            int cnt = 0;
            int prev = 0;
            mid = (left + right) / 2;

            for(int i = 0 ; i < rocks.length ; i++) {
                if(rocks[i] - prev < mid) {
                    cnt++;
                } else {
                    prev = rocks[i];
                }
            }

            if(distance - prev < mid) cnt++;

            if(cnt <= n) {
                ans = mid > ans ? mid : ans;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) ans;
    }

}
