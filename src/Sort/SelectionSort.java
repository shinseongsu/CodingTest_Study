package Sort;

/**
 * 선택 정렬
 *
 * 데이터가 무작위로 여러 개 있을 때, 이 중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고,
 * 그 다음 작은 데이터를 선택해 앞에서 두 번째 데이터와 바꾸는 과정을 반복하면 어떻까?
 *
 * 가장 원시적인 방법으로 매번 '가장 작은 것을 선택한다.'
 *
 *  시간 복잡도 O(N^2)
 *  - 이중 for문이 적용되어있다.
 *  - 10,000개 이상이면 정렬 속도가 급격히 느려진다.
 *
 */
public class SelectionSort {

    public static void main(String[] args) {

        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for(int i = 0 ; i < n ; i++) {
            int min_index = i;
            for (int j = i+1 ; j < n ; j++) {
                if (arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }

            // 스와프
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        for(int i = 0 ; i < n ; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
