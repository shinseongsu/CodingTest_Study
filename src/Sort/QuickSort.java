package Sort;

/**
 *  퀵 정렬
 *
 *  퀵 정렬에서는 특정한 리스트에서 피벗을 설정하여 정렬을 수행한 이후에, 피벗을 기준으로 왼쪽 리스트와 오른쪽 리스트에서 각각 다시 정렬을 수행한다.
 *
 *  시간 복잡도
 *
 *  - 평균 O(N log N)이다.
 *  - 최악의 경우 O(N^2)이다. ( 리스트의 가장 왼쪽 데이터를 피벗을 삼을 때, '이미 데이터가 정렬되어 있는 경우' 매우 느리게 동작한다.
 *
 */
public class QuickSort {

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        solution(arr, 0, n-1);

        for(int i = 0; i < n ; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void solution(int[] arr, int start, int end) {
        if(start >= end) return;

        int pivot = start;
        int left = start +1;
        int right = end;

        while(left <= right) {
            while(left <= end && arr[left] <= arr[pivot]) left++;
            while(right > start && arr[right] >= arr[pivot]) right--;

            if(left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        solution(arr, start, right - 1);
        solution(arr, right + 1, end);
    }

}
