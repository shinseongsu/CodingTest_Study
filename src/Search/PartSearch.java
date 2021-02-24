package Search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 부품 찾기
 *
 * 동빈이네 전자 매장에는 부품이 N개 있다.
 * 각 부품은 정수 형태의 고유한 번호가 있다.
 * 어느 날 손님이 M개 종류의 부품을 대량으로 구매하겟다며 당일날 견적서를 요청했다.
 * 이때 가게 안에 부품이 모두 있는지 확인하는 프로그램을 작성해보자
 *
 * 입력 예시
 * 5
 * 8 3 7 9 2
 * 3
 * 5 7 9
 *
 */
public class PartSearch {

    public static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] == target) return mid;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int m = sc.nextInt();
        int[] targets = new int[m];
        for(int i = 0 ; i < m ; i++) {
            targets[i] = sc.nextInt();
        }

        for(int i = 0 ; i < m ; i++) {
            int result = binarySearch(arr, targets[i], 0, n-1);
            if(result != -1) {
                System.out.println("yes ");
            } else {
                System.out.println("no ");
            }
        }
    }

}
