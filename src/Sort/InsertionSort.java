package Sort;

import java.util.Arrays;

/**
 * 삽입 정렬
 *
 * 선택정렬은 현재 데이터의 상태와 상관없이 무조건 모든 원소를 비교하고 위치를 바꾸는 반면 삽입 정렬은 그렇지 않다.
 * 삽입 정렬은 특정한 데이터를 적절하게 위치에 삽입한다는 의미에서 삽입정렬이라고 부른다.
 *
 * 삽입 정렬은 특정한 데이터가 적절한 위치에 들어가기 이전에, 그 앞까지의 데이터는 이미 정렬되어 있다고 가정한다.
 *
 * 삽입정렬도 복잡도가 O(N^2) 인데,
 * 정렬이 거의 되어 있는 경우, 최선의 경우 O(N)의 시간복잡도를 가진다.
 *
 */
public class InsertionSort {

    public static void main(String[] args) {

        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for(int i = 1; i < n ; i++) {
            for(int j = i ; j > 0 ; j--) {
                if(arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                else {
                    break;
                }
            }
        }

        Arrays.stream(arr).forEach(System.out::print);

    }
}
