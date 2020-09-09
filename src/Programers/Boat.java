package Programers;

import java.util.Arrays;

/*
*
* 무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다.
* 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
*
* 예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의
* 무게 제한이 100kg이라면 2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로
* 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.
*
* 구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
*
* 사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때,
* 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
*
*
* people	       limit	return
 [70, 50, 80, 50]	100	       3
  [70, 80, 50]	    100	       3
*
 */
public class Boat {

    public static void main(String[] args) {
        int[] people = { 70, 50, 80, 50 };
        int limit = 100;

        int result = solution(people, limit);

        System.out.println(result);
    }

    /*
    *
    * 풀이법 : 최댓값과 최솟값을 더해서 보트에 넣을 수 있으면 제일 좋은 결과
    *         안될경우 제일 무거운거를 넣고 그 다음 무거운 거와 가벼운거를 합쳐 보트 무게에 넣어봄
    *
    * @param int[] people 사람들 무게를 알려주는 배열
    * @param int limit    보트 최대 무게
    *
    * @return 필요한 보트 개수
    *
     */
    private static int solution(int[] people, int limit) {
        int first = 0;                  // 첫번째 값
        int second = people.length -1;  // 두번째 값
        int answer = 0;                 // 구멍보트 개수

        Arrays.sort(people);

        while(true) {

            if(first > second) {   // first 가 인덱스보다 커지면 스탑
                break;
            }

            if(people[first] + people[second] <= limit) {    // 최대 무게 사람과 최저 사람이 같이 못 탈때
                first++;
                second--;
            } else {
                second--;
            }

            answer++;
        }

        return answer;
    }

}
