package DynamicProgram;

/**
 * 피보나치 수열
 *
 * 재귀함수를 더하는 식으로 계산
 *
 */
public class FibonacciFuction {

    public static int fibo(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        return fibo(x - 1) + fibo( x - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibo(4));
    }
}
