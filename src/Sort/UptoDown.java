package Sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * 하나의 수얄에는 다양한 수가 존재한다.
 * 이러한 수는 크기에 상관없이 나열되어 있다.
 *
 * 이수를 큰 수부터 작은 수의 순서로 정렬해야 한다.
 * 수열을 내림차순으로 정렬하는 프로그램을 만드시오.
 *
 */
public class UptoDown {

    public static void main(String[] args) {
        int n = 3;
        Integer[] arr = {15, 27, 12};

        Arrays.sort(arr , Collections.reverseOrder());

        Arrays.stream(arr).map(o -> o + " ").forEach(System.out::print);
    }

}
