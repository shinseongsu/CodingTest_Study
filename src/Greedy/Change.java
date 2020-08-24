package Greedy;

/*
*
*   거스름돈
*
*   당신은 음식점의 계산을 도와주는 점원입니다. 카운터에는 거스름돈으로 사용할 500원, 100원,
*   50원, 10원 짜리 동전이 무한히 존재한다고 가정한다. 손님에게 거슬러 줘야 할 돈이 N원일때 거슬러
*   줘야 할 동전의 최소 개수를 구하라.
*   단, 거슬러 줘야 할 돈 N은 항상 10의 배수이다.
*
 */

public class Change {

    public static void main(String[] args) {

        int price = 1260;
        int result = solution(price);

        System.out.println(result);

    }

    /*
    * solution
    *
    * 화폐의 종류 만큼 반복문을 돌려 나눈 몫은 동전의 개수에 더해지고
    * 나머지는 가격에 다시 넣어 다음 화폐 종류에 넣어 준다.
    *
    * @param price 거슬러줘야 할 돈
    *
     */
    private static int solution(int price) {

        int[] change_list = {500, 100, 50, 10};
        int count = 0;

        for(int i = 0 ; i < change_list.length ; i++) {
            count += price / change_list[i];
            price = price % change_list[i];
        }

        return count;
    }

}
