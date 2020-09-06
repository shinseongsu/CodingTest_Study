package Implementation;

/*
*
* 정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초 까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하시오.
* 예를 들어 1을 입력했을 때 다음은 3이 하나라도 포함되어 있으므로 세어야 하는 시각이다.
*
* - 00시 00분 03초
* - 00시 13분 30초
*
* 반면에 다음은 3이 하나라도 포함되어 있지 않으므로 세면 안 되는 시각이다.
*
* - 00시 02분 55초
* - 01시 27분 45초
*
*
 */
public class Times {

    public static void main(String[] args) {

        int N = 5;

        int result = solution(N);

        System.out.println(result);
    }

    private static int solution(int N) {

        int count = 0;

        for(int i = 0 ; i <= N ; i++) { // 시

            if(i/10 == 3 || i % 10 == 3) {
                count += 60 * 60;
               continue;
            }

            for(int j = 0 ; j < 60 ; j++) { // 분

                if(j/ 10 == 3 || j%10 == 3) {
                    count += 60;
                    continue;
                }

                for(int z = 0 ; z < 60 ; z++) {  // 초
                    if(z / 10 == 3 || z % 10 == 3) {
                        count += 1;
                    }
                }
            }

        }

        return count;
    }
}
