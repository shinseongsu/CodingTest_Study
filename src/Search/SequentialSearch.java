package Search;

import java.util.Scanner;

/**
 * 순차 탐색
 *
 * 리스트 안에 특정한 데이터를 찾기 위해 앞에서부터 데이터를 하나씩 차례대로 확인하는 방법이다.
 * 보통 정렬되지 않은 리스트에서 데이터를 찾아야할때 사용한다.
 * 리스트 내에 데이터가 아무리 많아도 시간만 충분한다면 항상 원하는 데이터를 찾을 수 있는 장점이 있다.
 *
 */
public class SequentialSearch {

    public static void main(String[] args) {
        String[] arr = {"Haneul", "Jonggu", "Dongbin", "Taeil", "Sangwook"};
        System.out.println(sequantialSearch(arr.length, "Dongbin", arr));
    }

    // 순차탐색
    public static int sequantialSearch(int n, String target, String[] arr) {
        for(int i = 0 ; i < n ; i++) {
            System.out.println(arr[i]);
            if(arr[i].equals(target)) {
                return i + 1;
            }
        }
        return -1;
    }


}
