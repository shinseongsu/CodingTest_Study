package Greedy;

/*
*
* 1이 될 때까지
*
* 어떤한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다.
* 단, 두번째 연산은 N이 K로 나누어 떨어질 때만 선택할 수 있다.
*
* 1. N에서 1을 뺀다.
* 2. N을 k로 나눈다.
*
*
 */
public class UntilOne {

    public static void main(String[] args) {

        int N = 25;
        int K = 5;

        int result = solution(N, K);

        System.out.println(result);
    }

    /*
    *
    *
    * @param int N 나눠야 할 값
    * @prram int K 나누는 값
    *
    * @return 1이되는 최솟 값
    *
     */

    private static int solution(int N, int K) {

        int count = 0;

        while(true) {
            if( N == 1 ) {
                break;
            }

            if(N % K == 0) {
                N = N / K;
                count = count + 1;
            } else {
                N = N - 1;
            }
        }

        return count;
    }

}
