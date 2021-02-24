package Programers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 가장 먼 노드
 *
 * n개의 노드가 있는 그래프가 있습니다.
 * 각 노드는 1부터 n까지 번호가 적혀있습니다.
 * 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다.
 * 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.
 *
 * 노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때,
 * 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.
 *
 * n	vertex	                                                    return
 * 6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3
 *
 */
public class LongerNode {

    public static void main(String[] args) {
        int n = 6;
        int[][] vertext = { {3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};

        System.out.println(solution(n, vertext));
    }

    public static int solution(int n, int[][] vertex) {
        int answer = 0;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < vertex.length ; i++) {
            list.add(new ArrayList<Integer>());
        }

        // 노드 연결
        int a, b;
        for(int[] node: vertex) {
            a = node[0];
            b = node[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int[] count = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        visited[0] = visited[1] = true;
        int now;

        while(!q.isEmpty()) {
            now = q.poll();
            for(int v : list.get(now)) {
                if(!visited[v]) {
                    count[v] = count[now] + 1;
                    visited[v] = true;
                    q.add(v);
                }
            }
        }

        int max = 0;
        for(int cnt : count) {
            if(max < cnt) {
                max = cnt;
                answer = 1;
            } else {
                if(max == cnt) answer++;
            }
        }

        return answer;
    }
}
