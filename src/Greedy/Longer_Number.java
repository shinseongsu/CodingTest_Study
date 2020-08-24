package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
*
* 큰 수의 법칙
*
* '큰 수의 법칙'은 일반적으로 통계 분야에서 다루어지는 내용이지만 동빈이는 본인만의 방식으로
* 다르게 사용하고 있다. 동빈이의 큰 수의 법칙은 다양한 수로 이루어진 배열이 있을 때 주어진
* 수들을 M번 더하여 가장 큰 수를 만드는 법칙이다. 단, 배열의 특정한 인덱스(번호)에 해당하는
* 수가 연속해서 K번을 초과하여 더해질 수 없는 것이 이 법칙의 특징이다.
*
*
 */
public class Longer_Number {

    public static void main(String[] args) {

        int M = 8;
        int K = 3;
        Integer[] arr = { 2, 4, 5, 4, 6 };

        int result = solution(M, K, arr);

        System.out.println(result);
    }

    /*
    * solution
    *
    * @param int M  M번 더한다.
    * @param int K  연속적으로 K 번 까지 더할 수 있다.
    * @param int[] arr 더할 수 있는 값들을 넣은 배
    *
     */
    private static int solution(int M, int K, Integer[] arr) {

        int count = 0;

        Arrays.sort(arr, (o1, o2) -> Integer.compare(o2, o1));

        int first = arr[0];
        int second = arr[1];

        int sum_count = (M / (K+1)) * K;
        sum_count += M % (K+1);

        count += first * sum_count ;
        count += second * (M - sum_count);

        return count;
    }

}
