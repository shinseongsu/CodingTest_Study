package Sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * 동빈이는 두 개의 배열 A와 B를 가지고 있다.
 * 두 배열은 N개의 원소로 구성되어 있으며, 배열의 원소는 모두 자연수이다.
 *
 * 동빈이는 최대 K번의 바꿔치기 연산을 수행할 수 있는데, 바꿔치기 연산이란 배열 A에 있는 원소 하나와 배열 B에 있는 원소 하나를 골라서 두 원소를 서로 바꾸는 것을 말한다.
 * 동빈이는 최종 목표는 배열 A의 모든 원소의 합이 최대가 되도록 하는 것이며, 여러분은 동빈이를 도와줘야 한다.
 *
 * N, K 그리고 배열 A와 B의 정보가 주어졌을때, 최대 K번의 바꿔치기 연산을 수행하여 만들 수 있는 배열 A의 모든 원소의 합의 최댓값을 출력하는 프로그램을 작성하시오.
 *
 */
public class TwoArray {

    public static void main(String[] args) {
        int n = 5;
        int k = 3;

        Integer[] a = {1, 2, 5, 4, 3};
        Integer[] b = {5, 5, 6, 6, 5};

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for(int i = 0 ; i < k ; i++) {
            if(a[i] < b[i]) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            } else {
                break;
            }
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += a[i];
        }
        System.out.println(result);

    }

}
