package Sort;

/**
 * 계수 정렬
 *
 * 특정한 조건이 부합할 때만 사용할 수 있지만 매우 빠른 정렬 알고리즘이다.
 *
 * 시간복잡도
 * - 데이터 개수 N, 최대값 크기 - K
 * - O(N + K)
 * - 데이터범위만 한정되어 있다면 효과적으로 사용할 수 있으며, 항상 빠르다.
 *
 */
public class CountSort {

    public static final int MAX_VALUE = 9;

    public static void main(String[] args) {

        int n = 15;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        int[] cnt = new int[MAX_VALUE + 1];

        for(int i = 0 ; i < n ; i++) {
            cnt[arr[i]] += 1;
        }

        for(int i = 0 ; i <= MAX_VALUE ; i++) {
            for(int j = 0 ; j < cnt[i] ; j++) {
                System.out.print(i + " ");
            }
        }

    }
}
