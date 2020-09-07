package Programers;

import java.util.Arrays;

/*
*
* 체육복
*
* 점심시간에 도둑이 들어, 일부 학생이 체육복이 도난당했습니다.
* 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
*
* 학생들의 번호는 체격순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄수 있습니다.
*
* 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
* 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
*
*
* 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
* 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질때, 체육복을 들을 수 있는 학생의 최댓값을 return 하도록 함수를 작성해주세요.
*
*
*   n   lost      reserve      return
*
*   5   [2, 4]   [1, 3, 5]       5
*   5   [2, 4]    [ 3 ]          4
*   3   [3]       [ 1 ]          2
*
*   n = 5, lost = [1, 2], reserve[2, 3] 일 때, 4
*
 */
public class GymSuit {

    public static void main(String[] args) {

        int n = 5;  // 사람 수
        int[] lost = {1, 2};    // 잃은 사람 번호
        int[] reserve = {2, 3};  // 여부을 가지고 있는 사람 번호

        int result = solution(n, lost, reserve);

        System.out.println(result);

    }

    private static int solution(int n, int[] lost, int[] reserve) {

        int answer = n - lost.length;   // 기본값 전체 사람 - 잃어버린 사람

        for(int i = 0 ; i <lost.length ; i++) {
            for(int j = 0 ; j < reserve.length ; j++) {
                if(lost[i] == reserve[j]) {
                    answer++;
                    reserve[j] = -1;
                    lost[i] = -1;
                    break;
                }
            }
        }

        for(int i = 0 ; i < lost.length ; i++) {
           int lost_value = lost[i];    // 체육복을 읽어 벌인 사람

            if(lost_value < 0 ) {
                continue;
            }

           for(int j = 0 ; j < reserve.length ; j++) {

               int reserve_value = reserve[j];  // 기준이 되는 값

               if(reserve_value < 0) {  // -1 이면 다음 껄로 넘어감
                   continue;
               }

               if(lost_value == reserve_value + 1 || lost_value == reserve_value - 1) {
                   answer = answer + 1;
                   reserve[j] = -1;
                   break;
               }

           }

        }
        return answer;
    }


    /*
    *
    *   다른 분이 푼 방법
    *
    *    추가된 테스트 코드에서 에러
    *
     */
    private static int solution1(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer = n;

        for(int i = 0; i < lost.length; i++) {
            boolean rent = false;
            int j = 0;
            while(!rent) {
                if(j == reserve.length)                   break;
                if(lost[i] == reserve[j])                {reserve[j] = -1; rent=true;}
                else if(lost[i] - reserve[j] == 1 )      {reserve[j] = -1; rent=true;}
                else if(lost[i] - reserve[j] == -1)      {reserve[j] = -1; rent=true;}
                else                                     {j++;                      }
            }
            if(!rent) answer--;
        }
        return answer;
    }

    /*
    *
    * 다른 사람이 푼 방식
    *
    *
     */
    private static int solution2(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost)
            people[l-1]--;
        for (int r : reserve)
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else
                    answer--;
            }
        }
        return answer;
    }

}
