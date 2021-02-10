package Programers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.
 *
 * 명령어	    수신 탑(높이)
 * I 숫자	큐에 주어진 숫자를 삽입합니다.
 * D 1	    큐에서 최댓값을 삭제합니다.
 * D -1	    큐에서 최솟값을 삭제합니다.
 *
 * 이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때,
 * 모든 연산을 처리한 후 큐가 비어있으면 [0,0]
 * 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
 *
 * 입출력 예
 * operations	        return
 * [I 16,D 1]	        [0,0]
 * [I 7,I 5,I -5,D -1]	[7,5]
 *
 */
public class DoublePriorQueue {
    public static void main(String[] args) {
//        String[] operations = { "I 16","D 1" };
//        String[] operations = { "I 7","I 5","I -5","D -1"};

        String[] operations = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

        int[] result = solution(operations);

        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> queueMax = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> queueMin = new PriorityQueue<>();

        for(String str : operations) {
            String[] arr = str.split(" ");
            if(arr[0].equals("I")) {
                int value = Integer.parseInt(arr[1]);
                queueMax.offer(value);
                queueMin.offer(value);
            } else {
                if(queueMax.isEmpty()) continue;

                if(arr[1].equals("1")) {            // 최댓값 삭제
                    int max = queueMax.peek();
                    queueMax.remove(max);
                    queueMin.remove(max);
                } else if(arr[1].equals("-1")){      // 최솟값 삭제
                    int min = queueMin.peek();
                    queueMax.remove(min);
                    queueMin.remove(min);
                }
            }
        }
        if(!queueMax.isEmpty()) {
            answer[0] = queueMax.peek();
            answer[1] = queueMin.peek();
        }

        return answer;
    }
}
