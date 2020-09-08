package Programers;

/*
*
* 큰 수 만들기
*
* 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
*
* 예를 들어, 숫자 1924에서 수 두 개를 제거하면
* [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다.
* 이 중 가장 큰 숫자는 94 입니다.
*
* 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
* number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
*
* number	k	return
*    1924	2	94
*  1231234	3	3234
*4177252841	4	775841
*
 */

import java.util.Arrays;

public class BigNumberMake {


    public static void main(String[] args) {

        String number = "4177252841";
        int k = 4;

        String result = solution(number, k);

        System.out.println(result);
    }

    private static String solution(String number, int k) {
        int idx = 0;
        char max;
        StringBuilder answer = new StringBuilder();

        if(number.charAt(0) == '0') return "0"; // 맨앞이 0 이면 0 리턴
        for(int i = 0; i < number.length() - k; i++) {
            max = '0';
            for(int j = idx; j <= k + i; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j + 1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }



}
