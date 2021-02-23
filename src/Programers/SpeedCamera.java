package Programers;

import java.util.Arrays;

/**
 * 고속도로를 이동하는 모든 차량이 고속도로를 이용하면서 단속용 카메라를 한 번은 만나도록 카메라를 설치하려고 합니다.
 *
 * 고속도로를 이동하는 차량의 경로 routes가 매개변수로 주어질 때,
 * 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면
 * 최소 몇 대의 카메라를 설치해야 하는지를 return 하도록 solution 함수를 완성하세요.
 *
 * routes	                                return
 * [[-20,15], [-14,-5], [-18,-13], [-5,-3]]	    2
 *
 */
public class SpeedCamera {
    public static void main(String[] args) {
        int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
        int result = solution(routes);
        System.out.println(result);
    }

    public static int solution(int[][] routes) {
        int answer = 0;
        int camera = -30001;

        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]) );

        for(int[] route : routes) {
            if(camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }

        return answer;
    }

}
