package BackJoon.Level12;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 소트인사이드
 *
 * 문제
 * 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
 *
 * 입력
 * 첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 *
 * 예제 입력 1
 * 2143
 * 예제 출력 1
 * 4321
 *
 */
public class SortInSide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String number = sc.next();
        Integer[] SortArray = new Integer[number.length()];

        for(int i = 0 ; i < number.length() ; i++) {
            SortArray[i] = Integer.valueOf(number.charAt(i) - '0');
        }

        Arrays.sort(SortArray, Collections.reverseOrder());

        for(int value : SortArray) {
            System.out.print(value);
        }

    }
}
