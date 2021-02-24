package Search;

import java.util.Scanner;

/**
 * 오늘 동빈이는 여행 가신 부모님을 대신하여 떡집 일을 하기로 했다.
 * 오늘은 떡뽂이 떡을 만드는 날이다.
 * 동빈이네 떡볶이 떡은 재밌게도 떡볶이 떡의 길이가 일정하지 않다.
 * 대신에 한 봉지 안에 들어가는 떡의 총 길이는 절단기로 잘라서 맞춰준다.
 *
 * 절단기에 높이를 지정하면 줄지어진 떡을 한 번에 절단한다. 높이가 H보다 긴 떡은 H위의 분이 잘릴 것이고, 낮은 떡은 잘리지 않다.
 *
 * 손님이 왔을 떄 요청한 총 길이가 M일 때 적어도 M만큼의 떡을 얻기 위해 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.
 *
 * 입력예시
 * 4 6
 * 19 15 10 17
 *
 * ==> 15
 *
 */
public class Tteokbokki {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = (int) 1e9;

        int result = 0;
        while(start <= end) {
            long total = 0;
            int mid = (start + end) / 2;
            for(int i = 0 ; i < n ; i++) {
                if(arr[i] > mid) total += arr[i] - mid;
            }

            if(total < m) end = mid -1;
            else {
                result = mid;
                start = mid+ 1;
            }
        }

        System.out.println(result);
    }
}
